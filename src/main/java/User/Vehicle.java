package User;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Vehicle implements java.io.Serializable
{
    private String type;
    public Vehicle()
    {
        this.type = "";
    }
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
        return type != null;
    }
    public Image setGarage(Image image)
    {
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        return image;
    }
}
