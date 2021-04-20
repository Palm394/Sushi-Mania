package model;

import gui.CustomerGUI;
import gui.gamePane;
import logic.GameController;
import model.base.Updatable;

public class Food implements Updatable {
	private boolean isEat = false;
	protected String name;
	//position of food after serving
	private double PosX = 0;
	private double PosY = 0;

	@Override
	public void update() {
		if(!isEat) {
			if(PosX > gamePane.WIDTH_SCREEN) {
				PosX = -15;
			}
			this.setPosX(PosX + 1);
			
			for(Customer i : CustomerGUI.getCustomerList()) {
				if(i.isDetect(this) != -1 && i.getWant() == name) {
					isEat = true;
					i.setWant(null);
					GameController.addScore(10);
					CustomerGUI.drawWant();
				}
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
