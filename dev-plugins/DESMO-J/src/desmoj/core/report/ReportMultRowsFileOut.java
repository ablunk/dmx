package desmoj.core.report;

//import desmoj.extensions.applicationDomains.production.report.WorkStationReporter;

/**
 * ReportMultRowsFileOut is used to create a file to let the reporters write
 * their reports to. It receives a reporter and divides its individual text
 * information up to be displayed in HTML format on disc in the user's local
 * directory. The messages are displayed in a tabular design with columns for
 * each item displayed by the reporter. For each Reporter giving a new group-ID,
 * a new table is opened. This leads to a number of distinct tables displayed in
 * one HTML-page with all reporters grouped by their group-id in one table. This
 * special ReportFileOut is designed to write reports with more than one row for
 * one reporter. This is needed for the <code>WaitQueueReporter</code> where
 * there will be one row for the data of the waiting slaves and one row for the
 * data of the waiting masters and for the <code>HistogramReporter</code>
 * where there will be multiple rows, one for each segment (cell) of ther
 * interval. Note that if the framework is used as an Applet in webpages there
 * is no access to the disc and an alternative output on screen or into a
 * graphics window must be registered at the Experiment's MessageManager for
 * this type of messages. Errors affecting the java runtime are always displayed
 * on the system's standard output PrintStream.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author of ReportFileOut class : Tim Lechler, modified by Soenke Claassen and
 *         Nicolas Knaak
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
public class ReportMultRowsFileOut extends ReportFileOut {
	
	/**
	 * Creates a file to print reports into a HTML page. By opening the file,
	 * the necessary HTML tags to define a webpage are already inserted into the
	 * file. The parameter given should reflect the experiment that produces
	 * this file.
	 * 
	 * @param simTimeFloatingDigits
	 *            int : The number of floating point digits of the simulation
	 *            time values to be displayed
	 */
	public ReportMultRowsFileOut(int simTimeFloatingDigits, String formatter) {
		super(simTimeFloatingDigits, formatter); // make a ReportFileOut
	}

	/**
	 * Receives a reporter and writes its contents formatted to a HTML table
	 * into a file in the user's default directory. In case of a ModelReporter
	 * it writes the model's information into the file. After writing the model
	 * data, all reportables registered with the ModelReporter are asked for a
	 * reporter and those are also written to the report file. After processing
	 * the Reportables, the registered subModels are asked to produce their
	 * reporters which in turn are recursively sent to this method until no
	 * other submodels are available.
	 * 
	 * @param r
	 *            Reporter : The Reporter to be processed
	 */
	public void receive(desmoj.core.report.Reporter r) {
		// check parameters
		if (r == null)
			return; // invalid parameter

		// copy values in buffer variables for faster access
		String[] titleBuf = r.getColumnTitles();
		String[] entryBuf = r.getEntries();

		// first Reporter to be printed here always writes heading and starts
		// table
		// (most likely a ModelReporter)
		if (lastReporter == null) {
			// open a table with the heading needed for this type of reporter
			formatter.openTable(r.getHeading());
			formatter.openRow();

			for (int i = 0; i < r.numColumns(); i++) {
				formatter.writeHeadingCell(titleBuf[i]);
			}

			formatter.closeRow();
			lastReporter = r;
			// trick the next if-clause to be avoided first time
		} else {
			// if two HistogramReporter or two StockReporter or two
			// WorkStationReporter
			// or two TransportReporter will be written one after the other
			// @modified by Nick Knaak 6.2.06: Condition 1: isContinuingReporter
				
			if (r.isContinuingReporter() && lastReporter.isContinuingReporter()
					&& (r.getClass().isAssignableFrom(lastReporter.getClass())
							|| lastReporter.getClass().isAssignableFrom(r.getClass()))) { 
				formatter.closeTable();
				// open new table for new XYReporter with no special header
				formatter.openTable(" ");
				formatter.openRow();

				for (int i = 0; i < r.numColumns(); i++) {
					formatter.writeHeadingCell(titleBuf[i]);
				}

				formatter.closeRow();
			} // end if
		} // end else

		// if new Reporter group type is received, close last table and open new
		// one
		// --- Modification by N. Knaak (27.11.01): Every table reporter has
		// it's own
		// headings.
		if (Reporter.isOtherGroup(r, lastReporter)
				&& !(r instanceof TableReporter)) {

			formatter.closeTable();
			formatter.writeHorizontalRuler();
			formatter.openTable(r.getHeading());
			formatter.openRow();

			for (int i = 0; i < r.numColumns(); i++) {
				formatter.writeHeadingCell(titleBuf[i]);
			}

			formatter.closeRow();
		}

		// the WaitQueueReporter, the TransportReporter and the
		// WorkStationReporter
		// produce two rows
		// @modified: Condition 2 - isTwoRowReporter
		// by Nick Knaak 6.2.06
		if (r.isTwoRowReporter()) {
			formatter.openRow(); // open the row for the master queue data

			// write all data of the master queue in this row
			for (int i = 0; i < r.numColumns(); i++) {
				formatter.writeCell(entryBuf[i]);
			}

			formatter.closeRow(); // close the row for the master queue data

			formatter.openRow(); // open the row for the slave queue data

			// write all data of the slave queue in this row
			for (int i = r.numColumns(); i < (r.numColumns() * 2); i++) {
				formatter.writeCell(entryBuf[i]);
			}

			formatter.closeRow(); // close the row for the slave queue data

			// if a WorkStation has more than one slave queue
			// @modified by Nick Knaak, 6.2.06
			if (r.getNumOfSlaveQueues() > 0) {
				int numberSlaveQueues = r.getNumOfSlaveQueues();

				// write all the slave queue rows
				for (int j = 1; j < numberSlaveQueues; j++) {
					formatter.openRow();
					// open the row for the slave queue data

					// write all data of the slave queue in this row
					for (int i = (r.numColumns() * (j + 1)); i < (r
							.numColumns() * (j + 2)); i++) {
						formatter.writeCell(entryBuf[i]);
					}

					formatter.closeRow();
					// close the row for the slave queue data
				}
			}

		}
		// --- Modification by N. Knaak (27.11.01): TableReporters are
		// completely handled below.
		else if (!(r instanceof TableReporter))
		// normal handling of all other Reporters
		{
			// always write the reporter's content into a table row
			formatter.openRow();

			for (int i = 0; i < r.numColumns(); i++) {
				formatter.writeCell(entryBuf[i]);
			}

			// the row's finished now
			formatter.closeRow();
		}

		// the HistogramReporter produces a special histogram table
		if (r instanceof desmoj.core.report.HistogramReporter) {
			// "Type-Cast"
			desmoj.core.report.HistogramReporter hr = (desmoj.core.report.HistogramReporter) r;

			// copy values in buffer variables for faster access
			String[] histTitleBuf = hr.getHistColumnTitles();
			String[][] histEntryBuf = hr.getHistEntries();

			formatter.closeTableNoTopTag();
			// close the normal (Tally-like) Histogram table
			formatter.openTable(" ");
			// open table for histogram part with no special header
			formatter.openRow(); // open header row

			// in case there is not enough data collected
			if (hr.getObservations() < 3) {
				formatter
						.writeCell("not sufficient data for displaying histogram statistics");

				formatter.closeRow();
			} else // enough data collected to display histogram part
			{
				for (int i = 0; i < hr.getHistNumColumns(); i++) {
					formatter.writeHeadingCell(histTitleBuf[i]);
				}

				formatter.closeRow();

				// write the HistrogramReporter's content into a table

				// loop through all cells
				for (int j = 0; j < hr.getNoOfCells() + 2; j++) {
					formatter.openRow();

					for (int i = 0; i < hr.getHistNumColumns(); i++) {
						formatter.writeCell(histEntryBuf[j][i]);
					}

					// the row is finished now
					formatter.closeRow();
				}
			}
		}

		// the StockReporter produces a special stock report about the two
		// queues
		// for the producers and consumers
		// @TODO: Cond 3: isStockReporter
		if (r instanceof desmoj.core.advancedModellingFeatures.report.StockReporter) {
			// "Type-Cast"
			desmoj.core.advancedModellingFeatures.report.StockReporter sr = (desmoj.core.advancedModellingFeatures.report.StockReporter) r;

			// copy values in buffer variables for faster access
			String[] stockTitleBuf = sr.getStockColumnTitles();
			String[] stockEntryBuf = sr.getStockEntries();

			formatter.closeTableNoTopTag();
			// close the normal Stock table (stock part)
			formatter.openTable(" ");
			// open table for queues part with no special header
			formatter.openRow(); // write header row

			// write queues heading
			for (int i = 0; i < sr.getStockNumColumns(); i++) {
				formatter.writeHeadingCell(stockTitleBuf[i]);
			}

			formatter.closeRow();

			// write the producer queue's content into a table
			formatter.openRow(); // open the row for the producer queue data

			// write all data of the producer queue in this row
			for (int i = 0; i < sr.getStockNumColumns(); i++) {
				formatter.writeCell(stockEntryBuf[i]);
			}

			formatter.closeRow(); // close the row for the producer queue data

			formatter.openRow(); // open the row for the consumer queue data

			// write all data of the consumer queue in this row
			for (int i = sr.getStockNumColumns(); i < (sr.getStockNumColumns() * 2); i++) {
				formatter.writeCell(stockEntryBuf[i]);
			}

			formatter.closeRow(); // close the row for the consumer queue data

		} // end if StockReporter

		// --- The table reporter produces a table of arbitrary length.
		// (Modification: Nicolas Knaak 27.11.2001)
		if (r instanceof TableReporter)
			writeTableReporter((TableReporter) r, titleBuf);

		// remember the last reporter
		lastReporter = r;
	}

	/** Writes a table reporter */
	private void writeTableReporter(TableReporter tr, String[] titleBuf) {
		int cols = tr.numColumns();
		int rows = tr.numRows();
		String[][] entryTable = tr.getEntryTable();
		if (formatter.tableIsOpen())
			formatter.closeTable();

		formatter.writeHorizontalRuler();
		formatter.openTable(tr.getTitle());

		// Write additional info in table header

		String[][] header = tr.getHeader();
		if (header != null) {
			for (int i = 0; i < header.length; i++) {
				formatter.openRow();
				for (int j = 0; j < header[i].length; j++) {
					formatter.writeCell(header[i][j]);
				}
				formatter.closeRow();
			}
			formatter.openRow();
			formatter.writeCell("___");
			formatter.closeRow();
		}

		// Write Headings
		formatter.openRow();
		for (int i = 0; i < cols; i++) {
			formatter.writeHeadingCell(titleBuf[i]);
		}
		formatter.closeRow();

		formatter.openRow();
		formatter.closeRow();

		// Write Data Entries
		for (int i = 0; i < rows; i++) {
			formatter.openRow();
			for (int j = 0; j < cols; j++) {
				formatter.writeCell(entryTable[i][j]);
			}
			formatter.closeRow();
		}
		formatter.closeTable();
	}
} // end class ReportMultRowsFileOut
