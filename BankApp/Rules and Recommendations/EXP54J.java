public class EXP54J {
    /* 
     * EXP54-J. Understand the differences between bitwise and logical operators
     * @author Matthew Fonner
     * 
     * This program will show methods utilizing both bitwise and logical operators to show
     * their appropriate use cases.
     * 
     * First method converts the character at the index of a string to lowercase using logical operators
     * 
     * @param - index: an integer indicating the index of the character that will be made lowercase
     * @param - word: a string with the word
     * @return - boolean: incidating success of the operation
    */

    public static boolean makeIndexLowercase(int index, String word)
    {
        if(word!=null && index >=0 && index < word.length())
        {
            Character.toLowerCase(word.charAt(index));
            return true;
        }
        return false;
    }

    /* Method comparing strings at every index using bitwise operators
     * @param - word1: a string of the first word
     * @param - word2: a string of the second word
     * @return - boolean: indicating whether strings are equal.
     */
    public static boolean areStringsSame(String word1, String word2)
    {
        int i1 = 0;
        int i2 = 0;
        while(++i1 < word1.length() & ++i2 < word2.length())
        {
            if(word1.charAt(i1) != word2.charAt(i2))
            {
                return false;
            }
        }
        return true;
    }
}
