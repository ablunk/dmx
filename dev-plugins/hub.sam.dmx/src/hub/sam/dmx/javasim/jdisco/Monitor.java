/*
  File: Monitor.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/*
 * A simulation is controlled behind the scenes, so to speak, by an object called the "monitor". 
 * <p>
 * It is the monitor's responsibility that 
 * <p>
 * 	(1) the state of the model changes "continuously" between the discrete events, 
 * <p>
 *	(2) the events (time- as well as state-events) take place at the right time and in correct 
 *      order, and
 * <p>
 * 	(3) the active <tt>Reporter</tt>-objects have their user-defined actions executed with the 
 *      specified frequency.
 * <p>
 * The monitor updates the state of the model between the discrete events as prescribed 
 * by the active continuous processes. 
 * The updating is performed in time steps using numerical integration. 
 * The step-size is adjusted so that the requested accuracy requirements are met, 
 * and so that no events take place within a step.
 * <p>
 * The monitor ensures that the scheduled events take place. 
 * The time-events take place precisely a their given time points (<tt>evTime</tt>); 
 * on the other hand, state-events, that is, events scheduled by the <tt>waitUntil</tt>-method, 
 * are time-determined with a certain error (<tt>dtMin</tt>). 
 * <p>
 * Moreover the monitor takes care that the user-defined <tt>actions</tt> of the 
 * active <tt>Reporter</tt>-objects are executed as frequently as prescribed, 
 * which for a <tt>Reporter</tt>-object with frequency <tt>f</tt> means:
 * <p>
 * <tt>    f</tt> > 0: at uniformly spaced intervals of length <tt>f</tt> time units 
 *                     and also at event times. 
 * <p>
 * <tt>    f</tt> = 0: at the end of each time step (which includes event times). 
 * <p>
 * <tt>    f</tt> < 0: only at event times. 
 * <p>
 * When an event takes place, the user-defined actions of all active <tt>Reporter</tt>-objects, 
 * regardless of frequency, are executed - both immediately before and after the event. 
 * <p>
 * The monitor is active between the events, even when they are "concurrent".
 * <p>
 * Interpolation is used to determine efficiently the state of the model at times 
 * within an integration step. The method is used both in connection with the time 
 * determination of state-events (<tt>waitUntil</tt>-events) and with the regular
 * reporting of <tt>Reporter</tt>-objects with a positive frequency. 
 * <p>
 * <tt>Monitor</tt> is an abstract class. The specification of integration and inperpolation
 * methods is left over to subclasses of class <tt>Monitor</tt>.
 */
abstract class Monitor extends Process {
 	double dt, dtNow, dtNext, dtFull, dtLower;
	double time, lastTime, nextTime, nextEventTime, nextReportTime;
	boolean active;
	Process stateEvent, nextStateEvent, nextTimeEvent;
	Continuous firstCont, lastCont;
	Reporter firstPosReporter, firstNegReporter, firstZeroReporter;
	Process.WaitNotice firstWait, lastWait;
	Variable firstVar;
	
	abstract void integrate();
	void prepareInterpolation() {}
	abstract void interpolate();
	
	final void reportPos() {
		nextReportTime = nextEventTime; 		
		for (Reporter r = firstPosReporter; r != null; r = r.suc) {
			if (r.reportTime > time && time < nextEventTime && dt > 0)
				continue;
			r.actions();
			if (r.reportTime <= time)
				r.reportTime += r.frequency;
			if (r.reportTime <= time)
				error("Frequency is too small to advance time (class Reporter)");
			if (r.reportTime < nextReportTime)
				nextReportTime = r.reportTime;
		}
	}

	final void reportNeg() { 
		for (Reporter r = firstNegReporter; r != null; r = r.suc) 
			r.actions();
	}

	final void reportZero() {
		for (Reporter r = firstZeroReporter; r != null; r = r.suc) 
			r.actions();
	}
	
	final void checkStateEvents() {
		stateEvent = null;
		for (WaitNotice w = firstWait; w != null; w = w.suc) {
			if (w.cond == null || w.cond.test()) {
				stateEvent = w.proc;
				return;
			}
		}
	}
	
	final void computeDerivatives() {
		for (Continuous c = firstCont; c != null; c = c.suc) 
            c.derivatives();
    }

