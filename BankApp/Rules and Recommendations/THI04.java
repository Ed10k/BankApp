import java.io.*;
import java.net.*;


/*
THI04-J. Ensure that threads performing blocking operations can be terminated
This rule highlights the importance of designing threads that can be safely and swiftly terminated,
 especially threads that are involved with long-running or blocking operations. 

 By adding the terminate function at the bottom, this allows the process to be 
 terminated quickly should there be an issue wheere the thread becomes unresponsive 
 */
public class THI04 implements Runnable{
    private volatile boolean exit = false;

    public void run(){
        try{
            URL url = new URL("https://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(5000);

            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine())!= null && !exit){
                System.out.println(line);

            }
            reader.close();
        }
        catch (IOException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }


    public void terminate(){
        exit = true;
    }
    
}
