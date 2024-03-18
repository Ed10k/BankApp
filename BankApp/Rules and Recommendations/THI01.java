/* Each thread that is created in Java is assigned to a threadgroup. 
When the name of the threadgroup is not specified, then it belongs to the main default group which is assigned by the JVM. 
Threadgroups allow for ‘convenience methods’ that allow the user to operate on all threads belonging to the thread group at once. 
* 
*/

//Import statements 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class THI01 {
    public static void main(String[] args) throws InterruptedException{

        // Creates an Executor service with a fixed thread pool size 
        ExecutorService executor  = Executors.newFixedThreadPool(5);

        //send multiple tasks to the executor 
        for (int i = 0; i<10; i++){
            int taskID = i;
            executor.submit(()->{
                System.out.println("Executing task " + taskID + " on thread " + Thread.currentThread().getName());
                try{
                    //Simulates the execution time 
                    TimeUnit.SECONDS.sleep(1);
                }
                catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }

            });
        }

        // invokes the shutdown method, no new tasks will be accepted but submitted tasks will be executed
        executor.shutdown();

        // Wait for all tasks to finish execution within a timeout period
        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("Some tasks were not completed within the timeout period.");

            // Attempt to stop all actively executing tasks and halt the processing of waiting tasks
            executor.shutdownNow();
        } else {
            System.out.println("All tasks completed successfully.");
        }

    }

    
}
