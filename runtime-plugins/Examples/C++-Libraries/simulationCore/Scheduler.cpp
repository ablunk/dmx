#include "Scheduler.h"
#include "EventNote.h"
#include "FunctionContext.h"
#include <iostream>
#include <sstream>
using cbsLib::intrusive_ptr;
using cbsLib::Process;

namespace cbsLib{
Scheduler* Scheduler::sched_instance = nullptr;

Scheduler* Scheduler::getScheduler() {
	if (sched_instance == nullptr)
		sched_instance = new Scheduler();
	return sched_instance;
}

void Scheduler::advance(intrusive_ptr<Process> p, double time) {
	double eventTime = time;
	if (eventTime < 0)
		eventTime *= (-1);
	p->ev->setScheduledTime(p->ev->getScheduledTime() + eventTime);
	p->isInExecutionSet = true;
	processSet.insert(p);
}

void Scheduler::createAndStoreErrorMessage(intrusive_ptr<Process> p,
		int errorCode) {
	std::stringstream ss;
	switch (errorCode) {
	case 0:
		ss << "Process " << p->getName() << " with ID " << p->getPid()
				<< " to be scheduled is already scheduled! Activation ignored!";
		break;
	case 1:
		ss << "Process " << p->getName() << " with ID " << p->getPid()
				<< " was already terminated! Activation ignored!";
		break;
	case 2:
		ss << "Process " << p->getName() << " with ID " << p->getPid()
				<< " is not waiting!";
		break;
	case 3:
		ss << "Process " << p->getName() << " with ID " << p->getPid()
				<< " is waiting! It should be reactivated!";
		break;
	default:
		ss << "Unknown ERROR!";
		break;
	}
	errorMessages.push_back(ss.str());
}

void Scheduler::yield(intrusive_ptr<Process> p) {
	p->isInExecutionSet = true;
	processSet.insert(p);
}

void Scheduler::wait(intrusive_ptr<Process> p) {
	p->isWaiting = true;
	p->isInExecutionSet = false;
	waitingProcesses.insert(p);
}

void Scheduler::terminate(intrusive_ptr<Process> p) {
	p->isTerminated = true;
	terminatedProcesses.push_back(p);
}

void Scheduler::reactivate(intrusive_ptr<Process> p) {
	if (p->isWaiting) {
			std::unordered_set<intrusive_ptr<Process>>::iterator reactivatedPIterator = waitingProcesses.find(p);
			intrusive_ptr<Process> waitingP = *reactivatedPIterator;
			waitingP->isWaiting = false;
			waitingP->ev->setScheduledTime(modelTime);
			waitingP->isInExecutionSet = true;
			waitingProcesses.erase(reactivatedPIterator);
			processSet.insert(waitingP);
	} else
		createAndStoreErrorMessage(p, 2);
}

void Scheduler::activate(intrusive_ptr<Process> p, int priority) {
	// the activation of a process can only be done once
	if (p->isCreated) {
		p->ev->setPriority(priority);
		p->ev->setScheduledTime(modelTime);
		p->isInExecutionSet = true;
		processSet.insert(p);
		p->isCreated = false;
	} else if (p->isTerminated) {
		createAndStoreErrorMessage(p, 1);
	} else if (p->isInExecutionSet) {
		createAndStoreErrorMessage(p, 0);
	} else if (p->isWaiting) {
		createAndStoreErrorMessage(p, 3);
	}
}

intrusive_ptr<Process> Scheduler::getNextProcess() const {
	return *processSet.begin();
}

intrusive_ptr<Process> Scheduler::getCurrentProcess() const {
	return currentProcess;
}

Process* Scheduler::getMainProcess() const{
	return mainProcess;
}

void Scheduler::setMainProcess(Process* p){
	mainProcess = p;
}

double Scheduler::getCurrentSimulationTime() const {
	return modelTime;
}

// in this function starts the execution of the scheduler
void Scheduler::manageProcessLifeCycles() {
	std::cout << "DefaultSimulation Experiment starts at simulation time "
			<< modelTime << "." << std::endl;
	std::cout << " ...please wait..." << std::endl;
	// state starts with running
	State s = State::RUNNING;
	while (s != State::FINISHED) {
		// gets next process and sets simulation time if needed
		currentProcess = getNextProcess();
		if (currentProcess->ev->getScheduledTime() > modelTime)
			modelTime = currentProcess->ev->getScheduledTime();
		// process is removed from the processSet
		currentProcess->isInExecutionSet = false;
		processSet.erase(processSet.begin());

		// this function call looks ugly, but here informations are retrieved from tuple
		// out of the current active process coroutine stack. The static function is called with
		// the function context and a pointer on the process, which calls the function
		// (see abstract class Process for details)
		s = intToState((std::get<0>(currentProcess->callStack.top())(std::get<2>(currentProcess->callStack.top()), std::get<1>(currentProcess->callStack.top()).get())));

		// as long as State::calling is read as return value the scheduler calls function from
		// coroutine stack, which is growing or shrinking
		while (s == State::CALLING)
			s = intToState((std::get<0>(currentProcess->callStack.top())(std::get<2>(currentProcess->callStack.top()), std::get<1>(currentProcess->callStack.top()).get())));
	}
	std::cout << "DefaultSimulation Experiment stopped at simulation time "
			<< modelTime << "." << std::endl;
	printErrors();
}

Scheduler::State Scheduler::intToState(int status) const {
	if (status == 2)
		return State::CALLING;
	else if (status == 0)
		return State::FINISHED;
	else
		return State::RUNNING;
}

void Scheduler::printErrors() {
	if (!errorMessages.empty()) {
		std::cerr << "Found Errors:" << std::endl;
		for (auto error : errorMessages)
			std::cerr << error << std::endl;
	}
}

void Scheduler::printSched() {
	std::cout << std::endl;
	auto t = processSet;
	while (!t.empty()) {
		intrusive_ptr<Process> p = *t.begin();
		std::cout << "Process " << p->getName() << " mit ID " << p->getPid()
				<< ", Ereigniszeit: " << p->ev->getScheduledTime()
				<< ", Prioritaet: " << p->ev->getPriority() << std::endl;
		t.erase(t.begin());
	}
	std::cout << std::endl;
}
}
