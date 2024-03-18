public class MET05J {
    /* MET05-J. Ensure that constructors do not call overridable methods
     * @author Matthew Fonner
     * 
     * This program will demonstrate the proper calling of other methods in constructors.
     * Methods called will not be overridable.
     */

    /*
     * @param - none: this is a constructor
     * @return - none: The constructor calls a private method identifyMyself, which
     * cannot be overridden
     */
    public MET05J()
    {
        identifyMyself();
    }

    /*
     * @param - none
     * @return - void: this method prints a string to the console and is called by the
     * constructor.
     */
    private final void identifyMyself()
    {
        System.out.println("I am a class");
    }
}

class SubClass extends MET05J
{
    /*
     * This is a subclass
     * 
     * @param - none: this constructor calls the constructor of the superclass,
     * which calls no overridable methods
     * @return - none:
     */
    public SubClass()
    {
        super();
    }
}