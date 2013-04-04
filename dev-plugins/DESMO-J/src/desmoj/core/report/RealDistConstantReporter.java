package desmoj.core.report;

/**
 * Reports all information about a RealDistConstant distribution.
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
public class RealDistConstantReporter extends DistributionReporter {
	/**
	 * Creates a new RealDistConstantReporter.
	 * 
	 * @param informationSource
	 *            desmoj.Reportable : The RealDistConstant distribution to
	 *            report about
	 */
	public RealDistConstantReporter(
			desmoj.core.simulator.Reportable informationSource) {

		super(informationSource);

		groupID = 150;

	}

	/**
	 * Returns the array of strings containing all information about the
	 * RealDistConstant distribution.
	 * 
	 * @return java.lang.String[] : The array of Strings containing all
	 *         information about the RealDistConstant distribution
	 */
	public java.lang.String[] getEntries() {

		if (source instanceof desmoj.core.dist.RealDistConstant) {

			// use casted bdb as a shortcut for source
			desmoj.core.dist.RealDistConstant rdc = (desmoj.core.dist.RealDistConstant) source;
			// Title
			entries[0] = rdc.getName();
			// (Re)set
			entries[1] = rdc.resetAt().toString();
			// Obs
			entries[2] = Long.toString(rdc.getObservations());
			// Type
			entries[3] = "Real Constant";
			// param1
			entries[4] = Double.toString(rdc.getConstantValue());
			// param2
			entries[5] = " ";
			// seed
			entries[6] = Long.toString(rdc.getInitialSeed());

		} else {

			for (int i = 0; i < numColumns; i++) {
				entries[i] = "Invalid source!";
			}

		}

		return entries;

	}
}