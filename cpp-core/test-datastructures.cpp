#include <iostream>
#include <boost/intrusive_ptr.hpp>
#include "dbl-stdlib.hpp"

class X : public Object {
public:
    int i;

    X() : i(1) {
        std::cout << "X created" << std::endl;
    }

    ~X() {
        std::cout << "X destroyed" << std::endl;
    }

    bool equals(boost::intrusive_ptr<X> other) const {
        return i == other->i;
    }

    int hashCode() const {
        return i;
    }
};

void inc(boost::intrusive_ptr<X> x) {
    x->i = 2;
}

int main() {
    boost::intrusive_ptr<ArrayList> list = new ArrayList;
    boost::intrusive_ptr<X> x1 = new X;
    list->add(x1);
    list->add(new X);
    std::cout << list->size() << std::endl;

    boost::intrusive_ptr<Iterator> iterator = list->iterator();
    while (iterator->hasNext()) {
        boost::intrusive_ptr<Object> object = iterator->getNext();
        boost::intrusive_ptr<X> objectAsX = boost::static_pointer_cast<X>(object);
        std::cout << "got X " << objectAsX->i << std::endl;
    }
}
