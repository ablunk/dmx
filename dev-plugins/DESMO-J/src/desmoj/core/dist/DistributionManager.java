package desmoj.core.dist;

import desmoj.core.simulator.NamedObject;

/**
 * Controls all distributions used during an experiment. Provides the service of
 * automatic seed generation for all distributions registered at the
 * distributionmanager. Note that all distributions register at instantiation
 * time at the experiment's distributionmanager automatically.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Tim Lechler
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */
public class DistributionManager extends NamedObject {

	/**
	 * The initial seed value for the random seed generator.
	 */
	private long currentSeed;
    
    /**
     * The current default random number generator to be used by newly created distributions.
     */
    private Class<? extends UniformRandomGenerator> currentDefaultGenerator;

	/**
	 * Value sets antithetic mode for all distributions registering at the
	 * distributionmanager.
	 */
	private boolean antitheticMode;

	/**
	 * Keeps references to all distributions of this experiment
	 */
	private java.util.ArrayList<Distribution> distributions;

	/**
	 * Produces all starting seeds for registered distributions.
	 */
	private UniformRandomGenerator seedGenerator;

	/**
	 * Creates a new distributionManager with the given name and the given
	 * initial seed for the seed-generator.
	 * 
	 * @param name
	 *            java.lang.String : The distributionmanager's name
	 * @param seed
	 *            long : The initial seed for the seedgenerator
	 */
	public DistributionManager(String name, long seed) {

		super(name + "_DistributionManager"); // create the NamedObject

		antitheticMode = false; // set antithetic mode to false by default
		seedGenerator = new LinearCongruentialRandomGenerator(seed); // create seed generator
        currentDefaultGenerator = LinearCongruentialRandomGenerator.class;
		distributions = new java.util.ArrayList<Distribution>(); // init List for dist

	}

	/**
	 * De-registers a distribution from the experiment.
	 * 
	 * @param dist
	 *            desmoj.dist.Distribution : The distribution to be deregistered
	 */
	public void deRegister(Distribution dist) {

		distributions.remove(dist); // remove from List

	}

	/**
	 * Provides all registered distributions with new seed values, thus
	 * resetting all distribution statistics at the same time.
	 */
	public void newSeedAll() {
	    
	    for (Distribution d : distributions) {
	        d.setSeed(nextSeed());
	    }
	}

	/**
	 * Returns a new seed value to be used as an initial seed for registered
	 * distributions.
	 * 
	 * @return long : A new seed value for a registered distribution
	 */
	public long nextSeed() {

		// get a positive seed value
		return (long) (seedGenerator.nextDouble() * 100000000);

	}

	/**
	 * Registers a new distribution at the experiment to control antithetic mode
	 * and set random seed values.
	 * 
	 * @param dist
	 *            desmoj.dist.Distribution : The distribution to be registered
	 */
	public void register(Distribution dist) {

		dist.setAntithetic(antitheticMode); // set antithetic mode to default

		dist.setSeed(nextSeed()); // set new seed

		distributions.add(dist); // add to Vector

	}

	/**
	 * Resets all registered distributions. Just calls all distribution's
	 * individual reset method.
	 */
	public void resetAll() {
	    
	    for (Distribution d : distributions) {
	        d.reset();
	    }
	}

	/**
	 * Sets antithetic mode to true on all registered distributions regardless
	 * of their previous status. No reset of statistical counters.
	 * 
	 * @param antitheticMode
	 *            boolean : The new status of antithetic mode
	 */
	public void setAntitheticAll(boolean newMode) {
	    
	    for (Distribution d : distributions) {
	        d.setAntithetic(newMode);
	    }
	}

	/**
	 * Sets the seed of the SeedGenerator to the given value. If the seed is not
	 * set here, its default is zero, unless specified in the experimentoptions.
	 * 
	 * @param seed
	 *            long : The new seed for the seedgenerator
	 */
	public void setSeed(long newSeed) {

		seedGenerator.setSeed(newSeed); // go ahead and set it!

	}
    
    /**
     * Sets the underlying pseudo random number generator to be used by all 
     * distributions created from now on. 
     * The default generator is LinearCongruentialRandomGenerator; any other
     * generator to be used must implement the interface UniformRandomGenerator.
     * 
     * @see desmoj.desmoj.core.dist.LinearCongruentialRandomGenerator
     * @see desmoj.desmoj.core.dist.UniformRandomGenerator
     * 
     * @param randomNumberGenerator
     *            Class : The random number generator class to be used
     */
    public void setRandomNumberGenerator(Class<? extends UniformRandomGenerator> randomNumberGenerator) {
        
        this.currentDefaultGenerator = randomNumberGenerator;

    }
    
    /**
     * Returns the underlying pseudo random number generator to be used by all 
     * distributions. This method is intended for internal use
     * (i.e. called by Distribution) only.  
     * 
     * @see desmoj.desmoj.core.dist.LinearCongruentialRandomGenerator
     * @see desmoj.desmoj.core.dist.MersenneTwisterRandomGenerator
     * @see desmoj.desmoj.core.dist.UniformRandomGenerator
     * 
     * @param randomNumberGenerator
     *            Class : The random number generator class to be used
     */
    protected Class<? extends UniformRandomGenerator> getRandomNumberGenerator() {
        
        return this.currentDefaultGenerator;

    }
}