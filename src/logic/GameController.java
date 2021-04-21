package logic;

import application.Database;
import application.Utility;
import gui.GameOverPane;
import gui.LevelUpPane;
import gui.StatusBar;
import gui.SushiTrainGUI;
import gui.gamePane;
import javafx.animation.AnimationTimer;
import model.AlertPane;
import model.SushiTrain;

public class GameController {
	
	private static int Score;
	private static int Level;
	private static int Target;
	private static int timer;
	//second unit
	private final static int timeEachRound = 120;
	
	private static AnimationTimer animation;
	private static TimerController time_left;
	private static OrderController order_time;
	
	public static void initialize() {
		Score = 200;
		Level = 1;
		Target = 500;
		
		animation = new AnimationTimer() {
			public void handle(long now) {
				SushiTrain.update();
				SushiTrainGUI.paintComponent();

				if(timer == 0) {
					timer = timeEachRound;
					if(Score >= Target) {
						Utility.NewLevelSound.play();
						newLevel();
					}else {
						//GameOver
						AlertPane gameOver = new GameOverPane("Game Over",gamePane.getWidthScreen(),gamePane.getHeightScreen());
						gamePane.getGameStage().setScene(gameOver.getScene());
					}
					
				}
			}
		};
		startGame();
	}
	
	public static void addScore(int number) {
		Score += number;
		Utility.EatSound.play();
		StatusBar.getScoreLabel().update();
	}
	
	private static void newLevel() {
		Level += 1;
		Target += 100;
		StatusBar.getTargetLabel().update();
		StatusBar.getLevelLabel().update();
		
		Database.newLV(Level);
		LevelUpPane levelup = new LevelUpPane("Level UP!",gamePane.WIDTH_SCREEN,gamePane.HEIGHT_SCREEN);
		gamePane.getGameStage().setScene(levelup.getScene());

	}
	
	private static void startGame() {
		time_left = new TimerController();
		order_time = new OrderController();
		animation.start();
	}
	
	public static void pauseGame() {
		time_left.stop();
		order_time.stop();
		animation.stop();
	}
	
	public static void continueGame() {
		time_left.getTimeline().play();;
		order_time.getTimeline().play();;
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
