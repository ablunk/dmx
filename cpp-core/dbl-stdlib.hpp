#include <iostream>
#include <iterator>
#include <algorithm>
#include <vector>
#include <boost/intrusive_ptr.hpp>
#include <boost/smart_ptr/intrusive_ref_counter.hpp>
#include <cstdint>

class String;

class Object : public boost::intrusive_ref_counter<Object, boost::thread_unsafe_counter> {
public:
    Object() {}
    virtual ~Object() {}

    virtual boost::intrusive_ptr<String> toString() const;

    virtual bool equals(boost::intrusive_ptr<Object> other) const {
        return this == other.get();
    }

    virtual int hashCode() const {
        return reinterpret_cast<uintptr_t>(this);
    }
};


class String : public Object {
private:
    std::string value;

public:
    String(std::string value) : value(value) {}

    std::string getValue() const {
        return value;
    }
};

boost::intrusive_ptr<String> Object::toString() const {
    std::string address = std::to_string(reinterpret_cast<uintptr_t>(this));
    std::string typeName = typeid(this).name();
    return new String(typeName + "/" + address);
}

template<typename T>
std::ostream& operator<< (std::ostream& stream, const boost::intrusive_ptr<T>& object) {
    stream << object->toString()->getValue().c_str();
    return stream;
}

class Iterator : public Object {
public:
    virtual bool hasNext() = 0;
    virtual boost::intrusive_ptr<Object> getNext() = 0 ;
    virtual void remove() = 0 ;
};

class List : public Object {
public:
    virtual void add(boost::intrusive_ptr<Object> object) = 0;
    virtual boost::intrusive_ptr<Object> get(int i) = 0;
    virtual int size() = 0;
    virtual boost::intrusive_ptr<Iterator> iterator() = 0;
};

class ArrayListIterator : public Iterator {
private:
    std::vector<boost::intrusive_ptr<Object> >::iterator iterator;
    std::vector<boost::intrusive_ptr<Object> >& vector;
public:
    ArrayListIterator(std::vector<boost::intrusive_ptr<Object> >& vector) : iterator(vector.begin()), vector(vector) {}

    virtual bool hasNext() {
        return iterator != vector.end();
    }

    virtual boost::intrusive_ptr<Object> getNext() {
        boost::intrusive_ptr<Object> current = *iterator;
        iterator++;
        return current;
    }

    virtual void remove() {
        iterator = vector.erase(iterator);
    }
};

class ArrayList : public List {
private:
    std::vector<boost::intrusive_ptr<Object> > vector;

public:
    void add(boost::intrusive_ptr<Object> object) {
        vector.push_back(object);
    }

    boost::intrusive_ptr<Object> get(int i) {
        return vector[i];
    }

    int size() {
        return vector.size();
    }

    virtual boost::intrusive_ptr<Iterator> iterator() {
        return new ArrayListIterator(vector);
    }
};
