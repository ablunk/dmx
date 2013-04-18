/*
  File: Random.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date        Who                What
  20Sep2001   kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * A class for random drawing.
 */
public class Random extends java.util.Random {
    /** 
     * This constructor creates a <tt>Random</tt> object with the current 
     * time as its seed value.
     */
    public Random() { 
        super(); 
    }

    /**
     * This constructor creates a <tt>Random</tt> object with the given
     * seed value.
     */ 
    public Random(long seed) { 
        super(seed); 
    }

    /**
     * Returns <tt>true</tt> or <tt>false</tt> with a given probability.
     *
     * @param <tt>a</tt> the propability.
     * 
     * @return <tt>true</tt>, with probability <tt>a</tt>,
     * <tt>false</tt> with probability <tt>1-a</tt>.<br>
     * If <tt>a</tt> >= 1, <tt>true</tt> is always returned.<br>
     * If <tt>a</tt> &lt;= 0, <tt>false</tt> is always returned.
     */
    public final boolean draw(double a) {
        return a < nextDouble();
    }

    /**
     * Returns an integer in a given range with uniform probability.
     *
     * @param <tt>a</tt> the minimum value.
     * @param <tt>b</tt> the maximum value.
     *  
     * @return one of the integers <tt>a</tt>, <tt>a+1</tt>, ..., 
     * <tt>b-1</tt>, <tt>b</tt> with equal probability.
     *
     * @exception <tt>DiscoException</tt> 
     * if <tt>b</tt> &lt; <tt>a</tt>.  
     */    
    public final int randInt(int a, int b) {
        if (b < a)
            error("randInt: Second parameter is lower than first parameter");
        return (int) (a + nextDouble()*(b - a + 1));
    }

    /**
     * Returns a <tt>double</tt> in a given range with uniform probability.
     *
     * @param <tt>a</tt> the minimum value. 
     * @param <tt>b</tt> the maximum value. 
     *
     * @return a double in the range from <tt>a</tt> to <tt>b</tt>,
     * not including <tt>b</tt>, with uniform probability. 
     *
     * @exception <tt>DiscoException</tt> 
     * if <tt>b</tt> &lt;= <tt>a</tt>.  
     */    
    public final double uniform(double a, double b) {
        if (b <= a)
            error("uniform: Second parameter is not greater than first parameter");
        return a + nextDouble()*(b - a);
    }
   
    /**
     * Returns a normally distributed <tt>double</tt>.
     *
     * @param <tt>a</tt> the mean. 
     * @param <tt>b</tt> the standard deviation.
     *
     * @return a normally distributed <tt>double</tt> 
     * with mean <tt>a</tt> and standard deviation <tt>b</tt>.
     */     
    public final double normal(double a, double b) {
        return a + b*nextGaussian();
    }
   
    /**
     * Returns a <tt>double</tt> drawn from the negative 
     * exponential distribution.
     *
     * @param <tt>a</tt> the reciprocal value of the mean.
     *
     * @return a <tt>double</tt> drawn from the negative 
     * exponential distribution with mean <tt>1/a</tt>.
     *
     * @exception <tt>DiscoException</tt>
     * if a &lt;= 0.
     */     
    public final double negexp(double a) {
        if (a <= 0)
            error("negexp: First parameter is lower than zero");
        return -Math.log(nextDouble())/a;
    }

    /**
     * Returns an integer drawn from the Poisson distribution.
     *
     * @param <tt>a</tt> the mean.
     *
     * @return an integer drawn from the Poisson distribution
     * with mean <tt>a</tt>.  
     */
    public final int poisson(double a) {
        double limit = Math.exp(-a), prod = nextDouble();
        int n;
        for (n = 0; prod >= limit; n++)
            prod *= nextDouble();
        return n;
    }
    
