/*
 * @author Ian Gowland
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* OBJ54-J. This class would be set up for a simple beginning of a file 
 * reading program. When finished with processing the file, let both of these variables
 * just remain as they are (as long as they don't contain sensitive data, that is).
 * The scope of the block will indicate when these variables will be deallocated by the 
 * garbage collector.
 */

public class OBJ54J {
    
    public static void main(String[] args) {
        try {
            File fileName = new File("random.txt");
            BufferedReader bRead = new BufferedReader(new FileReader(fileName));
            // process file, whichever manner it needs to be
            bRead.close();
        } catch (Exception e) {
            // Implement handling based on type of exception
        }
        
    }

}


