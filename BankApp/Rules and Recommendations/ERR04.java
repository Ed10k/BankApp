/*
 * 
 * Class to give an example of Java Rule ERR04-J. 
 * There should be no statements within a finally block that would disrupt the program. Breaks, returns, throws, etc. 
 * @return - 0 at the end of the finally block. 
 */
public class ERR04 {

	
	int example()
	{
		try
		{
			throw new ArrayIndexOutOfBoundsException();
			
		}
		finally
		{
			System.out.println("Index out of bounds.");
		}
		
		return 0;
	}
}
