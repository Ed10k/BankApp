public class VNA05 {
    /* VNA05-J. Ensure atomicity when reading and writing 64-bit values.
	Java allows 64-bit long and double values to be treated as two 32-bit values. 
    So reading a 64-bit operation can be read as two individual 32-bit operations
    */ 

    /* "l" is declared volatiles because it lets the program know it will be modified by different threads
     * The "volatile" declaraton ensures that the value is read and written from 
     * main memory and not the local cache. So, changes made by one thread are visible
     * by all threads.
     */
    private volatile long l = -1;

    void assign(long j){
        l = j;

    }
    void print(){
        System.out.println("l = "  + l);

    }
    
}

