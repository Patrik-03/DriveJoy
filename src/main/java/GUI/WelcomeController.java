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

public class WelcomeController
{
    @FXML
    protected void onSigninButtonClick(ActionEvent event) throws IOException {
        Parent newScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Signin.fxml")));
        Scene signInScene = new Scene(newScreen);
        Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        signInStage.setScene(signInScene);
        signInStage.show();
    }

    @FXML
    protected void onSignupButtonClick(ActionEvent event) throws IOException {
        Parent newS = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Signup.fxml")));
        Scene signInScene = new Scene(newS);
        Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        signInStage.setScene(signInScene);
        signInStage.show();
    }
    @FXML
    protected void onEditorButtonClick(ActionEvent event) throws IOException {
        Parent newS = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Editor.fxml")));
        Scene signInScene = new Scene(newS);
        Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        signInStage.setScene(signInScene);
        signInStage.show();
    }
}
