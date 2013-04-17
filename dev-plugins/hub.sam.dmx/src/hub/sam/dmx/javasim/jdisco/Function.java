/*
  File: Function.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * The solution of higher-order differential equations normally requires that 
 * the user rewrites the system as first-order equations. 
 * The class <tt>Function</tt> frees the user from this task.
 * <p>
 * A <tt>Function</tt>-object represents a variable whose continuous change 
 * can be described by an n'th order differential equation. 
 * The <tt>d</tt> array of an object contains the derivatives; 
 * <tt>d(i).state</tt> contains the i'th derivative
 * (<tt>d(0).state</tt> contains the function value itself). 
 * <p>
 * <tt>d(i).rate</tt> should not be used by the user.
 * <p>
 * Example:
 * <br>
 * <br> The second-order equation of Van der Pol:
 * <br><pre>
 *      d<sup>2</sup>y/dt<sup>2</sup> + E(1-y<sup>2</sup>)dy/dt + y = 0
 * </pre>
 * may be represented by: 
 * <br><pre><tt> 
 *      y.d(2).state = - E * (1 - Math.pow(y.d(0).state, 2)) * y.d(1).state
 *                     - y.d(0).state;
 * </tt></pre>
 * where <tt>y</tt> is a <tt>Function</tt>-object with <tt>n</tt> = 2. 
 * <p>
 * Note that <tt>y</tt> must be <tt>start</tt>ed to undergo continuous change. 
 */
public class Function extends Continuous {
    /**
     * Constructs a n'th order <tt>Function</tt>-object.
     */
    public Function(int n) {
        if (n <= 0)
            Process.error("new Function(n): n <= 0");
        this.n = n;
        d = new Variable[n + 1];
        for (int i = 0; i <= n; i++)
            d[i] = new Variable(0);
        setPriority(Double.MIN_VALUE);
    }
    
    /**
     * Starts the continuous change of this function.
     *
     * @return <tt>this</tt>.
     */
    public Continuous start() {
        for (int i = 0; i < n; i++)
            d[i].start();
        super.start();
        return this;
    }
    
    /**
     * Stops the continuous change of this function.
     */
    public void stop() {
        for (int i = 0; i < n; i++)
            d[i].stop();
        super.stop();
    }
    
    /**
     * Returns the i'th derivative
     */
    public Variable d(int i) {
        return d[i];
    }
    
    /**
     * Computes derivatives of n internal variables. 
     */
    protected final void derivatives() {
        for (int i = 1; i <= n; i++)
            d[i-1].rate = d[i].state;        
    }
    
    private int n;            // the order
    private Variable[] d;    // table of derivatives
}