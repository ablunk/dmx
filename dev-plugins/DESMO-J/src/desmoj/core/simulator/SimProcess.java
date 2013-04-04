package desmoj.core.simulator;

import java.util.Enumeration;
import java.util.Vector; //TODO: oder dem Anwender überlassen...?

import desmoj.core.advancedModellingFeatures.Res;
import desmoj.core.report.ErrorMessage;

/**
 * SimProcess represents entities with an own active lifecycle. Since
 * simprocesses are in fact special entities with extended capabilities ( esp.
 * the method lifeCycle() ), they inherit from entity and thus can also be used
 * in conjunction with events. So they can be handled in both ways, event- and
 * process-oriented. Clients are supposed to implement the lifeCycle() method to
 * specify the individual behaviour of a special simprocess subclass. Since
 * implementing activity- and transaction-oriented synchronization mechanisms
 * requires significant changes in this class, methods that have been
 * implemented by Soenke Claassen have been marked.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Tim Lechler.
 * @author Methods: canCooperate, clearInterruptCode, cooperate,
 *         getInterruptCode, getMaster, getSlaveWaitQueue, IsInterrupted,
 *         resetMaster and setSlaveWaitQueue by Soenke Claassen
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
public abstract class SimProcess extends Entity {

	/**
	 * The Thread needed for implementing coroutine behaviour.
	 */
	private Thread myThread;

	/**
	 * Displays the current blocked status of this simprocess. A simprocess is
	 * blocked whenever it has to wait inside a queue or synchronization object.
	 */
	private boolean isBlocked;

	/**
	 * Displays the current status of this simprocess. Is <code>true</code> if
	 * lifeCycle method has finished, <code>false</code> if it is still running
	 * or has not been started yet
	 */
	private boolean isTerminated;

	/**
	 * Displays if the thread in of control of this simprocess is already the
	 * associated simthread. Is <code>true</code> if the simthread is active and
	 * is carrying on its lifeCycle. Is <code>false</code> if it has not started
	 * its lifeCycle yet or is terminated already.
	 */
	private boolean isRunning;

	/**
	 * If this simprocess is cooperating as a slave with a master process, it
	 * keeps a reference to its master here. Master is set in the
	 * <code>cooperate()</code> -method, when the slave cooperates with his
	 * master and deleted every time the slave process is activated.
	 * 
	 * @author Soenke Claassen
	 */
	private SimProcess master;

	/**
	 * If this simprocess is cooperating as a slave it has to wait in this
	 * waitQueue until a master is cooperating with it.
	 * 
	 * @author Soenke Claassen
	 */
	private ProcessQueue slaveWaitQueue;

	/**
	 * The <code>InterruptCode</code> with which this simprocess is interrupted.
	 * 
	 * @author Soenke Claassen
	 */
	private InterruptCode irqCode;

	/**
	 * The <code>Vector</code> holding all the resources this SimProcess is
	 * using at the moment.
	 * 
	 * @author Soenke Claassen
	 */
	private java.util.Vector usedResources;

	/**
	 * A reference to the container this SimProcess belongs to. Is
	 * <code>null</code> as long as this SimProcess is not contained in any
	 * <code>ComplexSimProcess</code>.
	 * 
	 * @author Soenke Claassen
	 */
	private ComplexSimProcess supervisor;
	
	/**
	 * The realTime deadline for this SimProcess in nanoseconds. In case of a
	 * real-time execution (i. e. the execution speed rate is set to a positive
	 * value) the Scheduler will produce a warning message if a deadline is
	 * missed.
	 */
	private long realTimeConstraint;

	/**
	 * Constructs a SimProcess.
	 * 
	 * @param name
	 *            java.lang.String : The name of the simprocess
	 * @param owner
	 *            Model : The model this simprocess is associated to
	 * @param showInTrace
	 *            boolean : Flag for showing simprocess in trace-files. Set it
	 *            to <code>true</code> if simprocess should show up in trace.
	 *            Set it to <code>false</code> if simprocess should not be shown
	 *            in trace.
	 */
	public SimProcess(Model owner, String name, boolean showInTrace) {

		super(owner, name, showInTrace);

		// init variables
		isBlocked = false; // not waiting in queue so far
		isRunning = false; // not running so far
		isTerminated = false; // not terminated either
		master = null; // this SimProcess has no master, so far
		slaveWaitQueue = null; // this SimProcess is not waiting in any queue
		irqCode = null; // this is not interrupted

		// set up simthread
		myThread = new SimThread(getModel().getExperiment().getThreadGroup(),
				this);

		// set up the Vector holding the used Resources
		usedResources = new java.util.Vector();

		// this SimProcess is not contained in any ComplexSimProcess yet
		supervisor = null;

	}

	/**
	 * Used to synchronize the change of control between scheduler and
	 * simprocesses. This method must only be called by the scheduler resp. the
	 * experiment's main thread in order to prevent multiple simprocess' threads
	 * running in parallel which has to be avoided.
	 */
	synchronized void activate() {

		// check that the SimThread has not finished yet
		if (isTerminated) {
			sendWarning(
					"Can't activate simprocess! Command ignored.",
					"SimProcess : " + getName() + " Method: void activate()",
					"The simprocess' lifeCycle method has already terminated.",
					"Be sure to check the simprocess' status before activating."
							+ " Use method isTerminated() to check the current status");
			return;
		}

		// wake up the SimThread waiting in a block for the SimProcess' lock
		// to be released
		notify();

		// now go wait until the next notification by the SimThread
		// of this SimProcess
		try {
			wait();
		} catch (InterruptedException irqEx) { // must be caught when using
			// wait
			// create eror message
			ErrorMessage errmsg = new ErrorMessage(getModel(),
					"Simulation stopped!",
					"InterruptedException thrown by Java VM : " + irqEx,
					"Thread conflict assumed.", "Check Java VM.", presentTime());
			// throw it back to Experiment's start routine
			throw (new desmoj.core.exception.DESMOJException(errmsg));
		}

	}

	/**
	 * Schedules the SimProcess to be activated at the specified point in
	 * simulation time. The point of time is given as an offset to the current
	 * simulation time. This will allow a SimProcess to continue executing its
	 * <code>lifeCycle</code> method. Thus in contrast to the entity, no event
	 * is needed for scheduling here.
	 * 
	 * @param dt
	 *            TimeSpan : The offset to the current simulation time this
	 *            process is to be activated
	 */
	public void activate(TimeSpan dt) {
		if (isBlocked()) {
			sendWarning(
					"Can't activate simprocess! Command ignored.",
					"SimProcess : " + getName()
							+ " Method: activate(TimeSpan dt)",
					"The simprocess to be activated is blocked inside "
							+ "a higher level synchronization object.",
					"Simprocesses waiting inside higher synchronization "
							+ "constructs can not be activated by other simprocesses or "
							+ "events!");
			return; // is blocked in some synch construction
		}

		if (isScheduled()) {
			sendWarning("Can't activate simprocess! Command ignored.",
					"SimProcess : " + getName()
							+ " Method: activate(TimeSpan dt)",
					"The simprocess to be activated is already scheduled to be "
							+ "activated at " + getEventNote().getTime() + ".",
					"Use method reActivate(TimeSpan dt) to shift the entity "
							+ "to be scheduled at some other point of time.");
			return; // was already scheduled
		}

		if (dt == null) {
			sendWarning(
					"Can't activate simprocess! Command ignored.",
					"SimProcess : " + getName() + " Method:  void activate"
							+ "(TimeSpan dt)",
					"The simulation time given as parameter is a null reference",
					"Be sure to have a valid simulation time reference before "
							+ "calling this method");
			return; // no proper parameter
		}
		// tell in the trace when the SimProcess will be activated
		if (currentlySendTraceNotes()) {
			if (this == currentSimProcess()) {
				if (dt == TimeSpan.ZERO) {
					sendTraceNote("activates itself immediately (NOW)");
				} else {
					if (TimeSpan.isEqual(dt, TimeSpan.ZERO)) {
						sendTraceNote("activates itself now");
					} else {
						sendTraceNote("activates itself at "
								+ TimeOperations.add(presentTime(), dt)
										.toString());
					}
				}
			} else { // this is not the currently running SimProcess

				if (dt == TimeSpan.ZERO) {
					sendTraceNote("activates " + getQuotedName()
							+ " immediately (NOW)");
				} else {
					if (TimeSpan.isEqual(dt, TimeSpan.ZERO)) {
						sendTraceNote("activates " + getQuotedName() + " now");
					} else {
						sendTraceNote("activates "
								+ getQuotedName()
								+ " at "
								+ TimeOperations.add(presentTime(), dt)
										.toString());
					}
				}
			}
		}

		// schedule this SimProcess
		getModel().getExperiment().getScheduler().schedule(this, null, dt);

		// debug output
		if (currentlySendDebugNotes()) {
			sendDebugNote("is activated on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

		resetMaster(); // if activate(TimeSpan dt) is called for this
		// SimProcess,
		// there is no Master anymore controlling it.

	}

	/**
	 * Schedules the SimProcess to be activated at the given point in simulation
	 * time. This will allow a SimProcess to continue executing its
	 * <code>lifeCycle</code> method. Thus in contrast to the entity, no event
	 * is needed for scheduling here.
	 * 
	 * @param dt
	 *            TimeInstant : The point in simulation time this process is to
	 *            be activated.
	 */
	public void activate(TimeInstant when) {
		if (isBlocked()) {
			sendWarning(
					"Can't activate simprocess! Command ignored.",
					"SimProcess : " + getName()
							+ " Method: activate(TimeInstant when)",
					"The simprocess to be activated is blocked inside "
							+ "a higher level synchronization object.",
					"Simprocesses waiting inside higher synchronization "
							+ "constructs can not be activated by other simprocesses or "
							+ "events!");
			return; // is blocked in some synch construction
		}

		if (isScheduled()) {
			sendWarning("Can't activate simprocess! Command ignored.",
					"SimProcess : " + getName()
							+ " Method: activate(TimeInstant when)",
					"The simprocess to be activated is already scheduled to be "
							+ "activated at " + getEventNote().getTime() + ".",
					"Use method reActivate(TimeInstant when) to shift the entity "
							+ "to be scheduled at some other point of time.");
			return; // was already scheduled
		}

		if (when == null) {
			sendWarning(
					"Can't activate simprocess! Command ignored.",
					"SimProcess : " + getName() + " Method:  void activate"
							+ "(TimeInstant when)",
					"The simulation time given as parameter is a null reference",
					"Be sure to have a valid simulation time reference before "
							+ "calling this method");
			return; // no proper parameter
		}
		// tell in the trace when the SimProcess will be activated
		if (currentlySendTraceNotes()) {
			if (this == currentSimProcess()) {
				if (when == presentTime()) {
					sendTraceNote("activates itself immediately (NOW)");
				} else {
					if (TimeInstant.isEqual(when, presentTime())) {
						sendTraceNote("activates itself now");
					} else {
						sendTraceNote("activates itself at " + when.toString());

					}
				}
			} else { // this is not the currently running SimProcess

				if (when == presentTime()) {
					sendTraceNote("activates " + getQuotedName()
							+ " immediately (NOW)");
				} else {
					// stand auch oben: if (dt.getTimeValue() == 0.0) {
					if (TimeInstant.isEqual(when, presentTime())) {
						sendTraceNote("activates " + getQuotedName() + " now");
					} else {
						sendTraceNote("activates " + getQuotedName() + " at "
								+ when.toString());
					}
				}
			}
		}

		// schedule this SimProcess
		getModel().getExperiment().getScheduler().schedule(this, null, when);

		// debug output
		if (currentlySendDebugNotes()) {
			sendDebugNote("is activated on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

		resetMaster(); // if activate(TimeInstant when) is called for this
		// SimProcess,
		// there is no Master anymore controlling it.
	}

	/**
	 * @deprecated Replaced by activate(TimeSpan dt). Schedules the SimProcess
	 *             to be activated at the given time offset to the current
	 *             simulation time. This will allow a SimProcess to continue
	 *             executing its <code>lifeCycle</code> method. Thus in contrast
	 *             to the entity, no event is needed for scheduling here.
	 * 
	 * @param dt
	 *            SimTime : The offset to the current simulation time that this
	 *            SimProcess is due to be activated
	 */
	@Deprecated
	public void activate(SimTime dt) {
		activate(SimTime.toTimeSpan(dt));

	}

	/**
	 * Schedules this simprocess to be activated directly after the given
	 * Schedulable, which itself is already scheduled. Note that this
	 * simprocess' point of simulation time will be set to be the same as the
	 * schedulable's time. Thus this simprocess will continue to execute its
	 * <code>lifeCycle</code> method directly after the given schedulable but
	 * the simulation clock will not change. Please make sure that the
	 * Schedulable given as parameter is actually scheduled.
	 * 
	 * @param after
	 *            Schedulable : The schedulable this simprocess should be
	 *            scheduled after
	 */
	public void activateAfter(Schedulable after) {

		if (after == null) {
			sendWarning(
					"Can't activate this simprocess after the given simprocess "
							+ "parameter! Command ignored.", "SimProcess : "
							+ getName() + " Method: void "
							+ "activateAfter(Schedulable after)",
					"The schedulable given as parameter is a null reference",
					"Be sure to have a valid Schedulable reference before "
							+ "calling this method");
			return; // no proper parameter
		}

		if (isBlocked()) {
			sendWarning(
					"Can't activate simprocess! Command ignored.",
					"SimProcess : " + getName()
							+ " Method: void activateAfter(Schedulable after)",
					"The simprocess to be activated is blocked inside "
							+ "a higher level synchronization object.",
					"Simprocesses waiting inside higher synchronization "
							+ "constructs can not be activated by other simprocesses or "
							+ "events!");
			return; // is blocked in some synch construction
		}

		if (isScheduled()) {
			sendWarning("Can't activate simprocess! Command ignored.",
					"SimProcess : " + getName()
							+ " Method: void activateAfter(Schedulable after)",
					"The simprocess to be activated is already scheduled to be "
							+ "activated at " + getEventNote().getTime() + ".",
					"Use method reActivate(TimeSpan dt) to shift the entity "
							+ "to be scheduled at some other point of time.");
			return; // was already scheduled
		}

		if (currentlySendTraceNotes()) {
			if (this == currentSimProcess()) {
				sendTraceNote("activates itself after " + getQuotedName());
			} else {
				sendTraceNote("activates " + getQuotedName() + " after "
						+ after.getQuotedName());
			}
		}

		// schedule this simprocess
		getModel().getExperiment().getScheduler().scheduleAfter(after, this,
				null);

		if (currentlySendDebugNotes()) {
			sendDebugNote("is activated after " + after.getQuotedName()
					+ " on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

	}

	/**
	 * Schedules this simprocess to be activated directly before the given
	 * schedulable, which itself is already scheduled. Note that this
	 * simprocess' point of simulation time will be set to be the same as the
	 * schedulable's time. Thus this simprocess will continue to execute its
	 * <code>lifeCycle</code> method directly before the given schedulable but
	 * the simulation clock will not change. Please make sure that the
	 * schedulable given as parameter is actually scheduled.
	 * 
	 * @param before
	 *            Schedulable : The schedulable this simprocess should be
	 *            scheduled before
	 */
	public void activateBefore(Schedulable before) {

		if (before == null) {
			sendWarning("Can't activate this simprocess before the given "
					+ "simprocess parameter", "SimProcess : " + getName()
					+ " Method: void activateBefore" + "(Schedulable before)",
					"The Schedulable given as parameter is a null reference",
					"Be sure to have a valid Schedulable reference before "
							+ "calling this method");
			return; // no proper parameter
		}

		if (isBlocked()) {
			sendWarning(
					"Can't activate simprocess! Command ignored.",
					"SimProcess : "
							+ getName()
							+ " Method: void activateBefore(Schedulable before)",
					"The simprocess to be activated is blocked inside "
							+ "a higher level synchronization object.",
					"Simprocesses waiting inside higher synchronization "
							+ "constructs can not be activated by other simprocesses or "
							+ "events!");
			return; // is blocked in some synch construction
		}

		if (isScheduled()) {
			sendWarning(
					"Can't activate simprocess! Command ignored.",
					"SimProcess : "
							+ getName()
							+ " Method: void activateBefore(Schedulable before)",
					"The simprocess to be activated is already scheduled to be "
							+ "activated at " + getEventNote().getTime() + ".",
					"Use method reActivate(TimeSpan dt) to shift the entity "
							+ "to be scheduled at some other point of time.");
			return; // was already scheduled
		}

		if (currentlySendTraceNotes()) {
			if (this == currentSimProcess()) {
				sendTraceNote("activates itself before "
						+ before.getQuotedName());
			} else {
				sendTraceNote("activates " + getQuotedName() + " before "
						+ before.getQuotedName());
			}
		}

		// schedule this simprocess
		getModel().getExperiment().getScheduler().scheduleBefore(before, this,
				null);

		if (currentlySendDebugNotes()) {
			sendDebugNote("activateBefore " + before.getQuotedName()
					+ " on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

		// hand control over to scheduler only if this is
		// a running thread of simprocess
		// if ( isRunning ) passivate();

		resetMaster(); // if activateBefore() is called for this simprocess,
		// there is no Master anymore controlling it.

	}

	/**
	 * Returns <code>true</code> if this process can cooperate with another
	 * SimProcess. If this process is already cooperating with a master
	 * <code>false</code> is returned.
	 * 
	 * @return boolean : Is this process ready to cooperate with another
	 *         SimProcess?
	 * @author Soenke Claassen
	 */
	public boolean canCooperate() {
		return master == null; // if the master is not set yet this SimProcess
		// can cooperate with another SimProcess
	}

	/**
	 * Resets the interrupt-status of this SimProcess to not interrupted. Should
	 * be called every time the SimProcess has successfully dealt with the
	 * interrupt. The internal <code>InterruptCode</code> of this SimProcess
	 * will be reset to <code>null</code>.
	 * 
	 * @author Soenke Claassen
	 */
	public void clearInterruptCode() {
		this.irqCode = null;
	}

	/**
	 * The current (master) process is calling this method (within
	 * <code>WaitQueue.cooperate()</code>) on the slave process to lead him
	 * through the joint cooperation. After the joint cooperation is finished
	 * the master is still active and after him the slave will be activated.
	 * 
	 * @author Soenke Claassen
	 */
	public void cooperate() {
		// this is the slave and current the master

		// check if this slave already has a master
		if (this.master != null) {
			sendWarning(
					"Slaves can not cooperate with more than one master at a "
							+ "time! The attempted cooperation is ignored.",
					"SimProcess : " + getName() + " Method: cooperate () ",
					"This slave process is already cooperating with another "
							+ "master: " + master.getName(),
					"Be sure to have finished one cooperation before starting "
							+ "the next one.");
			return; // this process has a master already
		}

		// check if this slave is not terminated yet
		if (this.isTerminated) {
			sendWarning(
					"Attempt to cooperate with a terminated slave process! "
							+ "The attempted cooperation is ignored.",
					"SimProcess : " + getName() + " Method: cooperate () ",
					"This slave process is already terminated.",
					"Make sure not to cooperate with terminated processes.");
			return; // this process is already terminated
		}

		// check the master
		SimProcess currentMaster = currentSimProcess(); // the current master
		// process
		if (currentMaster == null) // if currentMaster is only a null pointer
		{
			sendWarning("A non existing process is trying to cooperate as a "
					+ "master! The attempted cooperation is ignored!",
					"SimProcess : " + getName() + " Method: cooperate ()",
					"The master process is only a null pointer.",
					"Make sure that only real SimProcesses are cooperating with other "
							+ "processes. ");
			return; // the currentMaster process is only a null pointer
		}

		if (!isModelCompatible(currentMaster)) {
			sendWarning(
					"The given master SimProcess object does not "
							+ "belong to this model. The attempted cooperation is ignored!",
					"SimProcess : " + getName() + " Method: cooperate ()",
					"The master SimProcess is not modelcompatible.",
					"Make sure that the processes all belong to this model.");
			return; // the currentMaster is not modelcompatible
		}

		// the slave must be waiting in a WaitQueue
		if (slaveWaitQueue == null) {
			sendWarning(
					"Attempt to cooperate with a slave process, that is not "
							+ "waiting in a WaitQueue. The attempted cooperation is ignored!",
					"SimProcess : " + getName() + " Method: cooperate ()",
					"Slave processes must wait in a WaitQueue before they can get into "
							+ "a cooperation.",
					"Make sure that the slave processes are waiting in a WaitQueue.");
			return; // the slave is not waiting in a queue
		}

		// now prepare for the real cooperation
		this.master = currentMaster; // set the master for this slave process

		// leave a note in the trace
		if (master.currentlySendTraceNotes()) {
			// trace note for a cooperation without any special conditions
			sendTraceNote("cooperates " + this.getQuotedName() + " from "
					+ slaveWaitQueue.getQuotedName());
		}

		// get this slave out of his slaveWaitQueue
		slaveWaitQueue.remove(this);
		// this slave process is not waiting in any slaveWaitingQueue anymore
		slaveWaitQueue = null;
		// and therefore this slave process is not blocked anymore
		this.isBlocked = false;

	}

	/**
	 * Method to release the waiting scheduler when the SimThread finishes.
	 */
	synchronized void freeThread() {

		notify(); // free the scheduler

	}

	/**
	 * Returns the InterruptCode from this SimProcess. If this SimProcess is not
	 * interrupted, the InterruptCode is <code>null</code>.
	 * 
	 * @return irqCode : The InterruptCode of this SimProcess.
	 * @author Soenke Claassen
	 */
	public InterruptCode getInterruptCode() {
		return irqCode;
	}

	/**
	 * Returns the master when two SimProcesses are cooperating. If this method
	 * is called on a SimProcess which is not a slave <code>null</code> is
	 * returned.
	 * 
	 * @return SimProcess : The master process during the cooperation or
	 *         <code>null</code> if this process is not a slave process.
	 * @author Soenke Claassen
	 */
	public SimProcess getMaster() {
		return master;
	}


	/**Returns the realTime deadline for this SimProcess (in nanoseconds). In case of a
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
	 * Returns the waiting queue in which this SimProcess is waiting as a slave
	 * to cooperate with a master. If this method is called on a SimProcess
	 * which is not a slave <code>null</code> is returned.
	 * 
	 * @return ProcessQueue : The waiting queue in which this SimProcess is
	 *         waiting as a slave or <code>null</code> if this SimProcess is not
	 *         waiting as a slave for cooperation.
	 * @author Soenke Claassen
	 */
	public ProcessQueue getSlaveWaitQueue() {
		return slaveWaitQueue;
	}

	/**
	 * Returns the supervising <code>ComplexSimProcess</code> this SimProcess is
	 * contained in.
	 * 
	 * @return desmoj.ComplexSimProcess : The supervising
	 *         <code>ComplexSimProcess</code> this SimProcess is contained in.
	 *         Is <code>null</code> if this SimProcess is not contained in any
	 *         <code>ComplexSimProcess</code>.
	 * @author Soenke Claassen
	 */
	public ComplexSimProcess getSupervisor() {

		return supervisor;
	}

	/**
	 * Returns a clone of the internal <code>Vector</code> containing all the
	 * <code>Resource</code> objects this SimProcess is using at the moment.
	 * 
	 * @return java.util.Vector : the internal <code>Vector</code> containing
	 *         all the <code>Resource</code> objects this SimProcess is using at
	 *         the moment.
	 * @author Soenke Claassen
	 */
	protected Vector getUsedResources() {

		// clone the internal Vector
		Vector usedRes = (Vector) usedResources.clone();

		// return the cloned Vector
		return usedRes;
	}

	/**
	 * Passivates a simprocess for the given span of time. The simthread of this
	 * simprocess is put into a lock and the scheduler, resp. the experiment's
	 * main thread is released from its block and continues with the next
	 * eventnote to be processed.
	 * 
	 * @param duration
	 *            TimeSpan : The duration of the simprocess' passivation
	 */
	public void hold(TimeSpan dt) {
		if ((dt == null)) {
			sendWarning("Can't schedule simprocess! Command ignored.",
					"SimProcess : " + getName()
							+ " Method: void hold(TimeSpan dt)",
					"The TimeSpan given as parameter is a null reference.",
					"Be sure to have a valid TimeSpan reference before calling this method.");
			return; // no proper parameter
		}

		if (isBlocked()) {
			sendWarning(
					"Can't activate simprocess! Command ignored.",
					"SimProcess : " + getName() + " Method: hold(TimeSpan dt)",
					"The simprocess to be activated is blocked inside "
							+ "a higher level synchronization object.",
					"Simprocesses waiting inside higher synchronization "
							+ "constructs can not be set to be activated by other "
							+ "simprocesses or events!");
			return; // is blocked in some synch construction
		}

		if (isScheduled()) {
			sendWarning("Can't schedule simprocess! Command ignored.",
					"SimProcess : " + getName()
							+ " Method: void hold(TimeSpan dt)",
					"The simprocess to be scheduled is already scheduled.",
					"Use method reActivate(TimeSpan dt) to shift the simprocess "
							+ "to be scheduled at some other point of time.");
			return; // was already scheduled
		}

		if (currentlySendTraceNotes()) {
			if (this == currentSimProcess()) {
				sendTraceNote("holds for " + dt.toString() + " until "
						+ TimeOperations.add(presentTime(), dt).toString());
			} else {
				sendTraceNote("holds " + getQuotedName() + "for "
						+ dt.toString() + " until "
						+ TimeOperations.add(presentTime(), dt).toString());
			}
		}

		// schedule to be reactivated in dt
		getModel().getExperiment().getScheduler().schedule(this, null, dt);

		if (currentlySendDebugNotes()) {
			sendDebugNote("holds on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

		// hand control over to scheduler only if this is
		// a running thread of simprocess
		skipTraceNote();
		passivate();

	}

	/**
	 * Passivates a simprocess until the given point in simulation time. The
	 * simthread of this simprocess is put into a lock and the scheduler, resp.
	 * the experiment's main thread is released from its block and continues
	 * with the next eventnote to be processed.
	 * 
	 * @param until
	 *            TimeInstant : The point in simulation time when the
	 *            simprocess' passivation ends.
	 * 
	 */
	public void hold(TimeInstant until) {
		if ((until == null)) {
			sendWarning("Can't schedule simprocess! Command ignored.",
					"SimProcess : " + getName()
							+ " Method: void hold(TimeInstant until)",
					"The TimeInstant given as parameter is a null reference.",
					"Be sure to have a valid TimeInstant reference before calling this method.");
			return; // no proper parameter
		}

		if (isBlocked()) {
			sendWarning(
					"Can't activate simprocess! Command ignored.",
					"SimProcess : " + getName()
							+ " Method: hold(TimeInstant until)",
					"The simprocess to be activated is blocked inside "
							+ "a higher level synchronization object.",
					"Simprocesses waiting inside higher synchronization "
							+ "constructs can not be set to be activated by other "
							+ "simprocesses or events!");
			return; // is blocked in some synch construction
		}

		if (isScheduled()) {
			sendWarning("Can't schedule simprocess! Command ignored.",
					"SimProcess : " + getName()
							+ " Method: void hold(TimeInstant until)",
					"The simprocess to be scheduled is already scheduled.",
					"Use method reActivate(TimeInstant when) to shift the simprocess "
							+ "to be scheduled at some other point of time.");
			return; // was already scheduled
		}
		
        if (TimeInstant.isBefore(until, presentTime())) {
            sendWarning("Can't schedule simprocess! Command ignored.",
                    "SimProcess : " + getName()
                            + " Method: void hold(TimeInstant until)",
                    "The instant given is in the past.",
                    "To hold a SimProcess, use a TimeInstant no earlier than the present time. "
                            + "The present time can be obtained using the "
                            + "presentTime() method.");
            return; // do not hold
        }

		if (currentlySendTraceNotes()) {
			if (this == currentSimProcess()) {
				sendTraceNote("holds until " + until.toString());
			} else {
				sendTraceNote("holds " + getQuotedName() + "until "
						+ until.toString());
			}
		}

		// schedule to be reactivated at the point of simulation time "until"
		getModel().getExperiment().getScheduler().schedule(this, null, until);

		if (currentlySendDebugNotes()) {
			sendDebugNote("holds on eventlist<br>"
					+ getModel().getExperiment().getScheduler().toString());
		}

		// hand control over to scheduler only if this is
		// a running thread of simprocess
		skipTraceNote();
		passivate();
	}

	/**
	 * @deprecated Replaced by hold(TimeSpan dt). Passivates a simprocess for
	 *             the time given. The simthread of this simprocess is put into
	 *             a lock and the scheduler, resp. the experiment's main thread
	 *             is released from its block and continues with the next
	 *             eventnote to be processed.
	 * 
	 * @param dt
	 *            desmoj.SimTime : The duration of the simprocess' passivation
	 */
	@Deprecated
	public void hold(SimTime dt) {
		hold(SimTime.toTimeSpan(dt));

	}

	/**
	 * Interrupts the SimProcess setting the given InterruptCode as the reason
	 * for the interruption. Blocked, terminated or already interrupted
	 * SimProcesses can not be interrupted. In this case a warning message will
	 * be produced and the interrupt will be ignord. If the SimProcess is
	 * cooperating as a slave the interrupt will be passed to the master.
	 * 
	 * @param interruptReason
	 *            desmoj.InterruptCode
	 */
	public void interrupt(InterruptCode interruptReason) {

		if (interruptReason == null) {
			sendWarning(
					"Can't interrupt simprocess! Command ignored",
					"SimProcess : " + getName() + " Method: void "
							+ "interrupt(InterruptCode interruptReason)",
					"The InterruptCode given as parameter is a null reference.",
					"Be sure to have a valid InterruptCode reference before "
							+ "calling this method.");
			return; // no proper parameter
		}

		// if the SimProcess is cooperating as a slave
		if (master != null) {
			if (currentlySendTraceNotes()) {
				sendTraceNote("interrupts '" + this.getName() + "' , who ...");
			}

			// interrupt the master, too. (with the same reason/InterruptCode)
			master.interrupt(interruptReason);
		}

		if (isBlocked()) {
			sendWarning("Can't interrupt simprocess! Command ignored",
					"SimProcess : " + getName() + " Method: void "
							+ "interrupt(InterruptCode interruptReason)",
					"Blocked SimProcesses can not be interrupted.",
					"You can check if a SimProcess is blocked using method "
							+ "isBlocked().");
			return; // is Blocked
		}

		if (isTerminated()) {
			sendWarning("Can't interrupt simprocess! Command ignored",
					"SimProcess : " + getName() + " Method: void "
							+ "interrupt(InterruptCode interruptReason)",
					"Terminated SimProcesses can not be interrupted.",
					"You can check if a SimProcess is terminated using method "
							+ "isTerminated().");
			return; // is Terminated
		}

		if (irqCode != null) {
			sendWarning(
					"Can't interrupt simprocess! Command ignored",
					"SimProcess : " + getName() + " Method: void "
							+ "interrupt(InterruptCode interruptReason)",
					"SimProcesses has already a InterruptCode set :"
							+ irqCode.getName(),
					"SimProcesses may only be interrupted if no other "
							+ "InterruptCode is set on that SimProcess. You can check "
							+ "on that using mehtod getInterruptCode, which must return "
							+ "null if no other InterruptCode is set.");
			return; // is Interrupted
		}

		if (this == currentSimProcess()) {
			sendWarning("Can't interrupt simprocess! Command ignored",
					"SimProcess : " + getName() + " Method: void "
							+ "interrupt(InterruptCode interruptReason)",
					"SimProcess is the currently active SimProcess.",
					"Make sure not to interrupt the currently active "
							+ "SimProcess.");
			return; // is currentSimProcess
		}

		if (currentlySendTraceNotes()) {
			sendTraceNote("interrupts '" + this.getName() + "', with reason "
					+ interruptReason.getName() + " ["
					+ interruptReason.getCodeNumber() + "]");
		}

		irqCode = interruptReason; // set the InterruptCode

		// if on eventlist, remove first ...
		if (isScheduled()) {
			skipTraceNote(2);
			cancel();
		} else {
			skipTraceNote();
		}
		// ... then activate after the one interrupting this SimProcess
		activateAfter(current());
	}

	/**
	 * Returns the current block-status of the simprocess. If a simprocess is
	 * blocked, it is waiting inside a queue or synchronization block for it's
	 * release.
	 * 
	 * @return boolean : Is <code>true</code> if simprocess is blocked,
	 *         <code>false</code> otherwise
	 */
	public boolean isBlocked() {

		return isBlocked;

	}

	/**
	 * Returns the current component status of this SimProcess. If a SimProcess
	 * is a component of a <code>ComplexSimProcess</code> it is blocked and
	 * passivated. It exists only within the <code>ComplexSimProcess</code>;
	 * it's own lifeCycle is stopped and will only be activated again when it is
	 * removed from the <code>ComplexSimProcess</code>.
	 * 
	 * @return boolean :<code>true</code> if and only if this SimProcess is a
	 *         component (part of) a <code>ComplexSimProcess</code>;
	 *         <code>false</code> otherwise.
	 * @author Soenke Claassen
	 */
	public boolean isComponent() {

		return (supervisor != null);
	}

	/**
	 * Returns the current interrupt-status of this SimProcess. If a SimProcess
	 * is interrupted, it should deal with the interrupt and then call the
	 * <code>clearInterruptCode()</code> -method.
	 * 
	 * @return boolean : Is <code>true</code> if this SimProcess is interrupted,
	 *         <code>false</code> otherwise.
	 * @author Soenke Claassen
	 */
	public boolean isInterrupted() {
		return (irqCode != null);
	}

	/**
	 * Returns the current running status of the simprocess. If a simprocess is
	 * not ready, it has already finished its <code>lifeCycle()</code> method
	 * and can not further be used as a simprocess. A terminated simprocess can
	 * still be used like any other entity which it is derived from.
	 * 
	 * @return boolean : Is <code>true</code> if the simprocess is terminated,
	 *         <code>false</code> otherwise
	 * @see Entity
	 */
	boolean isReady() {

		return isRunning;

	}

	/**
	 * Returns the current status of the simprocess. If a simprocess is
	 * terminated, it has already finished its <code>lifeCycle()</code> method
	 * and can not further be used as a simprocess. A terminated simprocess can
	 * still be used like any other entity which it is derived from.
	 * 
	 * @return boolean : Is <code>true</code> if the simprocess is terminated,
	 *         <code>false</code> otherwise
	 * @see Entity
	 */
	public boolean isTerminated() {

		return isTerminated;

	}

	/**
	 * Override this method in a subclass of simprocess to implement that
	 * simprocess' specific behaviour. This method starts after a simprocess has
	 * been created and activated by the scheduler.
	 */
	public abstract void lifeCycle();

	/**
	 * Makes the SimProcess obtain an array of resources and store them for
	 * further usage.
	 * 
	 * @param obtainedResources
	 *            Resource[] : The array of resources obtained.
	 * 
	 * @author Soenke Claassen
	 */
	public void obtainResources(Resource[] obtainedResources) {
		if (obtainedResources.length <= 0) {
			sendWarning("Attempt to obtain resources, but got none! Command "
					+ "ignored!", "SimProcess : " + getName()
					+ " Method:  void obtain"
					+ "Resources(Resource[] obtainedResources)",
					"The array of obtained resources is empty.",
					"Make sure to obtain at least one resource. Check if the "
							+ "resource pool can provide any resources.");
			return; // parameter contains nothing
		}

		// put all the obtained resources in the Vector of used resources
		for (int i = 0; i < obtainedResources.length; i++) {
			usedResources.addElement(obtainedResources[i]);
		}

		// for debugging purposes
		if (currentlySendDebugNotes()) {
			// make a string of all resources used by this SimProcess
			String t = "uses: ";

			for (Enumeration e = usedResources.elements(); e.hasMoreElements();) {
				t += "<br>" + ((Resource) e.nextElement()).getName();
			}

			sendDebugNote(t);
		}
	}

	/**
	 * Passivates the simprocess for an indefinite time. This method must be
	 * called by the simprocess' own Thread only. The simprocess can only be
	 * reactivated by another simprocess or entity.
	 */
	public synchronized void passivate() {

		if (currentlySendTraceNotes()) {
			if (this == currentSimProcess()) {
				sendTraceNote("passivates");
			} else {
				sendTraceNote("passivates " + getQuotedName());
			}
		}

		notify(); // frees the scheduler after wait()

		try {
			wait();
		} catch (InterruptedException ioEx) {
			// create eror message
			ErrorMessage errmsg = new ErrorMessage(getModel(),
					"Simulation stopped!",
					"Exception thrown by Java VM" + ioEx,
					"Thread conflict assumed.", "Check Java VM.", presentTime());
			// throw it back to Experiment's start routine
			throw (new desmoj.core.exception.DESMOJException(errmsg));
		}

		// if simulation is not running, throw SimFinishedException to stop
		// thread
		if (getModel().getExperiment().isAborted()) {
			throw (new desmoj.core.exception.SimFinishedException(getModel(),
					getName(), presentTime()));
		}

	}

	/**
	 * The current (master) process is calling this method (within
	 * <code>TransportJunction.cooperate()</code>) on the slave process to make
	 * him prepare for the transportation. After the transport is finished the
	 * master is still active and after him the slave will be activated.
	 * 
	 * @author Soenke Claassen
	 */
	public void prepareTransport() {
		// this is the slave and current the master

		// check if this slave already has a master
		if (this.master != null) {
			sendWarning(
					"Slaves can not be transported from more than one master at "
							+ "a time! The attempted transport is ignored.",
					"SimProcess : " + getName()
							+ " Method: prepareTransport () ",
					"This slave process is already transported by another "
							+ "master: " + master.getName(),
					"Be sure to have finished one transportation before starting "
							+ "the next one.");
			return; // this process has a master already
		}

		// check if this slave is not terminated yet
		if (this.isTerminated) {
			sendWarning("Attempt to transport a terminated slave process! "
					+ "The attempted transport is ignored.", "SimProcess : "
					+ getName() + " Method: prepareTransport () ",
					"This slave process is already terminated.",
					"Make sure not to transport terminated processes.");
			return; // this process is already terminated
		}

		// check the master
		SimProcess currentMaster = currentSimProcess(); // the current master
		// process
		if (currentMaster == null) // if currentMaster is only a null pointer
		{
			sendWarning(
					"A non existing process is trying to transport other "
							+ "processes as a master! The attempted transport is ignored!",
					"SimProcess : " + getName()
							+ " Method: prepareTransport ()",
					"The master process is only a null pointer.",
					"Make sure that only real SimProcesses are transporting other "
							+ "processes. ");
			return; // the currentMaster process is only a null pointer
		}

		if (!isModelCompatible(currentMaster)) {
			sendWarning(
					"The given master SimProcess object does not "
							+ "belong to this model. The attempted transport is ignored!",
					"SimProcess : " + getName()
							+ " Method: prepareTransport ()",
					"The master SimProcess is not modelcompatible.",
					"Make sure that the processes all belong to this model.");
			return; // the currentMaster is not modelcompatible
		}

		// the slave must be waiting in a WaitQueue
		if (slaveWaitQueue == null) {
			sendWarning(
					"Attempt to transport a slave process, that is not "
							+ "waiting in a TransportJunction. The attempted transport is ignored!",
					"SimProcess : " + getName()
							+ " Method: prepareTransport ()",
					"Slave processes must wait in a TransportJunction before they can be "
							+ "transported.",
					"Make sure that the slave processes are waiting in a "
							+ "TransportJunction.");
			return; // the slave is not waiting in a queue
		}

		// now prepare for the real cooperation
		this.master = currentMaster; // set the master for this slave process

		// leave a note in the trace
		if (master.currentlySendTraceNotes()) {
			// trace note for a transport without any special conditions
			sendTraceNote("transports " + this.getQuotedName() + " from "
					+ slaveWaitQueue.getQuotedName());
		}

		// get this slave out of his slaveWaitQueue
		slaveWaitQueue.remove(this);
		// this slave process is not waiting in any slaveWaitingQueue anymore
		slaveWaitQueue = null;
		// and therefore this slave process is not blocked anymore
		this.isBlocked = false;

	}

	/**
	 * Re-schedules the SimProcess to be activated at the given TimeSpan offset
	 * to the current simulation time. The Simprocess has already been scheduled
	 * but is now supposed to be reactivated at some other point of simulation
	 * time.
	 * 
	 * @param dt
	 *            TimeSpan : The offset to the current simulation time that this
	 *            SimProcess is due to be re-activated
	 */
	public void reActivate(TimeSpan dt) {
		if (isBlocked()) {
			sendWarning(
					"Can't reactivate simprocess! Command ignored.",
					"SimProcess : " + getName()
							+ " Method: reActivate(TimeSpan dt)",
					"The simprocess to be activated is blocked inside "
							+ "a higher level synchronization object.",
					"Simprocesses waiting inside higher synchronization "
							+ "constructs can not be activated by other simprocesses or "
							+ "events!");
			return; // is blocked in some synch construction
		}

		if (!isScheduled()) {
			sendWarning("Can't reactivate simprocess! Command ignored.",
					"SimProcess : " + getName()
							+ " Method: reActivate(TimeSpan dt)",
					"The simprocess to be reactivated is not scheduled.",
					"Use method activate(TimeSpan dt) to activate a simprocess"
							+ "that is not scheduled yet.");
			return; // was already scheduled
		}

		if (dt == null) {
			sendWarning(
					"Can't reactivate simprocess! Command ignored.",
					"SimProcess : " + getName() + " Method:  void reActivate"
							+ "(TimeSpan dt)",
					"The simulation time given as parameter is a null reference",
					"Be sure to have a valid simulation time reference before "
							+ "calling this method");
			return; // no proper parameter
		}

		if (currentlySendTraceNotes()) {
			if (this == currentSimProcess()) {
				if (dt == TimeSpan.ZERO)
					sendTraceNote("reactivates itself now");
				else
					sendTraceNote("reactivates itself at "
							+ TimeOperations.add(presentTime(), dt));
			} else {
				if (dt == TimeSpan.ZERO)
					sendTraceNote("reactivates " + getQuotedName() + " now");
				else
					sendTraceNote("reactivates " + getQuotedName() + " at "
							+ TimeOperations.add(presentTime(), dt));
			}
		}

		getModel().getExperiment().getScheduler().reSchedule(this, dt);

		resetMaster(); // if reActivate(TimeSpan dt) is called for this
		// SimProcess,
		// there is no Master anymore controlling it.
	}

	/**
	 * Gets the InterruptCode from the master and resets the master to
	 * <code>null</code>.
	 * 
	 * @author Soenke Claassen
	 */
	public void resetMaster() {
		if (this.master != null) {
			irqCode = master.getInterruptCode();
		}

		this.master = null;
	}

	/**
	 * Makes the SimProcess return all resources it holds at the moment to all
	 * the different Res pools it is holding resources from. This is useful in
	 * situations the Simprocess is about to terminate.
	 * 
	 * @author Soenke Claassen
	 */
	public void returnAllResources() {
		// check if something can be returned
		if (usedResources.isEmpty()) {
			sendWarning(
					"Attempt to return all resources, but the "
							+ "SimProcess does not hold any resources! Command ignored!",
					"SimProcess : " + getName()
							+ " Method: returnAllResources()",
					"If the SimProcess does not hold any resources it is "
							+ "impossible to return any.",
					"Make sure that the SimProcess holds resources that "
							+ "should be returned!");
			return; // return nothing, go to where you came from
		}

		// repeat while vector of usedResources is not empty
		while (!usedResources.isEmpty()) {
			// get the first resource and check the Res pool it belongs to
			Res crntResPool = ((Resource) usedResources.firstElement())
					.getResPool();

			// counter how many resources of that res pool are used
			int n = 1;

			// search the whole vector of usedResources for resources of the
			// current
			// Res pool
			for (int i = 1; i < usedResources.size(); i++) {
				// is the resource of the desired Res pool?
				if (((Resource) usedResources.elementAt(i)).getResPool() == crntResPool) {
					n++; // increase the counter
				}
			} // end for-loop

			// make the array to store the resources which will be returned
			Resource[] returningRes = new Resource[n];

			// counter for the index of the array
			int k = 0;

			// collect all the resources from the Vector of usedResources
			for (int j = 0; j < usedResources.size(); j++) {
				// is the resource of the desired Res pool?
				if (((Resource) usedResources.elementAt(j)).getResPool() == crntResPool) {
					// put res in array
					returningRes[k] = (Resource) usedResources.elementAt(j);
					k++; // increase counter of array
				}
				if (k == n) // array is full
					break; // stop the for-loop
			}

			// return the array of resources to the Res pool they belong to
			crntResPool.takeBack(returningRes);

			// remove the returned resources from the vector of usedResources
			for (int m = 0; m < n; m++) // go through the array of
			// returningResources
			{
				// remove each resource that is in the array of
				// returningResources
				usedResources.removeElement(returningRes[m]);
			}

		} // end while

		// for debugging purposes
		if (currentlySendDebugNotes()) {
			// make a string including all elements of the vector usedResources
			String s = "All resources returned! Contents of vector usedResources: ";

			if (usedResources.isEmpty()) // anything left ?
			{
				s += "<br>none";
			}

			for (Enumeration e = usedResources.elements(); e.hasMoreElements();) {
				s += e.nextElement();
			}

			// send a debugNote representing the state of the vector
			// usedResources
			sendDebugNote(s);
		}

	} // end method returnAllResources

	/**
	 * Makes the SimProcess return a certain number of resources of the given
	 * resource pool.
	 * 
	 * @param resPool
	 *            Res : The resource pool which resources will be returned.
	 * @param n
	 *            int : The number of resources which will be returned.
	 * @return Resource[] : the array containing the resources which will be
	 *         returned.
	 * @author Soenke Claassen
	 */
	public Resource[] returnResources(Res resPool, int n) {
		// check if nothing should be returned
		if (n <= 0) {
			sendWarning(
					"Attempt to return no or a negative number of resources! "
							+ " Command ignored!", "SimProcess : " + getName()
							+ " Method:  Resource[] "
							+ "returnResources(Res resPool, int n)",
					"It makes no sense to return nothing or a negative number "
							+ "of resources.",
					"Make sure to return at least one resource. Only resources "
							+ "which have been obtained once can be returned!");
			return null; // return nothing, go to where you came from
		}

		// check if nothing can be returned
		if (usedResources.isEmpty()) {
			sendWarning(
					"Attempt to return a number of resources, but the "
							+ "SimProcess does not hold any resources! Command ignored!",
					"SimProcess : " + getName() + " Method:  Resource[] "
							+ "returnResources(Res resPool, int n)",
					"If the SimProcess does not hold any resources it is "
							+ "impossible to return any.",
					"Make sure that the SimProcess holds the resources that "
							+ "should be returned!");
			return null; // return nothing, go to where you came from
		}

		// make the array to store the resources which will be returned
		Resource[] returningRes = new Resource[n];

		// counter for the index of the array
		int j = 0;

		// collect all the resources from the Vector of usedResources
		for (int i = 0; i < usedResources.size(); i++) {
			// is the resource of the desired kind?
			if (((Resource) usedResources.elementAt(i)).getResPool() == resPool) {
				// put res in array
				returningRes[j] = (Resource) usedResources.elementAt(i);
				j++; // increase counter of array
			}
			if (j == n) // array is full
				break; // stop the for-loop
		}

		// for debugging: make a string of all returning resources
		String s = "<b>returns</b> to Res '" + resPool.getName() + "' : ";

		// remove the returning resources from the vector of usedResources
		for (int m = 0; m < j; m++) // go through the array of
		// returningResources
		{
			// remove each resource that is in the array of returningResources
			usedResources.removeElement(returningRes[m]);

			// add them to string of returning resources
			s += "<br>" + returningRes[m].getName();
		}

		if (j < n) // array is not full
		{
			sendWarning("Attempt to return " + n
					+ " resources to the Res pool. "
					+ "But the SimProcess holds only" + j
					+ "resources of that " + "kind. The " + j
					+ "resources will be returned.", "SimProcess : "
					+ getName() + " Method:  Resource[] "
					+ "returnResources(Res resPool, int n)",
					"The SimProcess can not return " + n + " resources, "
							+ "because it holds only" + j + "resources.",
					"Make sure that the SimProcess holds at least as many "
							+ "resources as it should return.");
		}

		// for debugging purposes
		if (currentlySendDebugNotes()) {
			sendDebugNote(s);

			// make a string of all resources still held by this SimProcess
			String t = "still holds: ";

			if (usedResources.isEmpty()) // anything left ?
			{
				t += "<br>none";
			}

			for (Enumeration e = usedResources.elements(); e.hasMoreElements();) {
				t += "<br>" + ((Resource) e.nextElement()).getName();
			}

			sendDebugNote(t);
		}

		return returningRes; // return the array of resources
	}

	/**
	 * Sets the simprocess' blocked status to the boolean value given. This is
	 * necessary for some operations in conjunction with some synchronization
	 * classes.
	 * 
	 * @param blockStatus
	 *            boolean : The new value for the blocked status
	 */
	public void setBlocked(boolean blockStatus) {

		isBlocked = blockStatus;

	}
	
	/**Sets the realTime deadline for this SimProcess (in nanoseconds). In case of a
	 * real-time execution (i. e. the execution speed rate is set to a positive
	 * value) the Scheduler will produce a warning message if a deadline is
	 * missed.
	 * 
	 * @param realTimeConstraint the realTimeConstraint in nanoseconds to set
	 */
	public void setRealTimeConstraint(long realTimeConstraint) {
		this.realTimeConstraint = realTimeConstraint;
	}
	
	/**
	 * Sets the simprocess' running status to the boolean value given. This is
	 * necessary for some operations in conjunction with synchronization
	 * classes.
	 * 
	 * @param runStatus
	 *            boolean : The new value for the running status
	 */
	void setRunning(boolean runStatus) {

		isRunning = runStatus;

	}

	/**
	 * Sets the simprocess' slaveWaitQueue variable to the ProcessQueue in which
	 * this SimProcess is waiting as a slave to cooperate with a master.
	 * 
	 * @param slvWaitQueue
	 *            ProcessQueue : The waiting queue in which this SimProcess is
	 *            waiting as a slave to cooperate with a master.
	 * @author Soenke Claassen
	 */
	public void setSlaveWaitQueue(ProcessQueue slvWaitQueue) {
		slaveWaitQueue = slvWaitQueue;
	}

	/**
	 * Sets the supervising <code>ComplexSimProcess</code> this SimProcess is
	 * contained in. Setting it to <code>null</code> indicates that this
	 * SimProcess is not contained in any <code>ComplexSimProcess</code>
	 * (anymore).
	 * 
	 * @param complexProcess
	 *            desmoj.ComplexSimProcess : The <code>ComplexSimProcess</code>
	 *            which serves as a container for this SimProcess.
	 * @author Soenke Claassen
	 */
	protected void setSupervisor(ComplexSimProcess complexProcess) {

		this.supervisor = complexProcess;
	}

	/**
	 * Sets the attribute indicating that this simprocess' simthread has
	 * finished to the given value. This method is used by class
	 * <code>SimThread<code> only.
	 * 
	 * @param termValue
	 *            boolean : The new value for the attribute indicating the
	 *            SimThread's end
	 */
	void setTerminated(boolean termValue) {

		isTerminated = termValue; // Hasta la vista, baby!

	}

	/**
	 * Starts the simthread associated with this simprocess. This is method must
	 * be called the first time a simprocess is supposed to start processing its
	 * <code>lifeCycle()</code> method.
	 */
	synchronized void start() {

		// setting this flag shows that the simthread is now ready to take over
		// control from the scheduler's thread
		isRunning = true;

		// start thread and let it run into the block
		myThread.start();

		// put thread in to a wait for synchronization
		try {
			wait();
		} catch (InterruptedException irqEx) {
			// create eror message
			ErrorMessage errmsg = new ErrorMessage(getModel(),
					"Simulation stopped!", "Exception thrown by Java VM"
							+ irqEx, "Thread conflict assumed.",
					"Check Java VM.", presentTime());
			// throw it back to Experiment's start routine
			throw (new desmoj.core.exception.DESMOJException(errmsg));
		}

		// check if simulation has been stopped in between and throw SimFinished
		if (getModel().getExperiment().isAborted()) {
			throw (new desmoj.core.exception.SimFinishedException(getModel(),
					getName(), presentTime()));
		}
	}
} // end class SimProcess
