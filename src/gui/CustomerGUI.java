package gui;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.Customer;
import model.Food;

public class CustomerGUI extends HBox {
	private static GraphicsContext gc;
	private static ArrayList<Customer> CustomerList;
	
	private final double HEIGHT = 150;
	
	public CustomerGUI() {
		Canvas canvas = new Canvas(gamePane.WIDTH_SCREEN,HEIGHT);
		gc = canvas.getGraphicsContext2D();
		CustomerList = new ArrayList<Customer>();
		
		drawBG(gc);
		
		for(int i=0;i<7;i++) {
			Customer a = new Customer(i);
			CustomerList.add(a);
			drawCustomer(gc,a);
		}
		this.getChildren().add(canvas);
	}
	
	private void drawCustomer(GraphicsContext gc,Customer a) {
		String image_path = "file:res/customer.png";
		Image image = new Image(image_path);

		gc.drawImage( image, a.getPosX(), HEIGHT / 2);
	}

	private void drawBG(GraphicsContext gc) {
		gc.setFill(Color.WHITE.darker());
		gc.fillRect(0, 0, gamePane.WIDTH_SCREEN, HEIGHT);
	}

	public static ArrayList<Customer> getCustomerList() {
		return CustomerList;
	}
}
