package model;

import java.util.ArrayList;

public class SushiTrain {
	private final int maxDish = 10;
	private static ArrayList<Food> List;
	
	public SushiTrain() {
		List = new ArrayList<Food>(maxDish);
	}
	
	public static void addNewDish(Food food) {
		try {
			List.add(food);
		}catch(ArrayIndexOutOfBoundsException e)
		{
			//Implement!
		}
		
	}

}
