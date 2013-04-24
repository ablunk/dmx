package desmoj.core.dist;

import desmoj.core.simulator.Model;

/**
 * Poisson distributed stream of pseudo random integer numbers. The distribution
 * specified by one parameter describing the mean value.
 * 
 * @version DESMO-J, Ver. 2.3.5 copyright (c) 2013
 * @author Tim Lechler
 * @author Ruth Meyer
 * @deprecated Replaced by DiscreteDistPoisson
 * 
 *             Licensed under the Apache License, Version 2.0 (the "License");
 *             you may not use this file except in compliance with the License.
 *             You may obtain a copy of the License at
 *             http://www.apache.org/licenses/LICENSE-2.0
 * 
 *             Unless required by applicable law or agreed to in writing,
 *             software distributed under the License is distributed on an
 *             "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *             either express or implied. See the License for the specific
 *             language governing permissions and limitations under the License.
 * 
 */
@Deprecated
public class IntDistPoisson extends DiscreteDistPoisson implements IntDist {

	public IntDistPoisson(Model owner, String name, double meanValue,
			boolean showInReport, boolean showInTrace) {
		super(owner, name, meanValue, showInReport, showInTrace);
	}

}