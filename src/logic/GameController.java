package logic;

import gui.StatusBar;
import gui.SushiTrainGUI;
import javafx.animation.AnimationTimer;
import model.SushiTrain;

public class GameController {
	
	private static int Score;
	private static int Level;
	private static int Target;
	private static boolean isGameOver;
	private static AnimationTimer animation;
	
	private static int timer;
	
	//second unit
	private final static int timeEachRound = 60;
	
	public static void initialize() {
		Score = 0;
		Level = 1;
		Target = 100;
		isGameOver = false;
		
		DurationTime.initialize();
		OrderController.initialize();
		
		animation = new AnimationTimer() {
			public void handle(long now) {
				SushiTrain.update();
				SushiTrainGUI.paintComponent();
				
				if(timer == 0) {
					animation.stop();
					//GameOver
				}
			}
		};
		animation.start();
	}
	
	public static void addScore(int number) {
		Score += number;
		if(Score >= Target) {
			newLevel();
		}
		StatusBar.getScoreLabel().update();
	}
	
	private static void newLevel() {
		Level += 1;
		Target = Level * 100;
		StatusBar.getTargetLabel().update();
		StatusBar.getLevelLabel().update();
		
//		DurationTime.stop();
//		OrderController.stop();
//		animation.stop();
		
		//Should have ALERT to User
		//New Menu ~~Yummy!
		//and Clock.initialize again
	}
	
	//Getter & Setter methods
	public static int getScore() {
		return Score;
	}
	public static void setScore(int score) {
		Score = score;
	}
	public static int getLevel() {
		return Level;
	}
	public static void setLevel(int level) {
		Level = level;
	}
	public static boolean isGameOver() {
		return isGameOver;
	}
	public static void setGameOver(boolean isGameOver) {
		GameController.isGameOver = isGameOver;
	}
	public static int getTarget() {
		return Target;
	}
	public static void setTarget(int target) {
		Target = target;
	}

	public static int getTimer() {
		return timer;
	}

	public static void setTimer(int timer) {
		GameController.timer = timer;
	}

	public static int getTimeeachround() {
		return timeEachRound;
	}
	
}
