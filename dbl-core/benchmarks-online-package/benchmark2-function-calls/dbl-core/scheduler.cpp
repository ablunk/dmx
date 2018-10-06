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
#include "scheduler.h"

int Execution::nextPid = 0;

Execution* Scheduler::next() {
    MovingList* hml = pml.begin()->second;
    return hml->first;
}

Execution* Scheduler::yield() {
    // 1. step:
    // the current execution has to yield in its own priority class
    // (it may not have highest priority one anymore)
    cx->ml->yield();
    
    // 2. step:
    // the next execution has to be picked from the highest priority class
    // (which may be higher than the priority class of the active execution)
    return next();
}

Execution* Scheduler::terminate() {
    Execution* tx = cx;
    
    cx->ml->terminate();

    // when a moving list for a certain priority gets empty, it has to be erased.
    // that is because the PML is ordered by priority and we need access to the highest priority list in next().
    cx->ml->first->eraseEmptyMovingList(this);

    //delete[] old_cx;
    // TODO just to keep it simple for now, we delete the execution here. maybe something to rethink later.

    tx->freeResources();

    return next();
}

// moves the current Execution to the end and returns the new first Execution
void MovingList::yield() {
    Execution* cx = first; // the new current execution is the first execution in the moving list
    first = first->nextMoving;
    first->updateMovingList();
    last->addAsNext(this, cx); // adds the execution after the current last execution
}

void MovingList::terminate() {
    Execution* cx = first; // the current execution is the first execution in the moving list
    first = first->nextMoving;
    first->updateMovingList();
}

void Scheduler::add(Execution* e) {
    MovingList* rml; // the moving list related to the given element

    /*std::map<int,MovingList*>::iterator it;
    it = pml.find(e->priority);
    if (it == pml.end()) {
        rml = new MovingList(e->priority);
        pml.insert( std::pair<int, MovingList*>(e->priority, rml) );
        rml->last->addAsNext(rml, e);
    }
    else {
        rml = it->second;
        rml->last->addAsNext(rml, e);
    }*/

    try {
        rml = pml.at(e->priority);
    }
    catch (const std::out_of_range& r) {
        rml = new MovingList(e->priority);
        pml.insert( std::pair<int, MovingList*>(e->priority, rml) );
    }
    rml->last->addAsNext(rml, e);
}

void Execution::addAsNext(MovingList* rml, Execution* e) {
    ml = rml;
    nextMoving = e;
    rml->last = e;
    e->nextMoving = &(rml->dx);
}

void Execution::updateMovingList() {
    // nothing to do for Execution objects
}

void Execution::eraseEmptyMovingList(Scheduler* sched) {
}

void Execution::freeResources() {
    // nothing to do
}
 
void DummyExecution::addAsNext(MovingList* rml, Execution* e) {
    e->ml = rml;
    rml->first = e;
    rml->last = e;
    e->nextMoving = &(rml->dx);
}

void DummyExecution::updateMovingList() {
    ml->last = this;
}

void DummyExecution::eraseEmptyMovingList(Scheduler* sched) {
    sched->pml.erase(priority);
    log2("erased moving list for priority=" << priority);
}
