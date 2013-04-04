package desmoj.core.statistic;

import java.util.Observable;

import desmoj.core.simulator.Model;

/**
 * The <code>Count</code> class is simply counting something during an
 * experiment. Be careful the counter can be updated with positive and negative
 * integer numbers!
 * 
 * To get this <code>Count</code> object updated automatically every time a
 * <code>ValueSupplier</code> has changed, call the <code>addObserver
 * (Observer)</code>
 * -method from the <code>ValueSupplier</code> of interest, where Observer is
 * this <code>Count</code> object. <br>
 * This must be done by the user in his model! <br>
 * Consider usage of class <code>Aggregate</code> to count non-integer 
 * (i.e. double) values.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Soenke Claassen
 * @author based on DESMO-C from Thomas Schniewind, 1998
 * @author modified by Ruth Meyer
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

public class Count extends desmoj.core.statistic.StatisticObject {

	// ****** attributes ******

	/**
	 * The minimum of all values so far
	 */
	private long min;

	/**
	 * The maximum of all values so far
	 */
	private long max;

	/** The current counter value */
	private long value;

	/**
	 * Flag indicating if this count will retain its value during a reset.
	 * Default is false.
	 */
	private boolean isResetResistant;

	// ****** methods ******

	/**
	 * Constructor for a Count object.
	 * 
	 * @param ownerModel
	 *            Model : The model this Count is associated to
	 * @param name
	 *            java.lang.String : The name of this Count object
	 * @param showInReport
	 *            boolean : Flag for showing the report Set it to
	 *            <code>true</code> if this Count should show up in report.
	 *            Set it to <code>false</code> if this Count should not be
	 *            shown in report.
	 * @param showInTrace
	 *            boolean : Flag for showing this Count in trace files. Set it
	 *            to <code>true</code> if this Count should show up in trace.
	 *            Set it to <code>false</code> if this Count should not be
	 *            shown in trace.
	 */
	public Count(Model ownerModel, String name, boolean showInReport,
			boolean showInTrace) {
		this(ownerModel, name, showInReport, showInTrace, false);
	}

	/**
	 * Constructor for a Count object.
	 * 
	 * @param ownerModel
	 *            Model : The model this Count is associated to
	 * @param name
	 *            java.lang.String : The name of this Count object
	 * @param showInReport
	 *            boolean : Flag for showing the report Set it to
	 *            <code>true</code> if this Count should show up in report.
	 *            Set it to <code>false</code> if this Count should not be
	 *            shown in report.
	 * @param showInTrace
	 *            boolean : Flag for showing this Count in trace files. Set it
	 *            to <code>true</code> if this Count should show up in trace.
	 *            Set it to <code>false</code> if this Count should not be
	 *            shown in trace.
	 * @param isResetResistant
	 *            boolean : Flag for retaining the counter value during resets.
	 *            Set it to <code>true</code> if this Count should retain its
	 *            current value and only reset min, max and observations to 0.
	 *            Set it to <code>false</code> if this Count should also reset
	 *            its value to 0.
	 */
	public Count(Model ownerModel, String name, boolean showInReport,
			boolean showInTrace, boolean isResetResistant) {
		super(ownerModel, name, showInReport, showInTrace);

		this.min = this.max = 0; // no minimum or maximum so far

		this.value = 0; // nothing counted so far
		this.isResetResistant = isResetResistant; // set resistance flag
	}

	/**
	 * Converts a <code>double</code> value to a <code>long</code> value. If
	 * this can not be done without rounding a warning will be produced.
	 * 
	 * @param dbleValue
	 *            double : The double value which will be converted to a long
	 *            value.
	 * @return long : The long value the given double is converted to.
	 */
	protected long convertDoubleToLong(double dbleValue) {
		long lng = java.lang.Math.round(dbleValue); // rounded long value

		double rndDbleValue = lng;
		// rounded double value

		if ((rndDbleValue - dbleValue) != 0.0) {
			// the given double value must be rounded to produce a long
			sendWarning(
					"Attempt to convert a double value, which contains "
							+ "fractions, to a long value. The double value, rounded to a long "
							+ "value, will be returned!", "Count: " + getName()
							+ " Method: long convertDoubleToLong(double "
							+ "dbleValue) converts: " + dbleValue + " to: "
							+ lng,
					"You will lose accuracy when rounding a double value with fractions"
							+ " to a long value!",
					"Make sure to convert only double values with no fractions to long "
							+ "values.");
		}

		return lng; // return the rounded long value
	}

	/**
	 * Returns a Reporter to produce a report about this Count.
	 * 
	 * @return desmoj.report.Reporter : The Reporter for this Count.
	 */
	public desmoj.core.report.Reporter createReporter() {
		return new desmoj.core.report.CountReporter(this);
	}

	/**
	 * Returns the maximum value observed so far.
	 * 
	 * @return long : The maximum value observed so far.
	 */
	public long getMaximum() {
		return this.max;
	}

	/**
	 * Returns the minimum value observed so far.
	 * 
	 * @return long : The minimum value observed so far.
	 */
	public long getMinimum() {
		return this.min;
	}

	/**
	 * Resets this Count object by resetting (nearly) all variables to zero. If
	 * the flag <code>isResetResistant</code> is set to <code>true</code>
	 * the counter value will NOT be changed.
	 */
	public void reset() {
		super.reset(); // reset the Reportable, too.

		this.min = this.max = 0;

		// really reset the counter value?
		if (!this.isResetResistant)
			this.value = 0;
	}

	/**
	 * Increments the counter of this <code>Count</code> object by one.
	 */
	public void update() {
		update(1);
	}

	/**
	 * Increments the counter of this <code>Count</code> object by the value
	 * given in the parameter n.
	 * 
	 * @param n
	 *            long : The number that will be added to the counter of this
	 *            <code>Count</code> object.
	 */
	public void update(long n) {
		incrementObservations(1); // use the method from the Reportable class

		this.value += n; // update current value

		if (this.value < min) {
			min = this.value; // update min
		}

		if (this.value > max) {
			max = this.value; // update max
		}

		traceUpdate(); // leave a message in the trace
	}

	/**
	 * Implementation of the virtual <code>update(Observable, Object)</code>
	 * method of the <code>Observer</code> interface. This method will be
	 * called automatically from an <code>Observable</code> object within its
	 * <code>notifyObservers()</code> method. <br>
	 * If no Object (a<code>null</code> value) is passed as arg, the actual
	 * value of the ValueSupplier will be fetched with the <code>value()</code>
	 * method of the ValueSupplier. Otherwise it is expected that the actual
	 * value is passed in the Object arg.
	 * 
	 * @param o
	 *            java.util.Observable : The Observable calling this method
	 *            within its own <code>notifyObservers()</code> method.
	 * @param arg
	 *            Object : The Object with which this <code>Count</code> is
	 *            updated. Normally a long number which is added to the counter
	 *            or <code>null</code>.
	 */
	public void update(Observable o, Object arg) {
		if (o == null) // null was passed instead of an Observable
		{
			sendWarning(
					"Attempt to update a Count with no reference to an "
							+ "Observable. The attempted action will be ignored!",
					"Count: " + this.getName()
							+ " Method: update (Observable o, " + "Object arg)",
					"The passed Observable: o in this method is only a null pointer.",
					"The update()-method was not called via notifyObservers() from an "
							+ "Observable. Who was calling it? Why don't you let the Observable do"
							+ " the work?");

			return; // do nothing, just return
		}

		if (arg == null) // update was called with no arg Object
		{
			// get the actual value from the ValueSupplier (= Observable)
			double actualValue = ((ValueSupplier) o).value();

			long n = convertDoubleToLong(actualValue);

			update(n);
		} else {
			if (arg instanceof Number) {
				// get the value out of the Object arg
				double val = convertToDouble(arg);

				long n = convertDoubleToLong(val);

				update(n);

			} else {
				sendWarning(
						"Attempt to update a Count with an object, that can "
								+ "not be recognized. The attempted action will be ignored!",
						"Count: " + this.getName()
								+ " Method: update (Observable o, "
								+ "Object arg)",
						"The passed Object: arg in this method is not a Number.",
						"Make sure to pass as Object: arg in the update()-method only "
								+ "objects of the class: java.lang.Number or null!");

				return; // do nothing, just return
			}
		}

	}

	/**
	 * Returns the current counter value.
	 * 
	 * @return long : the current counter value.
	 */
	public long getValue() {
		return this.value;
	}
} // end class
