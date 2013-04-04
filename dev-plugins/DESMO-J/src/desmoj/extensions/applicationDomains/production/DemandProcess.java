package desmoj.extensions.applicationDomains.production;

import desmoj.core.dist.IntDist;
import desmoj.core.dist.RealDist;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

/**
 * DemandProcess is a kind of process representing the demand in a manufacturing
 * system. It is some kind of drain for the products manufactured in the
 * production system. So it can be viewed as the border of the simulated system,
 * where the products disappear. It is meant to model the demand of the market
 * where the finished products leaving the manufacturing system are sold. It has
 * three main parameters to be specified (see the Constructor): The
 * <code>Entrepot</code> where the products to be sold are stored, the random
 * number distribution to determine the quantity of demanded products, the rate
 * (frequenzy) also a random number distribution, at which the demand occurs.
 * Once the DemandProcess has obtained the products, they are consumed and will
 * leave the simulated system for ever. Actually they will be destroyed as the
 * the garbage collector will get them. Internally <code>CustomerProcesss</code>
 * es are set up and initialized, which are the ones actually fetching the
 * products from the <code>Entrepot</code>. But this is done automatically,
 * so the user does not have to care about it.
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
public class DemandProcess extends SimProcess {

	/**
	 * The random number distribution determining the quantity of demanded
	 * products.
	 */
	private desmoj.core.dist.IntDist demandQuantity;

	/**
	 * The random number distribution determining the intervals in which the
	 * demand occurs.
	 */
	private desmoj.core.dist.RealDist demandInterval;

	/**
	 * The <code>Entrepot</code> supplying the products this DemandProcess is
	 * demanding.
	 */
	private Entrepot entrepot;

	/**
	 * Constructor of a DemandProcess. The DemandProcess is fetching a certain
	 * quantity of products from the given <code>Entrepot</code> in certain
	 * intervals.
	 * 
	 * @param owner
	 *            desmoj.Model : The model this DemandProcess is associated to.
	 * @param name
	 *            java.lang.String : The name of this DemandProcess.
	 * @param supplier
	 *            desmoj.Entrepot : The <code>Entrepot</code> supplying the
	 *            products this DemandProcess is buying.
	 * @param quantity
	 *            desmoj.dist.IntDist : The random number distribution
	 *            determining the demand (quantity) of this DemandProcess. Use
	 *            <code>desmoj.dist.IntDistConstant</code> to simulate a
	 *            constant demand.
	 * @param interval
	 *            desmoj.dist.RealDist : The random number distribution
	 *            determining the intervals in which the demand occurs. Use
	 *            <code>desmoj.dist.RealDistConstant</code> to simulate
	 *            constant intervals.
	 * @param showInTrace
	 *            boolean : Flag, if this DemandProcess should produce a trace
	 *            output or not.
	 */
	public DemandProcess(Model owner, String name, Entrepot supplier,
			IntDist quantity, RealDist interval, boolean showInTrace) {
		super(owner, name, showInTrace); // make a SimProcess

		// save the parameters
		this.entrepot = supplier;
		this.demandQuantity = quantity;
		this.demandInterval = interval;
	}

	/**
	 * Returns the random number distribution determining the intervals in which
	 * the demand occurs.
	 * 
	 * @return desmoj.dist.RealDist : The random number distribution determining
	 *         the intervals in which the demand occurs.
	 */
	public desmoj.core.dist.RealDist getDemandInterval() {

		return demandInterval;
	}

	/**
	 * Returns the random number distribution determining the demand (quantity).
	 * 
	 * @return desmoj.dist.IntDist : The random number distribution determining
	 *         the demand (quantity).
	 */
	public desmoj.core.dist.IntDist getDemandQuantity() {

		return demandQuantity;
	}

	/**
	 * Returns the <code>Entrepot</code> supplying the products this
	 * DemandProcess is demanding.
	 * 
	 * @return desmoj.Entrepot : The <code>Entrepot</code> supplying the
	 *         products this DemandProcess is demanding.
	 */
	public Entrepot getEntrepot() {

		return entrepot;
	}

	/**
	 * The DemandProcess is fetching in certain intervals a certain quantity of
	 * products from the given <code>Entrepot</code> and destroys them. So it
	 * serves as a drain for the finished products. To prevent this process from
	 * being blocked waiting in the queue of the <code>Entrepot</code>, it
	 * will instantiate <code>CustomerProcess</code> es which will actually
	 * fetching the products from the <code>Entrepot</code>.
	 */
	public void lifeCycle() {

		while (true) // a never ending hunger for products ;-)
		{
			// wait until it is time to fetch the next products
			hold(new SimTime(demandInterval.sample()));

			// determine the quantity of demanded products
			int qty = (int) demandQuantity.sample();

			// create and activate a CustomerProcess to let him fetch the
			// products
			CustomerProcess cp = new CustomerProcess(getModel(),
					"anonymous customer", entrepot, qty, traceIsOn());
			cp.activate(new SimTime(0.0));

			// debug out
			if (currentlySendDebugNotes()) {
				sendDebugNote("demands " + qty + " products from "
						+ entrepot.getQuotedName());
			}
		} // end while loop
	}

	/**
	 * Sets the intervals in which the demand occurs to the new given random
	 * number distribution. Use <code>desmoj.dist.RealDistConstant</code> to
	 * simulate constant intervals.
	 * 
	 * @param newDemandInterval
	 *            desmoj.dist.RealDist : The new random number distribution
	 *            determining the intervals in which the demand occurs.
	 */
	public void setDemandInterval(desmoj.core.dist.RealDist newDemandInterval) {

		this.demandInterval = newDemandInterval;
	}

	/**
	 * Sets the demand (quantity) to the new given random number distribution.
	 * Use <code>desmoj.dist.IntDistConstant</code> to simulate a constant
	 * demand.
	 * 
	 * @param newDemandQuantity
	 *            desmoj.dist.IntDist : The new random number distribution
	 *            determining the demand (quantity).
	 */
	public void setDemandQuantity(desmoj.core.dist.IntDist newDemandQuantity) {

		this.demandQuantity = newDemandQuantity;
	}
}