package model;

import java.util.ArrayList;

public class Food {
	private String name;
	private double timeToCook;
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public Food(String name,double time) {
		this.name = name ;
		this.timeToCook = time ;
	}
	
	public void addIngredients(ArrayList<Ingredient> ingredients) {
		for(Ingredient i : ingredients) {
			ingredients.add(i);
		}
	}
	
}
