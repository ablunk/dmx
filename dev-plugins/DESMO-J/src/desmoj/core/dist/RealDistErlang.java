package desmoj.core.dist;

import desmoj.core.simulator.Model;

/**
 * Erlang distributed stream of pseudo random numbers of type double. Erlang
 * distributed streams are specified by a mean value and their order.
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
public class RealDistErlang extends RealDist {

	/**
	 * The order "k" of the Erlang distribution
	 */
	protected long k;

	/**
	 * The mean value for the Erlang distribution.
	 */
	protected double mean;

	/**
	 * Creates a stream of pseudo random numbers following a normal (a.k.a.
	 * "Gaussian") distribution. The specific mean and standard deviation values
	 * have to be given here at creation time, as well as the seed for the
	 * underlying pseudo random generator.
	 * 
	 * @param owner
	 *            Model : The distribution's owner
	 * @param name
	 *            java.lang.String : The distribution's name
	 * @param order
	 *            long : The order of the Erlang distribution (>=1)
	 * @param meanValue
	 *            double : The mean value for this distribution
	 * @param showInReport
	 *            boolean : Flag for producing reports
	 * @param showInTrace
	 *            boolean : Flag for producing trace output
	 */
	public RealDistErlang(Model owner, String name, long order, double mean,
			boolean showInReport, boolean showInTrace) {
		super(owner, name, showInReport, showInTrace);

		k = order;
		this.mean = mean;
	}

	/**
	 * Creates the default reporter for the RealDistErlang distribution.
	 * 
	 * @return Reporter : The reporter for the RealDistErlang distribution
	 * @see desmoj.core.report.RealDistErlangReporter
	 */
	public desmoj.core.report.Reporter createReporter() {

		return new desmoj.core.report.RealDistErlangReporter(this);

	}

	/**
	 * Returns the mean value of this Erlang distribution.
	 * 
	 * @return double : The mean value of this Erlang distribution.
	 */
	public double getMean() {

		return mean; // well, what'd you expect... ;-)

	}

	/**
	 * Returns the order of the Erlang distribution.
	 * 
	 * @return double : The order of this Erlang distribution.
	 */
	public long getOrder() {

		return k;

	}

	/**
	 * Returns the next Erlang distributed sample from this distribution. The
	 * algorithm used is taken from DESMO-C from Thomas Schniewind [Schni98]
	 * Volume 2, page 222, file realdist.cc. It has been adapted to Java and
	 * extended to handle antithetic random numbers if antithetic mode is
	 * switched on.
	 * 
	 * @return double : The next Erlang distributed sample
	 */
	public double sample() {

		incrementObservations(); // increase count of samples
		double q = 1.0; // auxiliary variable needed for computing
		// the order of Erlang sample

		if (isAntithetic()) { // if antithetic mode is switched on

			for (int i = 1; i <= k; i++) { // iteration over order of Erlang
				// number
				q *= (1 - randomGenerator.nextDouble());
			}

		} else { // normal computation of Erlang sample

			for (int i = 1; i <= k; i++) { // iteration over order of Erlang
				// number
				q *= randomGenerator.nextDouble();
			}

		}

		double newSample = ((-java.lang.Math.log(q) * mean) / k); // erlang
		// value

		// there are no negative samples in RealDistErlang
		// if (nonNegative) {
		// if (newSample < 0) return -newSample;
		// }
		
        if (this.currentlySendTraceNotes()) this.traceLastSample(Double.toString(newSample));

		return newSample;

	}
}