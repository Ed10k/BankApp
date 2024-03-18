import java.util.Arrays;

public class EXP02J {
    /* EXP02-J. Do not use the Object.equals() method to compare two arrays
     * @author Matthew Fonner
     * 
     * This method provides a correct example of comparing two arrays using the Arrays.equals() method after modifying the values
     * 
     * @param - arr1: the first array of doubles to be compared
     * @param - arr2: the second array of doubles to be compared
     * @return - boolean: indicating whether the two arrays are equal
     */

     public static boolean arrayCompare(double[] arr1, double[] arr2)
     {
        if(arr1 != null && arr2 != null && arr1.length >=1 && arr2.length >=1)
        {
            arr1[0] = 3.4;
            arr2[0] = 3.4;
        }
        return Arrays.equals(arr1, arr2);
     }
}
