/*
  File: Continuous.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class may be used to describe the continuous processes of a model.
 * <p>
 * The continuous state changes are described in one or more subclasses of class 
 * <tt>Continuous</tt>, so that objects of these subclasses through their
 * <tt>derivatives</tt> method compute the current values or derivatives of 
 * state variables.
 * <p>
 * Example:<br>
 * <pre><tt>
 *    class Dymamics extends Continuous {
 *        public void derivatives() {
 *            x.rate = -x.state * time();
 *        }
 *    }
 * </tt></pre>   
 * <p>
 * It is the user's responsibility to make sure that the sequence of these computations 
 * is correct so that the quantities involved always reflect the current state of the model. 
 * Sometimes the sequence may be decisive for correct model behaviour. 
 * This applies for example when a <tt>Variable</tt>-object's <tt>rate</tt> appears on 
 * the right-hand side of an assignment statement. 
 * Execution of the active continuous processes is governed by a sequence of decreasing 
 * priorities (high-value-first). 
 * Processes with equal priorities are executed according to when they became active 
 * (earliest-first).
 * <p>
 * Only continuous changes may be described with class <tt>Continuous</tt>. 
 * All discrete state changes should be handled by discrete processes 
 * (<tt>Process</tt>-objects).
 * <p>
 * Since <tt>Continuous</tt> is a subclass of <tt>Link</tt>, 
 * every continuous process has the capability of being a member of a two-way list.
 *   
 * @see jDisco.Process
 * @see jDisco.Link
 * @see jDisco.Head
 */
public abstract class Continuous extends Link {
    /**
     * The differential and/or difference equations associated with this 
     * continuous process. 
     */
    protected abstract void derivatives();
    
    /**
     * Tests if this continuous process is active.
     *
     * @return <tt>true</tt> if this process is currently 
     * in the list of active continuous processes; <tt>false</tt> otherwise.
     */    
    public boolean isActive() {
        return pred != null;
    }
    
    /** 
     * Starts this continuous process.
     * <p> 
     * The object is inserted into the list of active continuous processes. 
     * Its place in the list is determined by the priority value of the object, 
     * priority (high-value-first). If there are other objects with the same priority value, 
     * then the object in question is inserted after the others. 
     * <p>
     * Calling <tt>start</tt> when the object is already active has no effect.
     * <p>
     * Note that each object is inactive until its <tt>start</tt>-method is called. 
     * <p>
     * <tt>start</tt> may only be called by a discrete process. 
     * Violating this rule leads to the error message
     *  
     * <pre><tt>    Illegal call of start (class Continuous)</tt></pre>
     * <p>
     * after which the simulation is stopped. 
     * <p>
     * <tt>start</tt> returns a reference to this <tt>Continuous</tt>-object. 
     * This allows the user to write as follows:
     *  
       * <pre><tt>    Dynamics d = new Dynamics().start();</tt></pre>
     * <p>
     * where <tt>Dynamics</tt> is a subclass of class <tt>Continuous</tt>.    
     *
       * @return <tt>this</tt>.
     */
    public Continuous start() {
        if (Process.monitor.active) 
            Process.error("Illegal call of start (class Continuous)");
        if (pred == null) {
            if (Process.monitor.firstCont == null) { 
                Process.monitor.lastCont = this;
                Process.monitor.firstCont = this;
                pred = this;
            } else if (priority > Process.monitor.firstCont.priority) {
                suc = Process.monitor.firstCont;
                Process.monitor.firstCont.pred = this;
                Process.monitor.firstCont = this;
                pred = this;
            } else {
                pred = Process.monitor.lastCont;
                while (priority > pred.priority) 
                    pred = pred.pred;
                suc = pred.suc; 
                pred.suc = this;
                if (suc == null)
                    Process.monitor.lastCont = this;
                else
                    suc.pred = this;
            }
        }
        return this;
    }
    
    /** 
     * Stops this continuous process.
     * <p>
     * <tt>stop</tt> removes the object from the list of active continuous processes. 
     * <p>
     * Calling <tt>stop</tt> has no effect unless the object is active. 
     * 
     * <pre><tt>    stop may only be called by a discrete process.</tt></pre>  
     * Violating this rule leads to the error message 
     * <p>
     * <pre><tt>    Illegal call of stop (class Continuous)</tt></pre>
     * <p>
     * after which the simulation is stopped. 
     */    
    public void stop() {
        if (Process.monitor.active)
            Process.error("Illegal call of stop (class Continuous)");
        if (pred != null) {
            if (pred != this)
                pred.suc = suc;
            else {
                pred = null; 
                Process.monitor.firstCont = pred = suc;
            }
            if (suc == null)
                Process.monitor.lastCont = pred;
            else
                suc.pred = pred;
            pred = suc = null;
        }
    }
    
    /**
     * Returns the priority.
     */
    public double getPriority() {
        return priority;
    }
    
    /**
     * Sets the priority of this continuous process.
     * <p>
     * The list of active continuous processes is ordered according to decreasing 
     * priority values (high-value-first). Calling <tt>setPriority(p)</tt> sets the object's 
     * priority to <tt>p</tt>. 
     * <p>
     * The priority may be changed as often as necessary. 
     * Each continuous process has priority zero until its <tt>setPriority</tt>-methods is called.
     * <p>
     * <tt>setPriority</tt> may be called not only when the object is active, but also when it is 
     * inactive. However, <tt>setPriority</tt> may only be called by a discrete process. 
     * Violating this rule leads to the error message
     * 
     * <pre><tt>    Illegal call of setPriority (class Continuous)</tt></pre> 
     * <p>
     * after which the simulation is stopped. 
     * <p>
     * <tt>setPriority</tt> returns a reference to this <tt>Continuous</tt>-object. 
     * This allows the user to write as follows:
     * 
       * <pre><tt>    new Derivatives().setPriority(2).start();</tt></pre>
     * <p>
     * where <tt>Derivatives</tt> is a subclass of class <tt>Continuous</tt>.
     *
     * @param <tt>p</tt> the new priority.    
       * @return <tt>this</tt>.
     */
    public Continuous setPriority(double p) {
        if (Process.monitor.active) 
            Process.error("Illegal call of setPriority (class Continuous");
        priority = p;
        if (pred != null) {
            stop();
            start();
        }
        return this;
    }
    
    /**
     * Returns the current simulation time.
     */
    public static double time() {
        return Process.time();
    }
    
    double priority;
    
    /**
     * <tt>pred</tt> and <tt>suc</tt> denote the object's predecessor 
     * and successor, respectively, in the list of active<tt>Continuous</tt>-objects. 
     * When the object is not in any list, <tt>pred</tt> and <tt>suc</tt> 
     * both have the value <tt>null</tt>.
     * <p>
     * If the object is the first object of the list, then <tt>pred</tt> points 
     * to the object itself, that is, <tt>pred == this</tt>. 
     * <p>
     * The last object of the list has no successor, <tt>suc</tt> == null</tt>. 
     */
    Continuous pred, suc;
}