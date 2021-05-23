package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import logic.ChefZoneController;
import model.base.Boostable;

public class VeggiIngredientButton extends IngredientButton implements Boostable {
	public VeggiIngredientButton(Ingredient ingredient) {

		super(ingredient);

		this.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				veggiIgredientButtonHandler();
			}
		});
	}

	@Override
	public void Boost() {

		// TODO Auto-generated method stub
		this.setStyle("-fx-background-color: lime;");
		ChefZoneController.boostCountdown(20, this);

	}

	public void veggiIgredientButtonHandler() {
		VeggiIngredientButton button = this;

		ChefZoneController.addIngredient(button);

		if (ChefZoneController.isVeggiBoost() == true) {
			ChefZoneController.setExtraScore(ChefZoneController.getExtraScore() + 7);
		}
	}

}
