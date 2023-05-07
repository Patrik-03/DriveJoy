package Vehicles;

import User.Vehicle;
import javafx.scene.image.Image;

/**
 * This class is used to create a car object
 * It inherits from the Vehicle class
 * It is used to set the car
 * It is used to set the garage image
 * It is used to set the type of the car
 * @see User.Vehicle
 */
public class Car extends Vehicle // This class inherits from the Vehicle class
{
    /**
     * This is the constructor of the class
     */
    public Car() // This is the constructor
    {
        super();
    }
    /**
     * This is the method used to check if the car is set
     * @return boolean This returns true if the car is set
     */
    public boolean set() // This method is used to set the car
    {
        return super.set();
    }
    /**
     * This is the method used to set new image for the garage
     * @param image This is the image of the garage
     */
    @Override
    public Image setGarage(Image image) // This method is used to set the garage image
    {
        super.setGarage(image);
        return image;
    }
    /**
     * This is the method used to set the type of the vehicle
     * @param car This is the type of the vehicle
     */
    @Override
    public void setType(String car) // This method is used to set the type of the car
    {
        super.setType(car);
    }
}
