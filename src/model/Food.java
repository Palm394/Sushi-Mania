package model;

import java.util.ArrayList;

public class Food {//implement Updatable
	private String name;
	private double timeToCook;
	private boolean isEat;
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public Food(String name,double time) {
		this.name = name ;
		this.timeToCook = time ;
		this.isEat = false;
	}
	
	public void addIngredients(ArrayList<Ingredient> ingredients) {
		for(Ingredient i : ingredients) {
			ingredients.add(i);
		}
	}
	
}
