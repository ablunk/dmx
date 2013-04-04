package desmoj.core.simulator;

/**
 * EventNotes contain any information needed for any type of schedulable event
 * or process. Since eventnote are tightly coupled with the event-list, a change
 * of the event-list might alo force the eventnotes to contain other information
 * esp. concerning the data structures used in the event-list as well. To adopt
 * the eventnotes extend them to carry the specific data and methods you need
 * for a possible change of the event-list. The implementation here includes
 * data and methods for event information only, since the default implementation
 * of class <code>EventVector</code> needs no special information stored
 * inside the eventnotes.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Tim Lechler
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */
public class EventNote {

	/**
	 * The entity associated to an event and a point of simulation time. Can be
	 * <code>null</code> in case of an external event associated to this
	 * eventnote.
	 */
	private Entity myEntity; // Entity associated with this eventnote

	/**
	 * The event associated to an entity and a point of simulation time. Can be
	 * <code>null</code> in case of a simprocess associated to this eventnote.
	 */
	private Event myEvent; // Type of event that is going to happen
    
	
	/**
	 * The point of simulation time associated to an event and an entity. Must
	 * never be <code>null</code> since changes in the state of a model always
	 * happen to a certain discrete point of time.
	 */
	private TimeInstant myTimeInstant; // time that the event is supposed to happen
    /**
     * If an event note is connected, <code>RandomizingEventVector</code> or
     * <code>RandomizingEventTreeList</code> will not insert another event note 
     * (but not explicity scheduled using
     * <code>scheduleBefore()</code> or <code>scheduelAfter()</code>) 
     * between this event note and its predecessor scheduled for
     * the same instant.
     */
    private boolean isConnected; // flag for connection to predecessor

	/**
	 * EventNotes can only be created if all relevant data can be supplied at
	 * creation time. Note that all relevant associations of the given
	 * schedulables towards this eventnote are built in this constructor
	 * ensuring that each scheduled schedulable has access to its associated
	 * eventnote.
	 * 
	 * @param who
	 *            Entity : The entity that is scheduled to be change during the
	 *            course of the event or the simprocess
	 * @param what
	 *            Event : The type of event that scheduled to happen to the
	 *            entity
	 * @param when
	 *            TimeInstant : The point of time that this eventnote is supposed to
	 *            be processed by the scheduling mechanism
	 */
	public EventNote(Entity who, Event what, TimeInstant when) {

		myEntity = who;
		myEvent = what;
		myTimeInstant = when;
		isConnected = false;

		if (who != null)
			who.setEventNote(this);

		if (what != null)
			what.setEventNote(this);

	}

	/**
	 * Returns the entity that is associated with this eventnote.
	 * 
	 * @return Entity : The entity associated to this eventnote
	 */
	public Entity getEntity() {

		return myEntity;

	}

	/**
	 * Returns the event associated with this eventnote.
	 * 
	 * @return Event : The event associated with this eventnote
	 */
	public Event getEvent() {

		return myEvent;

	}
	
	/**
	 * Returns the point of time associated with this eventnote.
	 * 
	 * @return TimeInstant : Point of time in simulation associated with this
	 *         eventnote
	 */
	public TimeInstant getTime() {

		return myTimeInstant;

	}

	/**
	 * Associates this eventnote with the given entity. This is a package
	 * visibility method for internal framework use only.
	 * 
	 * @param e
	 *            Entity : The entity to be associated with this eventnote
	 */
	void setEntity(Entity e) {

		myEntity = e;

	}

	/**
	 * Associates this eventnote with the given event. This is a package
	 * visibility method for internal framework use only.
	 * 
	 * @param e
	 *            Event : The event to be associated with this eventnote
	 */
	void setEvent(Event e) {

		myEvent = e;

	}
	 
	/**
	 * Sets the point of time for this eventnote to the time given as parameter.
	 * This method is to be used by the scheduler to correct the point of time
	 * of an eventnote after inserting it relative to some other eventnote to
	 * preserve the temporal order of the event-list. This is a package
	 * visibility method for internal framework use only.
	 * 
	 * @param time
	 *            TimeInstant : the new point of simulation time this eventnote is
	 *            associated with.
	 */
	void setTime(TimeInstant time) {

		myTimeInstant = time;

	}
    
    /**
     * Tests if this EventNote is connected to its predecessor.
     * If a connection exists (true), <code>RandomizingEventVector</code> or
     * <code>RandomizingEventTreeList</code> will not insert another event note scheduled for
     * the same instant (but not explicity scheduled using
     * <code>scheduleBefore()</code> or <code>scheduelAfter()</code>) 
     * between this event note and its predecessor  scheduled for
     * the same instant. This is a package
     * visibility method for internal framework use only.
     * 
     * @return boolean : Is <code>true</code> if a connection to the predecessor exists, 
     *                   <code>false</code> otherwise.
     */
    boolean isConnected() {
        return isConnected;
    }

    /**
     * Sets this event node connected to its predecessor (true), so that
     * <code>RandomizingEventVector</code> or
     * <code>RandomizingEventTreeList</code> will not insert another EventNote 
     * (but not explicity scheduled using
     * <code>scheduleBefore()</code> or <code>scheduelAfter()</code>) 
     * between this event note and its predecessor scheduled for
     * the same instant or removes
     * such a connection (false). This is a package
     * visibility method for internal framework use only.
     * 
     * @param isConnected
     *            boolean : establishes (true) or removes (false) a connection between 
     *            this event note and its predecessor.
     */
    void setConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

    /**
	 * Returns a string representing the elements bundled in this eventnote. It
	 * calls the <code>toString()</code> methods of every element putting each
	 * in brackets containing one or two letters to indicate the type of
	 * element.
	 * <p>
	 * <ul>
	 * <li>En: Entity, simprocess or <code>null</code></li>
	 * <li>Ev: Event, external event or <code>null</code></li>
	 * <li>t: simulation time</li>
	 * </ul>
	 * 
	 * @return java.lang.String : String representing the contained elements.
	 */
	public String toString() {

		return ("(En:" + myEntity + ")(Ev:" + myEvent + ")(t:" + myTimeInstant + ")");

	}
}