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
		hasIngredient.add(new Ingredient(1));
		hasIngredient.add(new Ingredient(15));
		//onigiri
		hasMenu.add(new FoodList(28697817));	
		System.out.println("size="+hasIngredient.size());
	}
	
	public static void newLV(int level) {
		switch(level) {
			case 2:
				//salmon
				hasIngredient.add(new Ingredient(9));
				// 3 32
				hasMenu.add(new FoodList(14368590));	
				hasMenu.add(new FoodList(39366));	
				break;
			case 3:
				//sweet egg
				hasIngredient.add(new Ingredient(2));
				// 10
				hasMenu.add(new FoodList(14348919));
				break;
			case 4:
				//shrimp egg
				hasIngredient.add(new Ingredient(4));
				// 7 26
				hasMenu.add(new FoodList(14348991));
				hasMenu.add(new FoodList(28717506));
				break;
			case 5:
				//cucumber
				hasIngredient.add(new Ingredient(0));
				// 29
				hasMenu.add(new FoodList(14368602));
				break;
			case 6:
				//crab stick
				hasIngredient.add(new Ingredient(3));
				// 16 17
				hasMenu.add(new FoodList(14368594));
				hasMenu.add(new FoodList(14348937));
				break;
			case 7:
				//saba
				hasIngredient.add(new Ingredient(6));
				// 14 8
				hasMenu.add(new FoodList(14349636));
				hasMenu.add(new FoodList(28697905));
				break;
			case 8:
				//squid and shrimp
				hasIngredient.add(new Ingredient(8));
				hasIngredient.add(new Ingredient(5));
				// 12 13
				hasMenu.add(new FoodList(14349150));
				hasMenu.add(new FoodList(14355471));
				break;
			case 9:
				//Ikura
				hasIngredient.add(new Ingredient(10));
				// 2
				hasMenu.add(new FoodList(14407959));
				break;
			case 10:
				//avocado
				hasIngredient.add(new Ingredient(11));
				// 4
				hasMenu.add(new FoodList(14545740));
				break;
			case 11:
				hasIngredient.add(new Ingredient(7));
				// 5 6
				hasMenu.add(new FoodList(14351094));
				hasMenu.add(new FoodList(14390461));
				break;
			case 12:
				//scallop unangi and uni
				hasIngredient.add(new Ingredient(12));
				hasIngredient.add(new Ingredient(13));
				hasIngredient.add(new Ingredient(14));
				// 20 22 23 31 
				hasMenu.add(new FoodList(14880348));
				hasMenu.add(new FoodList(19131879));
				hasMenu.add(new FoodList(15943233));
				hasMenu.add(new FoodList(553311));
				break;
			case 13:
				// 11
				hasMenu.add(new FoodList(14372965));	
				break;
			case 14:
				// 1
				hasMenu.add(new FoodList(28700092));	
				break;
			case 15:
				// 27
				hasMenu.add(new FoodList(29071827));	
				break;
			case 16:
				// 28
				hasMenu.add(new FoodList(28896867));	
				break;
			case 17:
				// 9
				hasMenu.add(new FoodList(28719775));	
				break;
			case 18:
				// 19
				hasMenu.add(new FoodList(14526175));	
				break;
			case 19:
				// 18
				hasMenu.add(new FoodList(28717618));	
				break;
			case 21:
				// 30
				hasMenu.add(new FoodList(43086108));	
				break;
			case 23:
				// 21
				hasMenu.add(new FoodList(43086108));	
				break;
			case 25:
				// 24
				hasMenu.add(new FoodList(28700018));	
				break;
			case 27:
				//
				hasMenu.add(new FoodList(43051111));	
				break;
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
