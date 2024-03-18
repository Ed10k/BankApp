package BankApp;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import java.util.List;


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

    @SuppressWarnings("null")
    public boolean option(int choice, boolean validated) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException{
        boolean valid = false;
        String username = null;
        String password = null;
        BankUser user = null;
        @SuppressWarnings("unused")
        List<BankAccount> accounts;
        BankAccount currentAccount = null;

        
        
        
        switch (choice) {
           
            case 1:
                
                System.out.println("Please enter your username");
                username = scanner.nextLine();
                System.out.println("Please enter your password:");
                password = scanner.nextLine();
                if(sanitizeUsername(username) && sanitzePassword(password)){
                    if (users.containsKey(username)){
                        user = users.get(username);
                        if(password.equals(user.getPassword())){
                            System.out.println("Successful log in!");
                            valid = true;
                            break;
                        }
                        else{
                            System.out.println("The password or username you entered is incorrect, please try again.");
                            break;
                        }
    
                        
                    }
                    else{
                        System.out.println("No user with that username exists");
                        break;
    
                    }
                }
            case 2:
                System.out.println("Thank you for signing up with us!\n");
                System.out.println("Please enter a desired username\n");
                username = scanner.nextLine();
                if(sanitizeUsername(username)){
                    while (users.containsKey(username)){
                        System.out.println("Sorry, that username is taken. Pick a different username:\n ");
                        username = scanner.nextLine();
                    }
                }
                System.out.println("What is your password?\n");
                password = scanner.nextLine();
                while(!sanitzePassword(password)){
                    System.out.println("Invalid Password.");
                    System.out.println("What is your password?\n");
                    password = scanner.nextLine();
                }
                System.out.println("Please enter your first name: \n");
                String firstname = scanner.nextLine();
                System.out.println("Please enter your last name");
                String lastname = scanner.nextLine();
                System.out.println("Please enter your age");
                int age = scanner.nextInt();

                BankUser newUser = new BankUser(firstname, lastname, age, username, password);
                users.put(username, newUser);
                valid = true;
                break;
                

            case 3:
                if (!validated){
                    System.out.println("Unfortunately, before you can open an account with us you must eihter register or log in");
                    break;
                }
                System.out.println("Would you like to add a savings or checking account? (1 for checking, 2 for savings)");
                int account_preference = scanner.nextInt();
                String accountHolderName = user.getFullName();
                String accountType;
                String accountName;
                
                
                switch (account_preference) {
                    
                    case 1:
                        System.out.println("What would you like to name this account?");
                        accountName = scanner.nextLine();
                        accountType = "Checking";
                        CheckingAccount checking = new CheckingAccount(accountHolderName, accountType, accountName);
                        System.out.println("How much money would you like to deposit?");
                        double money = scanner.nextDouble();
                        checking.deposit(money);
                        user.addAccount(checking);
                        System.out.println("Thank you for choosing to open an account with us\n");
                        break;

                        
                        
                    case 2: 
                        System.out.println("What would you like to name this account?");
                        accountName = scanner.nextLine();
                        accountType = "Savings";
                        SavingAccount savings = new SavingAccount(accountHolderName, accountType, accountName);
                        System.out.println("How much money would you like to deposit?");
                        money = scanner.nextDouble();
                        savings.deposit(money);
                        user.addAccount(savings);
                        System.out.println("Thank you for choosing to open an account with us\n");
                        break;
                
                    default:
                    System.out.println("Invalid choice");
                        break;
                        
                
                }
            case 4:
                System.out.println("What account would you like to access?");
                for (BankAccount account: user.getAccounts()){
                    System.out.println(" \n" + account);
                }
                System.out.println("If you know the account number, type below otherwise you can select by typing the account name");
                String userInput = scanner.nextLine();
                try{
                    Integer accountNumber = Integer.parseInt(userInput);
                    for(BankAccount account: user.getAccounts()){
                        if (accountNumber.equals(account.getAccountNumber())){
                            currentAccount = account;
                            option(5, validated);
                            break;
                        }
                    }

                } catch(NumberFormatException e){
                    for (BankAccount account:user.getAccounts()){
                        if(userInput.equals(account.getAccountName())){
                            currentAccount = account;
                            option(5, validated);
                            break;
                        }
                    }

                }
                break;


            case 5:
                
                System.out.println("Would you like to deposit or withdraw? (1 for deposit, 2 for withdraw)");
                int userIntInput =  scanner.nextInt();
                Double amount;
                switch (userIntInput) {
                    case 1:
                    System.out.println("How much would you like to deposit? ");
                    amount = scanner.nextDouble();
                    if(currentAccount.deposit(amount)){
                        System.out.println(amount + " has been successfully deposited into account: " + currentAccount.getAccountName());
                    }
                    else{
                        System.out.println(amount + " has not been successfully deposited into account: " + currentAccount.getAccountName());

                    }
                    break;
                    case 2:
                    System.out.println("How much would you like to withdraw? ");
                    amount = scanner.nextDouble();
                    if(currentAccount.withdraw(amount)){
                        System.out.println(amount + " has been successfully deposited into account: " + currentAccount.getAccountName());
                    }
                    else{
                        System.out.println(amount + " has not been successfully deposited into account: " + currentAccount.getAccountName());

                    }
                    break;
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

    public boolean sanitizeUsername(String str){
        if(Pattern.matches("A-Za-z0-9", str)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean sanitzePassword(String str){
        if(Pattern.matches("A-Za-z0-9!@#$%^&*.?", str)){
            return true;
        }
        else{
            return false;
        }
    }


    public static void main(String[] args) throws Exception {
    
    }
}
