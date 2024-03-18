/*THI02-J. Notify all waiting threads rather than a single thread.
•Always call wait() and await() methods inside of a loop. 
Threads can only resume if their condition predicates prove to be true 
and they receive these notifications through the wait() and await() invocations.

This is a class designed to use the wait() function inside of a loop to ensure 
that the put and get methods only proceed when thier respective conditions are met. 
The notify method is used to wake the other thread once an action is completed.
 */

public class THI02{
    private int contents;
    private boolean available = false;

    public synchronized void put(int value){
        while (available){
            try {
                wait();
            }
            catch(InterruptedException e){}
        }
        contents = value;
        available = true;
        notify(); // This correctly notifies the conusmer that something has been put
    }

    public synchronized int get(){
        while(!available){
            try{
                wait();
            } catch (InterruptedException e){}
        }
        available = false;
        notify(); // This notifies the consumer that something has been taken
        return contents;

    }


}