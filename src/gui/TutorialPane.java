package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.ChefZoneController;

public class TutorialPane extends VBox {
	private int page = 0;
	private String[] text = new String[10];
	private String[] title = new String[10];
	public Scene scene;
	private Label titleText = new Label(title[page]);
	private Label description = new Label(text[page]);

	public TutorialPane() {
		// define tutorial description
		scene = new Scene(this, 400, 600);
		this.setAlignment(Pos.CENTER);
		Image image = new Image("FirstPage.jpg", 400, 600, false, false);
		BackgroundImage background = new BackgroundImage(image, null, null, null, null);
		this.setBackground(new Background(background));

		defineTutorialText();

		VBox textBox = new VBox();
		titleText.setText(title[page]);
		titleText.setTextFill(Color.WHITE);
		titleText.setStyle("-fx-font: 24 arial;");

		description.setText(text[page]);
		description.setTextFill(Color.WHITE);
		description.setWrapText(true);

		textBox.getChildren().add(titleText);
		textBox.getChildren().add(description);
		textBox.setSpacing(10);
		textBox.setPrefWidth(250);
		textBox.setPrefHeight(200);

		HBox tutorialRow = new HBox();
		tutorialRow.setAlignment(Pos.CENTER);
		tutorialRow.setSpacing(25);
		tutorialRow.getChildren().addAll(toLeftButton(), textBox, toRightButton());

		this.getChildren().add(tutorialRow);

		createBackToMenuButton();
	}

	public void createBackToMenuButton() {
		Button resumeButton = new Button("Back to menu");
		resumeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ChefZoneController.soundPlay("sound/ClickSound.wav");
				menuPane.backToMenu();
			}

		});
		this.getChildren().add(resumeButton);
	}

	private Button toLeftButton() {
		Button toLeft = new Button("<");
		toLeft.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				ChefZoneController.soundPlay("sound/ClickSound.wav");
				page = (page + 5) % 6;
				description.setText(text[page]);
				titleText.setText(title[page]);
			}
		});
		return toLeft;
	}

	private Button toRightButton() {
		Button toRight = new Button(">");
		toRight.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				ChefZoneController.soundPlay("sound/ClickSound.wav");
				page = (page + 1) % 6;
				description.setText(text[page]);
				titleText.setText(title[page]);
			}
		});
		return toRight;
	}

	private void defineTutorialText() {
		title[0] = "Objective";
		text[0] = "This game's objective is to serve customers the sushi as much as you can in provided time. "
				+ " You will get the price according to how hard it can be made.";

		title[1] = "Making sushi";
		text[1] = "You have to make sushi which match demand of customer by using propriate ingredient. "
				+ "Don't worry if you don't know how to make it. We have provided a super secret recipe for you!";

		title[2] = "Roll";
		text[2] = "When you prepare all the ingredient and sure it's correct recipe you have to click \"roll\" button"
				+ " in order to create a sushi. If it's correct, you will get the sushi on the train. But if it's not"
				+ " unknown sushi will appear instead";

		title[3] = "Clear";
		text[3] = "If you realiz that you prepare wrong ingredient you can use \"clear\" button in ordr too clear"
				+ " all recent ingredient but it will be cost 30";

		title[4] = "Ingredient shop";
		text[4] = "When the game start, some of ingredient are provided. But if it's not enough, you have to buy it"
				+ "by yourself. There are 2 ways to buy ingredient. First is buy normally which take a little bit time."
				+ " Another way is express buy which cost 10 more price but it's take faster time.";

		title[5] = "Level up!";
		text[5] = "If you reach the target in time, you will be moved to next level which has more ingredient, more "
				+ "menu and more challenge. Let's see how far you can go. Good luck!";
	}
}
