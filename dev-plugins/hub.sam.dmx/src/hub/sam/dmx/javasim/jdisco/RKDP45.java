/*
  File: RKDP45.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class provides a monitor that uses the Runge-Kutta-Dormand-Prince
 * fourth-fifth-order integration method.
 * <p>
 * The step-size is variable. The step-size is ajusted so that the 
 * integration error is less than absolute and relative integration 
 * error that can be tolerated at each step (<tt>maxRelError</tt>, <tt>maxAbsArror</tt>).
 * <p>
 * Reference:<br>
 * Dormand, J. R. and Prince, P.J.:<br>
 * "Runge-Kutta triples".
 * Manuscript. Mathematics Dept., Teeside Polytechnic, Middlesbrough, U.K., 1986.
 * <p>
 * @see jDisco.Monitor
*/
class RKDP45 extends Monitor {
    static final double 
        a21 = 1./5.,
        a31 = 3./40., a32 = 9./40.,
        a41 = 44./45., a42 = -56./15., a43 = 32./9.,
        a51 = 19372./6561., a52 = -25360./2187., a53 = 64448./6561., a54 = -212./729.,
        a61 = 9017./3168., a62 = -355./33., a63 = 46732./5247., a64 = 49./176., a65 = -5103./18656.,
        b1 = 35./384., b3 = 500./1113., b4 = 125./192., b5 = -2187./6784., b6 = 11./84.,
        c2 = 1./5., c3 = 3./10., c4 = 4./5., c5 = 8./9., 
        d1 = -12715105075. / 11282082432., d3 = 87487479700. / 32700410799., d4 = -10690763975.  / 1880347072. ,
        d5 = 701980252875. / 199316789632., d6 = -1453857185. / 822651844., d7 = 69997945. / 29380423.,
        e1 = 71./57600., e3 = -71./16695., e4 = 71./1920., e5 = -17253./339200., e6 = 22./525., e7 = -1./40.;
    
    /**
     * Takes a step of length <tt>dtNow</tt> using the Runge-Kutta-Dormand-Prince
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
                v.state = v.oldState + (a51 * v.k1 + a52 * v.k2 + a53 * v.k3 + a54 * v.k4);
            }
            dt = c5 * h;
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k5 = h * v.rate;
                v.state = v.oldState + (a61 * v.k1 + a62 * v.k2 + a63 * v.k3 + a64 * v.k4 + a65 * v.k5);
            }dt = h;
            time = lastTime + dt;
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k2 = v.k5;
                v.k5 = h * v.rate;
                v.ds = b1 * v.k1 + b3 * v.k3 + b4 * v.k4 + b5 * v.k2 + b6 * v.k5;
                v.state = v.oldState + v.ds;
            }
            computeDerivatives();
            errorRatio = 64;
            for (Variable v = firstVar; v != null; v = v.suc) {
                double err = Math.abs(e1 * v.k1 + e3 * v.k3 + e4 * v.k4 + e5 * v.k2 + e6 * v.k5 + e7 * h * v.rate);
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
                        dtNow = dtNext = dtMin;
                    } else {
                        f = 0.5;
                        dtNow = dtNext = h;
                    }
                    h = dtNow;
                    nextTime = lastTime + dtNow;
                    for (v = firstVar; v != null; v = v.suc)
                        v.k1 *= f;
                    break;
                }
            }
        } while (errorRatio < 1);
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
            v.k4 = d1 * v.k1 + d3 * v.k3 + d4 * v.k4 + d5 * v.k2 + 
                   d6 * v.k5 + d7 * dtFull * v.rate;
            v.k3 = - dtFull * v.rate + 2 * v.ds - v.k1;
            v.k2 = v.k1 - v.ds;
            v.k1 = v.ds;
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
            v.ds = f * (v.k1 + (1 - f) * (v.k2 + f * (v.k3 + (1 - f) * v.k4)));
            v.state = v.oldState + v.ds;
        }
    }
}