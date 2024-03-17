import java.util.ArrayList;
import java.util.List;

public class BankUser {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int age;
    private List<BankAccount> accounts;

    public BankUser(String firstName, String lastName, int age, String username, String password) {

        this.firstName = Verification.normalizeString(firstName);
        this.lastName = Verification.normalizeString(lastName);
        this.username = Verification.normalizeString(username);
        this.age = age;
        this.accounts = new ArrayList<>();
    }

    public void setUsername(String username){
        this.username = username;
        
    }
    
    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        Verification.verifyPassword(this);
        Verification.normalizeString(password);
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }

    public void setFirstName(String firstName) {
        Verification.normalizeString(firstName);
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        Verification.normalizeString(lastName);
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