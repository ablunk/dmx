package desmoj.core.statistic;

import java.util.Observable;

import desmoj.core.simulator.Model;

/**
 * The <code>Histogram</code> class is providing a statistic analysis about
 * one value. An interval is devided into equidistant sections with an under-
 * and an overflow section. When a value is updated it will be decided to which
 * section it belongs to and the counter for that section will be updated. In
 * the end the report will show how many values belong to which section.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Soenke Claassen
 * @author based on DESMO-C from Thomas Schniewind, 1998
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

public class Histogram extends desmoj.core.statistic.Tally {

	// ****** attributes ******

	/**
	 * The lower limit of the interval
	 */
	private double lowerLimit;

	/**
	 * The upper limit of the interval
	 */
	private double upperLimit;

	/**
	 * The width of one section of the interval
	 */
	private double width;

	/**
	 * The number of cells the interval will be devided into
	 */
	private int cells;

	/**
	 * The array representing the sections of the interval
	 */
	private long[] table;

	// ****** methods ******

	/**
	 * Constructor for a Histogram object that will NOT be connected to a
	 * <code>ValueSupplier</code>.
	 * 
	 * @param ownerModel
	 *            Model : The model this Histogram is associated to
	 * @param name
	 *            java.lang.String : The name of this Histogram object
	 * @param lowerEnd
	 *            double : The lower end of the interval.
	 * @param upperEnd
	 *            double : The upper end of the interval.
	 * @param cells
	 *            int : The number of cells (sections) the given interval will
	 *            be devided into.
	 * @param showInReport
	 *            boolean : Flag for showing the report about this Histogram.
	 * @param showInTrace
	 *            boolean : Flag for showing the trace output of this Histogram.
	 */
	public Histogram(Model ownerModel, String name, double lowerEnd,
			double upperEnd, int cells, boolean showInReport,
			boolean showInTrace) {
		// call the constructor of Tally
		super(ownerModel, name, showInReport, showInTrace);

		this.lowerLimit = lowerEnd;
		this.upperLimit = upperEnd;
		this.cells = cells;

		checkParam(); // check the given parameters

		// set the rounded width of each cell
		this.width = java.lang.Math.rint(PRECISION * (upperLimit - lowerLimit)
				/ cells)
				/ PRECISION;

		// make a new table
		this.table = new long[cells + 2];

		// initialize the table with zero for each cell
		initTable();
	}

	/**
	 * Constructor for a Histogram object that will be connected to a
	 * <code>ValueSupplier</code>.
	 * 
	 * @param ownerModel
	 *            Model : The model this Histogram is associated to
	 * @param name
	 *            java.lang.String : The name of this Histogram object
	 * @param valsup
	 *            ValueSupplier : The ValueSupplier providing the value for this
	 *            Histogram. The given ValueSupplier will be observed by this
	 *            Histogram object.
	 * @param lowerEnd
	 *            double : The lower end of the interval.
	 * @param upperEnd
	 *            double : The upper end of the interval.
	 * @param cells
	 *            int : The number of cells (sections) the given interval will
	 *            be devided into.
	 * @param showInReport
	 *            boolean : Flag for showing the report about this Histogram.
	 * @param showInTrace
	 *            boolean : Flag for showing the trace output of this Histogram.
	 */
	public Histogram(Model ownerModel, String name, ValueSupplier valSup,
			double lowerEnd, double upperEnd, int cells, boolean showInReport,
			boolean showInTrace) {
		// call the constructor of Tally
		super(ownerModel, name, valSup, showInReport, showInTrace);

		// valsup is no valid ValueSupplier
		if (valSup == null) {
			sendWarning(
					"Attempt to produce a Histogram about a non existing "
							+ "ValueSupplier. The command will be ignored!",
					"Histogram: "
							+ this.getName()
							+ " Constructor: Histogram"
							+ " (Model ownerModel, String name, ValueSupplier valSup, "
							+ "double lowerEnd, double upperEnd, int cells, "
							+ "boolean showInReport, boolean showInTrace)",
					"The given ValueSupplier: valSup is only a null pointer.",
					"Make sure to pass a valid ValueSupplier when constructing a new "
							+ "Histogram object.");

			return; // just return
		}

		this.lowerLimit = lowerEnd;
		this.upperLimit = upperEnd;
		this.cells = cells;

		checkParam(); // check the given parameters

		// set the rounded width of each cell
		this.width = java.lang.Math.rint(PRECISION * (upperLimit - lowerLimit)
				/ cells)
				/ PRECISION;

		// make a new table
		this.table = new long[cells + 2];

		// initialize the table with zero for each cell
		initTable();

	}

	/**
	 * Changes the parameters of the interval and its' number of segments. Can
	 * only be done after construction of a Histogram or after a reset.
	 * 
	 * @param low
	 *            double : The lower end of the interval.
	 * @param up
	 *            double : The upper end of the interval.
	 * @param cel
	 *            int : The number of cells (sections) the given interval will
	 *            be devided into.
	 */
	public void changeParameters(double low, double up, int cel) {
		if (getObservations() > 0) // Histogram has been used already
		{
			sendWarning("Attempt to change the parameters of a Histogram, but "
					+ "it has been used already. The command will be ignored!",
					"Histogram: " + this.getName()
							+ " Method: changeParameters( double "
							+ "low, double up, int cel )",
					"The parameters of a Histogram can not be changed when the Histogram "
							+ "has been used already.",
					"Make sure to reset the Histogram right before changing its "
							+ "parameters.");

			return; // do nothing, just return
		}

		// get hold of the number of cells before changing the parameters
		int oldCells = cells;

		this.lowerLimit = low;
		this.upperLimit = up;
		this.cells = cel;

		checkParam(); // check the given parameters

		// set the rounded width of each cell
		this.width = java.lang.Math.rint(PRECISION * (upperLimit - lowerLimit)
				/ cells)
				/ PRECISION;

		if (cells != oldCells) // number of cells has changed?
		{
			// make a new table
			this.table = new long[cells + 2];
		}

		// initialize the table with zero for each cell
		initTable();
	}

	/**
	 * Checks the parameters of the given interval and its' segmentation.
	 */
	protected void checkParam() {
		if (cells <= 0) // the interval will not be devided into segments
		{
			sendWarning(
					"Attempt to produce a Histogram about an interval, "
							+ "which is not devided into segments. The number of segments will be "
							+ "set to one!",
					"Histogram: "
							+ this.getName()
							+ " Constructor: Histogram"
							+ " (Model ownerModel, String name, ... int cells, ...) "
							+ "or Method: changeParameters( ..., int cel ).",
					"The given number of cells is zero or negative.",
					"Make sure to pass a valid number of cells when constructing a new "
							+ "Histogram object or changing its parameters.");

			this.cells = 1;
		}

		if (lowerLimit > upperLimit) // lowerLimit is greater than upperLimit
		{
			sendWarning(
					"Attempt to produce a Histogram about an interval, "
							+ "which lower end is greater than its upper end. The lower and "
							+ "upper end are exchanged!",
					"Histogram: "
							+ this.getName()
							+ " Constructor: Histogram"
							+ " (Model ownerModel, ... double lowerEnd, double upperEnd, ...) "
							+ "or Method: changeParameters( double low, double up, int cel ).",
					"The given lower end is greater than the upper end of the interval.",
					"Make sure that the lower limit of the interval is smaller than the "
							+ "upper limit when constructing a new Histogram object or changing "
							+ "its parameters.");

			double temp = lowerLimit;
			lowerLimit = upperLimit;
			upperLimit = temp;
		} else {
			// there is no segmentation (all is one segment)
			if (lowerLimit == upperLimit && cells != 1) {
				sendWarning(
						"Attempt to produce a Histogram about an interval, "
								+ "which lower and upper limit are the same. The number of cells is "
								+ "set to one!",
						"Histogram: "
								+ this.getName()
								+ " Constructor: Histogram"
								+ " (Model ownerModel, ... double lowerEnd, double upperEnd, ...) "
								+ "or Method: changeParameters( double low, double up, int cel ).",
						"The given lower and upper end of the interval are the same, but "
								+ "the interval is devided into more than one segment.",
						"Make sure that in case the lower and upper limit of the interval "
								+ "are the same the number of cells is one.");

				this.cells = 1;

			} // end inner if
		} // end else

	}

	/**
	 * Returns a Reporter to produce a report about this Histogram.
	 * 
	 * @return desmoj.report.Reporter : The Reporter for this Histogram.
	 */
	public desmoj.core.report.Reporter createReporter() {
		return new desmoj.core.report.HistogramReporter(this);
	}

	/**
	 * Returns the number of cells the interval is devided into.
	 * 
	 * @return int : The number of cells the interval is devided into.
	 */
	public int getCells() {
		return this.cells;
	}

	/**
	 * Returns the width of one cell.
	 * 
	 * @return double : The width of one cell.
	 */
	public double getCellWidth() {
		return this.width;
	}

	/**
	 * Returns the lower limit of the given cell. If the given cell is negative,
	 * <code>UNDEFINED</code> (-1) will be returned.
	 * 
	 * @return double : The lower limit of the given cell.
	 * @param cell
	 *            int : The cell for which we want to know its lower limit.
	 *            Should be zero or positive.
	 */
	public double getLowerLimit(int cell) {
		if (cell < 0 || cell > cells + 1) {
			sendWarning("Attempt to get a lower limit of a not known cell. "
					+ "UNDEFINED (-1) will be returned!", "Histogram: "
					+ this.getName() + " Method: getLowerLimit( int cell ).",
					"The passed int: cell in this method is negative or greater than "
							+ "the largest cell number.",
					"Make sure to ask the lower limit only for valid cell numbers.");

			return UNDEFINED; // return UNDEFINED (-1)
		}

		if (cell == 0) {
			return Double.NEGATIVE_INFINITY;
		} else {
			return java.lang.Math.rint(100000 * (lowerLimit + (cell - 1)
					* width)) / 100000;
		}
	}

	/**
	 * Returns the number of the most frequented cell, so far.
	 * 
	 * @return int : The number of the most frequented cell.
	 */
	public int getMostFrequentedCell() {
		long max = 0; // highest frequency

		int cellNo = 0; // the number of the most frequented cell

		for (int i = 0; i < cells + 2; i++) // go through all cells
		{
			if (max < table[i]) // new maximum frequency found?
			{
				max = table[i]; // set the new highest frequency

				cellNo = i; // save the number of the cell
			}
		}

		return cellNo;
	}

	/**
	 * Returns the observations made for the given cell, so far.
	 * 
	 * @return long : The observations made for the given cell.
	 * @param cell
	 *            int : The cell of which want to get the number of observations
	 *            made for.
	 */
	public long getObservationsInCell(int cell) {
		if (cell < 0 || cell > cells + 1) {
			sendWarning("Attempt to get the number of observations from a not "
					+ "known cell. Zero (0) will be returned!", "Histogram: "
					+ this.getName() + " Method: getObservationsInCell"
					+ "( int cell ).",
					"The passed int: cell in this method is negative or greater than "
							+ "the largest cell number.",
					"Make sure to ask for the number of observations only for valid "
							+ "cell numbers.");

			return 0; // return zero (0)
		}

		return table[cell];
	}

	/**
	 * Returns the upper limit of the whole intervall.
	 * 
	 * @return double : The upper limit of the whole intervall.
	 */
	public double getUpperLimit() {
		return this.upperLimit;
	}

	/**
	 * Initializes the table by setting each cell counter to zero.
	 */
	protected void initTable() {
		// set each cell of the table to zero
		for (int i = 0; i < cells + 2; i++) {
			table[i] = 0;
		}
	}

	/**
	 * Resets this Histogram object by resetting the counters for each cell to
	 * zero. That means the array of the cell counters will be reset, but the
	 * interval and the number of sections this interval is devided into will
	 * remain the same. The parameters of the interval can be changed with the
	 * <code>changeParameters</code> method after the reset.
	 */
	public void reset() {
		super.reset(); // reset the Tally, too.

		// reset the array of cells #### only if the table already exists! Ruth 24/01/2008
		if (table != null){
			initTable();
		}
	}

	/**
	 * Updates this <code>Histogram</code> object by fetching the actual value
	 * of the <code>ValueSupplier</code> and processing it. The
	 * <code>ValueSupplier</code> is passed in the constructor of this
	 * <code>Histogram</code> object. This <code>update()</code> method
	 * complies with the one described in DESMO, see [Page91].
	 */
	public void update() {
		super.update(); // update Tally

		// how much is the value above the lowerLimit?
		double val = getLastValue() - lowerLimit;

		int n = 0; // to which cell does the value belong to?

		if (lowerLimit == upperLimit) // no real limit given, all in one
		// segment
		{
			if (val < 0.0) // underflow
			{
				n = 0;
			} else {
				if (val > 0.0) // overflow
				{
					n = 2;
				} else // val == lowerLimit == upperLimit
				{
					n = 1;
				}
			}
		} else // lowerLimit < upperLimit
		{
			if (val < 0.0) // underflow
			{
				n = 0;
			} else {
				Double d = new Double(val / width + 1);

				n = d.intValue(); // rounded down
			}
		}

		if (n > cells + 1) // overflow?
		{
			table[cells + 1]++;
		} else // normal range cell
		{
			table[n]++;
		}
	}

	/**
	 * Updates this <code>Histogram</code> object with the double value given
	 * as parameter. In some cases it might be more convenient to pass the value
	 * this <code>Histogram</code> will be updated with directly within the
	 * <code>update(double val)</code> method instead of going via the
	 * <code>ValueSupplier</code>.
	 * 
	 * @param val
	 *            double : The value with which this <code>Histogram</code>
	 *            will be updated.
	 */
	public void update(double val) {
		super.update(val); // update Tally

		// how much is the value above the lowerLimit?
		double diff = getLastValue() - lowerLimit;

		int n = 0; // to which cell does the value belong to?

		if (lowerLimit == upperLimit) // no real limit given, all in one
		// segment
		{
			if (diff < 0.0) // underflow
			{
				n = 0;
			} else {
				if (diff > 0.0) // overflow
				{
					n = 2;
				} else // diff == lowerLimit == upperLimit
				{
					n = 1;
				}
			}
		} else // lowerLimit < upperLimit
		{
			if (diff < 0.0) // underflow
			{
				n = 0;
			} else {
				Double d = new Double(diff / width + 1);

				n = d.intValue(); // rounded down
			}
		}

		if (n > cells + 1) // overflow?
		{
			table[cells + 1]++;
		} else // normal range cell
		{
			table[n]++;
		}
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
	 *            Object : The Object with which this <code>Tally</code> is
	 *            updated. Normally a double number which is added to the
	 *            statistics or <code>null</code>.
	 */
	public void update(Observable o, Object arg) {
		if (o == null) // null was passed instead of an Observable
		{
			sendWarning(
					"Attempt to update a Histogram with no reference to an "
							+ "Observable. The actual value of '"
							+ getValueSupplier().getName()
							+ "' will be fetched and processed anyway.",
					"Histogram: " + this.getName()
							+ " Method: update (Observable " + "o, Object arg)",
					"The passed Observable: o in this method is only a null pointer.",
					"The update()-method was not called via notifyObservers() from an "
							+ "Observable. Who was calling it? Why don't you let the Observable do"
							+ " the work?");
		}

		super.update(o, arg); // update Tally

		// how much is the value above the lowerLimit?
		double val = getLastValue() - lowerLimit;

		int n = 0; // to which cell does the value belong to?

		if (lowerLimit == upperLimit) // no real limit given, all in one
		// segment
		{
			if (val < 0.0) // underflow
			{
				n = 0;
			} else {
				if (val > 0.0) // overflow
				{
					n = 2;
				} else // val == lowerLimit == upperLimit
				{
					n = 1;
				}
			}
		} else // lowerLimit < upperLimit
		{
			if (val < 0.0) // underflow
			{
				n = 0;
			} else {
				Double d = new Double(val / width + 1);

				n = d.intValue(); // rounded down
			}
		}

		if (n > cells + 1) // overflow?
		{
			table[cells + 1]++;
		} else // normal range cell
		{
			table[n]++;
		}
	}
} // end class Histogram
