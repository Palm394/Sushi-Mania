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
		Button PlayBtn = new Button("Play");
		
		
		StackPane root = new StackPane();
		root.getChildren().add(PlayBtn);
		
		Scene MenuScene = new Scene(root, 400, 600);
		
		StackPane root1 = new StackPane();
		Scene PlayScene = new Scene(root1);
		
		PlayBtn.setOnAction(e -> primaryStage.setScene(PlayScene));
		
		primaryStage.setTitle("Sushi Mania");
		primaryStage.setScene(MenuScene);
		primaryStage.show();
	}

	
}