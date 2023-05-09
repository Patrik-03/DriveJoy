package GUI;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

/**
 * This class is used to animate the vehicle on the map
 */
public class GoController //animation controller
{
	/**
	 * Constructor.
	 */
	public GoController()
	{
	}
	@FXML
	Label dest;
	@FXML
	Label start;
	@FXML
	ImageView v;
	@FXML
	ImageView police;
	@FXML
	Label Z10;
	@FXML
	Label Z11;
	@FXML
	Label Z12;
	@FXML
	Label Z13;
	@FXML
	Label Z15;

	/**
	 * This method is used to set the destination
	 * @param dest This is the destination
	 */
	public void setDest(String dest) //set the destination
	{
		this.dest.setText(dest);
	}
	/**
	 * This method is used to set the start location
	 * @param start This is the start location
	 */
	public void setStart(String start) //set the start location
	{
		this.start.setText(start);
		this.start.wrapTextProperty().setValue(true);
	}
	/**
	 * This method is used to set the vehicle image
	 * @param image This is the vehicle image
	 */
	public void setVehicle(Image image) //set the vehicle image
	{
		v.setImage(image);
	}
	/**
	 * This method to animate the vehicle
	 * @return Thread This returns the thread of the animation
	 */
	public Thread animate() //animate the vehicle
	{
		Timeline timeline = new Timeline(); // Create a new Timeline animation object

		// Initial tilt by 45 degrees to the right
		Rotate initialTilt = new Rotate(45, v.getFitWidth() / 2, v.getFitHeight() / 2);
		v.getTransforms().add(initialTilt);

		Rotate returnToOriginal = new Rotate(-75, v.getFitWidth() / 2, v.getFitHeight() / 2);
		Scale scale = new Scale(0.9, 0.9, v.getFitWidth() / 2, v.getFitHeight() / 2);
		KeyValue kv1 = new KeyValue(v.layoutXProperty(), Z10.getLayoutX());
		KeyValue kv2 = new KeyValue(v.layoutYProperty(), Z10.getLayoutY());
		KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1, kv2);
		KeyValue kv3 = new KeyValue(v.rotateProperty(), returnToOriginal.getAngle());
		KeyValue kv4 = new KeyValue(v.scaleXProperty(), scale.getX());
		KeyValue kv5 = new KeyValue(v.scaleYProperty(), scale.getY());
		KeyFrame kf1Tilt = new KeyFrame(Duration.seconds(2), kv3, kv4, kv5);

		Rotate tiltHorizontal = new Rotate(-110, v.getFitWidth() / 2, v.getFitHeight() / 2);
		Scale scale2 = new Scale(0.9*0.9, 0.9*0.9, v.getFitWidth() / 2, v.getFitHeight() / 2);
		KeyValue kv9 = new KeyValue(v.layoutXProperty(), Z11.getLayoutX());
		KeyValue kv10 = new KeyValue(v.layoutYProperty(), Z11.getLayoutY());
		KeyFrame kf4 = new KeyFrame(Duration.seconds(3), kv9, kv10);
		KeyValue kv11 = new KeyValue(v.rotateProperty(), tiltHorizontal.getAngle());
		KeyValue kv12 = new KeyValue(v.scaleXProperty(), scale2.getX());
		KeyValue kv13 = new KeyValue(v.scaleYProperty(), scale2.getY());
		KeyFrame kf4Tilt = new KeyFrame(Duration.seconds(5), kv11, kv12, kv13);

		// Tilt back by 10 degrees at Z13
		Rotate tiltBack = new Rotate(-120, v.getFitWidth() / 2, v.getFitHeight() / 2);
		Scale scale3 = new Scale(0.9*0.9*0.9*0.9, 0.9*0.9*0.9*0.9, v.getFitWidth() / 2, v.getFitHeight() / 2);
		KeyValue kv14 = new KeyValue(v.layoutXProperty(), Z12.getLayoutX());
		KeyValue kv15 = new KeyValue(v.layoutYProperty(), Z12.getLayoutY());
		KeyFrame kf5 = new KeyFrame(Duration.seconds(6), kv14, kv15);
		KeyValue kv16 = new KeyValue(v.rotateProperty(), tiltBack.getAngle());
		KeyValue kv17 = new KeyValue(v.scaleXProperty(), scale3.getX());
		KeyValue kv18 = new KeyValue(v.scaleYProperty(), scale3.getY());
		KeyFrame kf5Tilt = new KeyFrame(Duration.seconds(7), kv16, kv17, kv18);

		// Tilt to original position and then 45 degrees to the right at Z14
		Rotate tiltRight = new Rotate(10, v.getFitWidth() / 2, v.getFitHeight() / 2);
		Scale scale4 = new Scale(0.9*0.9*0.9*0.9*0.8*0.8, 0.9*0.9*0.9*0.9*0.8*0.8, v.getFitWidth() / 2, v.getFitHeight() / 2);
		KeyValue kv19 = new KeyValue(v.layoutXProperty(), Z13.getLayoutX());
		KeyValue kv20 = new KeyValue(v.layoutYProperty(), Z13.getLayoutY());
		KeyFrame kf6 = new KeyFrame(Duration.seconds(9), kv19, kv20);
		KeyValue kv21 = new KeyValue(v.rotateProperty(), tiltRight.getAngle());
		KeyValue kv22 = new KeyValue(v.scaleXProperty(), scale4.getX());
		KeyValue kv23 = new KeyValue(v.scaleYProperty(), scale4.getY());
		KeyFrame kf6Tilt = new KeyFrame(Duration.seconds(11), kv21, kv22, kv23);

		KeyValue kv24 = new KeyValue(v.layoutXProperty(), Z15.getLayoutX());
		KeyValue kv25 = new KeyValue(v.layoutYProperty(), Z15.getLayoutY());
		KeyFrame kf7 = new KeyFrame(Duration.seconds(12), kv24, kv25);

		timeline.getKeyFrames().addAll(kf1, kf1Tilt, kf4, kf4Tilt, kf5, kf5Tilt, kf6, kf6Tilt, kf7);
		timeline.play(); // Start the animation
		timeline.setOnFinished(event -> {
			// Animation is finished, call the arrived() method
			arrived();
		});

		return new Thread(() -> {
			try
			{
				Thread.sleep(12000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		});
	}
	/**
	 * This method is used to display the alert box
	 */
	private void arrived()
	{
		Alert alert = new AlertBox();
	}
}
