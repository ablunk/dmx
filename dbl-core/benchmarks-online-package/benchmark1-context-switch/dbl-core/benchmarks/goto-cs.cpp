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
#define STACK_SIZE 32*1024

#include <iostream>
#include <sstream>

#include "../log.h"
#include "../scheduler.h"
#include "../core-goto.cpp"
GotoExecution* cx;
#include "../scheduler.cpp"

#define MEASURE_EXEC_TIME
#include "measure.cpp"

int count = 3;

class Counter : public GotoExecution {
public:
    Counter(int priority, void* cont) : GotoExecution(priority, cont) {}
};

void simulate(int argc, char *argv[]) {
    Scheduler* sched = new Scheduler();
    cx = new GotoExecution(0, &&main_actions);
    sched->add(cx);
 
    main_actions:;
    if (argc > 1) {
        std::stringstream str;
        str << argv[1];
        str >> count;
    }

    sched->add(new Counter(1, &&Counter_actions));
    sched->add(new Counter(1, &&Counter_actions));

    pprint("initial count: " << count);
    START_MEASURE;
    cx->cont = &&main_l1;
    YIELD;
    main_l1:;
    END_MEASURE;
    pprint("final count: " << count);
    pprint("time [s]: " << TIME_DIFF);

    WRITE_OUTPUT_LOG;

    goto end_cp;

    Counter_actions:;
    log("action execution begins.");

    while (count > 0) {
        log("count = " << count);
        count--;
        cx->cont = &&Counter_actions_l1;
        YIELD;
        Counter_actions_l1:;
    }
    TERMINATE;

    // end of program
    end_cp:;
    print("reached end_cp");
}

int main(int argc, char *argv[]) {
    simulate(argc, argv);

#ifdef PRINT_MEM_USAGE
    printMemUsage();
#endif

    return 0;
}
