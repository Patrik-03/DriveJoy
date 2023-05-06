package Icons;

import User.Vehicle;

import java.io.*;

public class SetIcons implements java.io.Serializable
{
	private String vehicleType;
	GO go = new GoIcons(); // Interface for setting icons
	public SetIcons(Vehicle vehicle) throws IOException, ClassNotFoundException
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
	public String getVehicleType()
	{
		return vehicleType;
	}
	public void setVehicleType(String vehicleType)
	{
		this.vehicleType = vehicleType;
	}
	public void setIcons()
	{
		go.checkType(vehicleType);
	}
	public String getIcon()
	{
		return go.random(getVehicleType());
	}
}
