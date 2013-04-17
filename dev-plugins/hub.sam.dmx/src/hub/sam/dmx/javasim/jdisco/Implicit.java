/*
  File: Implicit.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * In describing continuous processes it is the user's responsibility that the equations 
 * are evaluated in the correct order: variables must be updated before they are used on 
 * the right-hand side of an equation.
 * <p>
 * The user can determine the order of evaluation within each continuous process and the 
 * continuous processes themselves may be ranked by giving them a priority. Usually by 
 * these means a correct evaluation order can be achieved. 
 * <p>
 * In some cases, however, this is impossible: there is an "algebraic loop" in the equation 
 * system. 
 * <p>
 * An algebraic loop can often be circumvented by either rewriting the equations or using 
 * the class <tt>Implicit</tt>.  
 * <p>
 * Class <tt>Implicit</tt> is used to solve equations of the form
 * <br><pre>
 *         x = f(x) </pre>
 * that is, to find the <i>fixpoint</i> of the function <tt>f</tt>.
 * <p>
 * The mthod <tt>fixPoint</tt> finds an x satsifying the equation
 * with a given tolerance, <tt>tol</tt>, i.e.
 * <pre>
 *        |x - f(x)| <= |tol| </pre>
 * Wegstein's accelerated convergence algorithm is used to compute x. The algorithm 
 * is iterative and uses the paramter value of x as an initial guess for x. 
 * <p>
 * If the tolerance criterion is not satisfied after 100 iterations, the program 
 * stops with the error message: 
 * <br><pre><tt>
 *         Implicit: Convergence is not achieved within 100 iterations 
 * </tt></pre>
 */
public abstract class Implicit {
    /**
     * The function <tt>f</tt>. To be supplied in a subclass of <tt>Implicit</tt>.
     */ 
    protected abstract double f(double x);
    
    /**
     * Returns the fixpoint of the function <tt>f</tt>.
     *
     * @param <tt>x</tt> initial guess for x.
     * @param <tt>tol</tt> the tolerance.
     */
    public double fixPoint(double x, double tol) {
        tol = Math.abs(tol);
        double x1, x2, y1, y2, c;
        x1 = x2 = x;
        y1 = y2 = f(x);
        for (int i = 1; i <= 100 && Math.abs(y2 - x2) > tol; i++) {
            c = x1 == x2 ? -1 : (y2 - y1) / (x2 - x1);
            x1 = x2; y1 = y2;
            x = x2 = c == 1 ? y2 : (y2 - c * x2) / (1 - c);
            y2 = f(x);
        } 
        if (Math.abs(y2 - x2) > tol)
            Process.error("Implicit: Convergence is not achieved within 100 iterations");
        return y2;
    }
    
    /**
     * Returns the fixpoint of the function <tt>f</tt> with 1 as an initial guess for x
     * and tolerance of 1.0e-5.
     */
    public double fixPoint() {
        return fixPoint(1, 1.0e-5);
    }
} 