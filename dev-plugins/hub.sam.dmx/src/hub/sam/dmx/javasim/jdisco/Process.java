/*
  File: Process.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001    	kh      Created public version
  18Feb2004     kh		All coroutines are now recycled after use. This will often
  			            reduce the demand for threads in multiple simulations.
*/

package hub.sam.dmx.javasim.jdisco;
import java.util.*;

/**
 * This class may be used to describe the processes of a model.
 * <p>
 * The discrete processes of a system are described by means of class <tt>Process</tt>.
 * <p>
 * Outline:<br>
 * <pre><tt>
 *     public abstract class Process {
 *         protected abstract void actions();<br>
 *
 *         public static double time();
 *         public static void activate(Process p);
 *         public static void hold(double t);
 *         public static void passivate();
 *         public static void wait(Head q);<br>
 *         public static void waitUntil(Condition cond);
 *
 *         public double dtMin, dtMax;
 *         public double maxAbsError, maxRelError;
 *     }</tt></pre>
 * <p>
 * Processes are created as instances of <tt>Process</tt>-derived
 * classes that override the abstract method <tt>actions</tt>.
 * The <tt>actions</tt> method is used to describe their life cycles.
 * <p>
 * A process may be suspended temporarily and may be resumed later from where it left off.
 * <p>
 * The <tt>activate</tt> method is used to make a specified process start 
 * executing its actions.
 * <p> 
 * The <tt>hold</tt> method suspends the execution of the calling process for 
 * a specified period of time. 
 * <p>
 * The <tt>passivate</tt> method suspends the execution of  the calling process 
 * for an unknown period of time. Its execution may later be resumed by calling 
 * <tt>activate</tt> with the process as argument.
 * <p>
 * The <tt>wait</tt> method suspends the calling process and adds it to a queue.
 * <p>
 * The <tt>waitUntil</tt> method can be used to schedule a discrete event to occur 
 * as soon as a prescribed system state is reached. Such an event is called a state-event, 
 * in contrast to a time-event which is an event scheduled to occur at a 
 * specified point in time.
 * <p> 
 * Class <tt>Process</tt> extends class <tt>Continuous</tt>, allowing a 
 * <tt>Process</tt>-object to represent a discrete as well as a continuous process. 
 * <p>
 * Since <tt>Continuous</tt> is a subclass of <tt>Link</tt>, 
 * every process has the capability of being a member of a two-way list.
 * This is useful, for example, when processes must wait in a queue.
 *   
 * @see jDisco.Continuous
 * @see jDisco.Link
 * @see jDisco.Head
 */
public abstract class Process extends Continuous {
    private static class TerminateException extends RuntimeException {}
    private static Set processSet = Collections.synchronizedSet(new HashSet());
    private static boolean termination;
    
    /**
     * The life cycle of this process.  
     */
    protected abstract void actions();

    /**
     * The coroutine executing the <tt>actions</tt> of this process.   
     */
    private final Coroutine myCoroutine = new Coroutine() {           
         protected void body() {
            if (MAIN == null)
                MAIN = Process.this;
            processSet.add(Process.this);
            try {
            	actions();
            } catch (TerminateException e) {}
            TERMINATED = true;
            processSet.remove(Process.this);
            if (Process.this == MAIN) {            
                termination = true; 
                while (SQS.SUC != SQS) 
                   SQS.SUC.cancel();           
                MAIN.scheduleAfter(SQS);  
                Object[] pa = processSet.toArray();
                processSet.clear();
                for (int i = 0; i < pa.length; i++) 
                    if (!((Process) pa[i]).TERMINATED)
                        resume(((Process) pa[i]).myCoroutine);
                MAIN.cancel();
                MAIN = null;
                terminated = true;
                termination = false;
                monitor = MonitorFactory.getInstance();
             } else { 
            	if (SUC != null)
                	cancel();
            	terminated = true;
            	resume(SQS.SUC.myCoroutine);
            }
        }
    };
    
    /**
     * Default version causing an error if the process is used as
     * a continuous process (<tt>start</tt>ed), but no <tt>derivatives</tt> 
     * method has been specified. 
     */
    protected void derivatives() {
        error("No derivatives method specified");
    }

    /**
     * The predecessor of this process in the event list.
     */    
    private Process PRED;    
    
