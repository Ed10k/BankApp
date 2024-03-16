public class BankApp {
    public static void main(String[] args) throws Exception {
        BankAccount myAccount = new CheckingAccount(); //Changed to BankAccount interface 
        myAccount.openAccount("bob");
        System.out.println("Hello, World!");
    }
}
