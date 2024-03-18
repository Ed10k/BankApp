
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;

/**
 * @author Joseph Edozie
 * @author Ian Gowland
 */

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

    private BankUser currentUser = null;

    private BankAccount currentAccount = null;

    @SuppressWarnings("null")
    public boolean option(int choice, boolean validate) throws NumberFormatException {
        boolean valid = false;
        String username = null;
        String password = null;
        BankUser user = null;
        @SuppressWarnings("unused")
        List<BankAccount> accounts;
        boolean validated = validate;


        switch (choice) {
            case 1:
                System.out.println("Please enter your username: ");
                username = Verification.normalizeString(scanner.nextLine());
                System.out.println("Please enter your password: ");
                password = Verification.normalizeString(scanner.nextLine());
               
                if (users.containsKey(username)){
                    user = users.get(username);
                    
                    if (password.equals(user.getPassword())){
                        System.out.println("Successful log in!");
                        user = users.get(username);
                        currentUser = user;
                        valid = true;
                    } else {
                        System.out.println("The password or username you entered is incorrect, please try again.");
                    }
                } else {
                    System.out.println("No user with that username exists.");
                }
                
                break;

            case 2:
                System.out.println("Thank you for signing up with us!\n");
                System.out.println("Please enter a desired username: ");
                username = Verification.normalizeString(scanner.nextLine());
                while (users.containsKey(username)){
                    System.out.println("Sorry, that username is taken. Pick a different username:");
                    username = Verification.normalizeString(scanner.nextLine());
                }
        
                System.out.println("Please enter your first name: ");
                String firstname = Verification.normalizeString(scanner.nextLine());
                System.out.println("Please enter your last name: ");
                String lastname = Verification.normalizeString(scanner.nextLine());
                System.out.println("Please enter your age: ");
                int age = scanner.nextInt(); scanner.nextLine(); // To consume the remaining newline
                
                BankUser newUser = new BankUser(firstname, lastname, age, username, password);
                System.out.println("Please enter a password: ");
                password = Verification.normalizeString(scanner.nextLine());
                newUser.setPassword(password);
                users.put(username, newUser);
                currentUser = newUser;
                valid = true;
              
                break;
                

            case 3:
                if (currentUser == null){
                    System.out.println("Unfortunately, before you can open an account with us you must either register or log in");
                    break;
                }
                System.out.println("Would you like to add a savings or checking account? (1 for checking, 2 for savings)");
                int account_preference = scanner.nextInt();
                scanner.nextLine();
                String accountHolderName = currentUser.getFullName();
                String accountType;
                String accountName;
                
                
                switch (account_preference) {
                    
                    case 1:
                        System.out.println("What would you like to name this account?");
                        accountName = Verification.normalizeString(scanner.nextLine());
                        accountType = "Checking";
                        CheckingAccount checking = new CheckingAccount(accountHolderName, accountType, accountName);
                        System.out.println("How much money would you like to deposit?");
                        double money = scanner.nextDouble();
                        checking.deposit(money);
                        currentUser.addAccount(checking);
                        System.out.println("Thank you for choosing to open an account with us.\n");
                        break;

                        
                        
                    case 2: 
                        System.out.println("What would you like to name this account?");
                        accountName = Verification.normalizeString(scanner.nextLine());
                        accountType = "Savings";
                        SavingAccount savings = new SavingAccount(accountHolderName, accountType, accountName);
                        System.out.println("How much money would you like to deposit?");
                        money = scanner.nextDouble();
                        scanner.nextLine();
                        savings.deposit(money);
                        currentUser.addAccount(savings);
                        System.out.println("Thank you for choosing to open an account with us.\n");
                        break;
                
                    default:
                    System.out.println("Invalid choice.");
                        break;
                        
        
                }
                break;
            case 4:
                ///////////////////////////////
                if(currentUser == null) {
                    System.out.println("You have not signed up yet. Please sign up first.");
                    break;
                }
                ///////////////////////////////

                System.out.println("What account would you like to access?");
                System.out.println("If you know the account number, type below, otherwise you can select by typing the account name:");
                String userInput = scanner.nextLine();
                try{
                    Integer accountNumber = Integer.parseInt(userInput);
                    for(BankAccount account: currentUser.getAccounts()){
                        if (accountNumber.equals(account.getAccountNumber())){
                            currentAccount = account;
                            option(5, validated);
                            break;
                        }
                    }

                } catch(NumberFormatException e){
                    for (BankAccount account: currentUser.getAccounts()){
                        if(userInput.equals(account.getAccountName())){
                            currentAccount = account;
                            option(5, validated);
                            break;
                        }
                    }

                }
                break;


            case 5:
                ///////////////////////////////
                if(currentUser == null) {
                    System.out.println("You have not signed up yet. Please sign up first.");
                    break;
                }
                ///////////////////////////////
                
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
                        System.out.println("Invalid choice.");
                        break;
                }
                break;
            case 6:

                if (currentUser == null) {
                    System.out.println("You need to be logged in to close an account.");
                    break;
                }
                System.out.println("Please enter the name of the account you wish to close: ");
                String accountToClose = scanner.nextLine();
                boolean found = currentUser.getAccounts().removeIf(account -> account.getAccountName().equals(accountToClose));
                if (found) {
                    System.out.println("Account closed successfully.");
                } else {
                    System.out.println("Account not found.");
                }
                break;
            case 7:
                if (currentUser == null) {
                    System.out.println("You need to be logged in to view account balances.");
                    break;
                }
                System.out.println("Your account balances are:");
                currentUser.getAccounts().forEach(account -> System.out.println(account.getAccountName() + ": " + account.checkBalance()));
                break;

            case 8:
                if (currentUser == null) {
                    System.out.println("You must log in to transfer funds.");
                    break;
                }
                System.out.println("Enter the source account name:");
                String sourceAccountName = scanner.nextLine();
                System.out.println("Enter the destination account name:");
                String destinationAccountName = scanner.nextLine();
                System.out.println("Enter the amount to transfer:");
                double transferAmount = scanner.nextDouble();
                // Find accounts
                BankAccount sourceAccount = currentUser.getAccounts().stream()
                                                    .filter(account -> account.getAccountName().equals(sourceAccountName))
                                                    .findFirst().orElse(null);
                BankAccount destinationAccount = currentUser.getAccounts().stream()
                                                        .filter(account -> account.getAccountName().equals(destinationAccountName))
                                                        .findFirst().orElse(null);
                // Perform transfer
                if (sourceAccount != null && destinationAccount != null && sourceAccount.withdraw(transferAmount)) {
                    destinationAccount.deposit(transferAmount);
                    System.out.println("Transfer successful.");
                } else {
                    System.out.println("Transfer failed.");
                }
                break;


            case 9:
                if (currentUser == null) {
                    System.out.println("You need to be logged in to update your information.");
                    break;
                }
                System.out.println("What information would you like to update? (1 for password, 2 for name)");
                int updateChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (updateChoice) {
                    case 1:
                        System.out.println("Enter your new password:");
                        String newPassword = scanner.nextLine();
                        currentUser.setPassword(newPassword);
                        System.out.println("Password updated successfully.");
                        break;
                    case 2:
                        System.out.println("Enter your new first name:");
                        String newFirstName = scanner.nextLine();
                        System.out.println("Enter your new last name:");
                        String newLastName = scanner.nextLine();
                        currentUser.setFirstName(newFirstName);
                        currentUser.setLastName(newLastName);
                        System.out.println("Name updated successfully.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                break;

            case 10:
                if (currentUser == null) {
                    System.out.println("You must log in to apply interest to an account.");
                    break;
                }
                System.out.println("Select the account to apply interest:");
                String interestAccountName = scanner.nextLine();
                BankAccount interestAccount = currentUser.getAccounts().stream()
                                                .filter(account -> account.getAccountName().equals(interestAccountName))
                                                .findFirst().orElse(null);
                if (interestAccount != null) {
                    double interestGained = interestAccount.calcAmountGainedWithInterest();
                    interestAccount.deposit(interestGained);
                    System.out.println("Interest applied. Amount gained: " + interestGained + ". New balance: " + interestAccount.checkBalance());
                } else {
                    System.out.println("Account not found.");
                }
                break;

            case 11:
                if (currentUser == null) {
                    System.out.println("Please log in to update the interest rate of an account.");
                    break;
                }
                System.out.println("Which account's interest rate would you like to update?");
                String rateAccountName = scanner.nextLine();
                BankAccount rateAccount = currentUser.getAccounts().stream()
                                            .filter(account -> account.getAccountName().equals(rateAccountName))
                                            .findFirst().orElse(null);
                if (rateAccount != null) {
                    System.out.println("Current interest rate: " + rateAccount.getInterestRate() + ". Enter the new interest rate:");
                    double newRate = scanner.nextDouble();
                    if (rateAccount.setInterestRate(newRate)) {
                        System.out.println("Interest rate updated to " + newRate + ".");
                    } else {
                        System.out.println("Failed to update interest rate. Ensure the new rate is within the allowed range.");
                    }
                } else {
                    System.out.println("Account not found.");
                }
                break;
        
        
            case 12:
                if (currentUser == null) {
                    System.out.println("You must log in to view account details.");
                    break;
                }
                System.out.println("Enter the name of the account you wish to view details for:");
                String detailAccountName = scanner.nextLine();
                BankAccount detailAccount = currentUser.getAccounts().stream()
                                                .filter(account -> account.getAccountName().equals(detailAccountName))
                                                .findFirst().orElse(null);
                if (detailAccount != null) {
                    System.out.println("Account Holder: " + detailAccount.getAccountHolder());
                    System.out.println("Account Number: " + detailAccount.getAccountNumber());
                    System.out.println("Routing Number: " + detailAccount.getRoutingNumber());
                    System.out.println("Account Type: " + detailAccount.getAccountType());
                    System.out.println("Balance: " + detailAccount.checkBalance());
                    System.out.println("Interest Rate: " + detailAccount.getInterestRate());
                } else {
                    System.out.println("Account not found.");
                }
                break;
            
            
            default:
            System.out.println("Invalid choice");
                break;
        }

        return valid;
    }


    public void menu() {
        boolean isOn = true;
        boolean validated = false;
        int userChoice;
        System.out.println("Hello, welcome to the Banking App\nWhat action would you like to perform?");
    
        while (isOn) {
            System.out.println("\nPlease select an option:");
            System.out.println("1 - Log in");
            System.out.println("2 - Sign up");
            System.out.println("3 - Open a new account");
            System.out.println("4 - Access an existing account");
            System.out.println("5 - Deposit/Withdraw");
            System.out.println("6 - Close an account");
            System.out.println("7 - View account balances");
            System.out.println("8 - Transfer funds between accounts");
            System.out.println("9 - Update personal information");
            System.out.println("10 - Apply interest to an account");
            System.out.println("11 - Update the interest rate of an account");
            System.out.println("12 - View account details");
            System.out.println("0 - Exit");
            
            System.out.print("\nPlease select an option:");
            userChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
    
            if (userChoice == 0) {
                System.out.println("Thank you for using the Banking App. Goodbye!");
                isOn = false;
            } else {
                // This assumes that logging in (option 1) correctly sets 'validated' to true upon successful login.
                validated = option(userChoice, validated);
            }
        }
    }
    


    public static void main(String[] args) throws Exception {
        //Instance of the BankApp
        BankApp bank = new BankApp();
        bank.menu();
    }
}