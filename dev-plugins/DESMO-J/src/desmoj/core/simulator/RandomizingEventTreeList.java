package desmoj.core.simulator;

import java.util.Random;

/**
 * A specialized event tree list providing random order for concurrent event notes.
 * Random order is achieved by computing a random insert position within the
 * range of simultaneous (concurrent) events. Existing connections between
 * events are maintained, i.e. a new event note will never be inserted between
 * two connected event notes. Connections are only possible between to
 * successive concurrent event notes where one of the notes was inserted by call
 * of the insertBefore() or the insertAfter() method. Most of the methods
 * inherited from the super class
 * {@link desmoj.core.simulator.EventTreeList EventTreeList}are only overwritten to
 * keep track of the existing connections.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Ruth Meyer, modified by Johannes Göbel
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
public class RandomizingEventTreeList extends EventTreeList {

	// -------------------------------------------------------------------
	// Fields

	/** the random position generator. */
	private Random positionGenerator;

	// -------------------------------------------------------------
	// Constructors

	/**
	 * Constructs a new randomizing event tree list. Initializes the event tree list
	 * and the random position generator.
	 */
	public RandomizingEventTreeList() {
		super();
		positionGenerator = new Random();
	}

	// ------------------------------------------------------------------
	// Methods

	/**
	 * Inserts the given new event note directly before the specified event
	 * note. Registers <code>where</code> as connected to <code>newNote</code>.
	 * 
	 * @param where :
	 *            the event note before which the new note shall be inserted
	 * @param newNote :
	 *            the new event note to be inserted
	 */
	void insertBefore(EventNote where, EventNote newNote) {
		super.insertBefore(where, newNote);
		// insertBefore means a "backward" connection: newNote is connected to
		// its successor where
		// this is translated to the "forward" connection: where is connected to
		// its predecessor newNote
		int i = this.eTreeList.indexOf(where);
		if (i >= 0)
			where.setConnected(true);
	}

	/**
	 * Inserts the given new event note directly behind the specified event
	 * note. Registers <code>newNote</code> as connected to <code>where</code>.
	 * 
	 * @param where :
	 *            the event note after which the new note shall be inserted
	 * @param newNote :
	 *            the new event note to be inserted
	 */
	void insertAfter(EventNote where, EventNote newNote) {
		super.insertAfter(where, newNote);
		// insertAfter means a "forward" connection: newNote is connected to its
		// predecessor where
		int i = this.eTreeList.indexOf(newNote);
		if (i >= 0)
            newNote.setConnected(true);
	}

	/**
	 * Inserts the given event note at the front of the event tree list.
	 * 
	 * @param newNote
	 *            EventNote : the new event note to be inserted as first note.
	 */
	void insertAsFirst(EventNote newNote) {
		super.insertAsFirst(newNote);
        newNote.setConnected(false);
	}

	/**
	 * Inserts the given event note at the back of the event tree list.
	 * 
	 * @param newNote
	 *            EventNote : the new event note to be inserted as last note.
	 */
	void insertAsLast(EventNote newNote) {
		super.insertAsLast(newNote);
        newNote.setConnected(false);
	}

	/**
	 * Removes the given note from the event tree list.
     * A connection between the note's previous and next note
     * is established if and only if the given note was 
     * connnect to both the previous and next node.
	 * 
	 * @param note
	 *            EventNote : the event note to be removed
	 */
	void remove(EventNote note) {
		int i = this.eTreeList.indexOf(note);
		if (i >= 0) {
            EventNote prev = this.prevNote(note);
            EventNote next = this.nextNote(note);
            if (prev != null && next != null) {
                if (note.isConnected() && next.isConnected()) 
                    next.setConnected(true); 
                else 
                    next.setConnected(false);
            }
			super.remove(note);
		}
	}

	/**
	 * Removes the first event note (if any).
	 */
	void removeFirst() {
		if (!this.isEmpty()) {
			super.removeFirst();
            if (this.isEmpty())
                this.firstNote().setConnected(false);
		}
	}

	/**
	 * Inserts the given event note into the event tree list. Overwrites the
	 * inherited insert() method to achieve random insert for concurrent events.
	 * Takes possible connections between existing event notes into account,
	 * i.e. will not insert the new note between connected events. Connections
	 * may only exist between two events of the same time where one of the
	 * events has been inserted via insertBefore() or insertAfter().
	 * 
	 * @param newNote
	 *            EventNote : the event note to be inserted
	 */
	//TODO:
	void insert(EventNote newNote) {
		if (isEmpty()) {
			super.insert(newNote);
            newNote.setConnected(false);
			// notes inserted via insert() are not connected to other notes
			return; // no need to continue
		}
		// use binary search to determine first event note with same time
		TimeInstant refTime = newNote.getTime();
		int firstIndexForInsert, lastIndexForInsert;
		int left = 0;
		int right = eTreeList.size();
		while (left < right) {
			int middle = (left + right) / 2;
			if (TimeInstant.isBefore(((EventNote) eTreeList.get(middle)).getTime(),
					refTime)) {
				left = middle + 1;
			} else {
				right = middle;
			}
		}
		if (right < eTreeList.size()
				&& TimeInstant.isEqual(((EventNote) eTreeList.get(right)).getTime(),
						refTime)) {
			// same time found
			firstIndexForInsert = right;
			// look for last event note with same time; last position to insert
            // is AFTER last concurrent note 
			lastIndexForInsert = findLastIndex(firstIndexForInsert) + 1;
		} else {
			// same time not found, but right still holds the insert position
			firstIndexForInsert = right;
			lastIndexForInsert = firstIndexForInsert;
		}
		// do we need to generate a random insert position?
		if (firstIndexForInsert != lastIndexForInsert) {
			// yeah, so here we go
			firstIndexForInsert += positionGenerator.nextInt(lastIndexForInsert - firstIndexForInsert + 1);
			// defer in case connection violated
			while (firstIndexForInsert < this.eTreeList.size() && ((EventNote) eTreeList.get(firstIndexForInsert)).isConnected()) firstIndexForInsert++;
		}
		// at last do the actual inserting
		this.eTreeList.add(firstIndexForInsert, newNote);
        newNote.setConnected(false);
	}

	/**
	 * This helper method determines the position of the last event note with
	 * the same time as the event note at position firstIndex doing a simple
	 * linear search from firstIndex.
	 */
	protected int findLastIndex(int firstIndex) {
		TimeInstant refTime = ((EventNote) eTreeList.get(firstIndex)).getTime();
		int lastIndex = firstIndex + 1;
		while (lastIndex < eTreeList.size()
				&& TimeInstant.isEqual(refTime,
						((EventNote) eTreeList.get(lastIndex)).getTime())) {
			lastIndex++;
		}
		return lastIndex - 1;
	}

} /* end of class RandomizingEventTreeList */