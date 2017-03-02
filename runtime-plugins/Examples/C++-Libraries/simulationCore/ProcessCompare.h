#ifndef PROCESSCOMPARE
#define PROCESSCOMPARE

#include "..\..\C++-Libraries\referenceSemantics\intrusive_ptr.h"
#include "Process.h"

// this structure is used for comparing process instances by their event notes.
// Its important to know that the order is by increasing scheduledTime and if
// scheduledTime is the same by decreasing priority.
namespace cbsLib{
struct ProcessComp {
	bool operator()(const cbsLib::intrusive_ptr<cbsLib::Process>& lhs, const cbsLib::intrusive_ptr<cbsLib::Process>& rhs) const;
};
}
#endif
