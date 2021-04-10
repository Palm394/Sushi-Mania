package model.LabelStatusBar;

import logic.GameController;
import model.LabelStatus;

public class TargetLabel extends LabelStatus {

	public TargetLabel() {
		super("Target");
	}

	@Override
	protected void setSentence() {
		this.textProperty().setValue("Target : " + GameController.getTarget());
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		setSentence();
	}

}