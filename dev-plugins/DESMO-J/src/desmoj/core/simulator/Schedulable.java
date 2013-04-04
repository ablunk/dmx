package desmoj.core.simulator;

/**
 * All objects that want to be handled by the scheduler must extend this class.
 * These are events (including external events), entities and simprocesses. All
 * functionality common to schedulable objects are encapsulated here.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
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
	 * The eventnote associated to this schedulable object when it is inserted
	 * in the eventlist.
	 */
	EventNote myNote;

	/**
	 * Constructs a schedulable object with the given name. Note that to
	 * identify the multiple objects that can be created of one type of
	 * schedulable, each has a unique number added to its name as a suffix. The
	 * numbers represent the amount of objects being created with the same name.
	 * 
	 * @param name
	 *            java.lang.String : The name of the new schedulable object
	 * @param owner
	 *            Model : The owner of this schedulable object
	 */
	public Schedulable(Model owner, String name, boolean showInTrace) {

		// create modelcomponent with the checked and registered name
		super(owner, owner.getExperiment().getNameCatalog()
				.registeredName(name), showInTrace);
	}

	/**
	 * Removes the schedulable object from the eventlist. The schedulable object
	 * will not become active unless scheduled again. A warning is given if the
	 * schedulable has not scheduled and the method simply returns.
	 */
	public void cancel() {

		if (!isScheduled()) {
			sendWarning("Can't cancel schedulable! Command ignored.",
					"schedulable : " + getName() + " Method: void cancel()",
					"The schedulable to be canceled is not scheduled.",
					"Use method isSchedule() to test if the Schedulable "
							+ "is scheduled and thus can be canceled or not.");
			return; // was already scheduled
		}

		if (currentlySendTraceNotes()) {
			if (this == current()) {
				sendTraceNote("cancels itself");
			} else {
				sendTraceNote("cancels '" + getName() + "'");
			}
		}

		getModel().getExperiment().getScheduler().cancel(this);

		if (currentlySendDebugNotes()) {
			sendDebugNote("cancels from eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

	}

	/**
	 * Returns the eventnote associated to this schedulable object. If the
	 * schedulable object is not currently scheduled, <code>null</code> will be
	 * returned.
	 * 
	 * @return EventNote : The eventnote associated to the schedulable or
	 *         <code>null</code> if scheduable is not currently scheduled
	 */
	EventNote getEventNote() {

		return myNote;

	}

	/**
	 * Shows if this schedulable is the currently active object.
	 * 
	 * @return boolean :<code>true</code> if this schedulable is the currently
	 *         active, <code>false</code> otherwise
	 */
	public boolean isCurrent() {

		return this.equals(getModel().getExperiment().getScheduler()
				.getCurrentSchedulable());

	}

	/**
	 * Tests if this schedulable has already been scheduled.
	 * 
	 * @return boolean :<code>true</code> if already scheduled,
	 *         <code>false</code> otherwise
	 */
	public boolean isScheduled() {

		// Not associated to eventnote if not scheduled
		return (myNote != null);

	}

	/**
	 * Returns the next following scheduled entity on the eventlist relative to
	 * this schedulable object or <code>null</code> if the next entry in the
	 * eventlist is an external event.
	 * 
	 * @return Entity : The next entity following this schedulable object on the
	 *         eventlist or <code>null</code> in case of an external event
	 */
	public Entity nextEntity() {

		if (!isScheduled()) {
			sendWarning(
					"Can't return the next scheduled entity to this schedulable!",
					"Schedulable : " + getName()
							+ " Method: Entity nextEntity()",
					"This schedulable is not scheduled, thus no other "
							+ "schedulable scheduled after this can exist.",
					"Be sure to call this method on scheduled Entities only. "
							+ "You can check that by calling the entity's isScheduled() "
							+ "method which returns a "
							+ "boolean value telling you if it is scheduled or not.");
			return null;
		} else {
			return getModel().getExperiment().getScheduler()
					.getNextEntity(this);
		}

	}

	/**
	 * Returns the next following scheduled event on the eventList relative to
	 * this schedulable object or <code>null</code> if the next entry in the
	 * eventlist is a simprocess.
	 * 
	 * @return Event : The next event following this schedulable object on the
	 *         eventlist or <code>null</code> in case of a simprocess
	 */
	public Event nextEvent() {

		if (!isScheduled()) {
			sendWarning(
					"Can't return the next scheduled Event to this Schedulable!",
					"Schedulable : " + getName() + " Method: Event nextEvent()",
					"This schedulable is not scheduled, thus no other "
							+ "schedulable scheduled after this can exist.",
					"Be sure to call this method on scheduled entities only. "
							+ "You can check that by calling the entity's isScheduled() "
							+ "method which returns a"
							+ "boolean value telling you if it is scheduled or not.");
			return null;
		} else {
			return getModel().getExperiment().getScheduler().getNextEvent(this);
		}

	}

	/**
	 * Returns the next following scheduled schedulable object on the eventList
	 * relative to this schedulable object. The type of object returned will be
	 * determined by following rules
	 * <ol>
	 * <li>an entity if an entity or simprocess is scheduled</li>
	 * <li>an event if an external event is scheduled where neither event nor
	 * simprocess are involved</li>
	 * </ol>
	 * 
	 * @return Event : The next scheudlable following this schedulable object on
	 *         the eventlist
	 */
	public Schedulable nextSchedulable() {

		if (!isScheduled()) {
			sendWarning(
					"Can't return the next schedulable to this schedulable!",
					"Schedulable : " + getName()
							+ " Method: Entity nextSchedulable()",
					"This entity is not scheduled, thus no other Schedulable "
							+ "scheduled after this can exist.",
					"Be sure to call this method on scheduled entities only. "
							+ "You can check that by calling the entity's isScheduled() "
							+ "method which returns a "
							+ "boolean value telling you if it is scheduled or not.");
			return null;
		} else {
			return getModel().getExperiment().getScheduler()
					.getNextSchedulable(this);
		}

	}

	/**
	 * Removes the eventnote associated to this schedulable and the link of the
	 * eventnote to this schedulable object.
	 */
	void removeEventNote() {

		if (myNote == null)
			return;
		if (this instanceof Entity)
			myNote.setEntity(null);
		if (this instanceof Event)
			myNote.setEvent(null);
		myNote = null;

	}

	/**
	 * Allows to rename a schedulable object while keeping its internally added
	 * serial number to keep track of the individual object. Note that invalid
	 * string parameters will result in renaming the schedulable to 'unnamed'.
	 * 
	 * @param newName
	 *            java.lang.String : The schedulable's new name
	 */
	public void rename(String newName) {

		super.rename(getModel().getExperiment().getNameCatalog()
				.registeredName(newName));

	}

	/**
	 * Re-schedules the schedulable at some other point in simulation time than
	 * it already had been scheduled before.
	 * 
	 * @param dt
	 *            TimeSpan : The offset to the current simulation time at which
	 *            this schedulable is to be re-scheduled
	 */
	public void reSchedule(TimeSpan dt) {

		if (dt == null) {
			sendWarning("Can't reSchedule schedulable! Command ingnored.",
					"Schedulable : " + getName()
							+ " Method: reSchedule(TimeSpan dt)",
					"The simulation time given as parameter is a null "
							+ "reference.",
					"Be sure to have a valid TimeSpan reference before calling "
							+ "this method.");
			return; // no proper parameter
		}

		if (!isScheduled()) {
			sendWarning("Can't reSchedule schedulable! Command ingnored.",
					"Schedulable : " + getName()
							+ " Method: reSchedule(TimeSpan dt)",
					"The Schedulable is not scheduled, thus unable to be "
							+ "reScheduled..",
					"Be sure that the schedulable is currently scheduled "
							+ "before calling this method.");
			return; // no proper parameter
		}

		if (currentlySendTraceNotes()) {
			if (this == current()) {
				if (dt == TimeSpan.ZERO)
					sendTraceNote("reschedules itself now");
				else
					sendTraceNote("reschedules itself at "
							+ TimeOperations.add(presentTime(), dt));
			} else {
				if (dt == TimeSpan.ZERO)
					sendTraceNote("reschedules '" + getName() + "' now");
				else
					sendTraceNote("reschedules '" + getName() + "' at "
							+ TimeOperations.add(presentTime(), dt));
			}
		}

		getModel().getExperiment().getScheduler().reSchedule(this, dt);

		if (currentlySendDebugNotes()) {
			sendDebugNote("reschedules on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

	}
	
	   /**
     * Re-schedules the schedulable at some other point in simulation time than
     * it already had been scheduled before.
     * 
     * @param time
     *            TimeInstant : The simulation time at which
     *            this schedulable is to be re-scheduled
     */
    public void reSchedule(TimeInstant time) {

        if (time == null) {
            sendWarning("Can't reSchedule schedulable! Command ingnored.",
                    "Schedulable : " + getName()
                            + " Method: reSchedule(TimeInstant time)",
                    "The simulation time given as parameter is a null "
                            + "reference.",
                    "Be sure to have a valid TimeSpan reference before calling "
                            + "this method.");
            return; // no proper parameter
        }

        if (!isScheduled()) {
            sendWarning("Can't reSchedule schedulable! Command ingnored.",
                    "Schedulable : " + getName()
                            + " Method: reSchedule(TimeInstant time)",
                    "The Schedulable is not scheduled, thus unable to be "
                            + "reScheduled.",
                    "Be sure that the schedulable is currently scheduled "
                            + "before calling this method.");
            return; // no proper parameter
        }
        
        if (TimeInstant.isBefore(time, this.presentTime())) {
                    sendWarning(
                            "Can't reschedule schedulable at given time! "
                                    + "Command ignored.",
                            "Schedulable : "
                                    + getName()
                                    + " Method: reSchedule(TimeInstant time)",
                            "The instant given is in the past.",
                            "To reschedule a schedulable, use a TimeInstant no earlier than the present time. "
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
            sendDebugNote("reschedules on eventlist<br>"
                    + getModel().getExperiment().getScheduler().toString());
        }

    }
	
	/**
     * @deprecated Use reSchedule(TimeSpan dt).
     * Re-schedules the schedulable at some other point in simulation time than
     * it already had been scheduled before.
     * 
     * @param dt
     *            TimeSpan : The offset to the current simulation time at which
     *            this schedulable is to be re-scheduled
     */
    public void reSchedule(SimTime dt) {

        reSchedule(SimTime.toTimeSpan(dt));

    }

	/**
	 * Returns the point of simulation time this Schedulable is scheduled at.
	 * Returns null, if it has not been scheduled and thus can not return an
	 * appropriate point of simulation time.
	 * 
	 * @return TimeInstant : The point of simulation time this Schedulable is
	 *         scheduled at or <code>null</code> otherwise
	 */
	public TimeInstant scheduledAt() {

		if (isScheduled())
			return myNote.getTime();
		else
			return null; // if not scheduled, there's no point of time

	}

	/**
	 * Connects the schedulable object to an eventnote to be inserted into the
	 * eventlist. Becomes necessary whenever a schedulable object is actually
	 * scheduled.
	 * 
	 * @param e
	 *            EventNote : The eventnote to be connected with or
	 *            <code>null</code> if a connection is to be released.
	 */
	void setEventNote(EventNote e) {

		myNote = e;

	}

}