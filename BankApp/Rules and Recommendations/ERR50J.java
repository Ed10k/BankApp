public class ERR50J {
    /*
    * ERR50-J. Use exceptions only for exceptional conditions
    * @author Matthew Fonner

    * This program provides an example of the correct use of the above recommendation.
    * Using an array can lead to an ArrayIndexOutOfBoundsException if not handled correctly.
    * This method uses a for loop that checks the length and index before manipulating the contents, 
    * preventing the possibility of an exception
    *
    * @param - arrOfInts: An array of integers for which the sum is to be calculated.
    * @return - sum: An integer representing the sum of the array of integers.
    */

    public static int sumOfArray(int [] arrOfInts)
    {
        int sum = 0;
        for(int i = 0; i < arrOfInts.length; i++)
        {
            sum += arrOfInts[i];
        }
        return sum;
    }
}