package Editor;

import GUI.Alert;
import Exception.EmptyDatabase;
import java.io.*;
import java.util.Scanner;

/**
 * This class is used to add and delete routes from the Routes.txt file
 * @param <T> Generic type
 */
public class AddDeleteRoutes<T>
{
	/**
	 * Constructor
	 */
	public AddDeleteRoutes()
	{
	}
	/**
	 * This class is used to add routes to the Routes.txt file
	 */
	public class AddRoutes //class for adding routes
	{
		/**
		 * Constructor
		 */
		public AddRoutes()
		{
		}
		/**
		 * This method is used to add routes to the Routes.txt file
		 * @param name The name of the route
		 * @param distance The distance of the route
		 * @param badge The badge of the route
		 * @param type The type of the route
		 */
		public void addRoute(T name, T distance, T badge, T type) //method for adding routes
		{
			try //try to add route
			{
				String[] parts = name.toString().split(" -> "); //split the route name into two parts
				FileWriter writer = new FileWriter("Routes.txt", true); //create a file writer
				writer.write(parts[0] + " - " + parts[1] + " - " + name + " - " + distance.toString() + " - " + badge.toString() + " - " + type.toString()); //write the route to the file
				writer.write("\n"); //write a new line
				writer.close(); //close the file writer
			}
			catch (Exception ex) //catch any exceptions
			{
				ex.printStackTrace(); //print the stack trace
			}
		}
	}

	/**
	 * This class is used to delete routes from the Routes.txt file
	 * @see Alert
	 */
	public class DeleteRoutes implements Alert
	{
		/**
		 * Constructor
		 */
		public DeleteRoutes()
		{
		}
		/**
		 * This method is used to delete routes from the Routes.txt file
		 * @param name The name of the route
		 * @throws EmptyDatabase if the database is empty
		 */
		public void deleteRoute(T name) throws EmptyDatabase
		{
			if (name.toString().equals("")) //if the name is empty
			{
				alert();
			}
			try //try to delete the route
			{
				StringBuilder oldContent = new StringBuilder(); //create a string builder
				FileReader file = new FileReader("Routes.txt"); //create a file reader
				Scanner scan = new Scanner(file); //create a scanner
				while (scan.hasNextLine()) //while there are still lines to read
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
					if (scan.hasNextLine()) //if there are still lines to read
					{
						oldContent.append(System.lineSeparator()); //add a new line
					}
				}
				BufferedWriter writer = new BufferedWriter(new FileWriter("Routes.txt")); //create a buffered writer
				writer.write(oldContent.toString()); //write the old content to the file
				writer.close(); //close the buffered writer
				scan.close(); //close the scanner
			}
			catch (IOException ex) //catch any exceptions
			{
				ex.printStackTrace(); //print the stack trace
			}
		}
	}
}
