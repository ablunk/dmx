#include <iostream>
#include <sstream>

#define MEASURE_EXEC_TIME
#include "measure.cpp"

int pnum = 1;
int sum = 0;

int f(int n) {
    return n+1;
}

int main(int argc, char *argv[]) {
    if (argc > 1) {
        std::stringstream str;
        str << argv[1];
        str >> pnum;
    }

    START_MEASURE;
    for (int i=0; i<pnum; i++) {
        sum += f(i);
    }
    END_MEASURE;
    std::cout << "sum: " << sum << std::endl;
    std::cout << "time [s]: " << TIME_DIFF << std::endl;

    WRITE_OUTPUT_LOG;

    return 0;
}
