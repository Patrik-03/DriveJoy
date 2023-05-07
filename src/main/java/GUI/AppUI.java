package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * This class is the entry point for the JavaFX application
 * @see Application
 */
public class AppUI extends Application // This class is the entry point for the JavaFX application
{
    /**
     * This is the constructor of the class.
     */
    public AppUI() // constructor
    {
    }
    /**
     * This method is called when the application is launched
     * @param stage The stage to be displayed
     * @throws IOException If the FXML file is not found
     */
    @Override
    public void start(Stage stage) throws IOException // This method is called when the application is launched
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Welcome.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.getIcons().add(new Image(Objects.requireNonNull(AppUI.class.getResourceAsStream("road.png"))));
        stage.setTitle("Drive Joy");
        stage.show();
    }

    /**
     * This method is the entry point for the Java application
     * @param args The command line arguments
     */
    public static void main(String[] args)  // This method is the entry point for the Java application
    {
        launch();
    }
}
