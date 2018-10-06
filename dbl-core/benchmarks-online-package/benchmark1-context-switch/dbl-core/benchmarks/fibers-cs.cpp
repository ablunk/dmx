/*
 * DBL Core
 * Copyright (C) 2013 Andreas Blunk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

//#define PRINT_MEM_USAGE
//#define PRINT_LOG

#include <iostream>
#include <sstream>

#include "../log.h"
#include "../scheduler.h"
#include "../core-fibers.cpp"
FiberExecution* cx;
#include "../scheduler.cpp"

#define MEASURE_EXEC_TIME
#include "measure.cpp"

Scheduler* sched;
int nextPid = 0;

int count = 3;

class Counter : public FiberExecution {
public:
    Counter(int priority) : FiberExecution(priority) {}

    virtual void actions() {
        log("action execution begins.");

        while (count > 0) {
            log("count = " << count);
            count--;
            YIELD;
        }
        TERMINATE;
    }
};

class Main : public FiberExecution {
public:
    int argc;
    char** argv;

    Main(int priority, int argc, char** argv)
        : FiberExecution(priority), argc(argc), argv(argv)
    {}

    virtual void actions() {
        log("main starts execuction.");

        if (argc > 1) {
            std::stringstream str;
            str << argv[1];
            str >> count;
        }

        sched->add(new Counter(1));
        sched->add(new Counter(1));

        pprint("initial count: " << count);
        START_MEASURE;
        YIELD;
        END_MEASURE;
        pprint("final count: " << count);
        pprint("time [s]: " << TIME_DIFF);

        WRITE_OUTPUT_LOG;

        freeResources();
        switchFiber( static_cast<FiberExecution*>(cx)->mainFiber );
    }
};
 
void simulate(int argc, char** argv) {
    sched = new Scheduler();

    FiberExecution::init();

    Main* mx = new Main(0, argc, argv);
    cx = mx;
    sched->add(mx);
    switchFiber( static_cast<FiberExecution*>(cx)->fiber );
    
    mx->freeResources();
    
    print("reached end of simulation.");
}

int main(int argc, char** argv) {
    simulate(argc, argv);

#ifdef PRINT_MEM_USAGE
    printMemUsage();
#endif

    return 0;
}
