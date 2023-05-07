/**
 * This module contains the main class and the GUI.
 * It also contains the FXML files for the GUI.
 * The GUI is built with JavaFX.
 * The GUI uses the following libraries:
 * - ControlsFX
 * - ValidatorFX
 * - Ikonli
 * - BootstrapFX
 * - JavaFX WebView
 */
module com.example.drivejoy
{
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