package GUI;

import Icons.SetIcons;
import User.*;
import Routes.*;
import Editor.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.io.*;
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
    private Label badge;
    @FXML
    private Label type;
    @FXML
    private Label curves;
    @FXML
    private Label welcome;
    @FXML
    private Menu latest;
    @FXML
    private Menu vehicle;
    @FXML
    private MenuItem car;
    @FXML
    private MenuItem motorbike;
    @FXML
    public ImageView image;
    @FXML
    private ImageView curvesNum;
    @FXML
    private ImageView routeBadge;
    @FXML
    private ImageView distanceI;
    @FXML
    private ImageView routeI;
    Vehicle v = new Vehicle();
    UserSign user;
    @FXML
    private Button go;

    public void setUserName(String username, String password)
    {
        user = new UserSign();
        user.setName(username);
        user.setPassword(password);
        welcome.setText("Welcome back in Drive Joy, " + user.getName() + "!");
        welcome.setStyle("-fx-wrap-text: true");
    }
    public void initialize()
    {
        DisplayOptions displayOptions = new DisplayOptions(); //create object
        displayOptions.getRoutes(); //get routes from database
        displayOptions.merge(); //merge routes
        historyClick(); //history menu
        go.setVisible(false); //hide go button
        image.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("garage.png")))); //set garage image
        TextFields.bindAutoCompletion(searchField, displayOptions.locations); //autocomplete
    }
    @FXML
    protected void signOutClick() throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Welcome.fxml"))); //load fxml
        Scene scene = new Scene(root); //create scene
        Stage stage = (Stage) menuBar.getScene().getWindow(); //get stage
        stage.setScene(scene); //set scene
        stage.setTitle("Drive Joy"); //set title
        stage.show(); //show stage
    }
    @FXML
    protected void changeP()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChangePassword.fxml"));
            Parent root = loader.load();
            ChangePassword changePasswordController = loader.getController();
            changePasswordController.setUserName(user.getName(), user.getPassword());
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("road.png"))));
            stage.show();
        }
        catch (IOException ex)
        {
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
        type.setText("");
        if(!displayOptions.checkRoute(searchField.getText()))
        {
            type.setText("This location is currently not available");
            type.setStyle("-fx-text-fill: #000000");
            go.setVisible(false);
        }
        else if(searchField.getText().equals(""))
        {
            type.setText("Please enter a location");
            type.setStyle("-fx-text-fill: red");
            go.setVisible(false);
        }
        else
        {
            if (v.set())
            {
                distance.setText(displayOptions.getDistance(displayOptions.getIndex(routeInput.getLocation())) + " km");
                nameR.setText(displayOptions.getName(displayOptions.getIndex(routeInput.getLocation())));
                badge.setText(displayOptions.getBadge(displayOptions.getIndex(routeInput.getLocation())));
                badge.setStyle("-fx-background-color: #2696f6;" + "-fx-background-radius: 5;" + "-fx-text-fill: #ffffff;");
                curves.setText("Curves: ");
                if (displayOptions.getType(displayOptions.getIndex(routeInput.getLocation())).equals(v.getType()))
                {
                    type.setText("Your vehicle is perfect for this route");
                    type.setStyle("-fx-text-fill: #275227;");
                }
                else
                {
                    type.setText("You will have better experience with a different type of vehicle");
                    type.setStyle("-fx-text-fill: #000000;");
                }
                routeI.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("tracking.png"))));
                distanceI.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("distance.png"))));
                routeBadge.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("route.png"))));
                curvesNum.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("curved-lines.png"))));
                routeMemory.addRoute(displayOptions.getName(displayOptions.getIndex(routeInput.getLocation()))+ " Vehicle: " + v.getType());
                go.setVisible(true);
            }
            else
            {
                type.setText(" Please select a vehicle");
                type.setStyle("-fx-text-fill: #ff0000;");
            }
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
            String[] vehicle = menuItem.getText().split(" Vehicle: ");
            menuItem.setOnAction(event1 -> {
                searchField.setText(origin[0]);
                if(vehicle[1].equals("Car"))
                {
                    try
                    {
                        setCar();
                    }
                    catch (IOException | ClassNotFoundException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
                else
                {
                    try
                    {
                        setMotorbike();
                    }
                    catch (IOException | ClassNotFoundException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
                try
                {
                    searchClick();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            });
        }
    }
    @FXML
    protected void setCar() throws IOException, ClassNotFoundException
    {
        Car c = new Car();
        c.setType(car.getText());
        v.setType(c.getType());
        SetIcons setIcons = new SetIcons(v);
        image.setImage(c.setGarage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("sport-car.png")))));
        vehicle.setText(c.getType());
    }
    @FXML
    protected void setMotorbike() throws IOException, ClassNotFoundException
    {
        Motorbike m = new Motorbike();
        m.setType(motorbike.getText());
        v.setType(m.getType());
        SetIcons setIcons = new SetIcons(v);
        image.setImage(m.setGarage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("motorbike.png")))));
        vehicle.setText(m.getType());
    }
    @FXML
    protected void go()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GO.fxml"));
            Parent root = loader.load();
            GoController goController = loader.getController();
            goController.setStart(searchField.getText());
            goController.setDest(nameR.getText().split(" -> ")[0].equals(searchField.getText()) ? nameR.getText().split(" -> ")[1] : nameR.getText().split(" -> ")[0]);
            goController.setVehicle(new Image(Objects.requireNonNull(getClass().getResourceAsStream("lambo.png"))));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("road.png"))));
            stage.show();
            Thread thread = new Thread(goController.animate());
            thread.start();
        }
        catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }
}
