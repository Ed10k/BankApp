/* Safe example using volatile 
 * the statement 'volatile' is used to make sure that changes to the object is seen by every
 * thread but it is important to note that mutable object shared between threads need to utilize 
 * synchronization blocks or concurrency mechanisms like 'AtomicReference'
 */
public final class CON50{

    //This class serves as immutable data for the example 
    private final int value;

    public CON50(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

}

class SafePublicationExample{

    private volatile CON50 data;

    public void updateData(int newValue){
        this.data = new CON50(newValue);
    }

    public int readData(){
        CON50 localData = this.data;
        if (localData != null){
            return localData.getValue();
        }
        return -1;
    }

    public static void main(String[] args) throws InterruptedException {
        SafePublicationExample example = new SafePublicationExample();

        Thread writer = new Thread(()-> {
            System.out.println(example.readData());
        });

        Thread reader = new Thread(()-> {
            System.out.println(example.readData());
        });

        writer.start();
        writer.join();

        reader.start();
        reader.join();
        

    }



}