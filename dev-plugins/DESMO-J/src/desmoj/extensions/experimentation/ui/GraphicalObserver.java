package desmoj.extensions.experimentation.ui;

import java.awt.Component;

import desmoj.core.util.SimRunListener;

/**
 * Base class for graphical observers in the experiment launcher. A graphical
 * observer can display itself inside a graphical observer context (e.g. a
 * JDesktop component).
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Nicolas Knaak
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
public abstract class GraphicalObserver implements SimRunListener {

	/** Context to display this graphical observer in */
	private GraphicalObserverContext context;

	/** The graphical observer's name */
	private String name;

	/**
	 * Creates a new graphical observer.
	 * 
	 * @param name
	 *            Name of the graphical observer
	 * @param c
	 *            the context this graphical observer is displayed in
	 */
	public GraphicalObserver(String name, GraphicalObserverContext c) {
		super();
		this.name = name;
		this.context = c;
	}

	/**
	 * Returns the context this observer is displayed in
	 * 
	 * @return The context (e.g. a JDesktop component).
	 */
	public GraphicalObserverContext getContext() {
		return context;
	}

	/**
	 * Should return the graphical observer's main GUI component
	 * 
	 * @return an AWT or Swing component.
	 */
	public abstract Component getGUI();

	/** Registers the observer with the context */
	public void register() {
		context.add(this);
	}

	/** Deregisters the observer from the context */
	public void deregister() {
		context.remove(this);
	}

	/** Sets the observer visible withing the context */
	public void setVisible(boolean visible) {
		context.setVisible(this, visible);
	}

	/**
	 * Sets the observer's main window's size.
	 * 
	 * @param width
	 *            window width
	 * @param height
	 *            window height
	 */
	public void setSize(int width, int height) {
		context.setSize(this, width, height);
	}

	/**
	 * Sets the position of the observer's main window's upper left edge.
	 * 
	 * @param x
	 *            horizontal position
	 * @param y
	 *            vertical position
	 */
	public void setLocation(int x, int y) {
		context.setLocation(this, x, y);
	}

	/**
	 * Returns the observer's name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Requests an update of the observer's display from the context.
	 */
	public void update() {
		context.update(this);
	}
}