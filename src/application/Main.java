package application;

import gui.GUIController;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		GUIController manager = new GUIController();
		
		primaryStage = manager.getMenuStage();
		primaryStage.show();
	}

	
}