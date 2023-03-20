package GUI;

import Editor.Database;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class ChangeName
{
    static Database Database = new Database();
    public static void changeName()
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.getIcons().add(new Image("Screenshot_20230317_185054_Waze.png"));
        
        Label label = new Label();
        label.setText("Username change");
        label.setTextAlignment(TextAlignment.CENTER);
        label.setTextFill(Color.BLACK);
        label.setStyle("-fx-font:italic small-caps Bold 12 cursive;");

        TextField current = new TextField();
        current.setPromptText("Current username");
        TextField newname = new TextField();
        newname.setPromptText("New username");

        Button change = new Button("Change");
        change.setEffect(new DropShadow());
        change.setStyle("-fx-background-color: gray; -fx-text-fill: white;");
        change.setOnMouseEntered(e -> change.setStyle("-fx-background-color: #2a9dff; -fx-text-fill: white;"));
        change.setOnMouseExited(e -> change.setStyle("-fx-background-color: gray; -fx-text-fill: white;"));
        change.setOnAction(e -> {
            try {
                Database.changeN(current.getText(), newname.getText());
                window.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Button back = new Button("Back");
        back.setEffect(new DropShadow());
        back.setStyle("-fx-background-color: gray; -fx-text-fill: white;");
        back.setOnMouseEntered(e -> back.setStyle("-fx-background-color: #2a9dff; -fx-text-fill: white;"));
        back.setOnMouseExited(e -> back.setStyle("-fx-background-color: gray; -fx-text-fill: white;"));
        back.setOnAction(e -> window.close());

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10)); //top, right, bottom, left
        //set the vertical and horizontal gaps between the columns
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);
        GridPane.setHalignment(label,HPos.CENTER);
        GridPane.setHalignment(current,HPos.CENTER);
        GridPane.setHalignment(newname,HPos.CENTER);
        GridPane.setHalignment(back,HPos.LEFT);
        GridPane.setHalignment(change,HPos.RIGHT);
        layout.add(label, 0,0);
        layout.add(current, 0,1);
        layout.add(newname, 0,2);
        layout.add(back, 0,3);
        layout.add(change,0,3);

        Scene scene = new Scene(layout, 200,150);
        scene.setFill(Color.WHITE);
        window.setScene(scene);
        window.centerOnScreen();
        window.showAndWait();

    }
}
