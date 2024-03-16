import java.util.*; 
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.awt.*;


public class BankApp {
    /*
     * Rules
     * DCL00-J Prevent class initiialization cycles
     * DCL50-J. Avoid cyclic dependencies among classes
     * EXP01-J. Do not allow execeptions to propogate outside of the method or class in which they are thrown
     * SER01-J Do not serialize instances of inner classes
     * ISD01-J Normalize strings before validating them
     * OBJ02-J Ensure visability of shared references to immutable objects
     * CON50-J Do not assume that declaring a reference volatile gaurantees safe publication of the memebers of the referenced object
     * EXP53-J Prefer interfaces to reflection
     * MET00-J. Validate method arguments
     * ERR50-J Use exception only for exceptional conditions 
     */

    private HashMap<String, BankUser> users = new HashMap<>(); 

    private Scanner scanner = new Scanner(System.in);

    public boolean option(int choice, boolean validated){
        boolean valid = false;
        String username = null;
        String password = null;
        BankUser user = null;
        
        
        
        switch (choice) {
           
            case 1:
                
                System.out.println("Please enter your username");
                username = scanner.nextLine();
                System.out.println("Please enter your password:");
                password = scanner.nextLine();
                if (users.containsKey(username)){
                    user = users.get(username);
                    if(password.equals(user.getPassword())){
                        System.out.println("Successful log in!");
                        valid = true;
                        return valid;
                    }
                    else{
                        System.out.println("The password or username you entered is incorrect, please try again.");
                        return valid;
                    }

                    
                }
                else{
                    System.out.println("No user with that username exists");
                    return valid;

                }
            case 2:
                System.out.println("Thank you for signing up with us!\n");
                System.out.println("Please enter a desired username\n");
                username = scanner.nextLine();
                while (users.containsKey(username)){
                    System.out.println("Sorry, that username is taken. Pick a different username:\n ");
                    username = scanner.nextLine();
                }
                System.out.println("What is your password?\n");
                password = scanner.nextLine();
                System.out.println("Please enter your first name: \n");
                String firstname = scanner.nextLine();
                System.out.println("Please enter your last name");
                String lastname = scanner.nextLine();
                System.out.println("Please enter your age");
                int age = scanner.nextInt();

                BankUser newUser = new BankUser(firstname, lastname, age, username, password);
                users.put(username, newUser);
                valid = true;
                return valid;

            case 3:
                if (!validated){
                    System.out.println("Unfortunately, before you can open an account with us you must eihter register or log in");
                    break;
                }
                System.out.println("Would you like to add a savings or checking account? (1 for checking, 2 for savings)");
                int account_preference = scanner.nextInt();
                String accountHolderName = user.getFullName();
                switch (account_preference) {
                    
                    case 1:
                        CheckingAccount checking = new CheckingAccount(accountHolderName);
                        System.out.println("How much money would you like to deposit?");
                        double money = scanner.nextDouble();
                        checking.deposit(money);
                        user.addAccount(checking);
                        System.out.println("Thank you for choosing to open an account with us\n");

                        
                        
                    case 2: 
                        SavingAccount savings = new SavingAccount();
                        System.out.println("How much money would you like to deposit?");
                        money = scanner.nextDouble();
                        savings.deposit(money);
                        user.addAccount(savings);
                        System.out.println("Thank you for choosing to open an account with us\n");
                
                    default:
                    System.out.println("Invalid choice");
                        break;
                }
                
            
        
            default:
            System.out.println("Invalid choice");
                break;
        }

        return valid;
    }


    public void menu(){
        boolean isOn = true;
        System.out.println("Hello, welcome to the Banking App\n What action would you like to perform?");
        while (isOn){
            
        }
    }


    public static void main(String[] args) throws Exception {
    
    }
}
