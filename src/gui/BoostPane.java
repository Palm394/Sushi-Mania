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

public class BoostPane extends VBox {
	private Button FreeBoostButton;
	private Button VeggiBoostButton;
	private Button FishBoostButton;

	public BoostPane() {

		this.setSpacing(15);

		VeggiBoostButton = new Button("");
		defineVeggiBoostButton();

		FishBoostButton = new Button("");
		defineFishBoostButton();

		FreeBoostButton = new Button("");
		defineFreeBoostButton();

		this.getChildren().addAll(VeggiBoostButton, FishBoostButton, FreeBoostButton);
	}

	private void defineFreeBoostButton() {

		FreeBoostButton.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		FreeBoostButton.setTextFill(Color.MAROON);
		FreeBoostButton.setPrefSize(90, 60);
		Image freeImage = new Image("ButtonImage/FreeBoostButton.png", 55, 65, false, false);
		BackgroundImage freeBackground = new BackgroundImage(freeImage, null, null, null, null);
		FreeBoostButton.setBackground(new Background(freeBackground));

		FreeBoostButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				freeBoostButtonHandler();
			}
		});

	}

	private void freeBoostButtonHandler() {
		FreeBoostButton.setDisable(true);
		ChefZoneController.setFreeBoost(true);
		for (int i = 0; i <= 15; i++) {
			ChefZoneGUI.getIngredientpane().getSupply().get(i).freeBoost();
		}
		new Thread(() -> {
			ChefZoneController.countdown(20, FreeBoostButton, "");
			ChefZoneController.setFreeBoost(false);
		}).start();
		ChefZoneController.soundPlay("sound/BoostSound.wav");
	}

	private void defineFishBoostButton() {

		FishBoostButton.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		FishBoostButton.setTextFill(Color.MAROON);
		FishBoostButton.setPrefSize(90, 60);
		Image fishImage = new Image("ButtonImage/FishBoostButton.png", 55, 65, false, false);
		BackgroundImage fishBackground = new BackgroundImage(fishImage, null, null, null, null);
		FishBoostButton.setBackground(new Background(fishBackground));

		FishBoostButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				fishBoostButtonHandler();
			}
		});
	}

	private void fishBoostButtonHandler() {

		FishBoostButton.setDisable(true);
		logic.ChefZoneController.setFishBoost(true);

		FishIngredientButton fish;
		fish = (FishIngredientButton) ChefZoneGUI.getIngredientpane().getSupply().get(6);
		fish.Boost();
		fish = (FishIngredientButton) ChefZoneGUI.getIngredientpane().getSupply().get(7);
		fish.Boost();
		fish = (FishIngredientButton) ChefZoneGUI.getIngredientpane().getSupply().get(9);
		fish.Boost();
		fish = (FishIngredientButton) ChefZoneGUI.getIngredientpane().getSupply().get(13);
		fish.Boost();
		ChefZoneController.boostCountdown(20, FishBoostButton);
		ChefZoneController.soundPlay("sound/BoostSound.wav");
	}

	private void defineVeggiBoostButton() {

		VeggiBoostButton.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		VeggiBoostButton.setTextFill(Color.MAROON);
		VeggiBoostButton.setPrefSize(90, 60);
		Image veggiImage = new Image("ButtonImage/VeggiBoostButton.png", 55, 65, false, false);
		BackgroundImage veggiBackground = new BackgroundImage(veggiImage, null, null, null, null);
		VeggiBoostButton.setBackground(new Background(veggiBackground));

		VeggiBoostButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				veggiBoostButtonHandler();
			}
		});

	}

	private void veggiBoostButtonHandler() {

		VeggiBoostButton.setDisable(true);
		logic.ChefZoneController.setVeggiBoost(true);

		VeggiIngredientButton veggi;
		veggi = (VeggiIngredientButton) ChefZoneGUI.getIngredientpane().getSupply().get(0);
		veggi.Boost();
		veggi = (VeggiIngredientButton) ChefZoneGUI.getIngredientpane().getSupply().get(1);
		veggi.Boost();
		veggi = (VeggiIngredientButton) ChefZoneGUI.getIngredientpane().getSupply().get(11);
		veggi.Boost();
		ChefZoneController.boostCountdown(20, VeggiBoostButton);
		ChefZoneController.soundPlay("sound/BoostSound.wav");
	}

	public Button getFreeBoostButton() {
		return FreeBoostButton;
	}

	public Button getVeggiBoostButton() {
		return VeggiBoostButton;
	}

	public Button getFishBoostButton() {
		return FishBoostButton;
	}

}
