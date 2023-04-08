package User;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Vehicle
{
    String type;
    public Vehicle()
    {
        this.type = null;
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
