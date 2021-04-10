package model.LabelStatusBar;

import logic.GameController;
import model.LabelStatus;

public class TimerLabel extends LabelStatus {

	@Override
	public void update() {
		// TODO Auto-generated method stub
		setSentence();
	}

	@Override
	protected void setSentence() {
		// TODO Auto-generated method stub
		this.textProperty().setValue("เร่งมือหน่อยครับเชฟ : " + GameController.getTarget() + " s");
	}

}
