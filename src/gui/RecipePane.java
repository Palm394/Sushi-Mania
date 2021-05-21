package gui;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.ChefZoneController;

public class RecipePane{
	
	private VBox root;
	private Scene scene;
	private int selectedImage = 0;
	private ImageView recipeImage;	
	private ArrayList<Image> recipeAlbum = new ArrayList<Image>();	
	
	RecipePane() {
		root = new VBox();
		recipeAlbum.add(new Image("Recipe/Recipe0.jpg"));
		recipeAlbum.add(new Image("Recipe/Recipe1.jpg"));
		recipeAlbum.add(new Image("Recipe/Recipe2.jpg"));
		recipeAlbum.add(new Image("Recipe/Recipe3.jpg"));
		recipeAlbum.add(new Image("Recipe/Recipe4.jpg"));
		recipeAlbum.add(new Image("Recipe/Recipe5.jpg"));
		recipeAlbum.add(new Image("Recipe/Recipe6.jpg"));
		ImageView recipeImage = new ImageView("Recipe/Recipe1.jpg");
		recipeImage.setImage(recipeAlbum.get(selectedImage));
		
		//add blank on the top
		root.getChildren().addAll(new Label(),new Label(),new Label());
		
		Button toLeft = new Button("<");
		toLeft.setStyle("-fx-font-size: 25px; -fx-background-color: rgba(245,222,179,0.8);");
		toLeft.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				ChefZoneController.soundPlay("sound/ClickSound.wav");
				selectedImage = ((selectedImage+6) % 7);
				recipeImage.setImage(new Image("Recipe/Recipe"+selectedImage+".jpg"));
			}
		});	
		Button toRight = new Button(">");
		toRight.setStyle("-fx-font-size: 25px; -fx-background-color: rgba(245,222,179,0.8);");
		root.setAlignment(Pos.CENTER);
		toRight.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				ChefZoneController.soundPlay("sound/ClickSound.wav");
				selectedImage = ((selectedImage+1) % 7);
				recipeImage.setImage(new Image("Recipe/Recipe"+selectedImage+".jpg"));
			}
		});	
		
		HBox recipeControl = new HBox();
		recipeControl.getChildren().addAll(toLeft,recipeImage,toRight);
		recipeControl.setAlignment(Pos.CENTER);
		root.getChildren().add(recipeControl);
		
		root.getChildren().add(closeButton());
		scene = new Scene(root ,1000 ,600);
		root.setStyle("-fx-background-image: url(\"recipeBackground.png\");");
	}
	
	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	protected Button closeButton() {
		Button cont = new Button("Resume");
		cont.setStyle("-fx-font-size: 30px; -fx-background-color: rgba(245,222,179,0.9);");
		cont.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ChefZoneController.soundPlay("sound/ClickSound.wav");
				gamePane.backToGame();
			}
			
		});
		cont.setAlignment(Pos.CENTER_RIGHT);
		return cont;
	}
}
