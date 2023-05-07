package GUI;

import Editor.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Exception.*;

import java.io.IOException;
import java.util.Objects;

/**
 * This class is the controller for the editor input screen
 */
public class EditorController //editor input controller
{
    /**
     * Constructor.
     */
    public EditorController()
    {
    }
    @FXML
    TextField id;
    @FXML
    Label no;
    /**
     * This method checks if the id is valid and if it is, goes to the editor menu
     * @param event The mouse event
     * @throws IOException The io exception
     * @throws WrongIdException The wrong id exception
     */
    @FXML
    protected void submitClick(MouseEvent event) throws IOException, WrongIdException //check if the id is valid and if it is, go to the editor menu
    {
        EditorRoles editorRoles = new EditorRoles(id.getText());
        editorRoles.checkID();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditorMenu.fxml"));
        Parent newScreen = loader.load();
        Scene signInScene = new Scene(newScreen);
        Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        signInStage.setScene(signInScene);
        signInStage.show();

    }
    /**
     * This method goes back to the welcome screen
     * @param event The mouse event
     * @throws IOException The io exception
     */
    @FXML
    protected void backEClick(MouseEvent event) throws IOException //go back to the welcome screen
    {
        Parent newScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Welcome.fxml")));
        Scene signInScene = new Scene(newScreen);
        Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        signInStage.setScene(signInScene);
        signInStage.show();
    }
}
