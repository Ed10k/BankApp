public class NUM02J {
    /* NUM02-J. Ensure that division and remainder operations do not result in divide-by-zero errors
     * @author Matthew Fonner
     * 
     * This program will demonstrate how to correctly handle modulus when 0 is the divisor
     * 
     * @param - divdend: the divident of the modulus operation
     * @param - divisor: the divisor of the modulus operation
     * @return - void: Print a message of the quotient or any possible problems
     */

     public static void modulusOfInt(int dividend, int divisor)
     {
        if(divisor == 0)
        {
            System.out.println("Cannot divide by zero");
        }
        else
        {
            System.out.println(dividend % divisor);
        }
     }
}
