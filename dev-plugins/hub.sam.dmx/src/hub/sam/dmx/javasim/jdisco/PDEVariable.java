/*
  File: PDEVariable.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date        Who                What
  20Sep2001   kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class may used for the description of state-variables that vary according 
 * to partial differential equations.<vr>
 * <p>
 * The class is designed mainly for the solution of nonlinear parabolic initial 
 * value problems in one space dimension within a limited interval, xLeft <= x <= xRight. 
 * Solution of hyperbolic and elliptic problems may also be attempted. 
 * <p>
 * A <tt>PDEVariable</tt>-object represents a variable, u(t,x), that varies according to
 * a partial differential equation of the following form:
 * <pre>
 *       du/dt = f(t, x,u, du/dx, 1/x<sup>c</sup> * d/dx(x<sup>c</sup> * D * du/dx))</pre> 
 * This equation represents the coupled system of partial differential equations, 
 * where u is a vector and xLeft < x < xRight.
 * <p>
 * At the left boundary, x = xLeft, 
 * the boundary condition is characterised as follows:
 * <pre>
 *     b1Left * u(t,x) + b2Left * du/dx = b3Left</pre>
 * At the right boundary, x = xRight, the boundary condition is characterised 
 * as follows:
 * <pre>
 *     b1Right * u(t,x) + b2Right * du/dx = b3Right</pre>
 * The initial condition (at t = t0) is characterised as follows:
 * <pre>
 *     u(t0,x) = g(x)</pre>
 * The 'diffusion coefficient', D, in the equation above is a function of t, x, and u. 
 * c is 0, 1, or 2, depending on whether the problem is Cartesian, 
 * cylindrical, or spherical, respectively. The 'left boundary coefficients', 
 * b1Left, beLeft, and b3Left, may be functions of t, x, and u. If b1Left and b2Left 
 * are both zero, the following condition is used at the left boundary:
 * <pre>
 *     du(t,xLeft)/dt = b3Left</pre>
 * The same is true for the 'right boundary coefficients', b1Right, beRight, and b3Right.
 * <p>
 * The partial diffeerntial equations are expressed by the user in subclasses 
 * of class <tt>PDEVariable</tt> by overriding the method <tt>rate</tt>. 
 * The two independent variables are denoted by <tt>t()</tt> and <tt>x()</tt>. 
 * The initial and boundary conditions are specified by
 * overriding the methods <tt>initialState</tt>, <tt>b1Left</tt>, <tt>b2Left</tt>,
 * <tt>b3Left</tt>, <tt>b1Right</tt>,<tt>b2Right</tt>, and <tt>b3Right</tt>. The diffusion
 * coefficient is specified by overriding the method D.
 * <p>
 * The equations are solved using the so-called 'method of lines' in which the 
 * spatial variable, x, is "discretized", while the time variable, t = time, 
 * remains "continuous". Roughly speaking, the method can be described as follows. 
 * If one has a time dependent partial differential equation and discretizes the 
 * spatial variable, a semi-discrete approximating system of 'ordinary' differential 
 * equations results. One then uses an ordinary differential equation integration method, 
 * for example the Runge-Kutta-Fehlberg method, for solving the resulting equations to 
 * obtain numerical approximations to the original partial differential equation.
 * <p>
 * The user specifies a spatial mesh consisting of a given number equidistant points
 * between  xLeft and xRight. This information is passed to the constructor of 
 * <tt>PDEVariable</tt>, which splits the partial differential equations into a 
 * system of approximating ordinary differential.
 * <p>
 * An example:<br>
 * <br>
 * Consider the following partial differential equation:
 * <pre>
 *     du/dt = -u * du/dx + x * d/dx(u * du/dx) + t</pre>
 * for x between xLeft = 0 and xRight = 1, and for t beween 0 and 1.2. 
 * Further, assume the initial condition
 * <pre>
 *     u(0,x) = x</pre>
 * and the non-linear boundary conditions
 * <pre>
 *     u(t,xLeft) = = 50
 * 
 *     du(t,xRight)/dt = du(t,1)/dt = 1 - sin(u(t,1))</pre>
 * A complete jDisco-program for solving this problem is given below. 
 * <pre><tt>
 * import jDisco.*;
 * import jDisco.Process;
 * 
 * public class PDEExample extends Process {
 *     PDEVariable u;<br>
 *		
 *     class U extends PDEVariable {
 *         U(double xLeft, double xRight, int nPoints) {
 *             super(xLeft, xRight, nPoints);
 *         }
 *		
 *         public double rate() { 
 *             return -state() * dx() + x() * ddx() + t(); 
 *         }
 *		
 *         public double D() { return state(); } 
 *		
 *         public double initialState() { return x(); }
 *		
 *         public double b1Left()  { return 1; }
 *         public double b3Left()  { return 50; }
 *         public double b1Right() { return 1; }
 *         public double b3Right() { return 1 - Math.sin(state()); }
 *     }<br>
 *
 *     public void actions() {
 *         dtMin = 1.0e-5; dtMax = 1.0; 
 *         maxAbsError = maxRelError = 1.0e-4;
 *         u = new U(0, 1, 21);
 *         u.start();
 *         hold(1.2);
 *         u.show();
 *     }<br>
 *    	
 *     public static void main(String[] args) {
 *         activate(new PDEExample());
 *     }
 * }
 * </tt></pre>
 * The design and implementation of class <tt>PDEVariable</tt> has been inspired by the
 * Fortran subroutine PDEONE.
 * <p>
 * Reference: <br>
 * Sincovec, R.F and Madsen, N.K.:<br>
 * "Software for Nonlinear Partial Differential Equations".<br>  
 * ACM Transactions on Mathematical Software,<br>
 * Vol. 1, No. 3, September 1975, pp. 232-260 and 261-263. 
 */
