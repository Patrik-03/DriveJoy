package GUI;

import Editor.AddDeleteRoutes;
import Exception.EmptyDatabase;
import Routes.DisplayOptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

/**
 * DeleteRouteController is the class responsible for the delete route window
 * @see AddDeleteRoutes
 * @see DisplayOptions
 * @see EmptyDatabase
 */
public class DeleteRouteController
{
	/**
	 * The Stage.
	 */
	public DeleteRouteController()
	{
	}
	@FXML
	CheckBox confirm;
	@FXML
	ChoiceBox<String> routes;
	/**
	 * The Add delete routes.
	 */
	AddDeleteRoutes<Object> addDeleteRoutes = new AddDeleteRoutes<>();
	/**
	 * The Delete routes.
	 */
	AddDeleteRoutes<Object>.DeleteRoutes deleteRoutes = addDeleteRoutes.new DeleteRoutes();
	/**
	 * The Display options.
	 */
	DisplayOptions displayOptions = new DisplayOptions();
	/**
	 * initialize the choice box with the routes
	 */
	public void initialize() //initialize the choice box with the routes
	{
		displayOptions.getRoutes();
		for (int i = 0; i < displayOptions.rows(); i++)
		{
			routes.getItems().add(displayOptions.getName(i));
		}
	}
	/**
	 * delete the route
	 * @param actionEvent the action event
	 * @throws EmptyDatabase the empty database
	 */
	@FXML
	protected void deleteClick(ActionEvent actionEvent) throws EmptyDatabase //delete the route
	{
		if(displayOptions.getName(0) != null)
		{
			if(confirm.isSelected())
			{
				deleteRoutes.deleteRoute(routes.getValue());
				backB(actionEvent);
			}
			else
			{
				confirm.setStyle("-fx-text-fill: red");
			}
		}
	}
	/**
	 * close the window
	 * @param actionEvent the action event
	 */
	@FXML
	protected void backB(ActionEvent actionEvent) //close the window
	{
		Stage newStage = (Stage) ((javafx.scene.control.Button) actionEvent.getSource()).getScene().getWindow();
		newStage.close();
	}
}
