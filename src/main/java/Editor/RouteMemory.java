package Editor;

import java.io.*;
import java.util.Scanner;

public class RouteMemory
{
    File file = new File("RouteMemory.txt");

    public void addRoute(String destination) throws IOException
    {
        BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
        out.newLine();
        out.write( destination);
        out.close();
    }
    public boolean checkSaved(String origin, String destination)
    {
        if(file.exists())
        {
            try
            {
                FileReader reader = new FileReader(file);
                Scanner scan = new Scanner(reader);
                while (scan.hasNextLine())
                {
                    String line = scan.nextLine();
                    String[] parts = line.split(" - ");
                    if (parts[0].equals(origin) && parts[1].equals(destination))
                    {
                        return true;
                    }
                }
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return false;
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
    public String getSaved1(int i)
    {
        String[] saved1 = new String[rows()];

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
                    String[] parts = line.split(" ");
                    saved1[j] = parts[0];
                    j++;
                }
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return saved1[i];
    }
    public String getSaved2(int i)
    {
        String[] saved2 = new String[rows()];

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
                    String[] parts = line.split(" ");
                    saved2[j] = parts[1];
                    j++;
                }
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return saved2[i] + " ";
    }
}
