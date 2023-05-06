package GUI;

public interface Alert
{
	String ERROR = "ERROR";
	void display(String message);
	default void alert()
	{
		display(ERROR);
	}
}
