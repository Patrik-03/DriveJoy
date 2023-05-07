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

public class DeleteUserController
{
	@FXML
	ChoiceBox<String> users;
	@FXML
	CheckBox confirm;
	Database database = new Database();
	public void initialize()
	{
		users.getItems().addAll(Arrays.stream(database.getUsers())
				.filter(user -> user != null && !user.isEmpty())
				.toArray(String[]::new));
	}
	@FXML
	protected void backB(ActionEvent event)
	{
		Stage newStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
		newStage.close();
	}
	public void deleteB(ActionEvent actionEvent) throws IOException, EmptyDatabase
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
