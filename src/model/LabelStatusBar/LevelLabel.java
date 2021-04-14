package model.LabelStatusBar;

import logic.GameController;
import model.LabelStatus;
import model.base.Updatable;

public class LevelLabel extends LabelStatus implements Updatable {

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
