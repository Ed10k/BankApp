/* THI05-J. Do not use Thread.stop() to terminate threads	
    Thread.stop() is a deprecated method that belongs in the 
    java.lang.RuntimePermission API. It allows the user to terminate 
    a thread instantaneously and immediately throws a ThreadDeath exception. 
 *
 *  This example uses a volatile boolean flag called 'running' to control
 * the execution. It ensures that the thread can complete its current work and
 * release the resources safely
 */

public class THI05 implements Runnable {

    //using the volatile flag to show whether a thread should run
    private volatile boolean running = true;

    public void run(){
        while (running){
            System.out.println("The thread is now running");


            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("The thread is stopping...");
    }

    public void stopRunning(){
        running = false;
    }
    
    public static void main(String[] args) throws InterruptedException {
        THI05 task = new THI05();
        Thread thread = new Thread(task);

        thread.start();
        Thread.sleep(5000);
        task.stopRunning();;
        thread.join();
        System.out.println("The thread has stopped");
    }
}
