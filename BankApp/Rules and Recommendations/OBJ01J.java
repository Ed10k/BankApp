public class OBJ01J {
    /* OBJ01-J. Limit accessibility of fields
     * @author Matthew Fonner
     * 
     * This program provides an example of the proper accessibility of fields.
     * Names is a private final array of strings used in the program.
     * To access this, a public method clones the array. This is safe since Strings
     * are immutable.
     * 
     * @param - none: the getter method requires no input
     * @return - String[]: a clone of the name array
     */

     private static final String[] names = {"Matt", "Rishi", "Bob"};

     public static final String[] getNames()
     {
        return names.clone();
     }
}
