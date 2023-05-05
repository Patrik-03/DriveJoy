package Routes;

import java.io.*;
import java.util.Scanner;

public class DisplayOptions
{
    public int rows()
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
    public String[] locations = new String[rows()*2];
    //merge origin and destination into locations
    public void merge()
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

    public void getRoutes()
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
    public int getIndex(String location)
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
    public boolean checkRoute(String origin)
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
    public String getOrigin(int i)
    {
        return origin[i];
    }
    public String getDestination(int i)
    {
        return destination[i];
    }
    public String getName(int i)
    {
        return name[i];
    }
    public String getDistance(int i)
    {
        return distance[i];
    }
    public String getBadge(int i)
    {
        return badge[i];
    }
    public String getType(int i)
    {
        return type[i];
    }

}
