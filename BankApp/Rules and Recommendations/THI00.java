/*
Thread.run() works by telling the current thread to perform the task at hand.
The issue with invoking Thread.run() is that because it using the current thread to perform the task, 
you are not able to work on other tasks, defeating the entire purpose of threading
to begin with. You want to use Thread.start() to perform the task
so that you can focus on other tasks. Also, if you have a subclass of Thread, 
unless the .run() method is overridden, nothing will happen. 
* 
*/

public class THI00 implements Runnable{
    @Override
    public void run(){
        for (int i = 1; i<5; i++){
            System.out.println("Number: " + i + " - " + Thread.currentThread().getName());
            try{
                Thread.sleep(100); // simulates "work being done"
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args){
        Runnable task = new THI00();
        Thread thread = new Thread(task);

        //This is the proper way to start a thread thart calls the run() method in the context of a new thread 
        thread.start();

        System.out.println("This line is executed by the main thread: " + Thread.currentThread().getName());
    }

}