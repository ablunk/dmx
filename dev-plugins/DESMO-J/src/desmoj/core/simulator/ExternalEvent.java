package desmoj.core.simulator;

/**
 * Provides the basic frame for user defined events. Derive from this class to
 * design special external events for a model. To use external events, always
 * create a new object of this class.
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
public abstract class ExternalEvent extends Event<Entity> {
	/**
	 * Creates an external event for the given model with the given name and the
	 * specified tracemode.
	 * 
	 * @param owner
	 *            Model : The external event's model
	 * @param name
	 *            java.lang.String : The external event's name
	 * @param showInTrace
	 *            boolean : Flag for showing this external event in
	 *            tracemessages
	 */
	public ExternalEvent(Model owner, String name, boolean showInTrace) {

		super(owner, name, showInTrace);

	}

	/**
	 * Implement this method to express the semantics of this external event.
	 * External events are supposed to act on the model or experiment in
	 * general. They are not related to a special entity (unlike method
	 * <code>eventRoutine(Entity who)</code> of class <code>Event</code>).
	 * Override this method to implement this ExternalEvent's behaviour.
	 */
	public abstract void eventRoutine();

	/**
	 * Do not use this method to implement the external event's eventRoutine!
	 * This method can not be hidden due to the inheritance relationship to the
	 * class <code>Event</code>. Since external events are designed to act on
	 * the model or experiment in general and are not associated to an
	 * individual entity, you should use the parameterless method
	 * <code>void eventRoutine()</code> instead. Calling this method will result
	 * in a warning message and the parameterless method will be called. The
	 * given entity will not be changed. Do not override this method in your
	 * special external events!
	 * 
	 * @see ExternalEvent#eventRoutine()
	 */
	public void eventRoutine(Entity who) {

		// send warning only if call was intended to be non-ExternalEvent
		// if null was given, it was intended to be an ExternalEvent
		if (who != null) {
			sendWarning("Can't accept entity as parameter", "ExternalEvent : "
					+ getName() + " Method: void eventRoutine(Entity who)",
					"External events do not act on entities.",
					"If you want an event to act on the given entity use the "
							+ "class Event and override the"
							+ "eventRoutine(Entity who) method in that class.");
		}

		eventRoutine();

	}

	/**
	 * Schedules this external event to make the desired changes to the
	 * experiment or model at the current point of time plus the given span of
	 * time
	 * 
	 * @param dt
	 *            TimeSpan : The offset to the current simulation time at which
	 *            this external event is to be scheduled
	 * @see SimClock
	 */
	public void schedule(TimeSpan dt) {
		if ((dt == null)) {
			sendWarning("Can't schedule external event!", "ExternalEvent : "
					+ getName() + " Method: schedule(Entity who, TimeSpan dt)",
					"The simulation time given as parameter is a null "
							+ "reference.",
					"Be sure to have a valid TimeSpan reference before calling "
							+ "this method.");
			return; // no proper parameter
		}

		if (isScheduled()) {
			sendWarning("Can't schedule external event! Command ignored.",
					"ExternalEvent : " + getName()
							+ " Method: schedule(Entity wo, TimeSpan dt)",
					"The external event to be scheduled is already scheduled.",
					"Use external events only once, do not reuse them "
							+ "multiple times.");
			return; // was already scheduled
		}

		if (currentlySendTraceNotes()) {
			sendTraceNote("ExternalEvent '" + getName() + "' scheduled at "
					+ TimeOperations.add(presentTime(), dt).toString());
			// getModel().getExperiment().getTimeFloats()));
		}

		getModel().getExperiment().getScheduler().schedule(null, this, dt);

		if (currentlySendDebugNotes()) {
			sendDebugNote("schedules on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}
	}

	/**
	 * Schedules this external event to make the desired changes to the
	 * experiment or model at the specified point in simulation time.
	 * 
	 * @param when
	 *            TimeInstant : The point in simulation time this external event
	 *            is scheduled to happen.
	 * @see SimClock
	 */
	public void schedule(TimeInstant when) {
		if ((when == null)) {
			sendWarning("Can't schedule external event!", "ExternalEvent : "
					+ getName()
					+ " Method: schedule(Entity who, TimeInstant when)",
					"The point of simulation time given as parameter is a null "
							+ "reference.",
					"Be sure to have a valid TimeInstant reference before calling "
							+ "this method.");
			return; // no proper parameter
		}

		if (isScheduled()) {
			sendWarning("Can't schedule external event! Command ignored.",
					"ExternalEvent : " + getName()
							+ " Method: schedule(Entity wo, TimeInstant when)",
					"The external event to be scheduled is already scheduled.",
					"Use external events only once, do not reuse them "
							+ "multiple times.");
			return; // was already scheduled
		}

		if (currentlySendTraceNotes()) {
			sendTraceNote("ExternalEvent '" + getName() + "' scheduled at "
					+ when.toString());
		}

		getModel().getExperiment().getScheduler().schedule(null, this, when);

		if (currentlySendDebugNotes()) {
			sendDebugNote("schedules on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}
	}

	/**
	 * @deprecated Replaced by schedule(TimeSpan dt).Schedules this external
	 *             event to make the desired changes to the experiment or model
	 *             at the specified point in simulation time. The point of time
	 *             is given as an offset to the current simulation time as
	 *             displayed by the simclock.
	 * 
	 * @param dt
	 *            SimTime : The offset to the current simulation time this event
	 *            is to happen
	 * @see SimClock
	 */
	@Deprecated
	public void schedule(SimTime dt) {
		schedule(SimTime.toTimeSpan(dt));
	}

	/**
	 * Schedules this external event to act on the experiment or model state
	 * directly after the given schedulable is already set to be activated. Note
	 * that this external event's point of simulation time will be set to be the
	 * same as the schedulable's time. Thus this external event will occur
	 * directly after the given schedulable but the simulation clock will not
	 * change. Make sure that the schedulable given as parameter is actually
	 * scheduled.
	 * 
	 * @param before
	 *            Schedulable : The schedulable this external event should be
	 *            scheduled after
	 */
	public void scheduleAfter(Schedulable after) {

		if ((after == null)) {
			sendWarning("Can't schedule external event! Command ignored.",
					"ExternalEvent : " + getName()
							+ " Method: scheduleAfter(Schedulable after, "
							+ "Entity who)",
					"The schedulable given as parameter is a null reference.",
					"Be sure to have a valid schedulable reference for this "
							+ "external event to be scheduled with.");
			return; // no proper parameter
		}

		if (isScheduled()) {
			sendWarning("Can't schedule external event! Command ignored.",
					"ExternalEvent : " + getName()
							+ " Method: scheduleAfter(Schedulable after)",
					"The external event to be scheduled is already scheduled.",
					"Use method external events only once, do not use them "
							+ "multiple times.");
			return; // was already scheduled
		}

		if (!after.isScheduled()) {
			sendWarning(
					"Can't schedule external event! Command ignored.",
					"ExternalEvent : " + getName()
							+ " Method: scheduleAfter(Schedulable after)",
					"The schedulable '"
							+ after.getName()
							+ "' given as a positioning "
							+ "reference has to be already scheduled but is not.",
					"Use method isScheduled() of any schedulable to find out "
							+ "if it is already scheduled.");
			return; // was not scheduled
		}

		if (currentlySendTraceNotes()) {
			sendTraceNote("External event '" + getName()
					+ "' scheduled after '" + after.getName() + "' at "
					+ after.getEventNote().getTime().toString());
		}

		getModel().getExperiment().getScheduler().scheduleAfter(after, null,
				this);

		if (currentlySendDebugNotes()) {
			sendDebugNote("scheduleAfter " + after.getQuotedName()
					+ " on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

	}

	/**
	 * Schedules this external event to act on the experiment or model state
	 * directly before the given schedulable is already set to be activated.
	 * Note that this external event's point of simulation time will be set to
	 * be the same as the schedulable's time. Thus this external event will
	 * occur directly before the given schedulable but the simulation clock will
	 * not change. Make sure that the schedulable given as parameter is actually
	 * scheduled.
	 * 
	 * @param before
	 *            Schedulable : The schedulable this external event should be
	 *            scheduled before
	 */
	public void scheduleBefore(Schedulable before) {

		if ((before == null)) {
			sendWarning("Can't schedule external event! Command ignored.",
					"ExternalEvent : " + getName()
							+ " Method: scheduleBefore(Schedulable before, "
							+ "Entity who)",
					"The schedulable given as parameter is a null reference.",
					"Be sure to have a valid schedulable reference for this "
							+ "external event to be scheduled with.");
			return; // no proper parameter
		}

		if (isScheduled()) {
			sendWarning("Can't schedule external event! Command ignored.",
					"ExternalEvent : " + getName()
							+ " Method: scheduleBefore(Schedulable before)",
					"The external event to be scheduled is already scheduled.",
					"Use method external events only once, do not use them "
							+ "multiple times.");
			return; // was already scheduled
		}

		if (!before.isScheduled()) {
			sendWarning("Can't schedule external event! Command ignored.",
					"ExternalEvent : " + getName()
							+ " Method: scheduleBefore(Schedulable before)",
					"The schedulable '" + before.getName() + "' given as a "
							+ "positioning reference has to be already "
							+ "scheduled but is not.",
					"Use method isScheduled() of any schedulable to find out "
							+ "if it is already scheduled.");
			return; // was not scheduled
		}

		if (currentlySendTraceNotes()) {
			sendTraceNote("External event '" + getName()
					+ "' scheduled before '" + before.getName() + "' at "
					+ before.getEventNote().getTime().toString());
		}

		getModel().getExperiment().getScheduler().scheduleBefore(before, null,
				this);

		if (currentlySendDebugNotes()) {
			sendDebugNote("scheduleBefore " + before.getQuotedName()
					+ " on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

	}
}