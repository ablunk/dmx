#ifndef EVENTNOTE
#define EVENTNOTE

// an event note contains information about a process
// scheduledTime and priority. Every process gets one
// event note, which is updated, when the process status
// changes
namespace cbsLib{
class EventNote {
private:
	int priority;
	double scheduledTime;
public:
	EventNote(int priority);
	int getPriority() const;
	void setPriority(int newPriority);
	void setScheduledTime(double time);
	double getScheduledTime() const;
};
}
#endif
