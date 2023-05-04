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

public class EditorController
{
    @FXML
    private TextField id;
    @FXML
    private Label no;
    @FXML
    protected void submitClick(MouseEvent event) throws IOException, WrongIdException
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
    @FXML
    protected void backEClick(MouseEvent event) throws IOException
    {
        Parent newScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Welcome.fxml")));
        Scene signInScene = new Scene(newScreen);
        Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        signInStage.setScene(signInScene);
        signInStage.show();
    }
}
