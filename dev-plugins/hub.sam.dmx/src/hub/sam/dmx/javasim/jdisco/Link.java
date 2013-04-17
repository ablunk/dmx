/*
  File: Link.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date        Who                What
  20Sep2001   kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class is used for representing items in a circular two-way list.<p>
 *
 * The list is held in a <tt>Head</tt> object. The items are represented by objects 
 * of class <tt>Link</tt>, or more usefully, subclasses of <tt>Link</tt>.
 *
 * @see jDisco.Head 
 * @see jDisco.Linkage
 */
public class Link extends Linkage {
    /** 
     * Removes this item from the list (if any) that it is currently in. 
     * If it is not currently in a list, the call has no effect.
     */  
    public final void out() {
        if (SUC != null) {
            SUC.PRED = PRED;
            PRED.SUC = SUC;
            SUC = PRED = null;
        }
    }
    
    /**
     * Inserts this item after  a specified item.
     * <p> 
     * The item is inserted after the one referred to by the parameter, 
     * after having removed it from the list (if any) that is currently in.
     * If the parameter refers to a <tt>Head</tt>, the effect is to
     * put this object into first place in the list.
     * If the parameter is <tt>null</tt> or does not belong 
     * to a list and is not a <tt>Head</tt> object, 
     * the effect is the same as <tt>out()</tt>.
     *
     * @param <tt>ptr</tt> a pointer to the <tt>Linkage</tt> after 
     * which this item is to be inserted.  
     */    
    public final void follow(Linkage ptr) {
        out();
        if (ptr != null && ptr.SUC != null) {
            PRED = ptr;
            SUC = ptr.SUC;
             SUC.PRED = ptr.SUC = this;
        }
    }

    /**
     * Inserts this item before a specified item.
     * <p>  
     * The item is inserted before the one referred to by the parameter, 
     * after having removed it from the list (if any) that is currently in.
     * If the parameter refers to a <tt>Head</tt>, the effect is to
     * put this object into last place in the list.
     * If the parameter is <tt>null</tt> or does not belong 
     * to a list and is not a <tt>Head</tt> object, 
     * the effect is the same as <tt>out()</tt>.
     *
     * @param <tt>ptr</tt> a pointer to the <tt>Linkage</tt> after 
     * which this item is to be inserted.  
     */    
    public final void precede(Linkage ptr) {
        out();
        if (ptr != null && ptr.SUC != null) {
            SUC = ptr;
            PRED = ptr.PRED;
            PRED.SUC = ptr.PRED = this;
        }
    }
    
    /** 
     * Inserts this item as the last member of a list. 
     * <p>
     * The item is inserted last in the list referred to by the parameter, 
     * after having removed it from any list that is currently in.
     * If the parameter is <tt>null</tt>, the effect is the same as 
     * <tt>out()</tt>.
     *
     * @param <tt>ptr</tt> a pointer to the list into 
     * which this item is to be inserted.  
     */    
    public final void into(Head s) { 
        precede(s); 
    }
}
