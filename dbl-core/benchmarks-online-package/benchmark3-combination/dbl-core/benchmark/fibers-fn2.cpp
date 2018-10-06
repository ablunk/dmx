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

#include <iostream>
#include <sstream>
#include <stack>
#include <vector>

//#define MEASURE_EXEC_TIME
//#define PRINT_MEM_USAGE
//#define PRINT_LOG
#define STACK_SIZE 128*1024+4+4+128 //200000000

#include "../log.h"
#include "../scheduler.h"
#include "../core-fibers.cpp"
FiberExecution* cx;
#include "../scheduler.cpp"

#define MEASURE_EXEC_TIME
#include "measure.cpp"

Scheduler* sched;

int num = 4;
int msize = 128*1024/4;
int sum = 0;

class P : public FiberExecution {
public:
    P(int priority) : FiberExecution(priority) {}

    int f(int size) {
        int mem[size];

        // init mem because SLX does so
        memset(mem,0,size*4);
        
        mem[0] = 'a';
        mem[size-1] = 'z';
        int r = mem[0] + mem[size-1];
        YIELD;
        return r;
    }

    virtual void actions() {
        log("action execution begins.");
        while (num > 0) {
            num--;
            //cout << this << ": count = " << num << endl;
            sum += f(msize);
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
            str >> num;
        }

        sched->add(new P(1));
        sched->add(new P(1));

        pprint("initial count: " << num);
        START_MEASURE;
        YIELD;
        END_MEASURE;
        pprint("final count: " << num);
        pprint("time [s]: " << TIME_DIFF);

        WRITE_OUTPUT_LOG;

        freeResources();
        switchFiber( static_cast<FiberExecution*>(cx)->mainFiber );
    }
};

void simulate(int argc, char *argv[]) {
    sched = new Scheduler();

    FiberExecution::init();

    Main* mx = new Main(0, argc, argv);
    cx = mx;
    sched->add(mx);
    switchFiber( static_cast<FiberExecution*>(cx)->fiber );
    
    mx->freeResources();
    
    print("reached end of simulation.");
}

int main(int argc, char *argv[]) {
    simulate(argc, argv);

#ifdef PRINT_MEM_USAGE
    printMemUsage();
#endif

    return 0;
}
