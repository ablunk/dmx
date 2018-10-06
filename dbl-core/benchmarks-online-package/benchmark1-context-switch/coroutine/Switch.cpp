#include "simulation.h"
#include <iostream>
#include <sstream>
#include <fstream>

#define MEASURE_EXEC_TIME
#include "measure.cpp"

using namespace std;

int num = 10;

class Counter : public Process {
    void Actions() {
        Hold(0);
        while (num > 0) {
            num--;
            //cout << this << ": count = " << num << endl;
            Hold(0);
        }
    }
};

void Switch() {
    Activate(new Counter);
    Activate(new Counter);

    cout << "count = " << num << endl;
    START_MEASURE;
    Hold(1);
    END_MEASURE;
    cout << "count = " << num << endl;
    cout << "time [s]: " << TIME_DIFF << endl;

    WRITE_OUTPUT_LOG;
}

int main(int argc, char *argv[]) {
    if (argc > 1) {
        std::stringstream str;
        str << argv[1];
        str >> num;
    } 

    Simulation(Switch())

    return 0;
}
