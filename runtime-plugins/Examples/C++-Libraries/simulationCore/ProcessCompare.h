#ifndef PROCESSCOMPARE
#define PROCESSCOMPARE

#include "..\..\C++-Libraries\referenceSemantics\intrusive_ptr.h"
#include "Process.h"
using cbsLib::intrusive_ptr;
using cbsLib::Process;

// this structure is used for comparing process instances by their event notes.
// Its important to know that the order is by increasing scheduledTime and if
// scheduledTime is the same by decreasing priority.
namespace cbsLib{
struct ProcessComp {
	bool operator()(const intrusive_ptr<Process>& lhs, const intrusive_ptr<Process>& rhs) const;
};
}
#endif
