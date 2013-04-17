/*
  File: RKV56.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class provides a monitor that uses the Runge-Kutta-Verner
 * fifth-sixth-order integration method.
 * <p>
 * The step-size is variable. The step-size is ajusted so that the 
 * integration error is less than absolute and relative integration 
 * error that can be tolerated at each step (<tt>maxRelError</tt>, <tt>maxAbsArror</tt>).
 * <p>
 * Reference:<br>
 * Hull, T. E., Enright, W. E., and Jackson, K. R.:<br>
 * "User's guide for DVERK - A subroutine for solving non-stiff ODE's."
 * Rept. 100, Dept. of Computer Science, Uinv. of Toronto,
 * Toronto, Canad, 1976.
 * <p>
 * @see jDisco.Monitor
 */
class RKV56 extends Monitor {
    static final double 
        a21 = 1./6.,
        a31 = 4./75., a32 = 16./75.,
        a41 = 5./6., a42 = -8./3., a43 = 5./2.,
        a51 = -165./64., a52 = 55./6., a53 = -425./64., a54 = 85./96.,
        a61 = 12./5., a62 = -8., a63 = 4015./612., a64 = -11./36., a65 = 88./255.,
        a71 = -8263./15000., a72 = 124./75., a73 = -643./680., a74 = -81./250., a75 = 2484./10625.,
        a81 = 3501./1720., a82 = -300./43., a83 = 297275./52632., a84 = -319./2322.,
        a85 = 24068./ 84065, a87 = 3850./26703.,
        b1 = 3./40., b3 = 875./2244., b4 = 23./72., b5 = 264./1955., 
        b7 = 125./11592., b8 = 43./616.,
        c2 = 1./6., c3 = 4./15., c4 = 2./3., c5 = 5./6., c7 = 1./15.,
        d1 = 121./ 1536., d3 = 317125. / 861696., d4 = 397./ 6912.,
        d5 = -1./ 68., d6 = 17./ 704., d7 = 125./12096., d8 = -817./14784., d9 = 1./32.,
        e1 = 13./160. - b1, e3 = 2375./5984. - b3, e4 = 5./16. - b4, e5 = 12./85. - b5,
        e6 = 3./44 - .0, e7 = 0. - b7, e8 = 0. - b8;
    
    /**
     * Takes a step of length <tt>dtNow</tt> using the Runge-Kutta-Verner
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
            dt = c5 * h;
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k5 = h * v.rate;
                v.state = v.oldState + (a61 * v.k1 + a62 * v.k2 + a63 * v.k3 + 
                                        a64 * v.k4 + a65 * v.k5);
            }
            dt = h;
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k6 = h * v.rate; 
                v.state = v.oldState + (a71 * v.k1 + a72 * v.k2 + a73 * v.k3 + 
                                        a74 * v.k4 + a75 * v.k5);
            }
            dt = c7 * h;
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k7 = h * v.rate;
                v.state = v.oldState + (a81 * v.k1 + a82 * v.k2 + a83 * v.k3 + 
                                        a84 * v.k4 + a85 * v.k5 + a87 * v.k7);
            }
            dt = h;
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k8 = h * v.rate;
                v.ds = b1 * v.k1 + b3 * v.k3 + b4 * v.k4 + 
                       b5 * v.k5 + b7 * v.k7 + b8 * v.k8;
                v.state = v.oldState + v.ds;
            }
            errorRatio = 64;
            for (Variable v = firstVar; v != null; v = v.suc) {
                double err = Math.abs(e1 * v.k1 + e3 * v.k3 + e4 * v.k4 + e5 * v.k5 + 
                                      e6 * v.k6 + e7 * v.k7 + e8 * v.k8);
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
        computeDerivatives();
        if (dtNow == dtFull) {
            dtNext = Math.pow(0.5 * errorRatio, 1./6.) * dtNow;
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
            v.dsh = v.state;
            v.k2 = dtFull * v.rate;
            v.state = v.oldState + (d1 * v.k1 + d3 * v.k3 + d4 * v.k4 + d5 * v.k5 + 
                                       d6 * v.k6 + d7 * v.k7 + d8 * v.k8 + d9 * v.k2);
        }
        dt = 0.5 * dtFull;
        time = lastTime + dt;
        computeDerivatives(); 
        for (Variable v = firstVar; v != null; v = v.suc) {
            v.k5 = dtFull * v.rate;
            v.k4 = v.state; 
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
        double d0 = 4 * (f - 1) * (f - 1) * (f - 0.5) * (f - 0.5) * (6 * f + 1);
        double d1 = 4 * f * (f - 1) * (f - 1) * (f - 0.5) * (f - 0.5);
        double d2 = 4 * f * f * (0.5 - f) * (0.5 - f) * (7 - 6 * f);
        double d3 = 4 * (f - 1) * (f - 1) * f * f * (f - 0.5) * (f - 0.5);
        double d4 = 16 * f * f * (f - 1) * (f - 1);
        double d5 = 16 * f * f * (f - 1) * (f - 1) * (f - 0.5); 
        for (Variable v = firstVar; v != null; v = v.suc)
            v.state = d0 * v.oldState + d1 * v.k1 + 
                      d2 * v.k2 + d3 * v.k3 + d4 * v.k4 + d5 * v.k5;
    }
}