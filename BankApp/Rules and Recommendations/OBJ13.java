public class OBJ13
{
    final ArrayList<String> list;

    OBJ13()
    {
        list=new ArrayList<String>();
    }
    /*
     * Gives a solution to OBJ13, by cloning the object, we can make sure that the arraylist cannot be manipulated
     * even though it is declared final.
     * @return a clone of the ArrayList list
     */
    ArrayList<String> getList()
    {
        return (ArrayList)list.clone();
    }
}