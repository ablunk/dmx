#include "ProcessCompare.h"
#include "EventNote.h"
using cbsLib::Process;
using cbsLib::intrusive_ptr;
using cbsLib::EventNote;

bool cbsLib::ProcessComp::operator()(const intrusive_ptr<Process>& lhs, const intrusive_ptr<Process>& rhs) const
{
	if (lhs->ev->getScheduledTime() == rhs->ev->getScheduledTime())
		return lhs->ev->getPriority() > rhs->ev->getPriority();
	else
		return lhs->ev->getScheduledTime() < rhs->ev->getScheduledTime();
}
