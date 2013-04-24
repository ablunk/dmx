package desmoj.extensions.dimensions;

import desmoj.core.simulator.Units;

/**
 * This class represents lengths. As lengths are quantities each length consists
 * of a numerical value and a unit. Only the length units specified in the
 * {@link desmoj.core.simulator.Units Units}interface are supported. The value
 * may not be negative.
 * 
 * @version DESMO-J, Ver. 2.3.5 copyright (c) 2013
 * @author Ruth Meyer and Nick Knaak
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
public class Length extends Quantity {

	/**
	 * Constructs a new length with default values (0.0 m).
	 */
	public Length() {
		super();
	}

	/**
	 * Constructs a new length with the given value und unit. If the value or
	 * the unit are invalid a default length will be constructed.
	 * 
	 * @param value
	 *            double : the length's numerical value (must be >= 0.0)
	 * @param unit
	 *            int : the length's unit as one of the constants of the
	 *            interface {@link desmoj.core.simulator.Units Units}
	 */
	public Length(double value, int unit) {
		super(value, unit);
	}

	/** Returns the default unit (<code>Units.M</code>) */
	public int defaultUnit() {
		return Units.M;
	}

	/**
	 * Checks if the given unit is a valid length unit. Returns
	 * <code>true</code> for MM, CM, M, KM and <code>false</code> otherwise
	 */
	public boolean isValidUnit(int unit) {
		return !(unit < Units.MM || unit > Units.KM);
	}

	/**
	 * Adds 2 length objects. Returns a new length with value this.value +
	 * length.value. This length' value is not changed.
	 * 
	 * @param length
	 *            the Length object to be added to this length
	 */
	public Length add(Length length) {
		return new Length(this.value + length.getValue(this.unit), this.unit);
	}

	/**
	 * Subtracts 2 length objects. Returns a new length with value this.value -
	 * length.value. This length' value is not changed.
	 * 
	 * @param length
	 *            the Length object to be subtracted to this length
	 */
	public Length subtract(Length length) {
		return new Length(this.value - length.getValue(this.unit), this.unit);
	}

} /* end of class Length */