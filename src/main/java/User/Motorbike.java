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
        return super.set();
    }
    @Override
    public Image setGarage(Image image)
    {
        super.setGarage(image);
        return image;
    }
    @Override
    public void setType(String motorbike)
    {
        super.setType(motorbike);
    }
}
