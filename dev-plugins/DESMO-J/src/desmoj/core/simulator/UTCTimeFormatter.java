package desmoj.core.simulator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Use this class to format TimeInstant objects using a java.text.DateFormat object.
 * The UTCTimeFormatter uses a MultiUnitTimeFormatter to format TimeSpans.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Felix Klueckmann
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
public class UTCTimeFormatter implements TimeFormatter {
	/**
	 * The DateFormat used by this TimeFormatter
	 */
	private DateFormat myDateFormat;
	private MultiUnitTimeFormatter myMultiUnitTimeFormatter;

	/**
	 * Constructor for a UTCTimeFormatter. This shortcut constructor uses the
	 * pattern "dd.MM.yyyy HH:mm:ss:SSS". Default Locale is Germany.
	 */
	public UTCTimeFormatter() {
		this(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss:SSS",Locale.GERMANY),TimeUnit.DAYS,TimeUnit.MILLISECONDS);
	}

	/**
	 * Constructor for a UTCTimeFormatter.
	 * 
	 * @param dateFormat
	 *            DateFormat : the dateFormat used by this UTCTimeFormatter.
	 * @param coarsestUnit
	 *          		TimeUnit: The coarsest Unit for the TimeSpan
	 * @param finestUnit
	 *   				TimeUnit: The finest Unit for the TimeSpan
	 */
	public UTCTimeFormatter(DateFormat dateFormat, TimeUnit coarsestUnit, TimeUnit finestUnit ) {
		this.myDateFormat = dateFormat;
		this.myMultiUnitTimeFormatter= new MultiUnitTimeFormatter(coarsestUnit, finestUnit);
	}

	/**
	 * Constructor for a UTCTimeFormatter. Default Locale is Germany.
	 * 
	 * @param pattern
	 *            String : the pattern used by this UTCTimeFormatter to format
	 *            TimeSpan and TimeInstant objects.
	 *             @param coarsestUnit
	 *          		TimeUnit: The coarsest Unit for the TimeSpan
	 * @param finestUnit
	 *   				TimeUnit: The finest Unit for the TimeSpan
	 */
	public UTCTimeFormatter(String pattern,TimeUnit coarsestUnit, TimeUnit finestUnit ) {
		this(new SimpleDateFormat(pattern,Locale.GERMANY),coarsestUnit, finestUnit);
	}
	
	/**Returns the String-Representation of the given TimeInstant.
	 *  
	 */
	public String buildTimeString(TimeInstant instant) {

		return myDateFormat.format(new Date(instant.getTimeTruncated(TimeUnit.MILLISECONDS)));
	}
	
	/**Returns the String-Representation of the given TimeSpan.
	 *  
	 */
	public String buildTimeString(TimeSpan span) {
		return myMultiUnitTimeFormatter.buildTimeString(span);
	}

}
