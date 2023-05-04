module com.example.drivejoy {
	requires javafx.controls;
	requires javafx.fxml;

	requires org.controlsfx.controls;
	requires net.synedra.validatorfx;
	requires org.kordamp.ikonli.javafx;
	requires org.kordamp.bootstrapfx.core;
	requires javafx.web;

	opens GUI to javafx.fxml;
	exports GUI;
}