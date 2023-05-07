package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Controller for EditorMenu.fxml
 */
public class EditorMenuController // Controller for EditorMenu.fxml
{
    /**
     * Constructor
     */
    public EditorMenuController()
    {
    }
    /**
     * When the delete route button is clicked
     * @param event When the delete route button is clicked
     * @throws IOException When the delete route button is clicked
     */
    @FXML
    protected void deleteRouteClick(ActionEvent event) throws IOException // When the delete route button is clicked
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteRoute.fxml")); // Load the DeleteRoute.fxml file
        Parent root = loader.load(); // Load the DeleteRoute.fxml file
        Scene scene = new Scene(root); // Create a new scene
        Stage stage = new Stage(); // Create a new stage
        stage.setScene(scene); // Set the scene to the stage
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("road.png")))); // Set the icon of the stage
        stage.setTitle("Delete Route"); // Set the title of the stage
        stage.show(); // Show the stage
    }
    /**
     * When the create route button is clicked
     * @param event When the create route button is clicked
     * @throws IOException When the create route button is clicked
     */
    @FXML
    protected void createRouteClick(ActionEvent event) throws IOException  // When the create route button is clicked
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddRoute.fxml")); // Load the AddRoute.fxml file
        Parent root = loader.load(); // Load the AddRoute.fxml file
        Scene scene = new Scene(root); // Create a new scene
        Stage stage = new Stage(); // Create a new stage
        stage.setScene(scene); // Set the scene to the stage
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("road.png")))); // Set the icon of the stage
        stage.setTitle("Create Route"); // Set the title of the stage
        stage.show(); // Show the stage
    }
    /**
     * When the delete user button is clicked
     * @param event When the delete user button is clicked
     * @throws IOException When the delete user button is clicked
     */
    @FXML
    protected void deleteUserClick(ActionEvent event) throws IOException // When the delete user button is clicked
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteUser.fxml")); // Load the DeleteUser.fxml file
        Parent root = loader.load(); // Load the DeleteUser.fxml file
        Scene scene = new Scene(root); // Create a new scene
        Stage stage = new Stage(); // Create a new stage
        stage.setScene(scene); // Set the scene to the stage
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("road.png")))); // Set the icon of the stage
        stage.setTitle("Delete User"); // Set the title of the stage
        stage.show(); // Show the stage
    }
    /**
     * When the sign out button is clicked
     * @param event When the sign out button is clicked
     * @throws IOException When the sign out button is clicked
     */
    @FXML
    protected void signOutClick(ActionEvent event) throws IOException // When the sign out button is clicked
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Welcome.fxml"))); // Load the Welcome.fxml file
        Scene scene = new Scene(root); // Create a new scene
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow(); // Get the stage
        stage.setScene(scene); // Set the scene to the stage
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("road.png")))); // Set the icon of the stage
        stage.setTitle("Drive Joy"); // Set the title of the stage
        stage.show(); // Show the stage
    }
}
