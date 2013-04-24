package desmoj.core.simulator;

import java.util.LinkedList;
import java.util.List;

/**
 * All objects that want to be handled by the scheduler must extend this class.
 * These are events (including external events), entities and SimProcesses. All
 * functionality common to Schedulable objects are encapsulated here.
 * 
 * @version DESMO-J, Ver. 2.3.5 copyright (c) 2013
 * @author Tim Lechler
 * 
 *         Licensed under the Apache License, Version 2.0 (the "License"); you
 *         may not use this file except in compliance with the License. You may
 *         obtain a copy of the License at
 *         http://www.apache.org/licenses/LICENSE-2.0
 * 
 *         Unless required by applicable law or agreed to in writing, software
 *         distributed under the License is distributed on an "AS IS" BASIS,
 *         WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *         implied. See the License for the specific language governing
 *         permissions and limitations under the License.
 * 
 */
public class Schedulable extends ModelComponent {

    /**
     * A list containing all scheduled entries for this Schedulable in future.
     */
    protected List<EventNote> _schedule;

	/**
	 * Constructs a Schedulable object with the given name. Note that to
	 * identify the multiple objects that can be created of one type of
	 * Schedulable, each has a unique number added to its name as a suffix. The
	 * numbers represent the amount of objects being created with the same name.
	 * 
	 * @param name
	 *            java.lang.String : The name of the new Schedulable object
	 * @param owner
	 *            Model : The owner of this Schedulable object
	 */
	public Schedulable(Model owner, String name, boolean showInTrace) {

		// create modelcomponent with the checked and registered name
		super(owner, owner.getExperiment().getNameCatalog()
				.registeredName(name), showInTrace);
		this._schedule = new LinkedList<EventNote>();
	}


    /**
     * Removes all events scheduled for this entity from the event-list. 
     * The Entity will not become active until scheduled again.
     */
    public void cancel()
    {
        if (!isScheduled()) {
            sendWarning("Can't cancel Schedulable! Command ignored.",
                    "Schedulable : " + getName() + " Method: void cancel()",
                    "The Schedulable to be canceled is not scheduled.",
                    "Use method isSchedule() to test if the Schedulable "
                            + "is scheduled and thus can be canceled or not.");
            return; // was already scheduled
        }
        
        // removes all scheduled events for this entity by using global event-list
        while(!_schedule.isEmpty())
        {
            //EventNote firstNote = this.getModel().getExperiment().getScheduler().evList.firstNote();
            EventNote firstNote = _schedule.get(0);
            
            if (currentlySendTraceNotes()) {
                TimeInstant time = firstNote.getTime();
                if (this == current()) {
                    if (time == presentTime())
                        sendTraceNote("cancels scheduled Event " + firstNote.getEvent() + " for itself, which was scheduled now");
                    else
                        sendTraceNote("cancels scheduled Event " + firstNote.getEvent() + " for itself, which was scheduled at " + time);
                } else {
                    if (time == presentTime())
                        sendTraceNote("cancels scheduled Event " + firstNote.getEvent() + " for " + this.getName() + ", which was scheduled now");
                    else
                        sendTraceNote("cancels scheduled Event " + firstNote.getEvent() + " for " + this.getName() + ", which was scheduled at " + time);
                }
            }
            this.getModel().getExperiment().getScheduler().evList.remove(firstNote);
        }
    }
	

    /**
     * Returns a list of EventNote associated to this Entity object. If the
     * Entity object is not currently scheduled, <code>null</code> will be
     * returned. Remind that all different Event classes can be included.
     * 
     * @return List<EventNote> : The event-notes associated to the entity or
     *         <code>null</code> if Entity is not currently scheduled
     */
    List<EventNote> getEventNotes()
    {
        return _schedule;

    }

	/**
	 * Shows if this Schedulable is the currently active object.
	 * 
	 * @return boolean :<code>true</code> if this Schedulable is the currently
	 *         active, <code>false</code> otherwise
	 */
	public boolean isCurrent() {

		return this.equals(getModel().getExperiment().getScheduler()
				.getCurrentSchedulable());

	}

    /**
     * Tests if this entity has already been scheduled.
     * 
     * @return boolean :<code>true</code> if already scheduled,
     *         <code>false</code> otherwise
     */
    public boolean isScheduled() {

        // Not associated to EventNote if not scheduled
        return (!_schedule.isEmpty());

    }

