import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FIO08J {
    /* FIO08-J. Distinguish between characters or bytes read from a stream and -1
     * @author Matthew Fonner
     * 
     * This program will demonstrate the proper use of characters in an input stream by checking for the end.
     * 
     * @param - file: the file to be made into a filestream that will be added to an array of characters after conversion from int
     * @return - ArrayList<Character>: the filestream will transfer the ints into Characters and put them into an ArrayList
     */

     public static ArrayList<Character> readingStream(File file)
     {
        ArrayList<Character> charList = new ArrayList<Character>(10);

        if(file.exists() && file.canRead())
        {
            try {
                FileInputStream fin = new FileInputStream(file);
                int inbuff;
                char dataToAdd;
                while((inbuff = fin.read()) != -1)
                {
                    dataToAdd = (char) inbuff;
                    charList.add(dataToAdd);
                }
                fin.close();
                return charList;

            } catch (FileNotFoundException e) {
                System.out.println("File Not Found");
                return charList;
            } catch (IOException e) {
                System.out.println("IO Exception");
                return charList;
            }
        }
        else
        {
            return charList;
        }
     }
}
