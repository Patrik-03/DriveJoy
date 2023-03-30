package User;

public class Car extends Vehicle
{
    public Car()
    {
        super();
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
