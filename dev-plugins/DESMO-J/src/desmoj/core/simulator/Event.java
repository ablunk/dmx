package desmoj.core.simulator;

/**
 * Provides the superclass for user defined events to change an entity's
 * internal state. The state of a discrete model is changed by events that occur
 * at distinct points of simulation time.
 * <p>
 * An event only acts on one entity, changing its state according to the
 * entity's reaction to the specific event in the system under inspection. So
 * each type of event acting on one certain type of entity requires a new
 * subclass to be derived from this class. Since events are associated to a
 * single Entity, the method executing the changes of state of a specific entity
 * gets that entity passed as a parameter. The scheduler takes care that this is
 * done at the specified point of simulation time.
 * <p>
 * For type safety it is recommended to generically assign the entity type an
 * event operates on by using the generic type
 * <code>Event&lt;EntityOperatingOn&gt;</code> where
 * <code>EntityOperatingOn</code> is derived from <code>Entity</code>.
 * <p>
 * Events should be used one time only. They are created to be scheduled
 * together with a specific entity, change that entity's state at the scheduled
 * point of simulation time and are destroyed by Java's garbage collector after
 * use. They could be reused but at a certain risk of inconsistent states. Since
 * each object of a class that is derived from the class
 * <code>Schedulable</code> has its unique identification number added as a
 * suffix to its name, reusing Event objects would make one Event responsible
 * for several distinct changes in a model at different simulation times. This
 * comes with the danger of of confusing the model's trace and making it more
 * difficult to debug a faulty model implementation. Each type of Event needed
 * for a model requires a new subclass of Event to be derived by the user.
 * <p>
 * Embed the changes of state for the specific entity associated with this event
 * by overriding the abstract method <code>eventRoutine(Entity e)</code>. Events
 * that do not manipulate a single entity but act on the model's state on a more
 * general matter are defined by external events, a subclass of this class.
 * 
 * @see Entity
 * @see ExternalEvent
 * @see TimeInstant
 * @see TimeSpan
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
public abstract class Event<E extends Entity> extends Schedulable {

	/**
	 * The realTime deadline for this event in nanoseconds. In case of a
	 * real-time execution (i. e. the execution speed rate is set to a positive
	 * value) the Scheduler will produce a warning message if a deadline is
	 * missed.
	 */
	private long realTimeConstraint;

	/**
	 * Creates a new event of the given model, with the given name and trace
	 * option.
	 * 
	 * @param name
	 *            java.lang.String : The name of this event
	 * @param owner
	 *            Model : The model this event is associated to
	 * @param showInTrace
	 *            boolean : Flag for showing event in trace-files. Set it to
	 *            <code>true</code> if event should show up in trace. Set it to
	 *            <code>false</code> if event should not be shown in trace.
	 */
	public Event(Model owner, String name, boolean showInTrace) {

		super(owner, name, showInTrace);

	}

	/**
	 * Implement this abstract method to express the changes of state this event
	 * does to a single entity. This event is related to the entity it has been
	 * scheduled with. That entity is given note that since class
	 * <code>SimProcess</code> inherits from class <code>Entity</code>, an event
	 * can also be given a process to operate on. In this case, the process is
	 * scheduled and manipulated by this event just like an entity.
	 * <p>
	 * For type safety, it is recommended to derive your events from the generic
	 * type <code>Event&lt;EntityOperatingOn&gt;</code> where
	 * <code>EntityOperatingOn</code> (which is derived from class
	 * <code>Entity</code>) represents the entity type your event is supposed to
	 * operate on.
	 * <p>
	 * Should you decide to derive your event from the raw type
	 * <code>Event</code> (which is not recommended), please take extra care in
	 * checking the given entity parameter to your special eventRoutine since
	 * any subtype of entity will be accepted! If your model uses several
	 * different entity types, chances are that while developing the model,
	 * wrong entity types might be passed. If your IDE does not support
	 * debugging, use following lines at the beginning of each
	 * <code>EventRoutine</code> to check for proper types. Checking types in
	 * java is easily done by using the <code>instanceof</code> operator as i.e.
	 * in :
	 * <p>
	 * 
	 * <pre>
	 * &lt;code&gt;
	 * if (!(who instanceof MySpecialEntityClass)) {
	 * 	return; // not correct type, so this method won't do anything about it
	 * }
	 * &lt;/code&gt;
	 * </pre>
	 * 
	 * @param who
	 *            Entity : The entity associated to this event. In case you have
	 *            derived a subclass from the raw class Event, do not forget to
	 *            cast its type when accessing special attributes of derived
	 *            entities.
	 */
	public abstract void eventRoutine(E who);

	/**Returns the realTime deadline for this event (in nanoseconds). In case of a
	 * real-time execution (i. e. the execution speed rate is set to a positive
	 * value) the Scheduler will produce a warning message if a deadline is
	 * missed.
	 * 
	 * @return the realTimeConstraint in nanoseconds
	 */
	public long getRealTimeConstraint() {
		return realTimeConstraint;
	}
	
	/**
	 * Tests if this event actually is an external event which is not used for
	 * modelling but to control the experiment to act at certain points of
	 * simulation time. External events must not be connected to an entity.
	 * 
	 * @return boolean : Is <code>true</code> if this is an instance of class
	 *         <code>ExternalEvent</code>,<code>false</code> otherwise
	 */
	public boolean isExternal() {

		return (this instanceof ExternalEvent);

	}

	public void schedule(E who, TimeInstant instant) {

		if ((instant == null)) {
			sendWarning("Can't schedule event!", "Event : " + getName()
					+ " Method: schedule(Entity who, TimeInstant instant)",
					"The TimeInstant given as parameter is a null reference.",
					"Be sure to have a valid TimeInstant reference before calling "
							+ "this method.");
			return; // no proper parameter
		}

		if ((who == null)) {
			sendWarning("Can't schedule event!", "Event : " + getName()
					+ " Method: schedule(Entity who, TimeInstant instant)",
					"The Entity given as parameter is a null reference.",
					"Be sure to have a valid Entity reference for this event to "
							+ "be scheduled with.");
			return; // no proper parameter
		}

		if (isScheduled()) {
			sendWarning("Can't schedule event! Command ignored.", "Event : "
					+ getName()
					+ " Method: schedule(Entity wo, TimeInstant instant)",
					"The event to be scheduled is already scheduled.",
					"Use method events only once, do not use them multiple "
							+ "times.");
			return; // was already scheduled
		}

		if (who.isScheduled()) {
			sendWarning("Can't schedule event! Command ignored.", "Entity : "
					+ getName()
					+ " Method: schedule(Entity who, TimeInstant instant)",
					"The Entity '" + who.getName()
							+ "'to be scheduled with this "
							+ "event is already scheduled.",
					"Use method reSchedule(TimeInstant instant) to shift the Entity "
							+ "to be scheduled at some other point of time.");
			return; // was already scheduled
		}

		if (!isModelCompatible(who)) {
			sendWarning("Can't schedule event! Command ignored", "Entity : "
					+ getName()
					+ " Method: schedule(Entity who, TimeInstant instant)",
					"The Entity to be scheduled with this event is not "
							+ "modelcompatible.",
					"Make sure to use compatible model components only.");
			return; // is not compatible
		}

		if (currentlySendTraceNotes()) {
			if (who == currentEntity()) {
				if (TimeInstant.isEqual(instant, presentTime()))
					sendTraceNote("schedules '" + getName() + "' of itself now");
				else
					sendTraceNote("schedules '" + getName() + "' of itself at "
							+ instant.toString());

			} else {
				if (TimeInstant.isEqual(instant, presentTime()))
					sendTraceNote("schedules '" + getName() + "' of '"
							+ who.getName() + "' now");
				else
					sendTraceNote("schedules '" + getName() + "' of '"
							+ who.getName() + "' at " + instant.toString());
			}
		}

		getModel().getExperiment().getScheduler().schedule(who, this, instant);

		if (currentlySendDebugNotes()) {
			sendDebugNote("schedules on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

	}

	/**
	 * Schedules this event to act on the given entity at the specified point in
	 * simulation time. The point of time is given as an offset to the current
	 * simulation time as displayed by the simulation clock.
	 * 
	 * @param who
	 *            Entity : The entity this event happens to
	 * @param dt
	 *            TimeSpan : The offset to the current simulation time this
	 *            event is to happen
	 * @see SimClock
	 */
	public void schedule(E who, TimeSpan dt) {
		if ((dt == null)) {
			sendWarning("Can't schedule event!", "Event : " + getName()
					+ " Method: schedule(Entity who, TimeSpan dt)",
					"The TimeSpan given as parameter is a null reference.",
					"Be sure to have a valid TimeSpan reference before calling "
							+ "this method.");
			return; // no proper parameter
		}

		if ((who == null)) {
			sendWarning("Can't schedule event!", "Event : " + getName()
					+ " Method: schedule(Entity who, TimeSpan dt)",
					"The Entity given as parameter is a null reference.",
					"Be sure to have a valid Entity reference for this event to "
							+ "be scheduled with.");
			return; // no proper parameter
		}

		if (isScheduled()) {
			sendWarning("Can't schedule event! Command ignored.", "Event : "
					+ getName() + " Method: schedule(Entity wo, TimeSpan dt)",
					"The event to be scheduled is already scheduled.",
					"Use method events only once, do not use them multiple "
							+ "times.");
			return; // was already scheduled
		}

		if (who.isScheduled()) {
			sendWarning("Can't schedule event! Command ignored.", "Entity : "
					+ getName() + " Method: schedule(Entity who, TimeSpan dt)",
					"The Entity '" + who.getName()
							+ "'to be scheduled with this "
							+ "event is already scheduled.",
					"Use method reSchedule(TimeSpan dt) to shift the Entity "
							+ "to be scheduled at some other point of time.");
			return; // was already scheduled
		}

		if (!isModelCompatible(who)) {
			sendWarning("Can't schedule event! Command ignored", "Entity : "
					+ getName() + " Method: schedule(Entity who, TimeSpan dt)",
					"The Entity to be scheduled with this event is not "
							+ "modelcompatible.",
					"Make sure to use compatible model components only.");
			return; // is not compatible
		}

		if (currentlySendTraceNotes()) {
			if (who == currentEntity()) {
				if (dt == TimeSpan.ZERO)
					sendTraceNote("schedules '" + getName() + "' of itself now");
				else
					sendTraceNote("schedules '" + getName() + "' of itself at "
							+ TimeOperations.add(presentTime(), dt).toString());

			} else {
				if (dt == TimeSpan.ZERO)
					sendTraceNote("schedules '" + getName() + "' of '"
							+ who.getName() + "' now");
				else
					sendTraceNote("schedules '" + getName() + "' of '"
							+ who.getName() + "' at "
							+ TimeOperations.add(presentTime(), dt).toString());
			}
		}

		getModel().getExperiment().getScheduler().schedule(who, this, dt);

		if (currentlySendDebugNotes()) {
			sendDebugNote("schedules on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

	}

	/**
	 * @deprecated Replaced by schedule(E who,TimeSpan dt). Schedules this event
	 *             to act on the given entity at the specified point in
	 *             simulation time. The point of time is given as an offset to
	 *             the current simulation time as displayed by the simulation
	 *             clock.
	 * 
	 * @param who
	 *            Entity : The entity this event happens to
	 * @param dt
	 *            SimTime : The offset to the current simulation time this event
	 *            is to happen
	 * @see SimClock
	 */
	@Deprecated
	public void schedule(E who, SimTime dt) {
		schedule(who, SimTime.toTimeSpan(dt));
	}

	/**
	 * Schedules this event to act on the given entity directly after the given
	 * schedulable is already set to be activated. Note that this event's point
	 * of simulation time will be set to be the same as the schedulable's time.
	 * Thus this event will occur directly after the given schedulable but the
	 * simulation clock will not change. Make sure that the schedulable given as
	 * parameter is actually scheduled.
	 * 
	 * @param before
	 *            Schedulable : The schedulable this entity should be scheduled
	 *            after
	 * @param what
	 *            Entity : The entity to be manipulated by this event
	 */
	public void scheduleAfter(Schedulable after, E who) {

		if (who == null) {
			sendWarning("Can't schedule event! Command ignored.", "Event : "
					+ getName() + " Method: scheduleAfter(Schedulable after, "
					+ "Entity who)",
					"The entity 'who' given as parameter is a null reference.",
					"Be sure to have a valid entity reference before calling "
							+ "this method.");
			return; // no proper parameter
		}

		if (after == null) {
			sendWarning("Can't schedule event! Command ignored.", "Event : "
					+ getName() + " Method: scheduleAfter(Schedulable after, "
					+ "Entity who)",
					"The schedulable given as parameter is a null reference.",
					"Be sure to have a valid schedulable reference for this "
							+ "event to be scheduled with.");
			return; // no proper parameter
		}

		if (isScheduled()) {
			sendWarning("Can't schedule event! Command ignored.", "Event : "
					+ getName() + " Method: scheduleAfter(Schedulable after, "
					+ "Entity who)",
					"The event to be scheduled is already scheduled.",
					"Use method events only once, do not use them multiple "
							+ "times.");
			return; // was already scheduled
		}

		if (who.isScheduled()) {
			sendWarning("Can't schedule event! Command ignored.", "Entity : "
					+ getName() + " Method: scheduleAfter(Schedulable after, "
					+ "Entity who)", "The entity '" + who.getName()
					+ "'to be scheduled with this "
					+ "event is already scheduled.",
					"Use method reSchedule(TimeSpan dt) to shift the Entity "
							+ "to be scheduled at some other point of time.");
			return; // was already scheduled
		}

		if (!after.isScheduled()) {
			sendWarning("Can't schedule event! Command ignored.", "Event : "
					+ getName() + " Method: scheduleAfter(Schedulable after, "
					+ "Entity who)", "The schedulable '" + who.getName()
					+ "' given as a positioning "
					+ "reference has to be already scheduled but is not.",
					"Use method isScheduled() of any schedulable to find out "
							+ "if it is already scheduled.");
			return; // was not scheduled
		}

		if (!isModelCompatible(who)) {
			sendWarning("Can't schedule event! Command ignored", "Entity : "
					+ getName() + " Method: scheduleAfter(Schedulable after, "
					+ "Entity who)",
					"The entity to be scheduled with this event is not "
							+ "modelcompatible.",
					"Make sure to use compatible model components only.");
			return; // is not compatible
		}

		if (currentlySendTraceNotes()) {
			if (who == currentEntity()) {
				sendTraceNote("schedules '" + getName() + "' of itself after '"
						+ after.getName() + "' at "
						+ after.getEventNote().getTime().toString());

			} else {
				sendTraceNote("schedules '" + getName() + "' of '"
						+ who.getName() + "' after '" + after.getName()
						+ "' at " + after.getEventNote().getTime().toString());
			}
		}

		getModel().getExperiment().getScheduler().scheduleAfter(after, who,
				this);

		if (currentlySendDebugNotes()) {
			sendDebugNote("scheduleAfter " + after.getQuotedName()
					+ " on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

	}

	/**
	 * Schedules this event to act on the given entity directly before the given
	 * schedulable is already set to be activated. Note that this event's point
	 * of simulation time will be set to be the same as the schedulable's time.
	 * Thus this event will occur directly before the given schedulable but the
	 * simulation clock will not change. Make sure that the schedulable given as
	 * parameter is actually scheduled.
	 * 
	 * @param before
	 *            Schedulable : The schedulable this entity should be scheduled
	 *            before
	 * @param what
	 *            Entity : The entity to be manipulated by this event
	 */
	public void scheduleBefore(Schedulable before, E who) {

		if ((who == null)) {
			sendWarning("Can't schedule event! Command ignored.", "Event : "
					+ getName()
					+ " Method: scheduleBefore(Schedulable before, "
					+ "Entity who)",
					"The entity given as parameter is a null reference.",
					"Be sure to have a valid Entity reference before calling "
							+ "this method.");
			return; // no proper parameter
		}

		if ((before == null)) {
			sendWarning("Can't schedule event! Command ignored.", "Event : "
					+ getName()
					+ " Method: scheduleBefore(Schedulable before, "
					+ "Entity who)",
					"The schedulable given as parameter is a null reference.",
					"Be sure to have a valid schedulable reference for this "
							+ "event to be scheduled with.");
			return; // no proper parameter
		}

		if (isScheduled()) {
			sendWarning("Can't schedule event! Command ignored.", "Event : "
					+ getName()
					+ " Method: scheduleBefore(Schedulable before, "
					+ "Entity who)",
					"The event to be scheduled is already scheduled.",
					"Use method events only once, do not use them multiple "
							+ "times.");
			return; // was already scheduled
		}

		if (who.isScheduled()) {
			sendWarning("Can't schedule event! Command ignored.", "Event : "
					+ getName()
					+ " Method: scheduleBefore(Schedulable before, "
					+ "Entity who)", "The entity '" + who.getName()
					+ "'to be scheduled with this "
					+ "event is already scheduled.",
					"Use method reSchedule(TimeSpan dt) to shift the entity "
							+ "to be scheduled at some other point of time.");
			return; // was already scheduled
		}

		if (!before.isScheduled()) {
			sendWarning("Can't schedule event! Command ignored.", "Event : "
					+ getName() + " Method: scheduleBefore(Schedulable after, "
					+ "Entity who)", "The schedulable '" + before.getName()
					+ "' given as a "
					+ "positioning reference has to be already scheduled but "
					+ "is not.",
					"Use method isScheduled() of any schedulable to find out "
							+ "if it is already scheduled.");
			return; // was not scheduled
		}

		if (!isModelCompatible(who)) {
			sendWarning("Can't schedule event! Command ignored", "Event : "
					+ getName()
					+ " Method: scheduleBeforer(Schedulable before, "
					+ "Entity who)",
					"The entity to be scheduled with this event is not "
							+ "modelcompatible.",
					"Make sure to use compatible model components only.");
			return; // is not compatible
		}

		if (currentlySendTraceNotes()) {
			if (who == currentEntity()) {
				sendTraceNote("schedules '" + getName()
						+ "' of itself before '" + before.getName() + "' at "
						+ before.getEventNote().getTime().toString());
			} else {
				sendTraceNote("schedules '" + getName() + "' of '"
						+ who.getName() + "' before '" + before.getName()
						+ "' at " + before.getEventNote().getTime().toString());
			}
		}

		getModel().getExperiment().getScheduler().scheduleBefore(before, who,
				this);

		if (currentlySendDebugNotes()) {
			sendDebugNote("scheduleBefore " + before.getQuotedName()
					+ " on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

	}
	
	/**Sets the realTime deadline for this event (in nanoseconds). In case of a
	 * real-time execution (i. e. the execution speed rate is set to a positive
	 * value) the Scheduler will produce a warning message if a deadline is
	 * missed.
	 * 
	 * @param realTimeConstraint the realTimeConstraint in nanoseconds to set
	 */
	public void setRealTimeConstraint(long realTimeConstraint) {
		this.realTimeConstraint = realTimeConstraint;
	}
}