public abstract class PDEVariable extends Continuous {
	/**
	 * Constructs a <tt>PDEVariable</tt>-object with <tt>nPoints</tt> equidistant points.
	 * between <tt>sLeft</tt> and <tt>xMax</tt>. 
	 */
	public PDEVariable(double xLeft, double xRight, int nPoints) {
		if (nPoints <= 1)
			Process.error("new PDEVariable( , , nPoints) : nPoints <= 1");
		this.xLeft = xLeft;
		this.xRight = xRight;
		this.nPoints = nPoints;	
		points = new Head();
		for (int i = 1; i <= nPoints; i++) {
			x = (double) (i - 1) / (nPoints - 1);
			x = (1 - x) * xLeft + x * xRight;
			new Point(x, initialState()).into(points);
		}
		setPriority(Double.MIN_VALUE);
		p = pp = (Point) points.first();
		ps = (Point) p.suc();
	}
	
	/**
	 * The rate, du/dt. Must be supplied in a subclass of <tt>PDEVariable</tt>.
	 */
	public abstract double rate();
	
	/**
	 * The initial state, u(t0, x). Returns 0, but may be overridden.  
	 */
	public double initialState() { return 0; }
	
	/**
	 * The diffusion coefficient. Returns 1, bu may be overridden.
	 */
	public double D() { return 1; }
	
	/**
	 * Returns 0, but may be overridden.
	 */
	public double b1Left() { return 0;}
	
	/**
	 * Returns 0, but may be overridden.
	 */
	public double b1Right() { return 0; }
		
	/**
	 * Returns 0, but may be overridden.
	 */
	public double b2Left() { return 0; }
	
	/**
	 * Returns 0, but may be overridden.
	 */
	public double b2Right() { return 0; }
	
	/**
	 * Returns 0, but may be overridden.
	 */
	public double b3Left() { return 0; }
		
	/**
	 * Returns 0, but may be overridden.
	 */
	public double b3Right() { return 0; }
		
