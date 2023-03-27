package Editor;

import User.UserSign;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Database
{

    File file = new File("UserInfo.txt");
    UserSign user = new UserSign("","");


    public void addUser(String name, String password) throws IOException {
        int hash = password.hashCode();
        BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
        out.newLine();
        out.write(name + " " + hash);
        out.close();
    }

    public boolean checkUser(String name, String password) {
        if (file.exists()) {
            try {
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
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    public boolean checkUserUP(String name) {
        if (file.exists()) {
            try {
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
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public void changeN(String name, String newName) throws IOException
    {
        //change name in file
        String old = "";
        FileReader file = new FileReader("UserInfo.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine())
        {
            old += scan.nextLine() + " " + System.lineSeparator();
        }
        String newContent = old.replaceAll(name, newName);
        BufferedWriter writer = new BufferedWriter(new FileWriter("UserInfo.txt"));
        writer.write(newContent);
        writer.close();
        scan.close();
    }
    //change password in file
    public void changeP(String password, String newpassword) throws IOException
    {
        String old = "";
        FileReader file = new FileReader("UserInfo.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine())
        {
            old += scan.nextLine() + " " + System.lineSeparator();
        }
        int hash = password.hashCode();
        int newhash = newpassword.hashCode();
        String newContent = old.replaceAll(String.valueOf(hash), String.valueOf(newhash));
        BufferedWriter writer = new BufferedWriter(new FileWriter("UserInfo.txt"));
        writer.write(newContent);
        writer.close();
        scan.close();
    }
}