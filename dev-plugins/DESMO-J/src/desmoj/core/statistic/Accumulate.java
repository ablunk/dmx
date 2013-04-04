package desmoj.core.statistic;

import java.util.Observable;

import desmoj.core.simulator.Model;
import desmoj.core.simulator.TimeInstant;
import desmoj.core.simulator.TimeOperations;
import desmoj.core.simulator.TimeSpan;

/**
 * The <code>Accumulate</code> class is providing a statistic analysis about
 * one value. The mean value and the standard deviation is weighted over time.
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

public class Accumulate extends desmoj.core.statistic.ValueStatistics {

    // ****** attributes ******

    /**
     * The sum of all values, multiplied with the time of their persistence
     */
    private double sumTotal;

    /**
     * The sum of all squared values, multiplied with the time of their
     * persistence.
     */
    private double sumSquareTotal;
    
    /**
     * This flag indicates if the accumulate's last value is
     * retained on reset (true) or nullified (false)
     */
    private boolean retainLastValueOnReset;

    /**
     * The point of time this Accumulate was updated at last
     */
    private TimeInstant lastTime;

    /**
     * Constructor for a Accumulate object that will be connected to a
     * <code>ValueSupplier</code>.
     * 
     * @param ownerModel
     *            Model : The model this Accumulate is associated to
     * @param name
     *            java.lang.String : The name of this Accumulate object
     * @param valSup
     *            ValueSupplier : The ValueSupplier providing the value for this
     *            Accumulate. The given ValueSupplier will be observed by this
     *            <code>Accumulate</code> object, if it is not observed
     *            automatically at every tick of the SimClock.
     * @param automatic
     *            boolean : Flag for observing the ValueSupplier at every tick
     *            of the SimClock. Set it to <code>true</code> to have it
     *            observed at every SimClock tick.
     * @param showInReport
     *            boolean : Flag for showing the report about this Accumulate.
     * @param showInTrace
     *            boolean : Flag for showing the trace output of this
     *            Accumulate.
     */
    public Accumulate(Model ownerModel, String name, ValueSupplier valSup,
            boolean automatic, boolean showInReport, boolean showInTrace) {
        // call the constructor of ValueStatistics
        super(ownerModel, name, valSup, showInReport, showInTrace);
        
        this.retainLastValueOnReset = true;

        // valSup is no valid ValueSupplier
        if (valSup == null) {
            sendWarning(
                    "Attempt to produce a Accumulate about a non existing "
                            + "ValueSupplier. The command will be ignored!",
                    "Accumulate: "
                            + this.getName()
                            + " Constructor: Accumulate"
                            + " (Model ownerModel, String name, ValueSupplier valSup, "
                            + "boolean showInReport, boolean showInTrace)",
                    "The given ValueSupplier: valSup is only a null pointer.",
                    "Make sure to pass a valid ValueSupplier when constructing a new "
                            + "Accumulate object.");

            return; // just return
        }

        if (automatic) // update at every tick of the SimClock?
        {
            // cancel the observation of the ValueSupplier
            getValueSupplier().deleteObserver(this);

            Observable simClock = this.getModel().getExperiment().getSimClock();

            simClock.addObserver(this); // observe the SimClock
        }
    }

    // ****** methods ******

    /**
     * Constructor for a Accumulate object that will not be connected to a
     * <code>ValueSupplier</code> automatically.
     * 
     * @param ownerModel
     *            Model : The model this Accumulate is associated to
     * @param name
     *            java.lang.String : The name of this Accumulate object.
     * @param showInReport
     *            boolean : Flag for showing the report about this Accumulate.
     * @param showInTrace
     *            boolean : Flag for showing the trace output of this
     *            Accumulate.
     */
    public Accumulate(Model ownerModel, String name, boolean showInReport,
            boolean showInTrace) {
        // call the constructor of ValueStatistics without a connection to a
        // ValueSupplier
        super(ownerModel, name, showInReport, showInTrace);
        
        this.retainLastValueOnReset = true;
    }

    /**
     * Returns a Reporter to produce a report about this Accumulate.
     * 
     * @return desmoj.report.Reporter : The Reporter for this Accumulate.
     */
    public desmoj.core.report.Reporter createReporter() {
        return new desmoj.core.report.AccumulateReporter(this);
    }

    /**
     * Returns the mean value of all the values observed so far, weighted over
     * time.
     * 
     * @return double : The mean value of all the values observed so far,
     *         weighted over time.
     */
    public double getMean() {
        TimeInstant now = presentTime(); // what's the time?

        // how long since the last reset?
        TimeSpan totalTimeDiff = TimeOperations.diff(now, resetAt());
        // has no time passed?
        if (TimeSpan.isEqual(totalTimeDiff, TimeSpan.ZERO)
                || getObservations() == 0) // OR no observations are made
        {
            sendWarning(
                    "Attempt to get a mean value, but there is not "
                            + "sufficient data yet. UNDEFINED (-1.0) will be returned!",
                    "Accumulate: " + this.getName()
                            + " Method: double getMean()",
                    "You can not calculate a mean value as long as no data is collected.",
                    "Make sure to ask for the mean value only after some data has been "
                            + "collected already.");

            return UNDEFINED; // return UNDEFINED = -1.0
        }

        // calculate the mean value weighted over time
        double meanValue = (sumTotal + getLastValue()
                * (TimeOperations.diff(now, lastTime)).getTimeInEpsilon())
                / totalTimeDiff.getTimeInEpsilon();
        // return the rounded mean value
        return java.lang.Math.rint(PRECISION * meanValue) / PRECISION;
    }

    /**
     * Returns the standard deviation of all the values observed so far,
     * weighted over time.
     * 
     * @return double : The standard deviation of all the values observed so
     *         far, weighted over time.
     */
    public double getStdDev() {
        TimeInstant now = presentTime(); // what's the time?

        // how long since the last update?
        TimeSpan timeDiff = TimeOperations.diff(now, lastTime);

        // how long since the last reset?
        TimeSpan totalTimeDiff = TimeOperations.diff(now, resetAt());

        // is totalTimeDiff less than the minimum distinguishable span of
        // time?
        if (TimeSpan.isEqual(totalTimeDiff, TimeSpan.ZERO)
                || getObservations() < 2) // OR not enough observations are
        // made
        {
            sendWarning(
                    "Attempt to get a standard deviation value, but there is "
                            + "not sufficient data yet. UNDEFINED (-1.0) will be returned!",
                    "Accumulate: " + this.getName()
                            + " Method: double getStdDev()",
                    "You can not calculate a standard deviation as long as no data is "
                            + "collected.",
                    "Make sure to ask for the standard deviation only after some data "
                            + "has been collected already.");

            return UNDEFINED; // return UNDEFINED = -1.0
        }

        double actVal = getLastValue(); // get the actual value

        double mean = getMean(); // get the mean value

        // calculate the standard deviation
        double stdDev = Math.sqrt(Math.abs((sumSquareTotal + actVal * actVal
                * timeDiff.getTimeInEpsilon())
                / totalTimeDiff.getTimeInEpsilon() - mean * mean));
        // return the rounded standard deviation
        return java.lang.Math.rint(PRECISION * stdDev) / PRECISION;
    }

    /**
     * Resets this Accumulate object by resetting all variables to 0.0.
     * If the flag retainLastValueOnReset is set to true, the last value
     * is not nullified but remains unchanged. 
     */
    public void reset() {
        double lastValue = this.getLastValue();
        boolean observationsPriorToRest = (getObservations() > 0); 
        
        super.reset(); // reset the ValueStatistics, too.
        
        this.sumTotal = this.sumSquareTotal = 0.0;

        lastTime = presentTime();
        
        if (doesRetainLastValueOnReset() && observationsPriorToRest) {
            this.update(lastValue);
        }
    }
    
    /**
     * This method determines whether if the accumulate's last value is
     * retained on reset (true) or nullified (false). The 
     * default value is true.
     * @return value of the retainLastValueOnReset flag
     */
    public boolean doesRetainLastValueOnReset() {
        return retainLastValueOnReset;
    }
    
    /**
     * Sets the value of the retainLastValueOnResetFlag.
     * @param retainValue new value of the flag.
     */
    public void setRetainLastValueOnReset(boolean retainValue) {
        this.retainLastValueOnReset = retainValue;
    }

    /**
     * Updates this <code>Accumulate</code> object by fetching the actual
     * value of the <code>ValueSupplier</code> and processing it. The
     * <code>ValueSupplier</code> can be passed in the constructor of this
     * <code>Accumulate</code> object. This <code>update()</code> method
     * complies with the one described in DESMO, see [Page91].
     */
    public void update() {
        // check if the experiment is already running
        if (!getModel().getExperiment().isRunning()) {
            return; // experiment is not running, don't update, just return
        }

        TimeInstant now = presentTime(); // what's the time?

        // how long since the last update or reset?
        TimeSpan timeDiff = TimeOperations.diff(now, lastTime);

        // get hold of the value that was valid until now
        double untilNowVal = getLastValue();

        super.update(); // call the update() method of ValueStatistics

        sumTotal += untilNowVal * timeDiff.getTimeInEpsilon();
        sumSquareTotal += untilNowVal * untilNowVal * timeDiff.getTimeInEpsilon();

        lastTime = now; // update the time of the last change
    }

    /**
     * Updates this <code>Accumulate</code> object with the double value given
     * as parameter. In some cases it might be more convenient to pass the value
     * this <code>Accumulate</code> will be updated with directly within the
     * <code>update(double val)</code> method instead of going via the
     * <code>ValueSupplier</code>.
     * 
     * @param val
     *            double : The value with which this <code>Accumulate</code>
     *            will be updated.
     */
    public void update(double val) {
        // check if the experiment is already running
        if (!getModel().getExperiment().isRunning()) {
            return; // experiment is not running, don't update, just return
        }

        TimeInstant now = presentTime(); // what's the time?

        // how long since the last update or reset?
        TimeSpan timeDiff = TimeOperations.diff(now, lastTime);

        // get hold of the value that was valid until now
        double untilNowVal = getLastValue();

        // call the update(double val) method of ValueStatistics
        super.update(val);

        sumTotal += untilNowVal * timeDiff.getTimeInEpsilon();
        sumSquareTotal += untilNowVal * untilNowVal * timeDiff.getTimeInEpsilon();

        lastTime = now; // update the time of the last change
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
     *            Object : The Object with which this <code>Accumulate</code>
     *            is updated. Normally a Double value which is added to the
     *            statistics or <code>null</code>.
     */
    public void update(Observable o, Object arg) {
        if (o == null) // null was passed instead of an Observable
        {
            sendWarning(
                    "Attempt to update a Accumulate with no reference to an "
                            + "Observable. The actual value of '"
                            + getValueSupplier().getName()
                            + "' will be fetched and processed anyway.",
                    "Accumulate: " + this.getName()
                            + " Method: update (Observable o," + " Object arg)",
                    "The passed Observable: o in this method is only a null pointer.",
                    "The update()-method was not called via notifyObservers() from an "
                            + "Observable. Who was calling it? Why don't you let the Observable do"
                            + " the work?");
        }

        // check if the experiment is already running
        if (!getModel().getExperiment().isRunning()) {
            return; // experiment is not running, don't update, just return
        }

        TimeInstant now = presentTime(); // what's the time?

        // how long since the last update or reset?
        TimeSpan timeDiff = TimeOperations.diff(now, lastTime);

        // get hold of the value that was valid until now
        double untilNowVal = getLastValue();

        super.update(o, arg); // call the update() method of ValueStatistics

        sumTotal += untilNowVal * timeDiff.getTimeInEpsilon();
        sumSquareTotal += untilNowVal * untilNowVal * timeDiff.getTimeInEpsilon();

        lastTime = now; // update the time of the last change
    }
} // end class Accumulate

