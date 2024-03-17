public class DCL53J {
    /* DCL53-J. Minimize the scope of variables
     * @author Matthew Fonner
     * This method minimizes the scope of its variables by only declaring them when they are appropriate.
     * Both spaceCounter and i have the lowest scope possible.
     * This method counts the number of spaces in a string.
     * 
     * @param - str: The string being counted for spaces
     * @return - int: The number of spaces in the string
     */
    public static int numSpaces(String str)
    {
        int spaceCounter = 0;
        
        //initialize variable in loop
        for(int i = 0; i< str.length(); i++)
        {
            if(str.charAt(i) == ' ')
            {
                spaceCounter++;
            }
        }

        return spaceCounter;
    }
}
