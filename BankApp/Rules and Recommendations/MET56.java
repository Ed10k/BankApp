import java.math.BigInteger;
import java.security.Key;
import java.security.interfaces.RSAPrivateKey;
import java.util.Arrays;

/**
 * @author Ian Gowland
 */

public class MET56 {
 
    /**
     * This method checks if the two Key objects are equals through several
     * different conditions to comprehensively verify that the two keys are equal.
     * @param first - first Key
     * @param second - second Key
     * @return - true if the Keys are equal, false if not
     */
    private static boolean keysEqual(Key first, Key second) {
        if(first.equals(second)) {
            return true;
        }

        if(Arrays.equals(first.getEncoded(), second.getEncoded())) {
            return true;
        }

        if((first instanceof RSAPrivateKey) && (second instanceof RSAPrivateKey)) {
            if(((RSAPrivateKey) first).getModulus().equals(((RSAPrivateKey) second).getModulus())
                && (((RSAPrivateKey) first).getPrivateExponent().equals(((RSAPrivateKey) second).getPrivateExponent()))
            ) {
                return true;
            }
        }
        return false;
    }
 
}
