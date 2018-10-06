#include <iostream>
using namespace std;

int main() {
    int cont;

    cont = 2;
    switch (cont) {
        case 1:
            cout << "skipped" << endl;
        case 2:
            cout << "continued" << endl;
    }
    return 0;
}