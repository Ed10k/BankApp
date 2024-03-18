/*
 * Solution to ERR07. This example finds a more specific exception to throw rather than just an instance of Exception.
 */
public class ERR07
{
    void readFile() throws IOException
    {
        file= new BufferedReader(new FileReader("example.txt"));
        if(file==null)
        {
            throw new IOException();
        }
        String line=file.readLine();
        while(line!=null)
        {
            System.out.println(line);
            line=file.readLine();
        }
        file.close();
    }
}