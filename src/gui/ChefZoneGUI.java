package gui;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ChefZoneGUI extends HBox {
		
	public static rollPane rollpane;
	public static ingredientPane ingredientpane;
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
			IngredientButton rice = new IngredientButton(17);
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
			recipePane = new RecipePane();
			shopPane = new ShopPane();
			rightZone.getChildren().add(recipePane);
			rightZone.getChildren().add(shopPane);
			this.getChildren().add(rightZone);
		}
		
	}
