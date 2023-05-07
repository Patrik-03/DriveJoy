package GUI;

import Editor.*;
import User.Vehicle;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

public class AddRouteController
{
	@FXML
	TextField direction;
	@FXML
	TextField length;
	@FXML
	TextField badge;
	@FXML
	ChoiceBox<String> type;
	AddDeleteRoutes<Object> addRoutes = new AddDeleteRoutes<>();
	AddDeleteRoutes<Object>.AddRoutes addRoute = addRoutes.new AddRoutes();
	public void initialize()
	{
		List<String> vehicleClasses = new ArrayList<>(); // Create a list to store the names of classes in the Vehicles package
		try
		{
			// Get the class loader for the current class
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			try
			{
				Enumeration<URL> resources = classLoader.getResources("Vehicles");
				while (resources.hasMoreElements())
				{
					URL resource = resources.nextElement();
					File file = new File(resource.toURI());
					File[] files = file.listFiles();
					for (File classFile : Objects.requireNonNull(files))
					{
						if (classFile.isFile() && classFile.getName().endsWith(".class"))
						{
							String className = classFile.getName().replace(".class", "");
							Class<?> clazz = Class.forName("Vehicles." + className);
							if (Vehicle.class.isAssignableFrom(clazz))
							{
								vehicleClasses.add(className);
							}
						}
					}
				}
			}
			catch (URISyntaxException e)
			{
				throw new RuntimeException(e);
			}
			catch (IOException | ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
			// Add the vehicle class names to the choice box
		type.getItems().addAll(vehicleClasses);
	}
	@FXML
	protected void addClick()
	{
		addRoute.addRoute(direction.getText(), length.getText(), badge.getText(), type.getValue());
		Stage stage = (Stage) type.getScene().getWindow();
		stage.close();
	}
	@FXML
	protected void backClick()
	{
		Stage stage = (Stage) type.getScene().getWindow();
		stage.close();
	}
}
