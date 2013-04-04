package desmoj.core.dist;

import desmoj.core.simulator.Model;

/**
 * Integer constant "pseudo"-distribution returns a single constant predefined
 * long value. This "distribution" is most useful for testing purposes. The
 * value to be returned can be specified at construction time.
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
public class IntDistConstant extends IntDist {

	/**
	 * Stores the status for the constant value to be returnde from this
	 * "pseudo"-distribution
	 */
	protected long constValue;

	/**
	 * Creates a constant integer "pseudo" distribution with the constant values
	 * given as parameter.
	 * 
	 * @param owner
	 *            Model : The distribution's owner
	 * @param name
	 *            java.lang.String : The distribution's name
	 * @param constantValue
	 *            long : The constant <code>long</code> value produced by this
	 *            distribution
	 * @param showInReport
	 *            boolean : Flag for producing reports
	 * @param showInTrace
	 *            boolean : Flag for producing trace output
	 */
	public IntDistConstant(Model owner, String name, long constantValue,
			boolean showInReport, boolean showInTrace) {
		super(owner, name, showInReport, showInTrace);
		constValue = constantValue;
	}

	/**
	 * Creates the default reporter for the IntDistConstant distribution.
	 * 
	 * @return Reporter : The reporter for the IntDistConstant distribution
	 * @see desmoj.core.report.IntDistConstantReporter
	 */
	public desmoj.core.report.Reporter createReporter() {

		return new desmoj.core.report.IntDistConstantReporter(this);

	}

	/**
	 * Returns the constant integer value associated with this IntDistConstant
	 * distribution
	 * 
	 * @return long : The constant boolean value returned by this
	 *         IntDistConstant distribution
	 */
	public long getConstantValue() {

		return constValue;

	}

	/**
	 * Returns the next constant sample of this distribution. For this
	 * "pseudo"-distribution it is always is the default value specified through
	 * the constructor or via the <em>setConstant</em> method.
	 * 
	 * @return long : The constant sample
	 */
	public long sample() {

		incrementObservations(); // increase count of samples by one

		// if (nonNegative) {
		// if (constValue < 0) return -constValue;
		// }
		
		if (this.currentlySendTraceNotes()) this.traceLastSample(Long.toString(constValue));

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
					"You set a nonNegative IntDistConstant distribution to a "
							+ "new negative constant.",
					"IntDistConstant: " + this.getName()
							+ " Method: public void "
							+ "setConstant(long newValue)",
					"The given constant is negative. But the IntDistConstant distribution "
							+ "is set to nonNegative. That does not make sense.",
					"Make sure not to set a nonNegative IntDistConstant distribution "
							+ "to a negative constant.");
		}
		constValue = newValue; // sets constant return-value to new one given

	}

	/**
	 * Overrides the same method of <code>desmoj.dist.Distribution</code>. It
	 * makes no sense to set a <code>IntDistConstant</code> object with a
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
					"Attempt to set a IntDistConstant distribution with a "
							+ "negative constant to nonNegative. This does not make sense!"
							+ "The negative constant will still be returned!",
					"IntDistConstant: " + this.getName()
							+ " Method: public void "
							+ "setNonNegative(boolean newValue)",
					"The given distribution has a negative constant but all negative "
							+ "values should be ignored. The negative constant will be returned "
							+ "anyway!",
					"Make sure not to set a IntDistConstant distribution with a negative "
							+ "constant to nonNegative.");
		}

		this.nonNegative = newValue;
	}
}