    /**
     * The successor of this process in the event list.
     */    
    private Process SUC;
    
    /**
     * The event time of this process when scheduled.
     */
    private double EVTIME;
    
    /**
     * An indication of whether this process has executed its actions.
     * The value is made publically available through the method 
     * <tt>terminated</tt>.
     */
    private boolean TERMINATED;
    
    /**
     * The list head of the event list, a circular two-way list.
     */
    private final static Process SQS;

    static { 
        SQS = new Process() {
            protected void actions() {}
        };
        SQS.EVTIME = -1;  SQS.PRED = SQS.SUC = SQS;
    }
    
    /**
     * The main process.
     * <p> 
     * This is the first activated process in a simulation.
     * The value is made publically available through the method 
     * <tt>main</tt>.
     */
    private static Process MAIN;

    /**
     * Tests if this process is scheduled.
     *
     * @return <tt>true</tt> if this process is not currently 
     * in the event list; <tt>false</tt> otherwise.
     */    
    public final boolean idle() { 
        return SUC == null; 
    }
    
    /**
     * Tests if this process is terminated. 
     *
     * @return <tt>true</tt> if this process has executed 
     * all its actions; <tt>false</tt> otherwise.
     */
    public final boolean terminated() { 
        return TERMINATED; 
    }
    
    /**
     * Returns the event time of this process. 
     * 
     * @exception <tt>DiscoException</tt>
     * if this process is idle.
     */
    public final double evTime() { 
        if (idle())
            error("No evTime for idle process");
        return EVTIME; 
    }
    
    /**
     * Returns the next process (if any) in the event list.
     */
    public final Process nextEv() { 
        return SUC == SQS ? null : 
               SUC != monitor ? SUC : SUC.SUC; 
    }

    /**
     * Returns the currently active process. 
     */
    public static final Process current() { 
        return SQS.SUC != SQS && SQS.SUC != monitor ? SQS.SUC : null; 
    } 
    
    /**
     * Returns the current simulation time.
     */
    public static final double time() { 
        return monitor.active ? monitor.time :
               SQS.SUC != SQS ? SQS.SUC.EVTIME : 0;
    }
    
    /**
     * Returns the starting point of the current time step.
     */
    public static final double lastTime() { 
        return monitor.active ? monitor.lastTime :
               SQS.SUC != SQS ? SQS.SUC.EVTIME : 0;
    }
    
    /**
     * Returns the current integration stepsize.
     */
    public static final double dt() {
        return monitor.dt;
    }
    
    /**
     * Returns the main process. 
     * The main process is the first process activated 
     * in a simulation.
     */
    public static final Process main() { 
        return MAIN; 
    }
    
    /**
     * Throws a run-time exception with a specified error message.
     *
     * @exception <tt>DiscoException</tt> 
     * always. 
     */
    static void error(String msg) {
        String s = msg + "\n\n" +
                   "Encountered at time " + new Format("%0.5g").form(time()) + "\n" +
                   "             dt          dtMin          dtMax" + "\n" +
                   new Format("%15.5g").form(dt()) +
                   new Format("%15.5g").form(dtMin) +
                   new Format("%15.5g").form(dtMax) + "\n";
        throw new DiscoException(s);
    }
    
    /**
     * Suspends the currently active process for a specified 
     * period of simulated time.
     * <p>
     * The process is rescheduled for
     * reactivation at <tt>time()</tt> + <tt>t</tt>.
     *
     * @param <tt>t</tt> the length of the period of suspension.
     */
    public static final void hold(double t) {
        if (monitor.active)
            error("Illegal call of hold");
        if (SQS.SUC == SQS)
           error("Hold: SQS is empty"); 
        Process Q = SQS.SUC;
        if (t > 0) 
            Q.EVTIME += t;
        t = Q.EVTIME;
        if (Q.SUC != SQS && Q.SUC.EVTIME <= t) {
            Q.cancel();
            Process P = SQS.PRED;
            while (P.EVTIME > t) 
                P = P.PRED;
            Q.scheduleAfter(P);
            resumeCurrent();
        }
    }
    
