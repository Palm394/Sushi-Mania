package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.AlertPane;

public class ChefZoneGUI extends HBox {
		
	public static rollPane rollpane;
	public static ingredientPane ingredientpane;
	public static IngredientButton rice;
	public static RecipePane recipePane;
	public static ShopPane shopPane;
	
		ChefZoneGUI(){
			this.setStyle("-fx-background-image: url(\"tableDesk.jpg\");");
			//left zone
			ingredientpane = new ingredientPane();
			this.getChildren().add(ingredientpane);
			
			
			//center zone
			VBox centerZone = new VBox();
			centerZone.setPadding(new Insets(10,10,10,10));
			rollpane = new rollPane();
			Pane pane = new Pane();
			pane.setPrefHeight(200);
			pane.setPrefWidth(300);
			pane.getChildren().add(rollpane);
			centerZone.getChildren().add(pane);
			HBox rollAndClear = new HBox();
			//Roll button
			RollButton rollButton = new RollButton(); 
			//Clear button
			ClearButton clearButton = new ClearButton();
			
			Label blank = new Label();
			blank.setPrefWidth(10);
			rollAndClear.getChildren().add(rollButton);
			rollAndClear.getChildren().add(blank);
			rollAndClear.getChildren().add(clearButton); 
			centerZone.getChildren().add(rollAndClear);
			this.getChildren().add(centerZone);
			centerZone.setAlignment(Pos.CENTER);
			
			//right zone
			VBox rightZone = new VBox();
			rightZone.setAlignment(Pos.CENTER);
			rightZone.setPadding(new Insets(10,0,10,10));
			Image image = new Image("recipeButton.jpg",250,80,false,false);
			Button recipeButton = new Button("Secret Recipe");
			recipeButton.setPrefSize(250, 80);
			recipeButton.setStyle("-fx-font-size: 20px");
			BackgroundImage recipeBut = new BackgroundImage(image,null,null,null,null);
			recipeButton.setBackground(new Background(recipeBut));
			recipeButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					RecipePane recipePane = new RecipePane();
					gamePane.getGameStage().setScene(recipePane.getScene());
				}
			});
			
			rightZone.getChildren().add(recipeButton);
			rightZone.getChildren().add(new Label());
			shopPane = new ShopPane();
			rightZone.getChildren().add(shopPane);
			this.getChildren().add(rightZone);
		}
		
	}
