package GUI;

import Editor.Database;
import User.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SignUpController
{
    @FXML
    private Label exist;
    @FXML
    private TextField name;
    @FXML
    private PasswordField pass;
    @FXML
    private PasswordField con;

    @FXML
    protected void onSignUpClick(MouseEvent event) throws IOException
    {
        UserSign userSign = new UserSign();
        userSign.setName(name.getText());
        userSign.setPassword(pass.getText());
        Database database = new Database();
        if (database.checkUserUP(userSign.name))
        {
            exist.setText("User already exists");
        }
        else if(name.getText().isEmpty() && pass.getText().isEmpty() && con.getText().isEmpty())
        {
            name.setPromptText("Please enter your name");
            pass.setPromptText("Please enter your password");
            con.setPromptText("Please confirm your password");
            name.setStyle("-fx-prompt-text-fill: red");
            pass.setStyle("-fx-prompt-text-fill: red");
            con.setStyle("-fx-prompt-text-fill: red");
        }
        else if(name.getText().isEmpty() && con.getText().isEmpty())
        {
            name.setPromptText("Please enter your name");
            con.setPromptText("Please confirm your password");
            name.setStyle("-fx-prompt-text-fill: red");
            con.setStyle("-fx-prompt-text-fill: red");
        }
        else if(pass.getText().isEmpty() && con.getText().isEmpty())
        {
            pass.setPromptText("Please enter your password");
            con.setPromptText("Please confirm your password");
            pass.setStyle("-fx-prompt-text-fill: red");
            con.setStyle("-fx-prompt-text-fill: red");
        }
        else if ( name.getText().isEmpty())
        {
            name.setPromptText("Please enter your name");
            name.setStyle("-fx-prompt-text-fill: red");
        }
        else if (pass.getText().isEmpty())
        {
            pass.setPromptText("Please enter your password");
            pass.setStyle("-fx-prompt-text-fill: red");
        }
        else if (con.getText().isEmpty())
        {
            con.setPromptText("Please confirm your password");
            con.setStyle("-fx-prompt-text-fill: red");
        }
        else
        {
            if (!pass.getText().equals(con.getText()))
            {
                exist.setText("Passwords do not match");
            }
            else
            {
                database.addUser(userSign.name, userSign.password);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
                Parent newScreen = loader.load();
                MainMenuController controller = loader.getController();
                controller.setUserName(userSign.name, userSign.password);
                Scene signInScene = new Scene(newScreen);
                Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                signInStage.setScene(signInScene);
                signInStage.show();
            }
        }
    }
    @FXML
    protected void onBackClick(MouseEvent event) throws IOException
    {
        Parent newScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Welcome.fxml")));
        Scene signUpScene = new Scene(newScreen);
        Stage signUpStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        signUpStage.setScene(signUpScene);
        signUpStage.show();
    }
}
