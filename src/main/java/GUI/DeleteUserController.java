package GUI;

import Editor.Database;
import Exception.EmptyDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

/**
 * This class is the controller for the delete user window
 */
public class DeleteUserController //delete user controller
{
	/**
	 * Constructor.
	 */
	public DeleteUserController()
	{
	}
	@FXML
	ChoiceBox<String> users;
	@FXML
	CheckBox confirm;
	/**
	 * The Database.
	 */
	Database database = new Database();
	/**
	 * This method initializes the choice box
	 */
	public void initialize() //initialize choice box
	{
		users.getItems().addAll(Arrays.stream(database.getUsers())
				.filter(user -> user != null && !user.isEmpty())
				.toArray(String[]::new));
	}
	/**
	 * This method closes the window
	 * @param event the event
	 */
	@FXML
	protected void backB(ActionEvent event) //back button
	{
		Stage newStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
		newStage.close();
	}
	/**
	 * This method deletes the user
	 * @param actionEvent the action event
	 * @throws IOException the io exception
	 * @throws EmptyDatabase the empty database
	 */
	public void deleteB(ActionEvent actionEvent) throws IOException, EmptyDatabase //delete button
	{
		if(database.getUsers().length == 0)
		{
			Alert alert = new AlertBox();
			alert.alert();
			throw new EmptyDatabase("No users in database");
		}
		else
		{
			if(confirm.isSelected())
			{
				database.deleteUser(users.getValue());
				backB(actionEvent);
			}
			else
			{
				confirm.setStyle("-fx-text-fill: red");
			}
		}
	}
}