    /**
     * Passivates the currently active process. 
     * <p> 
     * <tt>current</tt> is removed from the event list, and
     * the actions of the new <tt>current</tt> are resumed.
     *
     * @exception <tt>DiscoException</tt>
     * if the event list becomes empty.
     */
    public static final void passivate() {
        if (monitor.active)
            error("Illegal call of cancel");
        if (SQS.SUC == SQS)
           error("Passivate: SQS is empty"); 
        Process CURRENT = SQS.SUC;
        CURRENT.cancel();
        if (SQS.SUC == SQS)
            error("passivate causes SQS to become empty");
        resumeCurrent();
    } 

    /**
     * Causes the currently active process to wait in a queue. 
     * <p>
     * The currently active process is added to the two-way list 
     * passed as the parameter, and <tt>passivate</tt> is called
     *
     * @param <tt>q</tt> the head of the list.
     *
     * @exception <tt>DiscoException</tt>
     * if the event list becomes empty.
     */         
    public static final void wait(Head q) {
        if (monitor.active)
            error("Illegal call of wait");
        if (SQS.SUC == SQS)
           error("Wait: SQS is empty"); 
         SQS.SUC.into(q);
         Process CURRENT = SQS.SUC;
         CURRENT.cancel();
         if (SQS.SUC == SQS)
             error("wait causes SQS to become empty");
         resumeCurrent();
    }

    /**
     * Cancels a scheduled event.
     * <p>
     * The process passed as the parameter is removed from
     * the event list and the actions of the new 
     * <tt>current</tt> are resumed.
     * If the process is currently active or suspended, 
     * it becomes passive.
     * If it is passive, terminated or <tt>null</tt>,
     * the call has no effect.
     *
     * @param <tt>p</tt> the process to be cancelled.
     *
     * @exception <tt>DiscoException</tt>
     * if the event list becomes empty.
     */
    public static final void cancel(Process p) {
        if (monitor.active)
            error("Illegal call of cancel");
        if (p == null || p.SUC == null)
            return;
        Process CURRENT = SQS.SUC;
        p.cancel();
        if (SQS.SUC != CURRENT)
            return;
        if (SQS.SUC == SQS)
            error("cancel causes SQS to become empty");
        resumeCurrent();
    }

    /**
     * Internal method used to activate or reactivate a  
     * The method is invoked by the <tt>activate</tt> and 
     * <tt>reactivate</tt> methods. 
     * 
     * @param reac <tt>true</tt> if the process, <tt>x</tt>, 
     * is to be reactivated; <tt>false</tt> otherwise
     * @param <tt>x</tt> the process to be (re)activated. 
     * The first process in the activation call
     * @param <tt>code</tt> a code defined from the activation call:
     * <pre>        <i>absent</i>       direct_code = 0
     *        at           at_code     = 1
     *        delay        delay_code  = 2
     *        before       before_code = 3
     *        after        after_code  = 4</pre>
     * @param <tt>t</tt> the time specified in the activation call, 
     * if present, otherwise it is zero.
     * @param <tt>y</tt> The second process in the activation call,
     * if present, otherwise it is <tt>null</tt>.
     * @param <tt>prio</tt> <tt>true</tt> if <tt>prior</tt> is 
     * specified in the activation call; <tt>false</tt> otherwise.
     *
     * @exception <tt>DiscoException</tt>
     * if the event list becomes empty      
     */    
    private static final void activat(boolean reac, Process x, int code,
                                      double t, Process y, boolean prio) {
        if (monitor.active) 
            error("Illegal call of " + (reac ? "re" : "") + "activate");
        if (x == null || x.TERMINATED || (!reac && x.SUC != null))
            return;
        Process CURRENT = SQS.SUC, P = null;
        double NOW = time();
        switch(code) {
        case direct_code:
            if (x == CURRENT)
                return;
            t = NOW; P = SQS;
            break;
        case delay_code:
            t += NOW;
        case at_code:
            if (t <= NOW) {
                if (prio && x == CURRENT)
                    return;
                t = NOW;
            }
            break;
        case before_code:
        case after_code:
             if (y == null || y.SUC == null) {
                 if (x.SUC != null)
                     x.cancel();
                 if (SQS.SUC == SQS)
                     error("reactivate causes SQS to become empty");
                 return;
             }
             if (x == y)
                 return;
             t = y.EVTIME;
             P = code == before_code ? y.PRED : y;
        }
        if (x.SUC != null)
            x.cancel();
        if (P == null) {
            for (P = SQS.PRED; P.EVTIME > t; P = P.PRED)
                 ;
            if (prio)
                while (P.EVTIME == t)
                    P = P.PRED;
        }
        x.EVTIME = t;
        x.scheduleAfter(P);
        if (x == SQS.SUC && x.SUC != monitor && x != monitor)
            reactivate(monitor, after, x);
        if (SQS.SUC != CURRENT)
            resumeCurrent();
    }
   
