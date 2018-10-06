#include <odemx/odemx.h>
#include <iostream>
#include <sstream>

#define MEASURE_EXEC_TIME
#include "measure.cpp"

#define print(MSG) std::cout << getLabel() << ": " << MSG << std::endl;

int num = 5;

class Counter : public odemx::base::Process {
public:
    Counter(odemx::base::Simulation& sim)
        : odemx::base::Process (sim, "A simple process")
        {}

    virtual int main();
};

int Counter::main() {
    while (num > 0) {
        num--;
        hold();
    }
    return 0;
}

int main(int argc, char *argv[]) {
    if (argc > 1) {
        std::stringstream str;
        str << argv[1];
        str >> num;
    }

    odemx::base::Simulation& sim = odemx::getDefaultSimulation();
    //sim.enableDefaultLogging(odemx::data::output::STDOUT);

    Counter c1(sim);
    c1.activate();
    Counter c2(sim);
    c2.activate();

    std::cout << "initial count: " << num << std::endl;
    START_MEASURE;
    sim.run();
    END_MEASURE;
    std::cout << "final count: " << num << std::endl;
    std::cout << "time [s]: " << TIME_DIFF << std::endl;

    WRITE_OUTPUT_LOG;

    return 0;
}
