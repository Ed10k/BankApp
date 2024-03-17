/*CON51-J. Do not assume that the sleep(), yield(), or getState() methods provide synchronization semantics
 * Synchronization approach that declares a the incremenet method as 'Synchronized' to ensure that all changes
 * are published to all threads
 */
public class CON51 {

    private int count = 0;

    public void increment(){
        count++; //without synchronization, this is unsafe

    }

    public synchronized void incremented(){
        count++; // This is safe because of synchronization
    }

    public int print(){
        return count;
    }

    public static void main(String[] args) throws InterruptedException{
        CON51 example  = new CON51();
        Thread thread = new Thread(()-> {
            example.incremented();
            System.out.println(example.print());

        });
        thread.start();
        thread.join();

    }

    
}
