package desmoj.core.report;

import desmoj.core.simulator.Experiment;

/**
 * Extends the StdFileOut writer by the ability to create HTML pages displaying
 * the given text in table format. Using the methods
 * <code>void openTable(String name)</code> and <code>void closeTable()</code>
 * multiple distinct HTML tables with individual headings givne as parameter can
 * be written into one file.
 * 
 * @version DESMO-J, Ver. 2.3.5 copyright (c) 2013
 * @author Tim Lechler
 * @deprecated Replaced by the TableFormatter interface and the classes
 *             ASCIITableFormatter and HTMLTableFormatter for more flexible
 *             simulation output
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
public class HTMLFileOutput extends FileOutput {

	/**
	 * Status for a single line to keep track of when to open or close a new
	 * table row.
	 */
	private boolean _rowOpen;

	/**
	 * Status for the table printed. Needed to keep track of when to open or
	 * close the table.
	 */
	private boolean _tableOpen;

	/**
	 * Used to format the output of simulation time to the given number of
	 * floating point digits.
	 */
	private int _timeFloats;

	/**
	 * Creates a TraceOut to write into a HTML page. The number of floating
	 * point digits for writing simulation time values must be given. Only
	 * positive values are allowed. Otherwise the default (0) is used. The
	 * actual file is opened using the <code>open(String name)</code> method.
	 * 
	 * @param timePrecision
	 *            int : The number of floating point digits for displaying
	 *            simulation time values
	 */
	public HTMLFileOutput(int timePrecision) {

		super();
		_rowOpen = false;
		_tableOpen = false;

		if (timePrecision < 0)
			_timeFloats = 0;
		else
			_timeFloats = timePrecision;

	}

	/**
	 * Close the HTML file by writing the footing tags, flushing the buffer and
	 * closing the file.
	 */
	public void close() {

		if (_rowOpen)
			closeRow();
		if (_tableOpen)
			closeTable();
		writeln("<FONT SIZE=-2>created using <A HREF=http://www.desmoj.de>"
				+ "DESMO-J</A> Version " + Experiment.getDesmoJVersion() + " at " + new java.util.Date()
				+ " - DESMO-J is licensed under " + Experiment.getDesmoJLicense(true)
				+ "</FONT>");
		write("</BODY></HTML>");
		super.close();

	}

	/**
	 * Writes the tag to close a row in a table to the file.
	 */
	public void closeRow() {

		if ((_rowOpen) && (_tableOpen)) {
			writeln("</TR>");
			_rowOpen = false;
		}

	}

	/**
	 * Inserts the tags needed to close a HTML 3.2 table into the file. Also
	 * inserts a paragraph tag to add some space below the table.
	 */
	public void closeTable() {

		if (!_tableOpen)
			return; // do nothing if table not open

		if (_rowOpen) {
			closeRow(); // correct an open row if necessary
			_rowOpen = false;
		}

		writeln("</TABLE><P>"); // The table end tag
		writeln("<FONT SIZE=-1><A HREF=#top>top</A></FONT><P>");

		_tableOpen = false;

	}

	/**
	 * Inserts the tags needed to close a HTML 3.2 table into the file. Also
	 * inserts a paragraph tag to add some space below the table. But omits the
	 * top tag as used in method <code>closeTable()</code>. This is needed if
	 * one reportable is generating a report that consists of more than one
	 * table (see <code>StockReporter</code> or <code>HistogramReporter</code>)
	 */
	public void closeTableNoTopTag() {

		if (!_tableOpen)
			return; // do nothing if table not open, just return

		if (_rowOpen) {
			closeRow(); // correct an open row if necessary
			_rowOpen = false;
		}

		writeln("</TABLE><P>"); // The table end tag
		// writeln("<FONT SIZE=-1><A HREF=#top>top</A></FONT><P>");

		_tableOpen = false;

	}

	/**
	 * Opens a new file with the given fileName for writing a HTML table to. If
	 * no String is given, the default filename "unnamed_DESMOJ_file" is used.
	 * 
	 * @param name
	 *            java.lang.String : The name of the file to be created
	 */
	public void open(String name) {

		super.open(name);

		StringBuffer sb = new StringBuffer();
		sb.append("<HTML><HEAD>" + FileOutput.getEndOfLine());
		sb.append("<META HTTP-EQUIV=\"Content-Type\" CONTENT=");
		sb.append("\"text/html; charset=iso-8859-1\">" + FileOutput.getEndOfLine());
		sb.append("<META NAME=\"GENERATOR\" CONTENT=\"DESMO-J " + Experiment.getDesmoJVersion() + "\">" + FileOutput.getEndOfLine());
		sb.append("<TITLE>" + name + "</TITLE></HEAD>" + FileOutput.getEndOfLine());
		sb
				.append("<BODY TEXT=\"#000000\" BGCOLOR=\"#FFFFFF\" LINK=\"#0000EE\"");
		sb.append(" VLINK=\"#551A8B\" ALINK=\"#FF0000\">" + FileOutput.getEndOfLine());
		sb.append("<A NAME=\"top\"></A><br>" + FileOutput.getEndOfLine());

		write(sb.toString());

	}

	/**
	 * Writes the HTML 3.2 tags to open a new row in a table to the file. A new
	 * row can only be started, if the table has alerady been opened and the
	 * previous row has been closed.
	 */
	public void openRow() {

		if (_tableOpen) {

			if (!_rowOpen) {
				write("<TR VALIGN=TOP>");
				_rowOpen = true; // keep a note to shut the row on closes
			}

		}

	}

	/**
	 * Inserts the tags needed to build a HTML 3.2 table heading into the file.
	 * The table's heading text is given with the parameter.
	 * 
	 * @param s
	 *            String : The heading for the table
	 */
	public void openTable(String s) {

		if (_tableOpen)
			return; // table already opened

		StringBuffer sb = new StringBuffer();

		sb.append("<DIV align=center><H3>" + s + "</H3></DIV>" + FileOutput.getEndOfLine());
		sb.append("<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=3 ");
		sb.append("WIDTH=\"100%\" >" + FileOutput.getEndOfLine());

		write(sb.toString());
		_tableOpen = true;
		_rowOpen = false;

	}

	/**
	 * Returns the status of the current table row that is written to.
	 * 
	 * @return boolean : Is <code>true</code> if the method
	 *         <code>openRow()</code> has been called last, <code>false</code>
	 *         if the method <code>closeRow()</code> has been called last
	 */
	public boolean rowIsOpen() {

		return _rowOpen;

	}

	/**
	 * Returns the status of the current table that is written to.
	 * 
	 * @return boolean : Is <code>true</code> if the method
	 *         <code>openTable()</code> has been called last,
	 *         <code>false</code> if the method <code>closeTable()</code>
	 *         has been called last
	 */
	public boolean tableIsOpen() {

		return _tableOpen;

	}

	/**
	 * Returns the number of floating point digits to be displayed for
	 * simulation time values.
	 * 
	 * @return int : The number of floating point digits to be displayed for
	 *         simulation time values
	 */
	protected int timePrecision() {

		return _timeFloats;

	}

	/**
	 * Creates a new table cell and writes the given String into that cell. Note
	 * that there this is raw HTML code so there must not be any special
	 * language specific characters that might confuse any browser. A new cell
	 * can not be written, if neither a table nor a row have been opened yet.
	 * The method will simply return without action in that case.
	 * 
	 * @param s
	 *            java.lang.String : The text to be printed into a cell
	 */
	public void writeCell(String s) {

		if (s == null)
			return;

		if ((_rowOpen) && (_tableOpen))
			write("<TD>" + s + "</TD>");

	}

	/**
	 * Creates a newcentered heading row to print a title in. Note that there
	 * this is raw HTML code so the string given must not contain any special
	 * language specific characters that might confuse any browser. been opened
	 * yet. The method will simply return without action in that case. The
	 * number for the HTML heading style must be inside the range [1,6]. If not,
	 * it will be trimmed to the nearest legal heading style number.
	 * 
	 * @param style
	 *            int : The heading style format number for the text to be
	 *            printed in
	 * @param s
	 *            java.lang.String : The text to be printed as heading
	 */
	public void writeHeading(int style, String s) {

		// check parameter
		if (s == null)
			return;

		// check style number
		if (style > 6)
			style = 6;
		if (style < 1)
			style = 1;

		// check if no table is open, otherwise I can't write centered heading
		if (_tableOpen)
			return;

		// now write heading
		write("<P><H" + style + "><DIV align=center>" + s + "</DIV></H" + style
				+ "><P>");

	}

	/**
	 * Creates a new table cell and writes the given String into that cell as
	 * heading cells in bold letters and with centered text. Note that there
	 * this is raw HTML code so there must not be any special language specific
	 * characters that might confuse any browser. A new cell can not be written,
	 * if netiher a tbale nor a row have been opened yet. The method will simply
	 * return without action in that case.
	 * 
	 * @param s
	 *            java.lang.String : The text to be printed into a cell
	 */
	public void writeHeadingCell(String s) {

		if (s == null)
			return;

		if ((_rowOpen) && (_tableOpen))
			write("<TD><B><DIV align=left>" + s + "</DIV></B></TD>");

	}

	/**
	 * Writes the HTML tag for inserting a horizontal ruler into the file. Note
	 * that horizontal rulers are not written into table cells, thus this method
	 * simply returns, if a table is still open.
	 */
	public void writeHorizontalRuler() {

		if (!_tableOpen)
			write("<HR>");

	}

	/**
	 * Returns a String representation of a simulation time value with the given
	 * number of floating point digits after the decimal point.
	 * 
	 * @return java.lang.String : The string representing a simulation time
	 *         value trimmed to the number of floating points digits specified
	 *         at this class' constructor
	 * @param t
	 *            java.lang.String : The trimmed string representing a
	 *            simulation time value
	 */
	public String writeTime(String t) {
	    
	    if (t == null)
			return "None";

		if (t.lastIndexOf(".") == -1)
			return t; // no decimal point -> just print it

		int decPoint = t.lastIndexOf(".");

		if (t.length() - decPoint <= _timeFloats + 1)
			return t; // less floats than specified

        if (t.lastIndexOf("E") == -1)
            return t.substring(0, decPoint + _timeFloats + 1);  // no scientific notation
        else
            return t.substring(0, decPoint + _timeFloats + 1) + t.substring(t.lastIndexOf("E")); // scientific notation
        
	}
}