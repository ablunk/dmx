/*
  File: Linkage.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date        Who                What
  20Sep2001   kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class is used for representing the linkages of a circular 
 * two-way list.<p>
 *
 * Class <tt>Linkage</tt> contains basic linking attributes for forming lists.
 * It is a base class of class <tt>Link</tt> and class <tt>Head</tt>.
 * <p>
 * A <tt>Link</tt> object represents a list item,
 * whereas a <tt>Head</tt> object represents the start and end of a list.
 *
 * @see jDisco.Link
 * @see jDisco.Head 
 */
public class Linkage {
    /**
     * Returns the item in the list before this <tt>Linkage</tt>.
     *
     * @return If this <tt>Linkage</tt> is a <tt>Link</tt>,
     * its predecessor item in the list is returned. 
     * If this <tt>Linkage</tt> is a <tt>Head</tt>,
     * the last item in the list is returned.
     */
    public final Link pred() { 
         return PRED instanceof Link ? (Link) PRED : null; 
    }
        
    
    /**
     * Returns the item in the list after this <tt>Linkage</tt>.
     *
     * @return If this <tt>Linkage</tt> is a <tt>Link</tt>,
     * its predecessor item in the list is returned. 
     * If this <tt>Linkage</tt> is a <tt>Head</tt>,
     * the first item in the list is returned.
     */
    public final Link suc() { 
         return SUC instanceof Link ? (Link) SUC : null; 
    }
    
    /**
     * Returns the <tt>Linkage</tt> object before this one,
     * whether this is a <tt>Link</tt> object, a <tt>Head</tt> object
     * or <tt>null</tt>.
     *  
     * @return If this <tt>Linkage</tt> is a <tt>Link</tt> 
     * and not a member of any list, <tt>null</tt> is returned.
     * If this <tt>Linkage</tt> is the first item in a list, 
     * the corresponding <tt>Head</tt> object.
     * If this <tt>Linkage</tt> is a <tt>Head</tt>, 
     * the last item in the list.
     */
    public final Linkage prev() { return PRED; }

    /**
    * The predecessor this <tt>Linkage</tt>.
    */
    Linkage PRED;
    
    
    /**
     * The successor this <tt>Linkage</tt>.
     */
    Linkage SUC; 
}
