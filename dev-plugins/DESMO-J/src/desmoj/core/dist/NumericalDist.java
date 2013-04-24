package desmoj.core.dist;

import java.util.concurrent.TimeUnit;

import desmoj.core.simulator.Model;
import desmoj.core.simulator.TimeSpan;

public abstract class NumericalDist<N extends Number> extends Distribution {

	public NumericalDist(Model owner, String name, boolean showInReport,
			boolean showInTrace) {
		super(owner, name, showInReport, showInTrace);
	}

	/**
	 * Abstract method should return the specific sample as a value of type N
	 * when implemented in subclasses.
	 * 
	 * @return N : The sample of type N to be drawn from this distribution
	 */
	public abstract N sample();
	
	/**
     * Convenience method to sample a period of random length by creating a
     * <code>TimeSpan</code> whose length is determined by sampling this
     * distribution (time unit is the experiment's reference units),
     * thus replacing the pattern <code>new TimeSpan(distribution.sample())</code>.
     * 
     * @return TimeSpan : The TimeSpan sampled from this distribution
     */
    public TimeSpan sampleTimeSpan() {
        
        if (!this.getModel().isConnected()) {
            sendWarning(
                    "Failed to sample a TimeSpan. Returning TimeSpan.ZERO instead.",
                    "NumericalDist: " + getName() + " Method: TimeSpan sampleTimeSpan()",
                    "Model not yet connected to an experiment, thus reference time unit and random number seeds not yet set.",
                    "Make sure your model is connected to an experiment before this method is called.");
            return TimeSpan.ZERO;
        }
        
        // Obtain a sample 
        N sample = this.sample();
        if (sample.doubleValue() < 0) {
            sendWarning(
                    "Failed to sample a TimeSpan. Returning TimeSpan.ZERO instead.",
                    "NumericalDist: " + getName() + " Method: TimeSpan sampleTimeSpan()",
                    "The distribution returned a negative sample (" + sample.doubleValue() + ").",
                    "Make sure to sample TimeSpans from non-negative distributions only.");
            return TimeSpan.ZERO;
        }
        
        // Return a TimeSpan using the appropriate constructor
        if (sample instanceof Double || sample instanceof Float) {
            return new TimeSpan(sample.doubleValue());
        } else {
            return new TimeSpan(sample.longValue());
        }
    }
    
    /**
     * Convenience method to sample a period of random length by creating a
     * <code>TimeSpan</code> whose length is determined by sampling this
     * distribution (time unit given explicitly as parameter), thus replacing 
     * the pattern <code>new TimeSpan(distribution.sample(), unit)</code>.
     * 
     * @param unit 
     *      TimeUnit: the TimeUnit to assign to the sampled value
     *      
     * @return TimeSpan : The TimeSpan sampled from this distribution
     */
    public TimeSpan sampleTimeSpan(TimeUnit unit) {
        
        if (unit == null) { // no time unit given
            throw (new desmoj.core.exception.SimAbortedException(
                    new desmoj.core.report.ErrorMessage(
                            null,
                            "Can't create TimeSpan object! Simulation aborted.",
                            "NumericalDist: " + getName() + " Method: TimeSpan sampleTimeSpan(TimeUnit unit)",
                            "Time unit passed is null",
                            "Make sure to pass a non-null time unit.",
                            null)));
        }   
        
        if (!this.getModel().isConnected()) {
            sendWarning(
                    "Failed to sample a TimeSpan. Returning TimeSpan.ZERO instead.",
                    "NumericalDist: " + getName() + " Method: TimeSpan sampleTimeSpan(TimeUnit unit)",
                    "Model not yet connected to an experiment, thus random number seeds not yet set.",
                    "Make sure your model is connected to an experiment before this method is called.");
            return TimeSpan.ZERO;
        }
        
        // Obtain a sample 
        N sample = this.sample();
        if (sample.doubleValue() < 0) {
            sendWarning(
                    "Failed to sample a TimeSpan. Returning TimeSpan.ZERO instead.",
                    "NumericalDist: " + getName() + " Method: TimeSpan sampleTimeSpan(TimeUnit unit)",
                    "The distribution returned a negative sample (" + sample.doubleValue() + ").",
                    "Make sure to sample TimeSpans from non-negative distributions only.");
            return TimeSpan.ZERO;
        }
        
        // Return a TimeSpan using the appropriate constructor
        if (sample instanceof Double || sample instanceof Float) {
            return new TimeSpan(sample.doubleValue(), unit);
        } else {
            return new TimeSpan(sample.longValue(), unit);
        }
    }
    
    
    /**
     * Convenience method to return the distribution's sample as <code>Object</code>.
     * For type safety, method <code>sample()</code> should be preferred. However, 
     * this method is useful for environments requiring a non-genetic access point 
     * to obtain samples from any distribution. 
     * 
     * @return Object : A sample from this this distribution wrapped as <code>Object</code>.
     */
    public Object sampleObject() {
        return sample();
    }
}