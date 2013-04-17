/*
  File: Graph.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class facilitates curve plotting. 
 * <p>
 * A </tt>Graph</tt>-object represents a graph.
 * <p> 
 * An entry (<tt>x</tt>,</tt>y</tt>) is added to the graph
 * by calling <tt>add(x,y)</tt>. 
 * <p>
 * The graph is shown in a frame by calling its <tt>show</tt>-method.
 */
public class Graph {
    /**
     * Constructs a <tt>Graph</tt>-object without a title.
     */
    public Graph() {}
    
    /**
     * Constructs a <tt>Graph</tt>-object with a title.
     */
    public Graph(String title) {
        this.title = title;
    }    
    
    /**
     * Adds the entry (<tt>x</tt>, <tt>y</tt>) to the graph.
     *
     * @param <tt>x</tt> the x-value.
     * @param <tt>y</tt> the y-value.
     */
    public void add(double x, double y) {
        new Entry(x, y).into(Entries);
    }
    
    /**
     * Adds the entry (<tt>time()</tt>, <tt>y</tt>) to the graph.
     *
     * @param <tt>y</tt> the y-value.
     */
    public void add(double y) {
        add(Process.time(), y);
    } 
    
    /**
     * Adds the entry (<tt>time()</tt>, <tt>v.state</tt>) to the graph.
     *
     * @param <tt>v</tt> the <tt>Variable</tt>-object.
     */
    public void add(Variable v) {
        add(Process.time(), v.state);
    }
        
    /**
     * Adds the entry (<tt>v1.state</tt>, <tt>v2.state</tt>) to the graph.
     *    
     * @param <tt>v1</tt> the first <tt>Variable</tt>-object.
     * @param <tt>v2</tt> the second <tt>Variable</tt>-object.
     */
    public void add(Variable v1, Variable v2) {
        add(v1.state, v2.state);
    } 

    protected static int graphsVisible;
    
