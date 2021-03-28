package gui;

import javafx.stage.Stage;

public class GUIController {

	private static Stage stage;
	
	public GUIController() {
        menuPane menu = new menuPane();
        stage = menu.getMenuStage();
    }
	
	public Stage getMenuStage() {
		return stage;
	}
}
