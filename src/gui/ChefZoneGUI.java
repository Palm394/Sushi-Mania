package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ChefZoneGUI extends HBox {
		
	public static rollPane rollpane;
	public static ingredientPane ingredientpane;
	
		ChefZoneGUI(){
			
			//left zone
			ingredientpane = new ingredientPane();
			this.getChildren().add(ingredientpane);
			
			//center zone
			VBox centerZone = new VBox();
			centerZone.setPadding(new Insets(10,10,10,10));
			rollpane = new rollPane();
			centerZone.getChildren().add(rollpane);
			HBox riceAndRoll = new HBox(); 
			// Rice button
			IngredientButton rice = new IngredientButton(17);
			rice.setPrefHeight(75);
			rice.setPrefWidth(150);
			rice.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event) {
						if(rice.ingredient.getRemain()>0 && ChefZoneController.getWrapper().size() < 12) {
							ChefZoneController.addIngredient(rice);
						}
					}
				}
			);
			//Roll button
			RollButton rollButton = new RollButton(); 
			
			riceAndRoll.getChildren().add(rice);
			riceAndRoll.getChildren().add(rollButton);
			centerZone.getChildren().add(riceAndRoll);
			this.getChildren().add(centerZone);
		}
		
	}