    /**
     * Shows the graph in a frame.
     *
     * @param <tt>width</tt> the width of the frame.
     * @param <tt>height</tt> the height of the frame.
     */
    public void show(int width, int height) {
        final JFrame frame = new JFrame(title);
        frame.setSize(width + leftMargin + rightMargin, 
                      height + topMargin + bottomMargin);
        frame.setLocation(locationX, locationY);
        locationX += 20; locationY += 20;
        frame.getContentPane().add(new Canvas());
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (--graphsVisible == 0)
                    System.exit(0);
                else
                    frame.setVisible(false);
            }
        });
        frame.setVisible(true);
        graphsVisible++;
    }
    
    /**
     * Shows the graph in a frame of width 400 and height 400.
     */
    public void show() {
        show(400, 400);
    }

    /**
     * Sets the title of the graph.
     *
     * @param <tt>title</tt> the title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets a label on the x-axis.
     *
     * @param <tt>label</tt> the label.
     */
    public void setXLabel(String label) {
        xLabel = label;
    }

    /**
     * Sets a label on the y-axis.
     *
     * @param <tt>label</tt> the label.
     */
    public void setYLabel(String label) {
        yLabel = label;
    }
    
     public void setXMin(double xMin) {
        this.xMin = xMin;
        xMinSet = true;
    }

    /**
     * Sets a maximum on the x-axis.
     *
     * @param <tt>xMax</tt> the minimum.
     */
    public void setXMax(double xMax) {
        this.xMax = xMax;
        xMaxSet = true;
    }

    /**
     * Sets a minimum on the y-axis.
     *
     * @param <tt>yMin</tt> the minimum.
     */
    public void setYMin(double yMin) {
        this.yMin = yMin;
        yMinSet = true;
    }
    
    /**
     * Sets a maximum on the y-axis.
     *
     * @param <tt>xMax</tt> the minimum.
     */
    public void setYMax(double yMax) {
        this.yMax = yMax;
        yMaxSet = true;
    }
    
    /**
     * Sets the location of the frame.
     *
     * @param <tt>x</tt> the x-coordinate on the screen.
     * @param <tt>y</tt> the y-coordinate on the screen.
     */
    public void setLocation(int x, int y) {
        locationX = x;
        locationY = y;
    }
    
    private Head Entries = new Head();            // list of entries
    private String title = "";                    // the title of the graph
    private String xLabel = "";                   // the label on the x-axis
    private String yLabel = "";                   // the label on the y-axis    
    private double xMin, xMax, yMin, yMax;
    private boolean xMinSet, xMaxSet, yMinSet, yMaxSet;
    
    private static final int leftMargin = 80, rightMargin = 80;
    private static final int topMargin = 40, bottomMargin = 40; 
    private static int locationX = 20, locationY = 20;  // location on the screen
    
    /**
     * Inner class representing the table entries.
     */
    private static class Entry extends Link {
        Entry(double x, double y) {
            this.x = x; this.y = y;
        }        
        double x, y;
    }
    
    /**
     * Inner class representing the frame.
     */
    private class Canvas extends JComponent {
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            g.setColor(Color.white);
            g.fillRect(0, 0, d.width, d.height);
            if (Entries.empty())
                return;
            Entry e = (Entry) Entries.first();
            if (!xMinSet)
                 xMin = e.x;
            if (!xMaxSet)
                 xMax = e.x;
            if (!yMinSet)
                 yMin = e.y;
            if (!yMaxSet)
                 yMax = e.y;
            for (e = (Entry) Entries.first(); e != null; e = (Entry) e.suc()) {
                if (!xMinSet && e. x < xMin) 
                    xMin = e.x;
                else if (!xMaxSet && e.x > xMax) 
                    xMax = e.x;
                if (!yMinSet && e.y < yMin) 
                    yMin = e.y;
                else if (!yMaxSet && e.y > yMax) 
                    yMax = e.y;
            }
            int w = d.width - leftMargin - rightMargin;
            int h = d.height - topMargin - bottomMargin;
            double xRatio = xMax > xMin ? w / (xMax - xMin) : 1;
            double yRatio = yMax > yMin ? h / (yMax - yMin) : 1;
            g.setColor(Color.black);
            g.drawLine(leftMargin , topMargin + h, leftMargin + w, topMargin + h);    
            for (int i = 1; i <= 10; i++) 
                g.drawLine(leftMargin + i * w / 10, topMargin + h - 2,
                           leftMargin + i * w / 10, topMargin + h + 2);
            g.setFont(new Font("serif", Font.PLAIN, 12));
            FontMetrics fm = g.getFontMetrics();
            String s = formatDouble(xMin);
            g.drawString(s, leftMargin - fm.stringWidth(s) / 2, 
                            topMargin + h + fm.getHeight() + 4);
            s = formatDouble(xMax);
            g.drawString(s, leftMargin + w - fm.stringWidth(s) / 2, 
                            topMargin + h + fm.getHeight() + 4); 
            s = xLabel;
            g.drawString(s, leftMargin + w - fm.stringWidth(s) / 2,
                            topMargin + h + 2 * fm.getHeight() + 4 + 2);  
            g.drawLine(leftMargin, topMargin + h, leftMargin, topMargin);
            for (int i = 1; i <= 10; i++) 
                g.drawLine(leftMargin - 2, topMargin + h - i * h / 10,
                           leftMargin + 2, topMargin + h - i * h / 10);
            s = formatDouble(yMin);
            g.drawString(s, leftMargin - fm.stringWidth(s) - 4,
                            topMargin + h);     
            s = formatDouble(yMax);
            g.drawString(s, leftMargin - fm.stringWidth(s) - 4,
                         topMargin + fm.getHeight() / 2);
            s = yLabel;
            g.drawString(s, leftMargin - fm.stringWidth(s) / 2,
                            topMargin - 4 - 4);  
            e = (Entry) Entries.first();
            int pxLast = leftMargin + (int) Math.round((e.x - xMin) * xRatio);
            int pyLast = topMargin + (int) Math.round((yMax - e.y) * yRatio);
            while ((e = (Entry) e.suc()) != null) {
                int px = leftMargin + (int) Math.round((e.x - xMin) * xRatio);
                int py = topMargin + (int) Math.round((yMax - e.y) * yRatio); 
                if (pxLast >= leftMargin && pxLast <= leftMargin + w &&
                    pyLast >= topMargin && pyLast <= topMargin + h &&
                    px >= leftMargin && px <= leftMargin + w &&
                    py >= topMargin && py <= topMargin + h)
                    g.drawLine(pxLast, pyLast, px, py);
                pxLast = px; 
                pyLast = py;
            }
        }
    }
    
    /**
     * Formats a <tt>double</tt> in fixed format for small numbers, 
     * exponential format for large numbers. Trailing zeroes are suppressed.
     * Precision: 3 digits in the fractional part.
     */
    private String formatDouble(double x) {
        return 
            new Format(x == 0 || (Math.abs(x) > 0.1 && Math.abs(x) < 99999.999) ?
                "%0.3f" : "%0.3e").form(x); 
    }
}
