package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * The WelcomeController class is the controller for the Welcome.fxml file.
 * It is the controller for the welcome screen.
 * It contains methods for the buttons on the welcome screen.
 */
public class WelcomeController //welcome screen
{
    /**
     * Constructor.
     */
    public WelcomeController()
    {
    }
    /**
     * The onSigninButtonClick method is called when the user clicks the Sign In button.
     * It loads the Signin.fxml file and displays it.
     * @param event The event that caused the method to be called.
     * @throws IOException If the file cannot be found.
     */
    @FXML
    protected void onSigninButtonClick(ActionEvent event) throws IOException  //go to signin screen
    {
        Parent newScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Signin.fxml")));
        Scene signInScene = new Scene(newScreen);
        Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        signInStage.setScene(signInScene);
        signInStage.show();
    }
    /**
     * The onSignupButtonClick method is called when the user clicks the Sign Up button.
     * It loads the Signup.fxml file and displays it.
     * @param event The event that caused the method to be called.
     * @throws IOException If the file cannot be found.
     */
    @FXML
    protected void onSignupButtonClick(ActionEvent event) throws IOException  //go to signup screen
    {
        Parent newS = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Signup.fxml")));
        Scene signInScene = new Scene(newS);
        Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        signInStage.setScene(signInScene);
        signInStage.show();
    }
    /**
     * The onEditorButtonClick method is called when the user clicks the Editor button.
     * It loads the Editor.fxml file and displays it.
     * @param event The event that caused the method to be called.
     * @throws IOException If the file cannot be found.
     */
    @FXML
    protected void onEditorButtonClick(ActionEvent event) throws IOException //go to editor screen
    {
        Parent newS = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Editor.fxml")));
        Scene signInScene = new Scene(newS);
        Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        signInStage.setScene(signInScene);
        signInStage.show();
    }
}
