#include "ProcessCompare.h"
#include "EventNote.h"
using cbsLib::EventNote;

bool cbsLib::ProcessComp::operator()(const intrusive_ptr<Process>& lhs, const intrusive_ptr<Process>& rhs) const
{
	EventNote* ev1 = lhs.get()->ev;
	EventNote* ev2 = rhs.get()->ev;
	if (ev1->getScheduledTime() == ev2->getScheduledTime())
		return ev1->getPriority() > ev2->getPriority();
	else
		return ev1->getScheduledTime() < ev2->getScheduledTime();
}