    /**
     * Removes an event-note from the internal list
     * 
     * * @param note
     *            EventNote : The <code>EventNote to be removed</code>
     */
    void removeEventNote(EventNote note) 
    {
        _schedule.remove(note); // only removes Event in local list

    }

	/**
	 * Allows to rename a Schedulable object while keeping its internally added
	 * serial number to keep track of the individual object. Note that invalid
	 * string parameters will result in renaming the Schedulable to 'unnamed'.
	 * 
	 * @param newName
	 *            java.lang.String : The Schedulable's new name
	 */
	public void rename(String newName) {

		super.rename(getModel().getExperiment().getNameCatalog()
				.registeredName(newName));

	}
	
    /**
     * Re-schedules the Schedulable by shifting all EventNote by a specified <code>
     * TimeSpan</code>.
     * 
     * @param dt
     *            TimeSpan : The offset to the current simulation time at which
     *            this Schedulable is to be re-scheduled
     */
    public void reSchedule(TimeSpan dt)
    {
        if (dt == null) {
            sendWarning("Can't reSchedule Schedulable! Command ingnored.",
                    "Schedulable : " + getName()
                            + " Method: reSchedule(TimeSpan dt)",
                    "The simulation time given as parameter is a null "
                            + "reference.",
                    "Be sure to have a valid TimeSpan reference before calling "
                            + "this method.");
            return; // no proper parameter
        }

        if (!isScheduled()) {
            sendWarning("Can't reSchedule Schedulable! Command ingnored.",
                    "Schedulable : " + getName()
                            + " Method: reSchedule(TimeSpan dt)",
                    "The Schedulable is not scheduled, thus unable to be "
                            + "reScheduled..",
                    "Be sure that the Schedulable is currently scheduled "
                            + "before calling this method.");
            return; // no proper parameter
        }
        
        // create list with new events and remove old events
        EventNote newNote = null;
        List<EventNote> oldNotes = new LinkedList<EventNote>(_schedule);
        List<EventNote> newNotes = new LinkedList<EventNote>();
        for (EventNote oldNote : oldNotes)
        {
            newNote = oldNote.copy(current()); // copy EventNote
            newNote.setTime(TimeOperations.add(oldNote.getTime(), dt)); // shift it
            newNotes.add(newNote); // save it to new list
            this.getModel().getExperiment().getScheduler().evList.remove(oldNote); // remove original event-note local and global
            
            if (currentlySendTraceNotes()) {
                    TimeInstant timeOld = oldNote.getTime();
                    TimeInstant timeNew = newNote.getTime();
                    if (this == current()) {
                        if (timeOld == presentTime())
                            sendTraceNote("reschedules " + newNote.getEvent() + " for itself, which was scheduled now, to " + timeNew);
                        else
                            sendTraceNote("reschedules " + newNote.getEvent() + " for itself, which was scheduled at " + timeOld + ", to " + timeNew);
                    } else {
                        if (timeOld == presentTime())
                            sendTraceNote("reschedules " + newNote.getEvent() + " for " + this.getName() + ", which was scheduled now, to " + timeNew);
                        else
                            sendTraceNote("reschedules " + newNote.getEvent() + " for " + this.getName() + ", which was scheduled at " + timeOld + ", to " + timeNew);
                    }
             }
            
        }
        
        //insert temp to schedule
        for (EventNote ev : newNotes)
        {
            // insert to GLOBAL list, which inserts to local one
            this.getModel().getExperiment().getScheduler().evList.insert(ev); 
        }
        
    }
	    
