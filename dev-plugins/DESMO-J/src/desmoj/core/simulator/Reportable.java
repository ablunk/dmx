package desmoj.core.simulator;

import desmoj.core.report.Reporter;
import desmoj.core.report.StandardReporter;

/**
 * All classes that want to publish their information have to extend this class
 * in order to provide the necessary functions to represent their information in
 * reports.
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
public abstract class Reportable extends ModelComponent {

    /**
     * Flag indicating if this reportable should produce a report.
     */
    private boolean reportMode;

    /**
     * The number of observations that this reportable can report about
     */
    private long observations;

    /**
     * stores the last time that this reportable object was reset.
     */
    private TimeInstant lastReset;

    /**
     * Creates a reportable object with all parameters required. The reportable
     * registers itself at the given model
     * 
     * @param name
     *            java.lang.String : The name of this reportable
     * @param owner
     *            Model : The model this reportable is associated to
     * @param showInReport
     *            boolean : Flag for showing the report Set it to
     *            <code>true</code> if reportable should show up in report.
     *            Set it to <code>false</code> if reportable should not be
     *            shown in report.
     * @param showInTrace
     *            boolean : Flag for showing this reportable in trace files. Set
     *            it to <code>true</code> if reportable should show up in
     *            trace. Set it to <code>false</code> if reportable should not
     *            be shown in trace.
     */
    public Reportable(Model owner, String name, boolean showInReport,
            boolean showInTrace) {

        super(owner, name, showInTrace); // create the ModelComponent
        reportMode = showInReport; // set report flag
        observations = 0; // reset observations counter

        // check for non-null before registering. 
        // Registration even if showInReport=false! 
        // Otherwise such reportables are not reseted at the start of the experiment run! //TODO
        if ((owner != null)) {
            owner.register(this);
        }
        
        // reset in case experiment running
        // (for not yet running experiments, this happens automatically
        // when the experiment is started)
        if (owner != null && owner.getExperiment() != null && owner.getExperiment().isRunning()) { 
            this.reset();
        }   
    }

    /**
     * Override this method to return the appropriate reporter to the reportable
     * object. To ensure that always the appropriate reporter is used, it has to
     * be obtained from the reportable object that is of interest. All
     * reportable objects in desmoj that want to deliver special repoters have
     * to implement this method to hand back the correct reporter. The default
     * implementation returns an object of type <code>StandardReporter</code>
     * If you want to extend the framework by new concepts, you have to make
     * sure, that classes inheriting direct or indirect from reportable have to
     * implement this method correctly, especially by implementing an
     * appropriate reporter first and give a reference to it back through this
     * method.
     * 
     * @return desmoj.report.Reporter : A specific reporter for this reportable
     */
    public Reporter createReporter() {

        return new StandardReporter(this);

    }

    /**
     * Returns the number of observations made by the reportable object.
     * 
     * @return long : The number of observations made by the reportable object.
     */
    public long getObservations() {

        return observations;

    }

    /**
     * Increments the number of observations made by this reportable by one (1).
     */
    public void incrementObservations() {

        observations++;

    }

    /**
     * Increments the number of observations by the amount given as parameter.
     * 
     * @param multiObservations
     *            long : The number to increase the number of observations by
     */
    public void incrementObservations(long multiObservations) {

        observations += multiObservations;

    }

    /**
     * Checks if this reportable produces a report.
     * 
     * @return boolean : true if report will be produced, false otherwise
     */
    public boolean reportIsOn() {

        return reportMode;

    }

    /**
     * Switches report mode to prevent this reportable to produce reports.
     */
    public void reportOff() {

        reportMode = false;

    }

    /**
     * Switches report mode of this reportable on to produce a report.
     */
    public void reportOn() {

        reportMode = true;

    }

    /**
     * Resets the counter for observations made by this reportable. The point of
     * simulation time this method was called will be stored and can be
     * retrieved using method <code>resetAt()</code>.
     */
    public void reset() {

        observations = 0; // reset observations
        lastReset = presentTime(); // register the reset time
    }

    /**
     * Shows the point in simulation time when the last reset of this reportable
     * was made.
     * 
     * @return TimeInstant : The point of simulation time of the last reset.
     */
    public TimeInstant resetAt() {

        return lastReset;

    }
}
