package Icons;

import User.Vehicle;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SetIcons implements java.io.Serializable
{
	GoIcons goIcons = new GoIcons();
	private String vehicleType;
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

}
