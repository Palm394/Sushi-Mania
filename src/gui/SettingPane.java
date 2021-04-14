package gui;

import java.text.DecimalFormat;

import application.Utility;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;
import model.AlertPane;

public class SettingPane extends AlertPane {

	private Label Sound_Label;
	
	public SettingPane(String title, double W, double H) {
		super(title, W, H);
		setSliderVol();
	}
	
	@Override
	protected void addCenter() {
		Sound_Label = new Label("Sound Volume : " + 50);
		Sound_Label.setFont(new Font(20));
		center.getChildren().add(Sound_Label);
		
		center.getChildren().add(setSliderVol());
		center.getChildren().add(backToMenu());
	}

	private Slider setSliderVol() {
		Slider slider = new Slider(0, 1, Utility.volume);
		slider.setMaxWidth(300);
		
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				Utility.setAllVolume((double) newValue);
				Sound_Label.setText("Sound Volume : " + ((int)(Utility.volume *100)));
			}

		});
		return slider;
	}

}
