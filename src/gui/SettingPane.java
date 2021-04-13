package gui;

import application.Utility;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import model.AlertPane;

public class SettingPane extends AlertPane {

	public SettingPane(String title, double W, double H) {
		super(title, W, H);
		setSliderVol();
	}

	private Slider setSliderVol() {
		Slider slider = new Slider(0, 1, Utility.addScoreSound.getVolume());
		slider.setMaxWidth(500);
		
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				Utility.setAllVolume((double) newValue);
			}

		});
		return slider;
	}

	@Override
	protected void addCenter() {
		center.getChildren().add(setSliderVol());
		center.getChildren().add(backToMenu());
	}

}
