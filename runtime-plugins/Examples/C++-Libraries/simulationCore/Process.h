#ifndef PROCESS
#define PROCESS
#include <memory>
#include <stack>
#include <vector>
#include <tuple>
#include "../../C++-Libraries/referenceSemantics/BaseRefCounter.h"
#include "../../C++-Libraries/referenceSemantics/intrusive_ptr.h"
#include "../../C++-Libraries/referenceSemantics/RefStringType.h"
#include "../../C++-Libraries/simulationCore/FunctionContext.h"

typedef cbsLib::intrusive_ptr<cbsLib::myString> stringPtr;
// this abstract base class brings some concepts to simulate the coroutine
// behavior. All process instances are managed by intrusive pointers. They all
// get a standard toString() representation and a coroutine stack.

namespace cbsLib{
class EventNote;

class Process: public cbsLib::intrusive_ref_counter<cbsLib::Process> {
private:
	// type definition for static functions in the coroutine stack
	typedef int (*fp)(void* self, cbsLib::FunctionBaseContext* context);
	typedef std::tuple<fp, std::unique_ptr<cbsLib::FunctionBaseContext>,void*> tuple_type;

	// helper to make a standard conform function call. the idea is that
	// a static function with some type informations could do a cast to
	// the correct instance type and call the right member function.
	template <typename T, int (T::*M)(cbsLib::FunctionBaseContext* context)>
	struct FunctionCallHelper{
	    static int fCall(void* self, cbsLib::FunctionBaseContext* context){
	    	T* _self = static_cast<T*>(self);
	        return (_self->*M)(context);
	    }
	};

	int pid;
	std::string name;
public:
	// some of the possible states of a process
	bool isInExecutionSet;
	bool isWaiting;
	bool isTerminated;
	bool isCreated;

	// every process instance has a event note, which is all time updated
	EventNote* ev;

	// schedule() function enables a process to fill its coroutine stack with a function
	// call, a function context and a function caller
	template <typename T, int (T::*M)(cbsLib::FunctionBaseContext* context)>
	void schedule(void* p, cbsLib::FunctionBaseContext* context){
	    callStack.push(std::make_tuple(FunctionCallHelper<T,M>::fCall,std::unique_ptr<cbsLib::FunctionBaseContext>(context),p));
	}
	// coroutine stack
	std::stack<tuple_type, std::vector<tuple_type>> callStack;

	std::string getName() const {return name;}
	int getPid() const {return pid;}

	// represents the life cycle of a process. Is implemented in derived classes
	virtual int fActions(cbsLib::FunctionBaseContext* context) = 0;
	// to generate to-String() representation for process instances
	virtual stringPtr toString();

	Process(const char* nameP, int pidP);
	virtual ~Process();
};
}
#endif
