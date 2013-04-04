package desmoj.core.report;

import desmoj.core.simulator.Entity;
import desmoj.core.simulator.Event;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.TimeInstant;

/**
 * Represents a message produced by a simulation run whenever entities and / or
 * events are scheduled, created, deleted or enqueued. Tracenotes document the
 * changes of state of the model and allow modellers to trace and check the
 * model's dynamic behaviour. The basic information needed to trace a model's
 * changes of state are:
 * <ul>
 * <li>The name of the Model this message was produced in</li>
 * <li>The point of simulation time that this message was created</li>
 * <li>The name of the event involved in the change of state</li>
 * <li>The name of the entity or process involved in the change of state</li>
 * <li>A text to describe the kind of changes made to the model</li>
 * </ul>
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
public class TraceNote extends Message {

	/**
	 * The current entity that produced this message.
	 */
	private String who;

	/**
	 * The current event that produced this message. is especially useful when
	 * using multiple models.
	 */
	private String what;

	/**
	 * Creates a new tracenote with the given parameters as initial values. If
	 * <code>null</code> references are given, they are displayed as "----" in
	 * the trace output.
	 * 
	 * @param origin
	 *            Model : The model that produced this tracenote
	 * @param description
	 *            java.lang.String : The actual trace message
	 * @param messageTime
	 *            TimeInstant : The point in simulation time this tracenote was
	 *            produced
	 * @param entityInvolved
	 *            Event : The entity involved in this change of state
	 * @param eventInvolved
	 *            Entity : The event involved in this change of state
	 */
	//TODO:
	public TraceNote(Model origin, String message, TimeInstant time,
			Entity entityInvolved, Event eventInvolved) {

		super(origin, message, time);

		if (entityInvolved == null)
			who = "----";
		else
			who = entityInvolved.getName();

		if (eventInvolved == null)
			what = "----";
		else
			what = eventInvolved.getName();

	}

	/**
	 * Returns the name of the entity this tracenote evolved from.
	 * 
	 * @return java.lang.String : The name of the entity that produced this
	 *         tracenote
	 */
	public String getEntity() {

		return who;

	}

	/**
	 * Returns the name of the event described in this tracenote from.
	 * 
	 * @return java.lang.String : The name of the event that produced this
	 *         tracenote
	 */
	public String getEvent() {

		return what;

	}
}