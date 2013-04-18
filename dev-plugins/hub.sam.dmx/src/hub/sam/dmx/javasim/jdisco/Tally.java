/*
  File: Tally.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class can be used for collecting <i>time independent</i> data, 
 * e.g. the  average number of items bought by customers in a supermarket.
 * <p>
 * Example of use:
 * <pre><tt>
 *     class Customer extends Process {
 *         static Tally tt = new Tally("Thru times");<br>
 *
 *         public void actions() {
 *             double arrivalTime = time();
 *             <i>do shopping</i>;
 *             tt.update(time() - arrivalTime);
 *         }
 *     }
 * </tt></pre>
 * A typicial report:
 * <br><pre><tt>
 * title       /  (re)set/   obs/  average/est.st.dv/  minimum/  maximum/    conf./
 *   Thru times     0.000           18.379    12.576     4.612    38.664     6.438</tt></pre>
 * may be obtained by executing the following code at the end of the simulation:<br> 
 * <pre><tt>
 *       Customer.tt.printHeading();
 *       Customer.tt.report(); 
 * </tt></pre>
 * <p>
 * The last column reports the 95% confidence interval half-width. In the example above 
 * the average number of customers in the shop is 18.379 ± 6.438 with a confidence level of 95%.
 *
 * @see jDisco.Tab
 */
public class Tally extends Tab {
    /**
     * The constructor. An object is instantiated with a title. 
     * The length of the title is curtailed to 12 characters  
     * should it be longer.
     *
     * @param <tt>title</tt> the title.
     */
    public Tally(String title) {
        super(title);
    }
    
    /**
     * Resets the object.
     */
    public void reset() {
        obs = 0;
        sum = sumsq = min = max = 0;
        resetAt = Process.time();
    }
    
    double sum,     // the sum of input values since resetAt
           sumsq,     // the sum the squares of input since resetAt
           min,        // the least input value since resetAt 
           max;        // the largest input value since resetAt
    
    /**
     * Records a new entry.
     *
     * @param <tt>v</tt> the value.
     */
    public void update(double v) {
        obs++;
        sum += v;
        sumsq += v * v;
        if (obs == 1)
            min = max = v;
        else if (v < min)
            min = v;
        else if (v > max)
            max = v;
    }
    
    /**
     * Prints on one-line  title, reset time, number of observations, minimum,
     * maximum, mean, standard deviation, and 95% confidence value.
     */
    public void report() {
        writeTRN();
        if (obs == 0) 
            System.out.print(minuses.substring(0,40));
        else {
            printDouble(mean());
            printDouble(stdDev());
            printDouble(min);
            printDouble(max);
            printDouble(confidence()); 
        }
        System.out.println();
    }    
    
    /**
     * Returns the least sample value.
     */
    public double min() { 
        return min; 
        
    }
    
    /**
     * Returns the largest sample value.
     */
    public double max() { 
        return max; 
    }
    
    /**
     * Returns the mean.
     */
    public double mean() {
        if (obs == 0)
            return 0;
        return sum / obs;
    }
    
    /**
     * Returns the variance.
     */
    public double variance() {
        return Math.abs((sumsq - sum * sum / obs) / obs);
    }
    
    /**
     * Returns the standard deviation.
     */
    public double stdDev() {
        return Math.sqrt(variance());
    }
   
    /**
     * Returns the confidence interval half-width for a level between 0 and 1.
     *  
     * @param <tt>level</tt> the level, eg. 0.95.
     */ 
    public double confidence(double level) {
        int df = obs - 1;
        double t = tValue((1 - level) / 2, df);
        if (t == Double.MAX_VALUE)
            return t;
        return (t * stdDev()) / Math.sqrt(df);
    }
    
    /**
     * Returns the confidence interval half-width for the default level (0.95).
     */
    public double confidence() {
        return confidence(0.95);
    }
    
    /**
     * Returns the upper pth quantile of the t distribution.
     *
     * @param <tt>p</tt> significance value.
     * @param <tt>df</tt> degrees of freedom.
     * @return the pth quantile.
     *
     * Converted from Dirk Grunwald's C++ code:<br>
     * www.mit.edu/afs/athena/astaff/reference/4.3network2/lib/libg++/libg++/SmplStat.cc
     */
    double tValue(double p, int df) {
        p = p >= 0.5 ? 1 - p : p;
        if (p <= 0 || df == 0)
            return Double.MAX_VALUE;
        if (p == 0.5)
            return 0;
        double t;
        if (df == 1)
            t = 1 / Math.tan((p + p) * 1.57079633);
        else if (df == 2)
            t = Math.sqrt(1 / ((p + p) * (1 - p)) - 2);
        else {
            double a = Math.sqrt(Math.log(1 / (p * p)));
            double aa = a * a;
            a -= (2.515517 + (0.802853 * a) + (0.010328 * aa)) / 
                 (1.0 + (1.432788 * a) + (0.189269 * aa) + (0.001308 * aa * a));
            t = df - 0.666666667 + 1.0 / (10.0 * df);
            t = Math.sqrt (df * (Math.exp (a * a * (df - 0.833333333) / (t * t)) - 1.0));
        }
        return Math.abs(t);
    } 
}