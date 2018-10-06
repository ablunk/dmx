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

#include "log.h"

#ifndef STACK_SIZE
    #define STACK_SIZE 32*1024
#endif

#define YIELD   log("YIELD"); \
                cx = (GotoExecution*) sched->yield(); \
                goto *(cx->cont);

#define TERMINATE   log("TERMINATE"); \
                    cx = (GotoExecution*) sched->terminate(); \
                    goto *(cx->cont);

#define RETURN(vsize)   cx->pop(vsize); \
                        goto *( ((class Frame*)(cx->top))->returnPoint );

// access to a return value if the last function call returned an int value
#define LRV_INT  (cx->lrv.iv)

class Frame {
public:
    void* dummy;
    void* returnPoint; // pointer to return label
};

class GotoExecution : public Execution {
public:
    void* cont; // continuation instruction

    char mem[STACK_SIZE];
    char* top;
 
    // an active function call places its return value in the variable lrv.
    union lrv_union {
        int iv;
        double dv;
        bool bv;
        void* pv;
    } lrv;

    // memory layout
    // =============
    //          0: values (actions part)
    // top0 ->  i: Frame object (stack frame 1)
    //          j: values (stack frame 1)
    // top1 ->  k: (free space)
    void push(void* returnPoint, int vsize) {
        log2("current top @ " << ((void*) top));
        ((class Frame*)(top))->returnPoint = returnPoint;
        top = top + sizeof(class Frame) + vsize;
        log2("new top @ " << ((void*)top));
        log2("pushed stack frame");
    }

    void pop(int vsize) {
        top = top - sizeof(class Frame) - vsize;
        log2("popped stack frame");
    }

    GotoExecution(int priority, void* cont) : cont(cont), Execution(priority) {
        top = mem;
        log2("mem @ " << ((void*)mem) << " to " << ((void*)(mem + STACK_SIZE)) );
        log2("top @ " << ((void*)top));
    }

    virtual void freeResources() {
        Execution::freeResources();
        cont = NULL;
        // TODO release memory of stack in mem variable
        log2("pid-" << pid << ": freed resources.");
    }
};
