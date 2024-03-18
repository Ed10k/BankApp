public Class FIO14
{

    /*
     * Program to demostrate proper file clearup before termination as suggested
     * by FIO14-J. 
     */
    public void properTermination()
    {
        try
        {
            PrintWriter outfile = new PrintWriter("test.txt");
            outfile.println("this is a test.");

        }catch(FileNotFoundException e)
        {
            System.out.println("cannot create file.");
        }
        finally{
            outfile.close()
        }
        exit(1);
    }
}