	/**
	 * Returns the state, u(t, x).
	 */
	public final double state() {
		if (p.x != xNow)
			search();
		return x == xNow ? p.state : 
		       0.5 * (p.state + (x > xNow ? ps.state : pp.state));
	}
	
	/**
	 * Returns the state at the left bondary, u(t, xLeft).
	 */
	public final double leftState() {
		return ((Point) points.first()).state;
	}
	
	/**
	 * Returns the state at the right bondary, u(t, xRight).
	 */
	public final double rightState() {
		return ((Point) points.last()).state;
	}
	
	/**
	 * Returns an approximation to the derivative with respect to x, du/dx.
	 */
	public final double dx() {
		if (p.x != xNow)
			search();
		return pp == p && b2L != 0 ? (b3L - b1L * p.state) / b2L :
		       ps == p && b2R != 0 ? (b3R - b1R * p.state) / b2R :
		       (ps.state - pp.state) / (ps.x - pp.x);
	}
	
	/**
	 * Returns 1/x<sup>c</sup> * d/dx(x<sup>c</sup> * D() * du/dx).
	 */
	public final double ddx() {
		if (p.x != xNow)
			search();
		double xR = x = 0.5 * (xNow + ps.x);
		double temp = Math.pow(x, c) * D();
		double sum = ps == p && b2R != 0 ? temp * ((b3R - b1R * p.state) / b2R) :
		                                   temp * ((ps.state - p.state) / (ps.x - xNow));
		double xL = x = 0.5 * (pp.x + xNow);
		temp = pp == p && b2L != 0 ? temp * ((b3L - b1L * p.state) / b2L) :
		                             temp * ((pp.state - p.state) / (pp.x - xNow));
		sum -= temp;
		x = xNow;
		temp = c + 1;
		return temp / (Math.pow(xR, temp) - Math.pow(xL, temp)) * sum;
	}
	
	
	/**
	 * Returns an approximation to the second derivative with respect to x, 
     * d<sup>2</sup>/dx<sup>2</sup>.
	 */
	public final double d2x() {
		if (p.x != xNow)
			search();
		return ((ps == p && b2R != 0 ? (b3R - b1R * p.state) / b2R :
		        (ps.state - p.state) / (ps.x - xNow)) -
		        (pp == p && b2L != 0 ? (b3L - b1L * p.state) / b2L :
		        (pp.state - p.state) / (pp.x - xNow))
		       ) / (0.5 * (ps.x - pp.x));
	}
	
	/**
	 * Return the current value of x. 
	 */
	public final double x() {
		return x;
	}
	
	/**
	 * Return the current value of t (= time()).
	 */
	public final double t() {
		return Process.time(); 
	}
	
	/**
	 * Starts the continuous variation of this <tt>PDEVariable</tt>.
	 *
	 * @return <tt>this</tt>.
	 */
	public Continuous start() {
		Point p = (Point) points.first();
		while (p != null) {
			p.start();
			p = (Point) p.suc();
		}
		super.start();
		return this;
	}
	
	/**
	 * Stops the continuous variation of this <tt>PDEVariable</tt>.
	 */
	public void stop() {
		Point p = (Point) points.first();
		while (p != null) {
			p.stop();
			p = (Point) p.suc();
		}
		super.stop();
	}
	
	/**
	 * Returns the two-way list of points.
	 */	
	public Head points() {
		return points;
	}
	
	/**
	 * Prints the points of this <tt>PDEVariable</tt> as a table.
     *
	 * @param <tt>heading</tt> the heading to be printed above the table.
     * @see jDisco.Table
	 */
	public void print(String heading) {
		Table t = new Table();
 		Point p = (Point) points().first();
		while (p != null) {
			t.add(p.x(), p.state);
			p = (Point) p.suc();
		}
 		t.print(heading);	
	}
	
