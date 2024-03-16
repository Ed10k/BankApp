import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is a compilation of several rules that have been implemented and 
 * that can easily be called statically from any class within the classes that 
 * compose this application to verify safe operations, exception handling, etc. 
 * 
 * @author Ian Gowland
 */

public class Verification {

    /*
     * Rules:
     * 
     * FIO05-J. Do not expose buffers or their backing arrays methods to untrusted code 
     * FIO08-J. Distinguish between characters or bytes read from a stream and -1
     * 
     * 
     * NUM00-J: Detect or Prevent Integer Overflow 
     * 
     * MET00-J. Validate Method Arguments 
     * 
     * VNA05-J. Ensure atomicity when reading and writing 64-bit values.
     * /
     

     /**
      * IDS01-J. This class will take a String object and normalize it prior to validation.
      * Doing so will prevent the possibility of a user including a script tag in their String.
      *
      * The emphasis of normalization would prevent a user from using a script tag. 
      * Without the normalization, there would be no possibility of this user executing a script. 
      * This scripting is called cross-site scripting (XSS) and can cause a user to unknowingly execute 
      * a malicious script that can expose their information or the website's information.
      * 
      * @param str - String to check or convert to normalized String.
      * @return normalStr - Return string that has been normalized.
      */
     public static String normalizeString(String str) {
        String normalStr = Normalizer.normalize(str, Form.NFKC);
        // Validate
        Pattern pattern = Pattern.compile("[<>]");
        Matcher matcher = pattern.matcher(normalStr);
        /*
         * This String is normalized, which essentially means that the string is converted into a 
         * standard format prior to validating the string. This will allow Strings to be comparable 
         * with the same binary representation. 
         */

        if(matcher.find()){
            throw new IllegalStateException();
        } 
        return normalStr;
     }

     /**
      * NUM07-J. Direct comparisons should never happen with NaN (not a number). These
      * comparisons could cause unintended behaviors, so it must be confirmed that any 
      * mathematical operation does not directly compare to NaN. This is especially true
      * when working with floating point numbers. 
      *
      * EXP01-J: Don’t use a Null in a case where an Object is required. This rule is
      * expressed within this method in the case that the argument is an instance of NaN.
      * Instead of assigning the variable to null, assign to 0. 
      *
      * @param dub - Double variable to be checked if NaN
      * @return - If the original variable is NaN, it gets reassigned to null. If it's not, 
      * it just returns the original number.
      */
     public static Double verifyDoubleNonNaN(Double dub) {
        if (Double.isNaN(dub)) {
            System.out.println("Result is NaN.");
            dub = 0.0;
        }
        return dub;
     }

     /**
      * ERR01-J. Do not allow exceptions to expose sensitive information. 
      * 
      * Whenever programming a try catch, this method can be called to handle it. 
      * Certain messages should not be displayed as they can expose sensitive infomration
      * about the server, but even the client as well. So anytime try catch blocks are 
      * used in the program, pass in the Exception object where the exception can prevent
      * having its message displayed. 
      * 
      * @param except - Encountered Exception, which will be assessed based on its Exception type.
      */
     public static boolean handleExceptions(Exception except) {

        if(except instanceof FileNotFoundException) {
            System.out.println("File not found exception occurred.");
            return false;
        } else if (except instanceof IOException) {
            System.out.println("IOException occured.");
            return false;
        } else {
            // Exception message can be displayed.
            System.out.println(except.getMessage());
        }
        return true;
     }



}