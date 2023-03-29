package User;

public class Vehicle extends UserSign
{
    String type;
    public Vehicle(String name, String password) {
        super(name, password);
    }
    public Vehicle(String name, String password, String type) {
        super(name, password);
        this.type = type;
    }
    public String getType()
    {
        return type;
    }
    public boolean set()
    {
        if (type == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
