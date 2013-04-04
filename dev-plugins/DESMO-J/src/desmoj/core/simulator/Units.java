package desmoj.core.simulator;

/**
 * The interface Units provides constants for representing units for time,
 * length and speed. Additionally, textual representations for these units and
 * conversion factors are given.
 * <p>
 * Any class implementing this interface gains direct access to all defined
 * constants. It is recommended to use this interface in every class that has to
 * represent values with units.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Ruth Meyer
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
public interface Units {

	// Konstanten deklarieren für Zeit-Einheiten

	/** The time unit milliseconds. */
	public static final int MS = 0;

	/** The time unit seconds. */
	public static final int S = 1;

	/** The time unit minutes. */
	public static final int MIN = 2;

	/** The time unit hours. */
	public static final int H = 3;

	// Konstanten deklarieren für Längen-Einheiten

	/** The length unit millimetres. */
	public static final int MM = 4;

	/** The length unit centimetres. */
	public static final int CM = 5;

	/** The length unit metres. */
	public static final int M = 6;

	/** The length unit kilometres. */
	public static final int KM = 7;

	// Konstanten deklarieren für Geschwindigkeits-Einheiten

	/** The speed unit metres/second. */
	public static final int M_S = 8;

	/** The speed unit kilometres/hour. */
	public static final int KM_H = 9;

	// Konstanten für textuelle Repräsentation der Einheiten

	/**
	 * Textual representations for the defined units. To get the appropriate
	 * unit String use the unit constant as an index. For example:
	 * <code>Units.unitStrings[Units.MIN]</code> gives "min".
	 */
	public static final String[] unitStrings = { "ms", "s", "min", "h", "mm",
			"cm", "m", "km", "m/s", "km/h" };

	// Konstanten für Umrechungsfaktoren

	/**
	 * Conversion factors to convert between units. To get the appropriate unit
	 * factor use the unit constant as an index. For example:
	 * <code>Units.unitFactors[Units.MIN]</code> gives 60000.
	 * <p>
	 * To convert a value from an old unit to a new unit multiply the value with
	 * the factor for the old unit and divide by the factor for the new unit.
	 * Example: <code>value * unitFactors[oldUnit] / unitFactors[newUnit]</code>
	 * <p>
	 * Note that these factors of course only make sense when used for units of
	 * the same phenomenon, so you should never attempt to convert a time unit
	 * into a length unit, for example.
	 */
	public static final double[] unitFactors = { 1, 1000, 60000, 3600000, 1,
			100, 1000, 1000000, 1, 1000 / 3600.0 };
}