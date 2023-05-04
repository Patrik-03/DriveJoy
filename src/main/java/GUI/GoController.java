package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GoController
{
	@FXML
	Label dest;
	@FXML
	Label start;

	public void setDest(String dest)
	{
		this.dest.setText(dest);
	}
	public void setStart(String start)
	{
		this.start.setText(start);
	}

}
