package desmoj.core.simulator;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 * The progress bar to display the progress of the experiment.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Soenke Claassen
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
public class ExpProgressBar extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * A constant defining half a second as 500 milliseconds. Every half a
	 * second the progress bar will be updated.
	 */
	public final static int HALF_A_SECOND = 500;

	/**
	 * The experiment this ExpProgressBar is connected to.
	 */
	private Experiment myExperiment;

	/**
	 * The ProgressBar displaying the progress of the experiment.
	 */
	private JProgressBar progressBar;

	/**
	 * The timer timing the update of the progress bar.
	 */
	private Timer timer;

	/**
	 * Constructs an ExpProgressBar for an <code>Experiment</code> to display
	 * its progress on the screen.
	 * 
	 * @param experiment
	 *            Experiment : The experiment which progress will be displayed
	 *            of the progress bar.
	 */
	public ExpProgressBar(Experiment experiment) {

		super("Progress of the experiment"); // make a JFrame

		this.myExperiment = experiment;

		setTitle("Progress of " + myExperiment.getName());

		// create the UI
		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		// set the preferred size
		progressBar.setPreferredSize(new java.awt.Dimension(320, 22));

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(progressBar, BorderLayout.CENTER);
		contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);

		// Create a timer.
		timer = new Timer(HALF_A_SECOND, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				long crntTime = myExperiment.getSimClock().getTime().getTimeInEpsilon();
		        long stop = myExperiment.getStopTime().getTimeInEpsilon();
				int progress = (int) (100.0D * crntTime / stop);
				progressBar.setValue(progress);
				if (myExperiment.isAborted()) {
					Toolkit.getDefaultToolkit().beep();
					timer.stop();
				}
			}
		});

		// start the timer
		timer.start();
	}

	/**
	 * Returns the <code>Experiment</code> this progress bar monitors.
	 * 
	 * @return desmoj.Experiment : the <code>Experiment</code> this progress
	 *         bar monitors.
	 */
	public Experiment getExperiment() {

		return myExperiment;
	}
}