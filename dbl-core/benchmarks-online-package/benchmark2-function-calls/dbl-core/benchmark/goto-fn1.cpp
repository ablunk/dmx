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
#define STACK_SIZE 32*1024

#include "../log.h"
#include "../scheduler.h"
#include "../core-goto.cpp"
GotoExecution* cx;
#include "../scheduler.cpp"

#define MEASURE_EXEC_TIME
#include "measure.cpp"

// The size of the variables area is computed by the sum of the number of bytes of each parameter and local variable defined by a function. Variables allocated memory in the variables area in the order of their appearance in the BL function. The value of a certain variable is computed from the base vbp by adding the number of bytes of all variables which are defined before the regarded variable.
#define TN_varea_size sizeof(int)
#define TN_N_size sizeof(int)

// The pointer vbp has to be interpreted as a char pointer. This allows to make use of pointer arithmetics with a given number of bytes in order to compute the address of a corresponding variable. The variable then has a certain type, so another reinterpretation of the pointer to the variable is necessary.
#define TN_N  (* reinterpret_cast<int*>(cx->top - TN_varea_size))

int num = 2;
int sum = 0;

void simulate(int argc, char *argv[]) {
    Scheduler* sched = new Scheduler();
    cx = new GotoExecution(0, &&main_actions);
    sched->add(cx);
 
    main_actions:;
    if (argc > 1) {
        std::stringstream str;
        str << argv[1];
        str >> num;
    }

    START_MEASURE;
    for (int i=0; i<num; i++) {
        cx->push(&&main_l2, TN_varea_size);
        // place value for argument 1
        TN_N = i;
        goto fn_tn;
        main_l2:;
        log("tn() returned with return value = " << LRV_INT);
        sum += LRV_INT;
    }
    END_MEASURE;
    print("sum: " << sum);
    print("time [s]: " << TIME_DIFF);

    {
        WRITE_OUTPUT_LOG;
    }

    goto end_cp;

    fn_tn:;
    LRV_INT = TN_N + 1;
    RETURN(TN_varea_size);

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
