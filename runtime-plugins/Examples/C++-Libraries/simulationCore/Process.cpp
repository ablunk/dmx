#include "Process.h"
#include "EventNote.h"
#include <sstream>
cbsLib::Process::Process(const char* nameP, int pidP) :
		pid(pidP), name(nameP), isInExecutionSet(false), isWaiting(false),
		isTerminated(false), isCreated(true), ev(new EventNote(0)) {
}
cbsLib::Process::~Process() {
	delete ev;
}
stringPtr cbsLib::Process::toString() {
	std::stringstream ss;
	ss << name << "#" << pid;
	return new cbsLib::myString(ss.str());
}
