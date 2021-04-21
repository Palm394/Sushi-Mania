package application;

import java.util.ArrayList;

import gui.ChefZoneGUI;
import logic.ChefZoneController;
import model.FoodList;
import model.Ingredient;

public class Database {
	private static ArrayList<FoodList> hasMenu = new ArrayList<FoodList>();
	private static ArrayList<Ingredient> hasIngredient = new ArrayList<Ingredient>();
	
	
	public static void initialize() {
		//Mock for level 1
		hasMenu.add(new FoodList(28697817));
		hasIngredient.add(new Ingredient(1));
		hasIngredient.add(new Ingredient(15));
	}
	
	public static void newLV(int level) {
		switch(level) {
			case 2:
				hasIngredient.add(new Ingredient(3));
				hasIngredient.add(new Ingredient(8));
				hasMenu.add(new FoodList(14407959));
				hasMenu.add(new FoodList(14368590));
			case 3:
				hasMenu.add(new FoodList(14545740));
		}
		ChefZoneController.updateIngredientButton();
		ChefZoneController.updateShopList();
	}

	public static ArrayList<FoodList> getHasMenu() {
		return hasMenu;
	}

	public static ArrayList<Ingredient> getHasIngredient() {
		return hasIngredient;
	}
}
