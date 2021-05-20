package gui;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.ChefZoneController;
import model.FishIngredientButton;
import model.VeggiIngredientButton;

public class BoostPane extends VBox{
	public Button FreeBoostButton;
	
	public BoostPane(){
		
		this.setSpacing(15);
		
		
		// modify vegetable boost button
		Button VeggiBoostButton = new Button("");
		
		VeggiBoostButton.setFont(Font.font ("Tahoma",FontWeight.BOLD, 18));
		VeggiBoostButton.setTextFill(Color.MAROON);

		VeggiBoostButton.setPrefSize(90, 60);
		Image veggiImage = new Image("ButtonImage/VeggiBoostButton.png",55,65,false,false);
		BackgroundImage veggiBackground = new BackgroundImage(veggiImage,null,null,null,null);
		VeggiBoostButton.setBackground(new Background(veggiBackground));
		
		VeggiBoostButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				VeggiBoostButton.setDisable(true);
				logic.ChefZoneController.setVeggiBoost(true);
				
				VeggiIngredientButton veggi;
				veggi = (VeggiIngredientButton) ChefZoneGUI.ingredientpane.getSupply().get(0);
				veggi.Boost();
				veggi = (VeggiIngredientButton) ChefZoneGUI.ingredientpane.getSupply().get(1);
				veggi.Boost();
				veggi = (VeggiIngredientButton) ChefZoneGUI.ingredientpane.getSupply().get(11);
				veggi.Boost();
				ChefZoneController.boostCountdown(20,VeggiBoostButton);
				ChefZoneController.soundPlay("sound/BoostSound.wav");
			}
		});
		
		// modify fish boost button 
		Button FishBoostButton = new Button("");
		
		FishBoostButton.setFont(Font.font ("Tahoma",FontWeight.BOLD, 18));
		FishBoostButton.setTextFill(Color.MAROON);		
		
		FishBoostButton.setPrefSize(90, 60);
		Image fishImage = new Image("ButtonImage/FishBoostButton.png",55,65,false,false);
		BackgroundImage fishBackground = new BackgroundImage(fishImage,null,null,null,null);
		FishBoostButton.setBackground(new Background(fishBackground));
		
		FishBoostButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FishBoostButton.setDisable(true);
				FishIngredientButton fish;
				fish = (FishIngredientButton) ChefZoneGUI.ingredientpane.getSupply().get(6);
				fish.Boost();
				fish = (FishIngredientButton) ChefZoneGUI.ingredientpane.getSupply().get(7);
				fish.Boost();
				fish = (FishIngredientButton) ChefZoneGUI.ingredientpane.getSupply().get(9);
				fish.Boost();
				fish = (FishIngredientButton) ChefZoneGUI.ingredientpane.getSupply().get(13);
				fish.Boost();		
				ChefZoneController.boostCountdown(20,FishBoostButton);
				ChefZoneController.soundPlay("sound/BoostSound.wav");
			}
		});
		
		// modify free boost button
		FreeBoostButton = new Button("");
		
		FreeBoostButton.setFont(Font.font ("Tahoma",FontWeight.BOLD, 18));
		FreeBoostButton.setTextFill(Color.MAROON);		
		
		FreeBoostButton.setPrefSize(90, 60);
		Image freeImage = new Image("ButtonImage/FreeBoostButton.png",55,65,false,false);
		BackgroundImage freeBackground = new BackgroundImage(freeImage,null,null,null,null);
		FreeBoostButton.setBackground(new Background(freeBackground));
		
		FreeBoostButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FreeBoostButton.setDisable(true);
				ChefZoneController.setFreeBoost(true);
				for(int i=0;i<=15;i++) {
					ChefZoneGUI.ingredientpane.getSupply().get(i).freeBoost();
				}
				new Thread(()->{
					ChefZoneController.countdown(20,FreeBoostButton,"");
					ChefZoneController.setFreeBoost(false);
				}).start();
				ChefZoneController.soundPlay("sound/BoostSound.wav");
			}
		});
		
		// gather all button in boost pane
		this.getChildren().addAll(VeggiBoostButton,FishBoostButton,FreeBoostButton);
	}
	
}
