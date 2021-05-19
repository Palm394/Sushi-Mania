package gui;

import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import logic.ChefZoneController;
import model.FishIngredientButton;
import model.IngredientButton;
import model.VeggiIngredientButton;

public class BoostPane extends VBox{
	
	public BoostPane(){
		
		this.setSpacing(15);
		
		
		// modify vegetable boost button
		Button VeggiBoostButton = new Button("V");
		
		VeggiBoostButton.setPrefSize(50, 60);
		
		VeggiBoostButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				VeggiIngredientButton veggi;
				veggi = (VeggiIngredientButton) ChefZoneGUI.ingredientpane.getSupply().get(0);
				veggi.Boost();
				veggi = (VeggiIngredientButton) ChefZoneGUI.ingredientpane.getSupply().get(1);
				veggi.Boost();
				veggi = (VeggiIngredientButton) ChefZoneGUI.ingredientpane.getSupply().get(11);
				veggi.Boost();
				ChefZoneController.countdown(20,VeggiBoostButton);
			}
		});
		
		// modify fish boost button 
		Button FishBoostButton = new Button("F");
		
		FishBoostButton.setPrefSize(50, 60);
		
		FishBoostButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FishIngredientButton fish;
				fish = (FishIngredientButton) ChefZoneGUI.ingredientpane.getSupply().get(6);
				fish.Boost();
				fish = (FishIngredientButton) ChefZoneGUI.ingredientpane.getSupply().get(7);
				fish.Boost();
				fish = (FishIngredientButton) ChefZoneGUI.ingredientpane.getSupply().get(9);
				fish.Boost();
				fish = (FishIngredientButton) ChefZoneGUI.ingredientpane.getSupply().get(13);
				fish.Boost();		
				ChefZoneController.countdown(20,FishBoostButton);
			}
		});
		
		// modify free boost button
		Button FreeBoostButton = new Button("F");
		
		FreeBoostButton.setPrefSize(50, 60);
		
		FreeBoostButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ChefZoneController.countdown(10,FreeBoostButton);
			}
		});
		
		// gather all button in boost pane
		this.getChildren().addAll(VeggiBoostButton,FishBoostButton,FreeBoostButton);
	}
}
