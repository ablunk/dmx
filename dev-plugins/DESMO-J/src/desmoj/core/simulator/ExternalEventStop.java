package desmoj.core.simulator;

/**
 * The external event to stop a running experiment.
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
public class ExternalEventStop extends ExternalEvent {
	/**
	 * Constructs an external event to abort the experiment.
	 * 
	 * @param owner
	 *            desmoj.Model : The model this external event is associated to
	 * @param name
	 *            java.lang.String : The external event's name
	 * @param showInTrace
	 *            boolean : Flag indicating if the external event is shown in
	 *            the report
	 */
	public ExternalEventStop(Model owner, String name, boolean showInTrace) {

		super(owner, name, showInTrace);

	}

	/**
	 * The eventroutine to abort an experiment.
	 */
	public void eventRoutine() {

		getModel().getExperiment().setStatus(Experiment.STOPPED);

	}
}