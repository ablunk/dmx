package desmoj.core.dist;

import desmoj.core.simulator.Model;

/**
 * Integer constant "pseudo"-distribution returns a single constant predefined
 * long value. This "distribution" is most useful for testing purposes. The
 * value to be returned can be specified at construction time.
 * 
 * @see desmoj.core.dist.Distribution
 * 
 * @version DESMO-J, Ver. 2.3.5 copyright (c) 2013
 * @author Tim Lechler
 * @deprecated Replaced by DiscreteDistConstant
 * 
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
public class IntDistConstant extends DiscreteDistConstant<Long> implements IntDist {

	/**
	 * Creates a constant integer "pseudo" distribution with the constant values
	 * given as parameter.
	 * 
	 * @param owner
	 *            Model : The distribution's owner
	 * @param name
	 *            java.lang.String : The distribution's name
	 * @param constantValue
	 *            long : The constant <code>long</code> value produced by this
	 *            distribution
	 * @param showInReport
	 *            boolean : Flag for producing reports
	 * @param showInTrace
	 *            boolean : Flag for producing trace output
	 */
	public IntDistConstant(Model owner, String name, long constantValue,
			boolean showInReport, boolean showInTrace) {
		super(owner, name, constantValue, showInReport, showInTrace);
	}

}