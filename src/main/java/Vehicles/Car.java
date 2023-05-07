package Vehicles;

import User.Vehicle;
import javafx.scene.image.Image;

public class Car extends Vehicle
{
    public Car()
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
    public void setType(String car)
    {
        super.setType(car);
    }
}
