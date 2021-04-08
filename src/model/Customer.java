package model;

public class Customer {
	
	//order integer is sorting customer to check food to detect.
	private int number;
	
	private String want;
	
	private final double PosX;
	
	private final double PADDING = 100;
	
	public Customer(int number) {
		this.number = number;
		PosX = PADDING + number*125;
	}

	public double getPosX() {
		return PosX;
	}

	public int getNumber() {
		return number;
	}
	
	public int isDetect(Food food) {
		if(Math.abs(food.getPosX() - PosX) == 0 ) {//&& food.getName() == want
			return number;
		}else {
			return -1;
		}
	}
}
