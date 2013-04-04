package desmoj.core.simulator;

import java.util.Iterator;

/**
 * ProcessQueue provides models with a ready-to-use element to enqueue
 * <code>SimProcess</code>es in. The sort order of the ProcessQueue is
 * determined first by the priorities of the enqueued SimProcesses and second by
 * the given sort order. The default sort order is fifo (first in, first out)
 * but others like lifo (last in, first out) can be chosen, too. See the
 * constants in class <code>QueueBased</code> and the derived classes from
 * <code>QueueList</code>. The capacity of the ProcessQueue, that is the
 * maximum number of SimProcesses enqueued, can be chosen, too. Note that in
 * contrast to the 'plain' queue, this ProcessQueue always expects and returns
 * objects that are derived from class <code>SimProcess</code>. When
 * modelling using the process-, activity-, or transaction-oriented paradigm
 * where SimProcesses are used to represent the model's entities, this
 * ProcessQueue can be used instead of the standard Queue to reduce the amount
 * of casts needed otherwise.
 * 
 * @see QueueBased
 * @see QueueList
 * @see QueueListFifo
 * @see QueueListLifo
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Tim Lechler
 * @author modified by Soenke Claassen
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
public class ProcessQueue<P extends SimProcess> extends QueueBased implements Iterable<P> {

	/**
	 * The queue implementation that actually stores the entities
	 */
	private QueueList ql;

	/**
	 * Counter for the SimProcesses which are refused to be enqueued, because
	 * the queue capacity is full.
	 */
	private long refused;

	/**
	 * Constructs a simple priority based waiting queue for SimProcesses, the
	 * kind of queue implementation (Fifo or Lifo) and the capacity of the queue
	 * can be chosen.
	 * <p>
     * The usage of the generic version <code>ProcessQueue&lt;Type&gt;</code> where 
     * <code>Type</code> is derived from <code>SimProcess</code> is recommended
     * for type safety. Using the raw type <code>ProcessQueue</code> yields a queue
     * in which any <code>SimProcess</code> can be enqueued, potentially requiring
     * type casting on accessing processes enqueued.  
	 * 
	 * @param owner
	 *            Model : The model this ProcessQueue is associated to
	 * @param name
	 *            java.lang.String : The processqueue's name
	 * @param sortOrder
	 *            int : determines the sort order of the underlying queue
	 *            implementation. Choose a constant from <code>QueueBased</code>
	 *            like <code>QueueBased.FIFO</code> or
	 *            <code>QueueBased.LIFO</code> or ...
	 * @param qCapacity
	 *            int : The capacity of the ProcessQueue, that is how many
	 *            processes can be enqueued. Zero (0) means unlimited capacity.
	 * @param showInReport
	 *            boolean : Flag if processqueue should produce a report
	 * @param showInTrace
	 *            boolean : Flag for processqueue to produce trace messages
	 */
	public ProcessQueue(Model owner, String name, int sortOrder, int qCapacity,
			boolean showInReport, boolean showInTrace) {

		super(owner, name, showInReport, showInTrace); // create the QBased
		// object
		reset();

		// check if a valid sortOrder is given
		if (sortOrder < 0) {
			sendWarning(
					"The given sortOrder parameter is negative! "
							+ "A queue with Fifo sort order will be created.",
					"ProcessQueue : "
							+ getName()
							+ " Constructor: ProcessQueue(Model owner, String name, "
							+ "int sortOrder, long qCapacity, boolean showInReport, "
							+ "boolean showInTrace)",
					"A valid positive integer number must be provided to "
							+ "determine the sort order of the queue.",
					"Make sure to provide a valid positive integer number "
							+ "by using the constants in the class QueueBased, like "
							+ "QueueBased.FIFO or QueueBased.LIFO.");
			// make a Fifo queue
			ql = new QueueListFifo(); // better than nothing
			ql.setQueueBased(this);
		} else {
			try {
				// determine the queueing strategy
				Class queueListStrategy = queueingStrategy[sortOrder];

				ql = (QueueList) queueListStrategy.newInstance();
			}

			catch (ArrayIndexOutOfBoundsException arrayExcept) {
				// the given sortOrder is not valid
				sendWarning(
						"The given sortOrder parameter is not valid! "
								+ "A queue with Fifo sort order will be created.",
						"ProcessQueue : "
								+ getName()
								+ " Constructor: ProcessQueue(Model owner, String name, "
								+ "int sortOrder, long qCapacity, boolean showInReport, "
								+ "boolean showInTrace)",
						"A valid positive integer number must be provided to "
								+ "determine the sort order of the queue.",
						"Make sure to provide a valid positive integer number "
								+ "by using the constants in the class QueueBased, like "
								+ "QueueBased.FIFO or QueueBased.LIFO.");
				// make a Fifo queue
				ql = new QueueListFifo(); // better than nothing
			}

			catch (IllegalAccessException illAccExcept) {
				// the class to be loaded can not be found
				sendWarning(
						"IllegalAccessException: The class implementing the "
								+ "sortOrder of the queue can not be found. A queue with "
								+ "Fifo sort order will be created instead.",
						"ProcessQueue : "
								+ getName()
								+ " Constructor: ProcessQueue(Model owner, String name, "
								+ "int sortOrder, long qCapacity, boolean showInReport, "
								+ "boolean showInTrace)",
						"Programm error when trying to create an instance of a "
								+ "class. Maybe the zero-argument constructor of that "
								+ "class can not be found",
						"Make sure to provide a valid positive integer number "
								+ "by using the constants in the class QueueBased, like "
								+ "QueueBased.FIFO or QueueBased.LIFO. Contact one of the "
								+ "developers of DESMO-J!");
				// make a Fifo queue
				ql = new QueueListFifo(); // better than nothing
			}

			catch (InstantiationException instExcept) {
				// no object of the given class can be instantiated
				sendWarning(
						"InstantiationException: No object of the given class "
								+ "can be instantiated! A queue with Fifo sort order will "
								+ "be created instead.",
						"ProcessQueue : "
								+ getName()
								+ " Constructor: ProcessQueue(Model owner, String name, "
								+ "int sortOrder, long qCapacity, boolean showInReport, "
								+ "boolean showInTrace)",
						"Programm error when trying to create an instance of a "
								+ "class. Maybe the the class is an interface or an "
								+ "abstract class that can not be instantiated",
						"Make sure to provide a valid positive integer number "
								+ "by using the constants in the class QueueBased, like "
								+ "QueueBased.FIFO or QueueBased.LIFO.Contact one of the "
								+ "developers of DESMO-J!");
				// make a Fifo queue
				ql = new QueueListFifo(); // better than nothing
			}

			// give the QueueList a reference to this QueueBased
			ql.setQueueBased(this);
		}

		// set the capacity of the queue
		queueLimit = qCapacity;

		// check if it the capacity does make sense
		if (qCapacity < 0) {
			sendWarning(
					"The given capacity of the queue is negative! "
							+ "A queue with unlimited capacity will be created instead.",
					"ProcessQueue : "
							+ getName()
							+ " Constructor: ProcessQueue(Model owner, String name, "
							+ "int sortOrder, long qCapacity, boolean showInReport, "
							+ "boolean showInTrace)",
					"A negative capacity for a queue does not make sense.",
					"Make sure to provide a valid positive capacity "
							+ "for the queue.");
			// set the capacity to the maximum value
			queueLimit = Integer.MAX_VALUE;
		}

		// check if qCapacity is zero (that means unlimited capacity)
		if (qCapacity == 0) {
			// set the capacity to the maximum value
			queueLimit = Integer.MAX_VALUE;
		}

	}

	/**
	 * Constructs a simple priority and Fifo based waiting queue for
	 * SimProcesses with unlimited capacity of the queue.
     * <p>
     * The usage of the generic version <code>ProcessQueue&lt;Type&gt;</code> where 
     * <code>Type</code> is derived from <code>SimProcess</code> is recommended
     * for type safety. Using the raw type <code>ProcessQueue</code> yields a queue
     * in which any <code>SimProcess</code> can be enqueued, potentially requiring
     * type casting on accessing processes enqueued.  
	 * 
	 * @param owner
	 *            Model : The model this processqueue is associated to
	 * @param name
	 *            java.lang.String : The processqueue's name
	 * @param showInReport
	 *            boolean : Flag if processqueue should produce a report
	 * @param showInTrace
	 *            boolean : Flag for processqueue to produce trace messages
	 */
	public ProcessQueue(Model owner, String name, boolean showInReport,
			boolean showInTrace) {
		super(owner, name, showInReport, showInTrace); // create the QBased
		// object
		reset();

		// make the queue with Fifo queueing discipline and unlimited capacity
		ql = new QueueListFifo();
		ql.setQueueBased(this);
	}

	/**
	 * Returns a processqueue-reporter to produce a report about this
	 * processqueue.
	 * 
	 * @return desmoj.report.Reporter : The reporter for this processqueue
	 */
	public desmoj.core.report.Reporter createReporter() {

		return new desmoj.core.report.ProcessQueueReporter(this);

	}

	/**
	 * Returns the first simprocess queued in this processqueue or
	 * <code>null</code> in case the queue is empty.
	 * 
	 * @return desmoj.SimProcess : The first simprocess in the processqueue or
	 *         <code>null</code> if the processqueue is empty
	 */
	public P first() {

		return (P) ql.first(); // straight design

	}

	/**
	 * Returns the first simprocess queued in this processqueue that applies to
	 * the given condition. The processqueue is searched from front to end and
	 * the first simprocess that returns <code>true</code> when the condition
	 * is applied to it is returned by this method. If no simprocess applies to
	 * the given condition or the processqueue is empty, <code>null</code>
	 * will be returned.
	 * 
	 * @return desmoj.SimProcess : The first simprocess queued in this
	 *         processqueue applying to the given condition or <code>null</code>
	 * @param c
	 *            Condition : The condition that the simprocess returned must
	 *            confirm
	 */
	public P first(Condition c) {

		if (c == null) {
			sendWarning(
					"Can not return first SimProcess complying to condition!",
					"ProcessQueue : " + getName()
							+ " Method: void first(Condition c)",
					"The Condition 'c' given as parameter is a null reference!",
					"Check to always have valid references when querying Queues.");
			return null; // no proper parameter
		}
		if (ql.isEmpty())
			return null; // nobody home to be checked
		for (SimProcess tmp = (SimProcess) ql.first(); tmp != null; tmp = (SimProcess) ql
				.succ(tmp)) {
			if (c.check(tmp))
				return (P)tmp;
		}

		// if no SimProcess complies to the condition just return null
		return null;

	}

	/**
	 * Returns the underlying queue implementation. So we have access to the
	 * QueueList* implementation and can add it to the PropertyChangeListeners
	 * 
	 * @return desmoj.QueueList : The underlying queue implementation of this
	 *         ProcessQueue.
	 */
	public QueueList getQueueList() {

		return ql; // that's all
	}

	/**
	 * Returns the implemented queueing discipline of the underlying queue as a
	 * String, so it can be displayed in the report.
	 * 
	 * @return String : The String indicating the queueing discipline.
	 */
	public String getQueueStrategy() {

		return ql.getAbbreviation(); // that's it

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
	 * Enters a new SimProcess into the ProcessQueue. If the capacity of the
	 * ProcessQueue is full, the entity will not be enqueued and
	 * <code>false</code> will be returned. The SimProcess will be stored in
	 * the ProcessQueue until method <code>remove(SimProcess e)</code> is
	 * called with this specific simprocess. Simprocesses are ordered according
	 * to their priority. Higher priorities are sorted in front of lower
	 * priorities. Simprocesses with same priority are orderer according to the
	 * strategy specified in the constructor. The first simprocess inside the
	 * processqueue will always be the one with the highest priority.
	 * 
	 * @return boolean : Is <code>true</code> if insertion was successful,
	 *         <code>false</code> otherwise (i.e. capacity limit is reached).
	 * @param e
	 *            desmoj.SimProcess : The SimProcess to be added to the
	 *            ProcessQueue
	 */
	public boolean insert(P e) {

		if (e == null) { // null returns with warning
			sendWarning("Can not insert SimProcess!", "ProcessQueue : "
					+ getName() + " Method: boolean insert" + "(SimProcess e)",
					"The SimProcess given as parameter is a null reference!",
					"Check to always have valid references when enqueueing "
							+ "Entities");
			return false; // no proper parameter
		}

		if (!isModelCompatible(e)) {
			sendWarning("Can not insert SimProcess!", "ProcessQueue : "
					+ getName() + " Method: boolean insert" + "(SimProcess e)",
					"The SimProcess given as parameter is not compatible to "
							+ "the model this processqueue belongs to!",
					"Check if your submodels are allowed to mingle with other "
							+ "model's components.");
			return false; // not of my model type!!!
		}

		if (queueLimit <= length()) {

			if (currentlySendDebugNotes()) { 
				sendDebugNote("refuses to insert " + e.getQuotedName()
					+ " because the "
					+ "capacity limit is reached. ProcessQueue:<br>"
					+ ql.toString());
			}

			if (currentlySendTraceNotes()) {
				sendTraceNote("is refused to be enqueued in "
					+ this.getQuotedName() + "because the capacity limit ("
					+ getQueueLimit() + ") of this "
					+ "ProcessQueue is reached");
			}

			refused++; // count the refused ones

			return false; // capacity limit is reached
		}

		ql.insert(e); // that's it

		if (currentlySendDebugNotes()) {
			sendDebugNote("inserts " + e.getQuotedName()
					+ " in the ProcessQueue:<br>" + ql.toString());
		}

		// produce trace output
		if (currentlySendTraceNotes()) {
			if (e == currentEntity()) {
				sendTraceNote("inserts itself into " + this.getQuotedName());
			} else {
				sendTraceNote("inserts " + e.getName() + " into "
						+ this.getQuotedName());
			}
		}

		return true;
	}

	/**
	 * Enters a new simprocess into the processqueue and places it after the
	 * given simprocess. If the capacity of the ProcessQueue is full, the entity
	 * will not be enqueued and <code>false</code> will be returned. Make sure
	 * that the SimProcess given as reference is already queued inside the
	 * processqueue, else the SimProcess will not be enqueued and
	 * <code>false</code> will be returned. The SimProcess will be stored in
	 * the ProcessQueue until method <code>remove(SimProcess e)</code> is
	 * called with this specific SimProcess.
	 * 
	 * @return boolean : Is <code>true</code> if insertion was successful,
	 *         <code>false</code> otherwise (i.e. capacity limit is reached).
	 * @param e
	 *            SimProcess : The simprocess to be added to the processqueue
	 * @param after
	 *            SimProcess : The simprocess after which simprocess 'e' is to
	 *            be inserted
	 */
	public boolean insertAfter(P e, P after) {

		if (e == null) {
			sendWarning(
					"Can not insert SimProcess!",
					"ProcessQueue : "
							+ getName()
							+ " Method: boolean insertAfter(SimProcess e, SimProcess after)",
					"The SimProcess -e- given as parameter is a null reference!",
					"Check to always have valid references when enqueueing Entities");
			return false; // no proper parameter
		}

		if (after == null) {
			sendWarning(
					"Can not insert SimProcess!",
					"ProcessQueue : "
							+ getName()
							+ " Method: boolean insertAfter(SimProcess e, SimProcess after)",
					"The SimProcess -after- given as parameter is a null reference!",
					"Check to always have valid references when enqueueing Entities");
			return false; // no proper parameter
		}

		if (!isModelCompatible(e)) {
			sendWarning(
					"Can not insert SimProcess!",
					"ProcessQueue : "
							+ getName()
							+ " Method: boolean insertAfter(SimProcess e, SimProcess after)",
					"The SimProcess given as parameter is not compatible to "
							+ "the model this processqueue belongs to!",
					"Check if your submodels are allowed to mingle with other "
							+ "model's components.");
			return false; // not of my model type!!!
		}

		if (queueLimit <= length()) {

			if (currentlySendDebugNotes()) { 
				sendDebugNote("refuses to insert " + e.getQuotedName()
					+ " because the "
					+ "capacity limit is reached. ProcessQueue:<br>"
					+ ql.toString());
			}

			if (currentlySendTraceNotes()) {
				sendTraceNote("is refused to be enqueued in "
					+ this.getQuotedName() + "because the capacity limit ("
					+ getQueueLimit() + ") of this "
					+ "ProcessQueue is reached");
			}

			refused++; // count the refused ones

			return false; // capacity limit is reached
		}

		boolean successful = ql.insertAfter(e, after); // elegantly done...

		if (currentlySendDebugNotes()) {
			sendDebugNote("inserts " + e.getQuotedName() + " after "
					+ after.getQuotedName() + " in the ProcessQueue:<br>"
					+ ql.toString());
		}

		// produce trace output
		if (currentlySendTraceNotes()) {
			if (e == currentEntity()) {
				sendTraceNote("inserts itself into " + this.getQuotedName()
						+ " after " + after.getName());
			} else {
				sendTraceNote("inserts " + e.getName() + " into "
						+ this.getQuotedName() + " after " + after.getName());
			}
		}

		return successful;

	}

	/**
	 * Enters a new SimProcess into the ProcessQueue and places it in front of
	 * the given SimProcess. If the capacity of the ProcessQueue is full, the
	 * entity will not be enqueued and <code>false</code> will be returned.
	 * Make sure that the SimProcess given as reference is already queued inside
	 * the ProcessQueue, else the SimProcess will not be enqueued and
	 * <code>false</code> will be returned. The SimProcess will be stored in
	 * the ProcessQueue until method <code>remove(SimProcess e)</code> is
	 * called with this specific SimProcess.
	 * 
	 * @return boolean : Is <code>true</code> if insertion was successful,
	 *         <code>false</code> otherwise (i.e. capacity limit is reached).
	 * @param e
	 *            SimProcess : The simprocess to be added to the processqQueue
	 * @param before
	 *            SimProcess : The SimProcess before which the simprocess 'e' is
	 *            to be inserted
	 */
	public boolean insertBefore(P e, P before) {

		if (e == null) {
			sendWarning(
					"Can not insert SimProcess!",
					"ProcessQueue : "
							+ getName()
							+ " Method: boolean insertBefore(SimProcess e, SimProcess before)",
					"The SimProcess -e- given as parameter is a null reference!",
					"Check to always have valid references when enqueueing Entities");
			return false; // no proper parameter
		}

		if (before == null) {
			sendWarning(
					"Can not insert SimProcess!",
					"ProcessQueue : "
							+ getName()
							+ " Method: boolean insertBefore(SimProcess e, SimProcess before)",
					"The SimProcess -before- given as parameter is a null reference!",
					"Check to always have valid references when enqueueing Entities");
			return false; // no proper parameter
		}

		if (!isModelCompatible(e)) {
			sendWarning(
					"Can not insert SimProcess!",
					"ProcessQueue : "
							+ getName()
							+ " Method: boolean insertBefore(SimProcess e, SimProcess before)",
					"The SimProcess given as parameter is not compatible to "
							+ "the model this processqueue belongs to!",
					"Check if your submodels are allowed to mingle with other "
							+ "model's components.");
			return false; // not of my model type!!!
		}

		if (queueLimit <= length()) {

			if (currentlySendDebugNotes()) {
				sendDebugNote("refuses to insert " + e.getQuotedName()
					+ " because the "
					+ "capacity limit is reached. ProcessQueue:<br>"
					+ ql.toString());
			}

			if (currentlySendTraceNotes()) {
				sendTraceNote("is refused to be enqueued in "
					+ this.getQuotedName() + "because the capacity limit ("
					+ getQueueLimit() + ") of this "
					+ "ProcessQueue is reached");
			}

			refused++; // count the refused ones

			return false; // capacity limit is reached
		}

		boolean successful = ql.insertBefore(e, before); // elegantly done...

		if (currentlySendDebugNotes()) {
			sendDebugNote("inserts " + e.getQuotedName() + " before "
					+ before.getQuotedName() + " in the ProcessQueue:<br>"
					+ ql.toString());
		}

		// produce trace output
		if (currentlySendTraceNotes()) {
			if (e == currentEntity()) {
				sendTraceNote("inserts itself into " + this.getQuotedName()
						+ " before " + before.getName());
			} else {
				sendTraceNote("inserts " + e.getName() + " into "
						+ this.getQuotedName() + " before " + before.getName());
			}
		}

		return successful;
	}

	/**
	 * Returns a boolean value indicating if the processqueue is empty or if any
	 * number of simprocess is currently enqueued in it.
	 * 
	 * @return boolean : Is <code>true</code> if the processqueue is empty,
	 *         <code>false</code> otherwise
	 */
	public boolean isEmpty() {

		return ql.isEmpty();

	}

	/**
	 * Returns the last simprocess queued in this processqueue or
	 * <code>null</code> in case the processqueue is empty.
	 * 
	 * @return desmoj.SimProcess : The last simprocess in the processqueue or
	 *         <code>null</code> if the processqueue is empty
	 */
	public P last() {

		return (P) ql.last(); // straight design again

	}

	/**
	 * Returns the last simprocess queued in this processqueue that applies to
	 * the given condition. The processqueue is searched from end to front and
	 * the first simprocess that returns <code>true</code> when the condition
	 * is applied to it is returned by this method. If no simprocess applies to
	 * the given condition or the processqueue is empty, <code>null</code>
	 * will be returned.
	 * 
	 * @return desmoj.SimProcess : The last simprocess queued in this
	 *         processqueue applying to the given condition or <code>null</code>
	 * @param c
	 *            Condition : The condition that the simprocess returned must
	 *            comply to
	 */
	public P last(Condition c) {

		if (c == null) {
			sendWarning(
					"Can not insert SimProcess!",
					"ProcessQueue : " + getName()
							+ " Method: SimProcess last(Condition c)",
					"The Condition -c- given as parameter is a null reference!",
					"Check to always have valid references when querying Queues.");
			return null; // no proper parameter
		}

		if (ql.isEmpty())
			return null; // nobody home to be checked

		for (P tmp = (P) ql.last(); tmp != null; tmp = (P) ql.pred(tmp)) {
			if (c.check(tmp))
				return (P)tmp;
		}

		// if no SimProcess complies to the condition just return null
		return null;

	}

	/**
	 * Returns the simprocess enqueued directly before the given simprocess in
	 * the processqueue. If the given simprocess is not contained in this
	 * processqueue or is at the first position thus having no possible
	 * predecessor, <code>null</code> is returned.
	 * 
	 * @return desmoj.SimProcess : The simprocess directly before the given
	 *         simprocess in the processqueue or <code>null</code>.
	 * @param e
	 *            desmoj.SimProcess : An simprocess in the processqueue
	 */
	public P pred(P e) {

		if (e == null) {
			sendWarning(
					"Can not find predecessor of SimProcess in Queue!",
					"ProcessQueue : " + getName()
							+ " Method: SimProcess pred(SimProcess e)",
					"The SimProcess 'e' given as parameter is a null reference!",
					"Check to always have valid references when querying for Entities");
			return null; // no proper parameter
		}

		return (P) ql.pred(e);

	}

	/**
	 * Returns the simprocess enqueued before the given simprocess in the
	 * processqueue that also complies to the condition given. If the given
	 * simprocess is not contained in this processqueue or is at the first
	 * position thus having no possible predecessor, <code>null</code> is
	 * returned. If no other simprocess before the given one complies to the
	 * condition, <code>null</code> is returned, too.
	 * 
	 * @return desmoj.SimProcess : The simprocess before the given simprocess in
	 *         the processqueue complying to the condition or <code>null</code>.
	 * @param e
	 *            SimProcess : A simprocess in the processqueue
	 * @param c
	 *            Condition : The condition that the preceeding simprocess has
	 *            to comply to
	 */
	public P pred(P e, Condition c) {

		if (e == null) {
			sendWarning(
					"Can not find predecessor of SimProcess in Queue!",
					"ProcessQueue : "
							+ getName()
							+ " Method: SimProcess pred(SimProcess e, Condition c)",
					"The SimProcess 'e' given as parameter is a null reference!",
					"Check to always have valid references when querying for Entities");
			return null; // no proper parameter
		}

		if (c == null) {
			sendWarning(
					"Can not return previous SimProcess complying to condition!",
					"ProcessQueue : "
							+ getName()
							+ " Method: SimProcess pred(SimProcess e, Condition c)",
					"The Condition 'c' given as parameter is a null reference!",
					"Check to always have valid references when querying Queues.");
			return null; // no proper parameter
		}

		for (P tmp = pred(e); tmp != null; tmp = pred(tmp)) {
			if (c.check(tmp))
				return tmp;
		}

		return null; // obviously not found here, empty or doesn't comply

	}

	/**
	 * Removes the given simprocess from the processqueue. If the given
	 * simprocess is not in the processqueue, a warning will be issued but
	 * nothing else will be changed.
	 * 
	 * @param e
	 *            SimProcess : The simprocess to be removed from the
	 *            processqueue
	 */
	public void remove(P e) {

		if (e == null) {
			sendWarning(
					"Can not remove SimProcess from Queue!",
					"ProcessQueue : " + getName()
							+ " Method:  void remove(SimProcess e)",
					"The SimProcess 'e' given as parameter is a null reference!",
					"Check to always have valid references when removing "
							+ "Entities");
			return; // no proper parameter
		}

		if (!ql.remove(e)) { // watch out, removes simprocess as a side
			// effect!!!
			sendWarning("Can not remove SimProcess from Queue!",
					"ProcessQueue : " + getName()
							+ " Method:  void remove(SimProcess e)",
					"The SimProcess 'e' given as parameter is not enqueued in "
							+ "this queue!",
					"Make sure the SimProcess is inside the queue you want it "
							+ "to be removed.");
			return; // not enqueued here
		}

		if (currentlySendDebugNotes()) {
			sendDebugNote("remove " + e.getQuotedName() + "<br>"
					+ ql.toString());
		}

		// produce trace output
		if (currentlySendTraceNotes()) {
			if (e == currentEntity()) {
				sendTraceNote("removes itself from " + this.getQuotedName());
			} else {
				sendTraceNote("removes " + e.getName() + " from "
						+ this.getQuotedName());
			}
		}

	}

	/**
	 * Resets all statistical counters to their default values. The mininum and
	 * maximum length of the queue are set to the current number of queued
	 * objects. The counter for the entities refused to be enqueued will be
	 * reset.
	 */
	public void reset() {

		super.reset(); // reset of QueueBased

		refused = 0;

	}

	/**
	 * Sets the queue capacity to a new value. Only if the new capacity is equal
	 * or larger than the current length of the queue!
	 * 
	 * @param newCapacity
	 *            int : The new capacity of this ProcessQueue.
	 */
	public void setQueueCapacity(int newCapacity) {

		// check if the new capacity is negative or larger than the current
		// length
		// of the queue
		if (newCapacity < length() || newCapacity < 0) {
			sendWarning(
					"The new capacity is negative or would be smaller than the "
							+ "number of entities already enqueued in this ProcessQueue. The capacity "
							+ "will remain unchanged!",
					getClass().getName() + ": " + getQuotedName()
							+ ", Method: "
							+ "void setQueueCapacity(int newCapacity)",
					"The ProcessQueue already contains more entities than the new capacity "
							+ "could hold. What should happen to the remaining entities?",
					"Make sure to change the capacity only to a non negative value larger "
							+ "than the current length of this ProcessQueue.");

			return; // ignore that rubbish and just return
		}

		// set the capacity of the queue to the new value
		queueLimit = newCapacity;

	}

	/**
	 * Sets the sort order of this ProcessQueue to a new value and makes this
	 * ProcessQueue use another <code>QueueList</code> with the specified
	 * queueing discipline. Please choose a constant from
	 * <code>QueueBased</code> like <code>QueueBased.FIFO</code> or
	 * <code>QueueBased.LIFO</code> to determine the sort order. The sort
	 * order of a ProcessQueue can only be changed, if the queue is empty.
	 * 
	 * @param sortOrder
	 *            int : determines the sort order of the underlying
	 *            <code>QueueList</code> implementation. Choose a constant
	 *            from <code>QueueBased</code> like
	 *            <code>QueueBased.FIFO</code> or <code>QueueBased.LIFO</code>.
	 */
	public void setQueueStrategy(int sortOrder) {

		// check if the queue is empty
		if (!isEmpty()) {
			sendWarning(
					"The ProcessQueue for which the queueing discipline should be "
							+ "changed is not empty. The queueing discipline will remain unchanged!",
					getClass().getName() + ": " + getQuotedName()
							+ ", Method: "
							+ "void setQueueStrategy(int sortOrder)",
					"The ProcessQueue already contains some processes ordered according a "
							+ "certain order.",
					"Make sure to change the sort order only for an empty ProcessQueue.");

			return; // ignore that rubbish and just return
		}

		// check if a valid sort order is given for the ProcessQueue
		if (sortOrder < 0 || sortOrder >= queueingStrategy.length) {
			sendWarning(
					"The given sortOrder parameter is negative or too big! "
							+ "The sort order of the ProcessQueue will remain unchanged!",
					getClass().getName() + ": " + getQuotedName()
							+ ", Method: "
							+ "void setQueueStrategy(int sortOrder)",
					"A valid positive integer number must be provided to "
							+ "determine the sort order of the ProcessQueue.",
					"Make sure to provide a valid positive integer number "
							+ "by using the constants in the class QueueBased, like "
							+ "QueueBased.FIFO or QueueBased.LIFO.");

			return; // ignore that rubbish and just return
		}

		// change the sort order (queueing discipline) of the ProcessQueue
		try {
			// determine the queueing strategy
			Class queueListStrategy = queueingStrategy[sortOrder];

			// make the QueueList...
			ql = (QueueList) queueListStrategy.newInstance();

			// give the QueueList a reference to this QueueBased
			ql.setQueueBased(this);
		}

		catch (ArrayIndexOutOfBoundsException arrayExcept) {
			// the given sortOrder is not valid
			sendWarning(
					"The given sortOrder parameter is not valid! "
							+ "The sort order of the ProcessQueue will remain unchanged!",
					getClass().getName() + ": " + getQuotedName()
							+ ", Method: "
							+ "void setQueueStrategy(int sortOrder)",
					"A valid positive integer number must be provided to "
							+ "determine the sort order of the queue.",
					"Make sure to provide a valid positive integer number "
							+ "by using the constants in the class QueueBased, like "
							+ "QueueBased.FIFO or QueueBased.LIFO.");
		}

		catch (IllegalAccessException illAccExcept) {
			// the class to be loaded can not be found
			sendWarning(
					"IllegalAccessException: The class implementing the "
							+ "sortOrder of the queue can not be found. The sort order of "
							+ "the ProcessQueue will remain unchanged!",
					getClass().getName() + ": " + getQuotedName()
							+ ", Method: "
							+ "void setQueueStrategy(int sortOrder)",
					"Programm error when trying to create an instance of a "
							+ "class. Maybe the zero-argument constructor of that "
							+ "class can not be found",
					"Make sure to provide a valid positive integer number "
							+ "by using the constants in the class QueueBased, like "
							+ "QueueBased.FIFO or QueueBased.LIFO. Contact one of the "
							+ "developers of DESMO-J!");
		}

		catch (InstantiationException instExcept) {
			// no object of the given class can be instantiated
			sendWarning(
					"InstantiationException: No object of the given class "
							+ "can be instantiated! The sort order of the ProcessQueue "
							+ "will remain unchanged!",
					getClass().getName() + ": " + getQuotedName()
							+ ", Method: "
							+ "void setQueueStrategy(int sortOrder)",
					"Programm error when trying to create an instance of a "
							+ "class. Maybe the the class is an interface or an "
							+ "abstract class that can not be instantiated",
					"Make sure to provide a valid positive integer number "
							+ "by using the constants in the class QueueBased, like "
							+ "QueueBased.FIFO or QueueBased.LIFO.Contact one of the "
							+ "developers of DESMO-J!");
		}

	}

	/**
	 * Sets the number of entities refused to be enqueued in the queue because
	 * the capacity limit is reached to a new value.
	 * 
	 * @param n
	 *            long : the new number of entities refused to be enqueued in
	 *            the queue because the capacity limit is reached.
	 */
	public void setRefused(long n) {
		// check if n is negative
		if (n < 0) {
			sendWarning(
					"Attempt to set the number of entities refused to enqueue in "
							+ "the ProcessQueue to a negative value. The attempted action "
							+ "is ignored!", "ProcessQueue : " + getName()
							+ " Method: void setRefused(long n)",
					"The number given as parameter n is negative! That makes no "
							+ "sense!",
					"Make sure to provide only positive numbers as parameter n.");
			return;
		}

		this.refused = n; // save the new value

	}

	/**
	 * Returns the SimProcess enqueued directly after the given simprocess in
	 * the processqueue. If the given SimProcess is not contained in this
	 * processqueue or is at the last position thus having no possible
	 * successor, <code>null</code> is returned.
	 * 
	 * @return desmoj.SimProcess : The SimProcess directly after the given
	 *         SimProcess in the ProcessQueue or <code>null</code>
	 * @param e
	 *            desmoj.SimProcess : A SimProcess in the processqueue
	 */
	public P succ(P e) {

		if (e == null) {
			sendWarning(
					"Can not find successor of SimProcess in Queue!",
					"ProcessQueue : " + getName()
							+ " Method: SimProcess succ(SimProcess e)",
					"The SimProcess 'e' given as parameter is a null reference!",
					"Check to always have valid references when querying for "
							+ "Entities");
			return null; // no proper parameter
		}

		return (P) ql.succ(e);

	}

	/**
	 * Returns the simprocess enqueued after the given simprocess in the
	 * processqueue that also complies to the condition given. If the given
	 * simprocess is not contained in this processqueue or is at the last
	 * position thus having no possible successor, <code>null</code> is
	 * returned. If no other simprocess after the given one complies to the
	 * condition, <code>null</code> is returned, too.
	 * 
	 * @return desmoj.SimProcess : The simprocess after the given simprocess in
	 *         the processqueue complying to the condition or <code>null</code>.
	 * @param e
	 *            SimProcess : A simprocess in the processqueue
	 * @param c
	 *            Condition : The condition that the succeeding simprocess has
	 *            to comply to
	 */
	public P succ(P e, Condition c) {

		if (e == null) {
			sendWarning(
					"Can not find predecessor of SimProcess in Queue!",
					"ProcessQueue : "
							+ getName()
							+ " Method: SimProcess succ(SimProcess e, Condition c)",
					"The SimProcess 'e' given as parameter is a null reference!",
					"Check to always have valid references when querying for Entities");
			return null; // no proper parameter
		}

		if (c == null) {
			sendWarning(
					"Can not return previous SimProcess complying to condition!",
					"ProcessQueue : "
							+ getName()
							+ " Method: SimProcess succ(SimProcess e, Condition c)",
					"The Condition 'c' given as parameter is a null reference!",
					"Check to always have valid references when querying Queues.");
			return null; // no proper parameter
		}

		for (P tmp = succ(e); tmp != null; tmp = succ(tmp)) {
			if (c.check(tmp))
				return tmp;
		}

		return null; // obviously not found here, empty or doesn't comply

	}
	
    /**
     * Returns an iterator over the processes enqueued.
     *
     * @return java.lang.Iterator&lt;P&gt; : An iterator over the processes enqueued.
     */
    public Iterator<P> iterator() {
        return new ProcessQueueIterator(this);
    }

    /**
     * Private queue iterator, e.g. required for processing all queue elements in a 
     * for-each-loop.
     */
    private class ProcessQueueIterator implements Iterator<P> {
        
        ProcessQueue<P> clientQ; 
        P next, lastReturned;
        
        public ProcessQueueIterator(ProcessQueue<P> clientQ) {
            this.clientQ = clientQ;
            next = first();
            lastReturned = null;
        }
        public boolean hasNext() {
            return next != null;
        }
        public P next() {
            lastReturned = next;
            next = succ(next);
            return lastReturned;
        }
        public void remove() {
            clientQ.remove(lastReturned);
        }
    }
}