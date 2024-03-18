import java.util.ArrayList;
import java.util.List;

/*
     * Rules:
     * EXP01-J: Don’t Use a Null in a Case where an Object is Required
     * DCL61-J: Declare lists with a specified data type, not just object
     */

public class BankUser {
    private String firstName;
    private String lastName;
    private int age;
    private List<BankAccount> accounts; //DCL61-J
    private String password;

    public BankUser(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.accounts = new ArrayList<>();
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;   //EXP01-J
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setAge(int age){
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }

    public void setPassword(String password){
        this.password = password;
        
    }
    
    public String getPassword(){
        return password;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account added successfully.");
    }
}