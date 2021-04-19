package model;

import gui.CustomerGUI;
import gui.gamePane;
import logic.GameController;
import model.base.Updatable;

public class Food implements Updatable {
	private boolean isEat = false;
	
	//position of food after serving
	private double PosX = 0;
	private double PosY = 0;

	@Override
	public void update() {
		if(PosX > gamePane.WIDTH_SCREEN) {
			PosX = -15;
		}
		this.setPosX(PosX + 1);
		
		for(Customer i : CustomerGUI.getCustomerList()) {
			if(i.isDetect(this) != -1) {
				System.out.println("Palm's Debug : Detect with Customer" + i.getNumber());
				isEat = true;
				i.setWant(null);
				GameController.addScore(10);
			}
		}
	}

	public double getPosX() {
		return PosX;
	}

	public void setPosX(double posX) {
		PosX = posX;
	}

	public double getPosY() {
		return PosY;
	}

	public void setPosY(double posY) {
		PosY = posY;
	}

	public boolean isEat() {
		return isEat;
	}
}
