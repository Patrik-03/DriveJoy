package GUI;

import Editor.Database;
import User.UserSign;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Change password.
 * This class is used to control the change password window.
 */
public class ChangePassword // change the password controller
{
    /**
     * Constructor.
     */
    public ChangePassword()
    {
    }
    @FXML
    TextField current;
    @FXML
    TextField newp;
    /**
     * The Db.
     */
    Database db = new Database();
    /**
     * The User sign.
     */
    private UserSign userSign;
    /**
     * Sets users name.
     * @param user the user
     */
    public void setUser(UserSign user) // set the username and password
    {
        this.userSign = user;
    }
    /**
     * Change password.
     * @param event the event
     */
    @FXML
    protected void changePassword(ActionEvent event) // change the password
    {
        try
        {
            db.changeP(userSign.getName(), current.getText(), newp.getText());
            close(event);
        }
        catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }
    /**
     * Close.
     * @param event the event
     */
    @FXML
    protected void close(ActionEvent event) // close the window
    {
        Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
        window.close();
    }
}

