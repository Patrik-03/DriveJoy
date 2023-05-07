package Exception;

/**
 * This class is used to throw an exception when the id is wrong
 * @see Exception
 */
public class WrongIdException extends Exception // This class is used to throw an exception when the id is wrong
{
	/**
	 * This method is used to throw an exception when the id is wrong
	 * @param message This is the message that will be displayed when the exception is thrown
	 */
	public WrongIdException(String message) // This method is used to throw an exception when the id is wrong
	{
		super(message);
	}
}
