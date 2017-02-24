#ifndef SCHEDULER_H
#define SCHEDULER_H

#include "ProcessCompare.h"
#include "Process.h"
#include "..\..\C++-Libraries\referenceSemantics\intrusive_ptr.h"
#include <vector>
#include <set>
#include <string>
#include <memory>
#include <unordered_set>
using std::string;
using cbsLib::intrusive_ptr;
using cbsLib::Process;

// scheduler manages the process life cycles by calling functions that
// are saved in the corresponding process stacks. It starts the simulation,
// transfers the control between processes and ends the simulation when the
// main process has finished.

namespace cbsLib{
class Scheduler {
public:
	// singleton function to ensure there is only one scheduler
	static Scheduler* getScheduler();

	// scheduling functions working with intrusive pointers on processes
	void advance(intrusive_ptr<Process> p, double time);
	void yield(intrusive_ptr<Process> p);
	void wait(intrusive_ptr<Process> p);
	void reactivate(intrusive_ptr<Process> p);
	void activate(intrusive_ptr<Process> p, int priority = 0);
	void terminate(intrusive_ptr<Process> p);

	// gets additional informations needed in the simulation
	intrusive_ptr<Process> getCurrentProcess() const;
	double getCurrentSimulationTime() const;
	Process* getMainProcess() const;
	void setMainProcess(Process* p);

	// scheduler starts execution
	void manageProcessLifeCycles();
private:
	Scheduler() :
		modelTime(0.0), processSet(), waitingProcesses(), terminatedProcesses(),
		errorMessages(), currentProcess(), mainProcess(){
	}
	// different states, which needs different actions.
	// FINISHED: simulation end, RUNNING: giving control between processes (context switch),
	// CALLING: call and execute functions on the current process stack (no context switch)
	enum class State {
		FINISHED, RUNNING, CALLING
	};
	double modelTime;
	static Scheduler* sched_instance;

	// containers in which process instances are saved to hold them as long as they are needed
	// for the simulation
	std::multiset<intrusive_ptr<Process>, ProcessComp> processSet;
	std::unordered_set<intrusive_ptr<Process>> waitingProcesses;
	std::vector<intrusive_ptr<Process>> terminatedProcesses;

	// stores error messages
	std::vector<string> errorMessages;

	intrusive_ptr<Process> currentProcess;
	Process* mainProcess;

	void printSched();
	State intToState(int status) const;
	void printErrors();
	void createAndStoreErrorMessage(intrusive_ptr<Process> p, int errorCode);
	intrusive_ptr<Process> getNextProcess() const;
};
}
#endif
