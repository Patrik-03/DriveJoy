package Icons;

/**
 * This class is used to set the icons for the vehicles
 * @see GO
 */
public class GoIcons implements GO //icons for the vehicles class implements GO interface
{
	private String lambo;
	private String cabrio;
	private String scooter;
	private String motorbike;
	/**
	 * This is the constructor for the class
	 */
	public GoIcons()
	{

	}
	/**
	 * This method is used to set the icons for the vehicles
	 * @param type This is the type of the vehicle
	 */
	public void checkType(String type) //check the type of the vehicle
	{
		if(type.equals("Car"))
		{
			setLambo();
			setCabrio();
		}
		else if(type.equals("Motorbike"))
		{
			setScooter();
			setMotorbike();
		}
	}
	/**
	 * This method is used to get the icon for the vehicle
	 * @return String This returns the icon for the vehicle
	 */
	public String getLambo() //get the icon for the vehicle
	{
		return lambo;
	}
	/**
	 * This method is used to set the icon for the vehicle
	 */
	public void setLambo() //set the icon for the vehicle
	{
		this.lambo = "lambo.png";
	}
	/**
	 * This method is used to get the icon for the vehicle
	 * @return String This returns the icon for the vehicle
	 */
	public String getCabrio() //get the icon for the vehicle
	{
		return cabrio;
	}
	/**
	 * This method is used to set the icon for the vehicle
	 */
	public void setCabrio() //set the icon for the vehicle
	{
		this.cabrio = "cabrio.png";
	}
	/**
	 * This method is used to get the icon for the vehicle
	 * @return String This returns the icon for the vehicle
	 */
	public String getScooter() //get the icon for the vehicle
	{
		return scooter;
	}
	/**
	 * This method is used to set the icon for the vehicle
	 */
	public void setScooter() //set the icon for the vehicle
	{
		this.scooter = "scooter.png";
	}
	/**
	 * This method is used to get the icon for the vehicle
	 * @return String This returns the icon for the vehicle
	 */
	public String getMotorbike() //get the icon for the vehicle
	{
		return motorbike;
	}
	/**
	 * This method is used to set the icon for the vehicle
	 */
	public void setMotorbike() //set the icon for the vehicle
	{
		this.motorbike = "motorbike.png";
	}
	/**
	 * This method is used to randomize the icon for the vehicle
	 *
	 * @param type This is the type of the vehicle
	 * @return String This returns the icon for the vehicle
	 */
	public String random(String type) //randomize the icon for the vehicle
	{
		if(type.equals("Car"))
		{
			int random = (int) (Math.random() * 2);
			if(random == 0)
			{
				return getLambo();
			}
			else
			{
				return getCabrio();
			}
		}
		else if(type.equals("Motorbike"))
		{
			int random = (int) (Math.random() * 2);
			if(random == 0)
			{
				return getScooter();
			}
			else
			{
				return getMotorbike();
			}
		}
		else
		{
			return null;
		}
	}
}