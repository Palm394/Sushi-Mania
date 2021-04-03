package model;

import java.util.ArrayList;

public class Food {//implement Updatable
	private String name;
	private double timeToCook;
	private boolean isEat;
	
	//position of food after serving
	private double PosX;
	private double PosY;
	
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public Food(String name,double time) {
		this.name = name ;
		this.timeToCook = time ;
		this.isEat = false;
		
		//Initialize for find position of food after serving 
		PosX = 0;
		PosY = 0;
	}
	
	public void addIngredients(ArrayList<Ingredient> ingredients) {
		for(Ingredient i : ingredients) {
			ingredients.add(i);
		}
	}
	
}
