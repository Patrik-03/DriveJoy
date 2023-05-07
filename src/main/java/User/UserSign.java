package User;

/**
 * This class is used to get the username and password from the user
 */
public class UserSign // This class is used to get the username and password from the user
{
    private String name;
    private String password;

    /**
     * Constructor
     */
    public UserSign()  // Constructor
    {
    }

    /**
     * Get name
     * @return name
     */
    public String getName() //get name
    {
        return name;
    }
    /**
     * Get password
     * @return password
     */
    public String getPassword() //get password
    {
        return password;
    }
    /**
     * Set name
     * @param name name
     */
    public void setName(String name)  //set name
    {
        this.name = name;
    }
    /**
     * Set password
     * @param password password
     */
    public void setPassword(String password)  //set password
    {
        this.password = password;
    }
}

