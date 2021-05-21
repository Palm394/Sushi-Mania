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
import javafx.scene.layout.VBox;
import logic.ChefZoneController;
import model.ClearButton;
import model.RollButton;

public class ChefZoneGUI extends HBox {
		
	private static rollPane rollpane;
	private static RollButton rollButton = new RollButton();
	private static ingredientPane ingredientpane = new ingredientPane();
	private static RecipePane recipePane;
	private static ShopPane shopPane;
	private static BoostPane boostpane;
	
		ChefZoneGUI(){
			this.setStyle("-fx-background-image: url(\"tableDesk.jpg\");");
			//left zone
			this.getChildren().add(ingredientpane);
			
			
			//center zone
			VBox centerZone = new VBox();
			centerZone.setSpacing(10);
			centerZone.setPadding(new Insets(10,10,10,10));
			rollpane = new rollPane();
			HBox pane = new HBox();
			pane.setSpacing(10);
			pane.setPrefHeight(200);
			pane.setPrefWidth(300);
			boostpane = new BoostPane();
			
			pane.getChildren().add(rollpane);
			pane.getChildren().add(boostpane);
			
			centerZone.getChildren().add(pane);
			HBox rollAndClear = new HBox();
			//Roll button
			//declared 
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
			Image image = new Image("ButtonImage/recipeButton.jpg",250,80,false,false);
			Button recipeButton = new Button("Secret Recipe");
			recipeButton.setPrefSize(250, 80);
			recipeButton.setStyle("-fx-font-size: 20px");
			BackgroundImage recipeBut = new BackgroundImage(image,null,null,null,null);
			recipeButton.setBackground(new Background(recipeBut));
			recipeButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					ChefZoneController.soundPlay("sound/ClickSound.wav");
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

		public static rollPane getRollpane() {
			return rollpane;
		}

		public static void setRollpane(rollPane rollpane) {
			ChefZoneGUI.rollpane = rollpane;
		}

		public static RollButton getRollButton() {
			return rollButton;
		}

		public static void setRollButton(RollButton rollButton) {
			ChefZoneGUI.rollButton = rollButton;
		}

		public static ingredientPane getIngredientpane() {
			return ingredientpane;
		}

		public static void setIngredientpane(ingredientPane ingredientpane) {
			ChefZoneGUI.ingredientpane = ingredientpane;
		}

		public static RecipePane getRecipePane() {
			return recipePane;
		}

		public static void setRecipePane(RecipePane recipePane) {
			ChefZoneGUI.recipePane = recipePane;
		}

		public static ShopPane getShopPane() {
			return shopPane;
		}

		public static void setShopPane(ShopPane shopPane) {
			ChefZoneGUI.shopPane = shopPane;
		}

		public static BoostPane getBoostpane() {
			return boostpane;
		}

		public static void setBoostpane(BoostPane boostpane) {
			ChefZoneGUI.boostpane = boostpane;
		}
	}
