package GUI;

import Editor.*;
import User.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * This class is used to control the sign in page.
 * It contains methods for the sign in button and the back button.
 * It is used to sign in a user.
 * It is used to check if the username and password are correct.
 */
public class SigInController //sign in controller
{
    /**
     * Constructor.
     */
    public SigInController()
    {
    }
    @FXML
    private Label wrong;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    /**
     * This method is used to sign in.
     * It checks if the username and password are correct.
     * If they are, it opens the main menu.
     * If they are not, it displays a message.
     * @param event The mouse event
     * @throws IOException If the file is not found
     * @see IOException
     */
    @FXML
    protected void signInClick(MouseEvent event) throws IOException //sign in button
    {
        UserSign userSign = new UserSign();
        userSign.setName(username.getText());
        userSign.setPassword(password.getText());
        Database database = new Database();
        if(database.checkUser(userSign.getName(), userSign.getPassword()))
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent newScreen = loader.load();
            MainMenuController mainMenuController = loader.getController();
            mainMenuController.setUserName(userSign.getName(), userSign.getPassword());
            Scene signInScene = new Scene(newScreen);
            Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            signInStage.setScene(signInScene);
            signInStage.show();
        }
        else if(username.getText().isEmpty() && password.getText().isEmpty())
        {
            username.setPromptText("Please enter your name");
            password.setPromptText("Please enter your password");
            username.setStyle("-fx-prompt-text-fill: red");
            password.setStyle("-fx-prompt-text-fill: red");
        }
        else if(username.getText().isEmpty())
        {
            username.setPromptText("Please enter your name");
            username.setStyle("-fx-prompt-text-fill: red");
        }
        else if(password.getText().isEmpty())
        {
            password.setPromptText("Please enter your password");
            password.setStyle("-fx-prompt-text-fill: red");
        }
        else
        {
            wrong.setText("Wrong username or password");
        }
    }
    /**
     * This method is used to go back to the welcome page.
     * @param event The mouse event
     * @throws IOException If the file is not found
     * @see IOException
     */
    @FXML
    protected void backClick(MouseEvent event) throws IOException //back button
    {
        Parent newScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Welcome.fxml")));
        Scene signInScene = new Scene(newScreen);
        Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        signInStage.setScene(signInScene);
        signInStage.show();
    }
}
