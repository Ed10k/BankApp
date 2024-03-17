public class VNA02J {
    /*
     * VNA02-J. Ensure that compound operations on shared variables are atomic
     * @author Matthew Fonner
     * 
     * This program will demonstrate the correct use of compound operations on a shared
     * variable using the 'synchronized' and 'volatile' key words. this will prevent data races
     */

    //volatile keyword assures visibility across threads
    private volatile boolean bool = false;

    /*
     * @param - none: switches bool to opposite value
     * @return - void
     */
    public synchronized void switchBool()
    {
        bool = !bool;
    }

    /*
     * @param - none: returns bool
     * @return - boolean: returns bool
     */
    public synchronized boolean getBool()
    {
        return bool;
    }
}
