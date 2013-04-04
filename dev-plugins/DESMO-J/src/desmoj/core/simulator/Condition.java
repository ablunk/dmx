package desmoj.core.simulator;

/**
 * Derive from this class to create your own special objects to test for certain
 * conditions in your Model or Experiment. Two methods for testing on conditions
 * are provided:
 * <ul>
 * <li>boolean check() : parameterless method to check for conditions
 * independent of any actual Entity</li>
 * <li>boolean check(Entity e) : a method to check for certain conditions on
 * individual Entities or Processes</li>
 * </ul>
 * Override these methods to return <code>true</code> whenever the model or
 * entity comply to the condition to be checked.
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
public abstract class Condition extends ModelComponent {
	/**
	 * Constructs a condition with the given name and parameters for trace
	 * files.
	 * 
	 * @param owner
	 *            Model : The main model this condition is associated to
	 * @param name
	 *            java.lang.String : The name of this condition
	 * @param showInTrace
	 *            boolean : Flag for showing this condition in trace-files. Set
	 *            it to <code>true</code> if model should show up in trace,
	 *            <code>false</code> if model should not be shown in trace.
	 */
	public Condition(Model owner, String name, boolean showInTrace) {

		super(owner, name, showInTrace); // create a ModelComponent

	}

	/**
	 * Returns a boolean value indicating whether the condition is met or not.
	 * Override this abstract method and implement the specific
	 * <code>check</code> to return true if the tested condition conforms to
	 * your specified needs. If a condition is used as a stop-condition for an
	 * experiment beware that the simulation will run endless if your condition
	 * can't be met. It is advisable to always use a time limit if you are not
	 * sure about the condition in question. This abstract method must be
	 * implemented to make sure the appropriate result is returned.
	 * 
	 * @return boolean : Override method to return <code>true</code>, if the
	 *         model complies to the checked condition, return
	 *         <code>false</code> otherwise.
	 */
	public abstract boolean check();

	/**
	 * Returns a boolean showing whether the given entity complies to the
	 * condition tested by this method or not. Inherit from this class and
	 * implement this abstract method to return true if the passed entity
	 * conforms to your special condition. Note that any type of entity can be
	 * contained in a queue, so it is absolutely necessary to verify that the
	 * entity given as a parameter is actually an object of the type of entity
	 * you want to check. This can easily be done using the Java
	 * <code>instanceof</code> operator. To avoid runtime type mismatches
	 * always check for the appropriate type of object before accessing the
	 * desired object's attributes or methods like shown below: <code><p>
	 * // not sure about the special type of entity e
	 * <b>if</b> ( ! e <b>instanceof</b> mySpecialEntity ) <b>return false</b>;<br>
	 * // now we can be sure to have the special type of entity to check
	 * <b>return</b> ((mySpecialEntity)e).getSpecialEntityValue == neededValue;
	 * </code>
	 * <p>
	 * The line above aborts all further tests when the passed entity is not of
	 * the desired type. If we do have an entity of the right type, we can check
	 * it and even use its specific methods. Note also, that using these
	 * specific methods still requires a typecast. But since we have tested for
	 * the right type of entity before, this runtime typecast should never get
	 * into a situation to throw an exception. This abstract method must be
	 * implemented to return the desired value.
	 * 
	 * @return boolean : Is <code>true</code>, if the entity given conforms
	 *         to the condition, <code>false</code> otherwise.
	 * @param e
	 *            Entity : The entity to test the condition on
	 */
	public abstract boolean check(Entity e);
}