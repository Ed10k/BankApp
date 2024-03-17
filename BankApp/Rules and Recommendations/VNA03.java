


final public class VNA03 {
    /* VNA03-J. Do not assume that a group of calls to independently atomic methods is atomic

    * Description: You can make calls to methods that are independently atomic but that does not mean a
    * sequence of atomic calls also guarantees atomicity meaning, you must employ higher-level locking 
    * and unlocking techniques to ensure proper concurrency.
    * 

        Bank account example
    */


    private int balance;
    private final Object lock = new Object();
    
    public VNA03(int initialBalance){
        this.balance = initialBalance;
    }

    //Method that performs atomic check-then-act sequence
    public void withdrawIfPossible(int amount){
        //This block locks on a private final lock object which makes the entire sequence atomic.
        // No other thread can intervene between the balance check and withdrawal squences which prevents race conditions
        synchronized (lock){
            if(this.balance >= amount){
                balance -= amount;
                System.out.println("Withdrawn" + amount + " Remaining balance: "  + balance);

            }
            else {
                System.out.println("Insufficient balance for withdrawal");
            }
        }
    }

}

class User extends Thread{
    private VNA03 account;
    public User(VNA03 account){
        this.account = account;
    }

    public void run(){
        account.withdrawIfPossible(100);
    }

}
