package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import logic.ChefZoneController;
import model.base.Boostable;

public class FishIngredientButton extends IngredientButton implements Boostable {

	public FishIngredientButton(Ingredient ingredient) {

		super(ingredient);

		this.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				fishIngredientButtonHandler();
			}
		});
	}

	@Override
	public void Boost() {
		// TODO Auto-generated method stub
		this.setStyle("-fx-background-color: yellow;");
		ChefZoneController.boostCountdown(20, this);
	}

	public void fishIngredientButtonHandler() {
		FishIngredientButton button = this;
		ChefZoneController.addIngredient(button);

		if (ChefZoneController.isFishBoost() == true) {
			ChefZoneController.setExtraScore(ChefZoneController.getExtraScore() + 10);
		}
	}
}
