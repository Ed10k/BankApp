import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class IDS01J {

    /*
     * IDS01-J. This class will take a String object and normalize it prior to validation.
     * Doing so will prevent the possibility of a user including a script tag in their String.
     * 
     * This String is normalized, which essentially means that the string is converted into a 
     * prior to validating the string. This will allow Strings to be comparable with the same
     * binary representation. In this example, the emphasis of normalization would prevent a 
     * user from using a script tag. Without the normalization, there would be no possibility 
     * of this user executing a script. This scripting is called cross-site scripting (XSS) and
     * can cause a user to unknowingly execute a malicious script that can expose their information
     * or the website's information.
     * 
     * @author Ian Gowland
     */

     public static void main(String[] args) {
        String str = "\uFE64" + "script" + "\uFE65";
        // Normalize
        String normalStr = Normalizer.normalize(str, Form.NFKC);
        // Validate
        Pattern pattern = Pattern.compile("[<>]");
        Matcher matcher = pattern.matcher(normalStr);

        if(matcher.find()){
            throw new IllegalStateException();
        } else {
            // ...
        }
     }
    
}


