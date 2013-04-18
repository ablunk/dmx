/*
  File: IDelay.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class may be used to describe ideal delays.<br> 
 * <br>
 * The <tt>state</tt> of an active <tt>IDelay</tt>-object lags behind
 * a given <tt>target</tt>'s <tt>state</tt> with a specified delay,
 * <tt>lag</tt>.<br>
 * <br>
 * The <tt>target</tt> may itself be moving.<br>
 * <br>
 * During the first <tt>lag</tt> time units of an <tt>IDelay</tt>-object's 
 * existence its <tt>state</tt> is equal to <tt>target</tt>'s <tt>state</tt> at the 
 * creation of the <tt>IDelay</tt>-object.<br>
 * <br>
 * An <tt>IDelay</tt>-object stores samples of <tt>target</tt>'s 
 * <tt>state</tt> at the end of each integration step and interpolates 
 * linearly between sampled values. 
 */
public class IDelay extends Variable {
    /**
     * The contructor. 
     *
     * @param <tt>target</tt> the target variable.
     * @param <tt>lag</tt> the delay. 
     */
    public IDelay(Variable target, double lag) {
        super(0); 
        if (target == null)
            Process.error("new IDelay(target, ): target == null");
        if (lag < 0)
            Process.error("new IDelay( , lag): lag < 0");
        this.target = target;
        this.lag = lag;
        table = new Table();
        table.add(target);
        myStateUpdater = new StateUpdater();
        myStateUpdater.setPriority(Double.MAX_VALUE);
        myTableUpdater = new TableUpdater();
        state = target.state;
    }
    
    /**
     * Starts the persuit.
     *
       * @return <tt>this</tt>.
     */
    public Variable start() {
        super.start();
        myStateUpdater.start();
        myTableUpdater.start();
        return this;
    }
    
    /**
     * Stops the persuit.
     */
    public void stop() {
        super.stop();
        myStateUpdater.stop();
        myTableUpdater.stop();
    }
    
    /**
     * Inner class for updating <tt>state</tt>.
     */
    private class StateUpdater extends Continuous {
        protected void derivatives() {
            state = table.value(Process.time() - lag);
        }
    }
    
    /**
     * Inner class for updating the table of sampled values.
     */
    private class TableUpdater extends Reporter {
        protected void actions() {
            if (Process.time() > Process.lastTime()) {
                table.add(target);
                while (((Table.Entry) table.entries.first()).x < Process.time() - lag)
                    table.entries.first().out();
                table.left = table.right = (Table.Entry) table.entries.first();
                state = table.value(Process.time() - lag);
            }
        }
    }
    
    private Variable target;                // the target
    private double lag;                        // the delay
    private Table table;                    // table of sampled values
    private StateUpdater myStateUpdater;    // the associated state updater        
    private TableUpdater myTableUpdater;    // the assocaited table updater
}