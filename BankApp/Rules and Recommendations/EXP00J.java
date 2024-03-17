import java.io.File;

public class EXP00J {
    /* EXP00-J. Do not ignore values returned by methods
     * @author Matthew Fonner
     * 
     * This method uses the return values of the methods of the file class to display information about the file.
     * 
     * @param - file: the file being analyzed for readability and writeability
     * @return - boolean: indicating whether the file exists or not
     */

    public static boolean fileDetails(File file)
    {
        if(file.exists())
        {
            System.out.println("Can Read : " + file.canRead());
            System.out.println("Can Write: " + file.canWrite());
            return true;
        }
        else
        {
            System.out.println("File doesn't exist");
            return false;
        }
        
    }
}
