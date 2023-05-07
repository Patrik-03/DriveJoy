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

/**
 * The SignUpController class is used to control the sign up page.
 * It is used to sign up a new user.
 * It is used to check if the user already exists.
 * It is used to check if the password and confirm password match.
 * It is used to check if the fields are empty.
 * It is used to go back to the welcome page.
 * It is used to go to the main menu page.
 */
public class SignUpController //sign up controller
{
    /**
     * Constructor.
     */
    public SignUpController()
    {
    }
    @FXML
    private Label exist;
    @FXML
    private TextField name;
    @FXML
    private PasswordField pass;
    @FXML
    private PasswordField con;

    /**
     * The onSignUpClick method is used to sign up a new user.
     * @param event The mouse event
     * @throws IOException If the file is not found
     */
    @FXML
    protected void onSignUpClick(MouseEvent event) throws IOException //sign up button
    {
        UserSign userSign = new UserSign();
        userSign.setName(name.getText());
        userSign.setPassword(pass.getText());
        Database database = new Database();
        if (database.checkUserUP(userSign.getName()))
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
                database.addUser(userSign.getName(), userSign.getPassword());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
                Parent newScreen = loader.load();
                MainMenuController controller = loader.getController();
                controller.setUserName(userSign.getName(), userSign.getPassword());
                Scene signInScene = new Scene(newScreen);
                Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                signInStage.setScene(signInScene);
                signInStage.show();
            }
        }
    }
    /**
     * The onBackClick method is used to go back to the welcome page.
     * @param event The mouse event
     * @throws IOException If the file is not found
     */
    @FXML
    protected void onBackClick(MouseEvent event) throws IOException //back button
    {
        Parent newScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Welcome.fxml")));
        Scene signUpScene = new Scene(newScreen);
        Stage signUpStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        signUpStage.setScene(signUpScene);
        signUpStage.show();
    }
}
