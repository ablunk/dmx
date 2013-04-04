package desmoj.core.advancedModellingFeatures.report;

/**
 * Captures all relevant information about the <code>Stock</code>. That means
 * from the producer and the consumer queue.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Soenke Claassen
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

public class StockReporter extends desmoj.core.report.Reporter {
	// ****** attributes ******

	/**
	 * The column headings of the wait queues (producer and consumer) part of
	 * this StockReporter. Entries should contain the elements in the same order
	 * as the <code>stockEntries[]</code>.
	 */
	private String stockColumns[];

	/**
	 * The data entries of the wait queues (producer and consumer) part of this
	 * StockReporter. The entries should contain the data elements in the same
	 * order as defined in the <code>stockColumns[]</code> array.
	 */
	private String stockEntries[];

	/**
	 * The number of columns of the wait queues (producer and consumer) part of
	 * this StockReporter.
	 */
	private int stockNumColumns;

	// ****** methods ******

	/**
	 * Constructor for a new StockReporter. Note that although any Reportable is
	 * accepted you should make sure that only subtypes of Stock are passed to
	 * this constructor. Otherwise the number of column titles and their
	 * individual headings will differ from the actual content collected by this
	 * reporter.
	 * 
	 * @param informationSource
	 *            desmoj.Reportable : The Stock to report about
	 */
	public StockReporter(desmoj.core.simulator.Reportable informationSource) {
		super(informationSource); // make a Reporter

		groupHeading = "Stocks";
		groupID = 911; // see Reporter for more information about groupID

		// the stock part of the Stock
		numColumns = 10;
		columns = new String[numColumns];
		columns[0] = "Title";
		columns[1] = "(Re)set";
		columns[2] = "Prod";
		columns[3] = "Cons";
		columns[4] = "Init";
		columns[5] = "Limit";
		columns[6] = "Max";
		columns[7] = "Min";
		columns[8] = "Now";
		columns[9] = "Average";

		entries = new String[numColumns];

		// *** wait queues for producers and consumers ***

		stockNumColumns = 9;
		stockColumns = new String[stockNumColumns];
		stockColumns[0] = "Queues";
		stockColumns[1] = "Order";
		stockColumns[2] = "pass";
		stockColumns[3] = "(Re)set";
		stockColumns[4] = "Users";
		stockColumns[5] = "avg.Wait";
		stockColumns[6] = "QLimit";
		stockColumns[7] = "QMaxL";
		stockColumns[8] = "refused";

		// entries of producer and consumer queue
		stockEntries = new String[stockNumColumns * 2];

	}

	/**
	 * Returns an array of Strings each containing the data for the
	 * corresponding column in array <code>columns[]</code>. This method is
	 * fetching the data from the master Stock. Implement this method in a way,
	 * that an array of the same length as the column titles is produced
	 * containing the data at the point of time this method is called by someone
	 * else to produce up-to-date information.
	 * 
	 * @return java.lang.String[] : Array containing the data for reporting.
	 */
	public String[] getEntries() {

		if (source instanceof desmoj.core.advancedModellingFeatures.Stock) {
			// the Stock we report about (source = informationsource)
			desmoj.core.advancedModellingFeatures.Stock st = (desmoj.core.advancedModellingFeatures.Stock) source;

			// *** entries of stock
			// Title
			entries[0] = st.getName();
			// (Re)set
			entries[1] = st.resetAt().toString();
			// Prod
			entries[2] = Long.toString(st.getProducers());
			// Cons
			entries[3] = Long.toString(st.getConsumers());
			// Init
			entries[4] = Long.toString(st.getInitial());
			// Limit
			entries[5] = Long.toString(st.getCapacity());
			if (st.getCapacity() == Integer.MAX_VALUE) {
				entries[5] = "unlim.";
			}
			// Max
			entries[6] = Long.toString(st.getMaximum());
			// Min
			entries[7] = Long.toString(st.getMinimum());
			// Now
			entries[8] = Long.toString(st.getAvail());
			// Average
			entries[9] = Double.toString(st.avgAvail());

		} else {
			for (int i = 0; i < numColumns; i++) {
				entries[i] = "Invalid source!";
			} // end for
		} // end else

		return entries;
	}

	/**
	 * Returns the titles of the wait queues part of this StockReporter as an
	 * array of Strings.
	 * 
	 * @return java.lang.String[] : Array containing the titles of the wait
	 *         queues part of this StockReporter.
	 */
	public String[] getStockColumnTitles() {

		return stockColumns;
	}

	/**
	 * Returns an array of Strings each containing the data for the
	 * corresponding column in array <code>stockColumns[]</code>. This method
	 * is fetching the data from the master Stock. Implement this method in a
	 * way, that an array of the same length as the stockColumns titles is
	 * produced containing the data at the point of time this method is called
	 * by someone else to produce up-to-date information.
	 * 
	 * @return java.lang.String[] : Array containing the data for reporting.
	 */
	public String[] getStockEntries() {

		if (source instanceof desmoj.core.advancedModellingFeatures.Stock) {
			// the Stock (consumer queue) we report about (source =
			// informationsource)
			desmoj.core.advancedModellingFeatures.Stock st = (desmoj.core.advancedModellingFeatures.Stock) source;

			// the producer queue inside the Stock (is a ProcessQueue)
			desmoj.core.simulator.ProcessQueue pq = st.getProducerQueue();

			// *** stockEntries of the producers queue
			// Title
			stockEntries[0] = pq.getName();
			// pOrder
			stockEntries[1] = st.getProdQueueStrategy();
			// pass
			String passProds = "no";
			if (st.getPassByProducers()) {
				passProds = "yes";
			}
			stockEntries[2] = passProds;
			// (Re)set
			stockEntries[3] = pq.resetAt().toString();
			// Users
			stockEntries[4] = Long.toString(st.getProducers());
			// avg.Wait
			stockEntries[5] = pq.averageWaitTime().toString();
			// Qlimit
			stockEntries[6] = Long.toString(pq.getQueueLimit());
			if (pq.getQueueLimit() == Integer.MAX_VALUE) {
				stockEntries[6] = "unlimit.";
			}
			// QMaxL
			stockEntries[7] = Long.toString(pq.maxLength());
			// refused
			stockEntries[8] = Long.toString(pq.getRefused());

			// *** stockEntries of the consumer queue
			// Title
			stockEntries[9] = (st.getName() + "_C");
			// cOrder
			stockEntries[10] = st.getConsQueueStrategy();
			// pass
			String passCons = "no";
			if (st.getPassByConsumers()) {
				passCons = "yes";
			}
			stockEntries[11] = passCons;
			// (Re)set
			stockEntries[12] = st.resetAt().toString();
			// Users
			stockEntries[13] = Long.toString(st.getConsumers());
			// avg.Wait
			stockEntries[14] = st.averageWaitTime().toString();
			// QLimit
			stockEntries[15] = Long.toString(st.getQueueLimit());
			if (st.getQueueLimit() == Integer.MAX_VALUE) {
				stockEntries[15] = "unlimit.";
			}
			// QMaxL
			stockEntries[16] = Long.toString(st.maxLength());
			// refused
			stockEntries[17] = Long.toString(st.getRefused());

		} else {
			for (int i = 0; i < stockNumColumns * 2; i++) {
				stockEntries[i] = "Invalid source!";
			} // end for
		} // end else

		return stockEntries;
	}

	/**
	 * Returns the number of columns of the wait queues part of this
	 * StockReporter.
	 * 
	 * @return int : The number of columns of the wait queues part of this
	 *         StockReporter
	 */
	public int getStockNumColumns() {

		return stockNumColumns;
	}
	
	/*@TODO: Comment */
	public boolean isContinuingReporter() {
		return true;
	}
} // end class StockReporter
