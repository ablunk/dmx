/*
  File: ExpDelay.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class may be used to describe exponential delays of arbitrary order. 
 * The order of the delay, <tt>n</tt>, is the number of cascaded first-order
 * delays that compose the delay in question.
 * <p>
 * The <tt>state</tt> of an active <tt>ExpDelay</tt>-object continuously
 * approaches the <tt>target</tt>'s <tt>state</tt> with the specified delay,
 * <tt>lag</tt>.
 * <p>
 * The <tt>target</tt> may itself be moving.
 */
public class ExpDelay extends Variable {
    /**
     * The contructor. 
     *
     * @param <tt>n</tt> the order.
     * @param <tt>initialState</tt> the initial value of the delay.
     * @param <tt>target</tt> the target variable.
     * @param <tt>lag</tt> the delay. 
     */
    public ExpDelay(int n, double initialState, Variable target, double lag) {
        super(initialState);
        if (n <= 0)
            Process.error("new ExpDelay( n, , , ): n <= 0");
        if (target == null)
            Process.error("new ExpDelay( , , target, ): target == null");
        if (lag <= 0)
            Process.error("new ExpDelay( , , , lag): lag <= 0");    
        this.n = n;
        this.lag = lag;
        r = new Variable[n + 1];
        r[0] = target;
        for (int i = 1; i <= n; i++)
            r[i] = new Variable(initialState);
        myMover = new Mover();
    }
    
    /**
     * Starts the persuit.
     *
     * @return <tt>this</tt>.
     */
    public Variable start() {
        for (int i = 1; i <= n; i++)
            r[i].start();
        super.start();
        myMover.start();
        return this;
    }
    
    /**
     * Stops the persuit.
     */
    public void stop() {
        for (int i = 1; i <= n; i++)
            r[i].stop();
        super.stop();
        myMover.stop();
    }
    
    /**
     * Inner class describing the <tt>n</tt> cascaded first-order delays. 
     */
    private class Mover extends Continuous {
        protected void derivatives() {
            for (int i = 1; i <= n; i++)
                r[i].rate = (r[i - 1].state - r[i].state) / lag * n;
            state = r[n].state;
            rate = r[n].rate;
        }
    }
    
    private int n;                // the order
    private double lag;           // the delay
    private Variable[] r;         // table of n+1 variables
    private Mover myMover;        // the assocociated continuous process        
}