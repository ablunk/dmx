/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.math.analysis;

import java.io.IOException;
import org.apache.commons.math.FunctionEvaluationException; 
import org.apache.commons.math.MaxIterationsExceededException;

/**
 * Implements <a href="http://mathworld.wolfram.com/NewtonsMethod.html">
 * Newton's Method</a> for finding zeros of real univariate functions. 
 * <p> 
 * The function should be continuous but not necessarily smooth.</p>
 *
 * @version $Revision: 615734 $ $Date: 2008-01-27 23:10:03 -0700 (Sun, 27 Jan 2008) $
 */
public class NewtonSolver extends UnivariateRealSolverImpl {
    
    /** Serializable version identifier */
    private static final long serialVersionUID = 2067325783137941016L;

    /** The first derivative of the target function. */
    private transient UnivariateRealFunction derivative;
    
    /**
     * Construct a solver for the given function.
     * @param f function to solve.
     */
    public NewtonSolver(DifferentiableUnivariateRealFunction f) {
        super(f, 100, 1E-6);
        derivative = f.derivative();
    }

    /**
     * Find a zero near the midpoint of <code>min</code> and <code>max</code>.
     * 
     * @param min the lower bound for the interval
     * @param max the upper bound for the interval
     * @return the value where the function is zero
     * @throws MaxIterationsExceededException if the maximum iteration count is exceeded 
     * @throws FunctionEvaluationException if an error occurs evaluating the
     * function or derivative
     * @throws IllegalArgumentException if min is not less than max
     */
    public double solve(double min, double max) throws MaxIterationsExceededException, 
        FunctionEvaluationException  {
        return solve(min, max, UnivariateRealSolverUtils.midpoint(min, max));
    }

    /**
     * Find a zero near the value <code>startValue</code>.
     * 
     * @param min the lower bound for the interval (ignored).
     * @param max the upper bound for the interval (ignored).
     * @param startValue the start value to use.
     * @return the value where the function is zero
     * @throws MaxIterationsExceededException if the maximum iteration count is exceeded 
     * @throws FunctionEvaluationException if an error occurs evaluating the
     * function or derivative
     * @throws IllegalArgumentException if startValue is not between min and max
     */
    public double solve(double min, double max, double startValue)
        throws MaxIterationsExceededException, FunctionEvaluationException {
        
        clearResult();
        verifySequence(min, startValue, max);

        double x0 = startValue;
        double x1;
        
        int i = 0;
        while (i < maximalIterationCount) {
            x1 = x0 - (f.value(x0) / derivative.value(x0));
            if (Math.abs(x1 - x0) <= absoluteAccuracy) {
                
                setResult(x1, i);
                return x1;
            }
            
            x0 = x1;
            ++i;
        }
        
        throw new MaxIterationsExceededException(maximalIterationCount);
    }
    
    /**
     * Custom deserialization to initialize transient deriviate field.
     * 
     * @param in serialized object input stream
     * @throws IOException if IO error occurs 
     * @throws ClassNotFoundException if instantiation error occurs
     */
    private void readObject(java.io.ObjectInputStream in)
    throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        derivative = ((DifferentiableUnivariateRealFunction) f).derivative();
    }    
}
