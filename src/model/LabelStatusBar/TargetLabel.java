package model.LabelStatusBar;

import logic.GameController;
import model.LabelStatus;
import model.base.Updatable;

public class TargetLabel extends LabelStatus implements Updatable {
	
	@Override
	protected void setSentence() {
		this.textProperty().setValue(" : " + GameController.getTarget());
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		setSentence();
	}

}
