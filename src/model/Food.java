package model;

import java.util.ArrayList;

import gui.CustomerGUI;
import gui.gamePane;
import model.base.Updatable;

public class Food implements Updatable {
	private String name;
	private double timeToCook;
	private boolean isEat;
	
	//position of food after serving
	private double PosX;
	private double PosY;
	
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public Food(String name,double time) {
		this.setName(name) ;
		this.timeToCook = time ;
		this.isEat = false;
		
		//Initialize for find position of food after serving 
		setPosX(0);
		setPosY(0);
	}
	
	public void addIngredients(ArrayList<Ingredient> ingredients) {
		for(Ingredient i : ingredients) {
			ingredients.add(i);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		if(PosX > gamePane.WIDTH_SCREEN) {
			PosX = -15;
		}
		this.setPosX(PosX+1);
		
		for(Customer i : CustomerGUI.getCustomerList()) {
			if(i.isDetect(this) != -1) {
				System.out.println("Palm's Debug : Detect with Customer" + i.getNumber());
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
}
