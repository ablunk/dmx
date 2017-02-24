#ifndef MYLIST
#define MYLIST

#include <list>
#include "..\..\C++-Libraries\referenceSemantics\BaseRefCounter.h"
#include "..\..\C++-Libraries\referenceSemantics\intrusive_ptr.h"
#include "..\..\C++-Libraries\simulationCore\Process.h"

// this class is derived from std::list to have list functionality
// and it can hold intrusive pointer on process instances
class myProcessList: public std::list<cbsLib::intrusive_ptr<cbsLib::Process>>,
public cbsLib::intrusive_ref_counter<myProcessList> {
	public:
	myProcessList(): std::list<cbsLib::intrusive_ptr<cbsLib::Process>>() {}
};
#endif
