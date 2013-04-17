/*
  File: Condition.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001    kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
 * This interface is used in combination with the <tt>waitUntil</tt>-method for
 * specifying state-events.
 * <p>
 * <tt>waitUntil(cond)</tt>, where <tt>cond</tt> is a <tt>Condition</tt>-object, 
 * causes the active discrete process, <tt>current</tt>, to become passive 
 * (<tt>idle</tt>) over a period which is planned to last until the 
 * <tt>test</tt>-method of <tt>cond</tt> evaluates to <tt>true</tt>.
 * <p>
 * Example:<br>
 * <pre><tt>
 *    waitUntil(new Condition() {
 *        public void test() {
 *            return pressure.state >= 200;
 *        }
 *    }); 
 * </tt></pre>
 * 
 * @see jDisco.Process#waitUntil(jDisco.Condition)
 * @see jDisco.Process#waitUntil(jDisco.Condition, double)
 * @see jDisco.Process#waitUntil(jDisco.Condition, jDisco.Process.Prior)
 * @see jDisco.Process#waitUntil(jDisco.Condition, double, jDisco.Process.Prior)
 */
public interface Condition {
	/**
	 * Returns <tt>true</tt> if the condition is fulfilled; <tt>false</tt>, otherwise.
	 */
	boolean test();
}