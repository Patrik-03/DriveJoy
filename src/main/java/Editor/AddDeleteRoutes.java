package Editor;

import java.io.*;
import java.util.Scanner;

public class AddDeleteRoutes<T>
{
	public class AddRoutes
	{
		public void addRoute(T name, T distance, T badge, T type)
		{
			try
			{
				String[] parts = name.toString().split(" -> ");
				FileWriter writer = new FileWriter("Routes.txt", true);
				writer.write(parts[0] + " - " + parts[1] + " - " + name.toString() + " - " + distance.toString() + " - " + badge.toString() + " - " + type.toString());
				writer.write("\n");
				writer.close();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

	public class DeleteRoutes
	{
		public void deleteRoute(T name)
		{
			try
			{
				StringBuilder oldContent = new StringBuilder();
				FileReader file = new FileReader("Routes.txt");
				Scanner scan = new Scanner(file);
				while (scan.hasNextLine())
				{
					String line = scan.nextLine(); // read the current line
					if (line.contains(name.toString()))
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
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
