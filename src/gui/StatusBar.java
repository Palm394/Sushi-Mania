package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.AlertPane;
import model.LabelStatusBar.LevelLabel;
import model.LabelStatusBar.ScoreLabel;
import model.LabelStatusBar.TargetLabel;
import model.LabelStatusBar.TimerLabel;

public class StatusBar extends HBox {
	
	private final double HEIGHT = 50;
	private static ScoreLabel score_label;
	private static TargetLabel target_label;
	private static LevelLabel level_label;
	private static TimerLabel timer_label;
	private static Button setting_button;
	
	public StatusBar() {
		this.setPrefHeight(HEIGHT);
		this.setBackground(new Background(new BackgroundFill(Color.web("#c2e39c"), CornerRadii.EMPTY, Insets.EMPTY)));
		this.setAlignment(Pos.CENTER);
		
	    this.getChildren().add(createIcon("money.png",48,48));
		score_label = new ScoreLabel();
		this.getChildren().add(score_label);

	    this.getChildren().add(createIcon("goal_icon.png",48,48));
		target_label = new TargetLabel();
		this.getChildren().add(target_label);
		
	    this.getChildren().add(createIcon("timer.png",45,45));
		timer_label = new TimerLabel();
		this.getChildren().add(timer_label);
		
		level_label = new LevelLabel();
		this.getChildren().add(level_label);
		
		setting_button = new Button();
		
	    setting_button.setStyle("-fx-background-color: transparent;");
	    setting_button.setGraphic(createIcon("settingIcon.png",50,50));
	    
		setting_button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				AlertPane settings = new SettingPane("Settings",gamePane.getWidthScreen(),gamePane.getHeightScreen());
				gamePane.getGameStage().setScene(settings.getScene());
			}
			
		});
		this.getChildren().add(setting_button);
		
	}
	
	private static ImageView createIcon(String i,int W,int H) {
		Image img = new Image(ClassLoader.getSystemResource(i).toString());
	    ImageView view = new ImageView(img);
	    view.setFitHeight(W);
	    view.setFitWidth(H);
		return view;
	}
	
	public static ScoreLabel getScoreLabel() {
		return score_label;
	}

	public static TargetLabel getTargetLabel() {
		return target_label;
	}

	public static LevelLabel getLevelLabel() {
		return level_label;
	}

	public static TimerLabel getTimerLabel() {
		return timer_label;
	}

}
