package Editor;

import java.io.*;
import java.util.Scanner;

/**
 * This class is used to store the routes that the user has created
 * @see Editor
 */
public class RouteMemory //this class is used to store the routes that the user has created
{
    /**
     * This is the constructor of the class
     */
    public RouteMemory() //constructor
    {

    }
    /**
     * This is the file that the routes are stored in
     */
    File file = new File("RouteMemory.txt");

    /**
     * This method is used to add a route to the file
     * @param destination The destination of the route
     * @throws IOException if the file is not found
     */
    public void addRoute(String destination) throws IOException //add a route to the file
    {
        BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
        out.write( destination);
        out.newLine();
        out.close();
    }
    /**
     * This method is used to find the number of rows in the file
     * @return The number of rows in the file
     */
    public int rows() //count the number of rows in the file
    {
        int rows = 0;
        if(file.exists())
        {
            try
            {
                FileReader reader = new FileReader(file);
                Scanner scan = new Scanner(reader);
                while (scan.hasNextLine())
                {
                    String line = scan.nextLine();
                    rows++;
                }
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return rows;
    }
    /**
     * This method is used to get the name of the route at the specified index
     * @param i The index of the route
     * @return The name of the route
     */
    public String getName(int i) //get the name of the route at the specified index
    {
        String[] name = new String[rows()];
        if(file.exists())
        {
            try
            {
                FileReader reader = new FileReader(file);
                Scanner scan = new Scanner(reader);
                int j = 0;
                while (scan.hasNextLine())
                {
                    String line = scan.nextLine();
                    name[j] = line;
                    j++;
                }
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return name[i];
    }
    /**
     * This method is used to delete all routes from the file
     * @throws IOException if the file is not found
     */
    public void deleteAll() throws IOException // delete all routes from the file
    {
        File file = new File("RouteMemory.txt");

        FileWriter fw = new FileWriter(file, false); // open file in write mode, false for overwrite
        fw.write(""); // write empty string to clear the file
        fw.close();

        System.out.println("File cleared successfully.");
    }
    /**
     * This method is used to check if there are more than 20 routes and if so delete them all
     * @throws IOException if the file is not found
     */
    public void check() throws IOException //check if there are more than 20 routes and if so delete them all
    {
        if(rows() > 20)
        {
            deleteAll();
        }
    }
}
