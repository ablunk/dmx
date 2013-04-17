/*
  File: Reporter.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date        Who                What
  20Sep2001   kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class may be used for reporting purposes. 
 * <p>
 * In one or more subclasses of class <tt>Reporter</tt> the user may define 
 * actions for gathering information about the model's behaviour. 
 * <p>
 * Each object of class <tt>Reporter</tt> may automatically have its user-defined 
 * actions executed with a specified frequency, namely either 
 * <ol><li>at uniformly spaced intervals,</li>
 * <li>after each time step, or</li>
 * <li>at event times.</li></ol>
 * <p>
 * Note that all state changes should be restricted to <tt>Process</tt>- and 
 * <tt>Continuous</tt>-objects. Class <tt>Reporter</tt> must not be used for 
 * any kind of state change.
 */
public class Reporter extends Link {
    /**
     * The actions associated with this <tt>Reporter</tt>-object. 
     */
    protected void actions() {}
    
    /**
     * Sets the object's frequency.
     * <p>
     * The frequency may be changed as often as necessary. 
     * The frequency of each <tt>Reporter</tt>-object is zero until its 
     * <tt>setFrequency</tt>-method is called.
     * <p>
     * <tt>setFrequency</tt> may be called not only when the object is active, 
     * but also when it is inactive. However, it may only be called by a discrete process. 
     * Violating this rule leads to the error message 
     * <pre>
     * <tt>    Illegal call of setFrequency (class Reporter)</tt></pre>
     * after which the simulation is stopped.
     * <p>
     * <tt>setFrequency</tt> returns a reference to this <tt>Reporter</tt>-object. 
     * This allows the user to write as follows:
     * <pre>
     * <tt>    new Plotter.setFrequency(0.1).start();</tt></pre>
     * where <tt>Plotter</tt> is a subclass of class <tt>Reporter</tt>. 
     *
     * @param <tt>f</tt> the new frequency.
       * @return <tt>this</tt>.
     */
    public Reporter setFrequency(double f) {
        if (Process.monitor.active) 
            Process.error("Illegal call of setFrequency (class Reporter)");
        if (pred == null || (frequency > 0 ? f > 0 : frequency == 0 ? f == 0 : f < 0)) {
            reportTime = Process.time();
            frequency = f;
        } else {
            stop();
            frequency = f;
            start();
        }
        return this; 
    }
    
    /**
     * Returns the frequency.
     */    
    public double getFrequency() {
        return frequency;
    }
    
    /**
     * Returns the next report time.
     * <p>
     * For an active <tt>Reporter</tt>-object with a positive frequency,
     * <tt>reportTime</tt> denotes the time when the next regular execution 
     * of the object's user-defined actions will take place. 
     * Executions due to discrete event occurrences are not taken into account.
     * <p>
     * <tt>reportTime</tt> may be viewed as a counterpart to the 
     * <tt>Process</tt>-method <tt>evTime</tt>.
     * <p>
     * If the object is inactive, the value of <tt>reportTime</tt> is of no 
     * interest to the user and is not updated.
     * The initial value of <tt>reportTime</tt> is zero. 
     */    
    public double getReportTime() {
        return reportTime;
    }
    
    /**
     * Tests if this <tt>Reporter</tt>-object is active.
     *
     * @return <tt>true</tt> if the object is a member of one of 
     * the three lists of active <tt>Reporter</tt>-objects; otherwise, 
     * <tt>false</tt>.
     */    
    public boolean isActive() {
        return pred != null;
    }
    
    /**
     * Starts this <tt>Reporter</tt>-object.
     * <p>
     * The object is inserted into one of the three lists of active 
     * <tt>Reporter</tt>-objects. 
     * The list the object is placed in is determined by the value of 
     * <tt>frequency</tt> - positive, zero, or negative. 
     * The first object of the three lists is denoted 
     * firstPosReporter, firstZeroReporter and firstNegReporter, respectively.
     * <p>
     * Calling <tt>start</tt> when the object is already active has no effect. 
     * <p>
     * Note that each object is inactive until its <tt>start</tt>-procedure is called. 
     * <p>
     * <tt>start</tt> may only be called by a discrete process. 
     * Violating this rule leads to the error message
     * <pre><tt>    Illegal call of start (class Reporter)</tt></pre>
     * after which the simulation is stopped. 
     *
       * @return <tt>this</tt>.
     */
    public Reporter start() {
        if (Process.monitor.active) 
            Process.error("Illegal call of start (class Reporter)");
        if (pred == null) {
            reportTime = Process.time();
            Reporter first = frequency > 0 ? Process.monitor.firstPosReporter :
                             frequency < 0 ? Process.monitor.firstNegReporter :
                                       Process.monitor.firstZeroReporter;
            if (first == null)
                first = pred = this;
            else {
                suc = first;
                first = first.pred = pred = this;
            }
            if (frequency > 0) 
                Process.monitor.firstPosReporter = first;
            else if (frequency < 0)
                Process.monitor.firstNegReporter = first;
            else
                Process.monitor.firstZeroReporter = first;
            
        }
        this.frequency = frequency;
        return this;
    }
    
    /** 
     * Stops this <tt>Reporter</tt>-object.
     * <p>
     * <tt>stop</tt> removes the object from the list of active 
     * <tt>Reporter</tt>-objects. 
     * <p>
     * Calling <tt>stop</tt> has no effect unless the object is active. 
     * <p>
     * <tt>stop</tt> may only be called by a discrete process. 
     * Violating this rule leads to the error message 
     * <pre>
     * <tt>    Illegal call of stop (class Reporter)</tt></pre>
     * <p>
     * after which the simulation is stopped. 
     */    
    public void stop() {
        if (Process.monitor.active)
            Process.error("Illegal call of stop (class Reporter)");
        if (pred != null) {
            if (pred != this) 
                pred.suc = suc;
            else {
                Reporter first = suc;
                if (frequency > 0) 
                    Process.monitor.firstPosReporter = first;
                else if (frequency < 0)
                    Process.monitor.firstNegReporter = first;
                else
                    Process.monitor.firstZeroReporter = first;
                if (first != null)
                    first.pred = first;
            }
            if (suc != null)
                suc.pred = pred;
            pred = suc = null;
        }
    }
    
    double frequency, reportTime;
    
    /**
     * <tt>pred</tt> and <tt>suc</tt> denote the object's predecessor 
     * and successor, respectively, in a list of active<tt>Reporter</tt>-objects. 
     * When the object is not in any list, <tt>pred</tt> and <tt>suc</tt> 
     * both have the value <tt>null</tt>.
     * <p>
     * If the object is the first object of a list, then <tt>pred</tt> points 
     * to the object itself, that is, <tt>pred == this</tt>. 
     * <p>
     * The last object of the list has no successor, <tt>suc</tt> == null</tt>. 
     */
    Reporter pred, suc;
}