package model;

import model.base.Boostable;

public class VeggiIngredientButton extends IngredientButton implements Boostable {
	public VeggiIngredientButton(Ingredient ingredient) {
		super(ingredient);
		this.setStyle("-fx-background-color: green;");
	}

	@Override
	public void Boost() {
		// TODO Auto-generated method stub
		
	}


}
