package desmoj.core.simulator;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import desmoj.core.dist.DistributionManager;
import desmoj.core.exception.DESMOJException;
import desmoj.core.report.DebugNote;
import desmoj.core.report.ErrorMessage;
import desmoj.core.report.FileOutput;
import desmoj.core.report.Message;
import desmoj.core.report.MessageDistributor;
import desmoj.core.report.MessageReceiver;
import desmoj.core.report.OutputType;
import desmoj.core.report.Reporter;
import desmoj.core.report.TraceNote;

/**
 * Experiment is the class that provides the infrastructure for running the
 * simulation of a model. It contains all data structures necessary to simulate
 * the model and takes care of all necessary output. To actually run an
 * experiment, a new instance of the experiment class and a new instance of the
 * desired model have to be created. To link both instances, call the
 * <code>connectToExperiment(Experiment e)</code> method of the model instance
 * and pass the new experiment as a parameter.
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Tim Lechler
 * @author modified by Soenke Claassen, Ruth Meyer, Nicolas Knaak, Gunnar
 *         Kiesel,Felix Klueckmann
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
public class Experiment extends NamedObject {

	/**
	 * The experiment's name catalog for ensuring uniqueness of simulation
	 * object names within a single experiment.
	 */
	private NameCatalog nameCatalog = new NameCatalog();

	/**
	 * Fully qualified class name of default table formatter (the HTMLFormatter)
	 */
	// public static String DEFAULT_FORMATTER =
	// "desmoj.report.HTMLTableFormatter";
	/** Specifies the default output format for each of the four report types */
	public static final String DEFAULT_REPORT_OUTPUT_TYPE = "desmoj.core.report.HTMLReportOutput";

	public static final String DEFAULT_TRACE_OUTPUT_TYPE = "desmoj.core.report.HTMLTraceOutput";

	public static final String DEFAULT_ERROR_OUTPUT_TYPE = "desmoj.core.report.HTMLErrorOutput";

	public static final String DEFAULT_DEBUG_OUTPUT_TYPE = "desmoj.core.report.HTMLDebugOutput";

	/**
	 * Status of an Experiment just created without any accessories created yet.
	 */
	public static final int NOT_INITIALIZED = -3;

	/**
	 * Status of an Experiment instantiated with all needed accessories
	 * available.
	 */
	public static final int INITIALIZED = -2;

	/**
	 * Status of an Experiment connected to a Model and ready to be started.
	 */
	public static final int CONNECTED = -1;

	/**
	 * Status of an Experiment being started. Only if an Experiment is
	 */
	public static final int STARTED = 0;

	/**
	 * Status of an Experiment stopped after having run.
	 */
	public static final int STOPPED = 1;

	/**
	 * Status of an Experiment currently running the simulation.
	 */
	public static final int RUNNING = 2;

	/**
	 * Status of an Experiment finished and to be cleared.
	 */
	public static final int ABORTED = 3;

	/**
	 * The last suffix used with filenames when creating multiple batch runs of
	 * an experiment.
	 */
	private static int lastSuffix;

	/**
	 * The class reference to messages of type desmoj.core.report.TraceNote
	 */
	static Class<desmoj.core.report.TraceNote> tracenote;

	/**
	 * The class reference to messages of type desmoj.core.report.DebugNote
	 */
	static Class<desmoj.core.report.DebugNote> debugnote;

	/**
	 * The class reference to messages of type desmoj.core.report.ErrorMessage
	 */
	static Class<desmoj.core.report.ErrorMessage> errormessage;

	/**
	 * The class reference to messages of type desmoj.core.report.Reporter
	 */
	static Class<desmoj.core.report.Reporter> reporter;

	/**
	 * Flag indicating if the simulation is running.
	 */
	private int status;

	/**
	 * The model to be run by this experiment.
	 */
	private Model client;

	/**
	 * The scheduler used for this experiment.
	 */
	protected Scheduler clientScheduler;

	/**
	 * The distribution manager for the model's distributions.
	 */
	private DistributionManager distMan;

	/**
	 * The message manager for the model's messages.
	 */
	private MessageDistributor messMan;

	/**
	 * The ThreadGroup for this Experiment.
	 */
	private ThreadGroup expThreads;

	/**
	 * The list to register all OutputType objects to close them after finishing
	 * the Experiment.
	 */
	private java.util.ArrayList<OutputType> registryOutputType;

	/**
	 * The list to register all FileOutput objects to close them after finishing
	 * the Experiment.
	 */
	private java.util.ArrayList<FileOutput> registryFileOutput;

	/**
	 * The resource database storing all resource allocations and requests. Also
	 * needed to detect deadlocks.
	 */
	private ResourceDB resDB;

	/**
	 * The TimeInstant when the experiment is supposed to stop. Is initially
	 * <code>null</code> and will be set only if the user provides a time limit.
	 */
	private TimeInstant stopTime = null;
	
   /**
     * The Event to stop the experiment. Is initially <code>null</code> and will 
     * be set only if the user provides a time limit.
     */
    private ExternalEventStop stopTimeEvent = null;
	
    /**
     * A list of <code>Condition</code>s which cause the experiment to stop. The
     * user has to implement the <code>check()</code> method of the 
     * <code>Condition</code>s in order to effectively stop an experiment.
     */
    private List<Condition> stopConditions;

	/**
	 * Flag indicating whether a progressbar for this experiment should be
	 * displayed or not.
	 */
	private boolean showProgressBar;

	/**
	 * Specifies an output path for the report files (Modification by Nicolas
	 * Knaak, 02/2001)
	 */
	private String pathName;

	/**
	 * Delay between steps of the scheduler in milliseconds. Necessary for
	 * online observation of experiments in FAMOS. (Modification by Nicolas
	 * Knaak, 07/2001)
	 */
	private long delayInMillis = 0;

	/**
	 * The real time (wallclock time) start time of the simulation run.
	 * (Modification by Felix Klueckmann, 05/2009)
	 */
	private long realTimeStartTime;

	/**
	 * The Output classes that create the Output files (debug, report, error,
	 * trace) *
	 */
	private OutputType dbg;

	private OutputType rpt;

	private OutputType err;

	private OutputType trc;

	/**
	 * Constructs a new Experiment with the given name. This is a shortcut
	 * constructor with just the name needed as parameter to identify the
	 * outputfiles produced by this experiment. All other possible settings are
	 * set to default values. These settings for an experiment without special
	 * ExperimentOptions are:
	 * <ol>
	 * <li>seed = 979 : The initial seed setting for the seed-generator</li>
	 * </ol>
	 * The default stop condition for this experiment will never interfere,
	 * always returning false.
	 * 
	 * @param name
	 *            String : The name of the experiment determining the
	 *            outputfile's names, too. So please avoid characters that your
	 *            local filesystem does not support in filenames.
	 */
	public Experiment(String name) {
		this(name, true);
	}

	/**
	 * Constructs a new Experiment with the given name. This is a shortcut
	 * constructor with just an output flag and the name needed as parameter to
	 * identify the outputfiles produced by this experiment. All other possible
	 * settings are set to default values. These settings for an experiment
	 * without special ExperimentOptions are:
	 * <ol>
	 * <li>seed = 979 : The initial seed setting for the seed-generator</li>
	 * </ol>
	 * The default stop condition for this experiment will never interfere,
	 * always returning false.
	 * 
	 * @param name
	 *            String : The name of the experiment determining the
	 *            outputfile's names, too. So please avoid characters that your
	 *            local filesystem does not support in filenames.
	 * @param output
	 *            boolean : This flag indicates if the experiment should write
	 *            output files in the default format (HTML) or no output files
	 *            at all.
	 */
	public Experiment(String name, boolean output) {
		this(name, ".", TimeUnit.MICROSECONDS, TimeUnit.SECONDS, null,
				output ? DEFAULT_REPORT_OUTPUT_TYPE : null,
				output ? DEFAULT_TRACE_OUTPUT_TYPE : null,
				output ? DEFAULT_ERROR_OUTPUT_TYPE : null,
				output ? DEFAULT_DEBUG_OUTPUT_TYPE : null); // call most special
		// constructor
	}

	/**
	 * Constructs a new Experiment with the given name. This is the shortcut
	 * constructor with just the name needed as parameter to identify the
	 * outputfiles produced by this experiment. All other possible settings are
	 * set to default values. These settings for an experiment without special
	 * ExperimentOptions are:
	 * <ol>
	 * <li>seed = 979 : The initial seed setting for the seed-generator</li>
	 * </ol>
	 * The default stop condition for this experiment will never interfere,
	 * always returning false.
	 * 
	 * @param name
	 *            String : The name of the experiment determining the
	 *            outputfile's names, too. So please avoid characters that your
	 *            local filesystem does not support in filenames.
	 * @param pathName
	 *            java.lang.String : The output path for report files
	 */
	public Experiment(String name, String pathName) {

		this(name, pathName, DEFAULT_REPORT_OUTPUT_TYPE,
				DEFAULT_TRACE_OUTPUT_TYPE, DEFAULT_ERROR_OUTPUT_TYPE,
				DEFAULT_DEBUG_OUTPUT_TYPE);
		// call more special constructor

	}

	/**
	 * Constructs a new Experiment with the given parameters. This is a shortcut
	 * constructor. Parameters for the name, the granularity(epsilon), the
	 * reference time unit and a time formatter are needed. All other possible
	 * settings are set to default values. These settings for an experiment
	 * without special ExperimentOptions are:
	 * <ol>
	 * <li>seed = 979 : The initial seed setting for the seed-generator</li>
	 * </ol>
	 * The default stop condition for this experiment will never interfere,
	 * always returning false.
	 * 
	 * @param name
	 *            String : The name of the experiment determining the
	 *            outputfile's names, too. So please avoid characters that your
	 *            local filesystem does not support in filenames.
	 * @param epsilon
	 *            java.util.concurrent.TimeUnit: The granularity of simulation
	 *            time.
	 * @param referenceUnit
	 *            java.util.concurrent.TimeUnit : In statements without an
	 *            explicit declaration of a TimeUnit the reference unit is used.
	 * @param TimeFormatter
	 *            desmoj.core.simulator.TimeFormatter: Defines how time values
	 *            will be formatted in the output files.
	 * 
	 * @see java.util.concurrent.TimeUnit
	 */
	public Experiment(String name, TimeUnit epsilon, TimeUnit referenceUnit,
			TimeFormatter formatter) {
		// call most special constructor
		this(name, ".", epsilon, referenceUnit, formatter,
				DEFAULT_REPORT_OUTPUT_TYPE, DEFAULT_TRACE_OUTPUT_TYPE,
				DEFAULT_ERROR_OUTPUT_TYPE, DEFAULT_DEBUG_OUTPUT_TYPE);

	}
	
	   /**
     * Constructs a new Experiment with the given settings. This is a shortcut
     * constructor. The granularity of simulation time, the reference unit and
     * the time formatter are set to default values. These settings for an
     * experiment without special ExperimentOptions are:
     * <ol>
     * <li>epsilon = MICROSECONDS : The granularity of simulation time</li>
     * <li>reference time = SECONDS : This unit is used in statements without an
     * explicit declaration of a TimeUnit.</li>
     * <li>TimeFormatter =
     * SingleUnitTimeFormatter(TimeUnit.MICROSECONDS,false,false):</li>
     * <li>seed = 979 : The initial seed setting for the seed-generator</li>
     * </ol>
     * The default stop condition for this experiment will never interfere,
     * always returning false.
     * 
     * @param name
     *            String : The name of the experiment determining the
     *            outputfile's names, too. So please avoid characters that your
     *            local filesystem does not support in filenames.
     * @param pathName
     *            java.lang.String : The output path for report files
     * @see desmoj.core.simulator.Units
     * @param reportOutputType
     * @param traceOutputType
     * @param errorOutputType
     * @param debugOutputType
     */
    public Experiment(String name, String pathName, String reportOutputType,
            String traceOutputType, String errorOutputType,
            String debugOutputType) {
        this(name, pathName, TimeUnit.MICROSECONDS, TimeUnit.SECONDS, null,
                reportOutputType, traceOutputType, errorOutputType,
                debugOutputType);
    }

	/**
	 * Constructs a new Experiment with the given parameters. This is the most
	 * special constructor. The shortcut constructors call this constructor to
	 * create an experiment object. Sets the seed for the seed-generator to the
	 * default value 979. Use setSeedGenerator to set a different value. The
	 * default stop condition for this experiment will never interfere, always
	 * returning false.
	 * 
	 * @param name
	 *            String : The name of the experiment determining the
	 *            outputfile's names, too. So please avoid characters that your
	 *            local filesystem does not support in filenames.
	 * @param pathName
	 *            java.lang.String : The output path for report files
	 * @param epsilon
	 *            java.util.concurrent.TimeUnit: The granularity of simulation
	 *            time.
	 * @param referenceUnit
	 *            java.util.concurrent.TimeUnit : In statements without an
	 *            explicit declaration of a TimeUnit the reference unit is used.
	 * @param TimeFormatter
	 *            desmoj.core.simulator.TimeFormatter: Defines how time values
	 *            will be formatted in the output files.
	 * 
	 * @see java.util.concurrent.TimeUnit
	 */
	@SuppressWarnings("unchecked")
	public Experiment(String name, String pathName, TimeUnit epsilon,
			TimeUnit referenceUnit, TimeFormatter formatter,
			String reportOutputType, String traceOutputType,
			String errorOutputType, String debugOutputType) {
		super(name); // create a NamedObject with an attitude ;-)

		// initialize variables
		status = NOT_INITIALIZED;
		stopConditions = new ArrayList<Condition>(); // empty, i.e. no Stopper can be set at instantiation time
		expThreads = new ThreadGroup(name);
		registryFileOutput = new ArrayList<FileOutput>();
		registryOutputType = new ArrayList<OutputType>();
		lastSuffix = 0; // no batches have run so far ;-)
		showProgressBar = true; // display a progress bar for this experiment

		// Check and set output path
		if (pathName == null
				|| (pathName != null && (pathName.isEmpty() || pathName
						.equals("."))))
			this.pathName = System.getProperty("user.dir", ".");
		else
			this.pathName = pathName;

		// set class variables for basic messagetypes
		try {
			tracenote = (Class<TraceNote>) Class
					.forName("desmoj.core.report.TraceNote");
			debugnote = (Class<DebugNote>) Class
					.forName("desmoj.core.report.DebugNote");
			errormessage = (Class<ErrorMessage>) Class
					.forName("desmoj.core.report.ErrorMessage");
			reporter = (Class<Reporter>) Class
					.forName("desmoj.core.report.Reporter");
		} catch (ClassNotFoundException cnfEx) {
			System.out.println("Can not create Experiment!");
			System.out.println("Constructor of desmoj.Experiment.");
			System.out.println("Classes are probably not installed correctly.");
			System.out.println("Check your CLASSPATH setting.");
			System.out.println("Exception caught : " + cnfEx);
		}

		// create output system first
		messMan = new MessageDistributor();

		// create and register the debug output

		try {
			Class<OutputType> debugOType = (Class<OutputType>) Class
					.forName((debugOutputType != null) ? debugOutputType
							: DEFAULT_DEBUG_OUTPUT_TYPE);
			dbg = debugOType.newInstance();
			if (debugOutputType != null)
				dbg.open(pathName, name);
			messMan.register(dbg, debugnote);
			messMan.switchOff(debugnote);
			register(dbg);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		// create and register the report output

		try {
			Class<OutputType> reportOType = (Class<OutputType>) Class
					.forName((reportOutputType != null) ? reportOutputType
							: DEFAULT_REPORT_OUTPUT_TYPE);
			rpt = reportOType.newInstance();
			if (reportOutputType != null)
				rpt.open(pathName, name);
			messMan.register(rpt, reporter);
			register(rpt);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		// create and register the error output

		try {
			Class<OutputType> errorOType = (Class<OutputType>) Class
					.forName((errorOutputType != null) ? errorOutputType
							: DEFAULT_ERROR_OUTPUT_TYPE);
			err = errorOType.newInstance();
			// err.setTimeFloats(timeFloats);
			if (errorOutputType != null)
				err.open(pathName, name);
			messMan.register(err, errormessage);
			register(err);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		// create and register the trace output

		try {
			Class<OutputType> traceOType = (Class<OutputType>) Class
					.forName((traceOutputType != null) ? traceOutputType
							: DEFAULT_TRACE_OUTPUT_TYPE);
			trc = traceOType.newInstance();
			if (traceOutputType != null)
				trc.open(pathName, name);
			messMan.register(trc, tracenote);
			messMan.switchOff(tracenote);
			register(trc);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		// create the distributionmanager to register distributions at
		distMan = new DistributionManager(name, 979);

		// now create the simulation runtime accessories
		client = null; // no object connected

		// check for null reference
		if (epsilon == null) {
			// set to default unit
			epsilon = TimeUnit.MICROSECONDS;
		}
		if (referenceUnit == null) {
			// set to default unit
			referenceUnit = TimeUnit.SECONDS;
		}
		// interchange epsilon and reference unit if the reference unit has a
		// finer granularity than epsilon
		if (referenceUnit.compareTo(epsilon) < 0) {
			TimeUnit buffer = referenceUnit;
			referenceUnit = epsilon;
			epsilon = buffer;
		}
		// set epsilon and referenceUnit
		TimeOperations.setEpsilon(epsilon);
		TimeOperations.setReferenceUnit(referenceUnit);

		// check for null reference
		if (formatter == null) {
			formatter = new SingleUnitTimeFormatter(referenceUnit,
			        epsilon, 4, false);
		}
		TimeOperations.setTimeFormatter(formatter);

		// building the scheduler: prepare event list...
		// (for efficiency reasons, we use the TreeList-basd implementation)
		EventList eventList = new EventTreeList();

		// create the scheduler (and clock)
		clientScheduler = createScheduler(name, eventList);

		// create a resource database and tell it that it belongs to this
		// experiment
		resDB = new ResourceDB(this);

		// set status to first valid value - initialized, but not connected
		status = INITIALIZED;
	}

	/**
	 * Creates a scheduler for this experiment.
	 * 
	 * @param exp
	 *            the experiment
	 * @param name
	 *            experiment name
	 * @param epsilon
	 *            smallest sim time unit
	 * @return a new scheduler
	 */
	protected Scheduler createScheduler(String name, EventList evl) {
		Scheduler s = new Scheduler(this, name, evl);
		return s;
	}

	/**
	 * Adds a messagereceiver for debugnotes to the experiment. Whenever a model
	 * produces a message of that type, it will also be sent to the given
	 * messagereceiver for further processing. Note that the given receiver must
	 * be capable of handling debugnotes.
	 * 
	 * @param trcRec
	 *            desmoj.report.MessageReceiver : The new messagereceiver for
	 *            the given type of messages
	 */
	public void addDebugReceiver(MessageReceiver trcRec) {

		if (trcRec == null) {
			sendWarning("Can not add receiver to experiment! Command ignored.",
					"Experiment '" + getName()
							+ "', method 'void addDebugReceiver("
							+ "MessageReceiver trcRec)'",
					"The parameter 'trc' passed was a null reference.",
					"Make sure to construct a valid MessageReciever before adding it to "
							+ "the experiment's messaging system.");
			return; // do nothing
		}

		messMan.register(trcRec, debugnote);

	}

	/**
	 * Adds a messagereceiver for error messages to the experiment. Whenever a
	 * model produces a message of that type, it will also be sent to the given
	 * messagereceiver for further processing. Note that the given receiver must
	 * be capable of handling messagereceiver.
	 * 
	 * @param trcRec
	 *            desmoj.report.MessageReceiver : The new messagereceiver for
	 *            the given type of messages
	 */
	public void addErrorReceiver(MessageReceiver trcRec) {

		if (trcRec == null) {
			sendWarning("Can not add receiver to experiment! Command ignored.",
					"Experiment '" + getName()
							+ "', method 'void addErrorReceiver("
							+ "MessageReceiver trcRec)'",
					"The parameter 'trc' passed was a null reference.",
					"Make sure to construct a valid MessageReciever before adding it to "
							+ "the experiment's messaging system.");
			return; // do nothing
		}

		messMan.register(trcRec, errormessage);

	}

	/**
	 * Returns the experiments name catalog for ensuring unique names of
	 * simulation objects within a single experiment.
	 */
	NameCatalog getNameCatalog() {
		return nameCatalog;
	}

	/**
	 * Adds a messagereceiver for the given subtype of message to the
	 * experiment. Whenever a model produces a message of that type, it will
	 * also be sent to the given messagereceiver for further processing.
	 * 
	 * @param trcRec
	 *            desmoj.report.MessageReceiver : The new messagereceiver for
	 *            the given type of messages
	 * @param messageType
	 *            Class : The type of message to be sent to the given
	 *            messagereceiver
	 */
	public void addReceiver(MessageReceiver trcRec, Class messageType) {

		if (trcRec == null) {
			sendWarning("Can not add receiver to experiment! Command ignored.",
					"Experiment '" + getName()
							+ "', method 'void addReceiver(MessageReceiver "
							+ "trcRec, Class messageType)'",
					"The parameter 'trc' passed was a null reference.",
					"Make sure to construct a valid MessageReciever before adding it to "
							+ "the experiment's messaging system.");
			return; // do nothing
		}

		if (messageType == null) { // again these damned null values
			sendWarning("Can not add receiver to experiment! Command ignored.",
					"Experiment '" + getName()
							+ "', method 'void addReceiver(MessageReceiver "
							+ "trcRec, Class messageType)'",
					"The parameter 'messageType' passed was a null reference.",
					"Make sure to construct a valid Class object before adding it to "
							+ "the experiment's messaging system.");
			return; // do nothing
		}

		messMan.register(trcRec, messageType);

	}

	/**
	 * Adds a messagereceiver for tracenotes to the experiment. Whenever a model
	 * produces a message of that type, it will also be sent to the given
	 * messagereceiver for further processing. Note that the given Receiver must
	 * be capable of handling tracenotes.
	 * 
	 * @param trcRec
	 *            desmoj.report.MessageReceiver : The new messagereceiver for
	 *            the given type of messages
	 */
	public void addTraceReceiver(MessageReceiver trcRec) {

		if (trcRec == null) {
			sendWarning("Can not add receiver to experiment! Command ignored.",
					"Experiment '" + getName()
							+ "', method 'void addTraceReceiver("
							+ "MessageReceiver trcRec)'",
					"The parameter 'trc' passed was a null reference.",
					"Make sure to construct a valid MessageReciever before adding it to "
							+ "the experiment's messaging system.");
			return; // do nothing
		}

		messMan.register(trcRec, tracenote);

	}

	/**
	 * Returns a boolean indicating whether debug notes are forwarded to the
	 * debug ouput or not. Debug ouput can be switched on and off using the
	 * methods <code>debugOn(TimeInstant startTime)</code> or
	 * <code>debugOff(TimeInstant stopTime)</code>
	 * 
	 * @return boolean
	 */
	public boolean debugIsOn() {

		return messMan.isOn(debugnote);

	}

	/**
	 * Switches the debug output off at the given point of simulation time.
	 * 
	 * @param duration
	 *            TimeInstant : The point in simulation time to switch off debug
	 */
	public void debugOff(TimeInstant stopTime) {

		// check initial TimeInstant parameter
		if (stopTime == null) {
			sendWarning(
					"Invalid start time parameter for debug output given! "
							+ "StopTime is set to current time.",
					"Experiment '" + getName()
							+ "', method 'void debugOn(TimeInstant startTime)'",
					"A null value or a not initialized TimeInstant reference has been passed.",
					"Make sure to have a valid TimeInstant object, otherwise use method "
							+ "start() without TimeInstant parameter.");
			stopTime = clientScheduler.presentTime();
		}

		// check if parameter is in future
		if (TimeInstant.isAfter(clientScheduler.presentTime(), stopTime)) {
			sendWarning("Invalid start time parameter for debug output given! "
					+ "StopTime is set to current time.", "Experiment '"
					+ getName()
					+ "', method 'void debugOn(TimeInstant stopTime)'",
					"The stopTime given is in the past.",
					"Make sure to give a TimeInstant parameter larger than the current time.");
			stopTime = clientScheduler.presentTime();
		}

		ExternalEvent debugOff = new ExternalEventDebugOff(client, true);

		debugOff.schedule(stopTime);

	}	
	   
    /**
     * @deprecated Use debugOff(TimeInstant startTime). Switches the debug output off at the given point of simulation time.
     * 
     * @param stopTime
     *            SimTime : The point in simulation time to switch debug off
     */
    public void debugOff(SimTime stopTime) {
        this.debugOff(SimTime.toTimeInstant(stopTime));        
    }

	/**
	 * Switches the debug output on at the given point of simulation time.
	 * 
	 * @param duration
	 *            TimeInstant : The point in simulation time to switch on debug
	 */
	public void debugOn(TimeInstant startTime) {

		// check initial TimeInstant parameter
		if (startTime == null) {
			sendWarning(
					"Invalid start time parameter for debug output given! "
							+ "StartTime is set to current time.",
					"Experiment '" + getName()
							+ "', method 'void debugOn(TimeInstant startTime)'",
					"A null value or a not initialized TimeInstant reference has been passed.",
					"Make sure to have a valid TimeInstant object, otherwise use method "
							+ "start() without TimeInstant parameter.");
			startTime = clientScheduler.presentTime();
		}

		// check if parameter is in future
		if (TimeInstant.isAfter(clientScheduler.presentTime(), startTime)) {
			sendWarning("Invalid start time parameter for debug output given! "
					+ "StartTime is set to current time.", "Experiment '"
					+ getName()
					+ "', method 'void debugOn(TimeInstant startTime)'",
					"The startTime given is in the past.",
					"Make sure to give a TimeInstant parameter larger than the current time.");
			startTime = clientScheduler.presentTime();
		}

		ExternalEvent debugOn = new ExternalEventDebugOn(client, true);

		debugOn.schedule(startTime);

	}
    
    /**
     * @deprecated Use debugOn(TimeInstant startTime). Switches the debug output on at the given point of simulation time.
     * 
     * @param startTime
     *            SimTime : The point in simulation time to switch debug on
     */
    public void debugOn(SimTime startTime) {
        this.debugOn(SimTime.toTimeInstant(startTime));        
    }

	/**
	 * Switches the debug output on for the given period of simulation time. If
	 * the second parameter (off) is "sooner" then the first parameter (on),
	 * they will be swapped automatically. Same parameters will result in no
	 * debug output at all!
	 * 
	 * @param duration
	 *            TimeInstant : The point in simulation time to switch debug on
	 * @param duration
	 *            TimeInstant : The point in simulation time to switch debug off
	 */
	public void debugPeriod(TimeInstant startTime, TimeInstant stopTime) {
		// check initial TimeInstant parameter
		if (startTime == null) {
			sendWarning(
					"Invalid start time parameter for debug output given! Command ignored",
					"Experiment '" + getName()
							+ "', Method 'debugPeriod(TimeInstant startTime, "
							+ "TimeInstant stopTime)'",
					"A null value or a not initialized TimeInstant reference has been passed.",
					"Make sure to have a valid TimeInstant object.");
			return;
		}

		// check initial TimeInstant parameter
		if (stopTime == null) {
			sendWarning(
					"Invalid stop time parameter for debug output given! Command ignored.",
					"Experiment '" + getName()
							+ "', Method 'debugPeriod(TimeInstant startTime, "
							+ "TimeInstant stopTime)'",
					"A null value or a not initialized TimeInstant reference has been passed.",
					"Make sure to have a valid TimeInstant object.");
			return;
		}

		// check for correct order in parameters
		if (TimeInstant.isAfter(startTime, stopTime)) {

			// swap parameters
			TimeInstant buffer = stopTime;
			stopTime = startTime;
			startTime = buffer;

		}

		// check if stop parameter is in future
		if (TimeInstant.isAfter(clientScheduler.presentTime(), stopTime)) {
			sendWarning(
					"Invalid stop time parameter for debug output given! Command ignored.",
					"Experiment '" + getName()
							+ "', Method 'debugPeriod(TimeInstant startTime, "
							+ "TimeInstant stopTime)'",
					"The stopTime given is in the past.",
					"Make sure to give a TimeInstant parameter larger than the current time.");
			return;
		}

		// check if start parameter is in past
		if (TimeInstant.isAfter(clientScheduler.presentTime(), startTime)) {
			sendWarning("Invalid start time parameter for debug output given! "
					+ "Debug output has been set to start immediately.",
					"Experiment '" + getName()
							+ "', Method 'debugPeriod(TimeInstant startTime, "
							+ "TimeInstant stopTime)'",
					"The startTime given is in the past.",
					"Make sure to give a TimeInstant parameter larger than the current time.");
			startTime = clientScheduler.presentTime();
		}

		// set debug to switch on
		debugOn(startTime);

		// set debug to switch off
		debugOff(stopTime);
	}

	/**
	 * @deprecated Replaced by debugTime(TimeInstant a, TimeInstant b). Switches
	 *             the debug output on for the given period of simulation time.
	 *             If the second parameter (off) is "sooner" then the first
	 *             parameter (on), they will be swapped automatically. Same
	 *             parameters will result in no debug output at all!
	 * 
	 * @param duration
	 *            SimTime : The point in simulation time to switch debug on
	 * @param duration
	 *            SimTime : The point in simulation time to switch debug off
	 */
	@Deprecated
	public void debugPeriod(SimTime startTime, SimTime stopTime) {
		debugPeriod(SimTime.toTimeInstant(startTime), SimTime
				.toTimeInstant(stopTime));
	}

	/**
	 * De-registers a file at the experiment. Registered files will be flushed
	 * and closed after the experiment has finished. If the file is manually
	 * closed by the user and has been registered at the Experiment, deRegister
	 * it
	 * 
	 * @param file
	 *            desmoj.report.FileOutput : The file to be closed with the end
	 *            of an Experiment
	 */
	public void deRegister(FileOutput file) {

		if (file == null) {
			sendWarning("Can not de-register FileOutput! Command ignored.",
					"Experiment '" + getName()
							+ "' method 'void deRegister(FileOutput file).'",
					"The parameter given was a null reference.",
					"Make sure to only connect valid FileOutputs at the Experiment.");
			return;
		}

		registryFileOutput.remove(file);
		// remove whether it was inside or not

	}

	/**
	 * Stopps all running simprocesses that might still be scheduled and closes
	 * the output files.
	 */
	public void finish() {

		// check if experiment has not been aborted before
		if (status >= ABORTED) {
			return;
		}

		// set status to let all simthreads be killed
		status = ABORTED;

		// close all files still open
		for (OutputType o : registryOutputType)
			o.close();
		for (FileOutput f : registryFileOutput)
			f.close();

		// kill all SimThreads still active
		Thread[] survivors = new Thread[expThreads.activeCount()];
		expThreads.enumerate(survivors);

		for (int i = 0; i < survivors.length; i++) {

			// print existing threads for controlling purposes only
			// System.out.println(survivors[i]);

			// if we get the enumeration of survivors, some of them
			// might not have made it until here and die in between
			// so an occasional NullPointerException is perfectly
			// alright and no reason to worry -> we just dump it.
		    if (survivors[i] instanceof SimThread) { 
    			try {
    				((SimThread) survivors[i]).kill();
    			} catch (NullPointerException e) {
    				; // forget it anyway...
    			}
		    }
		}

	}

	/**
	 * Returns the distributionmanager for this experiment. Distributions need
	 * access to the distributionmanager for handling antithetic modes,
	 * resetting and their initial seeds.
	 * 
	 * @return desmoj.dist.DistributionManager : The distributionmanager for
	 *         this experiment
	 */
	public DistributionManager getDistributionManager() {

		return distMan;

	}

	/**
	 * Returns the epsilon value representing the granularity 
	 * of simulation time for this experiment. So far, Hour, Minute,
	 * Second and Millisecond are supported.
	 * 
	 * @return TimeUnit : The Granularity of the simulation time
	 */	
	public TimeUnit getEpsilonUnit() {

		return TimeOperations.getEpsilon();
	}
	
    /**
     * @deprecated Use getEpsilonUnit(). 
     * Returns a SimTime representation of the granularity of simulation time 
     * for this experiment. So far, Hour, Minute,
     * Second and Millisecond are supported.
     * 
     * @return SimTime : The Granularity of the simulation time
     */ 
    public SimTime getEpsilon() {

        return SimTime.toSimTime(new TimeSpan (1L, TimeOperations.getEpsilon()));
    }

	/**
	 * Returns the current execution Speed Rate.
	 * 
	 * @return double : The current execution speed rate.
	 */
	public double getExecutionSpeedRate() {
		return this.clientScheduler.getExecutionSpeedRate();
	}

	/**
	 * Returns the messagemanager for this experiment. Messages need access to
	 * the MessageManager for distributing the messages to one or more specified
	 * output streams.
	 * 
	 * @return desmoj.dist.MessageManager : The messagemanager for this
	 *         experiment
	 */
	public MessageDistributor getMessageManager() {

		return messMan;

	}
	
	/**
	 * Returns the model that is connected to this experiment or
	 * <code>null</code> if no model is connected so far.
	 * 
	 * @return Model : The model that this experiment is connected to or
	 *         <code>null</code> if no connection is established.
	 */
	public Model getModel() {

		return client;

	}

	/**
	 * Returns the name of the path the experiment's report-, trace-, debug- and
	 * error-files are written to.
	 * 
	 * @return String the experiment's output path
	 */
	public String getOutputPath() {
		return new File(pathName).getAbsolutePath();
	}

	public String[] getOutputAppendixes() {
		String[] Appendixes = { dbg.getAppendix(), trc.getAppendix(),
				err.getAppendix(), rpt.getAppendix() };
		return Appendixes;
	}

	public long getRealTimeStartTime() {
		return realTimeStartTime;
	}

	/**
	 * Returns the reference unit for this experiment. This is the time unit
	 * mapped to a time step of 1.0 in simulation time. So far, Hour, Minute,
	 * Second and Millisecond are supported.
	 * 
	 * @return TimeUnit : The reference unit.
	 */
	public TimeUnit getReferenceUnit() {
		return TimeOperations.getReferenceUnit();
	}

	/**
	 * Returns the resource database for this experiment. The <code>Res</code>
	 * objects need access to the resource database to note their resource
	 * allocations and requests and for deadlock detection.
	 * 
	 * @return desmoj.ResourceDB : the resource database storing all resource
	 *         allocations and requests.
	 * @author Soenke Claassen
	 */
	public ResourceDB getResourceDB() {

		return resDB;
	}

	/**
	 * Returns the scheduler for this experiment. ModelComponents need access to
	 * the scheduler for identifying the current active entity or process and to
	 * schedule themselves or other schedulables to activate at a given time in
	 * the future.
	 * 
	 * @return Scheduler : The scheduler for this experiment
	 */
	public Scheduler getScheduler() {

		return clientScheduler;

	}

	/**
	 * Returns the simclock for this experiment. ModelComponents need access to
	 * the simclock for retrieveing the current simulation time.
	 * 
	 * @return SimCLock : The simclock for this experiment
	 */
	public SimClock getSimClock() {

		return clientScheduler.getSimClock();

	}

	/**
	 * Returns the TimeInstant when the experiment is expected to stop running.
	 * 
	 * @return desmoj.TimeInstant : The time, the experiment is expected to stop
	 *         running.
	 */
	public TimeInstant getStopTime() {

		return stopTime;
	}

	/**
	 * Returns the threadgroup associated to this experiment. All Threads are
	 * associated to this threadgroup to get control of their number and state
	 * and to have a means to differentiate them from possible other
	 * experiments' threads.
	 * 
	 * @return java.lang.ThreadGroup
	 */
	ThreadGroup getThreadGroup() {

		return expThreads;

	}
	
	/**
     * @deprecated Depends on TimeFormatter in use. Returns the experiment's number 
     * of floating point digits of simulation time that are displayed in the various output files,
     * as read from the SingleUnitTimeFormatter, if in use. Otherwise, 0 will be returned.
     * 
     * @return int : The number of floating point digits of simulation time to
     *         be displayed in output files
     */
    public int getTimeFloats() {
        
        if (TimeOperations.getTimeFormatter() instanceof SingleUnitTimeFormatter) {
            return (int) ((SingleUnitTimeFormatter)TimeOperations.getTimeFormatter()).floats;
        } else 
            return 0;
    }

	/**
	 * Displays the current state of the simulation run. If an experient is
	 * aborted, it can not be proceeded. All SimThreads still active are
	 * stopped, the main routine can finish.
	 * 
	 * @return boolean : Is <code>true</code> if the simulation is aborted,
	 *         <code>false</code> if it has not started yet or is still running
	 */
	public boolean isAborted() {

		return (status >= ABORTED);

	}

	/**
	 * Shows if this experiment has already been connected to a model.
	 * 
	 * @return boolean : Is <code>true</code>, if experiment is connected to a
	 *         model, <code>false</code> otherwise
	 */
	public boolean isConnected() {

		return (status >= CONNECTED); // model connected

	}

	/**
	 * Returns if the event list processes concurrent events in random order or
	 * not. Default is not.
	 * 
	 * @return boolean: <code>true</code> if concurrent events are randomized,
	 *         <code>false</code> otherwise
	 * @author Ruth Meyer
	 */
	public boolean isRandomizingConcurrentEvents() {
		return clientScheduler.isRandomizingConcurrentEvents();
	}

	/**
	 * Displays the current state of the simulation run.
	 * 
	 * @return boolean : Is <code>true</code> if the simulation is running,
	 *         <code>false</code> if it has not started yet or has already
	 *         finished
	 */
	public boolean isRunning() {

		return (status == RUNNING);

	}

	/**
	 * Returns if a progress bar should be displayed for this experiment or not.
	 * 
	 * @return boolean :<code>true</code> if a progress bar should be displayed
	 *         for this experiment, <code>false</code> otherwise.
	 */
	public boolean isShowProgressBar() {

		return showProgressBar;
	}

	/**
	 * Displays the current state of the simulation run. If an experient is
	 * stopped, it can be proceeded by calling proceed().
	 * 
	 * @return boolean : Is <code>true</code>, if experiment is stopped,
	 *         <code>false</code> otherwise
	 */
	public boolean isStopped() {

		return (status == STOPPED); // model stopped

	}

	/**
	 * Proceeds with a stopped experiment. An experiment can be stopped, if
	 * either its status is changed from <code>RUNNING</code> to some other
	 * state, the scheduler runs out of scheduled events or if the
	 * <code>check()</code> method of the given stop <code>Condition</code>
	 * returns <code>true</code> after an Event has been processed.
	 */
	public void proceed() {

		if (status < STARTED) {
			sendWarning(
					"Can not proceed with Experiment! Command ignored.",
					"Experiment: " + getName() + " Method: void proceed().",
					"The Experiment has not been started yet.",
					"Only Experiments that have been stopped after method 'start()' has "
							+ "been called can use method 'proceed()' to continue.");
			return;
		}

		if (status > STOPPED) {
			sendWarning("Can not proceed with Experiment! Command ignored.",
					"Experiment " + getName() + " Method: void proceed().",
					"The Experiment has already been aborted.",
					"Use method 'proceed()' only on stopped experiments.");
			return;
		}
		if (status == STARTED) {
			// print status message to calm users waiting long, long, long
			// hours...
			System.out.println("***** DESMO-J version " + getDesmoJVersion()
					+ " ***** \n" + getName() + " starts at simulation time "
					+ getScheduler().presentTime() + "\n ...please wait...");
		}
		else{
			System.out.println(getName() + " resumes at simulation time "
					+ getScheduler().presentTime() + "\n ...please wait...");
		}
		// display a progress bar if stop time is known and showProgressBar is
		// true
		if (stopTime != null && showProgressBar) {
			JFrame frame = new ExpProgressBar(this);

			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});

			frame.pack();
			// frame.setSize(380,90);
			frame.setVisible(true);
		}

		status = RUNNING; // now checked to run
		boolean gotEvent = false; // buffer to check if scheduler works

		try {

			while (status == RUNNING) {
				// infinite loop until condition/time expired
				gotEvent = clientScheduler.processNextEventNote();
				if (gotEvent == false) {
					status = STOPPED;
				}

				// check potential stop conditions
				if (!stopConditions.isEmpty()) {
				    for (Condition c : stopConditions) {
    					if (c.check()) {
    						status = STOPPED;
    						break;
    					}
				    }
				}

				// Sleep a while (modified by N. Knaak)
				if (status == RUNNING && delayInMillis != 0)
					Thread.sleep(delayInMillis);
			}
		} catch (DESMOJException e) {
			System.out.println("desaster recovery");
			// this is the desaster recovery routine to stop simulation and save
			// the report to disc before exiting the faulty experiment
			messMan.receive(e.getErrorMessage());
			report();
			finish();
			status = ABORTED;
			e.printStackTrace();
		} catch (java.lang.InterruptedException e) {
			System.out.println("desaster recovery");
			// this is the disaster recovery routine to stop simulation and save
			// the report to disc before exiting the faulty experiment
			// messMan.receive(e.getMessage());
			report();
			finish();
			status = ABORTED;
		}

		// give warning if reason for stopping was empty eventlist
		if (gotEvent == false) {
			sendWarning("No more events scheduled! Experiment is stopped.",
					"Experiment '" + getName() + "' method void proceed().",
					"The scheduler has run out of events to handle.",
					"Make sure to always have events to be scheduled i.e. by letting an "
							+ "Entity create and schedule its successor.");
		}

		// print status message to user...
		System.out.println(getName() + " stopped at simulation time "
				+ getScheduler().presentTime());

	}

	/**
	 * Sets the delay between each step of the scheduler.
	 * 
	 * @param delay
	 *            : Delay time in milliseconds as a long value
	 * @author Nicolas Knaak
	 */
	// TODO: wohl auch nicht mehr nötig
	public void setDelayInMillis(long delay) {
		delayInMillis = delay;
	}

	/**
	 * Returns the delay between each step of the scheduler
	 * 
	 * @return A long value representing the delay time in milliseconds
	 * @author Nicolas Knaak
	 * 
	 */
	// TODO:wohl auch nicht mehr nötig
	public long getDelayInMillis() {
		return delayInMillis;
	}


	/**
	 * Registers a file output (Report, Trace, Error, Debug) in specific formats
	 * (e.g. HTML, ASCII, XML) at the experiment. Registered files will be
	 * flushed and closed after the experiment has finished. This is handy for
	 * modellers producing their own output who want their files to be closed at
	 * the end of the experiment.
	 * 
	 * @param file
	 *            desmoj.report.FileOutput : The file to be closed with the end
	 *            of an experiment
	 */
	public void register(OutputType file) {

		if (file == null) {
			sendWarning("Can not register OutputType! Command ignored.",
					"Experiment '" + getName()
							+ "' method void register(OutputType file).",
					"The parameter given was a null reference.",
					"Make sure to only connect valid OutputType at the Experiment.");
			return;
		}

		if (registryOutputType.contains(file))
			return; // file already registered

		registryOutputType.add(file);

	}

	/**
	 * Registers a custom file output at the experiment, e.g. TimeSeries
	 * plotting data to a file. Registered files will be flushed and closed
	 * after the experiment has finished. This is handy for modellers producing
	 * their own output who want their files to be closed at the end of the
	 * experiment.
	 * 
	 * @param file
	 *            desmoj.report.FileOutput : The file to be closed with the end
	 *            of an experiment
	 */
	public void registerFileOutput(FileOutput file) {

		if (file == null) {
			sendWarning("Can not register FileOutput! Command ignored.",
					"Experiment '" + getName()
							+ "' method void register(OutputType file).",
					"The parameter given was a null reference.",
					"Make sure to only connect valid FileOutput at the Experiment.");
			return;
		}

		if (registryFileOutput.contains(file))
			return; // file already registered

		registryFileOutput.add(file);

	}

	/**
	 * Connects a model to this experiment. The given model must not be submodel
	 * of other models and not already be connected to some other experiment.
	 * Otherwise an errormessage will be given and the experiment will be
	 * stopped.
	 */
	void registerModel(Model mainModel) {

		if (mainModel == null) {
			sendWarning(
					"Can not register model at experiment! Command ignored.",
					"Experiment '" + getName()
							+ "', Method 'void registerModel(Model mainModel)'",
					"The parameter passed was a null reference.",
					"Make sure to connect a valid main model to this experiment.");
			return; // no connection possible.
		}

		if (mainModel.getModel() != null) {
			sendWarning(
					"Can not register model at experiment! Command ignored.",
					"Experiment '" + getName()
							+ "', Method 'void registerModel(Model mainModel)'",
					"The model references another model as its owner, thus can not be the "
							+ "main model.",
					"Make sure to connect a valid main model to this experiment.");
			return; // no connection possible.
		}

		if (isConnected()) {
			sendWarning(
					"Can not register model at experiment! Command ignored.",
					"Experiment '" + getName()
							+ "', Method 'void registerModel(Model mainModel)'",
					"This experiment is already connected to model : "
							+ client.getName(),
					"An experiment may only be connected to one main model at a time.");
			return; // no connection possible.
		}

		status = CONNECTED;
		client = mainModel;
		client.setMain();

	}

	/**
	 * Removes a messagereceiver for debugnotes from the experiment's
	 * messagedistributor. Whenever a model produces a message of that type, it
	 * will not be sent to the given messagereceiver anymore. Note that if the
	 * messagereceiver is also registered for other types of messages, these
	 * will not be affected. Use method
	 * <code>removeReceiverAll(MessageReceiver msgRec)</code> to remove a
	 * messagereceiver from all types of messages.
	 * 
	 * @param trcRec
	 *            desmoj.report.MessageReceiver : The new messagereceiver to be
	 *            removed from the messagedistributor's list for the given
	 *            messagetype
	 */
	public void removeDebugReceiver(MessageReceiver msgRec) {

		if (msgRec == null) {
			sendWarning(
					"Can not remove receiver to experiment! Command ignored.",
					"Experiment '" + getName()
							+ "', Method 'void removeDebugReceiver"
							+ "(MessageReceiver msgRec)'",
					"The parameter 'msgRec' passed was a null reference.",
					"Make sure to give a valid MessageReciever reference before removing it "
							+ "from the experiment's messaging system.");
			return; // do nothing
		}

		messMan.deRegister(msgRec, debugnote);

	}

	/**
	 * Removes a messagereceiver for errormessages from the experiment's
	 * messagedistributor. Whenever a model produces a message of that type, it
	 * will not be sent to the given messagereceiver anymore. Note that if the
	 * messagereceiver is also registered for other types of messages, these
	 * will not be affected. Use method
	 * <code>removeReceiverAll(MessageReceiver msgRec)</code> to remove a
	 * messagereceiver from all types of messages.
	 * 
	 * @param trcRec
	 *            desmoj.report.MessageReceiver : The new messagereceiver to be
	 *            removed from the vessagedistributor's list for the given
	 *            messagetype
	 */
	public void removeErrorReceiver(MessageReceiver msgRec) {

		if (msgRec == null) {
			sendWarning(
					"Can not remove receiver to experiment! Command ignored.",
					"Experiment '" + getName()
							+ "', Method 'void removeErrorReceiver"
							+ "(MessageReceiver msgRec)'",
					"The parameter 'msgRec' passed was a null reference.",
					"Make sure to give a valid MessageReciever reference before removing it "
							+ "from the experiment's messaging system.");
			return; // do nothing
		}

		messMan.deRegister(msgRec, errormessage);

	}

	/**
	 * Removes a messagereceiver from the experiment's messagedistributor. The
	 * given messagereceiver will not receive messages of any type any more Use
	 * method <code>removeReceiver(MessageReceiver msgRec, Class
	 * messageType)</code> to remove the messagereceiver from one type of
	 * messages only.
	 * 
	 * @param trcRec
	 *            desmoj.report.MessageReceiver : The new messagereceiver to be
	 *            removed from the messagedistributor's list for the given
	 *            messagetype
	 */
	public void removeReceiver(MessageReceiver msgRec) {

		if (msgRec == null) {
			sendWarning(
					"Can not remove receiver to experiment! Command ignored.",
					"Experiment '" + getName()
							+ "', Method 'void removeReceiver(MessageReceiver "
							+ "msgRec)'",
					"The parameter 'msgRec' passed was a null reference.",
					"Make sure to give a valid MessageReciever reference before removing it "
							+ "from the experiment's messaging system.");
			return; // do nothing
		}

		messMan.deRegister(msgRec);

	}

	/**
	 * Removes a messagereceiver for the given subtype of message from the
	 * Experiment's messagedistributor. Whenever a model produces a message of
	 * that type, it will not be sent to the given messagereceiver anymore. Note
	 * that if the messagereceiver is also registered for other types of
	 * messages, these will not be affected. Use method
	 * <code>removeReceiverAll(MessageReceiver msgRec)</code> to remove a
	 * messagereceiver from all types of messages.
	 * 
	 * @param trcRec
	 *            desmoj.report.MessageReceiver : The new messagereceiver to be
	 *            removed from the messagedistributor's list for the given
	 *            messagetype
	 * @param messageType
	 *            Class : The type of message not to be sent to the given
	 *            messagereceiver
	 */
	public void removeReceiver(MessageReceiver msgRec, Class messageType) {

		if (msgRec == null) {
			sendWarning(
					"Can not remove receiver to experiment! Command ignored.",
					"Experiment '" + getName()
							+ "', Method 'void removeReceiver(MessageReceiver "
							+ "msgRec, Class messageType)'",
					"The parameter 'msgRec' passed was a null reference.",
					"Make sure to give a valid MessageReciever reference before removing it "
							+ "from the experiment's messaging system.");
			return; // do nothing
		}

		if (messageType == null) {
			sendWarning(
					"Can not remove receiver to experiment! Command ignored.",
					"Experiment '" + getName()
							+ "', Method 'void removeReceiver(MessageReceiver "
							+ "msgRec, Class messageType)'",
					"The parameter 'msgRec' passed was a null reference.",
					"Make sure to give a valid MessageReciever reference before removing it "
							+ "from the experiment's messaging system.");
			return; // do nothing
		}

		messMan.deRegister(msgRec, messageType);

	}

	/**
	 * Removes a messagereceiver for tracenotes from the experiment's
	 * messagedistributor. Whenever a model produces a message of that type, it
	 * will not be sent to the given messagereceiver anymore. Note that if the
	 * messagereceiver is also registered for other types of messages, these
	 * will not be affected. Use method
	 * <code>removeReceiverAll(MessageReceiver msgRec)</code> to remove a
	 * messagereceiver from all types of messages.
	 * 
	 * @param trcRec
	 *            desmoj.report.MessageReceiver : The new messagereceiver to be
	 *            removed from the messagedistributor's list for the given
	 *            messagetype
	 */
	public void removeTraceReceiver(MessageReceiver msgRec) {

		if (msgRec == null) {
			sendWarning(
					"Can not remove receiver to experiment! Command ignored.",
					"Experiment '" + getName()
							+ "', Method 'void removeTraceReceiver"
							+ "(MessageReceiver msgRec)'",
					"The parameter 'msgRec' passed was a null reference.",
					"Make sure to give a valid MessageReciever reference before removing it "
							+ "from the experiment's messaging system.");
			return; // do nothing
		}

		messMan.deRegister(msgRec, tracenote);

	}

	/**
	 * Overrides inherited <code>NamedObjectImp.rename(String newName)</code>
	 * method to prevent the user from changing the experiment's name during an
	 * experiment. Renaming is not allowed with experiments, since it would not
	 * allow the user to identify the reports produced by an experiment. The
	 * method simply returns without changing the experiment's name, ignoring
	 * the given parameter.
	 * 
	 * @param newName
	 *            java.lang.String : The parameter given is not taken as the new
	 *            name, method simply returns
	 */
	public void rename(String newName) {

		// do nothing since renaming experiments is not allowed
		// would do too much confusion

	}

	/**
	 * Writes a report about the model connected top this experiment, its
	 * reportable components and all related submodels into the report output.
	 * Note that a report can only be produced, if a valid main model is already
	 * connected to the experiment.
	 */
	public void report() {

		// just pass on the call with main model as parameter
		report(client);

	}

	/**
	 * Writes a report about the given model which has to be connected to this
	 * experiment as main model or as a submodel. Note that this will report
	 * about a branch of the tree of submodels constructed. A report will only
	 * be produced, if the model given is connected to this experiment. All
	 * reportable components of this model and all related submodels will be
	 * sent to the report output configured at the experiment's
	 * messagedistributor. Note that a report can only be produced, if a valid
	 * main model is already connected to the experiment.
	 */
	public void report(Model m) {

		List<Reporter> reporters;
		// buffer for the reportmanager returned by client

		if (status < CONNECTED) {
			sendWarning(
					"Can not produce report! Command ignored.",
					"Experiment: " + getName()
							+ " Method: void report(Model m).",
					"The Experiment has not been connected to a model to report about yet.",
					"Connect a model to the experiment first using the model's method "
							+ "connectToExperiment(Experiment exp).");
			return; // no client there to be reported
		}

		if (status >= ABORTED) {
			// do nothing since experiment has already been aborted and all
			// output channels are already shut down
			return; // Experiment aborted
		}

		if (m == null) {
			sendWarning("Can not produce report! Command ignored.",
					"Experiment: " + getName()
							+ " Method: void report(Model m).",
					"The model parameter given is a null reference.",
					"Always make sure to use valid references.");
			return; // no model there to be reported
		}

		if (m.getExperiment() != this) {
			sendWarning(
					"Can not produce report! Command ignored.",
					"Experiment: " + getName()
							+ " Method: void report(Model m).",
					"The model parameter given is connected to a different experiment.",
					"Only experiments connected to theat model can produce reports "
							+ "about that model.");
			return; // model connected to other experiment
		}

		// get the client's reportmanager containing all reporters in sorted
		// order
		reporters = m.report();

		// get all out according to sorted order and send them to the report
		// output
		// registered at the experiment's messagemanager
		for (Reporter r : reporters) {

			messMan.receive(r);

		}
	}

	/**
	 * Creates and sends a debugnote to the messagedistributor. Be sure to have
	 * a correct location, since the object and method that the error becomes
	 * apparent is not necessary the location it was produced in. The
	 * information about the simulation time is extracted from the Experiment
	 * and must not be given as a parameter.
	 * 
	 * @param description
	 *            java.lang.String : The description of the error that occured
	 * @param location
	 *            java.lang.String : The class and method the error occured in
	 * @param reason
	 *            java.lang.String : The reason most probably responsible for
	 *            the error to occur
	 * @param prevention
	 *            java.lang.String : The measures a user should take to prevent
	 *            this warning to be issued again
	 */
	void sendDebugNote(String component, String description) {

		// comnpose the DebugNote and send it in one command
		sendMessage(new DebugNote(clientScheduler.getCurrentModel(),
				clientScheduler.getSimClock().getTime(), component, description));

	}

	/**
	 * Sends a message to the messagedistributor. Note that there are other
	 * shorthands for sending the standard DESMO-J messages.
	 * 
	 * @param m
	 *            Message : The Message to be transmitted
	 * @see ModelComponent#sendTraceNote
	 * @see ModelComponent#sendDebugNote
	 * @see ModelComponent#sendWarning
	 */
	void sendMessage(Message m) {

		if (m == null) {
			sendWarning("Can't send Message!", "Experiment :" + getName()
					+ " Method: SendMessage(Message m)",
					"The Message given as parameter is a null reference.",
					"Be sure to have a valid Message reference.");
			return; // no proper parameter
		}

		messMan.receive(m);

	}

	/**
	 * Creates and sends an error message to the messagedistributor to warn the
	 * modeller that some conditions required by the framework are not met. Be
	 * sure to have a correct location, since the object and method that the
	 * error becomes apparent is not necessary the location it was produced in.
	 * The information about the simulation time is extracted from the
	 * experiment and must not be given as a parameter.
	 * 
	 * @param description
	 *            java.lang.String : The description of the error that occured
	 * @param location
	 *            java.lang.String : The class and method the error occured in
	 * @param reason
	 *            java.lang.String : The reason most probably responsible for
	 *            the error to occur
	 * @param prevention
	 *            java.lang.String : The measures a user should take to prevent
	 *            this warning to be issued again
	 */
	void sendWarning(String description, String location, String reason,
			String prevention) {

		// comnpose the WarningMessage and send it in one command
		sendMessage(new ErrorMessage(clientScheduler.getCurrentModel(),
				description, location, reason, prevention, clientScheduler
						.getSimClock().getTime()));

	}

	/**
	 * Sets the TimeFormatter to be used for output of time Strings.
	 * 
	 * @param pattern
	 *            TimeFormatter : the formatter to be used for formatting time
	 *            Strings.
	 * 
	 */
	public void setTimeFormatter(TimeFormatter format) {
		TimeOperations.setTimeFormatter(format);
	}

	/**
	 * Determines if the event list processes concurrent events in random order
	 * or not. Default is not, i.e. when a new experiment is constructed, the
	 * event list is set to "linear" order. Note: If you want the event list to
	 * randomize concurrent events you should call this method BEFORE scheduling
	 * any events. Otherwise any connections between events established via
	 * scheduleBefore() or scheduleAfter() are lost. So it's a good idea to call
	 * this method only once and right after constructing the experiment.
	 * 
	 * @param randomizing
	 *            boolean :<code>true</code> forces random order,
	 *            <code>false</code> forces "linear" order
	 * @author Ruth Meyer
	 */
	public void randomizeConcurrentEvents(boolean randomizing) {
		clientScheduler.setRandomizingConcurrentEvents(randomizing);
	}

	/**
	 * Sets the speed rate for an execution that is proportional to wall-clock
	 * time (real time). Set the speed rate to a value bigger than zero for a
	 * simulation that will progress proportional to wall-clock time. The
	 * following equation applies for speed rates >0 : rate*simulation time =
	 * wallclock-time. If the speed rate is 0 or less the simulation will be
	 * executed as fast as possible. Default is 0 (as-fast-as-possible).
	 * 
	 * @param rate
	 *            double : The execution speed rate
	 */
	public void setExecutionSpeedRate(double rate) {
		clientScheduler.setExecutionSpeedRate(rate);
	}

	/**
	 * Sets the seed of the SeedGenerator to the given value. If the seed is not
	 * set here, its default is 979, unless specified different in the
	 * ExperimentOptions.
	 * 
	 * @param seed
	 *            long : The seed for the SeedGenerator
	 */
	public void setSeedGenerator(long seed) {

		distMan.setSeed(seed);

	}

	/**
	 * Sets the underlying pseudo random number generator to be used by all
	 * distributions created from now on. The default generator is
	 * LinearCongruentialRandomGenerator; any other generator to be used must
	 * implement the interface UniformRandomGenerator.
	 * 
	 * @see desmoj.desmoj.core.dist.LinearCongruentialRandomGenerator
	 * @see desmoj.desmoj.core.dist.UniformRandomGenerator
	 * 
	 * @param randomNumberGenerator
	 *            Class : The random number generator class to be used
	 */
	public void setRandomNumberGenerator(
			Class<? extends desmoj.core.dist.UniformRandomGenerator> randomNumberGenerator) {

		boolean classValid = false;
		// // Verify that a class implementing interface
		// desmoj.desmoj.core.dist.UniformRandomGenerator was passed
		// for (int i = 0; i < randomNumberGenerator.getInterfaces().length;
		// i++) {
		// if
		// (randomNumberGenerator.getInterfaces()[i].equals(desmoj.core.dist.UniformRandomGenerator.class))
		// {
		// classValid = true;
		// break;
		// }
		// }

		// Verify the class provided is not abstract
		if ((randomNumberGenerator.getModifiers() & java.lang.reflect.Modifier.ABSTRACT) > 0
				|| (randomNumberGenerator.getModifiers() & java.lang.reflect.Modifier.INTERFACE) > 0)
			classValid = false;

		// Update the random number generator...
		if (classValid) {

			this.distMan.setRandomNumberGenerator(randomNumberGenerator);

			// ...or otherwise return an error
		} else {

			this
					.sendWarning(
							"Invalid random number generator given! Method call ignored!",
							"Experiment '"
									+ getName()
									+ "', Method 'setRandomNumberGenerator(Class randomNumberGenerator)'",
							"The class provided '"
									+ randomNumberGenerator.getSimpleName()
									+ "' is abstract or does not implement the interface"
									+ " desmoj.desmoj.core.dist.UniformRandomGenerator.",
							"Make sure to use a non-abstract class that implements the interface"
									+ " desmoj.desmoj.core.dist.UniformRandomGenerator.");
		}
	}

	/**
	 * Sets the new value for showing the progress bar for this experiment or
	 * not.
	 * 
	 * @param newShowProgressBar
	 *            boolean : set it to <code>true</code> if a progress bar should
	 *            be displayed; for not showing the progress bar of this
	 *            experiment set it to <code>false</code>.
	 */
	public void setShowProgressBar(boolean newShowProgressBar) {

		this.showProgressBar = newShowProgressBar;
	}

	/**
	 * Sets the experiment's status to the given integer value. The value must
	 * be in the legal range of [-1,5], otherwise a warning is issued.
	 * 
	 * @param newStatus
	 *            int : The integer value of the experiments' new status
	 */
	void setStatus(int newStatus) {

		if ((newStatus < -1) || (newStatus > 5)) {
			sendWarning(
					"Can not start experiment! Command ignored.",
					"Experiment '" + getName() + "', Method 'start'",
					"No main model's connectToExperiment(Experiment e) method was called.",
					"Make sure to connect a valid main model first before starting "
							+ "this experiment.");
			return;
		} else
			status = newStatus;

	}

	/**
	 * Starts the simulation with default start time 0. This method can only be
	 * used once on an experiment. it initializes the connected model and starts
	 * the simulation. Note that in order to stop the simulation, the
	 * <code>stop(TimeInstant stopTime)</code> method has to be called first!
	 */
	public void start() {

		// this allows us to use start() in loops for multiple experiment runs
		// in other words, this is a shortcut for the lazy programmer
		if (status == STOPPED)
			proceed();

		// here's what start was supposed to be at first
		// a shortcut for startig an Experiment at TimeInstant(0)
		else {
			// now prepare connected model to start simulation
			start(new TimeInstant(0));
		}

	}

	/**
	 * Starts the experiment with the given simulation time as starting time.
	 * The experiment will not start unless a valid model has been connected to
	 * it before. Note that in order to stop the simulation at some point of
	 * time, the <code>stop</code> method has to be called first.
	 * <code>StopCondition</code> s can be given alternatively.
	 * 
	 * @param initTime
	 *            TimeInstant : The starting time instant
	 */
	public void start(TimeInstant initTime) {

		if (status < CONNECTED) {
			sendWarning(
					"Can not start experiment! Command ignored.",
					"Experiment: " + getName()
							+ " Method: void start(SimTime initTime)",
					"The Experiment has not been connected to a model to report about yet.",
					"Connect a model to the experiment first using the model's method "
							+ "connectToExperiment(Experiment exp).");
			return;
		}
		if (status > CONNECTED) {
			sendWarning(
					"Can not start experiment! Command ignored.",
					"Experiment: " + getName()
							+ " Method: void start(SimTime initTime)",
					"The Experiment has already been started before.",
					"An experiment can only be started once. If it has been stopped, "
							+ "it can be issued to continue using method proceed()");
			return;
		}

		// check initial TimeInstant parameter
		if (initTime != null) {
			clientScheduler.getSimClock().setInitTime(initTime);
			if(!TimeInstant.isEqual(initTime,new TimeInstant(0))){
			client.reset();
			}
		} else {
			clientScheduler.getSimClock().setTime(new TimeInstant(0));
			sendWarning(
					"Invalid start time parameter given! Start time set to "
							+ clientScheduler.presentTime() + ".",
					"Experiment: '" + getName()
							+ "', Method: void start(SimTime initTime)",
					"A null calue or a not initialized TimeInstant reference has been passed.",
					"Make sure to have a valid TimeInstnat object, otherwise use method "
							+ "start() without TimeInstant parameter.");
		}

		// client.init(); already done in connectToExperiment
		client.doInitialSchedules();
		client.doSubmodelSchedules();
		TimeOperations.setStartTime(initTime);
		// now everything is set up, go on and process events
		status = STARTED;
		this.realTimeStartTime = System.nanoTime();

		proceed();

	}
	
    /**
     * @deprecated Use start(TimeInstant initTime). 
     * Starts the experiment with the given simulation time as starting time.
     * The experiment will not start unless a valid model has been connected to
     * it before. Note that in order to stop the simulation at some point of
     * time, the <code>stop</code> method has to be called first.
     * <code>StopCondition</code> s can be given alternatively.
     * 
     * @param SimTime
     *            TimeInstant : The starting time instant
     */
    public void start(SimTime initTime) {
        start(SimTime.toTimeInstant(initTime));
    }

	/**
	 * Specifies a condition to stop the simulation. Note that this methode can
	 * be called muliple times, defining alternative conditions to terminate the 
	 * simulation. Once at least one of the conditions passed using this method 
	 * returns true, the experiment will stop. 
	 * Beware that the simulation will run endlessly if none of the conditions 
	 * are met; thus it is recommended to additionally always use a time limit 
	 * if none of the conditions in question can be proven to be met during the 
	 * run of the simulation!
	 * 
	 * @param stopCond
	 *            Condition : A condition to stop the simulation when
	 *            returning true.
	 */
	public void stop(Condition stopCond) {

		if (stopCond == null) {
			sendWarning("Can not set stop-condition! Command ignored.",
					"Experiment '" + getName()
							+ "', Method 'stop(Condition stopCond)'",
					"The parameter passed was either null or a not initialized "
							+ "Condition reference.",
					"Make sure to provide a valid stop Condition for "
							+ "this experiment.");
		} else {
			this.stopConditions.add(stopCond);
		}

	}

	/**
	 * Stops the simulation at the given point of simulation time. If no valid
	 * simulation time is given, the default is 0 which would not
	 * let the simulation run past that time. Repeatedly calling this method
	 * will override stop times specified before. 
	 * 
	 * @param stopTime
	 *            desmoj.TimeInstant : The point of simulation time to stop the
	 *            simulation
	 */
	public void stop(TimeInstant stopTime) {
		if (stopTime == null) {
			sendWarning(
					"Can not set stop-time! The stop-time will be set to 0",
					"Experiment '" + getName()
							+ "', Method: 'stop(TimeInstant stopTime)'",
					"The parameter passed was either null or a not initialized "
							+ "TimeInstance reference.",
					"Pass an initialized TimeInstant object as stop time.");

			ExternalEvent stopper = new ExternalEventStop(client,
					"Simulation stopped", true);
			stopper.schedule(new TimeInstant(0));

		} else {

			this.stopTime = stopTime;
			if (this.stopTimeEvent != null) this.stopTimeEvent.cancel();

			this.stopTimeEvent = new ExternalEventStop(client, "Simulation stopped", true);
			stopTimeEvent.schedule(stopTime);
		}
	}

	/**
	 * @deprecated Stops the simulation at the given point of simulation time.
	 *             If no valid simulation time is given, the default is 0.0
	 *             which would not let the simulation run past that time.
	 * 
	 * @param stopTime
	 *            desmoj.SimTime : The point of simulation time to stop the
	 *            simulation
	 */
	@Deprecated
	public void stop(SimTime stopTime) {
		stop(SimTime.toTimeInstant(stopTime));
	}

	/**
	 * Stops the simulation at the current simulation time (immediately). A
	 * stopped Simulation run can be resumed by calling proceed().
	 */	
	public void stop() {
		setStatus(STOPPED);
		clientScheduler.signalStop();
	}

	/**
	 * Returns a boolean indicating whether trace notes are forwarded to the
	 * trace ouput or not. Trace ouput can be switched on and off using the
	 * methods <code>traceOn(TimeInstant startTime)</code> and
	 * <code>traceOff(TimeInstant stopTime)</code>
	 * 
	 * @return boolean : Is <code>true</code>
	 */
	public boolean traceIsOn() {

		return messMan.isOn(tracenote);

	}

	/**
	 * Switches the trace output off at the given point of simulation time.
	 * 
	 * @param duration
	 *            TimeInstant : The point in simulation time to switch trace off
	 */
	public void traceOff(TimeInstant stopTime) {

		// check initial TimeInstant parameter
		if (stopTime == null) {
			sendWarning(
					"Invalid start time parameter for trace output given! "
							+ "Trace output is set to start immediately.",
					"Experiment '" + getName()
							+ "', Method 'traceOn(TimeInstant startTime)'",
					"A null value or a not initialized TimeInstant reference has been passed.",
					"Make sure to have a valid TimeInstant object, otherwise use method "
							+ "start() without TimeInstant parameter.");
			stopTime = clientScheduler.presentTime();
		}

		// check if parameter is in future
		if (TimeInstant.isAfter(clientScheduler.presentTime(), stopTime)) {
			sendWarning("Invalid start time parameter for trace output given! "
					+ "Trace output is set to start immediately.",
					"Experiment '" + getName()
							+ "', Method 'traceOn(TimeInstant stopTime)'",
					"The stopTime given is in the past.",
					"Make sure to give a TimeInstant parameter larger than the current time.");
			stopTime = clientScheduler.presentTime();
		}

		ExternalEvent traceOff = new ExternalEventTraceOff(client, true);
		traceOff.schedule(stopTime);
	}
	
    /**
     * @deprecated Use traceOff(TimeInstant startTime). Switches the trace output off at the given point of simulation time.
     * 
     * @param stopTime
     *            SimTime : The point in simulation time to switch trace off
     */
    public void traceOff(SimTime stopTime) {
        this.traceOff(SimTime.toTimeInstant(stopTime));        
    }

	/**
	 * Switches the trace output on at the given point of simulation time.
	 * 
	 * @param startTime
	 *            TimeInstant : The point in simulation time to switch trace on
	 */
	public void traceOn(TimeInstant startTime) {

		// check initial TimeInstant parameter
		if (startTime == null) {
			sendWarning(
					"Invalid start time parameter for trace output given! "
							+ "Trace output is set to start immediately.",
					"Experiment '" + getName()
							+ "', Method 'traceOn(TimeInstant startTime)'",
					"A null value or a not initialized TimeInstant reference has been passed.",
					"Make sure to have a valid TimeInstant object, otherwise use method "
							+ "start() without TimeInstant parameter.");
			startTime = clientScheduler.presentTime();
		}

		// check if parameter is in future
		if (TimeInstant.isAfter(clientScheduler.presentTime(), startTime)) {
			sendWarning("Invalid start time parameter for trace output given! "
					+ "Trace output is set to start immediately.",
					"Experiment '" + getName()
							+ "', Method 'traceOn(TimeInstant startTime)'",
					"The startTime given is in the past.",
					"Make sure to give a TimeInstant parameter larger than the current time.");
			startTime = clientScheduler.presentTime();
		}

		ExternalEvent traceOn = new ExternalEventTraceOn(client, true);
		traceOn.schedule(startTime);

	}
	
	/**
     * @deprecated Use traceOn(TimeInstant startTime). Switches the trace output on at the given point of simulation time.
     * 
     * @param startTime
     *            SimTime : The point in simulation time to switch trace on
     */
    public void traceOn(SimTime startTime) {
        this.traceOn(SimTime.toTimeInstant(startTime));        
    }

	/**
	 * Switches the trace output on for the given period of simulation time. If
	 * the second parameter (off) is "sooner" then the first parameter (on),
	 * they will be swapped automatically. Same parameters will result in no
	 * trace output at all.
	 * 
	 * @param startTime
	 *            TimeInstant : The point in simulation time to switch trace on
	 * @param stopTime
	 *            TimeInstant : The point in simulation time to switch trace off
	 */
	public void tracePeriod(TimeInstant startTime, TimeInstant stopTime) {
		if (startTime == null) {
			sendWarning(
					"Invalid start time parameter for trace output given! Command ignored",
					"Experiment '" + getName()
							+ "', Method 'tracePeriod(TimeInstant startTime, "
							+ "TimeInstant stopTime)'",
					"A null value or a not initialized TimeInstant reference has been passed.",
					"Make sure to have a valid TimeInstant object.");
			return;
		}

		// check initial TimeInstant parameter
		if (stopTime == null) {
			sendWarning(
					"Invalid stop time parameter for trace output given! Command ignored.",
					"Experiment '" + getName()
							+ "', Method 'tracePeriod(TimeInstant startTime, "
							+ "TimeInstant stopTime)'",
					"A null value or a not initialized TimeInstant reference has been passed.",
					"Make sure to have a valid TimeInstant object.");
			return;
		}

		// check for correct order in parameters
		if (TimeInstant.isAfter(startTime, stopTime)) {

			// swap parameters
			TimeInstant buffer = stopTime;
			stopTime = startTime;
			startTime = buffer;

		}

		// check if stop parameter is in future
		if (TimeInstant.isAfter(clientScheduler.presentTime(), stopTime)) {
			sendWarning(
					"Invalid stop time parameter for trace output given! Command ignored.",
					"Experiment '" + getName()
							+ "', Method 'tracePeriod(TimeInstant startTime, "
							+ "TimeInstant stopTime)'",
					"The stopTime given is in the past.",
					"Make sure to give a TimeInstant parameter larger than the current time.");
			return;
		}

		// check if start parameter is in past
		if (TimeInstant.isAfter(clientScheduler.presentTime(), startTime)) {
			sendWarning("Invalid start time parameter for trace output given! "
					+ "Trace output has been set to start immediately.",
					"Experiment '" + getName()
							+ "', Method 'tracePeriod(TimeInstant startTime, "
							+ "TimeInstant startTime)'",
					"The startTime given is in the past.",
					"Make sure to give a TimeInstant parameter larger than the current time.");
			startTime = clientScheduler.presentTime();
		}

		// set trace to switch on
		traceOn(startTime);

		// set trace to switch off
		traceOff(stopTime);
	}

	/**
	 * @deprecated Replaced by tracePeriod(TimeInstant startTime, TimeInstant
	 *             stopTime). Switches the trace output on for the given period
	 *             of simulation time. If the second parameter (off) is "sooner"
	 *             then the first parameter (on), they will be swapped
	 *             automatically. Same parameters will result in no trace output
	 *             at all.
	 * 
	 * @param duration
	 *            SimTime : The point in simulation time to switch trace on
	 * @param duration
	 *            SimTime : The point in simulation time to switch trace off
	 */
	@Deprecated
	public void tracePeriod(SimTime startTime, SimTime stopTime) {
		tracePeriod(SimTime.toTimeInstant(startTime), SimTime
				.toTimeInstant(stopTime));
	}

	/**
	 * Triggers the reporters of the given model or submodel to write their
	 * report data into the report output registered at the experiment's
	 * messagemanager. The string given will be added as a suffix to the report
	 * filename to help identify teh report when more than one report is
	 * produced by one Experiment at differnet points of simulation time.
	 * 
	 * @param m
	 *            desmoj.Model
	 * @param suffix
	 *            java.lang.String : Suffix for report filename if multiple
	 *            reports are drawn
	 */
	public void writeReport(Model m, String suffix) {

		if (suffix == null)
			suffix = "";

		// buffer used for storing the filename in
		String nameBuffer = null;

		// now flush and close all files and reopen with new names
		for (FileOutput f : registryFileOutput) {

			// remember the name the file had
			nameBuffer = f.getFileName();

			// flush buffer and close file
			f.close();

			// open new file with old name stripping off old suffix and
			// adding new suffix
			nameBuffer = nameBuffer.substring(0, nameBuffer.lastIndexOf("."));
			f.open(nameBuffer.substring(0, (nameBuffer.length() - lastSuffix))
					+ suffix + "html");
		}
		lastSuffix = suffix.length(); // remember last suffix length
		report(m);
	}

	/**
	 * Triggers the reporters to write their data into the report output
	 * registered at the experiment's messagemanager. The string given will be
	 * added as a suffix to the report filename to help identification when more
	 * than one report is produced by one Experiment at differnet points of
	 * simulation time.
	 * 
	 * @param suffix
	 *            java.lang.String : Suffix for report filename if multiple
	 *            reports are drawn
	 */
	public void writeReport(String suffix) {

		if (suffix == null)
			suffix = "";

		// write report data about main model
		report(client);

		// buffer used for storing the filename in
		String nameBuffer = null;

		// now flush and close all files and reopen with new names
		for (FileOutput f : registryFileOutput) {

			// remember the name the file had
			nameBuffer = f.getFileName();

			// flush buffer and close file
			f.close();

			// open new file with old name stripping off old suffix and
			// adding new suffix
			// strip the _debug / _error / _trace / _report part
			nameBuffer = nameBuffer.substring(0, nameBuffer.lastIndexOf("_"));
			// strip the previous suffix
			nameBuffer = nameBuffer.substring(0, nameBuffer.length()
					- lastSuffix);
			// add new suffix
			nameBuffer = nameBuffer + suffix;
			// now open file with new name
			f.open(nameBuffer);
		}
		lastSuffix = suffix.length(); // remember last suffix length
	}

	/**
	 * Returns the current DESMO-J version
	 * 
	 * @return The string "2.2.0".
	 */
	public static String getDesmoJVersion() {
		return "2.2.0";
	}

	/**
	 * Returns the DESMO-J license
	 * 
	 * @param html
	 *            boolean: Include link (HTML, true) or not (plain text, false)
	 * 
	 * @return The string "Apache License, Version 2.0", embedded in a HTML link
	 *         tag (currently http://www.apache.org/licenses/LICENSE-2.0) if
	 *         <code>html</code> is set true.
	 */
	public static String getDesmoJLicense(boolean html) {
		return html ? "<A HREF=http://www.apache.org/licenses/LICENSE-2.0>Apache License, Version 2.0</A>"
				: "Apache License, Version 2.0";
	}
}