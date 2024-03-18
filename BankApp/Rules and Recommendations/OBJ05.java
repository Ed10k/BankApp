public class OBJ05
{
    HashMap<int,int> map;

    OBJ05()
    {
        map = new HashMap<int,Int>();
    }


    /*
     * Method to return the clone of a private class member. Failure to do so allows the mutable member to be exposed.
     * @return clone of map 
     */
    HashMap getMap()
    {
        return (HashMap)map.clone();
    }
}