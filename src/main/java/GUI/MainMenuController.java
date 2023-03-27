package GUI;

import User.*;
import Routes.*;
import Editor.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.controlsfx.control.WorldMapView;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.util.Objects;

public class MainMenuController
{
    @FXML
    private MenuBar menuBar;
    @FXML
    public TextField searchField;
    @FXML
    private Label distance;
    @FXML
    private Label nameR;
    @FXML
    private Label time;
    @FXML
    private Label badge;
    @FXML
    private Label recommend;
    @FXML
    private ChoiceBox<String> history;

    @FXML
    protected void signOutClick(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Welcome.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Drive Joy");
        stage.show();
    }
    @FXML
    protected void changeP(ActionEvent event)
    {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChangePassword.fxml")));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("car.png"))));
            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    @FXML
    protected void searchClick() throws IOException
    {
        RouteInput routeInput = new RouteInput(searchField.getText());
        RouteMemory routeMemory = new RouteMemory();
        DisplayOptions displayOptions = new DisplayOptions();
        displayOptions.getRoutes();

        AutoCompletionBinding<String> autoCompletionBinding = TextFields.bindAutoCompletion(searchField, displayOptions.origin);

        distance.setText("Length: " + displayOptions.distance[displayOptions.getIndex(routeInput.location)] + " km");
        recommend.setText(" Recommended direction:");
        nameR.setText(" " + displayOptions.name[displayOptions.getIndex(routeInput.location)]);
        badge.setText(displayOptions.badge[displayOptions.getIndex(routeInput.location)]);
        badge.setStyle("-fx-background-color: #2696f6;" +"-fx-background-radius: 5;" + "-fx-text-fill: #ffffff;");
        routeMemory.addRoute(displayOptions.name[displayOptions.getIndex(routeInput.location)]);
    }
    @FXML
    protected void historyClick()
    {
        history.getItems().clear();
        DisplayOptions displayOptions = new DisplayOptions();
        displayOptions.getRoutes();
        history.getItems().addAll(displayOptions.name);
    }
    @FXML
    protected void map(ActionEvent event) throws IOException
    {
        WorldMapView worldMapView = new WorldMapView();
        worldMapView.setZoomFactor(2);
        Stage stage = new Stage();
        stage.setScene(new Scene(worldMapView));
        stage.show();
    }
}
