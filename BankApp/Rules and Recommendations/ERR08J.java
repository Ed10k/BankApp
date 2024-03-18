public class ERR08J {
    /* ERR08-J. Do not catch NullPointerException or any of its ancestors
     * @author Matthew Fonner
     * 
     * This method traverses through a string counting the number of capital letters
     * This method does not through nor catch a NullPointerException
     * 
     * @param - str: the string being analyzed for capital letters
     * @return - int: the number of capital letters
     */

    public static int numCapitals(String str)
    {
        int numCapitals = 0;
        if(str == null){
            return numCapitals;
        }
        else{
            for(int i = 0; i < str.length(); i++)
                if(Character.isUpperCase(str.charAt(i)))
                    numCapitals++;
            return numCapitals;
        }
    }
}
