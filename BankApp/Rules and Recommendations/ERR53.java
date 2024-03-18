public class ERR53
{
    public run()
    {
        run();
    }
    /*
     * Recommendation ERR53. This will catch all throwables if we suspect there are ones that we cannot catch ourselves.
     * This will throw a stackoverflowError but if we cannot predict that we have the second catch block.
     */
    public static void main(String [] args)
    {
        try{
            run();
        }catch(StackOverflowError e)
        {
            System.out.println("Stack Overflow!");
        }
        catch(throwable t)
        {
            t.printStackTrace();
        }
    }
}