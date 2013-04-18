/*
  File: AdamsBahshorth.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class provides a monitor that uses Adams and Bashforth'
 * predictor-corrector integration method.
 * <p>
 * The order and step-size is variable. The order and step-size are ajusted 
 * so that the integration error is less than absolute and relative integration 
 * error that can be tolerated at each step (<tt>maxRelError</tt>, <tt>maxAbsArror</tt>).
 * <p>
 * Reference:
 * Shampine, L.F. and Gordon, M.K.:  
 * "Computer solution of ordinary differential equations". 
 * W.H. Freeman and Company, San Francisco, 1975.
 *
 * @see jDisco.Monitor
 */
class AdamsBashforth extends Monitor {
    static final int MAXORDER = 12;
    double[] alpha = new double[MAXORDER + 3];
    double[] beta  = new double[MAXORDER + 3];      
    double[] y     = new double[MAXORDER + 3];      
    double[] psi   = new double[MAXORDER + 3];      
    double[] sig   = new double[MAXORDER + 3];      
    double[] g     = new double[MAXORDER + 3];      
    double[] gstr  = new double[MAXORDER + 3];      
    double[] w     = new double[MAXORDER + 3];      
    double[] gi    = new double[MAXORDER + 3];
    int k, kOld, ns;
    double h, hOld, hNew;
    boolean phase1;     
    
