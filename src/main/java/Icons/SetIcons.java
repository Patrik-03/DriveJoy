package Icons;

import User.Vehicle;

import java.io.*;

/**
 * This class is used to set the icons for the vehicles
 * @see java.io.Serializable //set the icons for the vehicles
 */
public class SetIcons implements java.io.Serializable
{
	/**
	 * This is the type of the vehicle
	 */
	private String vehicleType;
	/**
	 * This is the interface for setting icons
	 */
	GO go = new GoIcons(); // Interface for setting icons
	/**
	 * This method is used to set the icons for the vehicles
	 * @param vehicle the vehicle
	 * @throws IOException if the input or output is invalid
	 * @throws ClassNotFoundException if the class is not found
	 */
	public SetIcons(Vehicle vehicle) throws IOException, ClassNotFoundException //set the icons for the vehicles
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bos);
		out.writeObject(vehicle.getType());
		out.flush();
		out.close();

		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream in = new ObjectInputStream(bis);
		setVehicleType((String) in.readObject());
		in.close();
	}
	/**
	 * This method is used to get the type of the vehicle
	 * @return the type of the vehicle
	 */
	public String getVehicleType() //get the type of the vehicle
	{
		return vehicleType;
	}
	/**
	 * This method is used to set the type of the vehicle
	 * @param vehicleType the type of the vehicle
	 */
	public void setVehicleType(String vehicleType) //set the type of the vehicle
	{
		this.vehicleType = vehicleType;
	}
	/**
	 * This method is used to set the icons for the vehicles
	 * @see GO
	 */
	public void setIcons() //set the icons for the vehicles
	{
		go.checkType(vehicleType);
	}
	/**
	 * This method is used to get the icon for the vehicles
	 * @return the icon for the vehicles
	 */
	public String getIcon() //get the icon for the vehicles
	{
		return go.random(getVehicleType());
	}
}
