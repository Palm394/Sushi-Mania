package gui;

import model.AlertPane;

public class SettingPane extends AlertPane{

	public SettingPane(String title, double W, double H) {
		super(title, W, H);
	}

	@Override
	protected void addCenter() {
		center.getChildren().add(backToMenu());
	}

}
