/*
  File: FowlerWarten.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class provides a monitor that uses Fowler and Warten's explicit 
 * integration method. This method is especially suited for 
 * <i>stiff</i> differential equations. 
 * <p>
 * The step-size is variable. The step-size is ajusted so that the integration
 * error is less than absolute and relative integration error that can be tolerated
 * at each step (<tt>maxRelError</tt>, <tt>maxAbsArror</tt>).
 * <p>
 * Reference:
 * Fowler, M.E. and Warten, R.M.:
 * "A Numerical Integration Technique for Ordinary 
 * Equations with Widely Separated Eigenvalues". 
 * IBM J. Res. Develop. 11, September 1967, pp. 537-543. 
 *
 * @see jDisco.Monitor
 */
class FowlerWarten extends Monitor {
    double deltaNext;

    /**
     * Takes a step of length <tt>dtNow</tt> using Fowler and Warten's
     * integration method. 
     */
    void integrate() {
        double delta = deltaNext, errorRatio, deltaFull = deltaNext;
        if (delta == 0 || delta > 0.25 * dtNow)
            delta = 0.25 * dtNow;
        for (Variable v = firstVar; v != null; v = v.suc) {
            v.k1 = v.rate;
            v.k2 = dt == 0 ? 0 * v.rate : v.ds / dt;
            v.k3 = v.k1 - v.k2;
            v.state = v.oldState + delta * v.k1;
        }
        
        do {
            dt = delta;
            time = lastTime + dt;
            computeDerivatives();
            errorRatio = 8;
            for (Variable v = firstVar; v != null && errorRatio >= 1; v = v.suc) {
                double err = Math.abs(2 * delta * (v.rate - v.k1));
                double tol = maxAbsError + maxRelError * Math.abs(v.state);
                if (errorRatio * err > tol)
                    errorRatio = tol / err;
                if (errorRatio < 1) {
                    delta = deltaNext = 0.5 * delta;
                    for (v = firstVar; v != null; v = v.suc) 
                        v.state = v.oldState + delta * v.k1;
                    break;
                }
            }
        } while (errorRatio < 1);
        
        if (delta == deltaFull)
            deltaNext = Math.pow(0.5 * errorRatio, 0.5) * delta;
            
        do {
            for (Variable v = firstVar; v != null; v = v.suc) {
                double d1 = v.k3;
                double d2 = (v.rate - v.k1) / delta;
                double lambda = d1 == 0 ? 0 : d2 / d1;
                double lh = lambda * dtNow;
                double c0, c1;
                if (lh < 0) {
                    c0 = Math.exp(lh);
                    c1 = (c0 - 1) / lh;
                } else {
                    c0 = 1 + lh;
                    c1 = 1 + 0.5 * lh;
                }
                v.ds = dtNow * (v.k2 + c1 * v.k3);
                v.state = v.oldState + v.ds;
                v.k4 = c0;
            }
            dt = dtNow;
            time = nextTime;
            computeDerivatives();
            errorRatio = 16;
            for (Variable v = firstVar; v != null && errorRatio >= 1; v = v.suc) {
                double err = Math.abs(dtNow * (v.rate - (v.k2 + v.k4 * v.k3)));
                double tol = maxAbsError + maxRelError * Math.abs(v.state);
                if (errorRatio * err > tol) 
                    errorRatio = tol / err;
                if (errorRatio < 1) {
                    if (dtNow <= dtMin)
                        error("The requested integration accuracy could not be achieved"); 
                    dtNow = dtNext = 0.5 * dtNow;
                    if (dtNow < dtMin)
                        dtNow = dtNext = dtMin;
                    nextTime = lastTime + dtNow;
                    if (nextTime > nextEventTime)
                        nextTime = nextEventTime;
                    double temp = delta;
                    if (delta > 0.25 * dtNow)
                        delta = 0.25 * dtNow;
                    for (v = firstVar; v != null; v = v.suc) {
                        v.rate = v.k1;
                        v.ds = delta * v.rate;
                        v.state = v.oldState + v.ds;
                    }
                    if (temp != delta) {
                        dt = delta;
                        time = lastTime + dt;
                        computeDerivatives();
                    }
                    break;
                }
            }
        } while (errorRatio < 1);
        for (Variable v = firstVar; v != null; v = v.suc)
            v.k1 *= dtNow;
        if (dtNow == dtFull) {
            dtNext = Math.pow(0.5 * errorRatio, 1.0 / 3.0) * dtNow;
            if (dtNext > dtMax)
                dtNext = dtMax;
            if (dtNext < dtMin)
                dtNext = dtMin;
        }
    }
    
    /**
     * Computes for each <tt>Variable</tt>-object the coefficients of a 
     * second-order Hermite polynomium (to be used for interpolation).
     */
    void prepareInterpolation() {
        for (Variable v = firstVar; v != null; v = v.suc) {
            v.k3 = (v.k1 + dtFull * v.rate) - v.ds;
            v.k2 = v.ds - (v.k1 + v.k3);
        }
    }
    
    /**
     * Computes the model state within a step using interpolation. 
     * <p>
     * The interpolation is performed with a polynomials in <tt>f</tt>,
     * where <tt>f</tt> is the fraction <tt>dt/dtFull</tt>, that is, 
     * the actual time incerement, <tt>dt</tt>, divided by the length
     * of the full integration step, <tt>dtFull</tt>. 
     */
    void interpolate() {
        double f = dt / dtFull;
        for (Variable v = firstVar; v != null; v = v.suc) 
            v.state = v.oldState + ((v.k3 * f + v.k2) * f + v.k1) * f;
    }
}