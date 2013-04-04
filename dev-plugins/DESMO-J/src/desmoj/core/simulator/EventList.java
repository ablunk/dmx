package desmoj.core.simulator;

/**
 * This interface describes the set of methods an event-list carrying the
 * scheduled events and entities in a temporal order has to implement. This is a
 * part of the framework that does not have to be implemented by the user in
 * order to get a simulation running, since the scheduler already uses the class
 * EventVector as default EventList construction. Since each step in the
 * discrete simulation requires searching and manipulating the event-list, this
 * is probably one of the best places in the framework to optimize execution
 * performance. Especially if special models show specific behaviour i.e.
 * primarily inserting new events at the very end of the event-list, other
 * implementations of the event-list might support faster access times.
 * 
 * @see EventVector
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
public abstract class EventList {
	/**
	 * Implement this method to let the user obtain a new eventnote. This
	 * resembles the design pattern of a factory method [Gamm95, p. 107]. The
	 * use of a factory method here ensures that always the correct
	 * implementation of an eventnote is used together with the current active
	 * implementation of an event-list, since both might be tightly coupled.
	 * (Note that this is not mandatory as proven in the default implementation)
	 * 
	 * @return EventNote : The new eventnote that contains all the information
	 *         handed as parameters
	 * @param who
	 *            Entity : The entity that is to be changed by the event to
	 *            happen
	 * @param what
	 *            Event : The type of event that is going to happen
	 * @param when
	 *            TimeInstant : The point of time at which the event is going to
	 *            happen to the entity
	 */
	abstract EventNote createEventNote(Entity who, Event what, TimeInstant when);

	/**
	 * Returns the first eventnote in the event-list. That eventnote contains
	 * information about the next event to happen and will be the next event
	 * processed by the scheduler.
	 * 
	 * @return EventNote : The first eventnote in the event-list
	 */
	abstract EventNote firstNote();

	/**
	 * Inserts a new eventnote into the EventList. Eventnote are sorted by the
	 * point if time they are scheduled to happen. This method ensures that the
	 * new eventnote is inserted in the right place in the event-list, scanning
	 * through the list whenever a new eventnote has to be inserted.
	 * 
	 * @param newNote
	 *            EventNote : The eventnote to be sorted into the event-list
	 */
	abstract void insert(EventNote newNote);

	/**
	 * Inserts the new eventnote straight before the other specified eventnote.
	 * This other eventnote must already be scheduled. Otherwise a warning will
	 * be issued and the method returns without changing the event-list.
	 * 
	 * @param beforeNote
	 *            EventNote : The eventnote already scheduled, that the new
	 *            eventnote is supposed to be inserted before.
	 * @param newNote
	 *            EventNote : The new eventnote to be inserted before the
	 *            specified eventnote
	 */
	abstract void insertAfter(EventNote afterNote, EventNote newNote);

	/**
	 * Inserts the given eventnote at the first position in the event-list. The
	 * event encapsulated in that eventnote will probably be the next event to
	 * be processed by the scheduler (unless some other calls to this method are
	 * made before). Note that this operation changes the scheduled time of the
	 * given eventnote to the actual simulation time to keep the temporal order
	 * of the event-list.
	 * 
	 * @param newNote
	 *            EventNote : The eventnote to be inserted at the first position
	 *            in the event-list
	 */
	abstract void insertAsFirst(EventNote newNote);

	/**
	 * Inserts an eventnote at the last position in the event-list. Note that
	 * the simulation time of the given eventnote will be set to be the same as
	 * the last eventnote in the event-list to keep the temporal order of the
	 * evnet-list.
	 * 
	 * @param newNote
	 *            EventNote : The eventnote to be inserted at the last position
	 *            in the event-list
	 */
	abstract void insertAsLast(EventNote newNote);

	/**
	 * Inserts the new EventNote straight before the other specified EventNote.
	 * This other Eventnote must already be scheduled. Otherwise the position to
	 * insert the given EventNote can not be determined, resulting in a
	 * ItemNotScheduledException being thrown.
	 * 
	 * @param beforeNote
	 *            EventNote : The EventNote already scheduled, that the new
	 *            EventNote is supposed to be inserted before.
	 * @param newNote
	 *            EventNote : The new EventNote to be inserted before the
	 *            specified EventNote
	 */
	abstract void insertBefore(EventNote beforeNote, EventNote newNote);

	/**
	 * Tests if there are any scheduled events contained in the event-list. If
	 * the event-list happens to be empty during the run of a simulation, this
	 * is a criterium to stop the simulation, since no further action is
	 * scheduled.
	 * 
	 * @return boolean : Is <code>true</code> if there are no eventnote
	 *         contained in the event-list, <code>false</code> otherwise.
	 */
	abstract boolean isEmpty();

	/**
	 * Returns the last eventnote in the event-list.
	 * 
	 * @return EventNote : The last eventnote in the event-list
	 */
	abstract EventNote lastNote();

	/**
	 * Returns the next eventnote in the EventList relative to the given
	 * eventnote. If the given eventnote is not contained in the event-list or
	 * happens to be the last eventnote in the event-list, <code>null</code>
	 * will be returned.
	 * 
	 * @return EventNote : The eventnote following the given eventnote or
	 *         <ocde>null</code> if the given eventnote was last or not found
	 * @param origin
	 *            EventNote : The eventnote whose successor is wanted
	 */
	abstract EventNote nextNote(EventNote origin);

	/**
	 * Returns the previous eventnote in the event-list relative to the given
	 * eventnote. If the given eventnote is not contained in the event-list or
	 * happens to be the first eventnote in the evnet-list, <code>null</code>
	 * will be returned.
	 * 
	 * @return EventNote : The eventnote following the given eventnote or
	 *         <ocde>null</code> if the given eventnote was first or not found
	 * @param origin
	 *            EventNote : The eventnote whose predecessor is wanted
	 */
	abstract EventNote prevNote(EventNote origin);

	/**
	 * Removes the given eventnote from the event-list.
	 * 
	 * @param note
	 *            EventNote . The eventnote to be removed from the event-list
	 */
	abstract void remove(EventNote note);

	/**
	 * Removes the first eventnote from the event-list.
	 */
	abstract void removeFirst();
}