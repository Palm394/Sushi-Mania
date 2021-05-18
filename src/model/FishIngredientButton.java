package model;

import model.base.Boostable;

public class FishIngredientButton extends IngredientButton implements Boostable {

	public FishIngredientButton(Ingredient ingredient) {
		super(ingredient);
		// TODO Auto-generated constructor stub
		this.setStyle("-fx-background-color: yellow;");
	}

	@Override
	public void Boost() {
		// TODO Auto-generated method stub
		
	}
}
