package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		StackPane root = new StackPane();
		
		Scene scene = new Scene(root, 1000, 600);
		
		primaryStage.setTitle("Sushi Mania");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
}