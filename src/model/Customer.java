package model;

public class Customer {
	
	//order integer is sorting customer to check food to detect.
	private int number;
	
	private String want;
	private String wantURL;
	private int waitTime = 0;
	
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
		if(food.getPosX() + 15 == PosX ) {
			return number;
		}else {
			return -1;
		}
	}

	public String getWant() {
		return want;
	}

	public void setWant(String want) {
		this.want = want;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	public String getWantURL() {
		return wantURL;
	}

	public void setWantURL(String wantURL) {
		this.wantURL = wantURL;
	}
}
