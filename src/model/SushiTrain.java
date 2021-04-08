package model;

import java.util.ArrayList;

import gui.SushiTrainGUI;

public class SushiTrain {
	private static ArrayList<Food> TrainList;
	
	public static void initialize() {
		TrainList = new ArrayList<Food>();
	}
	
	public static void addNewDish(Food newFood) {
			TrainList.add(newFood);
			SushiTrainGUI.getTrainDraw().add(newFood);
	}
	
	public static void update() {
		for(Food e : TrainList) {
			e.update();
		}
	}
	
	public static ArrayList<Food> getTrainList() {
			return TrainList;
	}

}
