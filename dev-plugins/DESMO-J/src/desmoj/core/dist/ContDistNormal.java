package desmoj.core.dist;

import desmoj.core.simulator.Model;

/**
 * Normally (also known as "Gaussian") distributed stream of pseudo random
 * numbers of type double. The algorithm used here is derived from the Java API
 * class <code>java.util.Random</code> and modified to also produce antithetic
 * values if antithetic mode is switched on.
 * 
 * @see desmoj.core.dist.UniformRandomGenerator
 * @see java.util.Random
 * 
 * @version DESMO-J, Ver. 2.3.5 copyright (c) 2013
 * @author Tim Lechler
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
public class ContDistNormal extends ContDist {

	/**
	 * The mean value for this type of distribution.
	 */
	protected double mean;

	/**
	 * The standard deviation for this type of distribution
	 */
	protected double stdDev;

	/**
	 * Buffer for storing the next gaussian value already calculated. Necessary
	 * for algorithm taken from Java API class <code>java.util.Random</code>.
	 * When computing a Gaussian value two samples of a pseudo random number
	 * stream are taken and calculated to produce two gaussian values, even if
	 * only one is used. So the other value is stored to be delivered next time
	 * a Gaussian value is requested by a client.
	 */
	protected double nextGaussian;

	/**
	 * Flag indicates wether there is already a calculated Gaussian value
	 * present in the buffer variable <code>nextGaussian</code>. Necessary for
	 * algorithm taken from Java API class <code>java.util.Random</code>. When
	 * calculating a pseudo random number using the algorithm implemented here,
	 * two Gaussian values are computed at a time, so the other value is stored
	 * to be used next time the client asks for a new value, thus saving on
	 * computation time. If <code>true</code>, there is a next Gaussian value
	 * already calculated, if <code>false</code> a new pair of Gaussian values
	 * has to be generated.
	 */
	protected boolean haveNextGaussian;

	/**
	 * Creates a stream of pseud random numbers following a normal (also known
	 * as "Gaussian") distribution. The specific mean and standard deviation
	 * values have to be given here at creation time.
	 * 
	 * @param owner
	 *            Model : The distribution's owner
	 * @param name
	 *            java.lang.String : The distribution's name
	 * @param mean
	 *            double : The mean value of the normal distribution
	 * @param standardDeviation
	 *            double : The standard deviation for this distribution
	 * @param showInReport
	 *            boolean : Flag for producing reports
	 * @param showInTrace
	 *            boolean : Flag for producing trace output
	 */
	public ContDistNormal(Model owner, String name, double mean,
			double standardDeviation, boolean showInReport, boolean showInTrace) {
		super(owner, name, showInReport, showInTrace);
		this.mean = mean;
		stdDev = standardDeviation;
	}

	/**
	 * Creates the default reporter for the RealDistNormal distribution.
	 * 
	 * @return Reporter : The reporter for the RealDistNormal distribution
	 * @see desmoj.core.report.ContDistNormalReporter
	 */
	public desmoj.core.report.Reporter createReporter() {

		return new desmoj.core.report.ContDistNormalReporter(this);

	}

	/**
	 * Returns the mean value of this Normal (also known as "Gaussian")
	 * distribution.
	 * 
	 * @return double : The mean value of this Normal (a.k.a. "Gaussian")
	 *         distribution.
	 */
	public double getMean() {

		return mean; // well, what'd you expect... ;-)

	}

	/**
	 * Returns the standard deviation of this normal (also known as "Gaussian")
	 * distribution.
	 * 
	 * @return double : The standard deviation of this normal (also known as
	 *         "Gaussian") distribution.
	 */
	public double getStdDev() {

		return stdDev; // easy

	}

	/**
	 * Returns the next normally (also known as "Gaussian") distributed sample
	 * from this distribution. The value depends upon the seed, the number of
	 * values taken from the stream by using this method before and the mean and
	 * standard deviation values specified for this distribution. Computation
	 * same as RealDistGaussian plus cast to <code>long</code>. The basic
	 * algorithm has been taken from the Java API
	 * <code>java.util.Random.nextGaussian()</code> with the feature of
	 * antithetic random numbers added.
	 * 
	 * @return Double : The next normally (also known as "Gaussian") distributed
	 *         sample from this distribution.
	 */
	public Double sample() {

		double newSample; // aux variable

		incrementObservations(); // increase count of samples

		do {
			if (haveNextGaussian) { // a Gaussian already calculated?

				haveNextGaussian = false; // set Flag that last Gaussian is
				// gone
				newSample = nextGaussian * stdDev + mean; // the prefab
				// gaussian

				// following code changed by Soenke

			} else {

				double v1, v2, s; // interim variables needed for calculation

				if (isAntithetic()) {

					do { // loop with antithetic random numbers switched on
						v1 = 2 * (1 - randomGenerator.nextDouble()) - 1; // between
						// -1
						// and
						// 1
						v2 = 2 * (1 - randomGenerator.nextDouble()) - 1; // between
						// -1
						// and
						// 1
						s = v1 * v1 + v2 * v2;
					} while (s >= 1);

				} else {

					do { // loop with normal random number generation
						v1 = 2 * randomGenerator.nextDouble() - 1; // between
						// -1
						// and 1
						v2 = 2 * randomGenerator.nextDouble() - 1; // between
						// -1
						// and 1
						s = (v1 * v1) + (v2 * v2);
					} while (s >= 1);

				}

				double multiplier = Math.sqrt(-2 * Math.log(s) / s);
				nextGaussian = v2 * multiplier; // 2nd Gaussian stored for
				// future requests
				haveNextGaussian = true; // set flag that other Gaussian is
				// available
				newSample = (v1 * multiplier) * stdDev + mean; // the Gaussian
				// value

			}
		} while (nonNegative && newSample < 0); // get a new sample if it should
		// be
		// non negative but actually is negative.

		if (this.currentlySendTraceNotes())
			this.traceLastSample(Double.toString(newSample));

		return newSample;
	}
}