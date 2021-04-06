package model;

import java.util.ArrayList;

import gui.SushiTrainPart;

public class SushiTrain {
	private final int maxDish = 10;
	private static ArrayList<Food> TrainList;
	
	public SushiTrain() {
		TrainList = new ArrayList<Food>(maxDish);
	}
	
	public static void addNewDish(Food newFood) {
		try {
			TrainList.add(newFood);
			SushiTrainPart.drawNewDish(newFood);
		}catch(ArrayIndexOutOfBoundsException e)
		{
			//Implement!
		}
		
	}

}
