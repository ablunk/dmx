package desmoj.core.simulator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @deprecated Originally used for time conversion operations. Refer to 
 * TimeOperations.
 *             
 * TimeConverter is a class used by Experiment to convert sim time values to
 * true time values and vice versa. A true time value is a point in "real" time
 * specified as a String consisting of a date and a time, for example "26.3.2001
 * 13:25". In order to map the sim time values to true time values a reference
 * time and a time unit are needed. The class <code>TimeConverter</code>
 * implements the interface {@link desmoj.core.simulator.Units Units}to easily
 * use the time units and conversion factors defined there.
 * <p>
 * Every experiment has its own time converter and provides methods for time
 * conversion. The <code>TimeConverter</code> class is not intended for direct
 * use in model components because handling of (simulation) time should be done
 * in experiments only. Instead, if a model component needs to convert true time
 * values to sim time or vice versa it has to call the appropriate methods of
 * the class <code>Experiment</code>.
 * 
 * @version DESMO-J, Ver. 2.3.5 copyright (c) 2013
 * @author Ruth Meyer
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
class TimeConverter implements Units {

	/**
	 * The default output format pattern for true time values as a constant.
	 * Specified according to the time format syntax used in the
	 * <code>java.text.SimpleDateFormat</code> class.
	 */
	static final String DEFAULT_PATTERN = "dd.MM.yyyy HH:mm:ss:SSS";

	/**
	 * The default date used for true time values is <tt>1.1.1970</tt>.
	 */
	static final String DEFAULT_DATE = "1.1.1970";

	/**
	 * The default time used for true time values is <tt>0:00:00</tt>.
	 */
	static final String DEFAULT_TIME = "00:00:00";

	/**
	 * The default time unit is <code>Units.MIN</tt>.
	 */
	static final int DEFAULT_UNIT = Units.MIN;

	/**
	 * The interval between reference time (= start time of simulation) and
	 * default time of class <code>java.util.Date</code>(= 1.1.1970 0:00:00)
	 * in milliseconds.
	 */
	private long _offset;

	/**
	 * The reference time unit as a constant defined in interface
	 * <code>Units</code>.
	 */
	private int _unit;

	/**
	 * The output formatter for true time values. Uses the default pattern if no
	 * other pattern is specified via call of the
	 * {@link #setTimeFormat(String) setTimeFormat}method.
	 */
	private SimpleDateFormat _outFormat;

	/**
	 * The start time of the simulation as double (sim time). Default is 0.0.
	 */
	private double _startSimTime;

	/**
	 * Default constructor for a time converter using the defined constants as
	 * default values for reference time (1.1.1970 0:00:00) and reference time
	 * unit (minutes).
	 * 
	 * @throws java.text.ParseException
	 *             Is never thrown because the default values for reference time
	 *             have a valid format.
	 */
	public TimeConverter() throws ParseException {
		this(DEFAULT_DATE + " " + DEFAULT_TIME, DEFAULT_UNIT);
	}

	/**
	 * Constructs a time converter with given reference time and reference unit.
	 * The reference time String should follow the format:
	 * <tt>&lt;date&gt;&lt;blank&gt;&lt;time&gt;<tt> with <tt>&lt;date&gt; = [d]d.[M]M.[yy]yy</tt> and
	 *  <tt>&lt;time&gt; = [H]H[:[m]m[:[s]s[:[S][S]S]]]</tt>
	 *  @param referenceTime String : the reference time as a String
	 *  @param referenceUnit int : the reference time unit as a constant defined
	 *  in the {@link desmoj.core.simulator.Units Units} interface
	 *  @throws java.text.ParseException if an error occurred while parsing
	 *  the reference time
	 */
	public TimeConverter(String referenceTime, int referenceUnit)
			throws ParseException {
		// initialize instance variables
		this._unit = referenceUnit;
		this._outFormat = new SimpleDateFormat(DEFAULT_PATTERN, Locale.GERMANY);
		this._startSimTime = 0.0;
		// parse parameter referenceTime
		String completeRefTime = checkRefTime(referenceTime);
		String pattern = constructPattern(completeRefTime);
		SimpleDateFormat inFormat = new SimpleDateFormat(pattern,
				Locale.GERMANY);
		Date ref = inFormat.parse(completeRefTime);
		// calculate offset = millisecs since 1.1.1970 0:00:00
		this._offset = ref.getTime();
	}

