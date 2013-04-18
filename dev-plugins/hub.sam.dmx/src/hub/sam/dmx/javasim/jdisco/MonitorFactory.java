/*
  File: MonitorFactory.java

  Originally written by Keld Helsgaun and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.

  History:
  Date       	Who                What
  20Sep2001     kh         Created public version
*/

package hub.sam.dmx.javasim.jdisco;

/**
* This class can be used for cretaing instances of class <tt>Monitor</tt>.
*/
class MonitorFactory {
    /**
     * Returns a <tt>Monitor</tt>-object by its name (a String).
     * <p>
     * If there is no monitor with that name, the program is stopped
     * with an error message.
     * 
     * @param <tt>name</tt> the name of the integration method.
     * @return the <tt>Monitor</tt>-object. 
     */
    static Monitor getInstance(String name) {
        if ("Adams".equalsIgnoreCase(name))
            return new Adams();
        if ("AdamsBashforth".equalsIgnoreCase(name))
            return new AdamsBashforth();
        if ("Euler".equalsIgnoreCase(name))
            return new Euler();
        if ("FowlerWarten".equalsIgnoreCase(name))
            return new Euler();
        if ("RKDP45".equalsIgnoreCase(name))
            return new RKDP45();
        if ("RKE".equalsIgnoreCase(name))
            return new RKE();
        if ("RKF45".equalsIgnoreCase(name))
            return new RKF45();
        if ("RKN34".equalsIgnoreCase(name))
            return new RKN34();
        if ("RKV56".equalsIgnoreCase(name))
            return new RKV56();
        if ("Simpson".equalsIgnoreCase(name))
            return new Simpson();
        if ("Trapez".equalsIgnoreCase(name))
            return new Trapez();
        Process.error("No integration method named " + "\"" + name + "\"." + "\n\n" +
                      "Available methods:\n" +
                      "Adams, AdamsBashforth, Euler, FowlerWarten,\n" + 
                      "RKDP45, RKE, RKF45, RKN34, RKV56, Simpson, Trapez");
        return null;
    }    
    
    
    /**
     * Returns the default <tt>Monitor</tt>-object ("RKF45").
     * 
     * @return a <tt>Monitor</tt>-object of class <tt>RKF45</tt>.
     */
    static Monitor getInstance() {
        return new RKF45();
    }
}