    /*
     * Auxiliary classes for representing activation keywords. 
     */
    
    private static final class At     {}
    private static final class Delay  {}
    private static final class Before {}
    private static final class After  {}
    private static final class Prior  {}
    
    /* Activation keywords */
   
    public static final At     at     = new At();
    public static final Delay  delay  = new Delay();
    public static final Before before = new Before();
    public static final After  after  = new After();
    public static final Prior  prior  = new Prior();
    
    /* Codes passed to the <tt>activat</tt> method. */
    
    private static final int direct_code = 0;
    private static final int at_code     = 1;
    private static final int delay_code  = 2;
    private static final int before_code = 3;
    private static final int after_code  = 4;
    
    /**
     * Causes the specified passive process to become active 
     * at the current simulation time (after processes with the
     * same event time).
     * <b>The call has no effect unless the process is passive.</b>
     * <p>
     * The process is inserted into the event list at a
     * position corresponding to the current simulation time
     * and <b>after</b> any processes with the same event time.
     *
     * @param <tt>p</tt> the process to be activated.
     */
    public static final void activate(Process p) { 
        activat(false, p, direct_code, 0, null, false);  
    }
      
    /**
     * Causes the specified passive process to become active 
     * at the specified event time (after processes with the
     * same event time).
     * <b>The call has no effect unless the process is passive.</b>
     * <p>
     * The process is inserted into the event list at a
     * position corresponding to the current simulation time
     * and <b>after</b> any processes with the same event time.
     * 
     * @param <tt>p</tt> the process to be activated.
     * @param <tt>at</tt> the reference constant <tt>at</tt>. 
     * @param <tt>t</tt> the event time. 
     */
    public static final void activate(Process p, At at, double t) { 
        activat(false, p, at_code, t, null, false); 
    }
      
    /**
     * Causes the specified passive process to become active 
     * at the specified event time (before processes with the
     * same event time).
     * <b>The call has no effect unless the process is passive.</b>
     * <p>
     * The process is inserted into the event list at a
     * position corresponding to the current simulation time
     * and <b>before</b> any processes with the same event time.
     * 
     * @param <tt>p</tt> the process to be activated.
     * @param <tt>at</tt> the reference constant <tt>at</tt>.  
     * @param <tt>t</tt> the event time.
     * @param <tt>prior</tt> the reference constant <tt>prior</tt>.  
     */  
    public static final void activate(Process p, At at, double t, Prior prior) { 
        activat(false, p, at_code, t, null, prior != null); 
    }
      
    /**
     * Causes the specified passive process to become active 
     * after the specified delay (after processes with the
     * same event time). 
     * <b>The call has no effect unless the process is passive.</b>
     * <p>
     * The process is inserted into the event list at a position 
     * corresponding to the current simulation time plus the
     * the specified delay.
     * The process is inserted <b>after</b> any processes with the
     * same event time.
     * 
     * @param <tt>p</tt> the process to be activated.
     * @param <tt>delay</tt> the reference constant <tt>delay</tt>. 
     * @param <tt>t</tt> the delay.
     */
    public static final void activate(Process p, Delay delay, double t) { 
        activat(false, p, delay_code, t, null, false); 
    }
     
    /**
     * Causes the specified passive process to become active 
     * after the specified delay (before processes with the
     * same event time). 
     * <b>The call has no effect unless the process is passive.</b>
     * <p>
     * The process is inserted into the event list at a position 
     * corresponding to the current simulation time plus the
     * the specified delay.
     * The process is inserted <b>before</b> any processes with the
     * same event time.
     * 
     * @param <tt>p</tt> the process to be activated.
     * @param <tt>delay</tt> The reference constant <tt>delay</tt>. 
     * @param <tt>t</tt> the event time.
     * @param <tt>prior</tt> the reference constant <tt>prior</tt>. 
     */
    public static final void activate(Process p, Delay d, double t, Prior prior) { 
        activat(false, p, delay_code, t, null, prior != null); 
    }
      
