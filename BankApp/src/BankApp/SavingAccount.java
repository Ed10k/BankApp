package BankApp;
import java.math.BigDecimal;
import java.util.Random;
/*
 * This class is an implementation of a savings account.
 * It implements the BankAccount interface
 * 
 * 
 * March 16: Joe Edozie modified this code to include getters and setters for the variables accoutName and accountType 
 * I did this for the main method and i need to be able to sort through the list of accounts held by a single user 
 * either by account name or account type. 
 *
 */
public class SavingAccount implements BankAccount {
    /*
     * Rules:
     * OBJ01-J. Limit accessibility of fields
     * OBJ10-J. Do not use public static nonfinal fields
     * 
     * NUM02-J. Ensure that division and remainder operations do not result in divide-by-zero errors
     * NUM04-J. Do not use floating-point numbers if precise computation is required
     * NUM07-J. Do not attempt comparisons with NaN
     * 
     * ERR08-J. Do not catch NullPointerException or any of its ancestors
     * 
     * VNA00-J. Ensure visibility when accessing shared primitive variables
     * VNA02-J. Ensure that compound operations on shared variables are atomic
     * 
     * STR01-J. Do not assume that a Java char fully represents a Unicode code point
     * 
     * MET05-J. Ensure that constructors do not call overridable methods
     * 
     * EXP00-J. Do not ignore values returned by methods
     */

    //private, class level variables
    // OBJ01-J
    // OBJ10-J
    private final static int routingNumber = 8675309;
    private final double interestRateMin = 0.04;
    private BigDecimal interestRate = new BigDecimal("0.045"); //BigDecimal replaces floating point - NUM04-J
    private int accountNumber;
    private BigDecimal balance;
    private String accountHolder;
    private String accountName ;
    private String accountType;
    private volatile boolean accountOpen = false; //volatile ensures this variable is visible to all threads - VNA00-J

    /*
     * default constructor
     * 
     * @param - none
     * @return - void
     */


    
    public SavingAccount()
    {

    }

    /*
     * non-default constructor. Allows user to create account with given name
     * sets accountOpen to the success of the openAccount method
     * 
     * @param String accountHolderName: the name of the account holder
     * @return - void
     */
    public SavingAccount (String accountHolderName, String accountType, String accountName)
    {
        accountOpen = openAccount(accountHolderName, accountType, accountName); //instructor calls a non-overridable method - MET05-J
        //return value is used to update another variable - EXP00-J
    }


    
    public final boolean openAccount(String accountHolderName, String accountType, String accountName){
        if(accountHolderName == null) //NullPointerException is not thrown - ERR08-J
        {
            return false;
        }
        balance = new BigDecimal("0.0");
        accountHolder = accountHolderName;
        setAccountName(accountName);
        setAccountType(accountType);
        accountNumber = generateAccountNumber(accountHolderName);
        toggleAccountOpen();

        return true;
    }

    public boolean closeAccount(){
        if(accountOpen)
        {
            if(balance.doubleValue() < 0)
            {
                return false;
            }
            toggleAccountOpen();
            return true;
        }
        
        return false;
    }

    public boolean withdraw(double amount){
        if(accountOpen)
        {
            if(amount < 0)
            {
                return false;
            }

            BigDecimal withdrawalAmount = new BigDecimal(amount);
            balance = balance.subtract(withdrawalAmount);

            if(balance.doubleValue() >= 0)
            {
                return true;
            }
            return false;
        }
        return false;
        
    }

    public void setAccountName(String accountName){
        this.accountName = accountName;

    }

    public String getAccountName(){
        return accountName;

    }

    public void setAccountType(String accountType){
        this.accountType = accountType;
    }

    public String getAccountType(){
        return accountType;
    }

    public boolean deposit(double amount){
        if(accountOpen)
        {
            if(amount < 0)
            {
                return false;
            }
            
            BigDecimal depositAmount = new BigDecimal(amount);
            balance = balance.add(depositAmount);

            if(balance.doubleValue() >= 0)
            {
                return true;
            }
            return false;
        }
        return false;
    }
    
    /*
     * This method is a private helper method for generating a random account number. It instantiates a random integer.
     * The accountHolderName is looped through. The characters are converted into ints and added together. This sum
     * is added to a random integer and the result is the account number.
     * 
     * This method is not in the interface as interfaces cannot have private methods.
     * 
     * @param - String accountHolderName: the current name of the account holder used for determining account number
     * @return - int: the resulting account number
     */
    private int generateAccountNumber(String accountHolderName)
    {   
        int newAccountNumber = 0;
        Random rand = new Random();
        int randomNum = rand.nextInt(1000) + 500;
        for(int i = 0; i< accountHolderName.length(); i++)
        {
            newAccountNumber += accountHolderName.codePointAt(i); //compensates for all unicode - STR01-J
        }
        newAccountNumber *= randomNum;
        return newAccountNumber;
    }

    public double checkBalance()
    {
        return balance.doubleValue();
    }

    public String getAccountHolder()
    {
        return accountHolder;
    }

    public void setAccountHolder(String newAccountHolder)
    {
        accountHolder = newAccountHolder;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public int getRoutingNumber()
    {
        return routingNumber;
    }

    public double getInterestRate()
    {
        return interestRate.doubleValue();
    }

    public boolean setInterestRate(double newRate)
    {
        if(newRate >= interestRateMin)
        {   
            BigDecimal newInterestRate = new BigDecimal(newRate);
            interestRate = newInterestRate;
            return true;
        }
        return false;
    }

    /*
     * method that returns the current open status of the bank account
     * 
     * This method is marked as synchronized to comply with security rules and ensure visibility across threads.
     * This was not declared in the interface as interfaces cannot have synchronized methods.
     * 
     * @param - none:
     * @return - boolean: the open status
     */
    public synchronized boolean getAccountOpen() //synchronized method - VNA02-J
    {
        return accountOpen;
    }

    /*
     * method that toggles the current open status of the bank account
     * 
     * This method is marked as synchronized to comply with security rules and ensure visibility across threads.
     * This was not declared in the interface as interfaces cannot have synchronized methods.
     * 
     * @param - none:
     * @return - void
     */
    private synchronized void toggleAccountOpen()
    {
        accountOpen ^= true;
    }

    public double calcAmountGainedWithInterest()
    {

        if(interestRate.doubleValue() == 0.0) //checks if interest rate is zero - NUM02-J
        {
            return balance.doubleValue();
        }

        //multiplying a value is equal to dividing by the reciprocal
        balance = balance.add(new BigDecimal(balance.doubleValue() / (1/interestRate.doubleValue())));
        try{
            if(!verifyDoubleValue(balance.doubleValue())){
                throw new Exception();
            }
        } catch(Exception e){

        }
        return(balance.doubleValue());
    }

    public boolean verifyDoubleValue(double db){
        try{
            Double.isNaN(db);
            Double.isFinite(db);
        } catch(Exception e){
            return false;
        }
        return true;
    }
}
