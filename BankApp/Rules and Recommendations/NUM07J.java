/*
 * @author Ian Gowland
 */

public class NUM07J {

    /* NUM07-J. Direct comparisons should never happen with NaN (not a number). These
     * comparisons could cause unintended behaviors, so it must be confirmed that any 
     * mathematical operation does not directly compare to NaN. This is especially true
     * when working with floating point numbers. 
     * 
     * NaN is unordered. All comparison operators with any instance of NaN (<, <=, etc.) 
     * would result in false. The only time a comparison with NaN is true is if the != 
     * operator is used when comparing any variable that happens to be NaN. This example 
     * below would show what happens when NaN is the result of a mathematical function, 
     * Math.tan for this example. It checks if the double variable is NaN before doing 
     * anything else with the variable.
     */

    public static void main(String[] args) {

        double x = 0.0;
        // function input would mathematically result in infinity, assigning the variable to NaN
        double result = Math.tan(1/x); 
        if (Double.isNaN(result)) {
            System.out.println("Result is NaN");
        }

    }
}


