package desmoj.core.simulator;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import desmoj.core.report.DebugNote;

/**
 * The scheduler is the main element controlling the run of a simulation. It
 * controls the event-list in which all scheduled events are stored, picks the
 * next event to be processed and advances the simulation clock accordingly.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Tim Lechler, modified by Ruth Meyer
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
public class Scheduler extends NamedObject {

	/**
	 * The experiment this scheduler serves.
	 */
	protected Experiment myExperiment;

	/**
	 * The actual simulation clock for this scheduler.
	 */
	protected SimClock clock;

	/**
	 * The event-list used by the scheduler.
	 */
	protected EventList evList;

	/**
	 * Flag to indicate wether the current simulation is running or stopped. If
	 * true, the simulation is stopped, if false, the simulation is still
	 * running. This flag is especially polled by processes exiting any
	 * synchronized method used for passivating the process thus giving control
	 * back to the scheduler.
	 */
	protected boolean simulationFinished;

	/**
	 * Contains the eventnote used by the current schedulables.
	 */
	private EventNote currentNote;

	/**
	 * Contains the current active entity.
	 */
	private Entity currentEntity;

	/**
	 * Contains the current active simprocess.
	 */
	private SimProcess currentProcess;

	/**
	 * Contains the current active event.
	 */
	private Event currentEvent;

	/**
	 * Contains the current active model.
	 */
	private Model currentModel;

	/**
	 * Contains the current active schedulable. This is either the entity or
	 * simProcess if available, or the external event, if none of the first two
	 * are available.
	 */
	private Schedulable currentSchedulable;

	/**
	 * Flag indicating if the event list will process concurrent events in
	 * random order or not. Default is not (<code>false</code>). (Modification
	 * by Ruth Meyer, 11/2001)
	 */
	private boolean randomizingConcurrentEvents = false;

	/**
	 * The execution speed rate. Default is zero (as-fast-as-possible).
	 * (Modification by Felix Klueckmann, 05/2009)
	 */
	private double executionSpeedRate = 0.0;

	/**
	 * The point in physical time (real time) of the last change of the
	 * execution speed rate (in nanoseconds). (Modification by Felix Klueckmann,
	 * 05/2009)
	 */

	private long realTimeAtResetInNanos;
	/**
	 * The point in simulation time of the last change of the execution speed
	 * rate or the last time the simulation was stopped . (Modification by Felix
	 * Klueckmann, 05/2009)
	 */

	private TimeInstant simulationTimeAtReset;

	/**
	 * Flag indicating if the the execution speed rate was changed or the
	 * experiment was stopped since the last call of processNextEventNote().
	 * (Modification by Felix Klueckmann, 05/2009)
	 */
	private boolean timeReset;

	/**
	 * Lock for process synchronisation during a realtime execution.
	 * (Modification by Felix Klueckmann, 06/2009)
	 */
	private ReentrantLock lock;

	/**
	 * The condition used for process synchronisation during a realtime
	 * execution.
	 */
	private java.util.concurrent.locks.Condition waitSynchCondition;

	/**
	 * A threadsafte consumer/producer queue to store
	 * RealTimeEventWrapper-Objects send by external systems
	 */
	private java.util.concurrent.BlockingQueue<RealTimeEventWrapper> realTimeEventQueue;

	/**
	 * Constructs a scheduler with given name and the event-list (i.e. inheritor
	 * of <code>desmoj.core.simulator.EventList</code>) to use.
	 * 
	 * @param exp
	 *            Experiment : The experiment that uses this Scheduler
	 * @param name
	 *            java.lang.String : The scheduler's name
	 * @param eventList
	 *            EventList : The event list to store scheduled events
	 */

	public Scheduler(Experiment exp, String name, EventList eventList) {

		super(name + "_scheduler"); // create a namedObject with given name
		myExperiment = exp;
		evList = eventList;
		clock = new SimClock(name); // set reference to clock
		simulationFinished = false; // set flag to "not yet finished",
		lock = new ReentrantLock();
		waitSynchCondition = lock.newCondition();
		realTimeEventQueue = new LinkedBlockingQueue<RealTimeEventWrapper>();
	}

	/**
	 * Cancels the given schedulable by removing it from the event-list and
	 * removing all associated events or entities from the eventnote.
	 * 
	 * @param s
	 *            Schedulable : The schedulable object to be removed from the
	 *            event-list
	 */
	protected void cancel(Schedulable s) {

		if (s == null) {
			myExperiment.sendWarning(
					"Can't cancel schedulable! Command ignored.",
					"Scheduler : " + getName()
							+ " Method: cancel(Schedulable s)",
					"The schedulable reference passed as parameter is a null "
							+ "reference.",
					"Always make sure to use valid references only.");
			return;
		}

		if (!s.isScheduled()) {
			myExperiment.sendWarning(
					"Can't cancel schedulable! Command ignored.",
					"Scheduler : " + getName()
							+ " Method: cancel(Schedulable s) Schedulable :"
							+ s.getName(),
					"The schedulable passed as parameter is not scheduled, thus "
							+ "can not be canceled.",
					"Cancel is valid for shceduled entities or events only.");
			return;
		}

		// get rid of EventNote and feed big ole GC
		EventNote eNote = s.getEventNote();
		evList.remove(eNote);

		// remove the Entity's ref to the EventNote
		if (eNote.getEntity() != null) {
			eNote.getEntity().removeEventNote();
		}

		// remove the Entity's ref to the EventNote
		if (eNote.getEvent() != null) {
			eNote.getEvent().removeEventNote();
		}

		eNote.setTime(null);

		// all references are set to null, now the garbage collector can
		// collect all Entities/Events without any further reference to them
		// plus the TimeInstant and EventNote

	}

	/**
	 * Returns the actual simulation time as displayed by the simulation clock.
	 * 
	 * @return TimeInstant : The current point in simulation time
	 */
	protected TimeInstant presentTime() {

		return clock.getTime();

	}

	/**
	 * Returns the current active entity. Note that this method can also return
	 * a simprocess that can be handled just like an entity since simprocess
	 * inherits from entity. Returns <code>null</code> if the current
	 * schedulable happens to be an external event or a simprocess.
	 * 
	 * @return Entity : The currently active entity or simrocess or
	 *         <code>null</code> in case of an external event or a simprocess
	 *         being the currently active schedulable
	 */
	protected Entity getCurrentEntity() {

		return currentEntity;

	}

	/**
	 * Returns the current active event or <code>null</code>. Note that this
	 * method can also return an external event that can not be handled like an
	 * event since it does not support scheduling together with an entity.
	 * Returns <code>null</code> if the current schedulable happens to be a
	 * simprocess that has been activated, thus no kind of event is associated
	 * with it.
	 * 
	 * @return Event : The currently active event or external event or
	 *         <code>null</code> if the current schedulable happens to be an
	 *         activated simprocess
	 */
	protected Event getCurrentEvent() {

		return currentEvent;

	}

	/**
	 * Returns the currently active model.
	 * 
	 * @return Model : The currently active model or <code>null</code> in case
	 *         of no model being connected so far.
	 */
	protected Model getCurrentModel() {

		return currentModel;

	}

	/**
	 * Returns the currently active schedulable object. This can be any of its
	 * subtypes entity, simprocess or external event in that order.
	 * 
	 * @return Schedulable : The currently active schedulable
	 * @see Entity
	 * @see SimProcess
	 * @see ExternalEvent
	 */
	protected Schedulable getCurrentSchedulable() {

		return currentSchedulable;

	}

	/**
	 * Returns the current simprocess. Note that this method can only return a
	 * simprocess. If the currently active schedulable is not instance of
	 * simprocess or an external event, <code>null</code> is returned.
	 * 
	 * @return SimProcess : The currently active simprocess or <code>null</code>
	 */
	public SimProcess getCurrentSimProcess() {

		return currentProcess;

	}

	/**
	 * Returns the current execution Speed Rate.
	 * 
	 * @return double : The current execution speed rate.
	 */
	protected double getExecutionSpeedRate() {
		return executionSpeedRate;
	}

	/**
	 * Returns the next following scheduled entity on the event-list relative to
	 * the given schedulable object. If any entity is connected to the found
	 * eventnote it will be returned. If no entity is present, the associated
	 * event must be an external event and <code>null</code> is returned. If the
	 * given schedulable is the currently active schedulable, the entity of the
	 * first eventnote of the event-list will be returned. Again, this could be
	 * <code>null</code> in the case of an external event.
	 * 
	 * @return Entity : The next entity following this schedulable object on the
	 *         event-list or <code>null</code>
	 */
	protected Entity getNextEntity(Schedulable origin) {

		if (origin == null) {
			myExperiment.sendWarning(
					"Can't return next entity! Command ignored.",
					"Scheduler : " + getName()
							+ " Method: getNextEntity (Schedulable origin)",
					"The schedulable reference passed as parameter is a null "
							+ "reference.",
					"Always make sure to use valid references only.");
			return null;
		}

		if (!origin.isScheduled()) {
			myExperiment.sendWarning(
					"Can't return next entity! Command ignored.",
					"Scheduler : " + getName()
							+ " Method: getNextEntity (Schedulable origin) "
							+ "Schedulable : " + origin.getName(),
					"The schedulable passed as parameter is not scheduled, thus "
							+ "can not be canceled.",
					"Cancel is valid for shceduled entities or events only.");
			return null; // can't get next if o's not scheduled
		}

		EventNote bufferNote;
		// buffer needed for storing ref. to next EventNote
		if ((origin == getCurrentEntity()) || (origin == getCurrentEvent())) { // origin
			// is
			// currently
			// active?
			bufferNote = evList.firstNote();
			// get next of current =>1st in EventList
		} else {
			bufferNote = evList.nextNote(origin.getEventNote());
			// get EventNote
		}

		if (bufferNote == null) // given Schedulable was last on the EventList
			return null; // so there can't be successors
		else
			return bufferNote.getEntity(); // else return Entity

	}

	/**
	 * Returns the next following scheduled event on the event-list relative to
	 * the given schedulable object. If any event is connected to the found
	 * eventnote it will be returned. If no event is present, the associated
	 * entity must be a simprocess and <code>null</code> is returned. If the
	 * given schedulable is the currently active schedulable, the event of the
	 * first eventnote of the event-list will be returned. Again, this could be
	 * <code>null</code> in the case of a simprocess.
	 * 
	 * @return Event : The next event following this schedulable object on the
	 *         event-list
	 */
	protected Event getNextEvent(Schedulable origin) {

		if (origin == null) {
			myExperiment.sendWarning(
					"Can't return next event! Command ignored.", "Scheduler : "
							+ getName()
							+ " Method: getNextEventy (Schedulable origin)",
					"The schedulable reference passed as parameter is a null "
							+ "reference.",
					"Always make sure to use valid references only.");
			return null;
		}

		if (!origin.isScheduled()) {
			myExperiment.sendWarning(
					"Can't return next event! Command ignored.", "Scheduler : "
							+ getName()
							+ " Method: getNextEvent (Schedulable origin) "
							+ "Schedulable : " + origin.getName(),
					"The schedulable passed as parameter is not scheduled, thus "
							+ "can not be canceled.",
					"Cancel is valid for shceduled entities or events only.");
			return null; // can't get next if o's not scheduled
		}

		EventNote bufferNote;
		// buffer needed for storing ref. to next EventNote

		if ((origin == getCurrentEntity()) || (origin == getCurrentEvent())) { // origin
			// is
			// currently
			// active?
			bufferNote = evList.firstNote();
			// get next of current =>1st in EventList
		} else {
			bufferNote = evList.nextNote(origin.getEventNote());
			// get EventNote
		}

		if (bufferNote == null) // given Schedulable was last on the EventList
			return null; // so there can't be successors
		else
			return bufferNote.getEvent(); // else return Entity

	}

	/**
	 * Returns the next following scheduled entity or event on the event-list
	 * relative to this schedulable object's position on the event-list. If any
	 * object of entity or its subtypes are connected to the found eventnote it
	 * will be returned. If no sntity is present, the associated svent must be
	 * an external event that is returned instead. Should the given schedulable
	 * be the currently active, the schedulable of the first eventnote of the
	 * event-list will be returned.
	 * 
	 * @return Schedulable : The next entity or event following this schedulable
	 *         object on the event-list
	 */
	protected Schedulable getNextSchedulable(Schedulable origin) {

		if (origin == null) {
			myExperiment.sendWarning("Can't return next schedulable! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: getNextSchedulable (Schedulable origin)",
					"The schedulable reference passed as parameter is a null "
							+ "reference.",
					"Always make sure to use valid references only.");
			return null; // good reason for an exception
		}

		if (!origin.isScheduled()) {
			myExperiment
					.sendWarning(
							"Can't return next schedulable! Command ignored.",
							"Scheduler : "
									+ getName()
									+ " Method: getNextSchedulable (Schedulable origin) "
									+ "Schedulable : " + origin.getName(),
							"The schedulable passed as parameter is not scheduled, thus "
									+ "can not be canceled.",
							"Cancel is valid for shceduled entities or events only.");
			return null; // can't get next if o's not scheduled
		}

		EventNote bufferNote;
		// buffer needed for storing ref. to next EventNote

		if ((origin == getCurrentEntity()) || (origin == getCurrentEvent())) { // origin
			// is
			// currently
			// active?
			bufferNote = evList.firstNote();
			// get next of current =>1st in EventList
		} else {
			bufferNote = evList.nextNote(origin.getEventNote());
			// get EventNote
		}

		if (bufferNote == null) // given Schedulable was last on the EventList
			return null; // so there can't be successors

		if (bufferNote.getEntity() != null)
			// Schedulable means Entity if possible...
			return bufferNote.getEntity();
		else
			return bufferNote.getEvent(); // ...else the Event or
		// ExternalEvent

	}

	/**
	 * Returns the actual clock for this model.
	 * 
	 * @return SimClock : The actual clock for simulation time
	 */
	protected SimClock getSimClock() {

		return clock; // not much else to do

	}

	/**
	 * Returns if the event list processes concurrent events in random order or
	 * not.
	 * 
	 * @return boolean: <code>true</code> if concurrent events are randomized,
	 *         <code>false</code> otherwise
	 * @author Ruth Meyer
	 */
	public boolean isRandomizingConcurrentEvents() {
		return this.randomizingConcurrentEvents;
	}

	/**
	 * Preempts the currently running simprocess. Method is called whenenver
	 * another Entity or simprocess is scheduled with <code>TimeSpan.ZERO</code>
	 * or <code>presentTime()</code> as parameter for the simulation time. The
	 * current simprocess is interrupted and will be scheduled to continue its
	 * lifecycle
	 * 
	 * @param note
	 *            desmoj.EventNote - The eventnote of the Schedulable preempting
	 *            the current simprocess
	 */
	void preemptSimProcess(EventNote preemptNote) {

		if (currentProcess == null) {
			myExperiment.sendWarning("Can't preempt current simprocess! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: preemptSimProcess(EventNote preemptNote)",
					"The eventnote reference passed as parameter is a null "
							+ "reference.",
					"Always make sure to use valid references only.");
			return; // preemption of currentprocess only
		}

		preemptNote.setTime(presentTime());

		EventNote currentNote = new EventNote(currentProcess, null,
				presentTime());

		evList.insertAsFirst(currentNote); // schedule currentProcess..
		evList.insertAsFirst(preemptNote);
		// ..to be next after preempting SimPr.
		currentProcess.passivate(); // and set current to sleep until then

	}

	/**
	 * Processes the next eventnote on the event-list. Returns <code>true</code>
	 * if that eventnote has been processed correctly, <code>false</code> if an
	 * error occurred or the event-list is empty.
	 * 
	 * @return boolean : Is <code>true</code> if the next eventnote was
	 *         processed correctly, <code>false</code> if not
	 */
	protected boolean processNextEventNote() {
		// check if there still are EventNotes to be processed
		if (!(executionSpeedRate > 0)) {
			if (evList.isEmpty()) {
				return false; // no more eventnote available -> exit
			}
		} else {

			while (true) {
				this.lock.lock();
				if (evList.isEmpty() && realTimeEventQueue.isEmpty()) {
					// no event waiting
					lock.unlock();
					return false;
				}
				if (myExperiment.isStopped()) {
					// experiment has been stopped
					lock.unlock();
					return true; // there is an event
				}
				if (timeReset) {
					this.realTimeAtResetInNanos = System.nanoTime();
					this.simulationTimeAtReset = presentTime();
					this.timeReset = false;
				}

				while (!realTimeEventQueue.isEmpty()) {
					// an event has been sent by an external system

					RealTimeEventWrapper currentRealTimeWrapper = realTimeEventQueue
							.poll();// get the next RealTimeEventWrapper and
					// remove it from the queue
					ExternalEvent currentRealTimeEvent = currentRealTimeWrapper
							.getExternalEvent();// get the encapsulated
					// ExternalEvent

					long weightedRealTimeEventNanos = (long) ((currentRealTimeWrapper
							.getNanos() - realTimeAtResetInNanos) * executionSpeedRate);

					if (weightedRealTimeEventNanos < 0) {
						// the ExternalEvent is in the future
						myExperiment
								.sendWarning(
										"Can not schedule real time external event! "
												+ "The external event is discarded.",
										"Scheduler of experiment "
												+ myExperiment.getName()
												+ " Method processNextEventNote() "
												+ "External Event: "
												+ currentRealTimeEvent
														.getName()
												+ " deviation in nanoseconds: "
												+ -weightedRealTimeEventNanos,
										"The given real-time time stamp is in the future.",
										"Real-time Events are not supposed to be scheduled in the (real time) future.");
					} else {

						TimeInstant realTimeNanosEquivalent = TimeOperations
								.add(simulationTimeAtReset, new TimeSpan(
										weightedRealTimeEventNanos,
										TimeUnit.NANOSECONDS));
						// calculate the simulation time equivalent to
						// the real-time time stamp of the external event

						if (TimeInstant.isAfterOrEqual(realTimeNanosEquivalent,
								presentTime())) {
							// the event can be scheduled correctly
							currentRealTimeEvent
									.schedule(realTimeNanosEquivalent);
						} else {
							// the simulation time of the event is in the past
							currentRealTimeEvent.schedule(presentTime());

							myExperiment
									.sendWarning(
											"Can not schedule real time external event at the simulation time equivalent to the given timeStamp! "
													+ "The external event is scheduled at the present simulation time instead.",
											"Scheduler of experiment "
													+ myExperiment.getName()
													+ " Method processNextEventNote() "
													+ "External Event: "
													+ currentRealTimeEvent
															.getName()
													+ " deviation in nanoseconds: "
													+ (presentTime()
															.getTimeTruncated(
																	TimeUnit.NANOSECONDS) - weightedRealTimeEventNanos),
											"The simulation time equivalent of the given time stamp is before the current simulation time. Can not perform a rollback.",
											"Check if this deviation constitutes a problem.");
						}

					}

				}

				// System.out.println("--------------------------");
				// if (!evList.isEmpty()) {
				// EventNote note = evList.firstNote();
				// System.out.println(note.toString());
				// while (!(note == evList.lastNote())) {
				// System.out.println(evList.nextNote(note));
				// note = evList.nextNote(note);
				// }
				// System.out.println("--------------------------");
				// }
				// test code by felix

				currentNote = evList.firstNote(); // get next eventnote
				long weightedTimeSinceReset = (long) ((System.nanoTime() - realTimeAtResetInNanos) * executionSpeedRate);
				// calculate the real time passed since the last time reset
				// cosidering the execution speed rate

				long timeToWait = (long) ((TimeOperations.diff(
						currentNote.getTime(), simulationTimeAtReset)
						.getTimeTruncated(TimeUnit.NANOSECONDS) - weightedTimeSinceReset) / executionSpeedRate);
				// calculate the time the thread has to wait
				if (timeToWait > 0) {
					// there is a need to wait
					try {
						waitSynchCondition.awaitNanos(timeToWait);

					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						this.lock.unlock();
					}
				} else {
					this.lock.unlock();
				}
				if (!timeReset && realTimeEventQueue.isEmpty()) {
					break;
				}

			}
		}
		currentNote = evList.firstNote(); // get next eventnote
		TimeInstant nextTime = currentNote.getTime();
		// check if the next event note is in the future
		if (TimeInstant.isAfter(nextTime, presentTime())) {
			clock.setTime(nextTime);
		} else {
			// throw an exception if the next event note is in the past
			if (TimeInstant.isBefore(nextTime, presentTime())) {
				throw (new desmoj.core.exception.SimAbortedException(
						new desmoj.core.report.ErrorMessage(
								null,
								"The simulation Time of the next event is in the past! Simulation aborted.",
								"Class : Scheduler  Method : processNextEventNote()",
								"the simulation time of the next event note ("
										+ currentNote
										+ ") is before the current simulation time : "
										+ presentTime(),
								"Make sure not to schedule events in the past.",
								null)));
			}
		}
		// update the clock and its observers

		// changes to event-list and 'current' variables can only be made after
		// every
		// Observer registered with the clock has made their updates

		// take eventnote from EventList
		evList.remove(currentNote);

		// set 'current' variables
		// determine entity and simprocess, if applicable
		currentEntity = currentNote.getEntity();
		currentProcess = null;
		currentSchedulable = null;

		if (currentEntity != null) {

			currentModel = currentEntity.getModel();
			currentSchedulable = currentEntity;
			currentEntity.removeEventNote();
			if (currentEntity instanceof SimProcess) { // a real simprocess
				currentProcess = (SimProcess) currentEntity;
			}

		}

		// determine event resp. external event
		currentEvent = currentNote.getEvent();
		if (currentEvent != null && currentProcess == null) {

			currentEvent.removeEventNote();

			if (currentSchedulable == null) {

				currentSchedulable = currentEvent;
				currentModel = currentEvent.getModel();

			}

		}

		// just check if everything is still allright
		// currSched. must have been set to something other than null by now
		// otherwise : throw (new desmoj.exception.DESMOJException());
		if (currentSchedulable == null)
			return false;

		// clear time value and discard EventNote
		currentNote.setTime(null);
		currentNote = null;

		// determine if event-oriented or process-oriented
		if (currentEvent != null) { // event-oriented

			currentEvent.eventRoutine(currentEntity);
			// this is where it all happens
		} else { // process-oriented

			// The currentprocess to hand control over to may have terminated
			// already
			// so the scheduler must not start it
			if (!currentProcess.isTerminated()) {

				// The currentprocess can either be running, thus waiting in a
				// block
				// or still not have been started
				if (currentProcess.isReady()) {
					// currentProcess is already running

					// main thread passes control over to currentProcess'
					// SimThread
					// executing the SimProcess' lifeCycle method until
					// hold(dt)/passivate
					// or end of lifeCycle
					currentProcess.activate();

				} else { // currentProcess is starting for the first time

					currentProcess.start(); // start him up

				}

				// when hold / passivate or end of lifeCycle are passed, the
				// control
				// is handed back to the main thread here and there's nothing
				// else to do
				// but return true to state that this EventNote has been
				// processed correctly

			} else {
				// this must not happen, but we check on it anyway
				myExperiment
						.sendWarning("Can not activate scheduled simprocess! "
								+ "Command ignored.",
								"Scheduler of experiment "
										+ myExperiment.getName()
										+ " Method processNextEventNote() "
										+ "SimProcess : "
										+ currentProcess.getName(),
								"The simprocess to be activated to take over control has "
										+ "already terminated.",
								"Internal DESMOJ-Error. Please report to DESMOJ-Support.");
			}

		}
		if (executionSpeedRate > 0) {
			// calculate deviation
			long simTimeSinceReset = TimeOperations.diff(presentTime(),
					simulationTimeAtReset).getTimeTruncated(
					TimeUnit.NANOSECONDS);
			long realTimeSinceReset = (System.nanoTime() - realTimeAtResetInNanos);
			long deviationInNanoseconds = (long) (realTimeSinceReset - (simTimeSinceReset / executionSpeedRate));
			// System.out.println("SimTimeSinceReset: " + simTimeSinceReset
			// + ", RealTimeSinceReset: " + realTimeSinceReset
			// + ", Weighted deviation: " + deviationInNanoseconds);

			if (currentEvent != null) {
				// event-oriented

				long deadLine = currentEvent.getRealTimeConstraint();
				// the deadLine of this event

				if (deadLine > 0 && deadLine < deviationInNanoseconds) {
					// the real-time deadline was missed
					myExperiment.sendWarning(
							"The real-time deadline of this event was missed!",
							"Scheduler of experiment " + myExperiment.getName()
									+ " Method processNextEventNote() "
									+ "Event : " + currentEvent.getName(),
							"The real-time deadline of this event was "
									+ deadLine + " nanoseconds. It was missed by "
									+ (deviationInNanoseconds - deadLine)
									+ " nanoseconds.",
							"Check if the deadline can be met.");
				}
			} else {
				// process-oriented

				long deadLine = currentProcess.getRealTimeConstraint();
				// the deadLine of this SimProcess

				if (deadLine > 0 && deadLine < deviationInNanoseconds) {
					// the real-time deadline was missed
					myExperiment
							.sendWarning(
									"The real-time deadline of this SimProcess was missed!",
									"Scheduler of experiment "
											+ myExperiment.getName()
											+ " Method processNextEventNote() "
											+ "SimProcess : "
											+ currentProcess.getName(),
									"The real-time deadline of this SimProcess was "
											+ deadLine
											+ " nanoseconds. It was missed by "
											+ (deviationInNanoseconds - deadLine)
											+ " nanoseconds.",
									"Check if the deadline can be met.");
				}
			}

		}

		return true; // everything processed allright

	}

	/**
	 * Schedules the external event to happen at the simulation time equivalent
	 * to the current value of wall-clock time.
	 * 
	 * @param what
	 *            ExternalEvent : The external event to be scheduled
	 * 
	 */
	protected void realTimeSchedule(RealTimeEventWrapper what) {
		if (!myExperiment.isRunning()) {
			myExperiment
					.sendWarning(
							"Can not schedule real time external event! Command ignored.",
							"Experiment '"
									+ getName()
									+ "' method void realTimeSchedule(ExternalEvent what).",
							"The experiment is not running.",
							"Events can only be scheduled when the exeriment is running.");
			return;
		}
		if (what == null) { // check for null reference
			myExperiment.sendWarning("Can't schedule ExternalEvent! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: realTimeSchedule(ExternalEvent what)",
					"The ExternalEvent reference passed is a "
							+ "null references.",
					"Always make sure to use valid references only.");
			return;
		}

		try {
			// put the given event wrapper into the thread-safe event queue
			realTimeEventQueue.put(what);
		} catch (InterruptedException e) {
			myExperiment.sendWarning("Can't schedule external event! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: realTimeSchedule(ExternalEvent who)",
					"The Thread waiting to schedule the given external event "
							+ "was interrupted.",
					"A Thread has to wait until space becomes available");

		}
		lock.lock();
		waitSynchCondition.signal();// signal that a new real time event is
		// available
		lock.unlock();
	}

	/**
	 * Schedules the event to happen after a specified time. Checks that only
	 * legal combinations of valid parameters are scheduled.
	 * <p>
	 * <DIV align=center>
	 * <TABLE BORDER >
	 * <CAPTION>Valid scheduling types </CAPTION>
	 * <TR>
	 * <TH><DIV align=center>scheduling type</TH>
	 * <TH>entity object</TH>
	 * <TH>event object</TH>
	 * </TR>
	 * <TR>
	 * <TH>event oriented</TH>
	 * <TD>event or simprocess</TD>
	 * <TD>event</TD>
	 * </TR>
	 * <TR>
	 * <TH>process oriented</TH>
	 * <TD>simprocess</TD>
	 * <TD>null</TD>
	 * </TR>
	 * <TR>
	 * <TH>external event</TH>
	 * <TD>null</TD>
	 * <TD>external event</TD>
	 * </TR>
	 * </TABLE>
	 * </DIV>
	 * 
	 * @param who
	 *            Entity : The entity to be scheduled
	 * @param what
	 *            Event : The event to manipulate the entity
	 * @param dt
	 *            TimeSpan : The point in simulation time for the event to happen
	 *            as an offset to the current simulation time
	 */
	protected void reSchedule(Schedulable who, TimeSpan dt) {

		if (dt == null) {
			myExperiment
					.sendWarning(
							"Can't reschedule schedulable at given time! "
									+ "Command ignored.",
							"Scheduler : "
									+ getName()
									+ " Method: reSchedule(Schedulable who, TimeSpan dt)",
							"The simulation time reference passed as parameter is a "
									+ "null reference.",
							"Always make sure to use valid references only.");
			return; // time missing
		}

		if (who == null) {
			myExperiment
					.sendWarning(
							"Can't reschedule schedulable at given time! "
									+ "Command ignored.",
							"Scheduler : "
									+ getName()
									+ " Method: reSchedule(Schedulable who, TimeSpan dt)",
							"The schedulable reference passed as parameter is a "
									+ "null reference.",
							"Always make sure to use valid references only.");
			return; // schedulable missing
		}

		if (!who.isScheduled()) {
			myExperiment
					.sendWarning(
							"Can't reschedule schedulable at given time! "
									+ "Command ignored.",
							"Scheduler : "
									+ getName()
									+ " Method: reSchedule(Schedulable who, TimeSpan dt)",
							"The schedulable given is not scheduled, thus can not be "
									+ "rescheduled.",
							"To reschedule a schedulable, it must already be scheduled. "
									+ "You can check that by calling the schedulable's "
									+ "isScheduled() method");
			return;
			// I can't be rescheduled, I haven't even been scheduled yet
		}

		// all parameters checked, now remove the Schedulable's EventNote
		// first...
		EventNote note = who.getEventNote();
		evList.remove(note);
		note.setTime(TimeOperations.add(presentTime(), dt));

		if (dt == TimeSpan.ZERO) { // preempting schedule for processes

			if (currentProcess == null) { // currently Event -> no preemption
				// inserted as first in the EventList with the current time as
				// activation
				evList.insertAsFirst(note);
				return;

			} else { // currently SimProcess -> preempt!

				preemptSimProcess(note);
				return;

			}

		}

		// all parameters checked, now reinsert note
		evList.insert(note);

	}
	
	   /**
     * Schedules the event to happen at the specified time. Checks that only
     * legal combinations of valid parameters are scheduled.
     * <p>
     * <DIV align=center>
     * <TABLE BORDER >
     * <CAPTION>Valid scheduling types </CAPTION>
     * <TR>
     * <TH><DIV align=center>scheduling type</TH>
     * <TH>entity object</TH>
     * <TH>event object</TH>
     * </TR>
     * <TR>
     * <TH>event oriented</TH>
     * <TD>event or simprocess</TD>
     * <TD>event</TD>
     * </TR>
     * <TR>
     * <TH>process oriented</TH>
     * <TD>simprocess</TD>
     * <TD>null</TD>
     * </TR>
     * <TR>
     * <TH>external event</TH>
     * <TD>null</TD>
     * <TD>external event</TD>
     * </TR>
     * </TABLE>
     * </DIV>
     * 
     * @param who
     *            Entity : The entity to be scheduled
     * @param what
     *            Event : The event to manipulate the entity
     * @param time
     *            TimeInstant : The point in simulation time for the event to happen
     */
    protected void reSchedule(Schedulable who, TimeInstant time) {

        if (time == null) {
            myExperiment
                    .sendWarning(
                            "Can't reschedule schedulable at given time! "
                                    + "Command ignored.",
                            "Scheduler : "
                                    + getName()
                                    + " Method: reSchedule(Schedulable who, TimeInstant time)",
                            "The simulation time reference passed as parameter is a "
                                    + "null reference.",
                            "Always make sure to use valid references only.");
            return; // time missing
        }

        if (who == null) {
            myExperiment
                    .sendWarning(
                            "Can't reschedule schedulable at given time! "
                                    + "Command ignored.",
                            "Scheduler : "
                                    + getName()
                                    + " Method: reSchedule(Schedulable who, TimeInstant time)",
                            "The schedulable reference passed as parameter is a "
                                    + "null reference.",
                            "Always make sure to use valid references only.");
            return; // schedulable missing
        }

        if (!who.isScheduled()) {
            myExperiment
                    .sendWarning(
                            "Can't reschedule schedulable at given time! "
                                    + "Command ignored.",
                            "Scheduler : "
                                    + getName()
                                    + " Method: reSchedule(Schedulable who, TimeInstant time)",
                            "The schedulable given is not scheduled, thus can not be "
                                    + "rescheduled.",
                            "To reschedule a schedulable, it must already be scheduled. "
                                    + "You can check that by calling the schedulable's "
                                    + "isScheduled() method");
            return;
            // I can't be rescheduled, I haven't even been scheduled yet
        }
        
        if (TimeInstant.isBefore(time, this.presentTime())) {
            myExperiment
                    .sendWarning(
                            "Can't reschedule schedulable at given time! "
                                    + "Command ignored.",
                            "Scheduler : "
                                    + getName()
                                    + " Method: reSchedule(Schedulable who, TimeInstant time)",
                            "The instant given is in the past.",
                            "To reschedule a schedulable, use a TimeInstant no earlier than the present time. "
                                    + "The present time can be obtained using the "
                                    + "presentTime() method");
            return;
            // I can't be rescheduled, TimeInstant has already passed.
        }

        // all parameters checked, now remove the Schedulable's EventNote
        // first...
        EventNote note = who.getEventNote();
        evList.remove(note);
        note.setTime(time);

        if (this.presentTime() == time) { // preempting schedule for processes

            if (currentProcess == null) { // currently Event -> no preemption
                // inserted as first in the EventList with the current time as
                // activation
                evList.insertAsFirst(note);
                return;

            } else { // currently SimProcess -> preempt!

                preemptSimProcess(note);
                return;

            }

        }

        // all parameters checked, now reinsert note
        evList.insert(note);

    }

	/**
	 * Schedules the event to happen after a specified time span. Checks that only
	 * legal combinations of valid parameters are scheduled.
	 * <p>
	 * <DIV align=center>
	 * <TABLE BORDER >
	 * <CAPTION>Valid scheduling types </CAPTION>
	 * <TR>
	 * <TH><DIV align=center>scheduling type</TH>
	 * <TH>entity object</TH>
	 * <TH>event object</TH>
	 * </TR>
	 * <TR>
	 * <TH>event oriented</TH>
	 * <TD>event or simprocess</TD>
	 * <TD>event</TD>
	 * </TR>
	 * <TR>
	 * <TH>process oriented</TH>
	 * <TD>simprocess</TD>
	 * <TD>null</TD>
	 * </TR>
	 * <TR>
	 * <TH>external event</TH>
	 * <TD>null</TD>
	 * <TD>external event</TD>
	 * </TR>
	 * </TABLE>
	 * </DIV>
	 * 
	 * @param who
	 *            Entity : The entity to be scheduled
	 * @param what
	 *            Event : The event to manipulate the entity
	 * @param dt
	 *            TimeSpan : The point in simulation time for the event to happen
	 *            as an offset to the current simulation time
	 */
	protected void schedule(Entity who, Event what, TimeSpan dt) {

		if (dt == null) {
			myExperiment.sendWarning(
					"Can't schedule entity and event at given "
							+ "time! Command ignored.", "Scheduler : "
							+ getName() + " Method: schedule(Entity who, "
							+ "Event what, TimeSpan dt)",
					"The simulation time reference passed as parameter is a "
							+ "null reference.",
					"Always make sure to use valid references only.");
			return; // time missing
		}

		if ((who == null) && (what == null)) {
			myExperiment.sendWarning("Can't schedule entity and event! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: schedule(Entity who, "
					+ "Event what, TimeSpan dt)",
					"The event and entity references passed are both "
							+ "null references.",
					"Either event or entity references must be valid.");
			return; // no real parameters here anyway
		}

		if ((who == null) && !(what instanceof ExternalEvent)) {
			myExperiment.sendWarning("Can't schedule event! Command ignored.",
					"Scheduler : " + getName()
							+ " Method: schedule(Entity who, "
							+ "Event what, TimeSpan dt)",
					"The entity reference passed is a null reference but the "
							+ "event references is not an external event.",
					"If no valid entity is given, the event must be of type "
							+ "external event.");
			return; // if no Entity it must be ExternalEvent
		}

		if (!(who instanceof SimProcess) && (what == null)) {
			myExperiment.sendWarning("Can't schedule entity and event! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: schedule(Entity who, "
					+ "Event what, TimeSpan dt)",
					"The entity needs a valid event to be scheduled with.",
					"Only simprocesses may be scheduled without events.");
			return; // Event needed with Entity
		}
		
		TimeInstant time = TimeOperations.add(presentTime(), dt);
		// set time for being scheduled

		EventNote note = new EventNote(who, what, time);

		if (dt == TimeSpan.ZERO) { // preempting schedule for processes
			if (currentProcess == null) { // currently Event -> no preemption
				// inserted as first in the EventList with the current time as
				// activation
				evList.insertAsFirst(note);
				return;
			} else { // currently SimProcess -> preempt!
				preemptSimProcess(note);
				return;
			}
		}

		// all parameters checked, now schedule event
		evList.insert(note);

	}
	
	/**
	 * Schedules the event to happen at the specified time. Checks that only
	 * legal combinations of valid parameters are scheduled.
	 * <p>
	 * <DIV align=center>
	 * <TABLE BORDER >
	 * <CAPTION>Valid scheduling types </CAPTION>
	 * <TR>
	 * <TH><DIV align=center>scheduling type</TH>
	 * <TH>entity object</TH>
	 * <TH>event object</TH>
	 * </TR>
	 * <TR>
	 * <TH>event oriented</TH>
	 * <TD>event or simprocess</TD>
	 * <TD>event</TD>
	 * </TR>
	 * <TR>
	 * <TH>process oriented</TH>
	 * <TD>simprocess</TD>
	 * <TD>null</TD>
	 * </TR>
	 * <TR>
	 * <TH>external event</TH>
	 * <TD>null</TD>
	 * <TD>external event</TD>
	 * </TR>
	 * </TABLE>
	 * </DIV>
	 * 
	 * @param who
	 *            Entity : The entity to be scheduled
	 * @param what
	 *            Event : The event to manipulate the entity
	 * @param when
	 *            TimeInstant : The point in simulation time for the event to
	 *            happen
	 */
	protected void schedule(Entity who, Event what, TimeInstant when) {

		if (when == null) {
			myExperiment.sendWarning(
					"Can't schedule entity and event at given "
							+ "time! Command ignored.", "Scheduler : "
							+ getName() + " Method: schedule(Entity who, "
							+ "Event what, TimeInstant when)",
					"The simulation time reference passed as parameter is a "
							+ "null reference.",
					"Always make sure to use valid references only.");
			return; // time missing
		}

		if ((who == null) && (what == null)) {
			myExperiment.sendWarning("Can't schedule entity and event! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: schedule(Entity who, "
					+ "Event what, TimeInstant when)",
					"The event and entity references passed are both "
							+ "null references.",
					"Either event or entity references must be valid.");
			return; // no real parameters here anyway
		}

		if ((who == null) && !(what instanceof ExternalEvent)) {
			myExperiment.sendWarning("Can't schedule event! Command ignored.",
					"Scheduler : " + getName()
							+ " Method: schedule(Entity who, "
							+ "Event what, TimeInstant when)",
					"The entity reference passed is a null reference but the "
							+ "event references is not an external event.",
					"If no valid entity is given, the event must be of type "
							+ "external event.");
			return; // if no Entity it must be ExternalEvent
		}

		if (!(who instanceof SimProcess) && (what == null)) {
			myExperiment.sendWarning("Can't schedule entity and event! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: schedule(Entity who, "
					+ "Event what, TimeInstant when)",
					"The entity needs a valid event to be scheduled with.",
					"Only simprocesses may be scheduled without events.");
			return; // Event needed with Entity
		}
		
        if (TimeInstant.isBefore(when, this.presentTime())) {
            myExperiment
                    .sendWarning(
                            "Can't reschedule schedulable at given time! "
                                    + "Command ignored.",
                            "Scheduler : "
                                    + getName()
                                    + " Method: schedule(Schedulable who, TimeInstant when)",
                            "The instant given is in the past.",
                            "To schedule a schedulable, use a TimeInstant no earlier than the present time. "
                                    + "The present time can be obtained using the "
                                    + "presentTime() method.");
            return;
            // I can't be scheduled, TimeInstant has already passed.
        }

		EventNote note = new EventNote(who, what, when);

		if (when == presentTime()) { // preempting schedule for processes
			if (currentProcess == null) { // currently Event -> no preemption
				// inserted as first in the EventList with the current time as
				// activation
				evList.insertAsFirst(note);
				return;
			} else { // currently SimProcess -> preempt!
				preemptSimProcess(note);
				return;
			}

		}

		// all parameters checked, now schedule event
		evList.insert(note);

	}

	/**
	 * Schedules the given entity and event to happen straight after the given
	 * schedulable is set to be activated. Note that the siulation time for the
	 * newly entered eventnote will be set to the schedulable's time and the new
	 * eventnote will be inserted directly after the schedulable's eventnote.
	 * <p>
	 * <DIV align=center>
	 * <TABLE BORDER >
	 * <CAPTION>Valid scheduling types </CAPTION>
	 * <TR>
	 * <TH><DIV align=center>scheduling type</TH>
	 * <TH>entity object</TH>
	 * <TH>event object</TH>
	 * </TR>
	 * <TR>
	 * <TH>event oriented</TH>
	 * <TD>event or simprocess</TD>
	 * <TD>event</TD>
	 * </TR>
	 * <TR>
	 * <TH>process oriented</TH>
	 * <TD>simprocess</TD>
	 * <TD>null</TD>
	 * </TR>
	 * <TR>
	 * <TH>external event</TH>
	 * <TD>null</TD>
	 * <TD>external event</TD>
	 * </TR>
	 * </TABLE>
	 * </DIV>
	 * 
	 * @param before
	 *            Schedulable : The schedulable after which the new eventnote is
	 *            to be scheduled
	 * @param who
	 *            Entity : The entity to be scheduled
	 * @param what
	 *            Event : The event to be scheduled
	 */
	protected void scheduleAfter(Schedulable after, Entity who, Event what) {

		if (after == null) {
			myExperiment.sendWarning("Can't schedule after schedulable! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: scheduleAfter(Entity "
					+ "who, Event what, TimeSpan dt)",
					"The reference for the schedulable to schedule after is a "
							+ "null references.",
					"Always check to use valid references.");
			return; // relative Schedulable missing
		}

		if (!after.isScheduled() && (after != currentSchedulable)) {
			myExperiment.sendWarning("Can't schedule after schedulable! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: scheduleAfter(Entity "
					+ "who, Event what, TimeSpan dt)",
					"The schedulable to be scheduled after is not scheduled.",
					"The schedulable taken as reference must be scheduled.");
			return; // relative Schedulable not scheduled
		}

		if ((who == null) && (what == null)) {
			myExperiment.sendWarning("Can't schedule entity and event! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: scheduleAfter(Entity "
					+ "who, Event what, TimeSpan dt)",
					"The event and entity references passed are both "
							+ "null references.",
					"Either event or entity references must be valid.");
			return; // no real parameters here anyway
		}

		if ((who == null) && !(what instanceof ExternalEvent)) {
			myExperiment.sendWarning("Can't schedule event! Command ignored.",
					"Scheduler : " + getName()
							+ " Method: scheduleAfter(Entity "
							+ "who, Event what, TimeSpan dt)",
					"The entity reference passed is a null reference but the "
							+ "event references is not an external event.",
					"If no valid entity is given, the event must be of type "
							+ "external event.");
			return; // if no Entity it must be ExternalEvent
		}

		if (!(who instanceof SimProcess) && (what == null)) {
			myExperiment.sendWarning("Can't schedule entity and event! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: scheduleAfter(Entity "
					+ "who, Event what, TimeSpan dt)",
					"The entity needs a valid event to be scheduled with.",
					"Only simprocesses may be scheduled without events.");
			return; // Event needed with Entity
		}

		if (after != currentSchedulable) {
			// all parameters checked, now go on and schedule
			EventNote afterNote = after.getEventNote();
			evList.insertAfter(afterNote, new EventNote(who, what, afterNote
					.getTime()));
			// sets the time equivalent to the Schedulable's
		} else {
			evList.insertAsFirst(new EventNote(who, what, presentTime()));
		}

	}

	/**
	 * Schedules the given entity and event to happen straight before the given
	 * schedulable is scheduled. Note that the simulation time for the newly
	 * entered EventNote will be set to the schedulable's time and the new
	 * eventnote will be inserted directly before the schedulable's eventnote.
	 * <p>
	 * <DIV align=center>
	 * <TABLE BORDER >
	 * <CAPTION>Valid scheduling types </CAPTION>
	 * <TR>
	 * <TH><DIV align=center>scheduling type</TH>
	 * <TH>entity object</TH>
	 * <TH>event object</TH>
	 * </TR>
	 * <TR>
	 * <TH>event oriented</TH>
	 * <TD>event or simprocess</TD>
	 * <TD>event</TD>
	 * </TR>
	 * <TR>
	 * <TH>process oriented</TH>
	 * <TD>simprocess</TD>
	 * <TD>null</TD>
	 * </TR>
	 * <TR>
	 * <TH>external event</TH>
	 * <TD>null</TD>
	 * <TD>external event</TD>
	 * </TR>
	 * </TABLE>
	 * </DIV>
	 * 
	 * @param before
	 *            Schedulable : The schedulable before which the new Eeventnote
	 *            is to be scheduled
	 * @param who
	 *            Entity : The entity to be scheduled
	 * @param what
	 *            Event : The event to be scheduled
	 */
	protected void scheduleBefore(Schedulable before, Entity who, Event what) {

		if (before == null) {
			myExperiment.sendWarning("Can't schedule after schedulable! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: scheduleBefore(Entity "
					+ "who, Event what, TimeSpan dt)",
					"The reference for the schedulable to schedule before is a "
							+ "null references.",
					"Always check to use valid references.");
			return; // relative Schedulable missing
		}

		if (!before.isScheduled()) {
			myExperiment.sendWarning("Can't schedule after schedulable! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: scheduleBefore(Entity "
					+ "who, Event what, TimeSpan dt)",
					"The schedulable to schedule after is not scheduled.",
					"The schedulable taken as reference must be scheduled.");
			return; // relative Schedulable not scheduled
		}

		if ((who == null) && (what == null)) {
			myExperiment.sendWarning("Can't schedule entity and event! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: scheduleBefore(Entity "
					+ "who, Event what, TimeSpan dt)",
					"The event and entity references passed are both "
							+ "null references.",
					"Either event or entity references must be valid.");
			return; // no real parameters here anyway
		}

		if ((who == null) && !(what instanceof ExternalEvent)) {
			myExperiment.sendWarning("Can't schedule event! Command ignored.",
					"Scheduler : " + getName()
							+ " Method: scheduleBefore(Entity "
							+ "who, Event what, TimeSpan dt)",
					"The entity reference passed is a null reference but the "
							+ "event references is not an external event.",
					"If no valid entity is given, the event must be of type "
							+ "external event.");
			return; // if no Entity it must be ExternalEvent
		}

		if (!(who instanceof SimProcess) && (what == null)) {
			myExperiment.sendWarning("Can't schedule entity and event! "
					+ "Command ignored.", "Scheduler : " + getName()
					+ " Method: scheduleBefore(Entity "
					+ "who, Event what, TimeSpan dt)",
					"The entity needs a valid event to be scheduled with.",
					"Only simprocesses may be scheduled without events.");
			return; // Event needed with Entity
		}

		// all parameters checked, now go on and schedule
		EventNote beforeNote = before.getEventNote();
		evList.insertBefore(beforeNote, new EventNote(who, what, beforeNote
				.getTime()));
		// sets the time equivalent to the Schedulable's
	}

	/**
	 * Creates and sends a debugnote to the experiment's messagedistributor.
	 * These debugnotes express the internal state of the eventlist to visualize
	 * the changes of state to help find bugs. Classes <code>Scheduler</code>
	 * and <code>Queue</code> both produce debugnotes if set to do so
	 * representing the data stored inside them. The information about the
	 * simulation time is extracted from the experiment and must not be given as
	 * a parameter.
	 * 
	 * @param description
	 *            java.lang.String : The description of the eventlist's internal
	 *            state to be passed with this debugnote
	 */
	void sendDebugNote(String description) {

		myExperiment.getMessageManager().receive(
				new DebugNote(myExperiment.getModel(), presentTime(),
						getName(), description));

	}

	/**
	 * Sets the execution speed rate.
	 * 
	 * @param executionSpeedRate
	 *            double : the execution speed rate
	 * @author Felix Klueckmann
	 */
	protected void setExecutionSpeedRate(double executionSpeedRate) {
		lock.lock();
		this.executionSpeedRate = executionSpeedRate;
		this.timeReset = true;
		waitSynchCondition.signal();
		lock.unlock();
	}

	/**
	 * Sets the flag indicating if the event list processes concurrent events in
	 * random order or not. If a change occurred the event list has to be
	 * changed accordingly.
	 * 
	 * @param randomizing
	 *            boolean :<code>true</code> forces random order,
	 *            <code>false</code> forces "linear" order
	 * @author Ruth Meyer
	 */
	protected void setRandomizingConcurrentEvents(boolean randomizing) {
		// nothing new?
		if (this.randomizingConcurrentEvents == randomizing) {
			return; // just keep everything as is
		}
		// ok, we have to change the event list (oh bother!)
		this.randomizingConcurrentEvents = randomizing;
		EventList newList;
		if (this.evList instanceof EventTreeList) {
			if (randomizing) {
				newList = new RandomizingEventTreeList();
			} else {
				newList = new EventTreeList();
			}
		} else {
			if (randomizing) {
				newList = new RandomizingEventVector();
			} else {
				newList = new EventVector();
			}
		}
		// copy old list into new list
		EventNote note = this.evList.firstNote();
		while (note != null) {
			newList.insert(note);
			note = this.evList.nextNote(note);
		}
		this.evList = newList;
	}

	/**
	 * Returns the status of the current simulation. Clients should not need to
	 * use this method explicitly. This method is polled by each thread when it
	 * exits a lock to check wether it should continue its lifeCycle() method ot
	 * throw a SimulationFinishedException, which seems to be the only legal way
	 * to break out of the deep call hierarchies and stop the Process'
	 * lifeCycle.
	 * 
	 * @return boolean : state of the simulation. False if still running, true
	 *         if the simulation has already finished correctly
	 */
	boolean simFinished() {

		return simulationFinished;

	}

	/**
	 * Signals that the experiment is stopped.
	 * 
	 * @author Felix Klueckmann
	 */
	protected void signalStop() {
		lock.lock();
		this.timeReset = true;
		waitSynchCondition.signal();
		lock.unlock();
	}

	/**
	 * Returns a string representation of the current state of the eventlist.
	 * The string is built by concatenating all string representations of the
	 * contained entities, events and TimeInstant objects calling their
	 * <code>toString()</code> methods.
	 * 
	 * @return java.lang.String : The string representation of the queuelist
	 */
	public String toString() {

		StringBuffer buffer = new StringBuffer(); // strings
		Entity enBuff; // Buffer for Entities
		Event evBuff; // Buffer for Events

		TimeInstant tiBuff; // Buffer for Instants

		if (evList.isEmpty()) {
			// if empty, give short note
			buffer.append("- eventlist empty -");
			return buffer.toString();
		} else {

			// go thru list and present EventNotes
			int i = 0; // counter for position

			for (EventNote iNote = evList.firstNote(); iNote != null; iNote = evList
					.nextNote(iNote)) { // loop thru list

				i++; // increment counter
				buffer.append(i + ":");

				// set the buffers. This saves some calls to eventnote methods
				enBuff = iNote.getEntity();
				evBuff = iNote.getEvent();
				tiBuff = iNote.getTime();

				// set entity
				if (enBuff == null)
					buffer.append("[-]");
				else
					buffer.append("[" + enBuff.toString() + "]");
				// embrace in brackets

				// set event
				if (evBuff == null)
					buffer.append("[-]");
				else
					buffer.append("[" + evBuff.toString() + "]");
				// embrace in brackets

				// set time
				if (tiBuff == null)
					buffer.append("[-]"); // can never happen...
				else
					buffer.append("[" + tiBuff.toString() + "]<br>");
				// embrace in brackets
				// and make a linebreak
			}

		}

		// get it to the client who asked for it...
		return buffer.toString();

	}

}