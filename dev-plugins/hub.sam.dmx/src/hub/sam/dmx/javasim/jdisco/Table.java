/*
  File: Table.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class facilitates table-lookup.<br> 
 * <p>
 * A </tt>Table</tt>-object represents a function table. 
 * An entry (<tt>x</tt>,</tt>y</tt>) is added to the table
 * by calling <tt>add(x,y)</tt>. The entries may be added in arbitrary order. 
 * The <tt>x</tt>-es must be distinct, but need not be uniformly spaced.<br>
 * <p>
 * A call <tt>value(x)</tt> returns the <y>-value corresponding to <tt>x</tt> 
 * using linear interpolation. If <tt>x</tt> is less than the minimum 
 * <tt>x</tt>-value of the table, <tt>xMin</tt>, then 
 * <tt>value(x)</tt> = <tt>value(xMin)</tt>.
 * <p> 
 * If <tt>x</tt> is greater than the maximum 
 * <tt>x</tt>-value of the table, <tt>xMax</tt>, then 
 * <tt>value(x)</tt> = <tt>value(xMax)</tt>. 
 */
public class Table {
    /**
     * Adds the entry (<tt>x</tt>, <tt>y</tt>) to the table.
     *
     * @param <tt>x</tt> the x-value.
     * @param <tt>y</tt> the y-value.
     */
    public void add(double x, double y) {
        left = new Entry(x, y);
        if (entries.empty() || ((Entry) entries.last()).x < x)
            left.into(entries);
        else {
            right = (Entry) entries.first();
            while (right.x < x)
                right = (Entry) right.suc();
            if (right.x == x)
                right.y = y;
            else
                left.precede(right);
        }    
    }    
    
    /**
     * Adds the entry (<tt>time()</tt>, <tt>y</tt>) to the table.
     *
     * @param <tt>y</tt> the y-value.
     */
    public void add(double y) {
        add(Process.time(), y);
    } 
    
    /**
     * Adds the entry (<tt>time()</tt>, <tt>v.state</tt>) to the table.
     *
     * @param <tt>v</tt> the <tt>Variable</tt>-object.
     */
    public void add(Variable v) {
        add(Process.time(), v.state);
    }
    
    /**
     * Adds the entry (<tt>v1.state</tt>, <tt>v2.state</tt>) to the table.
     *
     * @param <tt>v1</tt> the first <tt>Variable</tt>-object.
     * @param <tt>v2</tt> the second <tt>Variable</tt>-object.
     */
    public void add(Variable v1, Variable v2) {
        add(v1.state, v2.state);
    }  
    
    /**
     * Returns the <tt>y</tt>-value corresponding to <tt>x</tt> using
     * linear interpolation.
     */
    public double value(double x) {
        if (entries.empty())
            Process.error("Table is empty");
        while (left != null && left.x > x) {
            right = left;
            left = (Entry) right.pred();
        }
        while (right != null && right.x <= x) {
            left = right;
            right = (Entry) left.suc();
        }
        return left == null ? right.y :
               right == null ? left.y :
               left.y + (right.y - left.y) * 
                           ((x - left.x) / (right.x - left.x));
    }
    
    /**
     * Prints the table with a heading.
     *
     * @param <tt>heading</tt> the heading to be printed above the table.
     */
    public void print(String heading) {
        if (heading != null && heading.length() > 0)
            System.out.println(heading);
        if (entries.empty()) 
            System.out.println("*** Table is empty ***");
        else {
            Format.print(System.out, "%7s", "x");
            Format.print(System.out, "%12s\n", "y");
            Entry e = (Entry) entries.first();
            while (e != null) {
                Tab.printDouble(e.x);
                System.out.print("  ");
                Tab.printDouble(e.y);
                System.out.println();
                e = (Entry) e.suc();
            }
        }
    }
    
    /**
     * Prints the table without heading.
     */
    public void print() {
        print("");
    }
    
    /**
     * Shows the table as a graph.
     *
     * @param </tt>title</tt> the title of the graph 
     */
    public void show(String title) {
        Graph g = new Graph(title);
        Entry e = (Entry) entries.first();
        while (e != null) {
            g.add(e.x, e.y);
            e = (Entry) e.suc();
        }
         g.show();    
    }
    
    /**
     * Shows the table as an untitled graph. 
     */
    public void show() {
        show("");
    }
    
    /**
     * Inner class representing the table entries.
     */
    static class Entry extends Link {
        Entry(double x, double y) {
            this.x = x; this.y = y;
        }        
        double x, y;
    }
    
    Head entries = new Head();    // list of entries sorted by their x-values    
    Entry left, right;            // pointers for searching the list 
}