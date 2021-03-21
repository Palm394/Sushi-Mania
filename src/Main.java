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
		Button btn = new Button("Play");
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		Scene scene = new Scene(root, 400, 600);
		primaryStage.setTitle("Sushi Mania");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
}