	/**
	 * Checks if the given reference time is complete. A complete true time
	 * value consists of &lt;date&gt;&lt;blank&gt;&lt;time&gt; with &lt;date&gt; =
	 * [d]d.[M]M.[yy]yy and &lt;time&gt; = [H]H[:[m]m[:[s]s[:[S][S]S]]]. If date
	 * or time is missing, the default values are used instead.
	 */
	private String checkRefTime(String refTime) {
		StringBuffer completeTime = new StringBuffer(17);
		if (refTime == null) {
			// neither date nor time --> use default values for both
			completeTime.append(DEFAULT_DATE);
			completeTime.append(" ");
			completeTime.append(DEFAULT_TIME);
		} else {
			int spacePos = refTime.indexOf(" ");
			if (spacePos < 0) {
				int pointPos = refTime.indexOf(".");
				if (pointPos < 0) {
					// apparently time only --> use default date
					completeTime.append(DEFAULT_DATE);
					completeTime.append(" ");
					completeTime.append(refTime);
				} else {
					// apparently date only --> use default time
					completeTime.append(refTime);
					completeTime.append(" ");
					completeTime.append(DEFAULT_TIME);
				}
			} else {
				// both date and time exist --> use given refTime
				completeTime.append(refTime);
			}
		}
		return completeTime.toString();
	}

	// /////////////////// helper methods /////////////////////////////////////

	/**
	 * Constructs a pattern to be used for parsing the given timeString. This
	 * private helper method is called in any of the above methods when a true
	 * time parameter has to be parsed. The following assumptions are made:
	 * <ol>
	 * <li>timeString consists of a date and a time separated by a blank (
	 * <tt>&lt;date&gt; &lt;time&gt;</tt>)</li>
	 * <li>&lt;date&gt; has the format <tt>[d]d.[M]M.[yy]yy</tt></li>
	 * <li>&lt;time&gt; has the format <tt>[H]H[:[m]m[:[s]s[:[S][S]S]]]</tt>
	 * </ol>
	 * Because the <code>SimpleDateFormat</code> class can use "minimal"
	 * patterns (for example: the pattern "d.M.yy" is okay for all dates
	 * consisting of 1 or 2 day digits, 1 or 2 month digits, and 2 or 4 year
	 * digits, separated by dots) the date format is no problem. But the time
	 * has to be checked on the number of elements (hours, minutes, seconds,
	 * milliseconds) used in order to construct the appropriate pattern.
	 */
	private String constructPattern(String timeString) {
		StringBuffer pattern = new StringBuffer(14);
		pattern.append("d.M.yy ");
		int spacePos = timeString.indexOf(" ");
		if (spacePos < 0) {
			// no time specified --> return pattern "as is"
			return pattern.toString();
		}
		// determine number of colons (:) in order to get number of time
		// elements
		int numberOfDelimiters = 0;
		int pos = timeString.indexOf(":", spacePos);
		while (pos >= 0) {
			pos = timeString.indexOf(":", pos + 1);
			numberOfDelimiters++;
		}
		// the time format depends on the number of elements
		// for each element use the minimal form
		switch (numberOfDelimiters) {
		case 3:
			pattern.insert(7, ":S");
		case 2:
			pattern.insert(7, ":s");
		case 1:
			pattern.insert(7, ":m");
		case 0:
			pattern.insert(7, "H");
		}
		return pattern.toString();
	}

	/**
	 * Returns the reference time as as String formatted as defined in the
	 * default output format pattern. A different format may be specified via
	 * call of the <code>setTimeFormat(String)</code> method.
	 * 
	 * @return String : the reference time which is the true time of the
	 *         simulation start. It is mapped to simulation time 0.0 if no other
	 *         simulation start time is specified.
	 */
	public String getReferenceTime() {
		return this._outFormat.format(new Date(this._offset));
	}

	/**
	 * Returns the reference time unit as a constant defined in the <code>
	 *  Units</code>
	 * interface.
	 * 
	 * @return the reference unit specifying what is meant by the simulation
	 *         time step 1.0
	 */
	public int getReferenceUnit() {
		return this._unit;
	}

	/**
	 * Resets the time format used to format true time values to the default
	 * pattern.
	 * 
	 * @see #DEFAULT_PATTERN
	 */
	public void resetTimeFormat() {
		this._outFormat.applyPattern(DEFAULT_PATTERN);
	}

