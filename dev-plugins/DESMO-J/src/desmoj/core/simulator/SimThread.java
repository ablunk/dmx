package desmoj.core.simulator;

import desmoj.core.exception.*;
import desmoj.core.report.ErrorMessage;

/**
 * SimThreads are used to mimic coroutine behaviour with the help of native Java
 * threads. SimThreads are attributes of SimProcesses only.
 * 
 * @version DESMO-J, Ver. 2.3.5 copyright (c) 2013
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
public class SimThread extends Thread {

	/**
	 * The SimProcess this simthread serves for.
	 */
	SimProcess simProc;

	/**
	 * Constructs a simple SimThread for the given SimProcess object in the
	 * given threadgroup. The threadgroup is defined by the experiment the
	 * SimThread's SimProcess is associated to. For better identification and
	 * easier debugging, the SimThread carries the SimProcess' name.
	 * 
	 * @param group
	 *            java.lang.ThreadGroup : The SimProcess' threadgroup
	 * @param siPro
	 *            SimProcess : The SimProcess
	 */
	SimThread(ThreadGroup group, SimProcess siPro) {

		super(group, siPro.getName());
		simProc = siPro;

	}

	/**
	 * Returns the status of the SimProcess wether it is still running active
	 * with this simthread or not. A return value of <code>true</code> indicates
	 * that this simthread is still alive while <code>false</code> indicates
	 * that the simthread is not in a blocking situation any more since it has
	 * exited its <code>run()</code> method.
	 * 
	 * @return boolean : Is <code>true</code> if the simthread is still alive,
	 *         <code>false</code> if the simthread has exited its
	 *         <code>run()</code> method
	 */
	boolean isRunning() {
		return simProc.isReady();
	}

	/**
	 * Method is used to stop all running threads after an experient is stopped.
	 * Calls the SimProcess' <code>clearThread()<code> method to free the
	 * scheduler waiting in the block.
	 */
	void kill() {

		simProc.resume();

	}

	/**
	 * Run starts when the associated SimProcess is activated for the first
	 * time. To prevent numerous simthread from running amok, they are
	 * immediately forced into a Java native wait situation where they can be
	 * released from using the method <code>activate(TimeSpan dt)</code> or
	 * <code>activate(TimeInstant time)</code>.
	 */
	public void run() {

		// let all other threads, esp. the main thread get into the block
		// yield();
		// catch SimFinishedExceptions to clear this thread
		// needed to get all SimProcesses cleared up after end of simulation
		try {
            long run = 0;
            do {
                run++;
                if (simProc.currentlySendTraceNotes()) {
                    if (simProc.isRepeating())
                        simProc.sendTraceNote("starts (run #" + run + ")");
                    else
                        simProc.sendTraceNote("starts");
                }
                simProc.lifeCycle();
            } while (simProc.isRepeating());
			if (simProc.currentlySendTraceNotes()) {
				simProc.sendTraceNote("terminates");
			}
        } catch (SimFinishedException sfEx) {
            ; // nothing done here, sfEx was just used to
                // finish this simthread after end of simulation
        } catch (InterruptException irqEx) {
            throw new SimAbortedException(
                    new ErrorMessage(
                            simProc.getModel(),
                            "The simulation has been aborted due to an unhandled interrupt.",
                            "SimProcess: " + simProc.getName() + " Method: void lifeCycle()",
                            "The current SimProcess has been interrupted by a call to its interrupt(InterruptException interruptReason) method but this interrupt hasn't been properly handled by catching the given InterruptException.",
                            "To properly handle an interrupt triggered by an InterruptException every call to the methods hold(...) and passivate() has to be surrounded with a try-block so that the InterruptException is caught and can be handled in an adjacent catch-block.",
                            simProc.getModel().getExperiment().getSimClock().getTime()));
        } catch (DESMOJException dEx) {
            simProc.getModel().getExperiment().interrupt(dEx); // transfer to experiment in main thread
        }
		
		// update running status, which is now stopped concerning the model
		simProc.setRunning(false);

		// update status flag for using the SimProcess' simthread
		simProc.setTerminated(true);

		// release the waiting scheduler
		simProc.freeThread();

		// for debugging purposes only
		// System.out.println(getName()+" exits");
	}
}