    /**
     * Re-schedules the Schedulable to some other point in simulation time
     * (which should be different form the instant at which is a scheduled
     * at the moment).
     * 
     * @param time
     *            TimeInstant : The simulation time at which
     *            this entity is to be re-scheduled
     */
    public void reSchedule(TimeInstant time) {

        if (time == null) {
            sendWarning("Can't reSchedule enitty! Command ingnored.",
                    "Entity : " + getName()
                            + " Method: reSchedule(TimeInstant time)",
                    "The simulation time given as parameter is a null "
                            + "reference.",
                    "Be sure to have a valid TimeSpan reference before calling "
                            + "this method.");
            return; // no proper parameter
        }

        if (!isScheduled()) {
            sendWarning("Can't reSchedule Schedulable! Command ingnored.",
                    "Entity : " + getName()
                            + " Method: reSchedule(TimeInstant time)",
                    "The Entity is not scheduled, thus unable to be "
                            + "reScheduled.",
                    "Be sure that the entity is currently scheduled "
                            + "before calling this method.");
            return; // no proper parameter
        }

        if (_schedule.size()>1) {
            sendWarning("Can't reSchedule Entity! Command ingnored.",
                    "Entity : " + getName()
                            + " Method: reSchedule(TimeInstant time)",
                    "The Entity is scheduled more then once, thus unable to be "
                            + "reScheduled.",
                    "Be sure that the entity is only scheduled once"
                            + "before calling this method.");
            return; // no proper parameter
        }
        
        if (TimeInstant.isBefore(time, this.presentTime())) {
                    sendWarning(
                            "Can't reschedule Entity at given time! "
                                    + "Command ignored.",
                            "Entity : "
                                    + getName()
                                    + " Method: reSchedule(TimeInstant time)",
                            "The instant given is in the past.",
                            "To reschedule an entity, use a TimeInstant no earlier than the present time. "
                                    + "The present time can be obtained using the "
                                    + "presentTime() method");
            return;
            // I can't be rescheduled, TimeInstant has already passed.
        }

        if (currentlySendTraceNotes()) {
            if (this == current()) {
                if (time == presentTime())
                    sendTraceNote("reschedules itself now");
                else
                    sendTraceNote("reschedules itself at "
                            + time);
            } else {
                if (time == presentTime())
                    sendTraceNote("reschedules '" + getName() + "' now");
                else
                    sendTraceNote("reschedules '" + getName() + "' at "
                            + time);
            }
        }

        getModel().getExperiment().getScheduler().reSchedule(this, time);

        if (currentlySendDebugNotes()) {
            sendDebugNote("reschedules on EventList<br>"
                    + getModel().getExperiment().getScheduler().toString());
        }

    }
	
	/**
     * @deprecated Use reSchedule(TimeSpan dt).
     * Re-schedules the Schedulable at some other point in simulation time than
     * it already had been scheduled before.
     * 
     * @param dt
     *            TimeSpan : The offset to the current simulation time at which
     *            this Schedulable is to be re-scheduled
     */
    public void reSchedule(SimTime dt) {

        reSchedule(SimTime.toTimeSpan(dt));

    }

    /**
     * @deprecated Returns the point of simulation time this Schedulable is scheduled at.
     * Returns null, if the entity has not been scheduled and thus can not return an
     * appropriate point of simulation time.
     * 
     * Use scheduleNext() for next TimeInstant where an event-note lists this entity.
     * 
     * @return TimeInstant : The point of simulation time this Schedulable is
     *         scheduled at or <code>null</code> otherwise
     */
    public TimeInstant scheduledAt() {

        return scheduledNext(); //use scheduleNext()

    }
    
    /**
     * Returns the next point of time this entity is scheduled.
     * 
     * @return TimeInstant : The point of simulation time the next Entity
     * is schedule or <code>null</code> otherwise
     */
    public TimeInstant scheduledNext()
    {
        if (!isScheduled())
        {
            return null; // if not scheduled, there is no point of time
        }
        else
        {
            return _schedule.get(0).getTime();
        }
    }
	
    
    /**
     * Adds an event-note to the Schedulable.
     */
    void addEventNote(EventNote note)
    {
        if (!_schedule.contains(note)) {
            _schedule.add(note);
            java.util.Collections.sort(_schedule);
        }
    }
    
    /**
     * Creates and returns a copy of this Schedulable.
     * Note that subclasses have to implement the interface 
     * </code>java.lang.Cloneable</code> to actually use this method as 
     * otherwise, a </code>CloneNotSupportedException</code> will be thrown.
     * 
     * @return Schedulable : A copy of this Schedulable.
     */  
    protected Schedulable clone() throws CloneNotSupportedException {
        Schedulable c = (Schedulable) super.clone();
        NameCatalog nc = this.getModel().getExperiment().getNameCatalog();
        c.rename(nc.getNameWithoutSuffix(this.getName()));
        c._schedule = new LinkedList<EventNote>();
        return c;
    }
}