	/**
	 * Sets the start time of the simulation to <code>initTime</code>. This
	 * method must be called if a start time other than 0.0 is used.
	 * 
	 * @param initTime
	 *            double the simulation start time as double (value of
	 *            <code>SimTime</code>)
	 */
	public void setStartSimTime(double initTime) {
		this._startSimTime = initTime;
	}

	/**
	 * Sets the time format used to format true time values. Initially, the
	 * default pattern is used for formatting.
	 * 
	 * @param pattern
	 *            String : the time format to be used for formatting true time
	 *            values. It must follow the time format syntax given in class
	 *            {@link java.text.SimpleDateFormat SimpleDateFormat}.
	 */
	public void setTimeFormat(String pattern) {
		this._outFormat.applyPattern(pattern);
	}

	/**
	 * Converts the given duration with the given time unit into a sim time
	 * value. The duration is interpreted as the interval between sim time 0.0
	 * and the calculated sim time value.
	 * 
	 * @param duration
	 *            double : the duration value to be converted
	 * @param unit
	 *            int : the time unit for the duration as a constant defined in
	 *            the {@link desmoj.core.simulator.Units Units}interface
	 * @return SimTime the sim time representing the given duration
	 */
	public SimTime toSimTime(double duration, int unit) {
		// transform duration in sim time
		// - because SimTime doesn't distinguish between points in time and
		// durations of time, a duration is interpreted as the interval between
		// sim time 0.0 and the corresponding duration sim time.
		// - the given duration is in the given unit -> just has to be converted
		// to reference unit
		double simDuration = duration * unitFactors[unit]
				/ unitFactors[this._unit];
		return new SimTime(simDuration);
	}

	/**
	 * Converts the given true time value to the corresponding sim time value.
	 * 
	 * @param trueTime
	 *            String : the true time value to be converted as a String
	 *            following the time format syntax of class
	 *            <code>SimpleDateFormat</code>.
	 * @return SimTime : the sim time representing the given true time
	 * @throws java.text.ParseException
	 *             If an error occurred while parsing the given true time String
	 * @see java.text.SimpleDateFormat
	 */
	public SimTime toSimTime(String trueTime) throws ParseException {
		// transform true time to sim time
		String pattern = constructPattern(trueTime);
		SimpleDateFormat inFormat = new SimpleDateFormat(pattern,
				Locale.GERMANY);
		Date trueDate = inFormat.parse(trueTime);
		// for this, subtract offset from trueDate (both are in milliseconds),
		// convert into reference unit and then add startSimTime (is in ref
		// unit)
		return new SimTime(((double) (trueDate.getTime() - this._offset))
				* unitFactors[MS] / unitFactors[this._unit] + this._startSimTime);
	}

	/**
	 * Converts the given sim time value to the corresponding true time value.
	 * 
	 * @param simTime
	 *            SimTime : the sim time value to be converted
	 * @return String : the true time representing the given sim time as a
	 *         String formatted according to the currently used time format.
	 *         Initially, this will be the default pattern.
	 */
	public String toTrueTime(SimTime simTime) {
		// transform sim time to true time
		// for this, subtract startSimTime from simTime (both are in reference
		// unit),
		// convert into milliseconds and then add offset (is in milliseconds)
		Date trueTime = new Date(
				(long) ((simTime.getTimeValue() - this._startSimTime)
						* unitFactors[this._unit] / unitFactors[MS] + this._offset));
		return this._outFormat.format(trueTime);
	}
	
	/**
	 * Converts the given sim time value to the corresponding true 
	 * time value and returns it as a Date object.
	 * 
	 * @param simTime
	 *            SimTime : the sim time value to be converted
	 * @return Date : the Date object representing the given sim time as a
	 *         
	 */
	public Date toTrueDate(SimTime simTime) {
		Date trueTime = new Date(
				(long) ((simTime.getTimeValue() - this._startSimTime)
						* unitFactors[this._unit] / unitFactors[MS] + this._offset));
		return trueTime;
	}

	/**
	 * Converts the given sim time value to the corresponding true time value
	 * using the given pattern as time format.
	 * 
	 * @param simTime
	 *            SimTime : the sim time value to be converted
	 * @param pattern
	 *            String : the time format to be used for formatting the true
	 *            time value
	 * @return String : the true time representing the given sim time as a
	 *         String formatted according to the given pattern
	 */
	public String toTrueTime(SimTime simTime, String pattern) {
		setTimeFormat(pattern);
		String trueTime = toTrueTime(simTime);
		resetTimeFormat();
		return trueTime;
	}
}