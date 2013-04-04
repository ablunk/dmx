package desmoj.core.dist;

/**
 * Superclass for all distributions returning boolean samples. Use this class
 * instead of a specific distribution if the special distribution function is
 * supposed to be specified in subclasses or changed dynamically. Extend this
 * abstract class to define your special function boolean distribution.
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
public abstract class BoolDist extends Distribution {
	/**
	 * Constructs a distribution returning boolean samples. Note that the method
	 * returning the boolean samples has to be implemented in subclasses.
	 * 
	 * @param owner
	 *            Model : The distribution's owner
	 * @param name
	 *            java.lang.String : The distribution's name
	 * @param showInreport
	 *            boolean : Flag to show distribution in report
	 * @param showInTrace
	 *            boolean : Flag to show distribution in trace
	 */
	public BoolDist(desmoj.core.simulator.Model owner, String name,
			boolean showInReport, boolean showInTrace) {
		super(owner, name, showInReport, showInTrace);
	}

	/**
	 * Abstract method should return the specific sample as a boolean value when
	 * implemented in subclasses.
	 * 
	 * @return boolean : The boolean sample to be drawn from this distribution
	 */
	public abstract boolean sample();
}