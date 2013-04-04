package desmoj.core.simulator;

/**
 * Provides the typical statistics common to all ModelComponents based on
 * Queues. It is set abstract to prevent users to use it straight without
 * deriving a class first because it only provides the functionality for
 * statistical data extraction, not the functionality for actually queueing
 * Entities. The statistical values provided are the queue's length and its
 * elements' waiting times with minimum, maximum, mean and standard deviation
 * for each. This class should be used when any type of ModelComponent using
 * Queues is created. In combination with class QueueList an automatic
 * insert/remove mechanism including search functionality with condition
 * checking can be set up within a few lines of code. It also provides full
 * automatic statistical data about the Queue used.
 * 
 * @see QueueList
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Tim Lechler
 * @author modified by Soenke Claassen
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
public abstract class QueueBased extends desmoj.core.simulator.Reportable {

	/**
	 * Represents the value returned if for a given statistics no valid value
	 * can be returned.
	 */
	public static final double UNDEFINED = -1;

	/**
	 * Displays the current number of objects waiting inside the queue.
	 */
	private int currentLength;

	/**
	 * Flag for letting the underlying queue implementation (
	 * <code>QueueList</code>) show own warnings (<code>true</code>) or
	 * suppressing them (<code>false</code>). Is <code>false</code> by default
	 * but can be set to <code>true</code> for debugging purposes
	 */
	private boolean qImpWarnings;

	/**
	 * Displays the minimum number of objects that have been waiting inside the
	 * queue since the last reset.
	 */
	private int minimumLength;

	/**
	 * Displays the maximum number of objects that have been waiting inside the
	 * queue since the last reset.
	 */
	private int maximumLength;

	/**
	 * Displays the number of objects that have passed the queue without waiting
	 * time. Thus the name "zeros" for zero waiting time. Value is valid for the
	 * span of time since the last reset.
	 */
	private long zeros;

	/**
	 * Displays the sum of the queue length weighted over the time each object
	 * spent waiting in the queue. Value is valid for the span of time since the
	 * last reset.
	 */
	private double wSumLength;

	/**
	 * Displays the squares of the sums of the queue length weighted over the
	 * time each object spent waiting in the queue. Value is valid for the span
	 * of time since the last reset.
	 */
	private double wSumSquareLength;
	/**
	 * The point in simulation time the queue was last accessed. Value is valid
	 * for the span of time since the last reset.
	 */
	private TimeInstant lastAcc;

	/**
	 * The point in simulation time the queue's minimum length was recorded.
	 * Value is valid for the span of time since the last reset.
	 */
	private TimeInstant minimumLengthAt;

	/**
	 * The point in simulation time the queue's maximum length was recorded.
	 * Value is valid for the span of time since the last reset.
	 */
	private TimeInstant maximumLengthAt;

	/**
	 * The maximum time an object inside the queue spent waiting. Value is valid
	 * for the span of time since the last reset.
	 */
	private TimeSpan maximumWaitTime;

	/**
	 * The point in simulation time the maximum waiting time of an object inside
	 * the queue was recorded at. Value is valid for the span of time since the
	 * last reset.
	 */
	private TimeInstant maximumWaitTimeAt;

	/**
	 * The sum of the waiting times spent by all objects that have passed
	 * through the queue. Value is valid for the span of time since the last
	 * reset.
	 */
	private TimeSpan sumWaitTime;

	/**
	 * The square of the sums of the waiting times spent by all objects that
	 * have passed through the queue. Value is valid for the span of time since
	 * the last reset.
	 */
	private double sumSquareWaitTime;

	/**
	 * Defining a constant for the service discipline of the underlying queue.
	 * FIFO = First In First Out.
	 */
	public final static int FIFO = 0;

	/**
	 * Defining a constant for the service discipline of the underlying queue.
	 * LIFO = Last In First Out.
	 */
	public final static int LIFO = 1;

	/**
	 * Represents the maximum number of entities in the queue (default is
	 * unlimited capacity).
	 */
	protected int queueLimit = Integer.MAX_VALUE;

	/**
	 * An array representing the possible queueing strategies as implemented in
	 * the QueueListFifo and QueueListLifo classes. If new queueing strategies
	 * are added later on, they must be declared here also.
	 */
	protected java.lang.Class[] queueingStrategy = new Class[] {
			desmoj.core.simulator.QueueListFifo.class,
			desmoj.core.simulator.QueueListLifo.class };

	/**
	 * Creates a queuebased object and initializes all statistical counters. If
	 * this standard constructor is used a queue with Fifo sort order and no
	 * limited capacity will be created.
	 * 
	 * @param owner
	 *            desmoj.Model : The model it belongs to
	 * @param name
	 *            java.lang.String : The name for this QueueBased object
	 * @param showInReport
	 *            boolean : Flag if values are shown in report
	 * @param showInTrace
	 *            boolean : Flag if QueueBased writes trace messages
	 */
	public QueueBased(desmoj.core.simulator.Model owner, String name,
			boolean showInReport, boolean showInTrace) {

		super(owner, name, showInReport, showInTrace); // create reportable

		// initialize all statistics
		currentLength = 0; // no one in here at starting time
		lastAcc = presentTime(); // time of last access is now
		minimumLength = currentLength;
		maximumLength = currentLength;
		zeros = 0;
		wSumSquareLength = wSumLength = sumSquareWaitTime = 0.0;
		sumWaitTime = maximumWaitTime = new TimeSpan(0);
		maximumWaitTimeAt = minimumLengthAt = maximumLengthAt = presentTime();
		// reset points of simulation time

		qImpWarnings = false; // no queue implementation warnings

	}

	/**
	 * Updates the statistics when a new element is inserted into the underlying
	 * queue. Note that this method must always be called whenever an insertion
	 * is made. If class <code>QueueList</code> is used in combination with a
	 * queuebased, this method gets called automatically whenever a new entity
	 * is inserted.
	 * 
	 * @see QueueList
	 * @see QueueListFifo
	 * @see QueueListLifo
	 */
	protected void addItem() {

		updateStatistics();
		currentLength++;

		if (currentLength > maximumLength) { // do we have a new record high?
			maximumLength = currentLength; // yes, store the record length
			maximumLengthAt = presentTime(); // and write down the time for
			// it
		}

	}

	/**
	 * Returns the average length of the underlying queue since the last reset.
	 * Current length of that queue will be returned, if the time span since the
	 * last reset is smaller than the smallest distinguishable timespan epsilon.
	 * 
	 * @return double : The average queue length since last reset or current
	 *         length of queue if no distinguishable periode of time has passed
	 */
	public double averageLength() {

		TimeInstant now = presentTime(); // store current time
		TimeSpan deltaTime = TimeOperations.diff(now, resetAt()); // time since
		// last
		// reset
		if (TimeSpan.isEqual(deltaTime, TimeSpan.ZERO)) {
			// has no time passed since the last reset?

			return UNDEFINED; // value is not defined
		}

		// calculate the average length
		double avgLength = (wSumLength + (currentLength * TimeOperations.diff(
				now, lastAcc).getTimeInEpsilon()))
				/ deltaTime.getTimeInEpsilon();
		// not nice to read, but it really does calculate the average!!!

		// round the average length
		double rndAvgLength = java.lang.Math.rint(100000 * avgLength) / 100000;
		// return the rounded average length

		return rndAvgLength;

	}

	/**
	 * Returns the average waiting time of all objects who have exited the
	 * queue. Value is valid for the time span since the last reset. Returns 0
	 * (zero) if no objects have exited the queue after the last reset.
	 * 
	 * @return TimeSpan : Average waiting time of all objects since last reset
	 *         or 0 if no objects have exited the queue
	 */
	public TimeSpan averageWaitTime() {

		double obs = getObservations(); // get and store number of observations
		// return rounded average wait time
		if (obs > 0){
			// calculate the resulting average wait time
			TimeSpan avgWaitTime = TimeOperations.divide(sumWaitTime, obs);
			return avgWaitTime;
		}
		else
			return TimeSpan.ZERO; // no observations -> zero TimeSpan value

	}

	/**
	 * Creates the reporter qualified to produce a report about a class that has
	 * been derived from queuebased. This method is declared abstract since no
	 * real queuebased is supposed to be instantiated and thus no rReporter can
	 * be defined here. Implement this method in the subclasses of queuebased
	 * such as in class Queue.
	 * 
	 * @see Queue
	 */
	public abstract desmoj.core.report.Reporter createReporter();

	/**
	 * Updates the statistics when a new element is exiting the underlying
	 * queue. Note that this method must always be called whenever an object is
	 * taken from the queue. The simulation time parameter given provides the
	 * statistics with the information about the point of time the exiting
	 * object had enterd this queue. This is needed to calculate the waiting
	 * times. If a queuebased is used in conjunction with class queuelist, this
	 * method is automatically called whenever an entity is taken from the
	 * queuelist to keep track of
	 * 
	 * @param entryTime
	 *            TimeInstant : Point of simulation time that the object now
	 *            exiting the queuebased had entered it
	 */
	protected void deleteItem(TimeInstant entryTime) {

		updateStatistics();
		TimeInstant now = presentTime(); // Store the actual simulation time
		TimeSpan waitTime = TimeOperations.diff(now, entryTime); // time waited
		// in
		// queue
		sumWaitTime = TimeOperations.add(sumWaitTime, waitTime); // update
		// sum

		// calculate square of waitTimes and
		sumSquareWaitTime += waitTime.getTimeInEpsilon()
				* waitTime.getTimeInEpsilon();

		if (TimeSpan.isLonger(waitTime, maximumWaitTime)) // do we have a new
		// waiting record?
		{
			maximumWaitTime = waitTime; // store new record
			maximumWaitTimeAt = now; // and the moment it happened
		}
		if (TimeSpan.isEqual(waitTime, new TimeSpan(0))) {
			// waitTime was zero
			zeros++;
		}

		if (currentLength <= 0) {
			sendWarning("Inconsistent Qeueue length", "QueueBased : "
					+ getName() + " Method: void activateAfter(TimeSpan dt)",
					"Error in Statistic operations of Queues",
					"Report information to DESMO-J designer Tim Lechler via eMail : "
							+ "1lechler@informatik.uni-hamburg.de");
			return; // bad stuff ?? We got more objects in the queue than
			// registered!!!
		}

		currentLength--;

		if (currentLength < minimumLength) {
			minimumLength = currentLength;
		}

		incrementObservations();
	}

	/**
	 * Returns the maximum possible number of entities in the underlying queue.
	 * 
	 * @return int : the maximum number of entities in the queue.
	 */
	public int getQueueLimit() {
		return queueLimit;
	}

	/**
	 * Returns the current length of the underlying queue.
	 * 
	 * @return int : The current queue length
	 */
	public int length() {

		return currentLength;

	}

	/**
	 * Returns the maximum length of the underlying queue since the last reset.
	 * 
	 * @return int : The maximum queue length since last reset
	 */
	public int maxLength() {

		return maximumLength;

	}

	/**
	 * Returns the point of simulation time with the maximum number of objects
	 * waiting inside the underlying queue. The value is valid for the period
	 * since the last reset.
	 * 
	 * @return desmoj.TimeInstant : Point of time with maximum queue length
	 *         since last reset
	 */
	public TimeInstant maxLengthAt() {

		return maximumLengthAt;

	}

	/**
	 * Returns the maximum duration in simulation time that an object has spent
	 * waiting inside the underlying queue. The value is valid for the period
	 * since the last reset.
	 * 
	 * @return desmoj.TimeSpan : Longest waiting time of an object in the queue
	 *         since last reset
	 */
	public TimeSpan maxWaitTime() {

		return maximumWaitTime;

	}

	/**
	 * Returns the point of simulation time when the object with the maximum
	 * waiting time exited the underlying queue. The value is valid for the
	 * period since the last reset.
	 * 
	 * @return desmoj.TimeInstant : The point of simulation time when the object
	 *         with the maximum waiting time exited the queue
	 */
	public TimeInstant maxWaitTimeAt() {

		return maximumWaitTimeAt;

	}

	/**
	 * Returns the minimumn length of the underlying queue since the last reset.
	 * 
	 * @return int : The minimum queue length since last reset
	 */
	public int minLength() {

		return minimumLength;

	}

	/**
	 * Returns the point of simulation time with the minimum number of objects
	 * waiting inside the underlying queue. The value is valid for the period
	 * since the last reset.
	 * 
	 * @return desmoj.TimeInstant : Point of time with minimum queue length
	 *         since last reset
	 */
	public TimeInstant minLengthAt() {

		return minimumLengthAt;

	}

	/**
	 * Returns a boolean flag telling if the underlying queue implementation
	 * should issue own warnings or not. The warnings from the queue
	 * implementation (<code>QueueList</code>) are needed for debugging
	 * purposes.
	 * 
	 * @return boolean : Is <code>true</code> if the underlying queue
	 *         implementation should issue warnings, <code>false</code>
	 *         otherwise
	 */
	boolean qImpWarn() {

		return qImpWarnings;

	}

	/**
	 * Resets all statistical counters to their default values. The mininum and
	 * maximum length of the queue are set to the current number of queued
	 * objects.
	 */
	public void reset() {

		super.reset(); // reset of Reportable

		lastAcc = presentTime(); // time of last access is now
		minimumLength = currentLength;
		maximumLength = currentLength;
		zeros = 0;
		wSumLength = wSumSquareLength = sumSquareWaitTime = 0.0;
		sumWaitTime = maximumWaitTime = new TimeSpan(0);
		maximumWaitTimeAt = minimumLengthAt = maximumLengthAt = presentTime();
		// reset points of simulation time

	}

	/**
	 * Method switches on warnings issued from the underlying queue
	 * implementation if parameter given is <code>true</code>. Warnings are
	 * suppressed if <code>false</code> is given. This method is used for
	 * internal debugging only.
	 * 
	 * @param warnFlag
	 *            boolean :<code>true</code> switches warnings on,
	 *            <code>false</code> switches warnings off
	 */
	public void setQueueImpWarning(boolean warnFlag) {

		qImpWarnings = warnFlag;

	}

	/**
	 * Returns the standard deviation of the queue's length. Value is weighted
	 * over time.
	 * 
	 * @return double : The standard deviation for the queue's length weighted
	 *         over time
	 */
	public double stdDevLength() {

		TimeInstant now = presentTime(); // store current time
		TimeSpan deltaTime = TimeOperations.diff(now, resetAt()); // time since
		// last
		// reset
		if (TimeSpan.isEqual(deltaTime, TimeSpan.ZERO)) // 
			// no time passed since the last reset
			return UNDEFINED; // no valid data
		else {
			double len = currentLength; // store and convert length
			double mean = averageLength(); // get mean for queuelength
			TimeSpan spanSinceLastAcess = TimeOperations.diff(now, lastAcc); // time
																				// span
			// since last
			// access
			return java.lang.Math.sqrt(java.lang.Math
					.abs((wSumSquareLength + (len * len * spanSinceLastAcess
							.getTimeInEpsilon()))
							/ deltaTime.getTimeInEpsilon() - (mean * mean)));
		}

	}

	/**
	 * Returns the standard deviation of the queue's objects waiting times.
	 * 
	 * @return double : The standard deviation for the queue's objects waiting
	 *         times
	 */
	public TimeSpan stdDevWaitTime() {

		if (getObservations() > 0) {
			
			double mean = averageWaitTime().getTimeInEpsilon(); // get avrg time
			double obs = getObservations(); // number of obs exited

			return new TimeSpan(java.lang.Math.sqrt( // not nice but functual
					java.lang.Math
							.abs(((obs * sumSquareWaitTime) - (mean * mean))
									/ (obs * (obs - 1.0)))), TimeOperations
					.getEpsilon()); // as simple as
			// that
		} else
			return TimeSpan.ZERO; // no observations -> no values

	}

	/**
	 * Updates the parts of the statistics used by both addItem and deleteItem.
	 */
	protected void updateStatistics() {

		TimeInstant now = presentTime(); // store current time
		TimeSpan deltaTime = TimeOperations.diff(now, lastAcc); // get time
		// since last
		// xs
		wSumLength += currentLength * deltaTime.getTimeInEpsilon(); // weighted
		// length sum
		wSumSquareLength += currentLength * currentLength
				* deltaTime.getTimeInEpsilon();// weighted square length sum
		lastAcc = now;

	}

	/**
	 * Returns the number of objects that have passed through the queue without
	 * spending time waiting.
	 * 
	 * @return long : The number of elements who have passed the queue without
	 *         waiting
	 */
	public long zeroWaits() {

		return zeros;

	}
}