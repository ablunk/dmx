#include "EventNote.h"

int cbsLib::EventNote::getPriority() const {
	return priority;
}

void cbsLib::EventNote::setPriority(int newPriority) {
	priority = newPriority;
}

void cbsLib::EventNote::setScheduledTime(double time) {
	scheduledTime = time;
}

double cbsLib::EventNote::getScheduledTime() const {
	return scheduledTime;
}

cbsLib::EventNote::EventNote(int priority) : priority(priority),scheduledTime(0.0){}
