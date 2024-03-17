public class VNA04{
    /* VNA04-J. Ensure that calls to chained methods are atomic.
    * Method chaining is a tool used to make multiple calls 
    * on the same object in a single statement. 
    * This mechanism consists of using methods that constantly return the ‘this’ method.
    * 
    *  User profile example 
    */

    private String name;
    private String email;
    private int age;

   
    public VNA04() {
        // This is just the constructor
    }

    // Settors

   
    public VNA04 setName(String name) {
        this.name = name;
        return this; // returns the current VNA04 object
    }

    
    public VNA04 setEmail(String email) {
        this.email = email;
        return this; // returns the current VNA04 object
    }

    
    public VNA04 setAge(int age) {
        this.age = age;
        return this; // returns the current VNA04 object
    }

    // Method to display user profile details
    public void displayProfile() {
        System.out.println("Name: " + name + ", Email: " + email + ", Age: " + age);
    }

    // Method ensuring the atomicity of chained method calls
    private final Object lock = new Object();

    public void updateProfile(String name, String email, int age) {
        synchronized (lock) {
            this.setName(name).setEmail(email).setAge(age);
        }
    }


    // Main method for testing
    public static void main(String[] args) {
        VNA04 userProfile = new VNA04();
        userProfile.updateProfile("Joseph Edozie", "Joedozi@ilstu.edu", 22);
        userProfile.displayProfile();
    }



}