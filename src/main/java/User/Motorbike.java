package User;

public class Motorbike extends Vehicle
{
    public Motorbike()
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
