package desmoj.core.advancedModellingFeatures;

import desmoj.core.simulator.QueueBased;
import desmoj.core.simulator.QueueList;
import desmoj.core.simulator.QueueListFifo;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.TimeInstant;
import desmoj.core.simulator.TimeOperations;
import desmoj.core.simulator.TimeSpan;

/**
 * Bin is the place where producers can store their products for consumers to
 * come and use them up. Bin is used to implement process synchronization
 * between producers and consumers. Producers are producing products and store
 * them using <code>store()</code> in the bin. Consumers make the Bin
 * <code>deliver()</code> the products to use them up. If no or not enough
 * units of a product are available for the consumers, they have to wait in a
 * queue until new units are delivered by a producer. The first sort criteria of
 * the queue is always highest priorities first, the second queueing discipline
 * of the underlying queue and the capacity limit can be determined by the user
 * (default is Fifo and unlimited capacity). Bin is derived from QueueBased,
 * which provides all the statistical functionality for a queue.
 * 
 * @see QueueBased
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Soenke Claassen
 * @author based on DESMO-C from Thomas Schniewind, 1998
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

public class Bin extends desmoj.core.simulator.QueueBased {

	// ****** attributes ******

	/**
	 * The queue, actually storing the processes waiting for products
	 */
	private QueueList queue;

	/**
	 * The initial number of products in the Bin
	 */
	private long initial;

	/**
	 * The maximum number of products in the Bin
	 */
	private long maximum;

	/**
	 * Number of products available at the moment
	 */
	private long avail;

	/**
	 * Number of producers having visited the Bin
	 */
	private long producers;

	/**
	 * Number of consumers having visited the Bin
	 */
	private long consumers;

	/**
	 * Weighted sum of available products in the Bin over the time (must be
	 * divided by the total time to get the average available units!)
	 */
	private double wSumAvail;

	/**
	 * The last time the Bin has been used
	 */
	private TimeInstant lastUsage;

	/**
	 * Indicates the method where something has gone wrong. Is passed as a
	 * parameter to the method <code>checkProcess()</code>.
	 */
	private String where;

	/**
	 * Counter for the SimProcesses which are refused to be enqueued, because
	 * the queue capacity is full.
	 */
	private long refused;

	/**
	 * Flag to indicate whether an entity can pass by other entities in the
	 * queue which are enqueued before that entity in the queue. Is
	 * <code>false</code> per default.
	 */
	private boolean passBy = false;

	// ****** methods ******

	/**
	 * Constructor for a Bin with a number of initial units of a product in it.
	 * The queueing discipline and the capacity limit of the underlying queue
	 * can be chosen, too. Highest priority are always first in the queue.
	 * 
	 * @param owner
	 *            Model : The model this Bin is associated to.
	 * @param name
	 *            java.lang.String : The Bin's name
	 * @param sortOrder
	 *            int : determines the sort order of the underlying queue
	 *            implementation. Choose a constant from <code>QueueBased</code>
	 *            like <code>QueueBased.FIFO</code> or
	 *            <code>QueueBased.LIFO</code> or ...
	 * @param qCapacity
	 *            int : The capacity of the queue, that is how many processes
	 *            can be enqueued. Zero (0) means unlimited capacity.
	 * @param initialUnits
	 *            long : The units of a product the Bin starts with. Must be
	 *            positive.
	 * @param showInReport
	 *            boolean : Flag, if Bin should produce a report or not.
	 * @param showInTrace
	 *            boolean : Flag for trace to produce trace messages.
	 */
	public Bin(desmoj.core.simulator.Model owner, String name, int sortOrder,
			int qCapacity, long initialUnits, boolean showInReport,
			boolean showInTrace) {
		super(owner, name, showInReport, showInTrace); // construct QueueBased
		reset();

		this.initial = initialUnits;
		this.maximum = initialUnits;
		this.avail = initialUnits;

		if (initialUnits < 0) // there can't be less than nothing
		{
			sendWarning("Attempt to construct a Bin with a negativ number of"
					+ " units. Initial number of units set to zero!", "Bin: "
					+ getName() + " Constructor: Bin (desmoj.Model owner, "
					+ "String name, long initialUnits, boolean showInReport, "
					+ "boolean showInTrace)",
					"A negative number of units does not make sense here.",
					"Make sure to initialize a Bin always with a positive number of "
							+ "initialUnits.");

			initial = maximum = avail = 0; // set it to 0, that makes more
			// sense
		}

		// check if a valid sortOrder is given
		if (sortOrder < 0) {
			sendWarning(
					"The given sortOrder parameter is negative! "
							+ "A queue with Fifo sort order will be created.",
					"Bin : "
							+ getName()
							+ " Constructor: Bin (desmoj.Model owner, String name, "
							+ "int sortOrder, long qCapacity, long initialUnits, "
							+ "boolean showInReport, boolean showInTrace)",
					"A valid positive integer number must be provided to "
							+ "determine the sort order of the underlying queue.",
					"Make sure to provide a valid positive integer number "
							+ "by using the constants in the class QueueBased, like "
							+ "QueueBased.FIFO or QueueBased.LIFO.");
			// make a Fifo queue
			queue = new QueueListFifo(); // better than nothing
			queue.setQueueBased(this);
		} else {
			try {
				// determine the queueing strategy
				Class queueListStrategy = queueingStrategy[sortOrder];

				queue = (QueueList) queueListStrategy.newInstance();
			}

			catch (ArrayIndexOutOfBoundsException arrayExcept) {
				// the given sortOrder is not valid
				sendWarning(
						"The given sortOrder parameter is not valid! "
								+ "A queue with Fifo sort order will be created.",
						"Bin : "
								+ getName()
								+ " Constructor: Bin (desmoj.Model owner, String name, "
								+ "int sortOrder, long qCapacity, long initialUnits, "
								+ "boolean showInReport, boolean showInTrace)",
						"A valid positive integer number must be provided to "
								+ "determine the sort order of the underlying queue.",
						"Make sure to provide a valid positive integer number "
								+ "by using the constants in the class QueueBased, like "
								+ "QueueBased.FIFO or QueueBased.LIFO.");
				// make a Fifo queue
				queue = new QueueListFifo(); // better than nothing
			}

			catch (IllegalAccessException illAccExcept) {
				// the class to be loaded can not be found
				sendWarning(
						"IllegalAccessException: The class implementing the "
								+ "sortOrder of the queue can not be found. A queue with "
								+ "Fifo sort order will be created instead.",
						"Bin : "
								+ getName()
								+ " Constructor: Bin (desmoj.Model owner, String name, "
								+ "int sortOrder, long qCapacity, long initialUnits, "
								+ "boolean showInReport, boolean showInTrace)",
						"Programm error when trying to create an instance of a "
								+ "class. Maybe the zero-argument constructor of that "
								+ "class can not be found",
						"Make sure to provide a valid positive integer number "
								+ "for the sort order by using the constants in the class "
								+ "QueueBased, like QueueBased.FIFO or QueueBased.LIFO. "
								+ "Contact one of the developers of DESMO-J!");
				// make a Fifo queue
				queue = new QueueListFifo(); // better than nothing
			}

			catch (InstantiationException instExcept) {
				// no object of the given class can be instantiated
				sendWarning(
						"InstantiationException: No object of the given class "
								+ "can be instantiated! A queue with Fifo sort order will "
								+ "be created instead.",
						"Bin : "
								+ getName()
								+ " Constructor: Bin (desmoj.Model owner, String name, "
								+ "int sortOrder, long qCapacity, long initialUnits, "
								+ "boolean showInReport, boolean showInTrace)",
						"Programm error when trying to create an instance of a "
								+ "class. Maybe the the class is an interface or an "
								+ "abstract class that can not be instantiated",
						"Make sure to provide a valid positive integer number "
								+ "for the sort order by using the constants in the class "
								+ "QueueBased, like QueueBased.FIFO or QueueBased.LIFO. "
								+ "Contact one of the developers of DESMO-J!");
				// make a Fifo queue
				queue = new QueueListFifo(); // better than nothing
			}

			// give the QueueList a reference to this QueueBased
			queue.setQueueBased(this);
		}

		// set the capacity of the queue
		queueLimit = qCapacity;

		// check if it the capacity does make sense
		if (qCapacity < 0) {
			sendWarning(
					"The given capacity of the queue is negative! "
							+ "A queue with unlimited capacity will be created instead.",
					"Bin : "
							+ getName()
							+ " Constructor: Bin (desmoj.Model owner, String name, "
							+ "int sortOrder, long qCapacity, long initialUnits, "
							+ "boolean showInReport, boolean showInTrace)",
					"A negative capacity for a queue does not make sense.",
					"Make sure to provide a valid positive capacity "
							+ "for the underlying queue.");
			// set the capacity to the maximum value
			queueLimit = Integer.MAX_VALUE;
		}

		// check if qCapacity is zero (that means unlimited capacity)
		if (qCapacity == 0) {
			// set the capacity to the maximum value
			queueLimit = Integer.MAX_VALUE;
		}

	}

	// ****** methods ******

	/**
	 * Constructor for a Bin with a number of initial units of a product in it.
	 * The underlying queue has a Fifo queueing discipline and unlimited
	 * capacity.
	 * 
	 * @param owner
	 *            Model : The model this Bin is associated to.
	 * @param name
	 *            java.lang.String : The Bin's name
	 * @param initialUnits
	 *            long : The units of a product the Bin starts with. Must be
	 *            positive.
	 * @param showInReport
	 *            boolean : Flag, if Bin should produce a report or not.
	 * @param showInTrace
	 *            boolean : Flag for trace to produce trace messages.
	 */
	public Bin(desmoj.core.simulator.Model owner, String name,
			long initialUnits, boolean showInReport, boolean showInTrace) {
		super(owner, name, showInReport, showInTrace); // construct QueueBased
		reset();

		queue = new QueueListFifo(); // make an actual queue and give it a
		queue.setQueueBased(this); // reference of this "QueueBased"-Bin

		this.initial = initialUnits;
		this.maximum = initialUnits;
		this.avail = initialUnits;

		if (initialUnits < 0) // there can't be less than nothing
		{
			sendWarning("Attempt to construct a Bin with a negativ number of"
					+ " units. Initial number of units set to zero!", "Bin: "
					+ getName() + " Constructor: Bin (desmoj.Model owner, "
					+ "String name, long initialUnits, boolean showInReport, "
					+ "boolean showInTrace)",
					"A negative number of units does not make sense here.",
					"Make sure to initialize a Bin always with a positive number of "
							+ "initialUnits.");

			initial = maximum = avail = 0; // set it to 0, that makes more
			// sense
		}
	}

	/**
	 * Activates the SimProcess <code>process</code>, given as a parameter of
	 * this method, as the next process. This process should be a SimProcess
	 * waiting in the queue for some products.
	 * 
	 * @param process
	 *            SimProcess : The process that is to be activated as next.
	 */
	protected void activateAsNext(SimProcess process) {
		where = "protected void activateAsNext(SimProcess process)";

		if (process != null) {
			// if the given process is not valid just return
			if (!checkProcess(process, where)) {
				return;
			}

			// if the process is scheduled (on the event list) already
			if (process.isScheduled()) {
				process.skipTraceNote(); // don't tell the user, that we ...
				process.cancel(); // get the process from the EventList
			}

			// remember if the process is blocked at the moment
			boolean wasBlocked = process.isBlocked();

			// unblock the process to be able to activate him
			if (wasBlocked) {
				process.setBlocked(false); // the process is not blocked
				// anymore
				// and
			} // ready to become activated

			// don't tell the user, that we activate the process after the
			// current process
			process.skipTraceNote();
			process.activateAfter(current());

			// the process status is still "blocked"
			if (wasBlocked) {
				process.setBlocked(true);
			}
		} // end outer if
	}

	/**
	 * Activates the first process waiting in the queue. That is a process which
	 * was trying to take products, but it could not get any because there were
	 * not enough products for it or another process was first in the queue to
	 * be served. This method is called every time a producer has given new
	 * products or a consumer in the waiting queue is satisfied.
	 */
	protected void activateFirst() {
		where = "protected void activateFirst()";

		// first is the first process in the queue (or null if none is in the
		// queue)
		SimProcess first = (SimProcess) queue.first();

		if (first != null) {
			// if first is not modelcompatible just return
			if (!checkProcess(first, where)) {
				return;
			}

			// if first is scheduled (on the event list) already
			if (first.isScheduled()) {
				first.skipTraceNote(); // don't tell the user, that we ...
				first.cancel(); // get the process from the Eventlist
			}

			// remember if first is blocked at the moment
			boolean wasBlocked = first.isBlocked();

			// unblock the process to be able to activate him
			if (wasBlocked) {
				first.setBlocked(false);
			}

			// don't tell the user, that we activate first after the current
			// process
			first.skipTraceNote();
			first.activateAfter(current());

			// the status of first is still "blocked"
			if (wasBlocked) {
				first.setBlocked(true);
			}
		} // end outer if
	}

	/**
	 * Returning the average number of products available in the bin over the
	 * time since the last reset of the bin.
	 * 
	 * @return double : The average number of products available in the bin over
	 *         the time since the last reset of the bin.
	 */
	public double avgAvail() {
		TimeInstant now = presentTime(); // what is the time?
		// how long since the last reset
		TimeSpan diff = TimeOperations.diff(now, resetAt());

		// update the weighted sum of available units
		double wSumAvl = wSumAvail
				+ ((double) avail * TimeOperations.diff(now, lastUsage).getTimeInEpsilon());

		if (TimeSpan.isEqual(diff,TimeSpan.ZERO)) // diff is not long enough
		{
			sendWarning("A Division-by-Zero error occured in a calculation. "
					+ "The UNDEFINED Value: -1.0 is returned as result.",
					"Bin: " + getName() + " Method: double avgAvail ()",
					"The Time difference is shorter than epsilon.",
					"Make sure not to use avgAvail() right after a reset.");
			return UNDEFINED; // see QueueBased: UNDEFINED = -1
		}
		// return the rounded average
		return java.lang.Math.rint(100000 * (wSumAvl / diff.getTimeInEpsilon())) / 100000;
	}

	/**
	 * Checks whether the entity using the bin is a valid process.
	 * 
	 * @return boolean : Returns whether the SimProcess is valid or not.
	 * @param p
	 *            SimProcess : Is this SimProcess a valid one?
	 * @param where
	 *            String : The method having called <code>checkProcess()</code>
	 *            as a String.
	 */
	protected boolean checkProcess(SimProcess p, String where) {
		if (p == null) // if p is a null pointer instead of a process
		{
			sendWarning(
					"A non existing process is trying to use a Bin object. "
							+ "The attempted action is ignored!", "Bin: "
							+ getName() + " Method: " + where,
					"The process is only a null pointer.",
					"Make sure that only real SimProcesses are using Bins.");
			return false;
		}

		if (!isModelCompatible(p)) // if p is not modelcompatible
		{
			sendWarning("The process trying to use a Bin object does not "
					+ "belong to this model. The attempted action is ignored!",
					"Bin: " + getName() + " Method: " + where,
					"The process is not modelcompatible.",
					"Make sure that processes are using only Bins within their model.");
			return false;
		}

		return true;
	}

	/**
	 * Returns a Reporter to produce a report about this Bin.
	 * 
	 * @return desmoj.report.Reporter : The Reporter for the queue inside this
	 *         bin
	 */
	public desmoj.core.report.Reporter createReporter() {
		return new desmoj.core.advancedModellingFeatures.report.BinReporter(
				this);
	}

	/**
	 * Method for consumers to make the Bin deliver a number of n products. When
	 * there are not enough products available or another consumer is first in
	 * the queue to be served (and it is not possible to pass by), the current
	 * consumer process will be blocked and inserted in the waiting queue.
	 * 
	 * @return boolean : Is <code>true</code> if the specified number of units
	 *         have been delivered successfully, <code>false</code> otherwise
	 *         (i.e. capacity limit of the queue is reached).
	 * @param n
	 *            long : The number of products the Bin is delivering to the
	 *            consumer.
	 */
	public boolean retrieve(long n) {
		where = "boolean retrieve (long n)";

		SimProcess currentProcess = currentSimProcess();

		if (!checkProcess(currentProcess, where)) // check the current process
		{
			return false;
		} // if it is not valid return false

		if (n <= 0) // if the process is taking nothing or less
		{
			sendWarning(
					"Attempt to take nothing or a negative number of units"
							+ " out of a Bin. The attempted action is ignored!",
					"Bin: " + getName() + " Method: " + where,
					"It does not make sense to take nothing or less out of a Bin. "
							+ "The statistic will be corrupted with negative numbers!",
					"Make sure to take at least one unit out of the Bin.");
			return false; // go to where you came from; ignore that rubbish
		}

		if (queueLimit <= length()) // check if capac. limit of queue is reached
		{
			if (currentlySendDebugNotes()) {
				sendDebugNote("refuses to insert "
					+ currentProcess.getQuotedName()
					+ " in waiting queue, because the capacity limit is reached. ");
			}

			if (currentlySendTraceNotes()) {
				sendTraceNote("is refused to be enqueued in "
					+ this.getQuotedName() + "because the capacity limit ("
					+ getQueueLimit() + ") of the " + "queue is reached");
			}

			refused++; // count the refused ones

			return false; // capacity limit is reached
		}

		// insert every process in the queue for statistic reasons
		queue.insert(currentProcess);

		// is it possible for this process to pass by?
		if (passBy == false) {
			if (n > avail || // not enough products available OR
					currentProcess != queue.first()) // other process is
			// first
			// in the q
			{
				// tell in the trace what the process is waiting for
				if (currentlySendTraceNotes()) {
					sendTraceNote("awaits " + n + " of '" + this.getName()
							+ "'");
				}

				// for debugging purposes
				if (currentlySendDebugNotes()) {
					sendDebugNote("can not deliver " + n + " units for "
							+ currentProcess.getQuotedName() + "<br>"
							+ "because there are only " + getAvail()
							+ " units " + "right now.");
				}

				do { // the process is stuck in here
					currentProcess.setBlocked(true); // as long as ...see
					// while
					currentProcess.skipTraceNote(); // don't tell the user, that
					// we ...
					currentProcess.passivate(); // passivate the current process
				} while (n > avail || // not enough products available OR
						currentProcess != queue.first()); // other process is
				// first
			} // end if

		} // end if (passBy = false)

		else // the process can pass by other processes in the queue, passBy
		// =
		// true
		{
			if (n > avail || // not enough products available OR
					currentProcess != queue.first()) // other process is
			// first
			// in the q
			{
				// if this process is not the first in the queue
				if (currentProcess != queue.first()) {
					// we have to make sure that no other process in front of
					// this current
					// process in the wait queue could be satisfied, so activate
					// the first Process in the queue to see what he can do. He
					// will pass
					// the activation on to his successors until this process
					// will be
					// activated again to get his products. (hopefully)
					activateFirst();
				}

				// only if not enough units are available the process has to
				// wait
				if (n > avail) {
					// tell in the trace what the process is waiting for
					if (currentlySendTraceNotes()) {
						sendTraceNote("awaits " + n + " of '" + this.getName()
								+ "'");
					}

					// for debugging purposes
					if (currentlySendTraceNotes()) {
						sendDebugNote("can not deliver " + n + " units for "
								+ currentProcess.getQuotedName() + "<br>"
								+ "because there are only " + getAvail()
								+ " units " + "right now.");
					}
				} // end if not enough units are available

				// block and passivate the process until enough products are
				// available
				do { // the process is stuck in here
					currentProcess.setBlocked(true); // as long as ...see
					// while
					currentProcess.skipTraceNote(); // don't tell the user, that
					// we ...
					currentProcess.passivate(); // passivate the current process

					// activate the next process in the queue to see what he can
					// do
					activateAsNext((SimProcess) queue.succ(currentProcess));
				} while (n > avail); // not enough products available
			}
		} // end else (passBy = true)

		// the current process has got the products he wanted ...

		// tell in the trace what the process is taking from the Bin
		if (currentlySendTraceNotes()) {
			sendTraceNote("takes " + n + " from '" + this.getName() + "'");
		}

		queue.remove(currentProcess); // get the process out of the queue
		currentProcess.setBlocked(false); // we are not blocked (anymore),
		// yeah!

		// activate the new first process in the queue
		activateFirst();

		updateStatistics(-n); // statistics will be updated
		// with a negative n for deliver(), remember?!
		return true;
	}

	/**
	 * Returns the number of units available at the moment.
	 * 
	 * @return long : The number of units available at the moment.
	 */
	public long getAvail() {
		return this.avail;
	}

	/**
	 * Returns the number of consumers having visited the Bin.
	 * 
	 * @return long : The number of consumers having visited the bin.
	 */
	public long getConsumers() {
		return this.consumers;
	}

	/**
	 * Returns the initial number of products in the bin.
	 * 
	 * @return long : The number of products the bin started with.
	 */
	public long getInitial() {
		return this.initial;
	}

	/**
	 * Returns the maximum number of products in the bin.
	 * 
	 * @return long : The maximum number of products in the bin.
	 */
	public long getMaximum() {
		return this.maximum;
	}

	/**
	 * Returns whether entities can pass by other entities which are enqueued
	 * before them in the queue.
	 * 
	 * @return boolean : Indicates whether entities can pass by other entities
	 *         which are enqueued before them in the queue.
	 */
	public boolean getPassBy() {
		return passBy;
	}

	/**
	 * Returns the number of producers having used the Bin.
	 * 
	 * @return long : The number of producers having put products in the bin.
	 */
	public long getProducers() {
		return this.producers;
	}

	/**
	 * Returns the implemented queueing discipline of the underlying queue as a
	 * String, so it can be displayed in the report.
	 * 
	 * @return String : The String indicating the queueing discipline.
	 */
	public String getQueueStrategy() {

		return queue.getAbbreviation(); // that's it

	}

	/**
	 * Returns the number of entities refused to be enqueued in the queue,
	 * because the capacity limit is reached.
	 * 
	 * @return long : The number of entities refused to be enqueued in the
	 *         queue.
	 */
	public long getRefused() {

		return refused; // that's it
	}

	/**
	 * To reset the statistics of this bin. The number of available products at
	 * this moment and the processes waiting in the queue are not changed. But
	 * all statistic counters are reset. The <code>QueueBased</code> is also
	 * reset.
	 */
	public void reset() {
		super.reset(); // reset the QueueBased also

		maximum = avail;
		producers = 0;
		consumers = 0;
		wSumAvail = 0.0;
		lastUsage = presentTime();
		refused = 0;
	}

	/**
	 * Sets the flag passBy to a new value. PassBy is indicating whether
	 * entities can pass by other entities which are enqueued before them in the
	 * queue.
	 * 
	 * @param newPassBy
	 *            boolean : The new value of passBy. Set it to <code>true</code>
	 *            if you want entities to pass by other entities which are
	 *            enqueued before them in the queue. Set it to
	 *            <code>false</code> if you don't want entities to overtake
	 *            other entities in the queue.
	 */
	public void setPassBy(boolean newPassBy) {
		this.passBy = newPassBy; // that's all!
	}

	/**
	 * Method for producers to put a number of n new products in the Bin. When
	 * producers <code>store()</code> new products n is positive. Producers
	 * can always store products into the Bin and will never be inserted in a
	 * queue and blocked, because the Bin has no capacity limit..
	 * 
	 * @param n
	 *            long : The number of products put into the Bin.
	 */
	public void store(long n) {
		where = "void store (long n)";

		SimProcess currentProcess = currentSimProcess();

		if (!checkProcess(currentProcess, where)) // if the current process
		{
			return;
		} // is not valid: just return

		if (n <= 0) // trying to store nothing or less, don't fool me!
		{
			sendWarning(
					"Attempt to store nothing or a negative number of units"
							+ " in a Bin. The attempted action is ignored!",
					"Bin: " + getName() + " Method: void store (long n)",
					"It does not make sense to put nothing or less into a Bin. "
							+ "The statistic will be corrupted with negative numbers!",
					"Make sure to store at least one unit in the Bin.");
			return; // ignore it and just return
		}

		if (currentlySendTraceNotes()) {
			sendTraceNote("stores " + n + " to '" + getName() + "'");
		} // tell in the trace what the process is giving into the Bin

		updateStatistics(n);

		// see if someone is in the queue waiting for products
		activateFirst();
	}

	/**
	 * Updates the statistics for producers and consumers.
	 * 
	 * @param n
	 *            long : Is positive when producers <code>store()</code> new
	 *            products in the bin and negative when the Bin
	 *            <code>deliver()</code>'s products to the consumer process.
	 */
	protected void updateStatistics(long n) {
		TimeInstant now = presentTime();
		wSumAvail = wSumAvail
				+ ((double) avail * TimeOperations.diff(now, lastUsage).getTimeInEpsilon());
						
		lastUsage = now;
		avail += n; // n can be positive or negative

		if (n > 0) // it is a real producer
		{
			producers++;
			if (avail > maximum) {
				maximum = avail;
			}
		} else // it is a consumer
		{
			consumers++;
		}
	}
}