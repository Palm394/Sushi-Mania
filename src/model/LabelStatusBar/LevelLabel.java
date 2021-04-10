package model.LabelStatusBar;

import logic.GameController;
import model.LabelStatus;

public class LevelLabel extends LabelStatus{

	public LevelLabel() {
		super("Level");
	}

	@Override
	protected void setSentence() {
		this.textProperty().setValue("Level : " + GameController.getLevel());
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		setSentence();
	}

}
