public class BankApp {
    public static void main(String[] args) throws Exception {
        CheckingAccount ca = new CheckingAccount();
        ca.openAccount("bob");
        System.out.println("Hello, World!");
    }
}
