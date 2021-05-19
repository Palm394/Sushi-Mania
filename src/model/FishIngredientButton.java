package model;

import logic.ChefZoneController;
import model.base.Boostable;

public class FishIngredientButton extends IngredientButton implements Boostable {

	public FishIngredientButton(Ingredient ingredient) {
		
		super(ingredient);
		
	}

	@Override
	public void Boost() {
		
		// TODO Auto-generated method stub
		this.setStyle("-fx-background-color: yellow;");
		ChefZoneController.countdown(20, this);
	}
}
