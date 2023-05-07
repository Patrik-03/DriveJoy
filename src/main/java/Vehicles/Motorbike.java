package Vehicles;

import User.Vehicle;
import javafx.scene.image.Image;

/**
 * Motorbike class
 * Inherits from Vehicle class
 * Sets the type of vehicle to motorbike
 * Sets the garage image for motorbike
 * @see User.Vehicle
 */
public class Motorbike extends Vehicle // Motorbike class inherits from Vehicle class
{
    /**
     * Motorbike constructor
     * Calls the super constructor
     */
    public Motorbike() // Constructor
    {
        super();
    }
    /**
     * This method to check if the motorbike is set
     * @return boolean This returns true if the motorbike is set
     */
    public boolean set() // Set method
    {
        return super.set();
    }
    /**
     * This method to set new image for motorbike
     * @param image This is the image of the motorbike
     */
    @Override
    public Image setGarage(Image image) // Set garage method for motorbike
    {
        super.setGarage(image);
        return image;
    }
    /**
     * This method to set the type of motorbike
     * @param motorbike This is the type of the motorbike
     */
    @Override
    public void setType(String motorbike) // Set type method for motorbike
    {
        super.setType(motorbike);
    }
}
