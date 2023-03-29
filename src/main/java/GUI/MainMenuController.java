package GUI;

import User.*;
import Routes.*;
import Editor.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
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
    private Menu latest;
    @FXML
    private Menu vehicle;
    @FXML
    private MenuItem car;
    @FXML
    private MenuItem motorbike;
    Vehicle vehicle1 = new Vehicle(UserSign.getName(), UserSign.getPassword());

    public void initialize()
    {
        DisplayOptions displayOptions = new DisplayOptions();
        displayOptions.getRoutes();
        history();
        TextFields.bindAutoCompletion(searchField, displayOptions.origin);
    }
    @FXML
    protected void signOutClick() throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Welcome.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Drive Joy");
        stage.show();
    }
    @FXML
    protected void changeP()
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

        if(vehicle1.set())
        {
            distance.setText("Length: " + displayOptions.distance[displayOptions.getIndex(routeInput.location)] + " km");
            recommend.setText(" Recommended direction:");
            nameR.setText(" " + displayOptions.name[displayOptions.getIndex(routeInput.location)]);
            badge.setText(displayOptions.badge[displayOptions.getIndex(routeInput.location)]);
            badge.setStyle("-fx-background-color: #2696f6;" + "-fx-background-radius: 5;" + "-fx-text-fill: #ffffff;");
            routeMemory.addRoute(displayOptions.name[displayOptions.getIndex(routeInput.location)]);
        }
        else
        {
            recommend.setText(" Please select a vehicle");
            recommend.setStyle("-fx-text-fill: #ff0000;");
        }
    }
    @FXML
    protected void historyClick()
    {
        RouteMemory routeMemory = new RouteMemory();
        DisplayOptions displayOptions = new DisplayOptions();
        displayOptions.getRoutes();
        for(int i = 0; i < routeMemory.rows(); i++)
        {
            MenuItem menuItem = new MenuItem(routeMemory.getName(i));
            latest.getItems().add(menuItem);
            String[] origin = menuItem.getText().split(" -> ");
            menuItem.setOnAction(event1 -> {
                searchField.setText(origin[0]);
                try {
                    searchClick();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    @FXML
    public void history()
    {
        historyClick();
    }
    @FXML
    protected void setCar()
    {
        vehicle1 = new Vehicle(UserSign.getName(), UserSign.getPassword(), "Car");
        vehicle.setText(vehicle1.getType());
    }
    @FXML
    protected void setMotorbike()
    {
        vehicle1 = new Vehicle(UserSign.getName(), UserSign.getPassword(), "Motorbike");
        vehicle.setText(vehicle1.getType());
    }
    public String getType()
    {
        if (vehicle.getText().equals(vehicle1.getType()))
        {
            vehicle1 = new Vehicle(UserSign.getName(), UserSign.getPassword(), vehicle.getText());
            return vehicle.getText();
        }
        else
        {
            return null;
        }
    }
}
