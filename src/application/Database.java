package application;

import java.util.ArrayList;

import model.FoodList;
import model.Ingredient;

public class Database {
	private static ArrayList<FoodList> hasMenu = new ArrayList<FoodList>();
	private static ArrayList<Ingredient> hasIngredient = new ArrayList<Ingredient>();
	
	
	public static void initialize() {
		//Mock for level 1
		hasMenu.add(new FoodList(28700092));
		
		hasIngredient.add(new Ingredient(0));
	}
	
	public static void newLV(int level) {
		switch(level) {
			case 2:
				hasMenu.add(new FoodList(14407959));
				hasMenu.add(new FoodList(14368590));
			case 3:
				hasMenu.add(new FoodList(14545740));
		}
			
	}

	public static ArrayList<FoodList> getHasMenu() {
		return hasMenu;
	}

	public static ArrayList<Ingredient> getHasIngredient() {
		return hasIngredient;
	}
}
