import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ERR01J {

    /* ERR01-J. If there is an exception thrown for a file, there will not be a message 
     * displayed associated with that specific exception because it might expose sensitive 
     * information. 
     * 
     * In these contexts, such as when a file path is for a home directory or 
     * if the file is not found. These will not display the messages for these exceptions.
     * This is how these filters can be used to prevent these messages exposing unintended data.
     * 
     * @author Ian Gowland
     */

    public static void main(String[] args) {

        File fileRef = null;
        try {
            fileRef = new File("c:\\homepath").getCanonicalFile();
            if(!fileRef.getPath().startsWith("c:\\homepath")){
                System.out.println("Invalid file");
                return;
            }
        } catch (IOException ioe) {
            System.out.println("Invalid file.");
            return;
        }

        try {
            FileInputStream fis = new FileInputStream(fileRef);
            return;
        } catch (FileNotFoundException fnf){
            System.out.println("Invalid file.");
            return;
        }
    }
}

