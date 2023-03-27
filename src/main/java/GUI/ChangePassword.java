package GUI;

import Editor.Database;
import User.UserSign;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class ChangePassword
{
    @FXML
    private TextField current;
    @FXML
    private TextField newp;
    @FXML
    protected void changePassword(ActionEvent event)
    {
        try {
            Database db = new Database();
            db.changeP(current.getText(), newp.getText());
            close(event);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    @FXML
    protected void close(ActionEvent event)
    {
        Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
        window.close();
    }
}

