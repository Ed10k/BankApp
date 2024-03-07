/*
 * Use classes to encapsulate account information, ensuring that sensitive data is private and accessed through getters and setters that perform validation (OBJ02-J, OBJ03-J). 

Prevent heap pollution by using generics with specific types for account collections (OBJ03-J). 

Avoid using public static nonfinal fields, ensuring that account information is not globally accessible or modifiable (OBJ10-J). 
 */

 /*
  * OBJ01-J. Limit accessibility of fields
    OBJ02-J. Preserve dependencies in subclasses when changing superclasses
    OBJ03-J. Prevent heap pollution
    OBJ10-J. Do not use public static nonfinal fields
  */

/*
 * This is the BankAccount interface that will be implemented in a checking account and savings account
 */
public interface BankAccount {
    /*
     * method that instantiates variables when opening account for first time
     * @param - String accountHolderName: the name of the person holding the account. False indicates a null name
     * @return - boolean: indicates success of operation
     * precondition: an account doesn't exist
     * postcondition: an account is ready to use
     */
    public boolean openAccount(String accountHolderName);

     /*
     * method that deactivates account when user wishes to close
     * @param - none
     * @return - boolean: indicates success of operation
     * precondition: an account must exist
     * postcondition: account is deactivated
     */
    public boolean closeAccount();

     /*
     * method that withdrawals a certain amount from the bank account
     * @param - double amount: the amount the user wishes to withdrawal
     * @return - boolean: indicates success of operation. False indicates negative balance or negative widrawal amount
     * precondition: an account must exist
     * postcondition: balance is subtracted by the amount entered
     */
    public boolean withdraw(double amount);

    /*
     * method that deposits a certain amount to the bank account
     * @param - double amount: the amount the user wishes to deposit
     * @return - boolean: indicates success of operation. False indicates negative balance or negative deposit amount
     * precondition: an account must exist
     * postcondition: amount entered is added to balance
     */
    public boolean deposit(double amount);

     /*
     * method that checks the balance of the account
     * @param - none:
     * @return - double: the balance on the account
     * precondition: an account must exist
     * postcondition: balance is returned
     */
    public double checkBalance();
    
}


