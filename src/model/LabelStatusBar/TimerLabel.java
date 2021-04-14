package model.LabelStatusBar;

import logic.GameController;
import model.LabelStatus;
import model.base.Updatable;

public class TimerLabel extends LabelStatus implements Updatable {

	@Override
	public void update() {
		// TODO Auto-generated method stub
		setSentence();
	}

	@Override
	protected void setSentence() {
		// TODO Auto-generated method stub
		this.textProperty().setValue("  : " + GameController.getTimer() + " s");
	}

}
