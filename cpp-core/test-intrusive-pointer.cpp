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
};

void inc(boost::intrusive_ptr<X> x) {
    x->i = 2;
}

int main() {
    boost::intrusive_ptr<X> x = new X;

    inc(x);
    std::cout << x->i << std::endl;

    {
        boost::intrusive_ptr<X> x2 = x;
        std::cout << x->i << std::endl;
    }

    std::cout << x->i << std::endl;

    std::cout << "vector" << std::endl;
    ArrayList list;
    list.add(x);

    boost::intrusive_ptr<Object> o = list.get(0);
    boost::intrusive_ptr<X> oAsX = boost::static_pointer_cast<X>(o);

    std::cout << oAsX->i << std::endl;
}
