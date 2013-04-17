/*
  File: Adams.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class provides a monitor that uses Adams' second-order integration method.
 * <p>
 * The step-size is fixed. The step-size remains constant at the maximum
 * prescribed by the user, <tt>dtMax</tt>, unless an event occurs within a step. 
 *
 * @see jDisco.Monitor
 */
class Adams extends Monitor {
    /**
     * Takes a step of length <tt>dtNow</tt> using Adams' second-order 
     * integration method. 
     */
    void integrate() {
        for (Variable v = firstVar; v != null; v = v.suc) {
            v.k1 = dtNow * v.rate;
            v.ds = dt == dtNow ? 1.5 * v.k1 - v.dsh : 0.5 * v.k1;
            v.dsh = 0.5 * v.k1;
            v.state = v.oldState + v.ds;
        }
        dt = dtNow;
        time = nextTime;
        if (dt != dtNow) {
            computeDerivatives();
            for (Variable v = firstVar; v != null; v = v.suc) {
                v.k2 = dtNow * v.rate;
                v.ds = 0.5 * (v.k1 + v.k2);
                v.state = v.oldState + v.ds;
            }
        }
        computeDerivatives();
    }
    
    /**
     * Computes for each <tt>Variable</tt>-object the coefficients of a 
     * second-order Hermite polynomium (to be used for interpolation).
     */
    void prepareInterpolation() {
        for (Variable v = firstVar; v != null; v = v.suc) {
            v.k3 = (v.k1 + dtFull * v.rate) - 2 * v.ds;
            v.k2 = v.ds - (v.k1 + v.k3);
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
        for (Variable v = firstVar; v != null; v = v.suc) 
            v.state = v.oldState + ((v.k3 * f + v.k2) * f + v.k1) * f;
    }
}