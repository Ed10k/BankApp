/* @author Matthew Fonner
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
    public boolean openAccount(String accountHolderName, String accountType, String accountName);

     /*
     * method that deactivates account when user wishes to close
     * @param - none
     * @return - boolean: indicates success of operation
     */
    public boolean closeAccount();


     /*
     * method that withdrawals a certain amount from the bank account
     * @param - double amount: the amount the user wishes to withdrawal
     * @return - boolean: indicates success of operation. False indicates negative balance or negative widrawal amount
     */
    public boolean withdraw(double amount);

    /*
     * method that deposits a certain amount to the bank account
     * @param - double amount: the amount the user wishes to deposit
     * @return - boolean: indicates success of operation. False indicates negative balance or negative deposit amount
     */
    public boolean deposit(double amount);

     /*
     * method that checks the balance of the account
     * @param - none:
     * @return - double: the balance on the account
     */
    public double checkBalance();

    /*
     * method that returns the current name of the account holder
     * @param - none:
     * @return - String: the name of the account holder
     */
    public String getAccountHolder();

    /*
     * method that sets the current name of the account holder
     * @param - String newAccountHolder: the new account holder's name to be set
     * @return - void
     */
    public void setAccountHolder(String newAccountHolder);

    /*
     * method that returns the current account number.
     * There is no 'set' method as the account number cannot be changed upon object creation.
     * 
     * @param - none:
     * @return - int: the account number
     */
    public int getAccountNumber();

    /*
     * method that returns the current routing number.
     * There is no 'set' method as the routing number cannot be changed upon object creation.
     * 
     * @param - none:
     * @return - int: the routing number
     */
    public int getRoutingNumber();

    /*
     * method that returns the current interest rate of the bank account.
     * 
     * @param - none:
     * @return - double: the interest rate
     */
    public double getInterestRate();
    
    /*
     * method that sets the current name of the account
     * @param - String accountName: the new account name to be set
     * @return - void
     */
    public void setAccountName(String accountName);

    /*
     * method that returns the current name of the bank account.
     * 
     * @param - none:
     * @return - String: the account name
     */
    public String getAccountName();

    /*
     * method that sets the current type of the account
     * @param - String accountType: the new account type to be set
     * @return - void
     */
    public void setAccountType(String accountType);

    /*
     * method that returns the current type of the bank account.
     * 
     * @param - none:
     * @return - String: the account type
     */
    public String getAccountType();

    /*
     * method that sets the current interest rate. Must be in specified range dictated by type of account
     * @param - double newRate: the new rate to be set
     * @return - boolean: indicating success of operation. False if outside specified range
     */
    public boolean setInterestRate(double newRate);

    /*
     * method that calculates how much is added to the balance with the current interest rate. Updates balance after operation.
     * 
     * @param - none:
     * @return - double: the resulting balance after the calculation
     */
    public double calcAmountGainedWithInterest();
    
}