    /**
     * Schedules the first (passive) process immediately before 
     * the second (scheduled) one, and at the same event time. 
     * <b>The call has no effect unless the first process is passive
     * and the second one is scheduled.</b>
     * <p>
     * The process <tt>p1</tt> is inserted into the event list 
     * immediately before the process <tt>p2</tt> and with 
     * the same event time.
     *
     * @param <tt>p1</tt> the process to be activated.
     * @param <tt>before</tt> the reference constant <tt>before</tt>.
     * @param <tt>p2</tt> the process before which <tt>p1</tt> 
     * is to be scheduled.   
     */
    public static final void activate(Process p1, Before before, Process p2) { 
        activat(false, p1, before_code, 0, p2, false); 
    }
        
    /**
     * Schedules the first (passive) process immediately after 
     * the second (scheduled) one, and at the same event time.
     * <b>The call has no effect unless the first process is passive
     * and the second one is scheduled.</b>
     * <p>
     * The process <tt>p1</tt> is inserted into the event list 
     * immediately after the process <tt>p2</tt> and with 
     * the same event time.
     *
     * @param <tt>p1</tt> the process to be activated.
     * @param <tt>before</tt> the reference constant <tt>after</tt>.
     * @param <tt>p2</tt> the process after which <tt>p1</tt> 
     * is to be scheduled. 
     */
    public static final void activate(Process p1, After after, Process p2) { 
        activat(false, p1, after_code, 0, p2, false); 
    }
    
    /**
     * Causes the specified process to become active 
     * at the current simulation time (after processes with the
     * same event time).
     * <p>
     * The process is positioned in the event list at a
     * position corresponding to the current simulation time
     * and <b>after</b> any processes with the same event time.
     *
     * @param <tt>p</tt> the process to be reactivated.
     */
    public static final void reactivate(Process p) { 
        activat(true, p, direct_code, 0, null, false);  
    }
      
    /**
     * Causes the specified process to become active 
     * at the specified event time (after processes with the
     * same event time).
     * <p>
     * The process is positioned in the event list at a
     * position corresponding to the current simulation time
     * and <b>after</b> any processes with the same event time.
     * 
     * @param <tt>p</tt> the process to be reactivated.
     * @param <tt>at</tt> the reference constant <tt>at</tt>.  
     * @param <tt>t</tt> the event time. 
     */
    public static final void reactivate(Process p, At at, double t) { 
        activat(true, p, at_code, t, null, false); 
    }
    
    /**
     * Causes the specified process to become active 
     * at the specified event time (before processes with the
     * same event time).
     * <p>
     * The process is positioned in the event list at a
     * position corresponding to the current simulation time
     * and <b>before</b> any processes with the same event time.
     * 
     * @param <tt>p</tt> the process to be reactivated.
     * @param <tt>at</tt> the reference constant <tt>at</tt>. 
     * @param <tt>t</tt> the event time.
     * @param <tt>prior</tt> the reference constant <tt>prior</tt>.  
     */   
    public static final void reactivate(Process p, At at, double t, Prior prior) { 
        activat(true, p, at_code, t, null, prior != null); 
    }    
    
    /**
     * Causes the specified process to become active 
     * after the specified delay (after processes with the
     * same event time).
     * <p>
     * The process is positioned in the event list at a
     * position corresponding to the current simulation time plus the
     * the specified delay.
     * The process is inserted <b>after</b> any processes with the
     * same event time.
     * 
     * @param <tt>p</tt> the process to be reactivated.
     * @param <tt>delay</tt> the reference <tt>delay</tt>. 
     * @param <tt>t</tt> the delay.
     */
    public static final void reactivate(Process p, Delay delay, double t) { 
        activat(true, p, delay_code, t, null, false); 
    }
    
