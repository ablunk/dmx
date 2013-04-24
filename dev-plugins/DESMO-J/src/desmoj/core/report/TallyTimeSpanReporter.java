package desmoj.core.report;

import desmoj.core.simulator.Reportable;
import desmoj.core.simulator.TimeSpan;

@Deprecated
public class TallyTimeSpanReporter extends TallyReporter {

	public TallyTimeSpanReporter(Reportable informationSource) {
		super(informationSource);
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
	@Override
	public String[] getEntries() {
		if (source instanceof desmoj.core.statistic.Tally) {
			// the Tally we report about (source = informationSource)
			desmoj.core.statistic.Tally tl = (desmoj.core.statistic.Tally) source;
			desmoj.core.statistic.TallyRunning tlr = null;
	        if (tl instanceof desmoj.core.statistic.TallyRunning) {
	           tlr = (desmoj.core.statistic.TallyRunning) tl;
	        }

			// Title
			entries[0] = tl.getName();
			// (Re)set
			entries[1] = tl.resetAt().toString();
			// Obs
			entries[2] = Long.toString(tl.getObservations());
			// Mean
			// no observations made, so Mean can not be calculated
			if (tl.getObservations() == 0) {
				entries[3] = "Insufficient data";
			}
			else // return mean value
			{
				entries[3] = new TimeSpan(tl.getMean()).toString();
				
				if (tlr != null)
					entries[3] += " (last " + tlr.getSampleSizeN() + " obs: " + new TimeSpan(tlr.getMeanLastN()).toString() + ")";    
			}

			// Std.Dev
			// not enough observations are made, so Std.Dev can not be
			// calculated
			if (tl.getObservations() < 2) {
				entries[4] = "Insufficient data";
			}
			else // return standard deviation
			{
				entries[4] = new TimeSpan(tl.getStdDev()).toString();
                
				if (tlr != null)
                	entries[4] += " (last " + tlr.getSampleSizeN() + " obs: " + new TimeSpan(tlr.getStdDevLastN()).toString() + ")";    
			}

			// Min
	        if (tl.getObservations() == 0) {
	            entries[5] = "Insufficient data";
	        }
	        else {
		       	entries[5] = new TimeSpan(tl.getMinimum()).toString();
                
		       	if (tlr != null)
		       		entries[5] += " (last " + tlr.getSampleSizeN() + " obs: " + new TimeSpan(tlr.getMinimumLastN()).toString() + ")";
	        }

			// Max
	        if (tl.getObservations() == 0) {
                entries[6] = "Insufficient data";
            }
	        else {
                entries[6] = new TimeSpan(tl.getMaximum()).toString();
                
                if (tlr != null)
                	entries[6] += " (last " + tlr.getSampleSizeN() + " obs: " + new TimeSpan(tlr.getMaximumLastN()).toString() + ")";
            }
			
		}
		else {
			for (int i = 0; i < numColumns; i++) {
				entries[i] = "Invalid source!";
			} // end for
		} // end else

		return entries;
	}
}
