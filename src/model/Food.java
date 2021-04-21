package model;

import gui.CustomerGUI;
import gui.SushiTrainGUI;
import gui.gamePane;
import logic.GameController;
import model.base.Updatable;

public class Food implements Updatable {
	protected String name;
	protected int price;
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
			if(i.isDetect(this) != -1 && ((i.getWant() == name) || (i.getWant()!=null && name == "unknown"))) {
				i.setWant(null);
				GameController.addScore(price);
				CustomerGUI.drawWant();
				SushiTrainGUI.getTrainDraw().remove(this);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
