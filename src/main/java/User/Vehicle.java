package User;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class is used to create a vehicle object
 * @see java.io.Serializable
 */
public class Vehicle implements java.io.Serializable // This class is used to create a vehicle object
{
    /**
     * This is the type of the vehicle
     */
    private String type;
    /**
     * This is the constructor of the class
     */
    public Vehicle() // Constructor
    {
        this.type = "";
    }
    /**
     * This is the method used to set the type of the vehicle
     * @param type This is the type of the vehicle
     */
    public void setType(String type) //set the type of vehicle
    {
        this.type = type;
    }
    /**
     * This is the method used to get the type of the vehicle
     * @return String This returns the type of the vehicle
     */
    public String getType() //get the type of vehicle
    {
        return type;
    }
    /**
     * This is the method used to check if the type of the vehicle is set
     * @return boolean This returns true if the type of the vehicle is set
     */
    public boolean set() //check if the type of vehicle is set
    {
        return type != null;
    }
    /**
     * This is the method used to set the image of the vehicle
     * @param image This is the image of the vehicle
     * @return Image This returns the image of the vehicle
     */
    public Image setGarage(Image image) //set the image of the vehicle
    {
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        return image;
    }
}
