/*
 * @author Ian Gowland
 */

public class OBJ10J {

    /* OBJ10-J. This public method would have access to a private static member of this rule
     * class,serialNo.and confirm that the given serial number matches the variable serialNo. 
     * 
     * @param serial - A Long input that is being compared to verify actual serialNo.
     * @return - true if argument "serial" matches the serialNo variable, false otherwise. 
     */

    private static final Long serialNo = 101010101010L;

    public static boolean verifySerial(Long serial){

        if(serial.equals(serialNo)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(OBJ10J.verifySerial(101010101010L));
    }
    
}

