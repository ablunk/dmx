package desmoj.core.simulator;

import java.util.concurrent.TimeUnit;


/**
 * TimeOperations is an utility class that provides arithmetic operations for
 * the time classes TimeInstant and TimeSpan. It also holds the time settings,
 * i.e. the granularity (epsilon) and the reference time unit.
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
public final class TimeOperations {

	/**
	 * The granularity of simulation time.Default is MICROSECONDS
	 */
	private static TimeUnit epsilon = TimeUnit.MICROSECONDS;

	/**
	 * The reference time unit specifying what is meant by the simulation time
	 * step of 1 in statements without an explicit declaration of a time unit
	 * like in <code>new TimeSpan(5)</code>.
	 */
	private static TimeUnit referenceUnit;

	/**
	 * The point in simulation time when the experiment has started.
	 */
	private static TimeInstant startTime;
	private static TimeFormatter myTimeFormatter;

	// Suppress default constuctor for noninstantiability
	private TimeOperations() {
	}

	/**
	 * Returns a new TimeSpan object representing the sum of the given TimeSpan
	 * objects. Note that the simulation will stop immediately if the resulting
	 * sum is larger than Long.MAX_VALUE-1 (in the unit of epsilon).
	 * 
	 * @return TimeSpan : A new TimeSpan as the sum of the TimeSpan parameters
	 * @param a
	 *            TimeSpan : TimeSpan parameter a
	 * @param b
	 *            TimeSpan : TimeSpan parameter b
	 */
	public static TimeSpan add(TimeSpan a, TimeSpan b) {
		if (Long.MAX_VALUE - a.getTimeInEpsilon() - b.getTimeInEpsilon() < 1) {
			// the resulting sum is too big
			throw (new desmoj.core.exception.SimAbortedException(
					new desmoj.core.report.ErrorMessage(
							null,
							"Can't add TimeSpan objects! Simulation aborted.",
							"Class : TimeOperations  Methode : add(TimeSpan a, TimeSpan b)",
							"the resulting sum is too big. ",
							"Can only create TimeSpan objects which are smaller than Long.MAX_VALUE (in the TimeUnit of epsilon).",
							null)));
		}
		return new TimeSpan(a.getTimeInEpsilon() + b.getTimeInEpsilon(),
				epsilon);
	}

	/**
	 * Returns a new TimeInstant object representing the sum of the given
	 * TimeSpan and TimeInstant, i.e. the point of time that is after the given
	 * TimeSpan relative to the given TimeInstant. Note that the simulation will
	 * stop immediately if the resulting sum is larger than Long.MAX_VALUE-1 (in
	 * the unit of epsilon).
	 * 
	 * @return TimeSpan : A new TimeInstant as the sum of the given TimeSpan and
	 *         the given TimeInstant
	 * @param span
	 *            TimeSpan : parameter a
	 * @param instant
	 *            TimeInstant : parameter b
	 */
	public static TimeInstant add(TimeSpan span, TimeInstant instant) {
		return TimeOperations.add(instant, span);
	}

	/**
	 * Returns a new TimeInstant object representing the sum of the given
	 * TimeSpan and TimeInstant parameter, i.e. the point of time that is after
	 * the given TimeSpan relative to the given TimeInstant. Note that the
	 * simulation will stop immediately if the resulting sum is larger than
	 * Long.MAX_VALUE-1 (in the unit of epsilon).
	 * 
	 * @return TimeSpan : A new TimeInstant as the sum of the given TimeSpan and
	 *         the given TimeInstant
	 * @param instant
	 *            TimeInstant : parameter a
	 * @param span
	 *            TimeSpan : parameter b
	 */
	public static TimeInstant add(TimeInstant instant, TimeSpan span) {
		if (instant.getTimeInEpsilon() > 0) {
			// overflow is possible
			if (Long.MAX_VALUE - span.getTimeInEpsilon()
					- instant.getTimeInEpsilon() < 1) {
				// the resulting sum is too big
				throw (new desmoj.core.exception.SimAbortedException(
						new desmoj.core.report.ErrorMessage(
								null,
								"Can't add TimeSpan and TimeInstant objects! Simulation aborted.",
								"Class : TimeOperations  Methode : add(TimeSpan a, TimeInstant b)",
								"the resulting sum is too big. ",
								"Can only create TimeInstant objects which are before Long.MAX_VALUE (in the TimeUnit of epsilon).",
								null)));
			}
		}
		return new TimeInstant(span.getTimeInEpsilon()
				+ instant.getTimeInEpsilon(), epsilon);
	}

	/**
	 * Returns a new TimeSpan object representing the absolute difference of the
	 * given TimeSpan objects.
	 * 
	 * @return TimeSpan : A new TimeSpan as the absolute difference of the
	 *         TimeSpan parameters
	 * @param a
	 *            TimeSpan : TimeSpan parameter a
	 * @param b
	 *            TimeSpan : TimeSpan parameter b
	 */
	public static TimeSpan diff(TimeSpan a, TimeSpan b) {

		if (TimeSpan.isShorter(a, b)) {
			return new TimeSpan(b.getTimeInEpsilon() - a.getTimeInEpsilon(),
					epsilon);
		}

		return new TimeSpan(a.getTimeInEpsilon() - b.getTimeInEpsilon(),
				epsilon);
	}

	/**
	 * Returns a new TimeSpan object representing the absolute difference of the
	 * given TimeInstant objects, i.e. the span of time between the two instants
	 * of time. Note that the simulation will stop immediately if the resulting
	 * sum is larger than Long.MAX_VALUE-1 (in the unit of epsilon).
	 * 
	 * @return TimeSpan : A new TimeSpan as the difference of the TimeSpan
	 *         parameters
	 * @param a
	 *            TimeInstant : parameter a
	 * @param b
	 *            TimeInstant : parameter b
	 */
	public static TimeSpan diff(TimeInstant a, TimeInstant b) {
		if (TimeInstant.isAfter(a, b)) {
			// a is after b
			if (b.getTimeInEpsilon() < 0) {
				// the resulting difference could be too big.

				if (Long.MAX_VALUE - 1 + b.getTimeInEpsilon() < a
						.getTimeInEpsilon()) {
					// the resulting difference is too big.
					throw (new desmoj.core.exception.SimAbortedException(
							new desmoj.core.report.ErrorMessage(
									null,
									"Can't subtract TimeInstant objects! Simulation aborted.",
									"Class : TimeOperations  Methode : diff(TimeSpan a, TimeInstant b)",
									"the resulting difference is too big. ",
									"Can only create TimeSpan objects which are smaller than Long.MAX_VALUE (in the TimeUnit of epsilon).",
									null)));
				}
			}
			return new TimeSpan(a.getTimeInEpsilon() - b.getTimeInEpsilon(),
					epsilon);
		} else {
			// b is after a
			if (a.getTimeInEpsilon() < 0) {
				// the resulting difference could be too big.

				if (Long.MAX_VALUE + a.getTimeInEpsilon() < b
						.getTimeInEpsilon()) {
					// the resulting difference is too big.
					throw (new desmoj.core.exception.SimAbortedException(
							new desmoj.core.report.ErrorMessage(
									null,
									"Can't subtract TimeInstant objects! Simulation aborted.",
									"Class : TimeOperations  Methode : diff(TimeSpan a, TimeInstant b)",
									"the resulting difference is too big. ",
									"Can only create TimeSpan objects which are smaller than Long.MAX_VALUE (in the TimeUnit of epsilon).",
									null)));
				}
			}

			return new TimeSpan(b.getTimeInEpsilon() - a.getTimeInEpsilon(),
					epsilon);
		}

	}

	/**
	 * Returns a new TimeSpan object representing the product of the given
	 * TimeSpan and the factor of type double. Note that the simulation will
	 * stop immediately if the resulting product is larger than Long.MAX_VALUE-1
	 * (in the unit of epsilon).
	 * 
	 * @return TimeSpan : A new TimeSpan as the product of span and factor
	 * @param span
	 *            TimeSpan : the span of time
	 * @param factor
	 *            double : the scalar factor
	 */
	public static TimeSpan multiply(TimeSpan span, double factor) {
		if (factor > 1) {
			// the resulting product could be too big
			if (Long.MAX_VALUE / factor < span.getTimeInEpsilon()) {
				// the resulting product is too big
				throw (new desmoj.core.exception.SimAbortedException(
						new desmoj.core.report.ErrorMessage(
								null,
								"Can't multiply TimeSpan and double value! Simulation aborted.",
								"Class : TimeOperations  Methode : multiply(TimeSpan span, double factor)",
								"the resulting product is too big. ",
								"Can only create TimeSpan objects which are shorter than Long.MAX_VALUE (in the TimeUnit of epsilon).",
								null)));
			}
		}
		return new TimeSpan((long) (span.getTimeInEpsilon() * factor), epsilon);
	}

	/**
	 * Returns a new TimeSpan object representing the product of the given
	 * TimeSpan and the factor of type double. Note that the simulation will
	 * stop immediately if the resulting product is larger than Long.MAX_VALUE-1
	 * (in the unit of epsilon).
	 * 
	 * @return TimeSpan : A new TimeSpan as the product of span and factor
	 * @param factor
	 *            double : the scalar factor
	 * @param span
	 *            TimeSpan : the span of time
	 */
	public static TimeSpan multiply(double factor, TimeSpan span) {
		return TimeOperations.multiply(span, factor);
	}

	/**
	 * Returns a new TimeSpan object representing the quotient of the given
	 * TimeSpan objects.
	 * 
	 * @return TimeSpan : A new TimeSpan as the quotient of dividend and divisor
	 * @param dividend
	 *            TimeSpan : the dividend
	 * @param divisor
	 *            TimeSpan : the divisor
	 */
	public static double divide(TimeSpan dividend, TimeSpan divisor) {
		if (divisor.getTimeInEpsilon() == 0) {
			// cannot divide by zero
			throw (new desmoj.core.exception.SimAbortedException(
					new desmoj.core.report.ErrorMessage(
							null,
							"Can't divide TimeSpan values! Simulation aborted.",
							"Class : TimeOperations  Methode : divide(TimeSpan dividend, TimeSpan divisor)",
							"Cannot devide by zero.",
							"Never try to devide by zero.", null)));
		}
		return ((double) dividend.getTimeInEpsilon() / (double) divisor
				.getTimeInEpsilon());

	}

	/**
	 * Returns a new TimeSpan object representing the quotient of the given
	 * TimeSpan and the divisor of type double. Note that the simulation will
	 * stop immediately if the resulting quotient is larger than
	 * Long.MAX_VALUE-1 (in the unit of epsilon).
	 * 
	 * @return TimeSpan : A new TimeSpan as the quotient of divident and divisor
	 * @param dividend
	 *            TimeSpan : the dividend
	 * @param divisor
	 *            double : the divisor
	 */
	public static TimeSpan divide(TimeSpan dividend, double divisor) {
		if (divisor <= 0) {
			// cannot divide by zero
			throw (new desmoj.core.exception.SimAbortedException(
					new desmoj.core.report.ErrorMessage(
							null,
							"Can't divide TimeSpan and double value! Simulation aborted.",
							"Class : TimeOperations  Methode : mdivide(TimeSpan dividend, double divisor)",
							"Cannot devide by zero.",
							"Never try to devide by zero.", null)));
		}
		if (divisor < 1) {
			// the resulting quotient could be too big
			if (Long.MAX_VALUE * divisor < dividend.getTimeInEpsilon()) {
				// the resulting product is too big
				throw (new desmoj.core.exception.SimAbortedException(
						new desmoj.core.report.ErrorMessage(
								null,
								"Can't divide TimeSpan and double value! Simulation aborted.",
								"Class : TimeOperations  Methode : mdivide(TimeSpan dividend, double divisor)",
								"the resulting quotient is too big. ",
								"Can only create TimeSpan objects which are shorter than Long.MAX_VALUE (in the TimeUnit of epsilon).",
								null)));
			}
		}
		return new TimeSpan((long) (dividend.getTimeInEpsilon() / divisor),
				epsilon);
	}

	/**
	 * Returns the epsilon value representing the granularity of simulation time
	 * for this experiment.
	 * 
	 * @return TimeUnit : The granularity of simulation time
	 */
	static TimeUnit getEpsilon() {
		return epsilon;
	}

	/**
	 * Returns the reference time unit specifying what is meant by the
	 * simulation time step of 1 in statements without an explicit declaration
	 * of a time unit like in <code>new TimeSpan(5)</code>.
	 * 
	 * 
	 * @return the reference time unit
	 * 
	 */
	static TimeUnit getReferenceUnit() {
		return referenceUnit;
	}

	/**
	 * Sets the epsilon value representing the granularity of simulation time to
	 * the given TimeUnit parameter. This is a package private method for
	 * internal framework use only.
	 * 
	 * @param eps
	 *            TimeUnit : The granularity of simulation time, i.e. the
	 *            smallest distinguishable span of simulation time.
	 */
	static void setEpsilon(TimeUnit epsilon) {
		TimeOperations.epsilon = epsilon;
	}

	/**
	 * Sets the reference time unit specifying what is meant by the simulation
	 * time step of 1 in statements without an explicit declaration of a time
	 * unit like in <code>new TimeSpan(5)</code>. This is a package private
	 * method for internal framework use only.
	 * 
	 * 
	 * @param referenceUnit
	 *            the reference time unit
	 * 
	 */
	static void setReferenceUnit(TimeUnit referenceUnit) {
		TimeOperations.referenceUnit = referenceUnit;
	}

	/**
	 * Formats the given instant of time according to the timeFormatter. This is
	 * a package private method for internal framework use only.
	 * 
	 * @param timeInstant
	 *            the instant of time to be formatted
	 * 
	 */

	static String formatTimeInstant(TimeInstant instant) {
		return myTimeFormatter.buildTimeString(instant);
	}

	/**
	 * Formats the given span of time according to the timeFormatter. This is a
	 * package private method for internal framework use only.
	 * 
	 * @param timeSpan
	 *            the span of time to be formatted
	 * 
	 */
	static String formatTimeSpan(TimeSpan span) {
		return myTimeFormatter.buildTimeString(span);
	}

	/**
	 * Returns the time Formatter. This is a package private method for internal
	 * framework use only.
	 */
	public static TimeFormatter getTimeFormatter() {
		return myTimeFormatter;
	}

	/**
	 * Sets the time Formatter. This is a package private method for internal
	 * framework use only.
	 * 
	 * @param TimeFormatter
	 *            the Time Formatter
	 */
	static void setTimeFormatter(TimeFormatter myTimeFormatter) {
		TimeOperations.myTimeFormatter = myTimeFormatter;
	}

	/**
	 * Returns the TimeInstant when the experiment has started.
	 * 
	 * @return TimeInstant : The point in simulation time, the experiment has
	 *         started.
	 */
	public static TimeInstant getStartTime() {
		return startTime;
	}

	static void setStartTime(TimeInstant startTime) {
		TimeOperations.startTime = startTime;
	}
}