/*•	Documenting thread-safety and using annotations to describe how a program works.
 This information is also available to the compiler, analyzer, JVM, and debugger.
 * 
 */

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class CON52 {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadSafeCounter counter = new ThreadSafeCounter();
        int numberOfThreads = 10;
        Thread[] threads = new Thread[numberOfThreads];

        // Create and start threads
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        counter.increment();
                    }
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i].join();
        }

        // Print the final count value
        System.out.println("Final count: " + counter.getCount());
    }
}
