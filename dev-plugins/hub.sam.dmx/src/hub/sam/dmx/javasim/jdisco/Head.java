/*
  File: Head.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date        Who                What
  20Sep2001   kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This class is used for representing circular two-way lists.<p>
 *
 * Items in a list are represented by objects of class <tt>Link</tt>, 
 * or more usefully, subclasses of <tt>Link</tt>.
 *
 * @see jDisco.Link 
 * @see jDisco.Linkage
 */
public class Head extends Linkage {
    public Head() { 
        PRED = SUC = this; 
    }

    /**
     * Returns the first item in this list.
     */
    public final Link first() { 
        return suc(); 
    }
    
    /**
     * Returns the last item in this list.
     */
    public final Link last() { 
         return pred(); 
    }
    
    /**
     * Tests if this list is empty.
     *
     * @return <tt>true</tt>, if this list is empty; <tt>false</tt> otherwise.
     */
    public final boolean empty() { 
         return SUC == this; 
    }

    /**
     * Returns the number of items currently in this list.
     */
    public final int cardinal() {
        int i = 0;
        for (Link ptr = first(); ptr != null; ptr = ptr.suc())
            i++;
        return i;
    }

    /**
     * Removes all items from this list. 
     */
    public final void clear() { 
        while (first() != null) 
            first().out(); 
    }
}
