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

import java.io.IOException;
import java.util.Objects;

public class EditorController
{
    @FXML
    private TextField id;
    @FXML
    private Label no;
    @FXML
    protected void submitClick(MouseEvent event) throws IOException {
        EditorInput editorInput = new EditorInput(id.getText());
        editorInput.ID = id.getText();
        if(id.getText().isEmpty())
        {
            no.setText("Please enter the ID");
        }
        else
        {
            if(EditorRoles.checkID(editorInput.ID) != null)
            {
                AlertBox.display("Welcome" + " " + EditorRoles.checkID(editorInput.ID));
                /*Parent newS = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Welcome.fxml")));
                Scene signInScene = new Scene(newS);
                Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                signInStage.setScene(signInScene);
                signInStage.show();*/
            }
            else
            {
                no.setText("Incorrect ID");
            }

        }
    }
    @FXML
    protected void backEClick(MouseEvent event) throws IOException {
        Parent newScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Welcome.fxml")));
        Scene signInScene = new Scene(newScreen);
        Stage signInStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        signInStage.setScene(signInScene);
        signInStage.show();
    }
}
