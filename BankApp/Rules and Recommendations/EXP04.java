/*
 * Class to demonstrate rule EXP04. Specifies the Integer type cast within the loop to avoid errors that would result without type casting.
 * Remove would not work if i was not typecasted. 
 */
public class EXP04
{
    public static void main(String{} args)
    {
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        for(int i=0;i<10;i++)
        {
            map.put((Integer)i,"1");
            map.remove((Integer)i);
        }
        System.out.println(map.size());
    }
}