    /**
     * Returns a <tt>double</tt> drawn from the Erlang distribution.
     * 
     * @param <tt>a</tt> the reciprocal value of the mean.
     *
     * @return a <tt>double</tt> drawn from the Erlang distribution
     * with mean <tt>1/a</tt>.
     *
     * @exception <tt>DiscoException</tt>
     * if <tt>a</tt> &lt;= <tt>0</tt> or <tt>b</tt> &lt;= <tt>0</tt>.    
     */
    public final double erlang(double a, double b) {
        if (a <= 0)
            error("erlang: First parameter is not greater than zero"); 
        if (b <= 0)
            error("erlang: Second parameter is not greater than zero"); 
        long bi = (long) b, ci;
        if (bi == b)
            bi--;
        double sum = 0;
        for (ci = 1; ci <= bi; ci++)
            sum += Math.log(nextDouble());
        return -(sum + (b - (ci-1))*Math.log(nextDouble()))/(a*b); 
    }

    /**
     * Returns an integer from a given discrete distribution.
     * <p>
     * The array <tt>a</tt> holds values corresponding to a step function,
     * rising from 0 to 1. The array, augmented by the element 1 to the right, 
     * is interpreted as a step function of the subscript, defining a discrete 
     * (cumulative) distribution function.
     * The method returns smallest index <tt>i</tt> such that 
     * <tt>a[i]</tt> > <tt>r</tt>, 
     * where <tt>r</tt> is a uniformly distributed random number 
     * in the interval [<tt>0</tt>;<tt>1</tt>], and 
     * <tt>a[a.length]</tt> = <tt>1</tt>. 
     *
     * @param <tt>a</tt> the distribution table.
     *
     * @return a <tt>double</tt> drawn from the discrete (cumulative) 
     * distribution defined by <tt>a</tt>.
     */
    public final int discrete(double[] a) {
        double basic = nextDouble();
        int i;
        for (i = 0; i < a.length; i++)
            if (a[i] > basic)
                break;
        return i;
    }
    
    /**
     * Returns a <tt>double</tt> from a distribution function f.
     *
     * @param <tt>a</tt> the f(p) values.
     * @param <tt>b</tt> the p-values
     * as well as <tt>b</tt>.
     *
     * @return a <tt>double</tt> drawn from a discrete (cumulative) 
     * distribution function f.
     * The value is found by a linear interpolation in a table defined by
     * <tt>a</tt> and <tt>b</tt>, such that 
     * <tt>a[i]</tt> = f(<tt>b[i]</tt>).
     *
     * @exception <tt>DiscoException</tt> 
     * if either <tt>a[0]</tt> != <tt>0</tt>,  
     * <tt>a[a.length-1]</tt> != <tt>1</tt> or
     * <tt>a.length</tt> != <tt>b.length</tt>.
     */
    public final double linear(double[] a, double[] b) {
        if (a.length != b.length)
            error("linear: the arrays have different length");
        if (a[0] != 0.0 || a[a.length-1] != 1.0)
            error("linear: Illegal value in first array");
        double basic = nextDouble();
        int i;
        for (i = 1; i < a.length; i++)
             if (a[i] >= basic)
                 break;
        double d = a[i] - a[i-1];
        if (d == 0.0)
            return b[i-1];
        return b[i-1] + (b[i]-b[i-1])*(basic-a[i-1])/d; 
    }

    /**
     * Returns a random integer drawn from a distribution defined 
     * by a histogram.
     * <p>
     * The parameter <tt>a</tt> is interpreted as a histogram 
     * defining the relative frequencies of the values.
     *
     * @param <tt>a</tt> the histogram.
     * @return an integer in the range [0;<tt>n</tt>-1].
     */
    public final int histd(double[] a) {
        double sum = 0.0;
        int i;
        for (i = 0; i < a.length; i++)
            sum += a[i];
        double weight = nextDouble() * sum;
        sum = 0.0;
        for (i = 0; i < a.length - 1; i++) {
            sum += a[i];
            if (sum >= weight)
                break;
        }
        return i;
    }
    
