package desmoj.core.dist;

import desmoj.core.simulator.Model;

/**
 * Empirically distributed stream of pseudo random numbers of type
 * <code>double</code>. Values produced by this distribution follow an empirical
 * distribution which is specified by entries consisting of the observed value
 * and the frequency (probability) this value has been observed to occur. These
 * entries are made by using the <code>addEntry()</code> method. There are a few
 * conditions a user has to meet before actually being allowed to take a sample
 * of this distribution.
 * 
 * @see desmoj.core.dist.Distribution
 * 
 * @version DESMO-J, Ver. 2.3.5 copyright (c) 2013
 * @author Tim Lechler
 * @deprecated Replaced by ContDistEmpirical
 * 
 *         Licensed under the Apache License, Version 2.0 (the "License"); you
 *         may not use this file except in compliance with the License. You may
 *         obtain a copy of the License at
 *         http://www.apache.org/licenses/LICENSE-2.0
 * 
 *         Unless required by applicable law or agreed to in writing, software
 *         distributed under the License is distributed on an "AS IS" BASIS,
 *         WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *         implied. See the License for the specific language governing
 *         permissions and limitations under the License.
 * 
 */
@Deprecated
public class RealDistEmpirical extends ContDistEmpirical implements RealDist {

	public RealDistEmpirical(Model owner, String name, boolean showInReport,
			boolean showInTrace) {

		super(owner, name, showInReport, showInTrace);

	}

}