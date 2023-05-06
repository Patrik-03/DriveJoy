package Editor;

import java.io.FileWriter;

public class AddRoutes
{
	public void addRoute(String origin, String destination, String name, String distance, String badge, String type)
	{
		try
		{
			FileWriter writer = new FileWriter("Routes.txt", true);
			writer.write(origin + " - " + destination + " - " + name + " - " + distance + " - " + badge + " - " + type);
			writer.write("\n");
			writer.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
