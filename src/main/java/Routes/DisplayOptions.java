package Routes;

import java.io.*;
import java.util.Scanner;

/**
 * This class is used to display the options for the routes.
 * It also contains methods to get the routes from the file,
 * get the index of the location, check if the route exists,
 * get the name, distance, badge and type of the route.
 */
public class DisplayOptions //display the options for the routes
{
    /**
     * Constructor.
     */
    public DisplayOptions()
    {
    }
    /**
     * This method is used to count the rows in the file.
     * @return the number of rows in the file
     */
    public int rows() //count the rows in the file
    {
        int i = 0;
        File file = new File("Routes.txt");
        if (file.exists())
        {
            try
            {
                FileReader reader = new FileReader(file);
                Scanner scan = new Scanner(reader);
                while (scan.hasNextLine())
                {
                    scan.nextLine();
                    i++;
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return i;
    }
    private String[] origin = new String[rows()];
    private String[] destination = new String[rows()];
    private String[] name = new String[rows()];
    private String[] distance = new String[rows()];
    private String[] badge = new String[rows()];
    private String[] type = new String[rows()];
    /**
     * All locations for autocomplete.
     */
    public String[] locations = new String[rows()*2];
    //merge origin and destination into locations
    /**
     * This method is used to merge origin and destination into locations.
     */
    public void merge() //merge origin and destination into locations
    {
        int i = 0;
        int j = 0;
        while (i < rows())
        {
            locations[j] = origin[i];
            locations[j+1] = destination[i];
            i++;
            j = j + 2;
        }
    }

    /**
     * This method is used to get the routes from the file.
     */
    public void getRoutes() //get the routes from the file
    {
        int i = 0;
        File file = new File("Routes.txt");
        if (file.exists())
        {
            try
            {
                FileReader reader = new FileReader(file);
                Scanner scan = new Scanner(reader);
                while (scan.hasNextLine())
                {
                    String line = scan.nextLine();
                    String[] parts = line.split(" - ");
                    origin[i] = parts[0];
                    destination[i] = parts[1];
                    name[i] = parts[2];
                    distance[i] = parts[3];
                    badge[i] = parts[4];
                    type[i] = parts[5];
                    i++;
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    /**
     * This method is used to get the index of the location.
     * @param location the location
     * @return the index of the location
     */
    public int getIndex(String location) //get the index of the location
    {
        int i;
        for (i = 0; i < rows(); i++)
        {
            if(origin[i].equals(location) || destination[i].equals(location))
            {
                break;
            }
        }
        return i;
    }
    /**
     * This method is used to check if the route exists.
     * @param origin the origin
     * @return true if the route exists, false otherwise
     */
    public boolean checkRoute(String origin) //check if the route exists
    {
        int i;
        for (i = 0; i < rows(); i++)
        {
            if(this.origin[i].equals(origin) || this.destination[i].equals(origin))
            {
                return true;
            }
        }
        return false;
    }
    /**
     * This method is used to get the name of the route.
     * @param i the index of the route
     * @return the name of the route
     */
    public String getName(int i) //get the name of the route
    {
        return name[i];
    }
    /**
     * This method is used to get the distance of the route.
     * @param i the index of the route
     * @return the distance of the route
     */
    public String getDistance(int i) //get the distance of the route
    {
        return distance[i];
    }
    /**
     * This method is used to get the badge of the route.
     * @param i the index of the route
     * @return the badge of the route
     */
    public String getBadge(int i) //get the badge of the route
    {
        return badge[i];
    }
    /**
     * This method is used to get the type of the route.
     * @param i the index of the route
     * @return the type of the route
     */
    public String getType(int i) //get the type of the route
    {
        return type[i];
    }
}
