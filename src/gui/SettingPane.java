package gui;

import application.Utility;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import model.AlertPane;

public class SettingPane extends AlertPane {

	public SettingPane(String title, double W, double H) {
		super(title, W, H);
		setSliderVol();
	}
	
	@Override
	protected void addCenter() {
		Label Sound_Label = new Label("Sound Volume");
		center.getChildren().add(Sound_Label);
		
		center.getChildren().add(setSliderVol());
		center.getChildren().add(backToMenu());
	}

	private Slider setSliderVol() {
		Slider slider = new Slider(0, 1, Utility.addScoreSound.getVolume());
		slider.setMaxWidth(300);
		
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				Utility.setAllVolume((double) newValue);
			}

		});
		return slider;
	}

}
