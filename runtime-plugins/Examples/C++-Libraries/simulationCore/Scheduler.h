#ifndef SCHEDULER_H
#define SCHEDULER_H

#include "ProcessCompare.h"
#include "Process.h"
#include "../../C++-Libraries/referenceSemantics/intrusive_ptr.h"
#include <vector>
#include <set>
#include <string>
#include <memory>
#include <unordered_set>
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
	void advance(cbsLib::intrusive_ptr<cbsLib::Process> p, double time);
	void yield(cbsLib::intrusive_ptr<cbsLib::Process> p);
	void wait(cbsLib::intrusive_ptr<cbsLib::Process> p);
	void reactivate(cbsLib::intrusive_ptr<cbsLib::Process> p);
	void activate(cbsLib::intrusive_ptr<cbsLib::Process> p, int priority = 0);
	void terminate(cbsLib::intrusive_ptr<cbsLib::Process> p);

	// gets additional informations needed in the simulation
	cbsLib::intrusive_ptr<cbsLib::Process> getCurrentProcess() const;
	double getCurrentSimulationTime() const;
	cbsLib::Process* getMainProcess() const;
	void setMainProcess(cbsLib::Process* p);

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
	std::multiset<cbsLib::intrusive_ptr<cbsLib::Process>, ProcessComp> processSet;
	std::unordered_set<cbsLib::intrusive_ptr<cbsLib::Process>> waitingProcesses;
	std::vector<cbsLib::intrusive_ptr<cbsLib::Process>> terminatedProcesses;

	// stores error messages
	std::vector<std::string> errorMessages;

	cbsLib::intrusive_ptr<cbsLib::Process> currentProcess;
	cbsLib::Process* mainProcess;

	void printSched();
	State intToState(int status) const;
	void printErrors();
	void createAndStoreErrorMessage(cbsLib::intrusive_ptr<cbsLib::Process> p, int errorCode);
	cbsLib::intrusive_ptr<cbsLib::Process> getNextProcess() const;
};
}
#endif
