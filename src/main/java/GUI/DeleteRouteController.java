package GUI;

import Editor.AddDeleteRoutes;
import Exception.EmptyDatabase;
import Routes.DisplayOptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteRouteController
{
	@FXML
	CheckBox confirm;
	@FXML
	ChoiceBox<String> routes;
	AddDeleteRoutes addDeleteRoutes = new AddDeleteRoutes();
	DisplayOptions displayOptions = new DisplayOptions();
	public void initialize()
	{
		displayOptions.getRoutes();
		for (int i = 0; i < displayOptions.rows(); i++)
		{
			routes.getItems().add(displayOptions.getName(i));
		}
	}
	@FXML
	protected void deleteClick(ActionEvent actionEvent) throws IOException, EmptyDatabase
	{
		if(displayOptions.getName(0) == null)
		{
			AlertBox alert = new AlertBox();
			alert.alert();
			throw new EmptyDatabase("No routes in database");
		}
		else
		{
			if(confirm.isSelected())
			{
				addDeleteRoutes.deleteRoute(routes.getValue());
				backB(actionEvent);
			}
			else
			{
				confirm.setStyle("-fx-text-fill: red");
			}
		}
	}
	@FXML
	protected void backB(ActionEvent actionEvent)
	{
		Stage newStage = (Stage) ((javafx.scene.control.Button) actionEvent.getSource()).getScene().getWindow();
		newStage.close();
	}

}