    /**
     * Returns a <tt>double</tt> drawn from the gamma distribution. 
     *
     * @param <tt>alpha</tt> the shape.
     * @param <tt>beta</tt> the scale. 
     *
     * @return a <tt>double</tt> drawn from the gamma distribution with
     * mean alpha * beta and variance alpha * beta<sup>2</sup>.
     *
     * @exception <tt>DiscoException</tt>
     * if <tt>alpha</tt> &lt;= <tt>0</tt> or <tt>beta</tt> &lt;= <tt>0</tt>.    
     */
    public final double gamma(double alpha, double beta) {
        if (alpha <= 0 || beta <= 0) 
            error("gamma: arguments must be greater than zero");
        double x = 0, y = 0;
        if (alpha < 1) {
            do {
                x = Math.pow(nextDouble(), 1 / alpha);
                y = Math.pow(nextDouble(), 1 / (1 - alpha));
            } while (x + y > 1);
            return x / (x + y) * (-Math.log(nextDouble())) * beta;
        }
        int a = (int) alpha;
        double b = alpha - a;
        if (alpha < 5) {
            do {
                x = alpha / a;
                double prod = 1;
                for (int i = 0; i < a; i++)
                    prod *= nextDouble();
                x *= - Math.log(prod);
            } while (nextDouble() > Math.pow(x / alpha, b) *
                                    Math.exp(-b * x / (alpha - 1)));
            return x * beta;
        }
        return erlang(beta, nextDouble() >= b ? a : a + 1);
    }
    
    /**
     * Returns a <tt>double</tt> drawn from the beta distribution. 
     *
     * @param <tt>alpha</tt> shape parameter for gamma1. 
     * @param <tt>beta</tt> shape parameter for gamma2. 
     *
     * @return a <tt>double</tt> drawn from the beta distribution:
     * gamma1 / (gamma1 + gamma2).
     *
     * @exception <tt>DiscoException</tt>
     * if <tt>alpha</tt> &lt; <tt>0</tt> or <tt>beta</tt> &lt; <tt>0</tt>.    
     */
    public final double beta(double alpha, double beta) {
        if (alpha < 0 || beta < 0) 
            error("beta: arguments must be greater than zero");
        double g1 = gamma(alpha, beta);
        double g2 = gamma(alpha, beta);
        return g1 / (g1 + g2);
   }
   
    /**
     * Returns a <tt>double</tt> drawn from the binomial distribution. 
     *
     * @param <tt>n</tt> number of trials. 
     * @param <tt>p</tt> propability of success. 
     *
     * @return a <tt>double</tt> drawn from the binomial distribution.
     */
    public final double binomial(int n, double p) {
        int count = 0;
        for (int i = 0; i < n; i++) 
            if (nextDouble() <= p)
                count++;
        return count;
    }
   
    /**
     * Returns a <tt>double</tt> drawn from the Cauchy distribution. 
     *
     * @param <tt>a</tt> the mea.n 
     * @param <tt>b</tt> the standard deviation.  
     *
     * @return a <tt>double</tt> drawn from the Cauchy distribution with
     * mean <tt>a</tt> and standard deviation <tt>b</tt>.    
     */
    public final double cauchy(double a, double b) {
        return a + b * Math.tan(Math.PI * (nextDouble() - 0.5));
    }
   
    /**
     * Returns a <tt>double</tt> drawn from the Chi-Square distribution. 
     *
     * @param <tt>n</tt> The degrees of freedom. 
     *
     * @return a <tt>double</tt> drawn from the Chi-Square distribution with
     * <tt>n</tt> degrees of freedom.    
     */
    public final double chiSquare(int n) {
        return gamma(0.5 * n, 2);
    }
   
    /**
     * Returns a <tt>double</tt> drawn from the
     * exponential distribution.
     *
     * @param <tt>a</tt> the mean.
     *
     * @return a <tt>double</tt> drawn from the 
     * exponential distribution with mean <tt>a</tt>.
     */ 
    public final double exp(double a) {
        return -a * Math.log(nextDouble());
    }
    
    /**
     * Returns a <tt>double</tt> drawn from the F-distribution.
     *
     * @param <tt>m</tt> degrees of freedom for numerator Chi-Square.
     * @param <tt>n</tt> degrees of freedom for denominator Chi-Square.
     *
     * @return a <tt>double</tt> drawn from the F-distribution.
     */     
    public final double fDist(int m, int n) {
        double c1 = chiSquare(m);
        double c2 = chiSquare(n);
        return (m * c1) / (n * c2); 
    }
    
