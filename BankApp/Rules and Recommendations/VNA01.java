public class VNA01 {

    /*  
    VNA01: Ensure visibility when accessing shared primitive variables
    Since threads work independently of each other,
    reading a value of a variable in one thread may not
    be the most updated version of that 
    ame variable that was written to in another thread. 

    counter example 
    - synchronization
    */

    private int counter =0;
    private volatile int counter2 =0;

    public void increment(){
    counter++;
    counter2++;
    }

    public int getCounter(){
        return counter;
    }
    public int getCounter2(){
        return counter2;
    }

    public static void main(String[] args) throws InterruptedException {
        VNA01 example = new VNA01();

        Thread t1 = new Thread(() ->{
            for (int i = 0; i<100; i++){
                example.increment();
            }
        });

        Thread t2 = new Thread(()->{try{
            Thread.sleep(50); // Waits for t1 to do some incrementing 
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Counter value (without volatile): " + example.getCounter());
        System.out.println("Counter value (with): " + example.getCounter2());
        

        
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    



    }
}