    /**
     * Causes the specified process to become active 
     * after the specified delay (before processes with the
     * same event time).
     * <p>
     * The process is positioned in the event list at a
     * position corresponding to the current simulation time plus the
     * the specified delay.
     * The process is positioned in the event list <b>before</b> 
     * any processes with the same event time.
     * 
     * @param <tt>p</tt> the process to be reactivated.
     * @param <tt>delay</tt> the reference constant <tt>delay</tt>.  
     * @param <tt>t</tt> the event time.
     * @param <tt>prior</tt> the reference constant <tt>prior</tt>. 
     */
    public static final void reactivate(Process p, Delay d, double t, Prior prior) { 
        activat(true, p, delay_code, t, null, prior != null); 
    }
    
    /**
     * Schedules the first process immediately before 
     * the second one and at the same event time.
     * <p>
     * The process <tt>p1</tt> is positioned in the event list 
     * immediately before the process <tt>p2</tt> and with 
     * the same event time. 
     * If <tt>p1</tt> == <tt>p2</tt> or <tt>p2</tt> is not in the event list, 
     * the call is equivalent to <tt>cancel(p1)</tt>.
     *
     * @param <tt>p1</tt> the process to be reactivated.
     * @param <tt>before</tt> the reference constant <tt>before</tt>.
     * @param <tt>p2</tt> the process before which <tt>p1</tt>. 
     * is to be scheduled.   
    */
    public static final void reactivate(Process p1, Before before, Process p2) { 
        activat(true, p1, before_code, 0, p2, false); 
    }
    
    /**
     * Schedules the first process immediately after 
     * the second one and at the same event time.
     * <p>
     * The process <tt>p1</tt> is positioned in the event list 
     * immediately after the process <tt>p2</tt> and with 
     * the same event time. 
     * If <tt>p1</tt> == <tt>p2</tt> or <tt>p2</tt> is not in the event list, 
     * the call is equivalent to <tt>cancel(p1)</tt>.
     *
     * @param <tt>p1</tt> the process to be reactivated.
     * @param <tt>before</tt> the reference constant <tt>after</tt>.
     * @param <tt>p2</tt> the process before which <tt>p1</tt> 
     * is to be scheduled.   
     */
    public static final void reactivate(Process p1, After after, Process p2) { 
        activat(true, p1, after_code, 0, p2, false); 
    }
    
    /**
     * Inserts this process after another process in the event list.
     *
     * @param <tt>p</tt> the process after which the process is to 
     * be inserted.
     */
    private final void scheduleAfter(Process p) {
        PRED = p; 
        SUC = p.SUC;
        p.SUC = SUC.PRED = this;
    }
    
    /**
     * Removes this process from the event list. 
     */
    private final void cancel() {
        PRED.SUC = SUC;
        SUC.PRED = PRED;
        PRED = SUC = null;
    }
    
   /**
    * Resumes the current process. 
    */
    private final static void resumeCurrent() {
    	Coroutine.resume(SQS.SUC.myCoroutine);
        if (termination) 
            throw new TerminateException();
    } 
    
    static final class WaitNotice {
        WaitNotice(Process proc, Condition cond, double priority) {
            this.proc = proc;
            this.cond = cond;
            this.priority = priority;
        }
    
        Process proc;
        Condition cond;
        double priority;
        WaitNotice pred, suc;
    }
    
