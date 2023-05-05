package Editor;

import java.io.*;
import java.util.Scanner;

public class RouteMemory
{
    File file = new File("RouteMemory.txt");

    public void addRoute(String destination) throws IOException
    {
        check();
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
    public void deleteRoute(String name) throws IOException
    {
        File inputFile = new File("RouteMemory.txt");
        File tempFile = new File("myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while((currentLine = reader.readLine()) != null)
        {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(name)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        boolean successful = tempFile.renameTo(inputFile);
    }
    public void deleteAll() throws IOException
    {
        File inputFile = new File("RouteMemory.txt");
        File tempFile = new File("myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while((currentLine = reader.readLine()) != null)
        {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals("")) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        boolean successful = tempFile.renameTo(inputFile);
    }
    //check if there are more than 20 routes and if so delete them all
    public void check() throws IOException
    {
        if(rows() > 20)
        {
            deleteAll();
        }
    }
}
