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

public class SigInController
{
    @FXML
    private Label wrong;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    protected void signInClick(MouseEvent event) throws IOException
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

    @FXML
    protected void backClick(MouseEvent event) throws IOException
    {
        Parent newScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Welcome.fxml")));
        Scene signInScene = new Scene(newScreen);
        Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        signInStage.setScene(signInScene);
        signInStage.show();
    }
}
