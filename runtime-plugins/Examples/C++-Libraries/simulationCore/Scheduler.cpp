#include "Scheduler.h"
#include "EventNote.h"
#include "FunctionContext.h"
#include <iostream>
#include <sstream>

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
	p.get()->ev->setScheduledTime(p.get()->ev->getScheduledTime() + eventTime);
	p.get()->isInExecutionSet = true;
	processSet.insert(p);
}

void Scheduler::createAndStoreErrorMessage(intrusive_ptr<Process> p,
		int errorCode) {
	std::stringstream ss;
	switch (errorCode) {
	case 0:
		ss << "Process " << p.get()->getName() << " with ID " << p.get()->getPid()
				<< " to be scheduled is already scheduled! Activation ignored!";
		break;
	case 1:
		ss << "Process " << p.get()->getName() << " with ID " << p.get()->getPid()
				<< " was already terminated! Activation ignored!";
		break;
	case 2:
		ss << "Process " << p.get()->getName() << " with ID " << p.get()->getPid()
				<< " is not waiting!";
		break;
	case 3:
		ss << "Process " << p.get()->getName() << " with ID " << p.get()->getPid()
				<< " is waiting! It should be reactivated!";
		break;
	default:
		ss << "Unknown ERROR!";
		break;
	}
	errorMessages.push_back(ss.str());
}

void Scheduler::yield(intrusive_ptr<Process> p) {
	p.get()->isInExecutionSet = true;
	processSet.insert(p);
}

void Scheduler::wait(intrusive_ptr<Process> p) {
	p.get()->isWaiting = true;
	p.get()->isInExecutionSet = false;
	waitingProcesses.insert(p);
}

void Scheduler::terminate(intrusive_ptr<Process> p) {
	p.get()->isTerminated = true;
	terminatedProcesses.push_back(p);
}

void Scheduler::reactivate(intrusive_ptr<Process> p) {
	if (p.get()->isWaiting) {
			std::unordered_set<intrusive_ptr<Process>>::iterator reactivatedPIterator = waitingProcesses.find(p);
			intrusive_ptr<Process> waitingP = *reactivatedPIterator;
			(*reactivatedPIterator).get()->isWaiting = false;
			(*reactivatedPIterator).get()->ev->setScheduledTime(modelTime);
			(*reactivatedPIterator).get()->isInExecutionSet = true;
			waitingProcesses.erase(reactivatedPIterator);
			processSet.insert(waitingP);
	} else
		createAndStoreErrorMessage(p, 2);
}

void Scheduler::activate(intrusive_ptr<Process> p, int priority) {
	// the activation of a process can only be done once
	if (p.get()->isCreated) {
		p.get()->ev->setPriority(priority);
		p.get()->ev->setScheduledTime(modelTime);
		p.get()->isInExecutionSet = true;
		processSet.insert(p);
		p.get()->isCreated = false;
	} else if (p.get()->isTerminated) {
		createAndStoreErrorMessage(p, 1);
	} else if (p.get()->isInExecutionSet) {
		createAndStoreErrorMessage(p, 0);
	} else if (p.get()->isWaiting) {
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
		if (currentProcess.get()->ev->getScheduledTime() > modelTime)
			modelTime = currentProcess.get()->ev->getScheduledTime();
		// process is removed from the processSet
		currentProcess.get()->isInExecutionSet = false;
		processSet.erase(processSet.begin());

		// this function call looks ugly, but here informations are retrieved from tuple
		// out of the current active process coroutine stack. The static function is called with
		// the function context and a pointer on the process, which calls the function
		// (see abstract class Process for details)
		s = intToState((std::get<0>(currentProcess.get()->callStack.top())(std::get<2>(currentProcess.get()->callStack.top()), std::get<1>(currentProcess.get()->callStack.top()).get())));

		// as long as State::calling is read as return value the scheduler calls function from
		// coroutine stack, which is growing or shrinking
		while (s == State::CALLING){
			s = intToState((std::get<0>(currentProcess.get()->callStack.top()) (std::get<2>(currentProcess.get()->callStack.top()), std::get<1>(currentProcess.get()->callStack.top()).get())));
		}
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
		std::cout << "Process " << p.get()->getName() << " mit ID " << p.get()->getPid()
				<< ", Ereigniszeit: " << p.get()->ev->getScheduledTime()
				<< ", Prioritaet: " << p.get()->ev->getPriority() << std::endl;
		t.erase(t.begin());
	}
	std::cout << std::endl;
}
}
