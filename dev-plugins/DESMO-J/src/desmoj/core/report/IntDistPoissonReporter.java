package desmoj.core.report;

/**
 * Reports all information about a IntDistPoisson distribution.
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
public class IntDistPoissonReporter extends DistributionReporter {
	/**
	 * Creates a new IntDistPoissonReporter.
	 * 
	 * @param informationSource
	 *            desmoj.Reportable : The integer Poisson distribution to report
	 *            about
	 */
	public IntDistPoissonReporter(
			desmoj.core.simulator.Reportable informationSource) {

		super(informationSource);

		groupID = 124;

	}

	/**
	 * Returns the array of strings containing all information about the
	 * IntDistPoisson distribution.
	 * 
	 * @return java.lang.String[] : The array of Strings containing all
	 *         information about the IntDistPoisson distribution
	 */
	public java.lang.String[] getEntries() {

		if (source instanceof desmoj.core.dist.IntDistPoisson) {
			// use casted ide as a shortcut for source
			desmoj.core.dist.IntDistPoisson idp = (desmoj.core.dist.IntDistPoisson) source;
			// Title
			entries[0] = idp.getName();
			// (Re)set
			entries[1] = idp.resetAt().toString();
			// Obs
			entries[2] = Long.toString(idp.getObservations());
			// Type
			entries[3] = "Poisson";
			// param1
			entries[4] = Double.toString(idp.getMean());
			// param2
			entries[5] = " ";
			// seed
			entries[6] = Long.toString(idp.getInitialSeed());
		} else {
			for (int i = 0; i < numColumns; i++) {
				entries[i] = "Invalid source!";
			}
		}

		return entries;

	}
}