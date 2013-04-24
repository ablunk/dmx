package desmoj.extensions.dimensions;

import desmoj.core.simulator.Units;

/**
 * An abstract base class for physical quantities with a unit (e.g. Length,
 * Velocity, etc.).
 * 
 * @version DESMO-J, Ver. 2.3.5 copyright (c) 2013
 * @author Nick Knaak and Ruth Meyer
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
public abstract class Quantity implements Units, Comparable {

	/** The quantity's numerical value */
	protected double value;

	/** The quantity's unit (@see desmoj.Units) */
	protected int unit;

	/**
	 * Creates a new Quantity with the given value and unit. If the unit is
	 * invalid a quantity with value 0.0 and the default unit is created.
	 */
	public Quantity(double value, int unit) {
		if (isValidUnit(unit) && isValidValue(value)) {
			this.value = value;
			this.unit = unit;
		} else {
			this.value = 0.0;
			this.unit = defaultUnit();
		}
	}

	/** Creates an "empty" quantity with value 0.0 and the default unit. */
	public Quantity() {
		this.value = 0.0;
		this.unit = defaultUnit();
	}

	/**
	 * Returns the numerical value of this quantity in terms of the specified
	 * unit. Value and unit of this quantity object remain unchanged.
	 * 
	 * @param unit
	 *            int : the unit as one of the constants of the interface
	 *            {@link desmoj.core.simulator.Units Units}
	 * @return the value converted to the specified unit (or Double.NaN if the
	 *         unit is invalid for this quantity)
	 */
	public double getValue(int unit) {
		if (!isValidUnit(unit))
			return Double.NaN;
		else
			return value * unitFactors[this.unit] / unitFactors[unit];
	}

	/** Returns the numerical value in the current unit as a double */
	public double getValue() {
		return value;
	}

	/**
	 * Should return true if this unit is valid for a certain subclass of
	 * Quantity (e.g. MM, CM, M, etc. for Length).
	 */
	public abstract boolean isValidUnit(int unit);

	/** Returns this quantities default unit. */
	public abstract int defaultUnit();

	/**
	 * Returns true if a given value is valid for this quantity and false
	 * otherwise. The default implementation returns true for non-negative
	 * values only.
	 */
	public boolean isValidValue(double value) {
		return value >= 0.0;
	}

	/**
	 * Returns the unit of this quantity as one of the constants of the
	 * interface {@link desmoj.core.simulator.Units Units}
	 */
	public int getUnit() {
		return unit;
	}

	/**
	 * Changes this quantity's unit to the given unit. If an invalid unit is
	 * specified the old unit remains unchanged.
	 * 
	 * @param unit
	 *            int : the new unit to which this quantity shall be converted
	 */
	public void setUnit(int unit) {
		if (unit == this.unit || !isValidUnit(unit))
			return;
		this.value = this.value * unitFactors[this.unit] / unitFactors[unit];
		this.unit = unit;
	}

	/**
	 * Returns a string representation of the quantity with at most
	 * <tt>floats</tt> decimals.
	 */
	public String toString(int floats) {
		String s = Double.toString(value);
		if (value > 10E7)
			return s + " " + Units.unitStrings[unit];
		int decimalPoint = s.lastIndexOf(".");

		if (decimalPoint <= 0)
			return s;
		else {
			if (floats == 0)
				return s.substring(0, decimalPoint) + " "
						+ Units.unitStrings[unit];
			if ((floats + 1) >= (s.length() - decimalPoint))
				return s + " " + Units.unitStrings[unit];
			else
				return s.substring(0, decimalPoint + floats + 1) + " "
						+ Units.unitStrings[unit];
		}
	}

	/** Returns a string representation of this quantity (=<value><unit>) */
	public String toString() {
		return this.value + " " + unitStrings[this.unit];
	}

	/**
	 * Compares this quantity with the given object. If <code>that</code> is
	 * of type Quantity the comparison results in: -1 : if this < that 0 : if
	 * this == that 1 : if this > that
	 * 
	 * @throws ClassCastException
	 *             if <code>that</code> is not a Quantity object
	 */
	public int compareTo(Object that) {
		Quantity other = (Quantity) that; // throws ClassCastException
		// eventually
		double otherValue = other.getValue(this.unit);
		if (this.value < otherValue) {
			return -1;
		}
		if (this.value > otherValue) {
			return 1;
		}
		return 0;
	}
}