import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.Normalizer;
import java.text.Normalizer.Form;


/**
 * Class description
 */

public class Verification {

    /*
     * Rules:
     * 
     * FIO05-J. Do not expose buffers or their backing arrays methods to untrusted code 
     * FIO08-J. Distinguish between characters or bytes read from a stream and -1
     * 
     * IDS00-J.
     * IDS01-J. Normalize strings before validating them. 
     * 
     * NUM07-J. Do not attempt comparisons with NaN. 
     * NUM00-J: Detect or Prevent Integer Overflow 
     * 
     * MET00-J. Validate Method Arguments 
     * 
     * SER03-J. Do not serialize unencrypted sensitive data.
     * Set the password variable, whether in this class or in User to transient.
     * Tbis will prevent the JVM from serializing the data. 
     * 
     * VNA05-J. Ensure atomicity when reading and writing 64-bit values.
     * 
     * ERR01-J. Do not allow exceptions to expose sensitive information.
     * 
     

    /* 
     * IDS01-J. This class will take a String object and normalize it prior to validation.
     * Doing so will prevent the possibility of a user including a script tag in their String.
     *
     * In this example, the emphasis of normalization would prevent a 
     * user from using a script tag. Without the normalization, there would be no possibility 
     * of this user executing a script. This scripting is called cross-site scripting (XSS) and
     * can cause a user to unknowingly execute a malicious script that can expose their information
     * or the website's information.
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

     

}