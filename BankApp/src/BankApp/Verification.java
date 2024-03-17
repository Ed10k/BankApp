package BankApp;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is a compilation of several rules that have been implemented and 
 * that can be called statically to verify safe operations, exception handling
 * and exception messages, etc. 
 * 
 * Rules referenced in this class:
 * IDS01-J. This class will take a String object and normalize it prior to validation.
 * NUM07-J. Direct comparisons should never happen with NaN (not a number). 
 * EXP01-J: Don’t use a Null in a case where an Object is required.
 * ERR01-J. Do not allow exceptions to expose sensitive information. 
 * OBJ03-J. Prevent heap pollution.
 * 
 * @author Ian Gowland
 */

public class Verification {

    private static final String SENTINEL = "*";

     /**
      * IDS01-J. This class will take a String object and normalize it prior to validation.
      * Doing so will prevent the possibility of a user including a script tag in their String.
      *
      * The emphasis of normalization would prevent a user from using a script tag. 
      * Without the normalization, there would be no possibility of this user executing a script. 
      * This scripting is called cross-site scripting (XSS) and can cause a user to unknowingly execute 
      * a malicious script that can expose their information or the website's information.
      * 
      * @param str - String to check or convert to normalized String.
      * @return normalStr - Return string that has been normalized.
      */
     public static String normalizeString(String str) {
        String normalStr = Normalizer.normalize(str, Form.NFKC);
        // Validate
        Pattern pattern = Pattern.compile("[<>]");
        Matcher matcher = pattern.matcher(normalStr);
        /*
         * This String is normalized, which essentially means that the string is converted into a 
         * standard format prior to validating the string. This will allow Strings to be comparable 
         * with the same binary representation. 
         */

        if(matcher.find()){
            throw new IllegalStateException();
        } 
        return normalStr;
     }

     /**
      * NUM07-J. Direct comparisons should never happen with NaN (not a number). These
      * comparisons could cause unintended behaviors, so it must be confirmed that any 
      * mathematical operation does not directly compare to NaN. This is especially true
      * when working with floating point numbers. 
      *
      * EXP01-J: Don’t use a Null in a case where an Object is required. This rule is
      * expressed within this method in the case that the argument is an instance of NaN.
      * Instead of assigning the variable to null, assign to 0 instead to prevent the 
      * potential NullPointerException. 
      *
      * @param dub - Double variable to be checked if NaN
      * @return - If the original variable is NaN, it gets reassigned to null. If it's not, 
      * it just returns the original number.
      */
     public static Double verifyDoubleNonNaN(Double dub) {
        if (Double.isNaN(dub)) {
            System.out.println("Result is NaN.");
            dub = 0.0;
        }
        return dub;
     }

     /**
      * ERR01-J. Do not allow exceptions to expose sensitive information. 
      * 
      * Whenever programming a try catch, this method can be called to handle exceptions.
      * Certain messages should not be displayed as they can expose sensitive infomration
      * about the server, but even the client as well. So anytime try catch blocks are 
      * used in the program, pass in the Exception object where the exception can prevent
      * having its message displayed. 
      * 
      * @param except - Encountered Exception, which will be assessed based on its Exception type.
      */
     public static boolean handleExceptions(Exception except) {

        if(except instanceof FileNotFoundException) {
            System.out.println("File not found exception occurred.");
            return false;
        } else if (except instanceof IOException) {
            System.out.println("IOException occured.");
            return false;
        // Add else if for any other risky exception and it's corresponding getMessage
        } else {
            // Exception message can be displayed.
            System.out.println(except.getMessage());
        }
        return true;
     }

     /**
      * OBJ03-J. Prevent heap pollution.
      * 
      * Heap pollution occurs when a raw list (superclass Object list) contains 
      * different data types for it's elements. This method would verify all 
      * elements in the list are the same, which will prevent heap pollution 
      * from occurring.
      * 
      * @param list - list that will have it's elements data types verified
      * @return - true if the list contains all elements of the same type
      */
     public static boolean verifyGenericList(ArrayList list) {

        if(!list.isEmpty()) {
            Object first = list.get(0);
            for(int i = 0; i < list.size(); i++){
                Object next = list.get(i);
                if(!first.getClass().equals(next.getClass())) {
                    return false;
                }
            }
        }
        return true;
     }

     /**
      * This method prompts a user to enter their password until it is correct.
      * @param user - BankUser, signifying the client that needs to verify their password.
      */
     public static boolean verifyPassword(BankUser user) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your password: ");
        String input = scan.nextLine();
        // while(!input.equals(user.getPassword()) && !input.equals(SENTINEL))
        while(!input.equals(user.getPassword()) && !input.equals(SENTINEL)) {
            //System.out.print("Incorrect.\nPlease enter your password:  (SENTINEL: Enter * to terminate loop.)");
            System.out.print("Incorrect.\nPlease enter your password: ");
            input = scan.nextLine();
        }
        scan.close();
        return true;
     }

     /**
      * Validate that user input is an integer
      * @param input - input to be validated as an integer
      */
      public static boolean verifyInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
     }

     /**
      * 
      */
     public static boolean loopForInteger(String input) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        while(!verifyInteger(input)){
            System.out.print("Incorrect.\nPlease enter an integer: ");
            input = scan.nextLine();
        }
        return true;
     }

     

}