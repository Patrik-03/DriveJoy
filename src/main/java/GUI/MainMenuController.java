package GUI;

import User.*;
import Calculations.*;
import Editor.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.WorldMapView;

import java.io.IOException;
import java.util.Objects;
public class MainMenuController
{
    @FXML
    private MenuBar menuBar;
    @FXML
    private TextField searchField;
    @FXML
    private TextField distance;
    @FXML
    private TextField nameR;
    DisplayOptions displayOptions = new DisplayOptions();
    Location location = new Location();
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
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    @FXML
    protected void searchClick(ActionEvent event) throws IOException
    {
        RouteInput routeInput = new RouteInput(searchField.getText());
        routeInput.location = searchField.getText();
        distance.setText("Distance:" + displayOptions.displayOptions(searchField.getText()));
        distance.setStyle("-fx-border-color: black");
        nameR.setText(location.getLocationName(searchField.getText()));
        nameR.setStyle("-fx-background-color: rgba(0,0,0,0.15)");
        RouteMemory routeMemory = new RouteMemory();
        routeMemory.addRoute(location.getLocationName(searchField.getText()));
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
