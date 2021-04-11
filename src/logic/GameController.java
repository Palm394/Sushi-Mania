package logic;

import gui.StatusBar;
import gui.SushiTrainGUI;
import javafx.animation.AnimationTimer;
import model.SushiTrain;

public class GameController {
	
	private static int Score;
	private static int Level;
	private static int Target;
	private static int timer;
	//second unit
	private final static int timeEachRound = 60;
	
	private static AnimationTimer animation;
	private static DurationTime time_left;
	private static OrderController order_time;
	
	public static void initialize() {
		Score = 0;
		Level = 1;
		Target = 100;
		
		animation = new AnimationTimer() {
			public void handle(long now) {
				SushiTrain.update();
				SushiTrainGUI.paintComponent();
				
				if(timer == 0) {
					pauseGame();
					//GameOver
				}
			}
		};
		startGame();
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
		
		pauseGame();
		
		//Should have ALERT to User
		//New Menu ~~Yummy!
	}
	
	private static void startGame() {
		time_left = new DurationTime();
		order_time = new OrderController();
		animation.start();
	}
	
	private static void pauseGame() {
		time_left.stop();
		order_time.stop();
		animation.stop();
	}
	
	private static void continueGame() {
		time_left = new DurationTime();
		order_time = new OrderController();
		animation.start();
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
