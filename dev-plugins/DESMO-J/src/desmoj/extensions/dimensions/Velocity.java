package desmoj.extensions.dimensions;

import desmoj.core.simulator.Units;

/**
 * This class represents velocities (speeds). Each velocity consists of a
 * numerical value and a unit. Only the speed units specified in the
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
public class Velocity extends Quantity {

	/**
	 * Constructs a new velocity with default values (0.0 km/h).
	 */
	public Velocity() {
		super();
	}

	/**
	 * Constructs a new velocity with the given value und unit. If the value or
	 * the unit are invalid a default velocity will be constructed.
	 * 
	 * @param value
	 *            double : the velocity's numerical value
	 * @param unit
	 *            int : the velocity's unit as one of the constants of the
	 *            interface {@link desmoj.core.simulator.Units Units}
	 */
	public Velocity(double value, int unit) {
		super(value, unit);
	}

	/**
	 * Constructs a new velocity by computing a value out of the given length
	 * (in km) and duration (in h). The unit will therefore be set to the
	 * default unit km/h.
	 * 
	 * @param distance
	 *            Length : the length value
	 * @param time
	 *            Duration : the duration value
	 */
	public Velocity(Length distance, Duration time) {
		this(distance.getValue(KM) / time.getValue(H), Units.KM_H);
	}

	/**
	 * Checks if the given unit is a valid length unit. Returns
	 * <code>true</code> for m/s and km/h, <code>false</code> otherwise
	 */
	public boolean isValidUnit(int unit) {
		return !(unit < M_S || unit > KM_H);
	}

	/** Returns the default unit (<code>Units.KM_H</code>) */
	public int defaultUnit() {
		return Units.KM_H;
	}

} /* end of class Velocity */