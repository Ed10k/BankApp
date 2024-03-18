/*
 * class to demonstrate a solution to NUM09. Instead of using floating point numbers for a for loop
 * integers should be used as floating points will not be exact and may cause extra iterations
 */
public class NUM09
{
    public void noFloatLoops()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println(i);
        }
        return;
    }
}