package desmoj.extensions.dimensions;

import desmoj.core.simulator.Units;

/**
 * @deprecated Replaced by desmoj.core.simulator.TimeSpan
 * 
 * This class represents durations (time spans). Each duration consists of a
 * numerical value and a time unit. Only the time units specified in the
 * {@link desmoj.core.simulator.Units Units}interface are supported. The value
 * may not be negative.
 * 
 * @version DESMO-J, Ver. 2.3.5 copyright (c) 2013
 * @author Ruth Meyer, Nick Knaak
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
@Deprecated
public class Duration extends Quantity {

	/**
	 * Constructs a new duration with default values (0.0 s).
	 */
	public Duration() {
		super();
	}

	/**
	 * Constructs a new duration with the given value und unit. If the value or
	 * the unit are invalid a default duration will be constructed.
	 * 
	 * @param value
	 *            double : the duration's numerical value
	 * @param unit
	 *            int : the duration's unit as one of the constants of the
	 *            interface {@link desmoj.core.simulator.Units Units}
	 */
	public Duration(double value, int unit) {
		super(value, unit);
	}

	/**
	 * Checks if the given unit is a valid time unit. Returns <code>true</code>
	 * if the given unit is MS, S, MIN or H and <code>false</code> otherwise
	 */
	public boolean isValidUnit(int unit) {
		return !(unit < MS || unit > H);
	}

	/** Returns the default unit (<code>Units.S</code>) */
	public int defaultUnit() {
		return Units.S;
	}

} /* end of class Duration */