    /**
     * Takes a step of length <tt>dtNow</tt> using the Adams-Bashforth
     * integration method. 
     */
    void integrate() { 
        int iFail = 0;
        Variable errorVariable;
        double errorRatio;
        int kp1, kp2, km1, km2, kNew;
        double temp1 = 0, temp2 = 0, temp3, temp4, temp5;
        
        if (g[1] == 0) {
            kp1 = MAXORDER + 1;
            kp2 = kp1 + 1;
            temp1 = 1;
            for (int i = 1; i <= kp1; i++)
                w[i] = 1.0 / i;
            for (int j = 1; j <= kp1; j++) {
                int limit = kp2 - j;
                for (int i = 1; i <= limit; i++) 
                    w[i] -= w[i + 1] / j;
                temp2 = w[1];
                gstr[j] = temp1 - temp2;
                temp1 = temp2;
            }
            g[1] = sig[1] = gi[1] = 1;
            g[2] = 0.5;
        }
        do {
            h = dtNow;
            if (k == 0) {
                for (Variable v = firstVar; v != null; v = v.suc) {
                    v.phi[1] = v.rate; 
                    v.phi[2] = 0;
                    v.k5 = maxAbsError + maxRelError * Math.abs(v.state);
                    if (v.k5 != 0 && v.k5 < 16 * Math.abs(v.rate) * h * h)
                        h = 0.25 * Math.sqrt(v.k5 / Math.abs(v.rate));
                }
                k = 1; 
                kOld = 0;
                hOld = 0; 
                phase1 = true;
                if (h < dtMin)
                    h = dtMin;
                dtNow = dtFull = dtNext = h;
                nextTime = lastTime + dtNow;
                if (nextTime > nextEventTime)
                    nextTime = nextEventTime;
            }
            kp1 = k + 1;
            kp2 = k + 2;
            km1 = k - 1;
            km2 = k - 2;
            if (h != hOld) 
                ns = 1;
            else if (ns <= kOld)
                ns++;
            int nsp1 = ns + 1;
             if (k >= ns) {
                 beta[ns] = 1;
                 alpha[ns] = 1.0 / ns;
                 sig[nsp1] = 1;
                 temp1 = h * ns;
                 for (int i = nsp1; i <= k; i++) {
                     int im1 = i - 1;
                     temp2 = psi[im1];
                     psi[im1] = temp1;
                     beta[i] = beta[im1] * (temp1 / temp2);
                     temp1 = temp2 + h;
                     alpha[i] = h / temp1;
                     sig[i + 1] = i * alpha[i] * sig[i];
                 }
                psi[k] = temp1;
                if (ns == 1) {
                    for (int iq = 1; iq <= k; iq++) 
                        w[iq] = y[iq] = 1.0 / (iq * (iq + 1));
                } else {
                    if (k > kOld) {
                        y[k] = 1.0 / (k * kp1);
                        int nsm2 = ns - 2;
                        for (int j = 1; j <= nsm2; ) {
                            int i = k - j;
                            j++;
                            y[i] -= alpha[j] * y[i + 1];
                        }
                    }
                    int limit = kp1 - ns;
                    temp1 = alpha[ns];
                    for (int iq = 1; iq <= limit; iq++) 
                        w[iq] = y[iq] -= temp1 * y[iq + 1];
                    g[nsp1] = w[1];
                }
                for (int i = ns + 2; i <= kp1; i++) {
                    int limit = kp2 - i;
                    temp1 = alpha[i - 1];
                    for (int iq = 1; iq <= limit; iq++)
                        w[iq] -= temp1 * w[iq + 1];
                    g[i] = w[1];
                }
            }
            for (Variable v = firstVar; v != null; v = v.suc) {
                for (int i = nsp1; i <= k; i++) 
                    v.phi[i] *= beta[i];
                v.phi[kp2] = v.phi[kp1];
                v.phi[kp1] = 0;
                double p = 0;
                for (int i = k; i >= 1; i--) {
                    p += g[i] * v.phi[i];
                    v.phi[i] += v.phi[i + 1];
                }
                v.dsh = h * p;
                v.state = v.oldState + v.dsh;
                v.rate = 0;
            }
            dt = h;
            time = nextTime;
            computeDerivatives();
            if (km2 > 0)
                temp1 = h * sig[km1] * gstr[km2];
            if (km2 >= 0)
                temp2 = h * sig[k] * gstr[km1];
            temp3 = h * sig[kp1] * gstr[k];
            temp5 = h * (g[k] - g[kp1]);
            kNew = km2 >= 0 ? km1 : 1;
            errorVariable = null;
            for (Variable v = firstVar; v != null; v = v.suc) {
                temp4 = v.rate - v.phi[1];
                v.k2 = temp3 * Math.abs(temp4);
                if (km2 >= 0) {
                    v.k1 = temp2 * Math.abs(v.phi[k] + temp4);
                    if (km2 == 0) {
                        if (v.k1 > 0.5 * v.k2)
                            kNew = k;
                    } else if (v.k1 > v.k2 ||
                               temp1 * Math.abs(v.phi[km1] + temp4) > v.k2)
                        kNew = k;
                }
                v.k4 = temp4 * temp5;
                v.k5 = maxAbsError + maxRelError * Math.abs(v.state);
                if (Math.abs(v.k4) > v.k5) {
                    errorVariable = v;
                    break;
                }
            }
            if (errorVariable != null) {
                if (h > dtMin) {
                    iFail++;
                    phase1 = false;
                    temp2 = 0.5;
                    if (iFail >= 3)
                        kNew = 1;
                    if (iFail > 3) {
                        errorRatio = 0.5;
                        for (Variable v = firstVar; v != null; v = v.suc) {
                            if (v.k5 != 0 && v.k5 < errorRatio * v.k2)
                                errorRatio = v.k5 / v.k2;
                        }
                        if (errorRatio < 0.5)
                            temp2 = Math.sqrt(0.5 * errorRatio);
                    }
                    hNew = temp2 * h;
                    if (hNew < dtMin) 
                        hNew = dtMin; 
                    dtNext = dtNow = hNew;
                    nextTime = lastTime + dtNow;
                    if (nextTime > nextEventTime)
                        nextTime = nextEventTime;
                    for (Variable v = firstVar; v != null; v = v.suc) {
                        for (int i = 1; i <= k; i++) 
                            v.phi[i] = (v.phi[i] - v.phi[i + 1]) / beta[i];
                        v.state = v.oldState;
                        v.ds = 0;
                    }
                    for (int i = nsp1; i <= k; i++) 
                        psi[i - 1] = psi[i] - h;
                    k = kNew;
                } else 
                    error("The requested integration accuracy could not be achieved");
            } 
        } while (errorVariable != null);
                
        kOld = k;
        hOld = h;
        temp1 = h * g[kp1];
        for (Variable v = firstVar; v != null; v = v.suc) {
            v.ds = v.dsh += temp1 * (v.rate - v.phi[1]);
            v.state = v.oldState + v.ds;
            v.rate = 0;
        }
        computeDerivatives();
        for (Variable v = firstVar; v != null; v = v.suc) {
            v.phi[kp1] = temp1 = v.rate - v.phi[1];
            v.phi[kp2] = temp1 - v.phi[kp2];
            v.phi[1] = v.rate;
            for (int i = 2; i <= k; i++)
                v.phi[i] += temp1;
        }
        if (kNew == km1 || k == MAXORDER)
            phase1 = false;
        hNew = 2 * h;
        if (!phase1) {
            if (kp1 <= ns && kNew != km1) {
                temp1 = h * gstr[kp1];
                for (Variable v = firstVar; v != null; v = v.suc) 
                    v.k3 = temp1 * Math.abs(v.phi[kp2]);
                if (k == 1) {
                    kNew = kp1;
                    for (Variable v = firstVar; v != null; v = v.suc) 
                        if (v.k3 > 0.5 * v.k2) {
                            kNew = k;
                            break;
                        }
                } else {
                    kNew = km1;
                    for (Variable v = firstVar; v != null; v = v.suc) 
                        if (v.k1 > v.k2 || v.k1 > v.k3) {
                            kNew = k;
                            break;
                        }
                    if (kNew != km1 && k < MAXORDER) {
                        kNew = kp1;
                        for (Variable v = firstVar; v != null; v = v.suc)
                            if (v.k3 > v.k2) {
                                kNew = k;
                                break;
                            }
                    }
                }
            }
            errorRatio = temp2 = Math.pow(2, kNew + 2);
            for (Variable v = firstVar; v != null; v = v.suc) {
                temp1 = kNew == k ? v.k2 : kNew == km1 ? v.k1 : v.k3;
                v.k5 = maxAbsError + 
                       0.5 * maxRelError * (Math.abs(v.oldState) + Math.abs(v.state));
                if (v.k5 != 0 && v.k5 < errorRatio * temp1)
                    errorRatio = v.k5 / temp1;
            }
            if (errorRatio < temp2) {
                hNew = h;
                if (errorRatio < 2) {
                    double r = Math.pow(0.5 * errorRatio, 1.0 / (kNew + 1));
                    if (r > 0.9)
                        r = 0.9;
                    else if (r < 0.5)
                        r = 0.5;
                    hNew = r * h;
                }
            }
            k = kNew;    
        } else
            k = kp1;
        if (dtNow == dtFull)
            dtNext = hNew < dtMin ? dtMin : hNew > dtMax ? dtMax : hNew;
        if (time == nextEventTime)
            k = 0;
    }
    
    /**
     * Computes the model state within a step using interpolation. 
     * <p>
     * The actual time incerement is <tt>dt</tt>, and the full integration step
     * is <tt>dtFull</tt>. 
     */
    void interpolate() { 
        double hi = dt - dtFull;
        int ki = kOld + 1;
        int kip1 = ki + 1;
        for (int i = 1; i <= ki; i++) 
            w[i] = 1.0 / i;
        double temp1 = 0;
        for (int j = 2; j <= ki; j++) {
            double temp2 = psi[j - 1];
            double temp3 = (hi + temp1) / temp2;
            double temp4 = hi / temp2;
            int limit = kip1 - j;
            for (int i = 1; i <= limit; i++)
                w[i] = temp3 * w[i] - temp4 * w[i + 1];
            gi[j] = w[1];
            temp1 = temp2;
        }
        for (Variable v = firstVar; v != null; v = v.suc) {
            double p = 0;
            for (int i = ki; i >= 1; i--)
                p += gi[i] * v.phi[i];
            v.ds = v.dsh + hi * p;
            v.state = v.oldState + v.ds;
        }
        computeDerivatives();
    }
}