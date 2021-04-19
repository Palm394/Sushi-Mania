package application;

import java.util.ArrayList;

import model.FoodList;

public class Database {
	private static ArrayList<FoodList> hasMenu = new ArrayList<FoodList>();
	
	public static void initialize() {
		//Mock for level 1
		hasMenu.add(new FoodList(28700092));
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
}
