package model;

import java.util.ArrayList;

public class Food {
	private String name;
	private double timeToCook;
	private ArrayList<ingredient> ingredients = new ArrayList<ingredient>();
	
	public Food(String name,double time) {
		this.name = name ;
		this.timeToCook = time ;
	}
	
	public void addIngredients(ArrayList<ingredient> ingredients) {
		for(ingredient i : ingredients) {
			ingredients.add(i);
		}
	}
	
}
