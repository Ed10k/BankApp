
/*
 * Compliant with SEC04-J. Sensitive operations should be checked with the security manager.
 */
public class SEC04J
{
    private HashMap<String,String> map;
    public void remove(String sentence)
    {
        SecurityManager sm=System.getSecurityManager();
        if(sm!=null)
        {
            sm.checkSecurityAccess("removeKeyPermission");
            map.remove(sentence);
        }
    }
}