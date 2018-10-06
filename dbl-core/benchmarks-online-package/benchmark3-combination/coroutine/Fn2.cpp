#include "simulation.h"
#include <iostream>
#include <sstream>
#include <string.h>

#define MEASURE_EXEC_TIME
#include "measure.cpp"

using namespace std;

int num = 4;
int msize = 128*1024/4;
int sum = 0;
int n = 0;

class Counter : public Process {

    int f(int size) {
        int mem[size];

        // init mem values to zero because SLX does so either
        memset(mem,0,size*4);
        
        mem[0] = 'a';
        mem[size-1] = 'z';
        int r = mem[0] + mem[size-1];
        Hold(0);
        return r;
    }

    void Actions() {
        Hold(0);
        while (num > 0) {
            num--;
            //cout << this << ": count = " << num << endl;
            sum += f(msize);
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
    cout << "sum = " << sum << endl;
    cout << "time [s]: " << TIME_DIFF << endl;

    WRITE_OUTPUT_LOG;
}

int main(int argc, char *argv[]) {
    if (argc > 1) {
        std::stringstream str;
        str << argv[1];
        str >> num;
    }
    if (argc > 2) {
        std::stringstream str2;
        str2 << argv[2];
        str2 >> msize;
    } 

    Simulation(Switch());

    return 0;
}
