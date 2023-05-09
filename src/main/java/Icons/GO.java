package Icons;
/**
 * Interface for GOIcons class
 * @see GoIcons
 */
public interface GO // Interface for GO class
{
	/**
	 * Method to check the type of the vehicle
	 * @param type This is the type of the vehicle
	 * @see GoIcons
	 */
	void checkType(String type); // Method to check the type of the vehicle
	/**
	 * Method to generate a random vehicle
	 * @param type This is the type of the vehicle
	 * @return String This returns the icon for the vehicle
	 */
	String random(String type); // Method to generate a random vehicle
}
