package model;

public class Customer {
	
	//order integer is sorting customer to check food to detect.
	private final int number;
	
	private String want;
	
	private final double PosX;
	private final double CheckPoint;
	
	private final double PADDING = 100;
	
	public Customer(int number) {
		this.number = number;
		PosX = PADDING + number*125;
		CheckPoint = PosX + 25;
	}

	public double getPosX() {
		return PosX;
	}

	public int getNumber() {
		return number;
	}
	
	public boolean isDetect(Food food) {
		return food.getPosX() == CheckPoint && food.getName() == want;
	}
}
