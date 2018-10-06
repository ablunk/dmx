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

#ifndef __SCHEDULER_H
#define __SCHEDULER_H

#include <iostream>
#include <stdexcept>
#include <map>

#include "log.h"

class MovingList;
class Scheduler;

class Execution {
public:
    static int nextPid;
    int pid;
    int priority;
    Execution* nextMoving; // next execution if this execution is in the moving list
    MovingList* ml; // the moving list of this execution

    Execution(int pid, int priority) : pid(pid), priority(priority) {
        log2("created execution: pid = " << pid << ", priority = " << priority);
    }

    Execution(int priority) : pid(nextPid++), priority(priority) {
        log2("created execution: pid = " << pid << ", priority = " << priority);
    }

    virtual void addAsNext(MovingList* rml, Execution* e);

    // gets the moving list back into a consistent state if the first Execution is a DummyExecution,
    // i.e. the moving list is essentially empty. this saves condition checks on the moving list,
    // i.e. something like "first == NULL" checks.
    virtual void updateMovingList();

    virtual void eraseEmptyMovingList(Scheduler* sched);

    // free resources needed for execution after the execution has terminated.
    virtual void freeResources();
};

class DummyExecution : public Execution {
public:
    DummyExecution(int priority) : Execution(-1,priority) {
        nextMoving = this;
    }
    virtual void addAsNext(MovingList* rml, Execution* e);
    virtual void updateMovingList();
    virtual void eraseEmptyMovingList(Scheduler* sched);
};

class MovingList {
public:
    DummyExecution dx; // dummy execution for saving NULL pointer checks
    Execution* first; // the current priority class as a linked list
    Execution* last;

public:
    MovingList(int priority) : dx(priority), first(&dx), last(&dx) {
        dx.ml = this;
    }

    void yield();
    void terminate(); // terminate current
};

class Scheduler {
public:
    // each priority-class is managed as a linked list in a priority-keyed map
    std::map<int, MovingList*, std::greater<int> > pml;

    void add(Execution* e);

    Execution* next();
    Execution* yield();
    Execution* terminate(); // terminate current and return next from moving list
};

#endif
