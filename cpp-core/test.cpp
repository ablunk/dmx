#include <iostream>
#include <iterator>
#include <algorithm>
#include <vector>
#include <boost/intrusive_ptr.hpp>

struct Object {
    Object() : count(0) {}
    virtual ~Object() {}

    size_t ref_count() {
        return count;
    }

    long count;
};

void intrusive_ptr_add_ref(Object* obj) {
    ++obj->count;
}

void intrusive_ptr_release(Object* obj) {
    if (--obj->count == 0)
        delete obj;
}

class VectorList {
private:
    std::vector<boost::intrusive_ptr<Object> > data;
public:
    void add(boost::intrusive_ptr<Object> object) {
        data.push_back(object);
    }
    boost::intrusive_ptr<Object> get(int i) {
        return data[i];
    }
    int size() {
        return data.size();
    }
};

class X : public Object {
public:
    int i;

    X() : i(1) {
        std::cout << "X created" << std::endl;
    }
    ~X() {
        std::cout << "X destroyed" << std::endl;
    }
};

void inc(boost::intrusive_ptr<X> x) {
    x->i = 2;
}

int main() {
    boost::intrusive_ptr<X> x;
    x = new X;

    inc(x);
    std::cout << x->i << std::endl;

    {
        boost::intrusive_ptr<X> x2 = x;
        std::cout << x->i << std::endl;
    }

    std::cout << x->i << std::endl;

    std::cout << "vector" << std::endl;
    VectorList vector;
    vector.add(x);

    boost::intrusive_ptr<Object> o = vector.get(0);
    boost::intrusive_ptr<X> oAsX = boost::static_pointer_cast<X>(o);

    std::cout << oAsX->i << std::endl;
}
