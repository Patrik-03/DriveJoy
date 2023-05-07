package Editor;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Database
{
    File file = new File("UserInfo.txt");

    public void addUser(String name, String password) throws IOException
    {
        int hash = password.hashCode();
        BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
        out.write(name + " " + hash);
        out.newLine();
        out.close();
    }

    public boolean checkUser(String name, String password)
    {
        if (file.exists())
        {
            try
            {
                FileReader reader = new FileReader(file);
                Scanner scan = new Scanner(reader);
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    int hash = password.hashCode();
                    if (parts[0].equals(name))
                    {
                        if (Objects.equals(parts[1], String.valueOf(hash)))
                        {
                            return true;
                        }
                    }
                    else if (parts[0].equals(""))
                    {
                        return false;
                    }
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return false;
    }
    public boolean checkUserUP(String name)
    {
        if (file.exists())
        {
            try
            {
                FileReader reader = new FileReader(file);
                Scanner scan = new Scanner(reader);
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    if (parts[0].equals(name))
                    {
                        return true;
                    }
                    else if (parts[0].equals(""))
                    {
                        return false;
                    }
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return false;
    }
    //change password in file
    public void changeP(String name, String password, String newpassword) throws IOException
    {
        StringBuilder oldContent = new StringBuilder();
        FileReader file = new FileReader("UserInfo.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine())
        {
            String line = scan.nextLine(); // read the current line
            if (line.startsWith(name))
            { // check if the current line contains the info of the signed-in user
                String[] parts = line.split("\\s+"); // split the line by whitespace
                int hash = password.hashCode();
                int old = Integer.parseInt(parts[1]);
                if (parts.length == 2 && old == hash) //check if the passwords matches
                {
                    oldContent.append(name).append(" ").append(newpassword.hashCode());
                }
                else
                {
                    oldContent.append(line); // keep the original line
                }
            }
            else
            {
                oldContent.append(line); // keep the original line
            }
            if (scan.hasNextLine()) {
                oldContent.append(System.lineSeparator());
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("UserInfo.txt"));
        writer.write(oldContent.toString());
        writer.close();
        scan.close();
    }
    public void deleteUser(String name) throws IOException
    {
        StringBuilder oldContent = new StringBuilder();
        FileReader file = new FileReader("UserInfo.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine())
        {
            String line = scan.nextLine(); // read the current line
            if (line.startsWith(name))
            { // check if the current line contains the info of the signed-in user
                String[] parts = line.split("\\s+"); // split the line by whitespace
                if (parts.length == 2) //check if the passwords matches
                {
                    oldContent.append("");
                }
                else
                {
                    oldContent.append(line); // keep the original line
                }
            }
            else
            {
                oldContent.append(line); // keep the original line
            }
            if (scan.hasNextLine()) {
                oldContent.append(System.lineSeparator());
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("UserInfo.txt"));
        writer.write(oldContent.toString());
        writer.close();
        scan.close();
    }
    public int getRows()
    {
        int rows = 0;
        if (file.exists())
        {
            try
            {
                FileReader reader = new FileReader(file);
                Scanner scan = new Scanner(reader);
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    rows++;
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return rows;
    }
    public String[] getUsers()
    {
        String[] users = new String[getRows()];
        int i = 0;
        if (file.exists())
        {
            try
            {
                FileReader reader = new FileReader(file);
                Scanner scan = new Scanner(reader);
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    users[i] = parts[0];
                    i++;
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return users;
    }
}