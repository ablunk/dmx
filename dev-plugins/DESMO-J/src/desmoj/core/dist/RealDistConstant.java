package desmoj.core.dist;

import desmoj.core.report.RealDistConstantReporter;
import desmoj.core.simulator.Model;

/**
 * Real number constant "pseudo"-distribution returns a single constant
 * predefined double value. This "distribution" is most useful for testing
 * purposes. The value to be returned can be specified at construction time.
 * 
 * @see desmoj.core.dist.Distribution
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
public class RealDistConstant extends RealDist {

	/**
	 * Stores the status for the constant value to be returnde from this
	 * "pseudo"-distribution
	 */
	protected double constValue;

	/**
	 * Constructs a simple poisson distributed pseudo random generator with the
	 * given value as mean of the distribution. Only positive values are
	 * allowed.
	 * 
	 * @param owner
	 *            Model : The distribution's owner
	 * @param name
	 *            java.lang.String : The distribution's name
	 * @param constantValue
	 *            double : The constant <code>double</code> value produced by
	 *            this distribution
	 * @param showInReport
	 *            boolean : Flag for producing reports
	 * @param showInTrace
	 *            boolean : Flag for producing trace output
	 */
	public RealDistConstant(Model owner, String name, double constantValue,
			boolean showInReport, boolean showInTrace) {
		super(owner, name, showInReport, showInTrace);
		constValue = constantValue;
	}

	/**
	 * Creates the default reporter for the RealDistConstant distribution.
	 * 
	 * @return Reporter : The reporter for the RealDistConstant distribution
	 * @see RealDistConstantReporter
	 */
	public desmoj.core.report.Reporter createReporter() {

		return new desmoj.core.report.RealDistConstantReporter(this);

	}

	/**
	 * Returns the constant floating point value associated with this
	 * RealDistConstant distribution
	 * 
	 * @return double : The constant boolean value returned by this
	 *         RealDistConstant distribution
	 */
	public double getConstantValue() {

		return constValue;

	}

	/**
	 * Returns the next floating point constant sample from this distribution.
	 * For this "pseudo"-distribution it is always is the default value
	 * specified through the constructor or via the <em>setConstant</em>
	 * method.
	 * 
	 * @return double : The next constant sample
	 */
	public double sample() {

		incrementObservations(); // increase count of samples by one

		// if (nonNegative) {
		// if (constValue < 0) return -constValue;
		// }
		
        if (this.currentlySendTraceNotes()) this.traceLastSample(Double.toString(constValue));


		return constValue; // always return same constant value

	}

	/**
	 * Changes the constant value to the new one specified.
	 * 
	 * @param newValue
	 *            long : the new value to be returned by this pseudo
	 *            distribution
	 */
	public void setConstant(long newValue) {

		// added by Soenke
		if (nonNegative && newValue < 0) {
			sendWarning(
					"You set a nonNegative RealDistConstant distribution to a "
							+ "new negative constant.",
					"RealDistConstant: " + this.getName()
							+ " Method: public void "
							+ "setConstant(long newValue)",
					"The given constant is negative. But the RealDistConstant distribution "
							+ "is set to nonNegative. That does not make sense.",
					"Make sure not to set a nonNegative RealDistConstant distribution "
							+ "to a negative constant.");
		}
		constValue = newValue; // sets constant return-value to new one given

	}

	/**
	 * Overrides the same method of <code>desmoj.dist.Distribution</code>. It
	 * makes no sense to set a <code>RealDistConstant</code> object with a
	 * negative constant to nonNegative. In this case a warning will be sent.
	 * <br>
	 * Sets the nonNegative switch to the given value. If nonNegative is set to
	 * <code>true</code> the distribution returns positive samples only,
	 * otherwise it also produces negative samples, if possible.
	 * 
	 * @param newValue
	 *            boolean : If <code>true</code> the distribution is set to
	 *            return positive samples only, otherwise it also produces
	 *            negative samples, if possible. added by Soenke
	 */
	public void setNonNegative(boolean newValue) {
		if (newValue == true && constValue < 0) {
			sendWarning(
					"Attempt to set a RealDistConstant distribution with a "
							+ "negative constant to nonNegative. This does not make sense!"
							+ "The negative constant will still be returned!",
					"RealDistConstant: " + this.getName()
							+ " Method: public void "
							+ "setNonNegative(boolean newValue)",
					"The given distribution has a negative constant but all negative "
							+ "values should be ignored. The negative constant will be returned "
							+ "anyway!",
					"Make sure not to set a RealDistConstant distribution with a negative "
							+ "constant to nonNegative.");
		}

		this.nonNegative = newValue;
	}
}