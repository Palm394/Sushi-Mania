package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.LabelStatusBar.LevelLabel;
import model.LabelStatusBar.ScoreLabel;
import model.LabelStatusBar.TargetLabel;

public class StatusBar extends HBox {
	
	private final double HEIGHT = 50;
	private static ScoreLabel score_label;
	private static Label target_label;
	private static Label level_label;
	
	public StatusBar() {
		this.setPrefHeight(HEIGHT);
		this.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setAlignment(Pos.CENTER);
		
		score_label = new ScoreLabel();
		this.getChildren().add(score_label);
		
//		Label timer = new LabelStatus("Time-Left");
//		this.getChildren().add(timer);
		
		target_label = new TargetLabel();
		this.getChildren().add(target_label);
		
		level_label = new LevelLabel();
		this.getChildren().add(level_label);
		
	}

	public static ScoreLabel getScoreLabel() {
		return score_label;
	}

	public static Label getTarget() {
		return target_label;
	}

	public static Label getLevel() {
		return level_label;
	}
	
}
