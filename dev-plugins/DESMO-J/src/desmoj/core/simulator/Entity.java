package desmoj.core.simulator;

/**
 * Represents the superclass for all entities of a model. Entities are supposed
 * to be scheduled together with a compatible event at a certain point of
 * simulation time or relative to another event in present or future simulation
 * time.
 * <p>
 * Entities typically encapsulate all information about a model's entity that is
 * relevant to the modeller. Events can manipulate these informations when the
 * scheduled point of simulation time is reached and thus change the state of
 * the model. When modelling different types of entities you need to derive
 * different classes from this superclass. Each carrying the specific
 * information to represent its counterpart in the system modelled. Thus a
 * simulation of i.e. a factory would require both machines and material to be
 * subclasses of class <code>Entity</code>. They can act on each other by
 * scheduling themselves or other Entities with the appropriate Events. To use
 * more than one Entity of one type, created the needed amount of instances. For
 * better identification, all instances created from a subclass of class
 * <code>NamedObjectImp</code> (just as Entity is) get an individual
 * identification number as a suffix to their name so there is no need to name
 * each individual different yourself.
 * <p>
 * Entities can carry a priority that can be modified after the Entity has been
 * instantiated. It is relevant for queueing Entities into any kind of Queues.
 * The entity's priority determines it's position inside the queue when entering
 * it. Although within a model all attributes of an entity could be made public
 * it is advisable to support data hiding by providing methods for accessing the
 * internal attributes, as always in oo-design.
 * 
 * @see Event
 * @see SimProcess
 * @see NamedObject
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
public abstract class Entity extends Schedulable {

	/**
	 * The priority of an entity is essential for inserting into queues.
	 */
	private int myPriority;

	/**
	 * Reference to the queue-links of this entity. They reference the places
	 * this entity is queued in multiple queues. Implemented as a single linked
	 * list.
	 */
	private QueueLink myQLink;

	/**
	 * Constructs an entity with the given name for the given model and the
	 * specified trace option. The default priority is zero.
	 * 
	 * @param name
	 *            java.lang.String : The name of the entity
	 * @param owner
	 *            Model : The model this entity is associated to
	 * @param showInTrace
	 *            boolean : Flag for showing entity in trace-files. Set it to
	 *            <code>true</code> if entity should show up in trace. Set it to
	 *            <code>false</code> if entity should not be shown in trace.
	 */
	public Entity(Model owner, String name, boolean showInTrace) {

		super(owner, name, showInTrace); // create Schedulable
		myPriority = 0; // default priority
		myQLink = null; // not queued

	}

	/**
	 * Adds a reference to the queue this entity was just inserted in. The given
	 * queue-link is an element of a single linked list that always references
	 * to the next queue this entity is in.
	 * 
	 * @param newQ
	 *            QueueLink : The queue-link referencing the queue this entity
	 *            is inserted in
	 */
	void addQueueLink(QueueLink newQ) {

		// do nothing on null values
		if (newQ == null)
			return;

		if (myQLink == null) { // special care for first element

			myQLink = newQ; // set reference to the only queue this is in

		} else { // insert at first position - saves traversing list to end

			newQ.setNextQueue(myQLink); // set ref. of new link to first link in
			// chain
			myQLink = newQ; // set first link ref to new link

		}

	}

	/**
	 * Returns the entity's priority. Default priority of an entity is zero.
	 * Higher priorities are positive, lower priorities negative.
	 * 
	 * @return int : The entity's priority
	 */
	public int getPriority() {

		return myPriority; // Who would have guessed that ?

	}

	/**
	 * Returns a reference to the QueueLink of the given QueueList if this
	 * Entity is inside that QueueList. The Entity's single linked List of
	 * Queues it is currently queued in is scanned for a QueueLink that contains
	 * a reference to the given QueueList. That QueueLink is returned. It
	 * returns <code>null</code> if the Entity is not yet queued in the given
	 * QueueList.
	 * 
	 * @return QueueLink : The QueueLink referencing the given QueueList this
	 *         Entity is in or <code>null</code> if not queued in that
	 *         particular QueueList
	 * @param qList
	 *            desmoj.QueueList : The QueueList this Entity's QueueLink is of
	 *            interest
	 */
	QueueLink getQueueLink(QueueList qList) {

		if (myQLink == null) { // check for null values

			return null;
		}

		if (qList == null) { // check for null values

			return null;
		}

		// loop through all links
		for (QueueLink i = myQLink; i != null; i = i.getNextQueue()) {

			if (i.getQueueList() == qList) {
				return i; // return link if found
			}

		}

		return null; // not found

	}

	/**
	 * Checks if the two entities have the same priority. Note that this is a
	 * static method available through calling the entity's class i.e.
	 * <code>Entity.isEqual(a,b)</code> where <code>a</code> and <code>b</code>
	 * are valid entity objects.
	 * 
	 * @return boolean : Is <code>true</code> if <code>a</code> has the same
	 *         priority as <code>b</code>,<code>/false</code> otherwise
	 * @param a
	 *            Entity : First comparand entity
	 * @param b
	 *            Entity : Second comparand entity
	 */
	public final static boolean isEqual(Entity a, Entity b) {

		return (a.getPriority() == b.getPriority());

	}

	/**
	 * Checks if the first of the two entities has a higher priority than the
	 * second. Note that this is a static method available through calling the
	 * entity's class i.e. <code>Entity.isLarger(a,b)</code> where a and b are
	 * valid entity objects.
	 * 
	 * @return boolean : Is <code>true</code> if <code>a</code> has a larger
	 *         priority than <code>b</code>,<code>/false</code> otherwise
	 * @param a
	 *            Entity : First comparand entity
	 * @param b
	 *            Entity : Second comparand entity
	 */
	public final static boolean isLarger(Entity a, Entity b) {

		return (a.getPriority() > b.getPriority());

	}

	/**
	 * Checks if the first of the two entities has higher or same priority than
	 * the second. Note that this is a static method available through calling
	 * the entity's class i.e. <code>Entity.isLargerOrEqual(a,b)</code> where a
	 * and b are valid entity objects.
	 * 
	 * @return boolean : Is <code>true</code> if <code>a</code> has a larger or
	 *         equal priority than <code>b</code>,<code>/false</code> otherwise
	 * @param a
	 *            Entity : First comparand entity
	 * @param b
	 *            Entity : Second comparand entity
	 */
	public final static boolean isLargerOrEqual(Entity a, Entity b) {

		return (a.getPriority() >= b.getPriority());

	}

	/**
	 * Checks if the first of the two entities have different priorities. Note
	 * that this is a static method available through calling the entity's class
	 * i.e. <code>Entity.isNotEqual(a,b)</code> where a and b are valid entity
	 * objects.
	 * 
	 * @return boolean : Is <code>true</code> if <code>a</code> has a different
	 *         priority than <code>b</code>,<code>/false</code> otherwise
	 * @param a
	 *            Entity : First comparand entity
	 * @param b
	 *            Entity : Second comparand entity
	 */
	public final static boolean isNotEqual(Entity a, Entity b) {

		return (a.getPriority() != b.getPriority());

	}

	/**
	 * Tests if this entity actually is a simprocess. Although simprocesses have
	 * an individual lifecycle, they can alsao be handled like entities and be
	 * scheduled to be manipulated by an event.
	 * 
	 * @return boolean : Is <code>true</code> if this entity is an instance of
	 *         class <code>SimProcess</code>,<code>false</code> otherwise
	 */
	public boolean isSimProcess() {

		return (this instanceof SimProcess);

	}

	/**
	 * Checks if the first of the two entities has a lower priority than the
	 * second. Note that this is a static method available through calling the
	 * entity's class i.e. <code>Entity.isSmaller(a,b)</code> where a and b are
	 * valid entity objects.
	 * 
	 * @return boolean : Is <code>true</code> if <code>a</code> has a lower
	 *         priority than <code>b</code>,<code>/false</code> otherwise
	 * @param a
	 *            Entity : First comparand entity
	 * @param b
	 *            Entity : Second comparand entity
	 */
	public final static boolean isSmaller(Entity a, Entity b) {

		return (a.getPriority() < b.getPriority());

	}

	/**
	 * Checks if the first of the two entities has lower or same priority than
	 * the second. Note that this is a static method available through calling
	 * the entity's class i.e. <code>Entity.isSmallerOrEqual(a,b)</code> where a
	 * and b are valid entity objects.
	 * 
	 * @return boolean : Is <code>true</code> if <code>a</code> has a smaller or
	 *         equal priority than <code>b</code>, <code>/false</code> otherwise
	 * @param a
	 *            Entity : First comparand entity
	 * @param b
	 *            Entity : Second comparand entity
	 */
	public final static boolean isSmallerOrEqual(Entity a, Entity b) {

		return (a.getPriority() <= b.getPriority());

	}

	/**
	 * Returns the number of Queues this Entity is currently queued in. Note
	 * that Entities that enter Queues for statistical reasons ("zeros") have
	 * that Queue registered with them for a short period of time. This might
	 * bias the value returned.
	 * 
	 * @return int : The number of Queues this Entity is currently queued in
	 */
	public int numQueues() {

		int count = 0; // the counter

		// Note that QueueLink.queues instead of QueueLink.next used here!
		for (QueueLink i = myQLink; i != null; i = i.getNextQueue()) {
			count++; // increment for each other QueueLink found
		}

		return count; // this should be the total of all queues

	}

	/**
	 * Removes a reference to the Queue this Entity was just removed from. The
	 * given QueueLink is an element of a single linked list that always
	 * references the next queue this Entity is in.
	 * 
	 * @param newQ
	 *            QueueLink : The QueueLink referencing the Queue this Entity is
	 *            inserted in.
	 */
	void removeQueueLink(QueueLink removeQ) {

		if (myQLink == null) {
			sendWarning("Can't remove QueueLink!", "Entity : " + getName()
					+ " Method: removeQueueLink(QueueLink removeQ)",
					"The entity does not have any references to queues.",
					"Check if this entity is queued in a eueu by calling that "
							+ "queue's contains(entity e) method.");
			return; // no links to queues to be removed here
		}

		if (removeQ == null) {
			sendWarning("Can't remove QueueLink!", "Entity : " + getName()
					+ " Method: removeQueueLink(QueueLink removeQ)",
					"The Queuelink given as parameter is a null reference.",
					"This is an internal error. Please report it to the "
							+ "DESMO-J operator!");
			return; // no proper parameter
		}

		// special care for first element
		if (myQLink == removeQ) {
			myQLink = removeQ.getNextQueue();
			return;
		}

		for (QueueLink tmp = myQLink; tmp != null; tmp = tmp.getNextQueue()) {

			if (tmp.getNextQueue() == removeQ) { // is remQ next?
				tmp.setNextQueue(removeQ.getNextQueue()); // set correct
				// references
				return; // job done
			}

		}

		sendWarning("Can't remove QueueLink!", "Entity : " + getName()
				+ " Method: removeQueueLink(QueueLink removeQ)",
				"The Queuelink given as parameter was not found in the "
						+ "queuelink chain.",
				"This is an internal error. Please report it to the "
						+ "DESMO-J operator!");

	}

	/**
	 * Schedules this entity to be manipulated by the given event at the current
	 * time plus the given offset. Method returns with a warning message if
	 * either Entity or Event are already scheduled in the event-list.
	 * 
	 * @param what
	 *            Event : The event that manipulates this entity
	 * @param when
	 *            TimeSpan :The offset to the current simulation time at which
	 *            the event is to be scheduled
	 * @see SimClock
	 */
	public void schedule(Event what, TimeSpan dt) {
		if ((dt == null)) {
			sendWarning(
					"Can't schedule entity!",
					"Entity : " + getName()
							+ " Method: schedule(Event what, TimeSpan dt)",
					"The simulation time given as parameter is a null reference.",
					"Be sure to have a valid simulation time reference before "
							+ "calling this method.");
			return; // no proper parameter
		}

		if ((what == null)) {
			sendWarning("Can't schedule entity! Command ignored.", "Entity : "
					+ getName() + " Method: schedule(Event what, TimeSpan dt)",
					"The event given as parameter is a null reference.",
					"Be sure to have a valid event reference for this event "
							+ "to be scheduled with.");
			return; // no proper parameter
		}

		if (isScheduled()) {
			sendWarning("Can't schedule entity! Command ignored.", "Entity : "
					+ getName() + " Method: schedule(Event what, TimeSpan dt)",
					"The entity to be scheduled is already scheduled.",
					"Use method reSchedule(TimeSpan dt) to shift the entity "
							+ "to be scheduled at some other point of time.");
			return; // was already scheduled
		}

		if (what.isScheduled()) {
			sendWarning("Can't schedule entity! Command ignored.", "Entity : "
					+ getName() + " Method: schedule(Event what, TimeSpan dt)",
					"The event '" + what.getName()
							+ "'to be scheduled with this "
							+ "entity is already scheduled.",
					"Use method reSchedule(TimeSpan dt) to shift the entity "
							+ "to be scheduled at some other point of time.");
			return; // was already scheduled
		}

		if (!isModelCompatible(what)) {
			sendWarning("Can't schedule Entity! Command ignored", "Entity : "
					+ getName() + " Method: schedule(Event what, TimeSpan dt)",
					"The event to be scheduled with this entity is not "
							+ "modelcompatible.",
					"Make sure to use compatible model components only.");
			return; // was already scheduled
		}

		if (currentlySendTraceNotes()) {
			if (this == currentEntity()) {
				if (dt == TimeSpan.ZERO)
					sendTraceNote("schedules '" + what.getName()
							+ "' of itself now");
				else
					sendTraceNote("schedules '" + what.getName()
							+ "' of itself at "
							+ TimeOperations.add(presentTime(), dt).toString());
			} else {
				if (dt == TimeSpan.ZERO)
					sendTraceNote("schedules '" + what.getName() + "' of '"
							+ getName() + "' now");
				else
					sendTraceNote("schedules '" + what.getName() + "' of '"
							+ getName() + "' at "
							+ TimeOperations.add(presentTime(), dt).toString());
			}
		}

		getModel().getExperiment().getScheduler().schedule(this, what, dt);

		if (currentlySendDebugNotes()) {
			sendDebugNote("schedules on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

	}

	/**
	 * Schedules this entity to be manipulated by the given event at the given
	 * point of time. Method returns with a warning message if either Entity or
	 * Event are already scheduled in the event-list.
	 * 
	 * @param what
	 *            Event : The event that manipulates this entity
	 * @param when
	 *            TimeInstant : The point in simulation time this event is
	 *            scheduled to happen.
	 * @see SimClock
	 */
	public void schedule(Event what, TimeInstant when) {
		if ((when == null)) {
			sendWarning(
					"Can't schedule entity!",
					"Entity : " + getName()
							+ " Method: schedule(Event what, TimeInstant when)",
					"The simulation time given as parameter is a null reference.",
					"Be sure to have a valid simulation time reference before "
							+ "calling this method.");
			return; // no proper parameter
		}

		if ((what == null)) {
			sendWarning("Can't schedule entity! Command ignored.", "Entity : "
					+ getName()
					+ " Method: schedule(Event what, TimeInstant when)",
					"The event given as parameter is a null reference.",
					"Be sure to have a valid event reference for this event "
							+ "to be scheduled with.");
			return; // no proper parameter
		}

		if (isScheduled()) {
			sendWarning("Can't schedule entity! Command ignored.", "Entity : "
					+ getName()
					+ " Method: schedule(Event what, TimeInstant when)",
					"The entity to be scheduled is already scheduled.",
					"Use method reSchedule(TimeInstant when) to shift the entity "
							+ "to be scheduled at some other point of time.");
			return; // was already scheduled
		}

		if (what.isScheduled()) {
			sendWarning("Can't schedule entity! Command ignored.", "Entity : "
					+ getName()
					+ " Method: schedule(Event what, TimeInstant when)",
					"The event '" + what.getName()
							+ "'to be scheduled with this "
							+ "entity is already scheduled.",
					"Use method reSchedule(TimeInstant when) to shift the entity "
							+ "to be scheduled at some other point of time.");
			return; // was already scheduled
		}

		if (!isModelCompatible(what)) {
			sendWarning("Can't schedule Entity! Command ignored", "Entity : "
					+ getName()
					+ " Method: schedule(Event what, TimeInstant when)",
					"The event to be scheduled with this entity is not "
							+ "modelcompatible.",
					"Make sure to use compatible model components only.");
			return; // was already scheduled
		}

		if (currentlySendTraceNotes()) {
			if (this == currentEntity()) {
				if (TimeInstant.isEqual(when, presentTime()))
					sendTraceNote("schedules '" + what.getName()
							+ "' of itself now");
				else
					sendTraceNote("schedules '" + what.getName()
							+ "' of itself at " + when.toString());
			} else {
				if (TimeInstant.isEqual(when, presentTime()))
					sendTraceNote("schedules '" + what.getName() + "' of '"
							+ getName() + "' now");
				else
					sendTraceNote("schedules '" + what.getName() + "' of '"
							+ getName() + "' at " + when.toString());
			}
		}

		getModel().getExperiment().getScheduler().schedule(this, what, when);

		if (currentlySendDebugNotes()) {
			sendDebugNote("schedules on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

	}

	/**
	 * @deprecated Replaced by schedule(Event what,TimeSpan dt). Schedules this
	 *             entity to be manipulated by the given event at the given
	 *             offset to the current simulation time. Note that the given
	 *             point in simulation time is the positive offset to the
	 *             current simulation time as displayed by the simulation clock.
	 *             Method returns with a warning message if either Entity or
	 *             Event are already scheduled in the event-list.
	 * 
	 * @param what
	 *            Event : The event that manipulates this entity
	 * @param when
	 *            SimTime : The offset to the current time this event is
	 *            scheduled to happen
	 * @see SimClock
	 */
	@Deprecated
	public void schedule(Event what, SimTime dt) {
		schedule(what, SimTime.toTimeSpan(dt));
	}

	/**
	 * Schedules this entity with the given event to occur directly after the
	 * given schedulable that is already scheduled. Note that this event's point
	 * of simulation time will be set to be the same as the schedulable's time.
	 * Thus this event will occur directly after the given schedulable but the
	 * simulation clock will not change. Will return with a warning message if
	 * the schedulable given as parameter is not scheduled.
	 * 
	 * @param after
	 *            Schedulable : The schedulable this entity should be scheduled
	 *            after
	 * @param what
	 *            Event : The event to manipulate this entity
	 */
	public void scheduleAfter(Schedulable after, Event what) {

		// check parameters
		if ((what == null)) {
			sendWarning("Can't schedule entity! Command ignored.", "Entity : "
					+ getName()
					+ " Method: scheduleAfter(Schedulable after, Entity who)",
					"The event given as parameter is a null reference.",
					"Be sure to have a valid Event reference before calling "
							+ "this method.");
			return; // no proper parameter
		}

		if ((after == null)) {
			sendWarning("Can't schedule entity! Command ignored.", "Entity : "
					+ getName()
					+ " Method: scheduleAfter(Schedulable after, Entity who)",
					"The schedulable given as parameter is a null reference.",
					"Be sure to have a valid schedulable reference for this "
							+ "Entity to be scheduled with.");
			return; // no proper parameter
		}

		if (!after.isScheduled()) {
			sendWarning(
					"Can't schedule entity! Command ignored.",
					"Entity : "
							+ getName()
							+ " Method: scheduleAfter(Schedulable after, Entity who)",
					"The schedulable given as parameter is not scheduled, "
							+ "thus no position can be determined for this entity.",
					"Be sure that the schedulable given as aprameter is "
							+ "actually scheduled. You can check that by calling its "
							+ "method isScheduled() which returns a boolean telling"
							+ "you whether it is scheduled or not.");
			return; // no proper parameter
		}

		if (isScheduled()) {
			sendWarning("Can't schedule entity! Command ignored.", "Entity : "
					+ getName()
					+ " Method: scheduleAfter(Schedulable after, Entity who)",
					"This entity is already scheduled.",
					"Use method reSchedule(TimeSpan dt) or cancel this entity "
							+ "first.");
			return; // no proper parameter
		}

		if (!isModelCompatible(what)) {
			sendWarning("Can't schedule Entity! Command ignored", "Entity : "
					+ getName()
					+ " Method: scheduleAfter(Schedulable after, Entity who)",
					"The event to be scheduled with this entity is not "
							+ "modelcompatible.",
					"Make sure to use compatible model components only.");
			return; // was already scheduled
		}

		if (currentlySendTraceNotes()) {
			if (this == currentEntity()) {
				sendTraceNote("schedules '" + what.getName()
						+ "' of itself after '" + after.getName() + "' at "
						+ after.getEventNote().getTime().toString());
			} else {
				sendTraceNote("schedules '" + what.getName() + "' of '"
						+ getName() + "' after '" + after.getName() + "' at "
						+ after.getEventNote().getTime().toString());
			}
		}

		getModel().getExperiment().getScheduler().scheduleAfter(after, this,
				what);

		if (currentlySendDebugNotes()) {
			sendDebugNote("scheduleAfter " + after.getQuotedName()
					+ " on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

	}

	/**
	 * Schedules this entity with the given event to occur directly before the
	 * given schedulable that is scheduled. Note that this event's point of
	 * simulation time will be set to be the same as the schedulable's time.
	 * Thus this event will occur directly before the given schedulable but the
	 * simulation clock will not change. Issues a warning message if the
	 * schedulable given is not scheduled.
	 * 
	 * @param before
	 *            Schedulable : The schedulable this entity should be scheduled
	 *            before
	 * @param what
	 *            Event : The event to manipulate this entity
	 */
	public void scheduleBefore(Schedulable before, Event what) {

		// check parameters
		if ((what == null)) {
			sendWarning("Can't schedule entity! Command ignored.", "Entity : "
					+ getName()
					+ " Method: scheduleBefore(Schedulable before, "
					+ "Entity who)",
					"The event given as parameter is a null reference.",
					"Be sure to have a valid Event reference before calling "
							+ "this method.");
			return; // no proper parameter
		}

		if ((before == null)) {
			sendWarning("Can't schedule entity! Command ignored.", "Entity : "
					+ getName()
					+ " Method: scheduleBefore(Schedulable before, "
					+ "Entity who)",
					"The schedulable given as parameter is a null reference.",
					"Be sure to have a valid schedulable reference for this "
							+ "entity to be scheduled with.");
			return; // no proper parameter
		}

		if (!before.isScheduled()) {
			sendWarning(
					"Can't schedule entity! Command ignored.",
					"Entity : " + getName()
							+ " Method: scheduleBefore(Schedulable before, "
							+ "Entity who)",
					"The schedulable given as parameter is not scheduled, "
							+ "thus no position can be determined for this entity.",
					"Be sure that the schedulable given as aprameter is "
							+ "actually scheduled. You can check that by calling its "
							+ "method isScheduled() which returns a boolean telling"
							+ "you whether it is scheduled or not.");
			return; // no proper parameter
		}

		if (isScheduled()) {
			sendWarning(
					"Can't schedule entity! Command ignored.",
					"Entity : "
							+ getName()
							+ " Method: scheduleBefore(Schedulable before, Entity who)",
					"This entity is already scheduled.",
					"Use method reSchedule(TimeSpan dt) or cancel this entity "
							+ "first.");
			return; // no proper parameter
		}

		if (!isModelCompatible(what)) {
			sendWarning(
					"Can't schedule entity! Command ignored",
					"Entity : "
							+ getName()
							+ " Method: scheduleBefore(Schedulable before, Entity who)",
					"The event to be scheduled with thisentity is not "
							+ "modelcompatible.",
					"Make sure to use compatible model components only.");
			return; // was already scheduled
		}

		if (currentlySendTraceNotes()) {
			if (this == currentEntity()) {
				sendTraceNote("schedules '" + what.getName()
						+ "' of itself before '" + before.getName() + "' at "
						+ before.getEventNote().getTime().toString());
			} else {
				sendTraceNote("schedules '" + what.getName() + "' of '"
						+ getName() + "' before '" + before.getName() + "' at "
						+ before.getEventNote().getTime().toString());
			}
		}

		getModel().getExperiment().getScheduler().scheduleBefore(before, this,
				what);

		if (currentlySendDebugNotes()) {
			sendDebugNote("scheduleBefore " + before.getQuotedName()
					+ " on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

	}

	/**
	 * Sets the entity's priority to a given integer value. An entity's priority
	 * defines its position inside queues, when an entity enters any DESMO-J
	 * construction relying on queues. The entity with highest priority is
	 * always entered at the queue's first position. Entities with lower
	 * priority are enqueued behind entities with higher priority. Entities with
	 * same priority are enqueued following the FiFo strategy. Zero is default
	 * priority. Negative priorities are lower, positive priorities are higher.
	 * All values should be inside the range defined by Java's integral
	 * <code>integer</code> data type. [-2147483648, +2147483648]
	 * 
	 * @param newPriority
	 *            int : The new priority value
	 */
	public void setPriority(int newPriority) {

		// check if this Entity is already enqueued in some queue with its old
		// priority
		if (numQueues() > 0) {
			sendWarning(
					"The priority of Entity "
							+ getQuotedName()
							+ "is changed. "
							+ "But this Entity is enqueued already in some queue according to its' "
							+ "old priority.",
					getClass().getName() + ": " + getQuotedName()
							+ ", Method: "
							+ "void setPriority (int newPriority)",
					"The priority of this Entity is changing from "
							+ myPriority
							+ "to "
							+ newPriority
							+ "but not its position in the queue(s) it is enqueued.",
					"Be aware that the position of this Entity in the queues it is already "
							+ "enqueued in will remain unchanged. To check whether this Entity is "
							+ "enqueued in some queue use the method <code>numQueues()</code>.");
		}

		this.myPriority = newPriority;

	}
}