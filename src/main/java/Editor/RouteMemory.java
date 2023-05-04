package Editor;

import java.io.*;
import java.util.Scanner;

public class RouteMemory
{
    File file = new File("RouteMemory.txt");

    public void addRoute(String destination) throws IOException
    {
        BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
        out.write( destination);
        out.newLine();
        out.close();
    }
    public int rows()
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
    public String getName(int i)
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
}
