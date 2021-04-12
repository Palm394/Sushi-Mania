package gui;

import model.AlertPane;

public class GameOverPane extends AlertPane{

	public GameOverPane(String title,double W, double H) {
		super(title,W, H);
		top.getChildren().remove(0);
	}

	@Override
	protected void addCenter() {
		// TODO Auto-generated method stub
		
	}

}
