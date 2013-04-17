/*
  File: RKE.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class provides a monitor that uses the Runge-Kutta-England
 * fourth-order integration method.
 * <p>
 * The step-size is variable. The step-size is ajusted so that the 
 * integration error is less than absolute and relative integration 
 * error that can be tolerated at each step (<tt>maxRelError</tt>, <tt>maxAbsArror</tt>).
 * <p>
 * Reference:<br>
 * England,R.:<br>
 * "Error estimates for Runge-Kutta type solutions to systems 
 * of ordinary differential equations".<br> 
 * Computer Journal, Vol. 12, 1969, pp. 166-170. 
 * <p>
 * @see jDisco.Monitor
 */
class RKE extends Monitor {
    /**
     * Takes a step of length <tt>dtNow</tt> using the Runge-Kutta-England
     * integration method. 
     */
    void integrate() {
        double h = 0.5 * dtNow, errorRatio;
        
        for (Variable v = firstVar; v != null; v = v.suc)
            v.k1 = h * v.rate;

        do {
            for (Variable v = firstVar; v != null; v = v.suc) 
                v.state = v.oldState + 0.5 * v.k1;
            dt = 0.5 * h; 
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k2 = h * v.rate;
                v.state = v.oldState + 0.25 * (v.k1 + v.k2);
            }
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k3 = h * v.rate;
                v.state = v.oldState + (2 * v.k3 - v.k2);
            }
            dt = h; 
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k4 = h * v.rate;
                v.dsh = (v.k1 + v.k4 + 4 * v.k3) / 6;
                v.state = v.oldState + v.dsh;
            }
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k5 = h * v.rate;
                v.ds = -v.dsh + 24 * v.k5 - 20 * v.k4 + 16 * (v.k3 - v.k2);
                v.k4 = -v.k1 + 4 * v.k3 + 17 * v.k4 - 23 * v.k5;
                v.state = v.oldState + (v.dsh + 0.5 * v.k5);
            }
            dt = 1.5 * h;
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k2 = h * v.rate;
                v.state = v.oldState + (v.dsh + 0.25 * (v.k5 + v.k2));
            }
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k3 = h * v.rate;
                v.state = v.oldState + (v.ds + v.k2 - 2 * v.k3);
            }
            dt = dtNow;
            time = nextTime;
            computeDerivatives();
            errorRatio = 64;
            for (Variable v = firstVar; v != null; v = v.suc) {
                double err = Math.abs((4 * v.k3 - h * v.rate + v.k4) / 90);
                double tol = maxAbsError + 
                             0.5 * maxRelError * (Math.abs(v.oldState) + Math.abs(v.state));
                if (errorRatio * err > tol)
                    errorRatio = tol / err;
                if (errorRatio < 1) {
                    if (dtNow <= dtMin)
                        error("The requested integration accuracy could not be achieved"); 
                    double f;
                    if (h < dtMin) {
                        f = dtMin / dtNow;
                        dtNow = dtNext = dtMin;
                    } else {
                        f = 0.5;
                        dtNow = dtNext = h;
                    }
                    h = 0.5 * dtNow;
                    nextTime = lastTime + dtNow;
                    for (v = firstVar; v != null; v = v.suc)
                        v.k1 *= f;
                    break;
                } 
                v.state = v.oldState + (v.dsh + 2 * v.k3 - v.k2);
            }
        } while (errorRatio < 1);
        computeDerivatives();
        for (Variable v = firstVar; v != null; v = v.suc) {
            v.ds = v.dsh + (v.k5 + h * v.rate + 4 * v.k3) / 6;
            v.state = v.oldState + v.ds;
        }
        computeDerivatives();
        if (dtNow == dtFull) {
            dtNext = Math.pow(0.5 * errorRatio, 1./5.) * dtNow;
            if (dtNext > dtMax)
                dtNext = dtMax;
            if (dtNext < dtMin)
                dtNext = dtMin;
        }
    } 
    
    /**
     * Computes for each <tt>Variable</tt>-object the coefficients of a 
     * fourth-order Hermite polynomium (to be used for interpolation).
     */
    void prepareInterpolation() {
        for (Variable v = firstVar; v != null; v = v.suc) {
            double temp = 0.5 * dtFull * v.rate;
            v.k4 = 16 * v.dsh + 52 * v.ds - 16 * temp - 24 * v.k1 - 80 * v.k5;
            v.k3 = 10 * temp + 26 * v.k1 + 64 * v.k5 - 32 * v.dsh - 34 * v.ds;
            v.k2 = 7 * v.ds + 16 * v.dsh - 2 * temp - 12 * v.k1 - 16 * v.k5;
            v.k5 = 8 * v.k1 + 8 * temp + 32 * v.k5 - 24 * v.ds;
            v.k1 *= 2;
        }        
    }
    
    /**
     * Computes the model state within a step using interpolation. 
     * <p>
     * The interpolation is performed with polynomials in <tt>f</tt>,
     * where <tt>f</tt> is the fraction <tt>dt/dtFull</tt>, that is, 
     * the actual time incerement, <tt>dt</tt>, divided by the length
     * of the full integration step, <tt>dtFull</tt>. 
     */    
    void interpolate() {
        double f = dt / dtFull;
        for (Variable v = firstVar; v != null; v = v.suc) {
            v.ds = ((((v.k5 * f + v.k4) * f + v.k3) * f + v.k2) * f + v.k1) * f;
            v.state = v.oldState + v.ds;
        }
    }
}