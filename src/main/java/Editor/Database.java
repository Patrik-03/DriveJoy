package Editor;

import java.io.*;
import java.util.Scanner;

public class Database {
    File file = new File("UserInfo.txt");

    public void addUser(String name, String password) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
        out.newLine();
        out.write(name + " " + password);
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
                    if (parts[0].equals(name) || parts[1].equals(password)) {
                        return true;
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
    //change email in file
    public void changeE(String email, String newemail)
    {

    }
    //change password in file
    public void changeP(String password, String newpassword)
    {
        int oldhash = password.hashCode();
    }
}