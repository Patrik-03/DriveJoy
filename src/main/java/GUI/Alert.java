package GUI;

import Exception.EmptyDatabase;

/**
 * Interface for the exceptions
 */
public interface Alert
{
	/**
	 * String constant for the error message
	 */
	String ERROR_MESSAGE = "Error";

	/**
	 * Method to display the alert window
	 * @throws EmptyDatabase if the database is empty
	 * @see EmptyDatabase
	 * @see AlertBox
	 */
	default void alert() throws EmptyDatabase
	{
		AlertBox alertBox = new AlertBox();
		alertBox.display(ERROR_MESSAGE);
		throw new EmptyDatabase("Empty Database");
	}
}
