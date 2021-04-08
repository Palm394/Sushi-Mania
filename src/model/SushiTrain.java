package model;

import java.util.ArrayList;

import gui.SushiTrainGUI;

public class SushiTrain {
	private final static int maxDish = 10;
	private static ArrayList<Food> TrainList;
	
	public static void initialize() {
		TrainList = new ArrayList<Food>(maxDish);
	}
	
	public static void addNewDish(Food newFood) {
		try {
			TrainList.add(newFood);
			SushiTrainGUI.drawDish(newFood);
		}catch(ArrayIndexOutOfBoundsException e)
		{
			//Implement!
		}
	}

	public static void removeDish(Food food) {
		//TrainList.remove(food);
	}
	
	public static ArrayList<Food> getTrainList() {
		return TrainList;
	}

}
