package User;

public class Vehicle
{
    String type;
    public void setType(String type)
    {
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