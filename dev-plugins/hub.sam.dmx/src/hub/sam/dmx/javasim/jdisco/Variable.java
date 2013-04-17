/*
  File: Variable.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001   	kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class is used to represent state variables that vary between 
 * discrete events according to ordinary first-order differential equations 
 * and/or difference equations.
 * <p>
 * These equations are expressed in subclasses of class <tt>Continous</tt>.
 *
 * @see jDisco.Continuous 
 */
public class Variable extends Link {
    /** 
     * The current value of the variable.
     */    
    public double state;
    
    /**
     * The derivative with respect to time.
     */
    public double rate;
    
    /**
     * Contructs a variable with an initial value of <tt>initialState</tt>.
     *
     * @param <tt>initialState</tt> the initial value.
     */
    public Variable(double initialState) {
        state = oldState = initialState;
    }
    
    /**
     * Tests if this variable is active.
     *
     * @return <tt>true</tt> if the variable is currently 
     * in the list of active variables; <tt>false</tt> otherwise.
     */    
    public boolean isActive() {
        return pred != null;
    }
    
    /**
     * Starts this variable.
     * <p>
     * The object is inserted into the list of active <tt>Variable</tt>-objects.
     * <p>
     * Calling <tt>start</tt> when the object is already active has no effect. 
     * Note that each <tt>Variable</tt>-object is inactive until its 
     * <tt>start</tt>-method has been called.
     * <p>
     * <tt>start</tt> may only be called by a discrete process. 
     * Violating this rule leads to the error message
     * <pre> 
     * <tt>    Illegal call of start (class Variable)</tt></pre>
     * after which the simulation is stopped. 
     * <p>
     * <tt>start</tt> returns a reference to this <tt>Variable</tt>-object. 
     * This allows the user to write as follows:
     * <pre> 
       * <tt>    Variable v = new Variable(1234).start();</tt></pre>
       *
     * @return <tt>this</tt>
     */
    public Variable start() {
        if (Process.monitor.active) 
            Process.error("Illegal call of start (class Variable)");
        if (pred == null) {
            if (Process.monitor.firstVar == null) 
                Process.monitor.firstVar = pred = this;
            else {
                suc = Process.monitor.firstVar;
                pred = this;
                Process.monitor.firstVar.pred = this;
                Process.monitor.firstVar = this;
            }
        }
        return this;
    }
    
    /** 
     * Stops this variable.
     * <p>
     * <tt>stop</tt> removes the object from the list of active <tt>Variable</tt>-objects. 
     * <p>
     * Calling <tt>stop</tt> has no effect unless the object is active. 
     * <p>
     * <tt>stop</tt> may only be called by a discrete process. 
     * Violating this rule leads to the error message 
     * <pre>
     * <tt>    Illegal call of stop (class Variable)</tt></pre>
     * after which the simulation is stopped. 
     */    
    public void stop() {
        if (Process.monitor.active) 
            Process.error("Illegal call of stop (class Variable)");
        if (pred != null) {
            if (pred != this)
                pred.suc = suc;
            else
                Process.monitor.firstVar = pred = suc;
            if (suc != null) {
                suc.pred = pred;
                suc = null;
            }
            pred = null;
            rate = 0;
        }
    }
    
    /**
     * Returns the value of <tt>state</tt> at the starting point of the 
     * current step. 
     * <p>
     * <tt>lastState</tt> may be used to describe continuous changes 
     * defined by difference equations.
     */
    public double lastState() {
        return oldState;
    }
    
    double oldState, nextState,
           k1, k2, k3, k4, k5, k6, k7, k8,
           ds, dsh;
    double[] phi = new double[Process.monitor instanceof AdamsBashforth ? 
                              AdamsBashforth.MAXORDER + 3 : 0];
           
    /**
     * <tt>pred</tt> and <tt>suc</tt> denote the object's predecessor 
     * and successor, respectively, in the list of active<tt>Variable</tt>-objects. 
     * When the object is not in this list, <tt>pred</tt> and <tt>suc</tt> 
     * both have the value <tt>null</tt>.
     * <p>
     * If the object is the first object of the list, then <tt>pred</tt> points 
     * to the object itself, that is, <tt>pred == this</tt>. 
     * <p>
     * The last object of the list has no successor, <tt>suc</tt> == null</tt>. 
     */
    Variable pred, suc;    
}
