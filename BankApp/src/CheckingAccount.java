import java.util.Random;
/*
 * This class is an implementation of a checking account.
 * It implements the BankAccount interface
 */
public class CheckingAccount implements BankAccount{
    //private, class level variables
    private final int routingNumber = 8675309;
    private final double interestRate = 0.1;
    private int accountNumber;
    private double balance;
    private String accountHolder;
    private boolean accountOpen = false;

    public boolean openAccount(String accountHolderName){
        if(accountHolderName == null)
        {
            return false;
        }
        balance = 0.0;
        accountHolder = accountHolderName;
        accountNumber = generateAccountNumber(accountHolderName);
        accountOpen = true;

        return true;
    }

    public boolean closeAccount(){
        if(accountOpen)
        {
            accountOpen = false;
            return true;
        }
        if(balance < 0)
        {
            return false;
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

            balance -= amount;
            if(balance >= 0)
            {
                return true;
            }
            return false;
        }
        return false;
        
    }

    public boolean deposit(double amount){
        if(accountOpen)
        {
            if(amount < 0)
            {
                return false;
            }
            
            balance += amount;
            if(balance >= 0)
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
            newAccountNumber += accountHolderName.charAt(i);
        }
        newAccountNumber *= randomNum;
        return newAccountNumber;
    }

    public double checkBalance()
    {
        return balance;
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
        return interestRate;
    }
}
