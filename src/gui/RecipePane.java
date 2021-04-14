package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class RecipePane{
	
	private VBox root;
	private Scene scene;
	RecipePane() {
		root = new VBox();
		Label recipeTitle = new Label("Secret Recipe");
		ImageView recipeImage = new ImageView("Recipe/recipe1.jpg");
		root.getChildren().add(recipeTitle);
		root.getChildren().add(recipeImage);
		root.getChildren().add(closeButton());
		scene = new Scene(root ,1000 ,600);
	}
	
	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	protected Button closeButton() {
		Button cont = new Button("Resume");
		
		cont.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				gamePane.backToGame();
			}
			
		});
		cont.setAlignment(Pos.CENTER_RIGHT);
		return cont;
	}
}
