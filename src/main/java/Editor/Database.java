package Editor;

import java.io.*;
import java.util.Scanner;
import User.UserSign;

public class Database {
    File file = new File("UserInfo.txt");

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
                int hash = 0;
                FileReader reader = new FileReader(file);
                Scanner scan = new Scanner(reader);
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    hash = parts[1].hashCode();
                    if (parts[0].equals(name) || hash == password.hashCode()) {
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
    //change password in file
    public void changeP(String password, String newpassword) throws IOException {
        String old = "";
        FileReader file = new FileReader("UserInfo.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split(" ");
            int hash = Integer.parseInt(parts[1]); // parse the hash value from the file
            if (hash == password.hashCode()) {
                old += parts[0] + " " + newpassword.hashCode() + System.lineSeparator();
            } else {
                old += line + System.lineSeparator();
            }
        }
        String newContent = old.replaceAll("\\b" + password.hashCode() + "\\b", String.valueOf(newpassword.hashCode())); // replace only the exact match of the old hash value
        BufferedWriter writer = new BufferedWriter(new FileWriter("UserInfo.txt"));
        writer.write(newContent);
        writer.close();
        scan.close();
    }
}