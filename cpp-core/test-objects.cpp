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
    boost::intrusive_ptr<X> x = new X;
    boost::intrusive_ptr<X> x2 = new X;

    std::cout << x << std::endl;
    std::cout << x->equals(x2) << std::endl;
    std::cout << "x.hashCode: " << x->hashCode() << std::endl;
    std::cout << "x2.hashCode: " << x2->hashCode() << std::endl;
}
