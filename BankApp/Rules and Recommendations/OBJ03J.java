
import java.util.ArrayList;
import java.util.List;

/*
 * @author Ian Gowland
 */

public class OBJ03J {

    /*
     * OBJ03-J. THis rule would be applied to use of Lists. Using a List of raw type 
     * (with no specific data type for the List) could cause problems.
     * 
     * This rule recommends to always make a List generically, that is, with a specific 
     * data type such as a String. This following example has an argument of List<String> 
     * and type checks another argument, a String, that will be added to the List. This type 
     * checks the String object that will be added to this generic List (Collection). It's 
     * generic because all elements of the List must be String. This type checking is 
     * safest.
     */
    
    /**
     * Confirms the type of List<String> is adding a String element
     * @param list - This is a List (ordered Collection)
     * @param str - Some arbitrary string that's type checked to be a String object
     */
    private static void addToList(List<String> list, String str) {
        list.add(str);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        addToList(list, "64");
        System.out.println(list.get(0));
    }
}


