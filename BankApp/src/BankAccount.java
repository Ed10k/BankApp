import java.util.Scanner;
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
public class BankAccount {
    private String accountHolder;
    
    private double balance;

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double newBalance)
    {
        balance = newBalance;
    }

    public String getAccountHolder()
    {
        return accountHolder;
    }

    public void setAccountHolder(String newAccountHolder)
    {
        accountHolder = newAccountHolder;
    }
    
}


