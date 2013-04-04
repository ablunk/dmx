package desmoj.core.simulator;

/**
 * QueueLinks make up the glue that keeps QueueList objects and entities stick
 * together. It keeps references to :
 * <ul>
 * <li>the QueueList object where this QueueLink is inserted</li>
 * <li>a reference to the preceeding link in the chain of the QueueList</li>
 * <li>a reference to the next link in the chain of the QueueList</li>
 * <li>a reference to another QueueList's queuelink that the given Entity is
 * also queued in</li>
 * <li>a reference to the actual entity handled by this queuelink</li>
 * <li>the point of simulation time the entity entered the QueueList object
 * </li>
 * </ul>
 * Having references to other QueueList's links enables an entity to be in
 * multiple queues at the same time.
 * 
 * @see QueueList
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
public class QueueLink {

	/*
	 * The following attribute was omitted because parallel priority handling
	 * between entity and its associated queuelinks would probably worry the
	 * modeler more than it would help. The idea was to have consistent priority
	 * queueing inside a queue which is always disrupted when insertBefore or
	 * insertAfter are used to place entities at certain positions relative to
	 * other entities inside the queue. This can cause entities with high
	 * priority to be placed behind entities with a much lower priority, thus
	 * confusing other entities being inserted with method insert, which might
	 * end up behind the higher priority entity but should be at thevery front,
	 * if compared to any other entity's priority. This problem has never been
	 * resolved in DESMO and has been passed through all other versions of
	 * DESMO-X ever since.
	 * 
	 * private int qPriority;
	 */

	/**
	 * Reference to the QueueList this queuelink is an element of.
	 */
	private QueueList motherQList;

	/**
	 * Link to the previous queuelink in the queuelist.
	 */
	private QueueLink prev;

	/**
	 * Link to the next queuelink in the queuelist.
	 */
	private QueueLink next;

	/**
	 * Link to the queuelink in another queuelist that this queuelink's entity
	 * is also enqueued in.
	 */
	private QueueLink nextQueue;

	/**
	 * Link to the entity handled by this queuelist.
	 */
	private Entity item;

	/**
	 * The point of simulation time that the entity entered the queuelist.
	 */
	private TimeInstant entryTime;

	/**
	 * Constructs a queuelink with the given parameters to insert it into a
	 * queuelist. This queuelink is automatically inserted into the given
	 * Entity's list of associated queues it is queued in.
	 * 
	 * @param e
	 *            Entity : The entity to be linked to this queuelink
	 * @param timeIn
	 *            TimeInstant : The point of simulation time that this link was
	 *            established
	 * @param q
	 *            QueueList : The queuelist this queuelink is an element of
	 */
	QueueLink(Entity e, TimeInstant timeIn, QueueList q) {

		prev = null; // refs to prev set at insertion before/after another
		// queuelink
		next = null; // refs to next set at insertion before/after another
		// queuelink
		item = e; // set the entity to be ref'd
		entryTime = timeIn; // store current time for statistics
		motherQList = q; // the reference to the QueueList where this
		// QueueLink is inserted
		nextQueue = null; // default for all new queuelink since they
		// are always added last in the list
		e.addQueueLink(this); // add this link to the Entity's list of queues

	}

	/**
	 * Returns the entity associated with this queuelink.
	 * 
	 * @return desmoj.Entity : The entity associated with this queuelink or
	 *         <code>null</code> if no entity has yet been associated
	 */
	Entity getEntity() {

		return item;

	}

	/**
	 * Returns the queuelink linked after this queuelink in the queuelist or
	 * <code>null</code> if there is no next queuelink
	 * 
	 * @return QueueLink : The next queuelink in a queuelist's order or
	 *         <code>null</code>
	 */
	QueueLink getNext() {

		return next;

	}

	/**
	 * Returns the reference to another queuelist's queuelink or <null>if no
	 * other queuelist's queuelink is associated with this.
	 * 
	 * @return QueueLink : The reference to another queuelist's queuelink or
	 *         <null>if no other queuelist's queuelink is associated with this
	 */
	QueueLink getNextQueue() {

		return nextQueue;

	}

	/**
	 * Returns the queuelink linked before this queuelink in the queuelist or
	 * <code>null</code> if there is no previous queuelink
	 * 
	 * @return QueueLink : The previous queuelink in a queuelist's order or
	 *         <code>null</code>
	 */
	QueueLink getPrev() {

		return prev;

	}

	/**
	 * Returns the reference to the queuelist this queuelink is associated to or
	 * <null>if this queuelink is not already part of such a queuelist.
	 * 
	 * @return QueueList : The reference to the queuelist this queuelink is
	 *         associated to or <null>
	 */
	QueueList getQueueList() {

		return motherQList;

	}

	/**
	 * Inserts this queuelink directly after the given queuelink in that
	 * queuelink's queuelist. Can only be linked if this queuelink is not
	 * already linked somewhere else.
	 * 
	 * @param which
	 *            QueueLink : The queuelink to be linked after
	 */
	void insertAfter(QueueLink which) {

		if ((this.prev != null) || (this.next != null)) {
			sendWarning(
					"Can not insert QueueLink! Command ignored.",
					"QueueLink of Entity : " + item.getName()
							+ " in QueueBased : "
							+ motherQList.getQueueBased().getName()
							+ " Method : insertAfter" + "(QueueLink which)",
					"The QueueLink to be inserted already contains valid "
							+ "references to other QueueLinks, thus must not be inserted "
							+ "again using this QueueLink.",
					"Internal error. Please report to the current DESMOJ-Developer.");
			return; // warning already linked somewhere else
		}

		this.prev = which;
		this.next = which.next;
		which.next = this;
		// only if successor present
		if (this.next != null)
			this.next.prev = this;

	}

	/**
	 * Inserts this queuelink directly before the given queuelink in that
	 * queuelink's queuelist. Can only be linked if this queuelink is not
	 * already linked somewhere else.
	 * 
	 * @param which
	 *            QueueLink : The queuelink to be linked before
	 */
	void insertBefore(QueueLink which) {

		if ((prev != null) || (next != null)) {
			sendWarning(
					"Can not insert QueueLink! Command ignored.",
					"QueueLink of Entity : " + item.getName()
							+ " in QueueBased : "
							+ motherQList.getQueueBased().getName()
							+ " Method : insertBefore" + "(QueueLink which)",
					"The QueueLink to be inserted already contains valid "
							+ "references to other QueueLinks, thus must not be inserted "
							+ "again using this QueueLink.",
					"Internal error. Please report to current DESMOJ-Developer.");
			return; // warning already linked somewhere else
		}

		this.next = which;
		this.prev = which.prev;
		which.prev = this;
		// only if predecessor present
		if (prev != null)
			this.prev.next = this;

	}

	/**
	 * Removes all references this queuelink has set up leaving no holes in the
	 * chains of queuelists and the entity's list of Queues it is in. Call this
	 * method directly before dropping the reference to this queuelink.
	 */
	void remove() {

		item.removeQueueLink(this); // drop entity's ref. to link
		nextQueue = null; // drop next queues
		prev = null; // drop previous queuelink
		next = null; // drop next queuelink
		item = null; // drop entity
		entryTime = null; // drop TimeInstant of entry point
		motherQList = null; // drop ref to qlist this was member of

	}

	/**
	 * Sends a warning to the error output by forwarding it to the associated
	 * queuelist's <code>sendwarning</code> method.
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
	 * @see QueueList
	 */
	void sendWarning(String description, String location, String reason,
			String prevention) {

		motherQList.sendWarning(description, location, reason, prevention);

	}

	/**
	 * Sets the queuelink following this one to the queuelink given as
	 * parameter.
	 * 
	 * @param nextLink
	 *            desmoj.QueueLink : The next queuelink after this queuelink
	 */
	void setNext(QueueLink nextLink) {

		next = nextLink;

	}

	/**
	 * Inserts the given queuelink directly after this queuelink in the single
	 * linked chain that entities have to keep track of the queues they are in.
	 * Note that it is perfectly legal to pass <code>null</code> values here
	 * since it must be possible to remove a reference. This method is for use
	 * by the entity only.
	 * 
	 * @param nextQ
	 *            QueueLink : The queuelink of the next queuelist to reference
	 */
	void setNextQueue(QueueLink nextQ) {
		/*
		 * if ( nextQ == null ) { sendWarning("Can not set reference to next
		 * QueueList! Command ignored.", "QueueLink of Entity :
		 * "+item.getName()+" in QueueBased : "+
		 * motherQList.getQueueBased().getName()+" Method : setNextQueue"+
		 * "(QueueLink which)", "The QueueLink parameter given is a null
		 * reference.", "Internal error. Please report to the current
		 * DESMOJ-Developer."); return; // warning already linked somewhere else }
		 */
		nextQueue = nextQ;

	}

	/**
	 * Sets the queuelink preceding this one to the queuelink given as
	 * parameter.
	 * 
	 * @param prevLink
	 *            desmoj.QueueLink : The preceding queuelink before this
	 *            queuelink
	 */
	void setPrev(QueueLink prevLink) {

		prev = prevLink;

	}

	/**
	 * Returns the point of simulation time this entity had entered the queue.
	 * 
	 * @return desmoj.TimeInstant : The entry time of the entity linked to this
	 *         queuelink
	 */
	TimeInstant timeIn() {

		return entryTime;

	}
}