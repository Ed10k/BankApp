import java.nio.IntBuffer;

public class FIO05J {
    /* FIO05-J. Do not expose buffers or their backing arrays methods to untrusted code
     * @author Matthew Fonner

     * This program will demonstrate the correct use of buffers so that the original data cannot be modified.
     * 
     * @param - intArray: an array of integers where a buffer will be wrapped around
     * @return - IntBuffer: a buffer around the array of integers that was passed, or null if none was passed
     */


     public static IntBuffer getIntBufferCopy(int[] intArray)
     {
        if(intArray != null)
        {
            return IntBuffer.wrap(intArray).asReadOnlyBuffer();
        }
        else
        {
            return null;
        }
     }
}
