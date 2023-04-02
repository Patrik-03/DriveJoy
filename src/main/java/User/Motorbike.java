package User;

import javafx.scene.image.Image;

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
    @Override
    public Image setGarage(Image image)
    {
        super.setGarage(image);
        return image;
    }
}
