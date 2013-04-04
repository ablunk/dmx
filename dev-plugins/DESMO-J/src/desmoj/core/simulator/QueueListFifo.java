package desmoj.core.simulator;

/**
 * Contains the implementation of a double linked list to represent queueing
 * functionality. The entities are queued first according to their priority and
 * second in first in first out order. The statistc data of the queue will be
 * stored in a <code>QueueBased</code> object. The <code>QueueListFifo</code>
 * has a reference to its <code>QueueBased</code> object. It uses the
 * <code>QueueLink</code> class to build a list out of links with references
 * to each element's predecessor, successor, the QueueBased object this
 * QueueListFifo is associated to and of course, the Entity that is supposed to
 * be enqueued here. This class needs a reference to a subclass of QueueBased to
 * update the queue statistics. It is used in many kinds of queue
 * implementations i.e. in classes <code>Queue</code> and
 * <code>ProcessQueue</code>.
 *
 * @see QueueList
 * @see QueueLink
 * @see QueueBased
 * @see Queue
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
public class QueueListFifo extends QueueList implements
		java.beans.PropertyChangeListener {

	/**
	 * The first link element of the list. It is set to <code>null</code> in
	 * the constructor to indicate that the QueueListFifo is empty.
	 */
	private QueueLink head;

	/**
	 * The last link element of the list It is set to <code>null</code> in the
	 * constructor to indicate that the QueueListFifo is empty.
	 */
	private QueueLink tail;

	/**
	 * An abbreviation to identify the sort of queueing discipline (like FIFO or
	 * LIFO or ...)
	 */
	private java.lang.String abbreviation;

	/**
	 * Constructs an empty <code>QueueListFifo</code> with no reference to its
	 * client QueueBased. This no-arg constructor is necessary to instantiate an
	 * object of this class by calling the
	 * <code>java.lang.Class.newInstance()</code> method. The reference to the
	 * QueueBased object making use of this queue-functionality must be provided
	 * later by calling the setQueueBased() method. The initial length is always
	 * zero.
	 */
	public QueueListFifo() {

		// set the abbreviation for this kind of queueing discipline
		this.abbreviation = "FIFO";

		// as the QueueListFifo is empty by now set the first and last element
		// of this
		// QueueListFifo to null
		head = null;
		tail = null;

		// we don't know the client queue yet.
		// Must be provided later by calling the setQueueBased() method
		clientQ = null;

	}

	/**
	 * Checks whether the process using the QueueList is a valid SimProcess.
	 * 
	 * @return boolean : Returns whether the SimProcess is valid or not.
	 * @param proc
	 *            desmoj.SimProcess : Is this SimProcess a valid one?
	 */
	protected boolean checkProcess(SimProcess proc) {

		if (proc == null) // if proc is a null pointer instead of a process
		{
			sendWarning("A non existing process was stored in a queue. "
					+ "The attempted action is ignored!",
					"QueueListFifo, Method: first(); called by Class: Stock, Method: "
							+ "store(long n) or retrieve(long n)",
					"The process is only a null pointer.",
					"Make sure that only real SimProcesses are stored in a queue.");
			return false;
		}

		if (!getQueueBased().isModelCompatible(proc)) // if proc is not
		// modelcompatible
		{
			sendWarning(
					"The process trying to use a QueueList object does not "
							+ "belong to this model. The attempted action is ignored!",
					"QueueListFifo, Method: first(); called by Class: Stock, Method: "
							+ "store(long n) or retrieve(long n)",
					"The process is not modelcompatible.",
					"Make sure that processes are using only queues within their model.");
			return false;
		}

		return true;
	}

	/**
	 * Returns true if the given entity is contained in the list, false
	 * otherwise.
	 * 
	 * @return boolean : True if the given entity is contained in the list,
	 *         false otherwise
	 * @param e
	 *            Entity : The entity assumed to be in the list
	 */
	boolean contains(Entity e) {

		if (e == null) { // check for nullreference
			sendWarning(
					"Can not check if the given entity is contained in queuelistfifo. "
							+ "Command ignored!",
					"Class: QueueListFifo Method: boolean contains(Entity e).",
					"The entity reference given as parameter is a null reference.",
					"Be sure to only use valid references.");
			return false;
		}

		// just check if e has a QueueLink referencing this Queue
		return (e.getQueueLink(this) != null);

	}

	/**
	 * Returns the first entity stored in the list. If the queue is empty,
	 * <code>null</code> is returned.
	 * 
	 * @return Entity : The first entity in the list or <code>null</code> if
	 *         list is empty
	 */
	public Entity first() {

		if (head == null)
			return null;
		else
			return head.getEntity();

	}

	/**
	 * Returns an abbreviation as a String to identify the sort of queueing
	 * discipline (like FIFO or LIFO or ...). Is used to display the queueing
	 * discipline in the report of the QueueBased objects.
	 * 
	 * @return java.lang.String : An abbreviation to identify the sort of
	 *         queueing discipline (like FIFO or LIFO or ...)
	 */
	public String getAbbreviation() {

		return abbreviation;
	}

	/**
	 * Adds a new entity to the QueueListFifo. Entities are inserted according
	 * to their priority in descending order. The highest priority Entity will
	 * always be first in the queue. Entities with same priority are inserted in
	 * FiFo order.
	 * 
	 * @param e
	 *            Entity : The entity to add to the queuelistfifo
	 */
	public void insert(Entity e) {

		if (e == null) { // check for null reference
			sendWarning(
					"Can not insert Entity. Command ignored.",
					"Class: QueueListFifo Method: boolean insert(Entity e).",
					"The Entity reference given as parameter is a null reference.",
					"Be sure to only use valid references.");
			return;
		}

		if (contains(e)) { // Entity must not be contained twice in queue
			sendWarning("Can not insert Entity. Command ignored.",
					"Class: QueueListFifo Method: boolean insert(Entity e).",
					"The Entity given as parameter is already enqueued.",
					"Make sure the Entity is not enqueued here by calling "
							+ "method 'contains(Entity e)'.");
			return;
		}

		QueueLink newLink = new QueueLink(e, clientQ.presentTime(), this);

		if (isEmpty()) { // if empty we can just insert it straight away

			head = newLink;
			tail = newLink;
			clientQ.addItem(); // update statistics
			return;
		}

		// loop through the queue from back to front until pos. or head found
		for (QueueLink i = tail; i != null; i = i.getPrev()) {

			if (Entity.isSmallerOrEqual(e, i.getEntity())) { // if position
				// found

				// now insert newLink after position "i"
				newLink.setPrev(i);
				newLink.setNext(i.getNext());
				i.setNext(newLink);

				if (newLink.getNext() != null) {
					newLink.getNext().setPrev(newLink);
				}

				// correct tail reference if necessary
				if (tail == i) {
					tail = newLink;
				}

				// newLink.insertAfter(i); // insert new link
				clientQ.addItem(); // update statistics
				return; // exit

			} // end if position found

		} // end for loop

		// now new entity e must be largest in whole queuelistfifo, so insert as
		// first
		newLink.setNext(head);
		head.setPrev(newLink);
		head = newLink;
		// newLink.insertBefore(head);
		clientQ.addItem(); // update statistics

	}

	/**
	 * Inserts the given "e" after the position of "which" in the queuelistfifo.
	 * Returns true if "e" is inserted correctly after "which". If the list is
	 * empty or the referenced "which" is not contained, the "e" will not be
	 * inserted and false is returned.
	 * 
	 * @return boolean : Is <code>true</code> if inserted correctly,
	 *         <code>false</code> otherwise
	 * @param e
	 *            Entity : The entity to be inserted
	 * @param which
	 *            Entity : The referenced entity that the given "e" has to be
	 *            inserted after
	 */
	boolean insertAfter(Entity e, Entity which) {

		if (e == null) { // check for null reference
			sendWarning("Can not insert Entity. Command ignored.",
					"Class 'QueueListFifo' Method: boolean insertAfter(Entity e, "
							+ "Entity which).",
					"The Entity reference 'e' given as parameter is a null "
							+ "reference.",
					"Be sure to only use valid references.");
			return false;
		}

		if (which == null) { // check for null reference
			sendWarning("Can not insert Entity. Command ignored.",
					"Class 'QueueListFifo' Method: boolean insertAfter(Entity e, "
							+ "Entity which).",
					"The Entity reference 'which' given as parameter is a null "
							+ "reference.",
					"Be sure to only use valid references.");
			return false;
		}

		if (contains(e)) { // Entity must not be contained twice in the queue
			sendWarning("Can not insert Entity. Command ignored.",
					"Class 'QueueListFifo' Method: boolean insertAfter(Entity e, "
							+ "Entity which).",
					"The Entity 'e' given as parameter is already enqueued.",
					"Make sure the Entity is not enqueued here by calling "
							+ "method 'contains(Entity e)'.");
			return false;
		}

		// buffer link of positioning reference for later use
		QueueLink whichLink = which.getQueueLink(this);

		if (whichLink == null) { // Entity must already be enqueued here
			sendWarning("Can not insert Entity. Command ignored.",
					"Class 'QueueListFifo' Method: boolean insertAfter(Entity e, "
							+ "Entity which).",
					"The Entity 'which' given as positioning reference is not "
							+ "enqueued in this QueueListFifo.",
					"Make sure the Entity is enqueued by calling "
							+ "method 'QueueListFifo.contains(Entity e)'.");
			return false;
		}

		// everything checked, now create the new queuelink
		QueueLink newLink = new QueueLink(e, e.presentTime(), this);

		// now insert newLink after whichLink
		newLink.setPrev(whichLink);
		newLink.setNext(whichLink.getNext());
		whichLink.setNext(newLink);

		if (newLink.getNext() != null) {
			newLink.getNext().setPrev(newLink);
		}

		// correct tail reference if necessary
		if (tail == whichLink) {
			tail = newLink;
		}

		clientQ.addItem(); // update statistics
		return true; // exit

	}

	/**
	 * Inserts the given "e" before the position of "which" in the
	 * queuelistfifo. Returns true if "e" is inserted correctly after "which".
	 * If the list is empty or the referenced "which" is not contained, the "e"
	 * will not be inserted and false is returned.
	 * 
	 * @return boolean : Is <code>true</code> if inserted correctly,
	 *         <code>false</code> otherwise
	 * @param e
	 *            Entity : The entity to be inserted
	 * @param which
	 *            Entity : The referenced entity that the given "e" has to be
	 *            inserted before
	 */
	boolean insertBefore(Entity e, Entity which) {

		if (e == null) { // check for null reference
			sendWarning("Can not insert Entity. Command ignored.",
					"Class 'QueueListFifo' Method: insertBefore(Entity e, "
							+ "Entity which).",
					"The Entity reference 'e' given as parameter is a null "
							+ "reference.",
					"Be sure to only use valid references.");
			return false;
		}

		if (which == null) { // check for null reference
			sendWarning("Can not insert Entity. Command ignored.",
					"Class 'QueueListFifo' Method: insertBefore(Entity e, "
							+ "Entity which).",
					"The Entity reference 'which' given as parameter is a null "
							+ "reference.",
					"Be sure to only use valid references.");
			return false;
		}

		if (contains(e)) { // Entity must not be contained twice in queue
			sendWarning("Can not insert Entity. Command ignored.",
					"Class 'QueueListFifo' Method: insertBefore(Entity e, "
							+ "Entity which).",
					"The Entity 'e' given as parameter is already enqueued.",
					"Make sure the Entity is not enqueued here by calling "
							+ "method 'contains(Entity e)'.");
			return false;
		}

		// buffer link of positinoning reference for later use
		QueueLink whichLink = which.getQueueLink(this);

		if (whichLink == null) { // Entity must already be enqueued here
			sendWarning("Can not insert Entity. Command ignored.",
					"Class 'QueueListFifo' Method: insertBefore(Entity e, "
							+ "Entity which).",
					"The Entity 'which' given as positioning reference is not "
							+ "enqueued in this QueueListFifo.",
					"Make sure the Entity is enqueued by calling "
							+ "method 'QueueListFifo.contains(Entity e)'.");
			return false;
		}

		// everything checked, now proceed to insert newLink before whichLink
		QueueLink newLink = new QueueLink(e, e.presentTime(), this);

		newLink.setNext(whichLink);
		newLink.setPrev(whichLink.getPrev());
		whichLink.setPrev(newLink);

		if (newLink.getPrev() != null) {
			newLink.getPrev().setNext(newLink);
		}

		// correct head reference if necessary
		if (head == whichLink) {
			head = newLink;
		}

		clientQ.addItem(); // update statistics
		return true; // signal correct insertion

	}

	/**
	 * Returns <code>true</code>, if no elements are inside the
	 * <code>QueueListFifo</code>,<code>false</code> otherwise
	 * 
	 * @return boolean : true, if no elements are inside the
	 *         <code>QueueListFifo</code>, false otherwise
	 */
	public boolean isEmpty() {

		return (head == null); // length is also zero

	}

	/**
	 * Returns the last entity stored in the queuelistfifo. If the queuelistfifo
	 * is empty, <code>null</code> is returned.
	 * 
	 * @return Entity : The last entity in the list or <code>null</code> if
	 *         queuelistfifo is empty
	 */
	Entity last() {

		if (tail == null)
			return null;
		else
			return tail.getEntity(); // just get and return

	}

	/**
	 * Returns the predecessor to the given entity in the queuelistfifo. If
	 * there is no predecessor or no entity, <code>null</code> is returned.
	 * 
	 * @return Entity : The entity before the given parameter in the
	 *         queuelistfifo or <code>null</code> if e has no predecessor in
	 *         the queuelistfifo or entity parameter 'e' itself is not contained
	 * @param e
	 *            Entity : The entity contained in the queuelistfifo whose
	 *            predecessor will be returned.
	 */
	Entity pred(Entity e) {

		if (e == null) { // check for null reference
			sendWarning("Can not return predecessor Entity. Command ignored.",
					"Class: QueueListFifo Method: Entity pred (Entity e).",
					"The Entity reference 'e' given as parameter is a null "
							+ "reference.",
					"Check if Entity 'e' is enqueued using method "
							+ "'QueueListFifo.contains(e)'.");
			return null;
		}

		// get e's QueueLink
		QueueLink eQLink = e.getQueueLink(this);
		if (eQLink == null)
			return null; // not enqueued here

		if (eQLink == head)
			return null; // first element can't have predecessor

		return eQLink.getPrev().getEntity(); // that's it, the Entity is
		// returned

	}

	/**
	 * This method will be called every time the Stock (the number of available
	 * units) has changed.
	 * 
	 * @param evt
	 *            java.beans.PropertyChangeEvent : The event specifying the
	 *            property that has changed ans its old and new value.
	 */
	public void propertyChange(java.beans.PropertyChangeEvent evt) {

		// check if the property expected has changed
		if (evt.getPropertyName() == "avail") {
			// check if anybody is in the queue
			if (!isEmpty()) {
				// get the first process in the queue
				SimProcess next = (SimProcess) first();

				// check if the process is not a null pointer or is not
				// modelcompatible
				if (!checkProcess(next)) {
					return;
				} // just return

				// is the process scheduled already?
				if (next.isScheduled()) {
					next.skipTraceNote(); // do not tell in the trace, that we
					// ...
					next.cancel(); // get the process from the EventList
				}

				// remember if the process is blocked
				boolean wasBlocked = next.isBlocked();

				// invalidate the block for a moment
				if (wasBlocked) {
					next.setBlocked(false);
				}

				next.skipTraceNote(); // do not tell in the trace, that we ...
				next.activateAfter(getQueueBased().current()); // schedule this
				// process
				// right after the current

				// set the block back
				if (wasBlocked) {
					next.setBlocked(true);
				}
			} // end if isEmpty()
		} // end if propertyName == available

	}

	/**
	 * Removes the given entity from the queuelistfifo. Checks if the given
	 * entity to be removed does apply to all restrictions on this operation.
	 * These are :
	 * <ul>
	 * <li>The given reference to an entity must not be <code>null</code>
	 * </li>
	 * <li>This queuelistfifo must not be empty, otherwise there's nothing to
	 * remove</li>
	 * <li>The entity's queuelink to the queues it is in must not be
	 * <code>null</code></li>
	 * <li>The entity's list of queues it is in must contain a queuelink
	 * referencing this queuelistfifo</li>
	 * </ul>
	 * If all these restrictions apply, <code>true</code> is returned and the
	 * entity is removed, otherwise <code>false</code> is the return value
	 * because the given entity could not be removed since one of the
	 * restrictions above was not met.
	 * 
	 * @return boolean : Is <code>true</code> if the given entity is contained
	 *         in the queuelistfifo, <code>false</code> otherwise
	 * @param e
	 *            Entity : The entity to be removed from the queuelistfifo
	 */
	public boolean remove(Entity e) {

		if (e == null) { // check for null reference
			sendWarning(
					"Can not remove Entity. Command ignored.",
					"Class: QueueListFifo Method: boolean remove(Entity e).",
					"The Entity reference given as parameter is a null reference.",
					"Be sure to only use valid references.");
			return false;
		}

		// check if anything can be removed at all
		if (isEmpty()) {
			sendWarning("Can not remove Entity. Command ignored.",
					"Class: QueueListFifo Method: boolean remove(Entity e).",
					"The Queue is empty, no Entities are contained.",
					"Check if an Entity is enqueued by calling method "
							+ "contains(Entity e).");
			return false;
		}

		// cache the Entity's QueueLink for further checking
		QueueLink tmp = e.getQueueLink(this);

		// check if Entity is enqueued in this QueueList
		if (tmp == null) {
			sendWarning(
					"Can not remove Entity. Command ignored.",
					"Class: QueueListFifo Method: boolean remove(Entity e).",
					"The Entity given as parameter is not contained in this Queue",
					"To make sure the Entity is enqueued here call "
							+ "method 'contains(Entity e)'.");
			return false;
		}

		if (tmp.getNext() != null) {
			tmp.getNext().setPrev(tmp.getPrev()); // redirect the Prev pointer
			// of
		} // the next QueueLink

		if (tmp.getPrev() != null) {
			tmp.getPrev().setNext(tmp.getNext()); // redirect the Next pointer
			// of
		} // the previous QueueLink

		if (head == tmp)
			head = tmp.getNext(); // set head ref to new first link
		if (tail == tmp)
			tail = tmp.getPrev(); // set tail ref to new last link

		clientQ.deleteItem(tmp.timeIn()); // tell QueueBased to update
		// statistics
		tmp.remove();
		return true; // job done

	}

	/**
	 * Removes the first entity from this QueueListFifo and returns
	 * <code>true</code> if it was removed successfully. If the queuelistfifo
	 * is empty, <code>false</code> is returned.
	 * 
	 * @return boolean : Is <code>true</code>, if the first element has been
	 *         removed successfully, <code>false</code> if the queuelistfifo
	 *         happened to be empty.
	 */
	boolean removeFirst() {

		if (isEmpty()) {
			sendWarning(
					"Can not remove first Entity in queue. Command ignored.",
					"Class: QueueListFifo Method: boolean removeFirst().",
					"The queue is empty, thus no entity can be removed.",
					"Check if any entity 'e' is enqueued using method "
							+ "'QueueListFifo.contains(e)'.");
			return false; // nothing from nothing leaves nothing
		}

		return remove(head.getEntity()); // delegate to remove()

	}

	/**
	 * Removes the last entity from the QueueListFifo and returns
	 * <code>true</code> if it was removed successfully. If the queuelistfifo
	 * is empty, <code>false</code> is returned.
	 * 
	 * @return boolean : Is <code>true</code>, if the last element has been
	 *         removed successfully, <code>false</code> if the queuelistfifo
	 *         happened to be empty
	 */
	boolean removeLast() {

		if (isEmpty()) {
			sendWarning(
					"Can not remove last Entity in queue. Command ignored.",
					"Class: QueueListFifo Method: boolean removeLast().",
					"The queue is empty, thus no entity can be removed.",
					"Check if any entity 'e' is enqueued using method "
							+ "'QueueListFifo.contains(e)'.");
			return false; // nothing from nothing leaves nothing
		}

		return remove(tail.getEntity()); // delegate to remove()

	}

	/**
	 * Sends a warning to the error output by forwarding it to the associated
	 * queuebased's <code>sendwarning</code> method. Warnings are sent only if
	 * the queuebased's flag for queue implementation warnings is set to
	 * <code>true</code>.
	 * 
	 * @param description
	 *            java.lang.String : describing the error
	 * @param location
	 *            java.lang.String : describing the location the error occurred
	 * @param reason
	 *            java.lang.String : describing the possible cause for this
	 *            error
	 * @param prevention
	 *            java.lang.String : telling what to do to prevent this error
	 * @see QueueBased
	 */
	void sendWarning(String description, String location, String reason,
			String prevention) {

		if (clientQ.qImpWarn()) {
			clientQ.sendWarning(description, location, reason, prevention);
		}

	}

	/**
	 * Returns the successor to the given entity in the queuelistfifo. If there
	 * is no successor or no entity in the queuelistfifo, <code>null</code> is
	 * returned.
	 * 
	 * @return Entity : The entity before the given parameter in the
	 *         queuelistfifo or <code>null</code> if the given entity
	 *         parameter 'e' has no successor in the queuelistfifo or e itself
	 *         is not contained in the queuelistfifo
	 * @param e
	 *            Entity : The entity contained in the queuelistfifo
	 */
	public Entity succ(Entity e) {

		if (e == null) { // check for null reference
			sendWarning("Can not return successing Entity. Command ignored.",
					"Class: QueueListFifo Method: Entity succ (Entity e).",
					"The Entity reference 'e' given as parameter is a null "
							+ "reference.",
					"Check if Entity 'e' is enqueued using method "
							+ "'QueueListFifo.contains(e)'.");
			return null;
		}

		// get the Entity's QueueLink
		QueueLink eQLink = e.getQueueLink(this);

		if (eQLink == null)
			return null; // not enqueued here???

		if (eQLink == tail)
			return null; // last element can't have successors

		return eQLink.getNext().getEntity();// that's it, return the Entity

	}

	/**
	 * Returns a string representation of the queuelistfifo. The string is built
	 * by concatenating all string representations of the contained entities,
	 * calling their <code>toString()</code> methods.
	 * 
	 * @return java.lang.String : The string representation of the queuelistfifo
	 */
	public String toString() {

		StringBuffer buffer = new StringBuffer(); // strings

		if (isEmpty()) {
			buffer.append("-");
		} else {

			int c = 0; // counter for positions

			for (QueueLink i = head; i != null; i = i.getNext()) { // loop thru
				// list
				c++; // increment counter
				buffer.append(c + ":"); // show counter
				buffer.append("[" + i.getEntity().toString() + "]<br>"); // embrace
				// in
				// brackets
			}

		}
		return buffer.toString();

	}
}