    /**
     * Suspends the currently active process until a specified condition
     * becomes true.
     * <p>
     * The method may be used to define state-events, that is, events whose time 
     * of occurrence is dependent upon a given state-condition. 
     * <p>
     * <tt>waitUntil(cond)</tt>, where <tt>cond</tt> is a <tt>Condition</tt>-object, 
     * causes the active discrete process, <tt>current</tt>, to become passive 
     * (<tt>idle</tt>) over a period which is planned to last until the 
     * <tt>test</tt>-method of <tt>cond</tt> evaluates to <tt>true</tt>. 
     * <p>
     * However, this passive period will end sooner if the waiting process 
     * is activated by another discrete process.
     * <p>
     * It is possible to schedule a time-event for a waiting process, so that 
     * the process has simultaneously a state-event and a time-event scheduled 
     * (e.g., <tt>activate(p, delay, 10)</tt>, where <tt>p</tt> is a waiting 
     * <tt>Process</tt>-object). When the first of these events takes place, 
     * the other one will be annulled. 
     * <p>
     * A state-event takes place as soon as the corresponding state-condition 
     * is fulfilled. The event time will be determined with an accuracy of <tt>dtMin</tt>. 
     * <p>
     * Discrete processes operate in quasi-parallel, which means that "simultaneous" 
     * events occur in a certain order. With regard to simultaneous events, 
     * the following rules apply: 
     * <p>
     * (1) Time-events take place before state-events<br>
     * (2) Time-events take place in their scheduled order, that is to say, 
     * in the same sequence as they are represented in the list of event notices<br>
     * (3) State-events take place in accordance with their priorities (high-value-first). 
     * <p>
     * The call <tt>waitUntil(cond)</tt> is equivalent to the call 
     * <tt>waitUntil(cond, 0, null)</tt>. 
     * <p>
     * A state-event takes place only if its condition is true. 
     * Notice that the occurrence of a simultaneous event can change the 
     * condition's truth value.
     * <p>
     * <tt>waitUntil</tt> must only be called by a discrete process. 
     * Violating this rule leads to the error message
     * <p><pre><tt>
     *     Illegal call of waitUntil</tt></pre>
     * <p>
     * after which the simulation is stopped.
     *
     * @param <tt>cond</tt> the condition.
     *
     * @see jDisco.Condition
     * @see #waitUntil(jDisco.Condition, double)
     * @see #waitUntil(jDisco.Condition, jDisco.Process.Prior)
     * @see #waitUntil(jDisco.Condition, double, jDisco.Process.Prior)
     */  
    public void waitUntil(Condition cond) {
        waitUntil(cond, 0, null);
    }
    
    /**
     * Suspends the currently active process until a specified condition
     * becomes true.
     * <p>
     * The call <tt>waitUntil(cond, waitPriority)</tt> is equivalent to the call 
     * <tt>waitUntil(cond, waitPriority, null)</tt>.
     *
     * @param <tt>cond</tt> the condition.
     * @param <tt>waitPriority</tt> the priority.
     *
     * @see jDisco.Condition
     * @see #waitUntil(jDisco.Condition)
     * @see #waitUntil(jDisco.Condition, jDisco.Process.Prior)
     * @see #waitUntil(jDisco.Condition, double, jDisco.Process.Prior)
     */
    public void waitUntil(Condition cond, double waitPriority) {
        waitUntil(cond, waitPriority, null);
    }
    
    /**
     * Suspends the currently active process until a specified condition
     * becomes true.
     * <p>
     * The call <tt>waitUntil(cond, prior)</tt> is equivalent to the call 
     * <tt>waitUntil(cond, 0, prior)</tt>.
     *
     * @param <tt>cond</tt> the condition.
     * @param <prior>prior</tt> the reference constant <tt>prior</tt>.   
     *
     * @see jDisco.Condition
     * @see #waitUntil(jDisco.Condition)
     * @see #waitUntil(jDisco.Condition, double)
     * @see #waitUntil(jDisco.Condition, double, jDisco.Process.Prior)
     */    
    public void waitUntil(Condition cond, Prior prior) {
        waitUntil(cond, 0, prior);
    }
    
    /**
     * Suspends the currently active process until a specified condition
     * becomes true.
     * <p>
     * The parameter <tt>waitPriority</tt> is the priority of the state-event.
     * <p>
     * The parameter <tt>prior</tt> is used to specify whether the state-event
     * should take place befor (<tt>prior != null</tt>) or after 
     * (<tt>prior == null</tt>) any other state-event with the same  priority.
     * The process is inserted into the wait list at a position corresponding 
     * to its <tt>waitPriority</tt>, and, if <tt>prior != null</tt>,
     * <b>before</b> any waiting processes with the same priority;
     * otherwise after. 
     *
     * @param <tt>cond</tt> the condition.
     * @param <tt>waitPriority</tt> the priority.
     * @param <tt>prior</tt> the reference constant <tt>prior</tt> or <tt>null</tt>.   
     *
     * @see jDisco.Condition
     * @see #waitUntil(jDisco.Condition)
     * @see #waitUntil(jDisco.Condition, jDisco.Process.Prior)
     * @see #waitUntil(jDisco.Condition, double)
     */
    public void waitUntil(Condition cond, double waitPriority, Prior prior) {
        if (monitor.active) 
            error("Illegal call of waitUnitil");
         WaitNotice w = new WaitNotice(current(), cond, waitPriority);
         if (monitor.firstWait == null) 
             monitor.firstWait = monitor.lastWait = w;
         else if (w.priority > monitor.firstWait.priority ||
                  (prior != null && w.priority == monitor.firstWait.priority)) {
             w.suc = monitor.firstWait;
             monitor.firstWait = w.suc.pred = w;         
         } else {
             w.pred = monitor.lastWait;
             while (w.priority > w.pred.priority)
                 w.pred = w.pred.pred;
             if (prior != null)
                 while (w.priority == w.pred.priority)
                     w.pred = w.pred.pred;
             w.suc = w.pred.suc;
             w.pred.suc = w;
             if (w.suc != null)
                 w.suc.pred = w;
             else
                 monitor.lastWait = w;
         }
         reactivate(monitor, after, current());    
         passivate();
         if (w.pred == null) 
             monitor.firstWait = w.suc;
         else
             w.pred.suc = w.suc;
         if (w.suc == null) 
             monitor.lastWait = w.pred;
         else
             w.suc.pred = w.pred;
     }
     
