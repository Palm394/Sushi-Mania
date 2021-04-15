package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
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
			HBox riceAndRoll = new HBox(); 
			// Rice button
			rice = new IngredientButton(16);
			rice.setPrefHeight(75);
			rice.setPrefWidth(150);
			//Roll button
			RollButton rollButton = new RollButton(); 
			
			riceAndRoll.getChildren().add(rice);
			riceAndRoll.getChildren().add(rollButton);
			centerZone.getChildren().add(riceAndRoll);
			this.getChildren().add(centerZone);
			
			
			//right zone
			VBox rightZone = new VBox();
			Button recipeButton = new Button("Secret Recipe");
			recipeButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					RecipePane recipePane = new RecipePane();
					gamePane.getGameStage().setScene(recipePane.getScene());
				}
			});
			
			rightZone.getChildren().add(recipeButton);
			shopPane = new ShopPane();
			rightZone.getChildren().add(shopPane);
			this.getChildren().add(rightZone);
		}
		
	}
