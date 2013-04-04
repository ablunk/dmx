package desmoj.core.report;

/**
 * Captures all relevant information about the Tally.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Soenke Claassen based on ideas from Tim Lechler
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

public class TallyReporter extends desmoj.core.report.Reporter {

	// ****** methods ******

	/**
	 * Constructor for a new TallyReporter. Note that although any Reportable is
	 * accepted you should make sure that only subtypes of Tally are passed to
	 * this constructor. Otherwise the number of column titles and their
	 * individual headings will differ from the actual content collected by this
	 * reporter.
	 * 
	 * @param informationSource
	 *            desmoj.Reportable : The Tally to report about.
	 */
	public TallyReporter(desmoj.core.simulator.Reportable informationSource) {
		super(informationSource); // make a Reporter

		numColumns = 12;
		columns = new String[numColumns];
		columns[0] = "Title";
		columns[1] = "(Re)set";
		columns[2] = "Obs";
		columns[3] = "Mean";
		columns[4] = "Std.Dv";
		columns[5] = "Min";
		columns[6] = "Max";
        columns[7] = "Mean/Last";
        columns[8] = "Std.Dv/Last";
        columns[9] = "Min/Last";
        columns[10] = "Max/Last";
        columns[11] = "LastLength";
        groupHeading = "Tallies";
		groupID = 1611; // see Reporter for more information about groupID
		entries = new String[numColumns];
	}

	/**
	 * Returns an array of Strings each containing the data for the
	 * corresponding column in array <code>columns[]</code>. Implement this
	 * method in a way, that an array of the same length as the column titles is
	 * produced containing the data at the point of time this method is called
	 * by someone else to produce up-to-date information.
	 * 
	 * @return java.lang.String[] : Array containing the data for reporting
	 */
	public String[] getEntries() {
		if (source instanceof desmoj.core.statistic.Tally) {
			// the Tally we report about (source = informationSource)
			desmoj.core.statistic.Tally tl = (desmoj.core.statistic.Tally) source;

			// Title
			entries[0] = tl.getName();
			// (Re)set
			entries[1] = tl.resetAt().toString();
			// Obs
			entries[2] = Long.toString(tl.getObservations());
			// Mean/Total
			// no observations made, so Mean can not be calculated
			if (tl.getObservations() == 0) {
				entries[3] = "insufficient data";
			} else // return mean value
			{
				entries[3] = Double.toString(tl.getMean());
			}

			// Std.Dev/Total
			// not enough observations are made, so Std.Dev can not be
			// calculated
			if (tl.getObservations() < 2) {
				entries[4] = "insufficient data";
			} else // return standard deviation
			{
				entries[4] = Double.toString(tl.getStdDev());
			}

			// Min./Total
			entries[5] = Double.toString(tl.getMinimum());
			// Max./Total
			entries[6] = Double.toString(tl.getMaximum());
			
			if (tl instanceof desmoj.core.statistic.TallyRunning) {
			    desmoj.core.statistic.TallyRunning tlr = (desmoj.core.statistic.TallyRunning) tl;
			    
	            // Mean/Last n
	            // no observations made, so Mean can not be calculated
	            if (tl.getObservations() == 0) {
	                entries[7] = "insufficient data";
	            } else // return mean value
	            {
	                entries[7] = Double.toString(tlr.getMeanLastN());
	            }

	            // Std.Dev/Last n
	            // not enough observations are made, so Std.Dev can not be
	            // calculated
	            if (tl.getObservations() < 2) {
	                entries[8] = "insufficient data";
	            } else // return standard deviation
	            {
	                entries[8] = Double.toString(tlr.getStdDevLastN());
	            }

	            // Min./Last n
	            entries[9] = Double.toString(tlr.getMinimumLastN());
	            // Max./Last n
	            entries[10] = Double.toString(tlr.getMaximumLastN());            
	            // n
	            entries[11] = Integer.toString(tlr.getSampleSizeN());
			    
			} else {
			    
			    entries[7] = entries[8] = entries[9] = entries[10] = entries[11] = "";
			}
			
		} else {
			for (int i = 0; i < numColumns; i++) {
				entries[i] = "Invalid source!";
			} // end for
		} // end else

		return entries;
	}
} // end class TallyReporter
