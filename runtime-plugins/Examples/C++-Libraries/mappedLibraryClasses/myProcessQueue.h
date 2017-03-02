#ifndef MYLIST
#define MYLIST

#include <queue>
#include "..\..\C++-Libraries\referenceSemantics\BaseRefCounter.h"
#include "..\..\C++-Libraries\referenceSemantics\intrusive_ptr.h"
#include "..\..\C++-Libraries\simulationCore\Process.h"

// this class is derived from std::vector to have arrayList functionality
// and it can hold intrusive pointer on process instances
class myProcessQueue: public std::queue<cbsLib::intrusive_ptr<cbsLib::Process>>,
public cbsLib::intrusive_ref_counter<myProcessQueue> {
	public:
	myProcessQueue(): std::queue<cbsLib::intrusive_ptr<cbsLib::Process>>() {}

	cbsLib::intrusive_ptr<cbsLib::Process> peek(){return front();}

	bool isEmpty() {return empty();}

	bool add(cbsLib::intrusive_ptr<cbsLib::Process> e){
		push(e);
		return true;
	}

	cbsLib::intrusive_ptr<cbsLib::Process> remove() {
		cbsLib::intrusive_ptr<cbsLib::Process> temp = front();
		pop();
		return temp;
	}
};
#endif
