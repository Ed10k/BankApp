import java.io.File;

public class FIO02J {

    /* FIO02-J. File handling will not thrown an exception, it will just return a value.
     * The File object will call functions just like any other object, but when 
     * trying to delete the file, the behavior is different. There's no exceptions.
     * 
     * This rule verifies the return value after trying to delete the file. It checks 
     * if the function is successful and the file has been deleted. If it hasn't been
     * deleted, then it is known that it must be addressed. 
     *
     * @author Ian Gowland
     */

    public static void main(String[] args){

        File file = new File("path");
        if(!file.delete()){
            // Implement code to handle if the file did
            // not in fact open. 
        }
    }
    
}
