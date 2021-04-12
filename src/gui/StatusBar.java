package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import logic.GameController;
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
	private static Button menu_button;
	
	public StatusBar() {
		this.setPrefHeight(HEIGHT);
		this.setBackground(new Background(new BackgroundFill(Color.ORANGE.brighter(), CornerRadii.EMPTY, Insets.EMPTY)));
		this.setAlignment(Pos.CENTER);
		
		score_label = new ScoreLabel();
		this.getChildren().add(score_label);
		
		target_label = new TargetLabel();
		this.getChildren().add(target_label);
		
		timer_label = new TimerLabel();
		this.getChildren().add(timer_label);
		
		level_label = new LevelLabel();
		this.getChildren().add(level_label);
		
		menu_button = new Button("Menu");
		menu_button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				GameController.pauseGame();
//				AlertPane choice = new GameOverPane("Game Over",gamePane.getWidthScreen(),gamePane.getHeightScreen());
//				gamePane.getGameStage().setScene(choice.getScene());
			}
			
		});
		this.getChildren().add(menu_button);
		
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
