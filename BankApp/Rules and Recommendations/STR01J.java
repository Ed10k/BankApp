
public class STR01J {
    /*
     * STR01-J. This rule would account for the additional characters that were added 
     * to an updated standard of Unicode. These characters would be represented by 
     * more than 16 bits, which are called supplementary characters.
     * 
     * Each Unicode charCount would return the number of bits it would need
     * to be assigned based on the code point beginning from where the last 
     * character ended (or when it starts). The Character.isLetter method would
     * accept a Unicode point as an int argument. Java library methods would
     * also accept these Unicode points as int, which would include all characters 
     * including supplementary characters.
     * 
     * @author Ian Gowland
     */

    /**
     * Trims a String str until a non-Unicode character is encountered.
     * @param - str: a string of characters
     * @return - remainder of string including last character that was a 
     * Unicode character. (Accounts for Unicode supplementary characters).
     */
    public static String trimUntilNonUTF16Char (String str) {
        int currentChar, i;
        for(i = 0; i < str.length(); i+= Character.charCount(i)){
            currentChar = str.codePointAt(i);
            System.out.println(currentChar);
            if(!Character.isLetter(currentChar)) {
                break;
            }
        }
        return str.substring(i);
    }
}



