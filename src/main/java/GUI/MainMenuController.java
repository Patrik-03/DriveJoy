package GUI;

import Icons.SetIcons;
import User.*;
import Routes.*;
import Editor.*;
import Vehicles.Car;
import Vehicles.Motorbike;
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
import java.util.Random;

/**
 * The type Main menu controller.
 * This class is used to control the main menu page.
 */
public class MainMenuController //main menu controller
{
    /**
     * Constructor.
     */
    public MainMenuController()
    {
    }
    @FXML
    private MenuBar menuBar;
    @FXML
    private TextField searchField;
    @FXML
    private Label distance;
    @FXML
    private Label nameR;
    @FXML
    private Label badge;
    @FXML
    private Label type;
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
    private ImageView image;
    @FXML
    private ImageView conditionIcon;
    @FXML
    private ImageView routeBadge;
    @FXML
    private ImageView distanceI;
    @FXML
    private ImageView routeI;
    @FXML
    private CheckBox good;
    @FXML
    private CheckBox bad;
    @FXML
    private CheckBox average;
    @FXML
    private Label condition;
    Vehicle v = new Vehicle();
    UserSign user;
    String veh;
    @FXML
    private Button go;

    /**
     * Set users name and password for this controller.
     * @param username the username
     * @param password the password
     */
    public void setUserName(String username, String password) //set username and password
    {
        user = new UserSign();
        user.setName(username);
        user.setPassword(password);
        welcome.setText("Welcome back in Drive Joy, " + user.getName() + "!");
        welcome.setStyle("-fx-wrap-text: true");
    }
    /**
     * Initialize autocomplete, history and routes.
     */
    public void initialize() //initialize autocomplete, history and routes
    {
        DisplayOptions displayOptions = new DisplayOptions();
        go.setVisible(false);
        conditionIcon.setVisible(false);
        good.setVisible(false);
        bad.setVisible(false);
        average.setVisible(false);
        condition.setVisible(false);
        image.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("garage.png"))));

        Thread autocompleteThread = new Thread(() -> TextFields.bindAutoCompletion(searchField, displayOptions.locations)); //create thread for autocomplete

        Thread historyThread = new Thread(() -> { //create thread for history
            try {
                historyClick();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Thread routesThread = new Thread(() -> { //create thread for routes
            displayOptions.getRoutes();
            displayOptions.merge();
        });

        routesThread.start(); //start threads
        historyThread.start(); //start threads
        autocompleteThread.start(); //start threads
        try
        {
            routesThread.join(); //join threads
            historyThread.join(); //join threads
            autocompleteThread.join(); //join threads
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Sign out.
     * @throws IOException the io exception
     */
    @FXML
    protected void signOutClick() throws IOException //sign out
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Welcome.fxml"))); //load fxml
        Scene scene = new Scene(root); //create scene
        Stage stage = (Stage) menuBar.getScene().getWindow(); //get stage
        stage.setScene(scene); //set scene
        stage.setTitle("Drive Joy"); //set title
        stage.show(); //show stage
    }
    /**
     * change password window.
     */
    @FXML
    protected void changeP() //change password window
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
    /**
     * Search click.
     * @throws IOException the io exception
     */
    @FXML
    protected void searchClick() throws IOException //search click
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
                good.setSelected(false);
                bad.setSelected(false);
                average.setSelected(false);
                distance.setText(displayOptions.getDistance(displayOptions.getIndex(routeInput.getLocation())) + " km");
                nameR.setText(displayOptions.getName(displayOptions.getIndex(routeInput.getLocation())));
                badge.setText(displayOptions.getBadge(displayOptions.getIndex(routeInput.getLocation())));
                badge.setStyle("-fx-background-color: #2696f6;" + "-fx-background-radius: 5;" + "-fx-text-fill: #ffffff;");
                conditionIcon.setVisible(true);
                good.setVisible(true);
                bad.setVisible(true);
                average.setVisible(true);
                condition.setVisible(true);
                Random rand = new Random();
                int n = rand.nextInt(3);
                if (n == 0)
                {
                    good.setSelected(true);
                }
                else if (n == 1)
                {
                    average.setSelected(true);
                }
                else
                {
                    bad.setSelected(true);
                }
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
    /**
     * History click.
     * @throws IOException the io exception
     */
    @FXML
    protected void historyClick() throws IOException //history click
    {
        RouteMemory routeMemory = new RouteMemory();
        routeMemory.check();
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
    /**
     * Set car.
     * @throws IOException the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    @FXML
    protected void setCar() throws IOException, ClassNotFoundException //set car
    {
        Car c = new Car();
        c.setType(car.getText());
        v.setType(c.getType());
        SetIcons setIcons = new SetIcons(v);
        setIcons.setIcons();
        veh = setIcons.getIcon();
        image.setImage(c.setGarage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("sport-car.png")))));
        vehicle.setText(c.getType());
    }
    /**
     * Set motorbike.
     * @throws IOException the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    @FXML
    protected void setMotorbike() throws IOException, ClassNotFoundException //set motorbike
    {
        Motorbike m = new Motorbike();
        m.setType(motorbike.getText());
        v.setType(m.getType());
        SetIcons setIcons = new SetIcons(v);
        setIcons.setIcons();
        veh = setIcons.getIcon();
        image.setImage(m.setGarage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("motorbike.png")))));
        vehicle.setText(m.getType());
    }
    /**
     * Go click.
     */
    @FXML
    protected void go() //go click, animation
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GO.fxml"));
            Parent root = loader.load();
            GoController goController = loader.getController();
            goController.setStart(searchField.getText());
            goController.setDest(nameR.getText().split(" -> ")[0].equals(searchField.getText()) ? nameR.getText().split(" -> ")[1] : nameR.getText().split(" -> ")[0]);
            goController.setVehicle(new Image(Objects.requireNonNull(getClass().getResourceAsStream(veh))));
            //random police
            Random random = new Random();
            int police = random.nextInt(2);
            if(police == 1)
            {
                goController.police.setVisible(true);
            }
            else
            {
                goController.police.setVisible(false);
            }
            System.out.println(police);
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
