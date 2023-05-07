package Exception;

/**
 * This class is used to throw an exception when the database is empty
 * @see Exception
 */
public class EmptyDatabase extends Exception // This class is used to throw an exception when the database is empty
{
	/**
	 * This method is used to throw an exception when the database is empty
	 * @param message This is the message that will be displayed when the exception is thrown
	 */
	public EmptyDatabase(String message) // This method is used to throw an exception when the database is empty
	{
		super(message);
	}
}
