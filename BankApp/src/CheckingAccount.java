import java.util.Random;

public class CheckingAccount implements BankAccount{
    private final int routingNumber = 8675309;
    private int accountNumber;
    private double balance;
    private String accountHolder;

    public boolean openAccount(String accountHolderName){
        if(accountHolderName == null)
        {
            return false;
        }
        balance = 0.0;
        accountHolder = accountHolderName;
        accountNumber = generateAccountNumber(accountHolderName);
        System.out.println(String.valueOf(accountNumber));
        return true;
    }

    public boolean closeAccount(){
        return true;
    }

    public boolean withdraw(double amount){
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

    public boolean deposit(double amount){
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

    public double checkBalance(){
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
}
