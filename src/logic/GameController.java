package logic;

import gui.gamePane;
import javafx.animation.AnimationTimer;

public class GameController {
	
	private static int Score;
	private static int Level;
	private static int Target;
	private static boolean isGameOver;
	
	public static void initialize() {
		Score = 0;
		Level = 1;
		//Target = ;
		isGameOver = false;
		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gamePane.paintComponent();
//				logic.logicUpdate();
//				RenderableHolder.getInstance().update();
//				InputUtility.updateInputState();
			}
		};
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
	
}
