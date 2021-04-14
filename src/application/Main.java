package application;

import gui.menuPane;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		menuPane menu = new menuPane();
		
		Utility.setAllVolume(0.5);
		
		primaryStage = menu.getMenuStage();
		primaryStage.show();
	}

	
}