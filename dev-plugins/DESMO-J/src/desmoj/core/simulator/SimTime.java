package desmoj.core.simulator;

/**
 * @deprecated Represents points in simulation time. Is used to indicate points
 *             in simulation time at which the state of the model changes. Each
 *             point in simulation time is represented by an individual object
 *             of this class and offers its own methods for arithmetic
 *             operations. Ensures that only valid points of time are generated.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Tim Lechler
 * @author modified by Felix Klueckmann
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
@Deprecated
public class SimTime {

	/**
	 * NOW defines the value for scheduling an object immediately, even
	 * replacing the current SimProcess. Since the value is otherwise arbitrary
	 * as long as it is unique and can not be confused with any other legal or
	 * illegal (negative) value, it is set to be the constant defined in
	 * java.lang.Double and in java.lang.Float representing a non-number value.
	 * 
	 * @see java.lang.Double
	 * @see java.lang.Float
	 */
	public static final SimTime NOW = new SimTime(0.0);

	/**
	 * Stores the point of simulation time as double value for each SimTime
	 * object.
	 */
	private final double myTime;

	/**
	 * Constructs a simtime object with the given initial time value. It
	 * represents a point in simulation time. Note that only points of future
	 * simulation time can be accessed and that trying to create a simtime
	 * object with negative initial value will stop the simulation immediately.
	 * 
	 * @param time
	 *            double : The time value of this simtime with a simtime.
	 */
	public SimTime(double time) {

		super(); // default object constructor

		if (time < 0.0) { // points of time must be postive
			throw (new desmoj.core.exception.SimAbortedException(
					new desmoj.core.report.ErrorMessage(null,
							"Can't create SimTime object! Simulation aborted.",
							"Class : SimTime  Constructor : SimTime(double)",
							"the value passed for instantiation is negative : "
									+ time,
							"Negative values for simulation time are illegal.",
							null)));
		}

		myTime = time;

	}

	/**
	 * Constructs a simtime object with the given initial time object. It
	 * represents a point in simulation time. Note that only points of future
	 * simulation time can be accessed and that trying to create a SimTime
	 * object with negative initial value will stop the simulation immediately.
	 * 
	 * @param time
	 *            SimTime : The time of this SimTime
	 */
	public SimTime(SimTime time) {

		myTime = time.getTimeValue();

	}

	/**
	 * Returns a new simtime object with a time value representing the sum of
	 * the time values of the given simtime objects.
	 * 
	 * @return SimTime : A new simtime as the sum of the simtime parameters
	 * @param a
	 *            SimTime : Simtime parameter a
	 * @param b
	 *            SimTime : Simtime parameter b
	 */
	public final static SimTime add(SimTime a, SimTime b) {

		return new SimTime(a.getTimeValue() + b.getTimeValue());

	}

	/**
	 * Returns a new simtime object with a time value representing the absolute
	 * difference of the time values of the given simtime objects. Note that
	 * since no negative time values are allowed, <code>null</code> will be
	 * returned if the result of the subtraction would have resulted in a
	 * negative value. That is, a's time value is smaller than b's.
	 * 
	 * @return SimTime : A new SimTime as the absolute difference of the SimTime
	 *         parameters given
	 * @param a
	 *            SimTime : Simtime parameter a of which parameter b will be
	 *            subtracted
	 * @param b
	 *            SimTime : Simtime parameter b subtracted from parameter a
	 */
	public final static SimTime diff(SimTime a, SimTime b) {

		if (a.getTimeValue() == b.getTimeValue())
			return new SimTime(0.0);

		double delta = a.getTimeValue() - b.getTimeValue();

		if (delta < 0)
			delta = -delta;

		if (delta < 0.000001)
			delta = 0;
		return new SimTime(delta);

	} // It's as simple as that

	/**
	 * Returns the value of the simtime object as type double.
	 * 
	 * @return double : The value of the SimTime object as type double
	 */
	public double getTimeValue() {

		return myTime; // not much else to do

	}

	/**
	 * Checks if the two simtime parameters describe the same point of
	 * simulation time. Note that this is a static method available through
	 * calling the class <code>SimTime</code> i.e.
	 * <code>SimTime.isEqual(a,b)</code> where a and b are valid simtime
	 * objects.
	 * 
	 * @return boolean : True if both parameters describe same point of
	 *         simulation time
	 * @param a
	 *            SimTime : first comparand
	 * @param b
	 *            SimTime : second comparand
	 */
	public final static boolean isEqual(SimTime a, SimTime b) {

		return (a.getTimeValue() == b.getTimeValue());

	}

	/**
	 * Checks if the first of two points of simulation time is larger than the
	 * second. Larger means, that the time value of simtime a is larger and
	 * hence "later" than simtime b. Note that this is a static method available
	 * through calling the class <code>SimTime</code> i.e.
	 * <code>SimTime.isLargerThan(a,b)</code> where a and b are valid simtime
	 * objects.
	 * 
	 * @return boolean : True if a is larger (later) than b
	 * @param a
	 *            SimTime : first comparand
	 * @param b
	 *            SimTime : second comparand
	 */
	public final static boolean isLarger(SimTime a, SimTime b) {

		return (a.getTimeValue() > b.getTimeValue());

	}

	/**
	 * Checks if the first of two points of simulation time is larger or equal
	 * to the second. Larger means, that the time value of simtime a is larger
	 * and hence "later" than simtime b. Equal means, that they both describe
	 * the same point in simulation time. Note that this is a static method
	 * available through calling the class <code>SimTime</code> i.e.
	 * <code>SimTime.isLargerOrEqual(a,b)</code> where a and b are valid simtime
	 * objects.
	 * 
	 * @return boolean : True if a is larger (later) or equal to b
	 * @param a
	 *            SimTime : first comparand
	 * @param b
	 *            SimTime : second comparand
	 */
	public final static boolean isLargerOrEqual(SimTime a, SimTime b) {

		return (a.getTimeValue() >= b.getTimeValue());

	}

	/**
	 * Checks if the two simtime parameters describe the different points of
	 * simulation time. Note that this is a static method available through
	 * calling the class <code>SimTime</code> i.e.
	 * <code>SimTime.isNotEqual(a,b)</code> where a and b are valid simtime
	 * objects.
	 * 
	 * @return boolean : True if parameters describe different points of
	 *         simulation time
	 * @param a
	 *            SimTime : first comparand
	 * @param b
	 *            SimTime : second comparand
	 */
	public final static boolean isNotEqual(SimTime a, SimTime b) {

		return (a.getTimeValue() != b.getTimeValue());

	}

	/**
	 * Checks if the first of two points of simulation time is smaller than the
	 * second. Smaller means, that the time value of SimTime a is larger and
	 * hence "sooner" than simtime b. Note that this is a static method
	 * available through calling the class <code>SimTime</code> i.e.
	 * <code>SimTime.isLargerThan(a,b)</code> where a and b are valid simtime
	 * objects.
	 * 
	 * @return boolean : True if a is smaller (sooner) than b
	 * @param a
	 *            SimTime : first comparand
	 * @param b
	 *            SimTime : second comparand
	 */
	public final static boolean isSmaller(SimTime a, SimTime b) {

		return (a.getTimeValue() < b.getTimeValue());

	}

	/**
	 * Checks if the first of two points of simulation time is smaller or equal
	 * to the second. Smaller means, that the time value of simtime a is smaller
	 * and hence "sooner" than simtime b. Equal means, that they both describe
	 * the same point in simulation time. Note that this is a static method
	 * available through calling the class <code>SimTime</code> i.e.
	 * <code>SimTime.isSmallerOrEqual(a,b)</code> where a and b are valid
	 * simtime objects.
	 * 
	 * @return boolean : True if a is smaller (sooner) or equal to b
	 * @param a
	 *            SimTime : first comparand
	 * @param b
	 *            SimTime : second comparand
	 */
	public final static boolean isSmallerOrEqual(SimTime a, SimTime b) {

		return (a.getTimeValue() <= b.getTimeValue());

	}

	/**
	 * Returns the special point of time to be used for replacing the current
	 * running process or schedule an entity at the first position in the
	 * event-list.
	 * 
	 * @return desmoj.SimTime : The special simtime object used to indicate
	 *         immediate scheduling, preempting a current simprocess
	 */
	public static final SimTime now() {

		return NOW;

	}

	/**
	 * Prints the time value of this simtime with all floating point digits.
	 * 
	 * @return java.lang.String : The string representation of a simtime
	 */
	public String toString() {

		// convert time value to string
		String s = Double.toString(myTime);
		return s;

	}

	/**
	 * Prints the time value of this simtime with the given number of floating
	 * point digits.
	 * 
	 * @return java.lang.String : The string representation of a simtime
	 * @param floats
	 *            int : The number of floating point digits to print
	 */
	public String toString(int floats) {

		// convert time value to String
		String s = Double.toString(myTime);

		// is the value larger than 10E7, <- that format is used giving the
		// decimal
		// point quite a different meaning
		if (myTime > 10E7)
			return s; // so return the whole number

		// get position of decimal point if available
		int decimalPoint = s.lastIndexOf(".");

		if (decimalPoint <= 0) {// no decimal point contained which can't really
			// be
			return s; // print it
		} else { // there is a decimal point at position decimalPoint
			if (floats == 0)
				return s.substring(0, decimalPoint); // no decPoint wanted
			if ((floats + 1) >= (s.length() - decimalPoint)) { // no more than
				// the floats
				return s;
			} else
				return s.substring(0, decimalPoint + floats + 1); // truncate
			// at
			// decimal
		}

	}

	/**
	 * Converts the given TimeInstant object to a SimTime object.
	 * 
	 * @param instant
	 *            TimeInstant : The TimeInstant to be converted
	 * @return SimTime : The resulting SimTime from the conversion
	 * @author Felix Klueckmann (07/09)
	 */
	static SimTime toSimTime(TimeInstant instant) {
		return new SimTime(instant.getTimeAsDouble());
	}
	
	   /**
     * Converts the given TimeInstant object to a SimTime object.
     * 
     * @param instant
     *            TimeInstant : The TimeInstant to be converted
     * @return SimTime : The resulting SimTime from the conversion
     * @author Felix Klueckmann (07/09)
     */
    static SimTime toSimTime(TimeSpan span) {
        return new SimTime(span.getTimeAsDouble());
    }

	/**
	 * Converts the given SimTime object to a TimeInstant object. Note that only
	 * SimTime objects with a time value smaller or equal than Long.MAX_VALUE
	 * can be converted and that trying to convert a simtime object with a time
	 * value that is bigger than Long.MAX_VALUE will stop the simulation
	 * immediately.
	 * 
	 * @param simTime
	 *            SimTime : The SimTime to be converted
	 * @return TimeInstant : The resulting TimeInstant from the conversion
	 * @author Felix Klueckmann (07/09)
	 */
	public static TimeInstant toTimeInstant(SimTime simTime) {
		double timeValue = simTime.getTimeValue();
		if (timeValue > Long.MAX_VALUE) {
			throw (new desmoj.core.exception.SimAbortedException(
					new desmoj.core.report.ErrorMessage(
							null,
							"Can't convert SimTime to TimeInstant object! Simulation aborted.",
							"Class : SimTime  Methode : toTimeInstant(SimTime)",
							"the double value passed as a parameter is bigger than Long.MAX_VALUE : "
									+ simTime.getTimeValue(),
							"Can not create TimeInstant objects with a time Value bigger than Long.MAX_VALUE.",
							null)));
		}
		return new TimeInstant((long) (timeValue
				* TimeOperations.getEpsilon().convert(1,
						TimeOperations.getReferenceUnit())),
				TimeOperations.getEpsilon());
	}

	/**
	 * Converts the given SimTime object to a TimeSpan object. Note that only
	 * SimTime objects with a time value smaller or equal than Long.MAX_VALUE
	 * can be converted and that trying to convert a simtime object with a time
	 * value that is bigger than Long.MAX_VALUE will stop the simulation
	 * immediately.
	 * 
	 * @param simTime
	 *            SimTime : The SimTime to be converted
	 * @return TimeSpan : The resulting TimeSpan from the conversion
	 * @author Felix Klueckmann (07/09)
	 */
	public static TimeSpan toTimeSpan(SimTime simTime) {
		if (simTime == SimTime.NOW) {
			return TimeSpan.ZERO;
		}
		double timeValue = simTime.getTimeValue();
		if (timeValue > Long.MAX_VALUE) {
			throw (new desmoj.core.exception.SimAbortedException(
					new desmoj.core.report.ErrorMessage(
							null,
							"Can't convert SimTime to TimeSpan object! Simulation aborted.",
							"Class : SimTime  Methode : toTimeSpan(SimTime)",
							"the double value passed as a parameter is bigger than Long.MAX_VALUE : "
									+ simTime.getTimeValue(),
							"Can not create TimeSpan objects with a time Value bigger than Long.MAX_VALUE.",
							null)));
		}
		return new TimeSpan(timeValue);
	}
}