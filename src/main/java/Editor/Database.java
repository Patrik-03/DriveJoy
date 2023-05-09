package Editor;

import GUI.Alert;
import Exception.EmptyDatabase;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

/**
 * Class for storing user info
 * @see Editor
 */
public class Database implements Alert
{
    /**
     * Constructor for Database
     */
    public Database()
    {
    }
    /**
     * File for storing user info
     */
    File file = new File("UserInfo.txt"); //file for storing user info

    /**
     * Method for adding user to file
     * @param name username
     * @param password password
     * @throws IOException if file not found
     */
    public void addUser(String name, String password) throws IOException //add user to file
    {
        int hash = password.hashCode(); //hash password
        BufferedWriter out = new BufferedWriter(new FileWriter(file, true)); //write to file
        out.write(name + " " + hash); //write name and password hash
        out.newLine(); //new line
        out.close(); //close writer
    }

    /**
     * Method for checking if user exists
     * @param name username
     * @param password password
     * @return true if user exists, false if not
     */
    public boolean checkUser(String name, String password) //check if user exists
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
    /**
     * Method for checking if user exists when creating new user
     * @param name username
     * @return true if user exists, false if not
     */
    public boolean checkUserUP(String name) //check if user exists if creating new user
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
    /**
     * Method for changing password
     * @param name username
     * @param password password
     * @param newpassword new password
     * @throws IOException if file not found
     */
    public void changeP(String name, String password, String newpassword) throws IOException //change password
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
    /**
     * Method for deleting user
     * @param name username
     * @throws IOException if file not found
     */
    public void deleteUser(String name) throws IOException, EmptyDatabase //delete user
    {
        if (name == null)
        {
            alert();
        }
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
    /**
     * Method for getting number of rows in file
     * @return number of rows
     */
    public int getRows() //get number of rows in file
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
    /**
     * Method for getting users from file
     * @return array of users
     */
    public String[] getUsers() //get users from file
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