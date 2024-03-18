import java.util.ArrayList;
import java.util.List;

/* DCL61-J. This class shows type checking to show how adding to a generic List
 * can type check any data being added to it. This example would just show that
 * the list is declared generically as a String and the argument given for the 
 * String str is type checked to be a String, which prevents mixing of raw and 
 * generic data types. The list and the argument are type checked. 
 * 
 * @author Ian Gowland
 */

public class DCL61J {
    
    /**
     * This method type checks a String argument being added to the generic String list
     * @param list - list that will have String str added to it
     * @param str - next string for list 
     */
    private static void addToList(List<String> list, String str) {
        list.add(str);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        addToList(list, "42");
        System.out.println(list.get(0));
    }
}