	/**
	 * Prints the points of this <tt>PDEVariable</tt> as a table without heading.
     *
     * @see jDisco.Table
	 */
	public void print() {
		print("");
	}
	
	/**
	 * Shows the points of this <tt>PDEVariable</tt> as a graph.
     *
	 * @param <tt>title</tt> the title of the graph.
     * @see jDisco.Graph
	 */
	public void show(String title) {
		Graph g = new Graph(title);
 		Point p = (Point) points().first();
		while (p != null) {
			g.add(p.x(), p.state);
			p = (Point) p.suc();
		}
 		g.show();	
	}
	
	/**
	 * Shows the points of this <tt>PDEVariable</tt> as an untitled graph.
     *
     * @see jDisco.Graph
	 */
	public void show() {
		show("");
	}
	
	/**
	 * Each <tt>Point</tt>-object represents one of the points 
	 * of a <tt>PDEVariable</tt>, (<tt>x</tt>, <tt>state()</tt>).
     *
     * @see jDisco.PDEVariable
	 */
	public static class Point extends Variable {
		/**
		 * The constructor.
		 */
		Point(double x, double state) {
			super(state);
			this.x = x;
		}
		
		/**
		 * Returns <tt>x</tt>.
		 */
		public double x() {
			return x;
		}
		
		/**
		 * Returns <tt>state</tt>).
		 */
		public double state() {
			return state;
		}
		
		double x;
	}
	
	/**
	 * This integer may be set to 0, 1, or 2, depending on 
     * whether the problem is Cartesian, cylindrical, or spherical, respectively. 
     */
    public int c = 0;
    
    /**
     * Computes derivatives for all points.
     */
    protected final void derivatives() {
        p = ps = (Point) points.last();
        pp = (Point) p.pred();
        x = xNow = p.x;
        b1R = b1Right();
        b2R = b2Right();
        b3R = b3Right();
        if (b2R == 0) {
            if (b1R != 0)
                p.state = b3R / b1R;
            else
                p.rate = b3R;
        } else 
            p.rate = rate();
        p = pp = (Point) points.first();
        ps = (Point) p.suc();
        x = xNow = p.x;
        b1L = b1Left();
        b2L = b2Left();
        b3L = b3Left();
        if (b2L == 0) {
            if (b1L != 0)
                p.state = b3L / b1L;
            else
                p.rate = b3L;
        } else
            p.rate = rate();
        p = ps; 
        while (p != (Point) points.last()) {
            ps = (Point) p.suc();
            x = xNow = p.x;
            p.rate = rate();
            pp = p;
            p = ps;
        } 
    }
    
    private double xLeft, xRight;
    private int nPoints;
    private Head points;
    private double b1L, b1R, b2L, b2R, b3L, b3R;
    private double x, xNow;
    private Point p, pp, ps;
    
    /**
     * Auxiliary method.
     * <p>
     * Searches the list <tt>points</tt> for a point <pp>p</tt>, where
     * <tt>p.x</tt> == <tt>xNow</tt>.
     * <p>
     * At return <tt>pp</tt> points at the predecessor of <tt>p</tt>, and
     * <tt>ps</tt> points at the successor of <tt>p</tt>. 
     * Note, however, that <tt>pp</tt> == <tt>p</tt>, if <tt>p</tt> ==
     * <tt>points.first()</tt>, and tt>ps</tt> == <tt>p</tt>, if <tt>p</tt> ==
     * <tt>points.last()</tt>.
     */
    private void search() {
        if (xNow == xLeft) {    
            p = pp = (Point) points.first(); 
            ps = (Point) p.suc();
        } else if (xNow == xRight) {
            p = ps = (Point) points.last();
            pp = (Point) p.pred();
        } else {
            while (p.x < xNow)
                p = (Point) p.suc();
            while (p.x > xNow)
                p = (Point) p.pred();
            pp = (Point) p.pred();
            ps = (Point) p.suc();
        }
    }
}