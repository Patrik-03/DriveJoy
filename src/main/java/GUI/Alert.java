package GUI;

import Exception.EmptyDatabase;

/**
 * Interface for the alert window
 * @see AlertBox
 */
public interface Alert //interface for the alert window
{
	/**
	 * String constant for the error message
	 */
	String ERROR_MESSAGE = "Error";

	/**
	 * Method to display the alert window
	 * @throws EmptyDatabase if the database is empty
	 */
	default void alert() throws EmptyDatabase
	{
		AlertBox alertBox = new AlertBox();
		alertBox.display(ERROR_MESSAGE);
		throw new EmptyDatabase("Empty Database");
	}
}
