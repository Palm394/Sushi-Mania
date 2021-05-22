package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import logic.ChefZoneController;

public class RollPane extends GridPane {
	public RollPane() {

		this.setPadding(new Insets(20, 20, 20, 20));
		this.setPrefHeight(180);
		this.setPrefWidth(280);
		this.setHgap(5);
		this.setVgap(5);
		this.setAlignment(Pos.CENTER);
		Image bambooMat = new Image("bambooMat.jpg");
		this.setBackground(new Background(new BackgroundImage(bambooMat, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
	}

	public void updateIngredient() {
		for (int i = 0; i < 12; i++) {
			if (i < Math.min(ChefZoneController.getWrapper().size(), 12)) {
				ImageView image = new ImageView(ChefZoneController.getWrapper().get(i).getUrl());
				image.setPreserveRatio(true);
				image.setFitWidth(80);
				image.setFitHeight(40);
				this.add(image, i - ((i / 4) * 4), i / 4);
			}
		}
	}

	public void removeIngredient() {
		this.getChildren().clear();
	}
}
