/*
  File: Histogram.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class can be used for collecting <i>time independent</i> data
 * and for producing a graphical representation of the collected data.
 * <p>
 * A histogram object records a rough  profile  of  a  sequence  of  real
 * values,  by  asking  in advance for their (expected) lower bound,
 * <tt>lower</tt>, and upper bound, <tt>upper</tt>;  and also for the number 
 * of  recording cells, <tt>ncells</tt>. The range [<tt>lower</tt>;<tt>upper</tt>[ 
 * is divided into <tt>ncell</tt> cells, each of the same width.
 * <p>
 * Example of use:<br>
 * <pre><tt>
 *     class HouseOnFire extends Process {
 *         static Histogram perDamage = new Tally("Perc.damage", 0, 100, 20);
 *
 *         public void actions() {
 *             Variable damage = new Variable(size).start();
 *             <i>do burning</i>;
 *             h.update(damage.state * 100 / material);
 *         }
 *     }
 * </tt></pre>
 * A typical report:<br>
 * <pre><tt>                                      
 * title       /  (re)set/   obs/  average/est.st.dv/  minimum/  maximum/    conf./
 * Perc. damage     0.000    138    13.817    13.257     0.062    73.831     2.240
 * 
 * cell/lower lim/    n/   freq/  cum %
 *                                       |----------------------------------------
 *    0 -infinity     0    0.00    0.00  |
 *    1     0.000    16    0.12   11.59  |*****************
 *    2     5.000    38    0.28   39.13  |****************************************
 *    3    10.000    31    0.22   61.59  |*********************************
 *    4    15.000    17    0.12   73.91  |******************
 *    5    20.000    13    0.09   83.33  |**************
 *    6    25.000     4    0.03   86.23  |****
 *    7    30.000     4    0.03   89.13  |****
 *    8    35.000     6    0.04   93.48  |******
 *    9    40.000     2    0.01   94.93  |**
 *   10    45.000     4    0.03   97.83  |****
 *   11    50.000     1    0.01   98.55  |*
 *   12    55.000     0    0.00   98.55  |
 *   13    60.000     0    0.00   98.55  |
 *   14    65.000     0    0.00   98.55  |
 *   15    70.000     0    0.00   98.55  |
 *   16    75.000     2    0.01  100.00  |**
 *   17    80.000     0    0.00  100.00  |
 *   18    85.000     0    0.00  100.00  |
 *   19    90.000     0    0.00  100.00  |
 *                                           **rest of table empty**
 *                                       |----------------------------------------
 * </tt></pre><br>
 * @see jDisco.Tab
 * @see jDisco.Tally
 */
public class Histogram extends Tab {
	/**
	 * The constructor. 
     *
     * @param <tt>title</tt> the title.
     * @param <tt>lower</tt> the lower limit.
     * @param <tt>upper</tt> the upper limit.
     * @param <tt>nCells</tt> the number of cells.
     */
    public Histogram(String title, double lower, double upper, int nCells) {
        super(title);
        if (lower >= upper)
            Process.error("new Histogram: lower >= upper");
        if (nCells < 1)
            Process.error("new Histogram: nCells < 1");
        width = (upper - lower) / nCells;
        limit = nCells + 1;
        this.lower = lower;
        this.upper = upper;
        this.nCells = nCells;
        table = new int[nCells + 2];
        myTally = new Tally(title);
    }
    
    /**
     * Resets the object.
     */
    public void reset() {
        obs = 0;
        for (int cell = 0; cell < limit; cell++) 
            table[cell] = 0;
        resetAt = Process.time();
        if (myTally != null)
            myTally.reset();
    }
    
    /**
     * Records a new entry.
     */
    public void update(double v) {
        obs++;
        myTally.update(v);
        v -= lower;
        int cell;
        if (v < 0)
            cell = 0;
        else {
            cell = (int) Math.round(v / width) + 1;
            if (cell > limit)
                cell = limit;
        }
        table[cell]++;
    }
    
    /**
     * Prints the histogram.
     */
    public void report() {
        printHeading();
        myTally.report();
        System.out.println();
        if (obs == 0)  
            Format.print(System.out, "%21s***no entries recorded***", "");
        else {
            double max = table[0];
            for (int cell = 1; cell <= limit; cell++)
                if (table[cell] > max)
                    max = table[cell];
            double scale = 40 / max;
            System.out.println("cell/lower lim/    n/   freq/  cum %");
            Format.print(System.out, "%38s", "");
            System.out.println("|" + minuses.substring(0, 40)); 
            double sum = 0;
            int occ = 0;
            for (int cell = 0; cell <= limit; cell++) {
                Format.print(System.out, "%4d", cell);
                if (cell == 0) 
                    Format.print(System.out, "%10s", "-infinity");
                else
                    printDouble(lower + (cell - 1) * width);
                int next = table[cell];
                Format.print(System.out, "%6d", next);
                double freq = (double) next / obs;
                Format.print(System.out, "%8.2f", freq);
                sum += freq * 100;
                Format.print(System.out, "%8.2f", sum);
                Format.print(System.out, "%3s", "|");
                if (next > 0) {
                    String t = stars.substring(0, (int) Math.round(scale * next));
                    if (t == null)
                        System.out.print('.');
                    else
                        System.out.print(t);
                }
                System.out.println();
                occ += next;
                if (occ == obs && cell + 3 > limit) {
                    Format.print(System.out, "%42s","");
                    System.out.print("**rest of table empty**");
                    System.out.println();
                    break;
                }
            }
            Format.print(System.out, "%38s", "");
            System.out.println("|" + minuses.substring(0, 40)); 
        }
        System.out.println("\n");    
    }
    
    /**
     * Returns the least sample value.
     */
    public double min() { 
        return myTally.min();         
    }
    
    /**
     * Returns the largest sample value.
     */
    public double max() { 
        return myTally.max(); 
    }
    
    /**
     * Returns the mean.
     */
    public double mean() {
        return myTally.mean();
    }
    
    /**
     * Returns the variance.
     *
     */
    public double variance() {
        return myTally.variance();
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
     * @return the confidence interval half-width. 
     */
    public double confidence(double level) {
        return myTally.confidence(level);
    }
  
    /**
     * Returns the confidence interval half-width for the default level (0.95).
     *  
     * @return the confidence interval half-width. 
     */
    public double confidence() {
        return confidence(0.95);
    }
    
    double lower,         // the lower expected bound for the input values
             upper,         // the upper expected bound for the input values 
             width;        // the widt of each cell
    int nCells;         // the number of recording cells
    final int limit;    // nCells + 1
    int[] table;        // the table in which the input values are recorded
    Tally myTally;        // reference to a local <tt>Tally</tt>-object
}

