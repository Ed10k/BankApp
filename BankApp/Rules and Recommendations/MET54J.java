import java.util.ArrayList;
import java.util.Random;

/*
 * @author Ian Gowland
 */

public class MET54J {

    public ArrayList<Integer> userIDs = new ArrayList<Integer>();
    public ArrayList<String> userNames = new ArrayList<String>();

    /**
     * This method displays the kernel of this rule in which all methods shuld have values
     * to return, which can relay the status of this method's operation. Return true if 
     * user found, false if not.
     * @param userID - int representation of UserID.
     * @return - true if userID is stored in list of user ID's, false if not found
     */
    public boolean displayUser(int userID) {
        for(int i = 0; i < userIDs.size(); i++) {
            if(userIDs.get(i) == userID) {
                System.out.println("UserID: " + userIDs.get(i));
                System.out.println("Username: " + userNames.get(i));
                return true;
            }
        }
        return false;
    }

    /**
     * This just creates some random user ID's and names
     * @return - size of user list. 
     */
    public int addRandomUsers() {
        Random rando = new Random();
        for(int i = 0; i < 10; i++) {
            userIDs.add(rando.nextInt(1000));
            userNames.add("Random user" + i);
        }
        return userIDs.size();
    }
    
}


