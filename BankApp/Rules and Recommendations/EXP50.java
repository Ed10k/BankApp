public class EXP50
{
    /*
     * Recommendation EXP50. Distinguishes by using the equals method to compare the strings rather
     * than using == which would check their references.
     */
    public static void main(String [] args)
    {
        String str1="Grant";
        String str2="Grant";
        if(str1.equals(str2))
        {
            //stuff 
        }
    }
}