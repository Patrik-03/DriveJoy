package GUI;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Objects;

public class AlertBox implements Alert
{
    public void display(String message)
    {
        Platform.runLater(() -> {
            Stage window = new Stage();
            window.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("road.png"))));
            window.initModality(Modality.APPLICATION_MODAL);

            Label label = new Label();
            label.setText(message);
            label.setWrapText(true);
            label.setTextAlignment(TextAlignment.CENTER);
            label.setTextFill(Color.BLACK);
            label.setStyle("-fx-font:italic small-caps Bold 12 cursive;");

            Button closeButton = new Button("Close");
            closeButton.setEffect(new DropShadow());
            closeButton.setStyle("-fx-background-color: gray; -fx-text-fill: white;");
            closeButton.setOnMouseEntered(e -> closeButton.setStyle("-fx-background-color: #2a9dff; -fx-text-fill: white;"));
            closeButton.setOnMouseExited(e -> closeButton.setStyle("-fx-background-color: gray; -fx-text-fill: white;"));
            closeButton.setOnAction(e -> window.close());

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, closeButton);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout, 200, 100);
            scene.setFill(Color.WHITE);
            window.setScene(scene);
            window.centerOnScreen();
            window.showAndWait();
        });
    }

}
