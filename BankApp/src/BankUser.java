import java.util.ArrayList;
import java.util.List;

public class BankUser {
    private String firstName;
    private String lastName;
    private int age;
    private List<BankAccount> accounts;

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
        return firstName;
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

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account added successfully.");
    }
}