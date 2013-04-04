package desmoj.core.simulator;

import static java.util.concurrent.TimeUnit.*;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;



/**
 * Represents points in simulation time. Is used to indicate points in
 * simulation time at which the state of the model changes. Each point in
 * simulation time is represented by an individual object of this class and
 * offers its own methods for arithmetic operations.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Felix Klueckmann
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

public final class TimeInstant implements Comparable<TimeInstant> {

	
	private final long timeInEpsilon;

	/**
	 * Constructs a TimeInstant object with the given time value in the time
	 * unit of the given parameter. It represents a time instant in simulation
	 * time. Note that trying to create a TimeInstant object The simulation will
	 * also stop immediately if the TimeSpan is larger than Long.MAX_VALUE-1 (in
	 * the unit of epsilon).
	 * 
	 * @param time
	 *            long : The time value of this TimeInstant in the time unit of
	 *            unit.
	 * @param unit
	 *            TimeUnit: the TimeUnit
	 */
	public TimeInstant(long time, TimeUnit unit) {
		// System.out.println(time + " " + unit);
		// System.out.println("Format: "
		// + new SimpleDateFormat().format(new Date(time)));
		if (unit.compareTo(TimeOperations.getEpsilon()) < 0) {
			// unit is a finer granularity than epsilon
			if (TimeOperations.getStartTime() != null) {// Start time has been
				// set
				System.out.println("Starttime: "
						+ TimeOperations.getStartTime());
				long timeSinceStart = time // time since start...?
						- unit.convert(TimeOperations.getStartTime()// Achtung-negative
								// werden
								// positiv
								.getTimeInEpsilon(), TimeOperations
								.getEpsilon());
				System.out.println("TimeSinceStart: " + timeSinceStart);
				if (timeSinceStart != 0) {
					time = time
							- (timeSinceStart % unit.convert(1, TimeOperations
									.getEpsilon()));
				}
			}
		}
		this.timeInEpsilon = TimeOperations.getEpsilon().convert(time, unit);
		if (timeInEpsilon == Long.MAX_VALUE) {
			/*The timeInstant is too big. 
			(The method TimeUnit.convert(duration,unit)returns Long.MAX_VALUE if
			the result of the conversion is to big*/
			
			throw (new desmoj.core.exception.SimAbortedException(
					new desmoj.core.report.ErrorMessage(
							null,
							"Can't create TimeInstant object! Simulation aborted.",
							"Class : TimeInstant  Constructor : TimeInstant(long,TimeUnit)",
							"the TimeInstant is too big. ",
							"Can only create TimeInstant objects which are smaller than Long.MAX_VALUE (in the TimeUnit of epsilon).",
							null)));
		}
	}

	/**
	 * Constructs a TimeInstant object with the given time value in the time
	 * unit of the reference time. It represents a time Instant in simulation
	 * time.
	 * 
	 * @param time
	 *            long : The time value of this TimeInstant in the time unit of
	 *            the reference time.
	 */
	public TimeInstant(long timeInReferenceUnit) {
		this(timeInReferenceUnit, TimeOperations.getReferenceUnit());
	}
	
    /**
     * Constructs a TimeInstant object with the given time value in the time
     * unit of the reference time. It represents a time Instant in simulation
     * time.
     * 
     * @param time
     *            double : The time value of this TimeInstant in the time unit of
     *            the reference time.
     */
    public TimeInstant(double timeInReferenceUnit) {
        this((long) (timeInReferenceUnit
                * TimeOperations.getEpsilon().convert(1,
                        TimeOperations.getReferenceUnit())),
                TimeOperations.getEpsilon());
    }

	/**
	 * Constructs a TimeInstant object that represents the given instant of time
	 * specified by the Calendar object.
	 * 
	 * @param calendar
	 *            Calendar : the instant of time that is represented by this TimeIstant
	 * @see java.until.Calendar
	 */
	public TimeInstant(Calendar calendar) {
		this(calendar.getTimeInMillis(), MILLISECONDS);
	}

	/**
	 * Constructs a TimeInstant object that represents the given instant of time
	 * specified by the Date object.
	 * 
	 * @param date
	 *            Date : the instant of time that is represented by this TimeInstant
	 * @see java.until.Date
	 */
	public TimeInstant(Date date) {
		this(date.getTime(), MILLISECONDS);
	}

	/**
	 * Returns the value of the TimeInstant object as a long type in the time
	 * unit of epsilon
	 * 
	 * @return long: the time value of the TimeInstant object as a long type in
	 *         the time unit of epsilon
	 */
	public long getTimeInEpsilon() {
		return timeInEpsilon;
	}

	/**
	 * Returns the value of this TimeInstant object as a long type in the time
	 * unit given as a parameter. If the parameter has a coarser granularity
	 * than epsilon the returned value will be truncated, so lose precision.
	 * 
	 * 
	 * @return long: the time value of the TimeInstant object as a long type in
	 *         the time unit given as a parameter or Long.MIN_VALUE if
	 *         conversion would negatively overflow, or Long.MAX_VALUE if it
	 *         would positively overflow.
	 */
	public long getTimeTruncated(TimeUnit unit) {
		return unit.convert(timeInEpsilon, TimeOperations.getEpsilon());
	}

	/**
	 * Returns the value of this TimeInstant object as a long type in the time
	 * unit of the reference time. If the parameter has a coarser granularity
	 * than epsilon the returned value will be truncated, so lose precision.
	 * 
	 * 
	 * @return long: the time value of the TimeInstant object as a long type in
	 *         the time unit given as a parameter or Long.MIN_VALUE if
	 *         conversion would negatively overflow, or Long.MAX_VALUE if it
	 *         would positively overflow.
	 */
	public long getTimeTruncated() {
		return getTimeTruncated(TimeOperations.getReferenceUnit());
	}

	/**
	 * Returns the value of this TimeInstant object as a long type in the time
	 * unit given as a parameter. If the parameter has a coarser granularity
	 * than epsilon the returned value will be rounded, so lose precision.
	 * 
	 * @param TimeUnit
	 *            : the TimeUnit
	 * 
	 * @return long: the time value of the TimeInstant object as a long type in
	 *         the time unit given as a parameter or Long.MIN_VALUE if
	 *         conversion would negatively overflow, or Long.MAX_VALUE if it
	 *         would positively overflow.
	 */
	public long getTimeRounded(TimeUnit unit) {
		if (unit.compareTo(TimeOperations.getEpsilon()) > 0) {
			// unit has a coarser granularity than epsilon
			long halfAUnitInEpsilon = TimeOperations.getEpsilon().convert(1,
					unit) / 2;
			long durationInUnitTruncated = getTimeTruncated(unit);
			long difference = timeInEpsilon
					- TimeOperations.getEpsilon().convert(
							durationInUnitTruncated, unit);
			// if the time value in the unit Epsilon is bigger than
			if (difference >= halfAUnitInEpsilon) {
				return durationInUnitTruncated + 1;
			}
			return durationInUnitTruncated;
		} else {
			// unit has a finer granularity or is equal than epsilon
			return getTimeTruncated(unit);
		}

	}

	/**
	 * Returns the value of this TimeInstant object as a long type in the time
	 * unit of the reference time. If the parameter has a coarser granularity
	 * than epsilon the returned value will be rounded, so lose precision.
	 * 
	 * 
	 * @return long: the time value of the TimeInstant object as a long type in
	 *         the time unit given as a parameter or Long.MIN_VALUE if
	 *         conversion would negatively overflow, or Long.MAX_VALUE if it
	 *         would positively overflow.
	 */
	public long getTimeRounded() {
		return getTimeRounded(TimeOperations.getReferenceUnit());
	}

	/**
	 * Returns the value of this TimeInstant object as a double type in the time
	 * unit given as a parameter.
	 * 
	 * @return double: the time value of the TimeInstant object as a double type
	 *         in the time unit given as a parameter
	 */
	public double getTimeAsDouble(TimeUnit unit) {
		return timeInEpsilon
				/ (double) TimeOperations.getEpsilon().convert(1, unit);
	}

	/**
	 * Returns the value of this TimeInstant object as a double type in the time
	 * unit of the reference time.
	 * 
	 * @return double: the time value of the TimeInstant object as a double type
	 *         in the time unit given as a parameter
	 */
	public double getTimeAsDouble() {
		return getTimeAsDouble(TimeOperations.getReferenceUnit());
	}
	
   /**
     * @deprecated Replaced by getTimeAsDouble(). 
     * The value of this TimeInstant object as a double type in the time
     * unit of the reference time.
     * 
     * @return double: the time value of the TimeInstant object as a double type
     *         in the time unit given as a parameter
     */
    public double getTimeValue() {
        return getTimeAsDouble();
    }

	/**
	 * Checks if the first of two points of simulation time is before the
	 * second. Before means, that the time value of TimeInstant a is smaller and
	 * hence "earlier" than TimeInstant b. Note that this is a static method
	 * available through calling the class <code>TimeInstant</code> i.e.
	 * <code>TimeInstant.isAfter(a,b)</code> where a and b are valid TimeInstant
	 * objects.
	 * 
	 * @return boolean : True if a is before (earlier) than b
	 * @param a
	 *            TimeInstant : first comparand
	 * @param b
	 *            TimeInstant : second comparand
	 */
	public static boolean isBefore(TimeInstant a, TimeInstant b) {
		return (a.timeInEpsilon < b.timeInEpsilon);
	}

	/**
	 * Checks if the first of two points of simulation time is after the second.
	 * After means, that the time value of TimeInstant a is larger and hence
	 * "later" than TimeInstant b. Note that this is a static method available
	 * through calling the class <code>TimeInstant</code> i.e.
	 * <code>TimeInstant.isAfter(a,b)</code> where a and b are valid TimeInstant
	 * objects.
	 * 
	 * @return boolean : True if a is after (later) than b
	 * @param a
	 *            TimeInstant : first comparand
	 * @param b
	 *            TimeInstant : second comparand
	 */
	public static boolean isAfter(TimeInstant a, TimeInstant b) {
		return (a.timeInEpsilon > b.timeInEpsilon);
	}

	/**
	 * Checks if the first of two points of simulation time is after the second
	 * or equal to the second. After means, that the time value of TimeInstant a
	 * is larger and hence after TimeInstant b. Equal means, that they both
	 * describe the same point in simulation time. Note that this is a static
	 * method available through calling the class <code>TimeInstant</code> i.e.
	 * <code>TimeInstant.isAfterOrEqual(a,b)</code> where a and b are valid
	 * timeInstant objects.
	 * 
	 * @return boolean : True if a is after (later than )b or equal to b
	 * 
	 * @param a
	 *            TimeInstant : first comparand
	 * @param b
	 *            TimeInstant : second comparand
	 */
	public static boolean isAfterOrEqual(TimeInstant a, TimeInstant b) {
		return (isAfter(a, b) || isEqual(a, b));
	}

	/**
	 * Checks if the two TimeInstant parameters describe the same point of
	 * simulation time. Note that this is a static method available through
	 * calling the class <code>TimeInstant</code> i.e.
	 * <code>TimeInstant.isEqual(a,b)</code> where a and b are valid TimeInstant
	 * objects.
	 * 
	 * @return boolean : True if both parameters describe same point of
	 *         simulation time
	 * @param a
	 *            TimeInstant : first comparand
	 * @param b
	 *            TimeInstant : second comparand
	 */
	public static boolean isEqual(TimeInstant a, TimeInstant b) {
		return (a.timeInEpsilon == b.timeInEpsilon);
	}

	/**
	 * Checks if the first of two points of simulation time is before the second
	 * or equal to the second. Before means, that the time value of TimeInstant
	 * a is smaller and hence before TimeInstant b. Equal means, that they both
	 * describe the same point in simulation time. Note that this is a static
	 * method available through calling the class <code>TimeInstant</code> i.e.
	 * <code>TimeInstant.isBeforeOrEqual(a,b)</code> where a and b are valid
	 * timeInstant objects.
	 * 
	 * @return boolean : True if a is before (earlier than )b or equal to b
	 * 
	 * @param a
	 *            TimeInstant : first comparand
	 * @param b
	 *            TimeInstant : second comparand
	 */
	public static boolean isBeforeOrEqual(TimeInstant a, TimeInstant b) {
		return (isBefore(a, b) || isEqual(a, b));
	}

	/**
	 * Returns a hash code value for the object. This methode overides
	 * java.lang.Object.hashCode().The method is supported for the benefit of
	 * hashtables such as those provided by java.util.Hashtable.
	 * 
	 * @return: int: a hash code value for this TimeInstant.
	 */
	@Override
	public int hashCode() {
		return (int) (this.timeInEpsilon ^ (this.timeInEpsilon >>> 32));
	}

	/**
	 * Indicates whether this TimeInstant is equal to the given parameter.
	 * Returns true if the obj argument is a TimeInstant and represents the same
	 * point of time as this TimeInstant; false otherwise. This method overrides
	 * java.lang.Object.equals()
	 * 
	 * @param: object: the reference object with which to compare.
	 * @return: true if the obj argument is a TimeInstant and represents the
	 *          same point of time as this TimeInstant; false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof TimeInstant))
			return false;
		TimeInstant instant = (TimeInstant) o;
		return isEqual(this, instant);
	}

	/**
	 * Compares the given TimeInstant to this TimeInstant. This method
	 * implements the Comparable<TimeInstant> Interface
	 * 
	 * @param : TimeSpan : The TimeInstant to be compared to this TimeInstant
	 * 
	 * @return: int: Returns a negative integer, zero, or a positive integer as
	 *          this TimeInstant is before, at the same time, or after the given
	 *          TimeInstant.
	 */
	public int compareTo(TimeInstant anotherInstant) {
		long difference = this.getTimeInEpsilon()
				- anotherInstant.getTimeInEpsilon();
		if (difference < 0)
			return -1;
		if (difference > 0)
			return 1;
		return 0;
	}

	/**
	 * Returns the String Representation of this TimeInstant according to the
	 * TimeFormatter.
	 * 
	 * @see java.lang.Object#toString()
	 * @see desmoj.core.TimeFormatter
	 */
	public String toString() {
		return TimeOperations.formatTimeInstant(this);
	}
	
	   /**
     * Returns the String Representation of this TimeInstant according to the
     * TimeFormatter, truncating digits after the decimal point if necessary.
     * 
     * @param int : Maximum number of digits after decimal point 
     * 
     * @see java.lang.Object#toString()
     * @see desmoj.core.TimeFormatter
     */
    public String toString(int digits) {
        
        String result = TimeOperations.formatTimeInstant(this);
        
        if (result.lastIndexOf(".") >= 0) {
            result = result.substring(0, Math.max(result.length()-1, result.lastIndexOf(".") + digits)); 
        }
        return result;
    }
}
