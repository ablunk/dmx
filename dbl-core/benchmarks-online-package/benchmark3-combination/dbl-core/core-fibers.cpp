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

#ifndef _WIN32_WINNT
    #define _WIN32_WINNT 0x0400
#endif

#include <windows.h>

#define YIELD   log("YIELD"); \
                cx = (FiberExecution*) sched->yield(); \
                SwitchToFiber( static_cast<FiberExecution*>(cx)->fiber );

#define TERMINATE   log("TERMINATE"); \
                    cx = (FiberExecution*) sched->terminate(); \
                    switchFiber( static_cast<FiberExecution*>(cx)->fiber );

// if size is set to zero, the fiber uses the default stack size which is usually 1 MB, i.e. 1024*1024.
#ifndef STACK_SIZE
    #define STACK_SIZE 32*1024 //(16+4+128+4+4)*1024 //200000000
#endif

static void __stdcall runFiber(void* p);
void switchFiber(void* targetFiber);
 
class FiberExecution : public Execution {
public:
    void* fiber;
    static void* mainFiber;
    static FiberExecution* prevTerminated;

    FiberExecution(int priority) : Execution(priority) {
        fiber = CreateFiber(STACK_SIZE, runFiber, this);
        log2("created Windows Fiber.");
    }

    static void init() {
        if (mainFiber == NULL) {
            mainFiber = ConvertThreadToFiber(NULL);
        }
    }

    virtual void actions() = 0;

    virtual void freeResources() {
        log2("freeing resources...");

        // an active Fiber cannot delete its own state.
        // therefore the next terminating execution deletes the last terminated fiber.
        if (prevTerminated != NULL) {
            log2("deleting previously terminated fiber.");
            DeleteFiber(prevTerminated->fiber);
            prevTerminated->fiber = NULL;
        }
        prevTerminated = this;
        log2("postponed fiber deletion.");
    }

    friend void runFiber(void* p);
};

void* FiberExecution::mainFiber = NULL;
FiberExecution* FiberExecution::prevTerminated = NULL;

static void __stdcall runFiber(void* p) {
    FiberExecution* fx = static_cast<FiberExecution*>(p);
    fx->actions();
}

void switchFiber(void* targetFiber) {
    SwitchToFiber(targetFiber);
}
