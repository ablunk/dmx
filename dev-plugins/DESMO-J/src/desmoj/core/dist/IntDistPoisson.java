package desmoj.core.dist;

import desmoj.core.report.IntDistPoissonReporter;
import desmoj.core.simulator.Model;

/**
 * Poisson distributed stream of pseudo random integer numbers. The distribution
 * specified by one parameter describing the mean value.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Tim Lechler
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
public class IntDistPoisson extends IntDist {

	/**
	 * The mean value of the poisson distribution as given to the constructor.
	 */
	protected double mean;

	/**
	 * Creates a poisson distributed stream of pseudo random integer numbers.
	 * The parameter describes the mean value. Giving zero or negative values
	 * for the mean value will result in zero being returned by the
	 * <code>sample()</code> method.
	 * 
	 * @param owner
	 *            Model : The distribution's owner
	 * @param name
	 *            java.lang.String : The distribution's name
	 * @param meanValue
	 *            double : The mean <code>double</code> value for this
	 *            distribution
	 * @param showInReport
	 *            boolean : Flag for producing reports
	 * @param showInTrace
	 *            boolean : Flag for producing trace output
	 */
	public IntDistPoisson(Model owner, String name, double meanValue,
			boolean showInReport, boolean showInTrace) {
		super(owner, name, showInReport, showInTrace);
		mean = meanValue;
	}

	/**
	 * Creates the default reporter for the IntDistPoisson distribution.
	 * 
	 * @return Reporter : The reporter for the IntDistPoisson distribution
	 * @see IntDistPoissonReporter
	 */
	public desmoj.core.report.Reporter createReporter() {

		return new desmoj.core.report.IntDistPoissonReporter(this);

	}

	/**
	 * Returns the mean value of the poisson distribution.
	 * 
	 * @return double : The mean value of this Poisson distribution
	 */
	public double getMean() {

		return mean;

	}

	/**
	 * Returns the next poisson distributed sample from this distribution. The
	 * algorithm used is taken from the lecture notes to a simulation lecture by
	 * Prof. Dr.-Ing. Hans-Juergen Siegert at TU Munich in 1995. It has been
	 * adapted to Java and extended to handle antithetic random numbers if
	 * antithetic mode is switched on.
	 * 
	 * @return long : The next Poisson distributed sample. This will be zero if
	 *         the given mean value <= 0.
	 */
	public long sample() {

		// the first version used the algorithm from DESMO-C from Thomas
		// Schniewind
		// [Schn98] Volume 2, page103, file intdist.cc.
		// it has the major drawback of running into an endless loop for mean
		// values > 745

		// incrementObservations(); // increase the number of randoms given to
		// the client
		// double r = java.lang.Math.exp(-mean);
		// double q = 1.0;
		// long m = -1;
		// if ( antithetic ) { // check if antithetic mode is switched on
		// do {
		// q *= ( 1 - randomGenerator.nextDouble());
		// m++;
		// } while ( q>=r );
		// }
		// else {
		// do {
		// q *= randomGenerator.nextDouble();
		// m++;
		// } while ( q>=r );
		// }
		// return m;

		// therefore replaced by the algorithm described in the lecture notes
		// of Prof. Siegert, chapter 7, page 161
		// URL:
		// http://www6.informatik.tu-muenchen.de/lehre/vorlesungen/script_simulation/vl_simulation_k07.ps.gz
		// this is only valid for mean values >= 0 !

		incrementObservations();
		// increase the number of randoms given to the client
		// check if mean value is valid
		if (this.mean <= 0)
			return 0;
		// compute next sample
		long newSample;
		double mv, dt, sum;
		mv = 1.0 / this.mean;
		sum = 0;
		newSample = 0;
		if (antithetic)
			dt = -mv * Math.log(1 - randomGenerator.nextDouble());
		else
			dt = -mv * Math.log(randomGenerator.nextDouble());
		while ((sum + dt) <= 1) {
			sum += dt;
			newSample++;
			if (antithetic)
				dt = -mv * Math.log(1 - randomGenerator.nextDouble());
			else
				dt = -mv * Math.log(randomGenerator.nextDouble());
		}
		
		if (this.currentlySendTraceNotes()) this.traceLastSample(Long.toString(newSample));
		
		return newSample;
	}
}