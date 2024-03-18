import java.math.BigDecimal;

/*
 * @author Ian Gowland
 */

public class NUM04J {

    /* NUM04-J. When doing arithmetic, it is inadvisable to use floating point values.
     * This is because floating point values in binary have a fixed number of digits
     * past the decimal point. But 0.1 and 0.2 are repating values in binary, so it's
     * better to use a different data type for accuracy. 
     * 
     * This is just one way of accounting for those inaccuracies (using BigDecimal).
     * Floating point values would not round up as seen by the example after the 
     * use of BigDecimal in main. 
     */

   public static void main(String[] args){

    BigDecimal dollars = new BigDecimal("1.0");
    BigDecimal dimes = new BigDecimal("0.1");
    BigDecimal number = new BigDecimal("8.5");
    System.out.println(dollars + "0 dollar minus " + number + " dimes is: " + "\n"
     + "\n" + dollars.subtract(dimes.multiply(number)));

    double doll = 1.0;
    double dime = 0.1;
    double num = 8.5;
    System.out.println(doll + "0 dollar minus " + number + " dimes is: " +
    (doll - (dime * num)) + "\n");

   }
    
}