    /**
     * Returns an <tt>int</tt> drawn from the geometric distribution.
     *
     * @param <tt>p</tt> the event propability.
     *
     * @return a <tt>int</tt> drawn from the geometric distribution.
     */     
    public final int geometric(double p) {
       if (p <= 0 || p >= 1)
           error("geometric: Propability must be in (0, 1)"); 
       return (int) (Math.log(nextDouble()) / Math.log(1 - p));
    }
    
    /**
     * Returns a <tt>double</tt> drawn from the Hyper-Exponential distribution.
     *
     * @param <tt>a</tt> the mean.
     * @param <tt>b</tt> the standard deviation.
     *
     * @return a <tt>double</tt> drawn from the Hyper-Exponential distribution with
     * mean <tt>a</tt> and standard deviation <tt>b</tt>.
     */     
    public final double hyperExponential(double a, double b) {
        double cv2 = b * b / (a * a);
        double p = 0.5 * (1 - Math.sqrt((cv2 - 1) / (cv2 + 1))); 
        double z = nextDouble() > p ? a / (1 - p) : a / p;
        return -0.5 * z * Math.log(nextDouble());
    }
    
    /**
     * Returns an <tt>int</tt> drawn from the Hyper-Geometric distribution.
     *
     * @param <tt>m</tt> size of population.
     * @param <tt>n</tt> number of items to be drawn.
     * @param <tt>p</tt> propability of success.
     *
     * @return an <tt>int</tt> drawn from the Hyper-Geometric distribution.
     */     
    public final double hyperGeomtric(int m, int n, double p) {
        if (m < n)
            error("hyperGeometric: m < n");
        double g = p * m;
        double c = m - g;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (nextDouble() <= g / m) {
                k++;
                g--;
            }
            else
                c--;
            m--;
        }
        return k;
    }
    
    /**
     * Returns a <tt>double</tt> drawn from the LogNormal distribution.
     *
     * @param <tt>a</tt> the mean.
     * @param <tt>b</tt> the standard deviation.
     *
     * @return a <tt>double</tt> drawn from the LogNoram distribution
     * with mean <tt>a</tt> and standard deviation <tt>b</tt>.
     */     
    public final double logNormal(double a, double b) {
        return Math.exp(normal(a, b));
    }
    
    /**
     * Returns a <tt>double</tt> drawn from the negative binomial distribution.
     *
     * @param <tt>p</tt> propability of success.
     * @param <tt>n</tt> number of successes.
     *
     * @return a <tt>double</tt> drawn from the negative binomial distribution.
     */     
    public final double negativeBinomial(double p, int n) {
        if (p <= 0 || p >= 1)
            error("negativeBinomial: Propability must be in (0, 1)"); 
        double sum = 0;
        for (int i = 0; i < n; i++)
            sum += geometric(p);
        return sum; 
    }
    
    /**
     * Returns a <tt>double</tt> drawn from Student's t distribution.
     *
     * @param <tt>n</tt> degrees of freedom.
     *
     * @return a <tt>double</tt> drawn from Student's t distribution.
     */     
    public final double student(int n) {
        return normal(0, 1) / Math.sqrt(chiSquare(n));
    }
    
    /**
     * Returns a <tt>double</tt> drawn from the triangular distribution.
     *
     * @param <tt>min</tt> the minimum value.
     * @param <tt>max</tt> the maximum value.
     *
     * @return a <tt>double</tt> drawn from the triangular distribution.
     */     
    public final double triangular(double min, double max) {
        if (min >= max)
            error("triangular: min must be less than max"); 
        double range = max - min;
        double mode = (min + max) / 2;
        double left = mode - min;
        double right = max - mode;
        double r = nextDouble();
        return r <= left / range ? min + Math.sqrt(left * range * r) 
                                 : max - Math.sqrt(right * range * (1 - r));  
    }
    
    /**
     * Returns a <tt>double</tt> drawn from the Weibul distribution.
     *
     * @param <tt>scale</tt> the scale.
     * @param <tt>shape</tt> the shap.e
     *
     * @return a <tt>double</tt> drawn from the Weibul distribution.
     */     
    public final double weibul(double scale, double shape) {
        return scale * Math.pow(-Math.log(nextDouble()), 1 / shape);
    }
    
    private static void error(String msg) {
        throw new DiscoException(msg);
    }
}
