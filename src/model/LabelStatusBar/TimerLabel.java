package model.LabelStatusBar;

import logic.GameController;
import model.LabelStatus;

public class TimerLabel extends LabelStatus {

	@Override
	protected void setSentence() {
		// TODO Auto-generated method stub
		this.textProperty().setValue("  : " + GameController.getTimer() + " s");
	}

}
