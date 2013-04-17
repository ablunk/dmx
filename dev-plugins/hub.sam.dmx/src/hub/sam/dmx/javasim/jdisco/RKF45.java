/*
  File: RKF45.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class provides a monitor that uses the Runge-Kutta-Fehlberg
 * fourth-fifth-order integration method.
 * <p>
 * The step-size is variable. The step-size is ajusted so that the 
 * integration error is less than absolute and relative integration 
 * error that can be tolerated at each step (<tt>maxRelError</tt>, <tt>maxAbsArror</tt>).
 * <p>
 * Reference:<br>
 * Fehlberg, E.:<br>
 * Klassische Runge-Kutta-Formeln vierter und niedriger Ordning mit
 * Schrittweiten-Kontrolle und ihre Anwendung auf W„rmeleitungsprobleme".<br>
 * Computing, Vol.6, No. 1-2, 1970, pp. 61-71.
 * <p>
 * @see jDisco.Monitor
 */
class RKF45 extends Monitor {
    static final double 
        a21 = 1./4.,
        a31 = 3./32., a32 = 9./32.,
        a41 = 1932./2197., a42 = -7200./2197., a43 = 7296./2197.,
        a51 = 439./216., a52 = -8., a53 = 3680./513., a54 = -845./4104.,
        a61 = -8./27., a62 = 2., a63 = -3544./2565., a64 = 1859./4104., a65 = -11./40.,
        b1 = 16./135., b3 = 6656./12825., b4 = 28561./56430., b5 = -9./50., b6 = 2./55.,
        c2 = 1./4., c3 = 3./8., c4 = 12./13., c6 = 1./2.,
        d1 = 1559./12500., d3 = 153856. / 296875., d4 = 68107./ 2612500.,
        d5 = -243./ 31250., d6 = -2106./ 34375.,
        e1 = 25./216. - b1, e3 = 1408./2565. - b3, e4 = 2197./4104. - b4,
        e5 = -1./5. - b5, e6 = 0. - b6; 
    
    /**
     * Takes a step of length <tt>dtNow</tt> using the Runge-Kutta-Fehlberg
     * integration method. 
     */                    
    void integrate() {
        double h = dtNow, errorRatio;
        
        for (Variable v = firstVar; v != null; v = v.suc)
            v.k1 = h * v.rate;
        
        do {
            for (Variable v = firstVar; v != null; v = v.suc) 
                v.state = v.oldState + a21 * v.k1;
            dt = c2 * h; 
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k2 = h * v.rate;
                v.state = v.oldState + (a31 * v.k1 + a32 * v.k2);
            }
            dt = c3 * h;
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k3 = h * v.rate;
                v.state = v.oldState + (a41 * v.k1 + a42 * v.k2 + a43 * v.k3);
            }
            dt = c4 * h; 
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k4 = h * v.rate;
                v.state = v.oldState + (a51 * v.k1 + a52 * v.k2 + a53 * v.k3 + 
                                        a54 * v.k4);
            }
            dt = h;
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k5 = h * v.rate;
                v.state = v.oldState + (a61 * v.k1 + a62 * v.k2 + a63 * v.k3 + 
                                        a64 * v.k4 + a65 * v.k5);
            }
            dt = c6 * h;
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k6 = h * v.rate;
                v.ds = b1 * v.k1 + b3 * v.k3 + b4 * v.k4 + 
                       b5 * v.k5 + b6 * v.k6;
                v.state = v.oldState + v.ds;
            }
            errorRatio = 64;
            for (Variable v = firstVar; v != null; v = v.suc) {
                double err = Math.abs(e1 * v.k1 + e3 * v.k3 + e4 * v.k4 + e5 * v.k5 + 
                                      e6 * v.k6);
                double tol = maxAbsError + 
                             0.5 * maxRelError * (Math.abs(v.oldState) + Math.abs(v.state));
                if (errorRatio * err > tol)
                    errorRatio = tol / err;
                if (errorRatio < 1) {
                    if (dtNow <= dtMin)
                        error("The requested integration accuracy could not be achieved"); 
                    double f;
                    h *= 0.5;
                    if (h < dtMin) {
                        f = dtMin / dtNow;
                        dtNow = dtNext = h = dtMin;
                    } else {
                        f = 0.5;
                        dtNow = dtNext = h;
                    }
                    nextTime = lastTime + dtNow;
                    for (v = firstVar; v != null; v = v.suc) 
                        v.k1 *= f;
                    break;
                }
            }
        } while (errorRatio < 1);
        dt = dtNow;
        time = nextTime;
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
     * foruth-order Hermite polynomium (to be used for interpolation).
     */
    void prepareInterpolation() { 
        for (Variable v = firstVar; v != null; v = v.suc) {
            v.k4 = v.oldState + (d1 * v.k1 + d3 * v.k3 + d4 * v.k4 + d5 * v.k5 + d6 * v.k6);
            v.k3 = dtFull * v.rate;
            v.k2 = v.state;
        }    
    }
    
    /**
     * Computes the model state within a step using interpolation. 
     * <p>
     * The interpolation is performed with polynomials in <tt>f</tt>,
     * where <tt>f</tt> is the fraction <tt>dt/dtFull</tt>, that is, 
     * the actual time incerement, <tt>dt</tt>, divided by the length
     * of the full integration step, <tt>dtFull</tt>. 
     * <p>
     * Reference:<br>
     * Enright, W. H., Jackson, K. R., Norsett S. P., and Thomsen, P. G.:
     * "Interpolants for Runge-Kutta Formulas".<br>
     * ACM Trans. Math. Softw., Vol. 12, No. 3, 1986, pp. 193-218.
     */    
    void interpolate() {
        double f = dt / dtFull;
        double d0 = (f - 1) * (f - 1) * (1 - 5 * f / 3) * (11 * f / 3 + 1);
        double d1 = f * (f - 1) * (f - 1) * (1 - 5 * f / 3);
        double d2 = f * f * (3 - 5 * f) / 4 * (9 * f - 11);
        double d3 = f * f * (f - 1) * (5 * f - 3) / 2;
        double d4 = 625 * f * f / 36 * (f - 1) * (f - 1);
        for (Variable v = firstVar; v != null; v = v.suc)
            v.state = d0 * v.oldState + d1 * v.k1 + 
                      d2 * v.k2 + d3 * v.k3 + d4 * v.k4;
    }
}