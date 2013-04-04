package desmoj.core.dist;

import desmoj.core.report.IntDistEmpiricalReporter;
import desmoj.core.simulator.Model;

/**
 * Empirically distributed stream of pseudo random numbers of type
 * <code>long</code>. Values produced by this distribution follow an
 * empirical distribution which is specified by entries consisting of the
 * observed value and the frequency (probability) this value has been observed
 * to occur. These entries are made by using the <code>addEntry()</code>
 * method. There are a few conditions a user has to meet before actually being
 * allowed to take a sample of this distribution.
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
public class IntDistEmpirical extends IntDist {

	/**
	 * Vector to store the entries of Value/cumulative frequency pairs.
	 */
	private java.util.ArrayList<Entry> values;

	/**
	 * Shows if the empirical distribution has been properly initialized.
	 */
	private boolean isInitialized;

	/**
	 * Inner class for entries
	 */
	private static class Entry {

		/**
		 * The value of the empirical entry.
		 */
		private long entryValue;

		/**
		 * The cumulative frequency of the empirical entry.
		 */
		private double entryFrequency;

		/**
		 * Constructs a simple entry pair with the given value and cumulative
		 * frequency.
		 * 
		 * @param val
		 *            long : The value of the empirical sample
		 * @param freq
		 *            double : The cumulative frequency of the empirical sample
		 */
		private Entry(long val, double freq) {
			entryValue = val;
			entryFrequency = freq;
		}

	}

	/**
	 * Constructs an empirical distribution producing integer values. Empirical
	 * distributions have to be initialized manually before use. This is done by
	 * calling the <code>addEntry(long, double)</code> method to add values
	 * defining the behaviour of the desired distribution.s
	 * 
	 * @param owner
	 *            Model : The distribution's owner
	 * @param name
	 *            java.lang.String : The distribution's name
	 * @param showInReport
	 *            boolean : Flag for producing reports
	 * @param showInTrace
	 *            boolean : Flag for producing trace output
	 */
	public IntDistEmpirical(Model owner, String name, boolean showInReport,
			boolean showInTrace) {

		super(owner, name, showInReport, showInTrace);
		values = new java.util.ArrayList<Entry>(); // Initialize Vector for values
		isInitialized = false; // No entries made yet

	}

	/**
	 * Adds a new entry of an empirical value and its associated cumulative
	 * frequency. There are restrictions on what will be accepted as a valid
	 * entry. If entries do not apply to the following list of restrictions, a
	 * note will be issued to the user
	 * <ol>
	 * <li>The lowest Entry in value and frequency has to be added first.</li>
	 * <li>The last value inserted has to have a cumulative frequency of 1.0 to
	 * indicate the upper boundary.</li>
	 * <li>Values have to be added in ascending order of their values and
	 * cumulative frequency. Any values added with lower value/cumulative
	 * frequency than the value added before will result in a warning message
	 * and be ignored.</li>
	 * <li>There have to be at least two entries. Otherwise it would be
	 * impossible to interpolate a reasonable sample value.</li>
	 * <li>Once this distribution is "initialized", this method does not accept
	 * any additional values to be added.</li>
	 * <li>No two values may be equal, since there can not be two different
	 * frequencies for one observed value. Entries with same value/frequency
	 * pair as an entry already made before are simply ignored.</li>
	 * </ol>
	 * Only if all conditions described above apply and this distribution is
	 * "initialized", it is possible to obtain samples via the sample() method.
	 * 
	 * @param value
	 *            long : The empirical value observed
	 * @param cumulativeFrequency
	 *            double : The corresponding cumulative frequency of the
	 *            empirical value
	 */
	public void addEntry(long value, double frequency) {

		// must not already be initialized
		if (isInitialized) {
			sendWarning("Can't add empirical entry! Command ignored.",
					"IntDistEmpirical : " + getName()
							+ " Method: void addEntry (long value, double "
							+ "frequency)",
					"The RealDistEmpirical distribution is aready initialized "
							+ "and does not accept any more entries.",
					"Be sure to check if the distribution is initialized by "
							+ "calling the method isInitialized().");
			return; // no proper parameter
		}

		// frequency must be positive
		if ((frequency < 0) || (frequency > 1.0)) {
			sendWarning("Can't add empirical entry! Command ignored.",
					"IntDistEmpirical " + getName()
							+ " Method: void addEntry (long value, double "
							+ "frequency)",
					"The frequency parameter given is invalid becaus it is out "
							+ "of range : " + frequency,
					"Be sure to add entries with positive frequency in the "
							+ "range [0,1].");
			return; // no proper parameter
		}

		// frequency of 1.0 indicates last element and initialization of
		// distribution
		if (frequency == 1.0) {
			if (values.get(values.size()-1).entryValue < value) {
				values.add(new Entry(value, frequency));
				isInitialized = true; // set state to initialized
				return; // exit, no further changes can be made
			} else {
				sendWarning("Can't add empirical entry! Command ignored.",
						"IntDistEmpirical : " + getName()
								+ " Method: void addEntry (long value, double "
								+ "frequency)", "The value for the entry ("
								+ value + ") is lower than the "
								+ "previously given ("
								+ values.get(values.size()-1).entryValue
								+ ").",
						"Be sure to add values and frequencies in ascending order.");
				return; // no proper parameter
			}
		}

		// always check for invalid values/frequencies
		for (int i = 0; i < values.size(); i++) {
			if (values.get(i).entryValue >= value
					|| values.get(i).entryFrequency >= frequency) {
				sendWarning("Can't add empirical entry! Command ignored.",
						"IntDistEmpirical : " + getName()
								+ " Method: void addEntry (long value, double "
								+ "frequency)",
						"The frequency parameter given is invalid becaus it "
								+ "is zero although an"
								+ " entry with zero has already been made!",
						"Be sure to add an entriy with frequency zero only at "
								+ "the first time an entry is added.");
				return; // no proper parameter
			}
		}

		// everythings fine so far, so go ahead and add the new val/freq pair
		values.add(new Entry(value, frequency));

	}

	/**
	 * Creates the default reporter for the IntDistEmpirical distribution.
	 * 
	 * @return Reporter : The reporter for the IntDistEmpirical distribution
	 * @see IntDistEmpiricalReporter
	 */
	public desmoj.core.report.Reporter createReporter() {

		return new desmoj.core.report.IntDistEmpiricalReporter(this);

	}

	/**
	 * Shows if the IntDistEmpirical distribution already is initialized. Being
	 * initialized means that all values needed have already been added via the
	 * <code>addEntry(long, double)</code> method.
	 * 
	 * @return boolean
	 */
	public boolean isInitialized() {

		return isInitialized;

	}

	/**
	 * Returns the next sample specified by the empirical distribution. In
	 * contrast to RealDistEmpirical here is no interpolation needed.
	 * 
	 * @return double : The next sample for this empirical distribution or
	 *         returns zero (0) with a warning if the distribution has not been
	 *         properly initialized yet
	 */
	public long sample() {

		if (!isInitialized) {
			sendWarning(
					"Invalid sample returned!",
					"IntDistEmpirical : " + getName()
							+ " Method: double sample()",
					"The distribution has not been initialized properly yet, "
							+ "thus no valid samples can be taken from it!",
					"Be sure to have the distribution initialized properly "
							+ "before using it. You can make sure by calling method "
							+ "isInitialized() which returns a boolean telling "
							+ "you wether the distribution is initilaized or not.");
			return 0; // no proper parameter but return zero to prevent
			// aborting
			// the simulation
		}

		incrementObservations(); // increase count of samples

		int i = 0; // counting variable to loop values
		double q = randomGenerator.nextDouble(); // the random number to
		// derive the value from
		if (antithetic)
			q = 1 - q; // check for antithetic

		while (values.get(i).entryFrequency < q) {
			i++; // try next item
		}

		long newSample = values.get(i).entryValue;

		if (nonNegative && newSample < 0) {
			sendWarning(
					"You get a sample from a IntDistEmpirical distribution which "
							+ "is set to nonNegative. But the sample is negative!",
					"IntDistEmpirical: " + this.getName()
							+ " Method: public double sample() ",
					"The given distribution has negative values but all negative values "
							+ "should be ignored.",
					"Make sure not to set a IntDistEmpirical distribution with "
							+ "negative values to nonNegative.");
		}
		
		if (this.currentlySendTraceNotes()) this.traceLastSample(Long.toString(newSample));

		return newSample;

	}
}