/*
  File: RKN34.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class provides a monitor that uses the Runge-Kutta-Norsett
 * third-fourth-order integration method.
 * <p>
 * The step-size is variable. The step-size is ajusted so that the 
 * integration error is less than absolute and relative integration 
 * error that can be tolerated at each step (<tt>maxRelError</tt>, <tt>maxAbsArror</tt>).
 * <p>
 * Reference:<br>
 * Enright, W. H., Jackson, K. R., Norsett S. P., and Thomsen, P. G.:
 * "Interpolants for Runge-Kutta Formulas".<br>
 * ACM Trans. Math. Softw., Vol. 12, No. 3, 1986, pp. 193-218.
 * <p>
 * @see jDisco.Monitor
 */
class RKN34 extends Monitor {
    static final double 
        a21 = 3./8.,
        a32 = 9./16.,
        a41 = -125./672., a42 = 325./336., 
        a51 = 371./891., a52 = -200./297., a53 = 1120./891.,
        b1 = 25./162., b2 = 32./135., b3 = 256./567., b5 = 11./70.,
        c2 = 3./8., c3 = 9./16., c4 = 25./32.,
        d1 = 243./250., d2 = 7./250., d3 = 81./1000., d4 = -9./1000., 
        e1 = 37./225. - b1, e2 = 44./117. - b2, e3 = 0. - b3,
        e4 = 448./975. - 0., e5 = 0. - b5; 
    
    /**
     * Takes a step of length <tt>dtNow</tt> using the Runge-Kutta-Norsett
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
                v.state = v.oldState + a32 * v.k2;
            }
            dt = c3 * h;
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k3 = h * v.rate;
                v.state = v.oldState + (a41 * v.k1 + a42 * v.k2);
            }
            dt = c4 * h; 
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k4 = h * v.rate;
                v.state = v.oldState + (a51 * v.k1 + a52 * v.k2 + a53 * v.k3);
            }
            dt = h;
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k5 = h * v.rate;
                v.ds = b1 * v.k1 + b2 * v.k2 + b3 * v.k3 + b5 * v.k5;
                v.state = v.oldState + v.ds;
            }
            errorRatio = 64;
            for (Variable v = firstVar; v != null; v = v.suc) {
                double err = Math.abs(e1 * v.k1 + e2 * v.k2 + e3 * v.k3 + e4 * v.k4 + 
                                      e5 * v.k5);
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
            dtNext = Math.pow(0.5 * errorRatio, 0.25) * dtNow;
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
            v.dsh = v.state;
            v.k2 = dtFull * v.rate;
            v.state = d1 * v.state + d2 * v.oldState + d3 * v.k1 + d4 * v.k2;
        }
        dt = 0.1 * dtFull;
        time = lastTime + dt;
        computeDerivatives(); 
        for (Variable v = firstVar; v != null; v = v.suc) {
            v.k4 = dtFull * v.rate; 
            v.k3 = v.k2;
            v.k2 = v.dsh;
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
        double d0 = (f - 1) * (f - 1) * (15 * f / 4 + 2 * f + 1);
        double d1 = f * (f - 1) * (f - 1) * (1 - 35 * f / 8);
        double d2 = 1 - d0;
        double d3 = f * f * (f - 1) * (85 * f - 13) / 72;
        double d4 = 125 * f * f * (f  - 1) * (f - 1) / 18;
        for (Variable v = firstVar; v != null; v = v.suc)
            v.state = d0 * v.oldState + d1 * v.k1 + 
                      d2 * v.k2 + d3 * v.k3 + d4 * v.k4;
    }
}