     /**
      * Causes the annulment of a state-event which might have been 
     * planned by a process.  
      *
     * <tt>cancelStateEvent</tt> must only be called by a discrete process. 
     * Violating this rule leads to the error message
     * <p><pre><tt>
     *     Illegal call of cancelStateEvent</tt></pre>
     * <p>
     * after which the simulation is stopped.
     *
      * @param <tt>p</tt> the process.
     * @see #waitUntil(jDisco.Condition)
      */
    public void cancelStateEvent(Process p) {
        if (monitor.active) 
            error("Illegal call of cancelStateEvent");
        WaitNotice w = monitor.lastWait;
        while (w != null && w.proc != p)
            w = w.pred;
        if (w == null)
            return; 
        if (w.pred == null)
            monitor.firstWait = w.suc;
        else
            w.pred.suc = w.suc;
        w.pred = w.suc = w;
     }
     
     /**
     * Reactives the currently active process after the monitor. 
     */
     public void pause() {
        if (monitor.active)
            error("Illegal call of pause");
        reactivate(current(), after, monitor);
    }
    
    /**
     * The minimum allowable step-size.
     * <p>
     * During the simulation time advances in steps of variable size. 
     * The step-size, among other things, is governed by the event times 
     * and the user's requirements regarding integration accuracy. 
     * <tt>dtMin</tt> and <tt>dtMax</tt> are used to specify the minimum 
     * and the maximum allowable step-size, respectively. 
     * <p>
     * In general, step-size will vary within these bounds. 
     * There are the following exceptions, however: 
     * <p>
     * (1) A time step less than <tt>dtMin</tt> can be taken in order to 
     * assure that a time-event is not passed. 
     * (2) A time step greater than <tt>dtMax</tt> can be taken whenever 
     * there are neither planned state-events nor active continuous processes. 
     * In this case, step-size is as large as possible without passing a time-event.
     */
    public static double dtMin = 1.0e-5;

    /**
     * The maximum allowable step-size.
     */
    public static double dtMax = 1.0;
    
    /**
     * The upper bound for the absolute error. 
     */
    public static double maxAbsError = 1.0e-5;

    /**
     * The upper bound for the relative error. 
     */
    public static double maxRelError = 1.0e-5;
    
    /**
     * Chooses one of the built-in integration methods.
     * <p>
     * If no such method exists, the following error message is printed
     * <pre><tt>
     *     Illegal call of integrationMethod (class Process)</tt></pre>
     * after which the simulation is stopped. 
     *
     * @param <tt>name</tt> the name of the integration method.
     * @exception <tt>DiscoException</tt>
     * if <tt>name</tt> is not a built-in integration method.  
     */
    public void integrationMethod(String name) {
        if (monitor.active ||
            monitor.firstVar != null ||
            monitor.firstCont != null)
            error("Illegal call of integrationMethod (class Process)");       
        cancel(monitor);
        monitor = MonitorFactory.getInstance(name);
        if (current() != null)
            reactivate(monitor, after, current());
    }
    
    static Monitor monitor = MonitorFactory.getInstance();
}
