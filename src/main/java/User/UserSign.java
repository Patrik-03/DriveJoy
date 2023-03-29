package User;

public class UserSign
{
    public static String name;
    public static String password;
    public UserSign(String name, String password)
    {
        UserSign.name = name;
        UserSign.password = password;
    }

    public static String getName()
    {
        return name;
    }
    public static String getPassword()
    {
        return password;
    }
}

