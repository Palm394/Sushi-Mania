package application;

import java.util.ArrayList;

import logic.ChefZoneController;
import model.FoodList;
import model.Ingredient;

public class Database {
	private static ArrayList<FoodList> hasMenu = new ArrayList<FoodList>();
	private static ArrayList<Ingredient> hasIngredient = new ArrayList<Ingredient>();
	
	
	public static void initialize() {
		//rice and seaweed
		hasIngredient.clear();
		hasIngredient.add(new Ingredient(1));
		hasIngredient.add(new Ingredient(15));
		// 15
		hasMenu.clear();
		hasMenu.add(new FoodList(15));	
		System.out.println("size="+hasIngredient.size());
		System.out.println("initialzed");
	}
	
	public static void newLV(int level) {
		switch(level) {
			case 2:
				//salmon
				hasIngredient.add(new Ingredient(9));
				// 3 32
				hasMenu.add(new FoodList(3));	
				hasMenu.add(new FoodList(32));	
				break;
			case 3:
				//sweet egg
				hasIngredient.add(new Ingredient(2));
				// 10
				hasMenu.add(new FoodList(10));
				break;
			case 4:
				//shrimp egg
				hasIngredient.add(new Ingredient(4));
				// 7 26
				hasMenu.add(new FoodList(7));
				hasMenu.add(new FoodList(26));
				break;
			case 5:
				//cucumber
				hasIngredient.add(new Ingredient(0));
				// 29
				hasMenu.add(new FoodList(29));
				break;
			case 6:
				//crab stick
				hasIngredient.add(new Ingredient(3));
				// 16 17
				hasMenu.add(new FoodList(16));
				hasMenu.add(new FoodList(17));
				break;
			case 7:
				//saba
				hasIngredient.add(new Ingredient(6));
				// 14 8
				hasMenu.add(new FoodList(14));
				hasMenu.add(new FoodList(8));
				break;
			case 8:
				//squid and shrimp
				hasIngredient.add(new Ingredient(8));
				hasIngredient.add(new Ingredient(5));
				// 12 13
				hasMenu.add(new FoodList(12));
				hasMenu.add(new FoodList(13));
				break;
			case 9:
				//Ikura
				hasIngredient.add(new Ingredient(10));
				// 2
				hasMenu.add(new FoodList(2));
				break;
			case 10:
				//avocado
				hasIngredient.add(new Ingredient(11));
				// 4
				hasMenu.add(new FoodList(4));
				break;
			case 11:
				hasIngredient.add(new Ingredient(7));
				// 5 6
				hasMenu.add(new FoodList(5));
				hasMenu.add(new FoodList(6));
				break;
			case 12:
				//scallop unangi and uni
				hasIngredient.add(new Ingredient(12));
				hasIngredient.add(new Ingredient(13));
				hasIngredient.add(new Ingredient(14));
				// 20 22 23 31 
				hasMenu.add(new FoodList(20));
				hasMenu.add(new FoodList(22));
				hasMenu.add(new FoodList(23));
				hasMenu.add(new FoodList(31));
				break;
			case 13:
				// 11
				hasMenu.add(new FoodList(11));	
				break;
			case 14:
				// 1
				hasMenu.add(new FoodList(1));	
				break;
			case 15:
				// 27
				hasMenu.add(new FoodList(27));	
				break;
			case 16:
				// 28
				hasMenu.add(new FoodList(28));	
				break;
			case 17:
				// 9
				hasMenu.add(new FoodList(9));	
				break;
			case 18:
				// 19
				hasMenu.add(new FoodList(19));	
				break;
			case 19:
				// 18
				hasMenu.add(new FoodList(18));	
				break;
			case 21:
				// 30
				hasMenu.add(new FoodList(30));	
				break;
			case 23:
				// 21
				hasMenu.add(new FoodList(21));	
				break;
			case 25:
				// 24
				hasMenu.add(new FoodList(24));	
				break;
			case 27:
				//
				hasMenu.add(new FoodList(27));	
				break;
		}
		ChefZoneController.update();
	}

	public static ArrayList<FoodList> getHasMenu() {
		return hasMenu;
	}

	public static ArrayList<Ingredient> getHasIngredient() {
		return hasIngredient;
	}
}
