package logic;

import application.Database;
import application.Utility;
import gui.ChefZoneGUI;
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
	
	private static long lastTimeTriggered;
	
	public static void initialize() {
		Score = 500;
		Level = 1;
		Target = 1000;
		lastTimeTriggered = -1;
		//setup for chef zone
		for(int i=0;i<=15;i++) {
			if(i!=1 && i!=15) {
				ChefZoneGUI.getIngredientpane().getSupply().get(i).setDisable(true);
			}
			ChefZoneGUI.getIngredientpane().getSupply().get(i).getIngredient().setRemain(10);
			ChefZoneGUI.getIngredientpane().getSupply().get(i).setText("10");
			ChefZoneController.goBackNormal(ChefZoneGUI.getIngredientpane().getSupply().get(i));
		}
		ChefZoneController.getWrapper().clear();
		ChefZoneController.setExtraScore(0);
		ChefZoneController.setVeggiBoost(false);
		ChefZoneController.setFishBoost(false);
		ChefZoneController.setFreeBoost(false);
		
		animation = new AnimationTimer() {
			
			public void handle(long now) {
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				if(now - lastTimeTriggered >= 30000000)
				{
					SushiTrain.update();
					SushiTrainGUI.paintComponent();
		
					lastTimeTriggered = now;
					
					if(timer == 0) {
						timer = timeEachRound;
						if(Score >= Target) {
							Utility.NewLevelSound.play();
							newLevel();
						}else {
							//GameOver
							AlertPane gameOver = new GameOverPane("Game Over",gamePane.getWidthScreen(),gamePane.getHeightScreen(),true);
							gamePane.getGameStage().setScene(gameOver.getScene());
						}
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
		Target += 500;
		StatusBar.getTargetLabel().update();
		StatusBar.getLevelLabel().update();
		
		Database.newLV(Level);
		LevelUpPane levelup = new LevelUpPane("Level UP!",gamePane.WIDTH_SCREEN,gamePane.HEIGHT_SCREEN,true);
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
