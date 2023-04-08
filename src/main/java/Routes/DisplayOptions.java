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
    public String[] origin = new String[rows()];
    public String[] destination = new String[rows()];
    public String[] name = new String[rows()];
    public String[] distance = new String[rows()];
    public String[] badge = new String[rows()];
    public String[] type = new String[rows()];

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
            if(this.origin[i].equals(origin))
            {
                return true;
            }
        }
        return false;
    }
}
