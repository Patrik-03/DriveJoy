package User;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Vehicle
{
    String type;
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
        if (type == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Image setGarage(Image image)
    {
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        return image;
    }
}
