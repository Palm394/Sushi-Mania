package gui;

import model.AlertPane;

public class LevelUpPane extends AlertPane{

	public LevelUpPane(String title, double W, double H) {
		super(title, W, H);
		top.getChildren().remove(0);
	}

	@Override
	protected void addCenter() {
		center.getChildren().add(continueButton());
	}

	private void newMenu() {
		
	}
}