    protected void actions() {
        nextTimeEvent = nextEv();           
        while (nextTimeEvent != null || firstWait != null) {
            active = true;
            if (dtMin < 0) 
                error("dtMin < 0");
            if (dtMin > dtMax) 
                error("dtMin > dtMax");
            dt = 0; lastTime = time;
            nextEventTime = nextTimeEvent != null ? nextTimeEvent.evTime() 
                                                  : Double.MAX_VALUE;
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.oldState = v.state;
                v.rate = 0;
            }
            computeDerivatives();
            if (dtNext == 0 || dtNext > dtMax)
                dtNext = dtMax;
            else if (dtNext < dtMin)
                dtNext = dtMin;
            reportPos();
            reportNeg();
            reportZero();
            checkStateEvents();
            if (stateEvent != null) 
                nextEventTime = time; 
            while (time < nextEventTime) {
                for (Variable v = firstVar; v != null; v = v.suc) 
                    v.oldState = v.state;
                lastTime = time;
                dtNow = nextEventTime - lastTime;
                if (firstCont != null) {
                    if (dtNow > dtNext) {
                        dtNow = dtNext;
                        nextTime = lastTime + dtNow;
                        if (nextTime > nextEventTime)
                            nextTime = nextEventTime;
                    } else
                        nextTime = nextEventTime;
                    maxAbsError = Math.abs(maxAbsError);
                    maxRelError = Math.abs(maxRelError);
                    dtFull = dtNext;
                    integrate();
                } else {
                    if (dtNow > dtMax && firstWait != null) {
                        dtNow = dtMax;
                        nextTime = lastTime + dtNow;
                        if (nextTime > nextEventTime)
                            nextTime = nextEventTime;
                    } else
                        nextTime = nextEventTime;
                }
                dt = dtFull = dtNow;
                time = nextTime;
                stateEvent = nextStateEvent = null;
                if (dt > dtMin || time < nextEventTime)
                    checkStateEvents();
                if (stateEvent != null) {
                    if (dtNow <= dtMin || firstCont == null)
                        nextEventTime = time;
                    else {
                        nextStateEvent = stateEvent;
                        for (Variable v = firstVar; v != null; v = v.suc) 
                            v.nextState = v.state;
                        prepareInterpolation();
                        dtLower = 0;
                        dt = 0.5 * dtNow;
                        time = lastTime + dt;
                        interpolate();
                        computeDerivatives();
                        do {
                            checkStateEvents();
                            if (stateEvent != null) {
                                nextStateEvent = stateEvent;
                                stateEvent = null;
                                nextTime = time;
                                dtNow = dt;
                                for (Variable v = firstVar; v != null; v = v.suc) 
                                    v.nextState = v.state;
                            } else
                                dtLower = dt;
                            dt = 0.5 * (dtLower + dtNow);
                            if (dtNow - dtLower <= dtMin || dt <= dtLower || dt >= dtNow) {
                                stateEvent = nextStateEvent;
                                time = nextTime;
                                dt = dtNow;
                                for (Variable v = firstVar; v != null; v = v.suc) 
                                    v.state = v.nextState;
                            } else {
                                time = lastTime + dt;
                                interpolate();
                            }
                            computeDerivatives();
                        } while (stateEvent == null);
                        if (time < nextEventTime) {
                            checkStateEvents();
                            if (stateEvent != null)
                                nextEventTime = time;
                        } else {
                            stateEvent = null;
                            time = nextTime = nextEventTime;
                        }
                    }
                    if (nextReportTime > nextEventTime)
                        nextReportTime = nextEventTime;
                }
                if (firstPosReporter != null && nextReportTime <= time) {
                    if (nextReportTime == time)
                        reportPos();    
                    else {
                        for (Variable v = firstVar; v != null; v = v.suc) 
                            v.nextState = v.state;
                        if (nextStateEvent == null)
                            prepareInterpolation();
                        do {
                            time = nextReportTime;
                            dt = time - lastTime;
                            interpolate();
                            computeDerivatives();
                            reportPos();
                        } while (nextReportTime < nextTime);
                        dt = dtNow;
                        time = nextTime;
                        for (Variable v = firstVar; v != null; v = v.suc) 
                            v.state = v.nextState;
                        computeDerivatives();
                        if (time == nextReportTime)
                            reportPos();
                    }
                }
                reportZero();
                if (time + dtNow <= time && time < nextEventTime)
                    error("The current time step is too small to advance time");
            }
            if (dt > 0)
                reportNeg();
            if (nextTimeEvent == null && stateEvent == null) {
                checkStateEvents();
                if (stateEvent == null)
                    error("Time is at its maximum value and no events occur");
            }
            active = false; 
            if (stateEvent != null) {
                reactivate(stateEvent, at, time);
                nextTimeEvent = stateEvent;
            }
            if (nextTimeEvent != null)
                reactivate(this, after, nextTimeEvent);
            nextTimeEvent = nextEv();    
        } 
        error("There are no discrete events scheduled");
    }
}