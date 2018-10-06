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

#define MEASURE_EXEC_TIME
#include "measure.cpp"

// int size, int mem[size], int i, int r
#define F_S_size sizeof(int)
#define F_MEM_size 128*1024
#define F_I_size sizeof(int)
#define F_R_size sizeof(int)
#define F_varea_size (F_S_size + F_MEM_size + F_I_size + F_R_size)

#define F_S  (* reinterpret_cast<int*>(cx->top - F_varea_size) )
#define F_MEM  reinterpret_cast<int*>(cx->top - F_varea_size + F_S_size)
#define F_I (* reinterpret_cast<int*>(cx->top - F_varea_size + F_S_size + F_MEM_size) )
#define F_R  (* reinterpret_cast<int*>(cx->top - F_varea_size + F_S_size + F_MEM_size + F_I_size) )

// access to a return value if the last function call returned an int value
#define LRV_INT  (cx->lrv.iv)

//#define MEASURE_EXEC_TIME
//#define PRINT_MEM_USAGE
//#define PRINT_LOG
#define STACK_SIZE 8 + F_varea_size //200000000

#include "../log.h"
#include "../scheduler.h"
#include "../core-goto.cpp"
GotoExecution* cx;
#include "../scheduler.cpp"

int num = 4;
int msize = 128*1024/4;
int sum = 0;

class P : public GotoExecution {
public:
    int n;

    P(int priority, void* cont) : GotoExecution(priority, cont), n(0) {}
};

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

    if (argc > 2) {
        std::stringstream str2;
        str2 << argv[2];
        str2 >> msize;
    }

    sched->add(new P(1, &&P_actions));
    log("P created.");

    sched->add(new P(1, &&P_actions));
    log("P created.");

    pprint("initial count: " << num);
    START_MEASURE;
    cx->cont = &&main_l1;
    YIELD;
    main_l1:;
    END_MEASURE;
    pprint("final count: " << num);
    pprint("sum: " << sum);
    pprint("time [s]: " << TIME_DIFF);

    {
        WRITE_OUTPUT_LOG;
    }

    goto end_cp;

    P_actions:;
    log("action execution begins.");

    while (num > 0) {
        num--;
        cx->push(&&P_actions_l2, F_varea_size);
        F_S = msize;
        goto fn_f;
        P_actions_l2:;
        log("f() returned with return value = " << LRV_INT);
        sum += LRV_INT;
    }

    TERMINATE;

    fn_f:;
    //int mem[TN_N]; --> F_MEM

    // init mem because SLX does so
    memset(F_MEM,0,F_S*4);
        
    *(F_MEM + 0) = 'a';
    *(F_MEM + F_S - 1) = 'z';
    F_R = *(F_MEM + 0) + *(F_MEM + F_S - 1);
    
    cx->cont = &&fn_tn_l1;
    YIELD;
    fn_tn_l1:;
    LRV_INT = F_R;
    log("peak tn() returns with value = " << LRV_INT);
    RETURN(F_varea_size);

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
