package GUI;

/**
 * Interface for the alert window
 * @see AlertBox
 */
public interface Alert //interface for the alert window
{
	/**
	 * String constant for the error message
	 */
	String ERROR = "ERROR";
	/**
	 * Display the alert window
	 * @param message the message to display
	 */
	void display(String message); //display the alert window
	/**
	 * Display the alert window
	 */
	default void alert() //default method to display the alert window
	{
		display(ERROR);
	}
}
