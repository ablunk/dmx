package desmoj.core.report;

/**
 * Reports all information about a IntDistEmpirical distribution.
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
public class RealDistEmpiricalReporter extends DistributionReporter {
	/**
	 * Creates a new IntDistEmpiricalReporter.
	 * 
	 * @param informationSource
	 *            desmoj.Reportable : The IntDistEmpirical distribution to
	 *            report about
	 */
	public RealDistEmpiricalReporter(
			desmoj.core.simulator.Reportable informationSource) {

		super(informationSource);

		groupID = 152;

	}

	/**
	 * Returns the array of strings containing all information about the
	 * RealDistEmpirical distribution.
	 * 
	 * @return java.lang.String[] : The array of Strings containing all
	 *         information about the RealDistEmpirical distribution
	 */
	public java.lang.String[] getEntries() {

		if (source instanceof desmoj.core.dist.RealDistEmpirical) {

			// use casted ide as a shortcut for source
			desmoj.core.dist.RealDistEmpirical rde = (desmoj.core.dist.RealDistEmpirical) source;
			// Title
			entries[0] = rde.getName();
			// (Re)set
			entries[1] = rde.resetAt().toString();
			// Obs
			entries[2] = Long.toString(rde.getObservations());
			// Type
			entries[3] = "Real Empirical";
			// param1
			entries[4] = " ";
			// param2
			entries[5] = " ";
			// seed
			entries[6] = Long.toString(rde.getInitialSeed());

		} else {

			for (int i = 0; i < numColumns; i++) {
				entries[i] = "Invalid source!";
			}

		}

		return entries;

	}
}