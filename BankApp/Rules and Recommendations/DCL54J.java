public class DCL54J {
    /*
    * DCL54-J. Use meaningful symbolic constants to represent literal values in program logic
    * @author Matthew Fonner
    * Performs exponential and division operations using Euler's constant e. Declares e as a constant
    * instead of using the literal 2.71828...
    * @param - exponent: an exponent that e will be raised to
    * @return - double: the result of raising e to the exponent
    *
    * @param - divident: the dividend that will divide by e
    * @return - double: the quotient of the operation
    */
    private static final double e = 2.71828;

    public static double exp(double exponent)
    {
        return Math.pow(e,exponent);
    }

    public static double divideByE(double dividend)
    {
        return dividend/e;
    }
}
