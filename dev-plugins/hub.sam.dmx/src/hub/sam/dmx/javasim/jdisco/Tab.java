/*
  File: Tab.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class defines the common core of the data colllection classes 
 * <tt>Accumulate</tt>, <tt>Count</tt>, <tt>Histogram</tt> and <tt>Tally</tt>.
 * <ul>
 * <li><tt>Accumulate</tt> is used to collect <i>time dependent</i> data.</li>
 * <li><tt>Histogram</tt> is used to collect data in histogram.</li>
 * <li><tt>Tally</tt> is used to collect <i>time independent</i> data.</li>
 * </ul>
 * <p>
 * The design and implementation of these classes has been inspired by the 
 * Simula class DEMOS by G. Birtwistle.
 * <p>
 * Reference:<br>
 * Birtwistle, G:<br> 
 * "A System for Discrete Event Modelling on SIMULA".<br>
 * Macmillan Computer Science Series, London 1979.
 * 
 * @see jDisco.Accumulate
 * @see jDisco.Histogram
 * @see jDisco.Tally
 */
abstract public class Tab {
    /**
     * The constructor. An object is instantiated with a title. 
     * The length of the title is curtailed to 12 characters  
     * should it be longer.
     *
     * @param <tt>title</tt> the title
    */
    Tab(String title) {
        if (title.length() > 12)
            title = title.substring(0, 12);
        this.title = title;
    }
    
    /**
     * Returns the title.
     */
    public String title() {
        return title;
    }    
   
    /**
     * Returns the numer of entries (updates) since <tt>resetAt</tt>.
     */
    public int obs() {
        return obs;
    }
    
    /**
     * Returns the time since the object was initiated, or last reset.
     */
    public double resetAt() {
        return resetAt;
    }
    
    /**
     * Abstract method to reset the object.
     */
    abstract void reset();
    
    /**
     * Abstract method to record a new entry.
     *
     * @param <tt>v</tt> the value to be recorded.
     */    
    abstract void update(double v);
    
    /**
     * Abstract method to print the current status.
     */    
    abstract void report();
    
    /**
     * Prints a <tt>double</tt> in fixed format for numbers between 0.1 and
     * 100000, exponential format for large numbers. Trailing zeroes are suppressed.
     * <p>
     * Field width: 10. Precision: 3 digits in fractional part for fixed format,
     * 2 digits in fractional part for exponential format.
     */
    static void printDouble(double x) {
        if (x == 0 || (Math.abs(x) > 0.1 && Math.abs(x) < 1000000))
            Format.print(System.out, "%10.3f", x);
        else 
            Format.print(System.out, "%10.2e", x);
    }
    
    /**
     * Prints the following information on one line:<br>
     * title, reset time, number of observations.
     */
    void writeTRN() {
        Format.print(System.out, "%12s", title);
        printDouble(resetAt);
        Format.print(System.out, "%7d", obs);
    }
    
    /**
     * Prints a heading.
     */
    public static void printHeading() {
        System.out.println(heading);
    }
    
    /**
     * Throws a run-time exception with a specified error
     * message.
     *
     * @param <tt>message</tt> the message.
     * @exception <tt>DiscoException</tt> 
     * always. 
     */    
    static void error(String msg) {
        throw new DiscoException(msg);
    } 
    
    String title;    // user supplied descriptive text
    int obs;        // number of entries since resetAt
    double resetAt;    // time when initiated or reset
    
    static final String heading =
        "title       /  (re)set/   obs/" +          
        "  average/est.st.dv/  minimum/  maximum/    conf./";
    static final String stars   = "*************************************************" +
                                  "*************************************************";
    static final String minuses = "-------------------------------------------------" +
                                  "-------------------------------------------------";
}
