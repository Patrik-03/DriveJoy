package Editor;

import java.io.*;
import java.util.Scanner;

public class AddDeleteRoutes
{
	public void addRoute(String name, String distance, String badge, String type)
	{
		try
		{
			String[] parts = name.split(" -> ");
			FileWriter writer = new FileWriter("Routes.txt", true);
			writer.write(parts[0] + " - " + parts[1] + " - " + name + " - " + distance + " - " + badge + " - " + type);
			writer.write("\n");
			writer.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void deleteRoute(String name) throws IOException
	{
		StringBuilder oldContent = new StringBuilder();
		FileReader file = new FileReader("Routes.txt");
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine())
		{
			String line = scan.nextLine(); // read the current line
			if (line.contains(name))
			{
				// if the line contains the string we want to remove
				line = line.replace(line, ""); // remove the line
			}
			else
			{
				oldContent.append(line); // keep the original line
			}
			if (scan.hasNextLine())
			{
				oldContent.append(System.lineSeparator());
			}
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter("Routes.txt"));
		writer.write(oldContent.toString());
		writer.close();
		scan.close();
	}
}
