package desmoj.core.simulator;

import java.util.Iterator;

/**
 * Queue provides models with a ready-to-use modelling element to enqueue
 * entities in. The sort order of the queue is determined first
 * by the priorities of the enqueued entities and second by the given sort
 * order. The default sort order is fifo (first in, first out) but others like
 * lifo (last in, first out) can be chosen, too. See the constants in class
 * <code>QueueBased</code> and the derived classes from <code>QueueList</code>.
 * The capacity of the Queue, that is the maximum number of entities enqueued,
 * can be chosen, too.
 * <p>
 * For queueing <code>SimProcess</code>es the usage of class
 * <code>ProcessQueue</code> is recommended.  
 * 
 * 
 * @see QueueBased
 * @see QueueList
 * @see QueueListFifo
 * @see QueueListLifo
 * @see ProcessQueue
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
public class Queue<E extends Entity> extends QueueBased implements Iterable<E>{

	/**
	 * The queue implementation (data structure) that actually stores the
	 * entities
	 */
	private QueueList ql;

	/**
	 * Counter for the entities which are refused to be enqueued, because the
	 * queue capacity is full.
	 */
	private long refused;
	
	/**
	 * Constructs a simple priority based waiting queue for entities, the kind
	 * of queue implementation (Fifo or Lifo) and the capacity of the queue can
	 * be chosen. Note that since SimProcesses are derived from Entities, they
	 * can be queued inside this queue, too. 
	 * <p>
	 * The usage of the generic version <code>Queue&lt;Type&gt;</code> where 
	 * <code>Type</code> is derived from <code>Entity</code> is recommended
	 * for type safety. Using the raw type <code>Queue</code> yields a queue
	 * in which any <code>Entity</code> can be enqueued, typically requiring
	 * type casting on accessing entities enqueued.  
	 * 
	 * @param owner
	 *            Model : The model this queue is associated to
	 * @param name
	 *            java.lang.String : The queue's name
	 * @param sortOrder
	 *            int : determines the sort order of the underlying queue
	 *            implementation. Choose a constant from <code>QueueBased</code>
	 *            like <code>QueueBased.FIFO</code> or
	 *            <code>QueueBased.LIFO</code> or ...
	 * @param qCapacity
	 *            int : The capacity of the Queue, that is how many entities can
	 *            be enqueued. Zero (0) means unlimited capacity.
	 * @param showInReport
	 *            boolean : Flag if queue should produce a report
	 * @param showInTrace
	 *            boolean : Flag for queue to produce trace messages
	 */
	public Queue(Model owner, String name, int sortOrder, int qCapacity,
			boolean showInReport, boolean showInTrace) {

		super(owner, name, showInReport, showInTrace); // create the QBased
		// object
		reset();

		// check if a valid sortOrder is given
		if (sortOrder < 0) {
			sendWarning(
					"The given sortOrder parameter is negative! "
							+ "A queue with Fifo sort order will be created.",
					"Queue : "
							+ getName()
							+ " Constructor: Queue(Model owner, String name, "
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
						"Queue : "
								+ getName()
								+ " Constructor: Queue(Model owner, String name, "
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
						"Queue : "
								+ getName()
								+ " Constructor: Queue(Model owner, String name, "
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
						"Queue : "
								+ getName()
								+ " Constructor: Queue(Model owner, String name, "
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
					"Queue : "
							+ getName()
							+ " Constructor: Queue(Model owner, String name, "
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
	 * Constructs a simple priority and Fifo based waiting queue for entities
	 * with unlimited capacity of the queue. Note that since SimProcesses are
	 * derived from Entities, they can be queued inside this queue, too.
     * <p>
     * The usage of the generic version <code>Queue&lt;Type&gt;</code> where 
     * <code>Type</code> is derived from <code>Entity</code> is recommended
     * for type safety. Using the raw type <code>Queue</code> yields a queue
     * in which any <code>Entity</code> can be enqueued, typically requiring
     * type casting on accessing entities enqueued.  
     * 
	 * @param owner
	 *            Model : The model this queue is associated to
	 * @param name
	 *            java.lang.String : The queue's name
	 * @param showInReport
	 *            boolean : Flag if queue should produce a report
	 * @param showInTrace
	 *            boolean : Flag for queue to produce trace messages
	 */
	public Queue(Model owner, String name, boolean showInReport,
			boolean showInTrace) {

		super(owner, name, showInReport, showInTrace); // create the QBased
		// object
		reset();

		// make the queue with Fifo queueing discipline and unlimited capacity
		ql = new QueueListFifo();
		ql.setQueueBased(this);

	}

	/**
	 * Returns a special queue reporter to produce a report about this queue.
	 * 
	 * @return desmoj.report.Reporter : The reporter for this queue
	 */
	public desmoj.core.report.Reporter createReporter() {

		return new desmoj.core.report.QueueReporter(this);

	}

	/**
	 * Returns the first entity queued in this queue or <code>null</code> in
	 * case the queue is empty.
	 * 
	 * @return desmoj.Entity : The first entity in the queue or
	 *         <code>null</code> if the queue is empty
	 */
	public E first() {

		return (E)ql.first(); // straight design

	}

	/**
	 * Returns the first entity queued in this queue that applies to the given
	 * condition. The queue is searched from front to end and the first entity
	 * that returns <code>true</code> when the condition is applied to it is
	 * returned by this method. If no entity apply to the given condition or the
	 * queue is empty, <code>null</code> will be returned.
	 * 
	 * @return desmoj.Entity : The first entity queued in this queue applying to
	 *         the given condition or <code>null</code>
	 * @param c
	 *            Condition : The condition that the entity returned must comply
	 *            to
	 */
	public E first(Condition c) {

		if (c == null) {
			sendWarning(
					"Can not return first Entity complying to condition!",
					"Queue : " + getName() + " Method: void first(Condition c)",
					"The Condition 'c' given as parameter is a null reference!",
					"Check to always have valid references when querying Queues.");
			return null; // no proper parameter
		}
		if (ql.isEmpty())
			return null; // nobody home to be checked
		for (Entity tmp = ql.first(); tmp != null; tmp = ql.succ(tmp)) {
			if (c.check(tmp))
				return (E)tmp;
		}
		// if no Entity complies to the condition just return null
		return null;

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
	 * Returns the number of entities refused to be enqueued in the queue.
	 * 
	 * @return long : The number of entities refused to be enqueued in the
	 *         queue.
	 */
	public long getRefused() {

		return refused; // that's it
	}

	/**
	 * Enters a new entity into the queue. If the capacity of the queue is full,
	 * the entity will not be enqueued and <code>false</code> will be
	 * returned. The entity will be stored in the queue until method
	 * <code>remove(Entity e)</code> is called with this specific entity.
	 * Entities inside the queue are ordered according to their priority. Higher
	 * priorities are sorted in front of lower priorities. Entities with same
	 * priority are orderer according to the specified strategy. The first
	 * entity inside the queue will always be the one with the highest priority.
	 * 
	 * @return boolean : Is <code>true</code> if insertion was successful,
	 *         <code>false</code> otherwise (i.e. capacity limit is reached).
	 * @param e
	 *            desmoj.Entity : The entity to be added to the queue.
	 */
	public boolean insert(E e) {

		if (e == null) { // null returns with warning
			sendWarning("Can not insert Entity into Queue! Command ignored.",
					"Queue : " + getName()
							+ " Method: boolean insert(Entity e)",
					"The Entity given as parameter is a null reference!",
					"Check to always have valid references when enqueueing Entities");
			return false; // no proper parameter
		}

		if (!isModelCompatible(e)) {
			sendWarning("Can not insert Entity into Queue! Command ignored.",
					"Queue : " + getName() + " Method: boolean insert"
							+ "(Entity e)",
					"The Entity given as parameter is not compatible to "
							+ "the model this queue belongs to!",
					"Check if your submodels are allowed to mingle with other "
							+ "model's components.");
			return false; // not of my model type!!!
		}

		if (queueLimit <= length()) {

			if (currentlySendDebugNotes()) {
				sendDebugNote("refuses to insert " + e.getQuotedName()
					+ " because the " + "capacity limit is reached. Queue:<br>"
					+ ql.toString());
			}

			if (currentlySendTraceNotes()) {
				sendTraceNote("is refused to be enqueued in "
					+ this.getQuotedName() + "because the capacity limit ("
					+ getQueueLimit() + ") of this queue is " + "reached");
			}

			refused++; // count the refused ones

			return false; // capacity limit is reached
		}

		ql.insert(e); // that's it

		if (currentlySendDebugNotes()) {
			sendDebugNote("inserts " + e.getQuotedName() + " in the queue:<br>"
					+ ql.toString());
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
	 * Enters a new entity into the queue and places it after the given entity.
	 * If the capacity of the queue is full, the entity will not be enqueued and
	 * <code>false</code> will be returned. Make sure that the entity given as
	 * reference is already queued inside the queue, else the entity will not be
	 * enqueued and <code>false</code> will be returned. The entity will be
	 * stored in the queue until method <code>remove(Entity e)</code> is
	 * called with this specific entity.
	 * 
	 * @return boolean : Is <code>true</code> if insertion was successful,
	 *         <code>false</code> otherwise (i.e. capacity limit is reached).
	 * @param e
	 *            Entity : The entity to be added to the queue
	 * @param after
	 *            Entity : The entity after which the entity e is to be inserted
	 */
	public boolean insertAfter(E e, E after) {

		if (e == null) {
			sendWarning(
					"Can not insert Entity into Queue! Command ignored.",
					"Queue : "
							+ getName()
							+ " Method: boolean insertAfter(Entity e, Entity after)",
					"The Entity -e- given as parameter is a null reference!",
					"Check to always have valid references when enqueueing Entities");
			return false; // no proper parameter
		}

		if (after == null) {
			sendWarning(
					"Can not insert Entity into Queue! Command ignored.",
					"Queue : "
							+ getName()
							+ " Method: boolean insertAfter(Entity e, Entity after)",
					"The Entity -after- given as parameter is a null reference!",
					"Check to always have valid references when enqueueing Entities");
			return false; // no proper parameter
		}

		if (!isModelCompatible(e)) {
			sendWarning("Can not insert Entity into Queue! Command ignored.",
					"Queue : " + getName() + " Method: boolean insertAfter"
							+ "(Entity e, Entity after)",
					"The Entity given as parameter is not compatible to "
							+ "the model this queue belongs to!",
					"Check if your submodels are allowed to mingle with other "
							+ "model's components.");
			return false; // not of my model type!!!
		}

		if (queueLimit <= length()) {

			if (currentlySendDebugNotes()) {
				sendDebugNote("refuses to insert " + e.getQuotedName()
					+ " because the " + "capacity limit is reached. Queue:<br>"
					+ ql.toString());
			}

			if (currentlySendTraceNotes()) {
				sendTraceNote("is refused to be enqueued in "
					+ this.getQuotedName() + "because the capacity limit ("
					+ getQueueLimit() + ") of this queue is " + "reached");
			}

			refused++; // count the refused ones

			return false; // capacity limit is reached
		}

		boolean successful = ql.insertAfter(e, after); // that's the point

		if (currentlySendDebugNotes()) {
			sendDebugNote("inserts " + e.getQuotedName() + " after "
					+ after.getQuotedName() + "<br>" + ql.toString());
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
	 * Enters a new entity into the queue and places it in front of the given
	 * entity. If the capacity of the queue is full, the entity will not be
	 * enqueued and <code>false</code> will be returned. Make sure that the
	 * entity given as reference is already queued inside the queue, else the
	 * entity will not be queued and <code>false</code> will be returned. The
	 * entity will be stored in the queue until method
	 * <code>remove(Entity e)</code> is called with this specific entity.
	 * 
	 * @return boolean : Is <code>true</code> if insertion was successful,
	 *         <code>false</code> otherwise (i.e. capacity limit is reached).
	 * @param e
	 *            Entity : The entity to be added to the queue
	 * @param before
	 *            Entity : The entity before which the entity e is to be
	 *            inserted
	 */
	public boolean insertBefore(E e, E before) {

		if (e == null) {
			sendWarning("Can not insert Entity into Queue! Command ignored.",
					"Queue : " + getName()
							+ " Method: boolean insertBefore(Entity e, "
							+ "Entity before)",
					"The Entity -e- given as parameter is a null reference!",
					"Check to always have valid references when enqueueing Entities");
			return false; // no proper parameter
		}
		if (before == null) {
			sendWarning(
					"Can not insert Entity into Queue! Command ignored.",
					"Queue : " + getName()
							+ " Method: boolean insertBefore(Entity e, "
							+ "Entity before)",
					"The Entity -before- given as parameter is a null reference!",
					"Check to always have valid references when enqueueing Entities");
			return false; // no proper parameter
		}

		if (!isModelCompatible(e)) {
			sendWarning("Can not insert Entity into Queue! Command ignored.",
					"Queue : " + getName() + " Method: boolean insertBefore"
							+ "(Entity e, Entity before)",
					"The Entity given as parameter is not compatible to "
							+ "the model this queue belongs to!",
					"Check if your submodels are allowed to mingle with other "
							+ "model's components.");
			return false; // not of my model type!!!
		}

		if (queueLimit <= length()) {

			if (currentlySendDebugNotes()) { 
				sendDebugNote("refuses to insert " + e.getQuotedName()
					+ " because the " + "capacity limit is reached. Queue:<br>"
					+ ql.toString());
			}
			
			if (currentlySendTraceNotes()) {
				sendTraceNote("is refused to be enqueued in "
					+ this.getQuotedName() + "because the capacity limit ("
					+ getQueueLimit() + ") of this queue is " + "reached");
			}

			refused++; // count the refused ones

			return false; // capacity limit is reached
		}

		boolean successful = ql.insertBefore(e, before); // that's the point

		if (currentlySendDebugNotes()) {
			sendDebugNote("inserts " + e.getQuotedName() + " before "
					+ before.getQuotedName() + "<br>" + ql.toString());
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
	 * Returns a boolean value indicating if the queue is empty or if any number
	 * of entities is currently enqueued in it.
	 * 
	 * @return boolean : Is <code>true</code> if the Queue is empty,
	 *         <code>false</code> otherwise
	 */
	public boolean isEmpty() {

		return ql.isEmpty();

	}

	/**
	 * Returns the last entity queued in this queue or <code>null</code> in
	 * case the queue is empty.
	 * 
	 * @return desmoj.Entity : The last entity in the queue or <code>null</code>
	 *         if the queue is empty
	 */
	public E last() {

		return (E) ql.last(); // straight design again

	}

	/**
	 * Returns the last entity queued in this queue that applies to the given
	 * condition. The queue is searched from end to front and the first entity
	 * that returns <code>true</code> when the condition is applied to it is
	 * returned. If no entity applies to the given condition or the queue is
	 * empty, <code>null</code> will be returned.
	 * 
	 * @return desmoj.Entity : The last entity queued in this queue applying to
	 *         the given condition or <code>null</code>
	 * @param c
	 *            Condition : The condition that the entity returned must comply
	 *            to
	 */
	public E last(Condition c) {

		if (c == null) {
			sendWarning(
					"Can not insert Entity!",
					"Queue : " + getName()
							+ " Method: Entity last(Condition c)",
					"The Condition -c- given as parameter is a null reference!",
					"Check to always have valid references when querying Queues.");
			return null; // no proper parameter
		}

		if (ql.isEmpty())
			return null; // nobody home to be checked
		for (Entity tmp = ql.last(); tmp != null; tmp = ql.pred(tmp)) {
			if (c.check(tmp))
				return (E) tmp;
		}

		// if no Entity complies to the condition just return null
		return null;

	}

	/**
	 * Returns the entity enqueued directly before the given entity in the
	 * queue. If the given entity is not contained in this queue or is at the
	 * first position thus having no possible predecessor, <code>null</code>
	 * is returned.
	 * 
	 * @return desmoj.Entity : The entity directly before the given entity in
	 *         the queue or <code>null</code>.
	 * @param e
	 *            desmoj.Entity : An entity in the queue
	 */
	public E pred(E e) {

		if (e == null) {
			sendWarning("Can not find predecessor of Entity in Queue!",
					"Queue : " + getName() + " Method: Entity pred(Entity e)",
					"The Entity -e- given as parameter is a null reference!",
					"Check to always have valid references when querying for Entities");
			return null; // no proper parameter
		}

		return (E) ql.pred(e);

	}

	/**
	 * Returns the entity enqueued before the given entity in the queue that
	 * also complies to the condition given. If the given entity is not
	 * contained in this queue or is at the first position thus having no
	 * possible predecessor, <code>null</code> is returned. If no other entity
	 * before the given one complies to the condition, <code>null</code> is
	 * returned, too.
	 * 
	 * @return desmoj.Entity : The entity before the given entity in the queue
	 *         complying to the condition or <code>null</code>.
	 * @param e
	 *            desmoj.Entity : An entity in thequeue
	 * @param c
	 *            Condition : The condition that the preceeding entity has to
	 *            comply to
	 */
	public E pred(E e, Condition c) {

		if (e == null) {
			sendWarning("Can not find predecessor of Entity in Queue!",
					"Queue : " + getName()
							+ " Method: Entity pred(Entity e, Condition c)",
					"The Entity 'e' given as parameter is a null reference!",
					"Check to always have valid references when querying "
							+ "for Entities");
			return null; // no proper parameter
		}

		if (c == null) {
			sendWarning(
					"Can not return previous Entity complying to condition!",
					"Queue : " + getName()
							+ " Method: Entity pred(Entity e, Condition c)",
					"The Condition 'c' given as parameter is a null reference!",
					"Check to always have valid references when querying Queues.");
			return null; // no proper parameter
		}

		for (E tmp = pred(e); tmp != null; tmp = pred(tmp)) {
			if (c.check(tmp))
				return tmp;
		}

		return null; // obviously not found here, empty or doesn't comply
	}

	/**
	 * Removes the given Entity from the Queue. If the given Entity is not in
	 * the Queue, a warning will be issued but nothing else will be changed.
	 * 
	 * @param e
	 *            Entity : The Entity to be removed
	 */
	public void remove(E e) {

		if (e == null) {
			sendWarning("Can not remove Entity from Queue!", "Queue : "
					+ getName() + " Method:  void remove(Entity e)",
					"The Entity 'e' given as parameter is a null reference!",
					"Check to always have valid references when removing "
							+ "Entities");
			return; // no proper parameter
		}
		if (!ql.remove(e)) { // watch out, already removed as a side
			// effect!!!
			sendWarning("Can not remove Entity from Queue!", "Queue : "
					+ getName() + " Method:  void remove(Entity e)",
					"The Entity 'e' given as parameter is not enqueued in this "
							+ "queue!",
					"Make sure the Entity is inside the queue you want it to "
							+ "be removed.");
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
	 * Returns the entity enqueued directly after the given entity in the queue.
	 * If the given entity is not contained in this queue or is at the last
	 * position thus having no possible successor, <code>null</code> is
	 * returned.
	 * 
	 * @return desmoj.Entity : The entity directly after the given entity in the
	 *         queue or <code>null</code>.
	 * @param e
	 *            desmoj.Entity : An entity in the queue
	 */
	public E succ(E e) {

		if (e == null) {
			sendWarning("Can not find successor of Entity in Queue!",
					"Queue : " + getName() + " Method: Entity succ(Entity e)",
					"The Entity 'e' given as parameter is a null reference!",
					"Check to always have valid references when querying for Entities");
			return null; // no proper parameter
		}

		return (E)ql.succ(e);

	}

	/**
	 * Returns the entity enqueued after the given entity in the queue that also
	 * complies to the condition given. If the given entity is not contained in
	 * this queue or is at the last position thus having no possible successor,
	 * <code>null</code> is returned. If no other entity after the given one
	 * complies to the condition, <code>null</code> is returned, too.
	 * 
	 * @return desmoj.Entity : The entity after the given entity in the queue
	 *         complying to the condition or <code>null</code>.
	 * @param e
	 *            Entity : An entity in the queue
	 * @param c
	 *            Condition : The condition that the succeeding entity has to
	 *            comply to
	 */
	public E succ(E e, Condition c) {

		if (e == null) {
			sendWarning("Can not find predecessor of Entity in Queue!",
					"Queue : " + getName()
							+ " Method: Entity succ(Entity e, Condition c)",
					"The Entity 'e' given as parameter is a null reference!",
					"Check to always have valid references when querying for Entities");
			return null; // no proper parameter
		}

		if (c == null) {
			sendWarning(
					"Can not return previous Entity complying to condition!",
					"Queue : " + getName()
							+ " Method: Entity succ(Entity e, Condition c)",
					"The Condition 'c' given as parameter is a null reference!",
					"Check to always have valid references when querying Queues.");
			return null; // no proper parameter
		}

		for (E tmp = succ(e); tmp != null; tmp = succ(tmp)) {
			if (c.check(tmp))
				return tmp;
		}

		return null; // obviously not found here, empty or doesn't comply

	}
	
    /**
     * Returns an iterator over the entities enqueued.
     *
     * @return java.lang.Iterator&lt;E&gt; : An iterator over the entities enqueued.
     */
	public Iterator<E> iterator() {
        return new QueueIterator(this);
    }

    /**
	 * Private queue iterator, e.g. required for processing all queue elements in a 
	 * for-each-loop.
	 */
    private class QueueIterator implements Iterator<E> {
        
        Queue<E> clientQ; 
        E next, lastReturned;
        
        public QueueIterator(Queue<E> clientQ) {
            this.clientQ = clientQ;
            next = first();
            lastReturned = null;
        }
        public boolean hasNext() {
            return next != null;
        }
        public E next() {
            lastReturned = next;
            next = succ(next);
            return lastReturned;
        }
        public void remove() {
            clientQ.remove(lastReturned);
        }
    }
}