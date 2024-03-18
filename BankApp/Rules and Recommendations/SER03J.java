import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * SER03-J. THis class implements a couple of nested classes to express the rule. The first class, Point,
 * stores instance variables of an (x,y) coordinate. These instance variables would be declared as 
 * transient. This instructs the JVM to interpret the variables as unserializable. Then the Coordinates class
 * extends Point. The main method will not serialize this object when attempting to serialize it or any 
 * fields declared as transient. 
 * 
 * @author Ian Gowland
 */

public class SER03J {


    private static class Point implements Serializable {
        private transient double x;
        private transient double y;
        /**
         * Constructor 
         * @param x - coordinate
         * @param y - coordinate
         */
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Coordinates extends Point {
        /**
         * Constructor 
         * @param x - coordinate
         * @param y - coordinate
         */
        public Coordinates(double x, double y) {
            super(x, y);
        }
    }

    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            Coordinates test = new Coordinates(3.14, 1.618);
            fos = new FileOutputStream("point.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(test);
            oos.close();
        } catch(Exception e) {
            // Handle
        } finally {
            if(fos != null) {
                try {
                    fos.close();
                } catch(IOException ioe) {
                    // Handle
                }
            }
        }
    }
}

