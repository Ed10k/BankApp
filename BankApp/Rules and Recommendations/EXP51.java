public class EXP51
{
    /*
     * Recommendation EXP51. Do not perform assignements in conditionals. This usually only happens mistakenly and is bad practice to do assignment this way.
     */
    public int run()
    {
        int a=1;
        int b=2;
        if(a=b)
        {
            return -1;
        }
        return 0;
    }
}