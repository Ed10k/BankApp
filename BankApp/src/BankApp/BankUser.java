package BankApp;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.*;


import javax.crypto.spec.*;

public class BankUser {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int age;
    private List<BankAccount> accounts;
    private SecretKey sk;
    private IvParameterSpec iv;

    public BankUser(String firstName, String lastName, int age, String username, String password) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {

        this.firstName = Verification.normalizeString(firstName);
        this.lastName = Verification.normalizeString(lastName);
        this.username = Verification.normalizeString(username);
        setPassword(password);
        this.age = age;
        this.accounts = new ArrayList<>();
        setPassword(password);
    }

    public void setUsername(String username){
        this.username = username;
        
    }
    
    public String getUsername(){
        return username;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException{
        //Verification.verifyPassword(this);
        Verification.normalizeString(password);
        this.sk=BankEncrypt.makeKey(password);
        this.iv=BankEncrypt.generateIV();
        
        this.password=BankEncrypt.encrypt(password, sk, iv);
 
    }
    
    public String getPassword() throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException{
    	
        return BankEncrypt.decrypt(this.password, sk, iv);
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