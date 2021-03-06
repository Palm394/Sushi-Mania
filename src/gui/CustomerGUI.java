package gui;

import java.util.ArrayList;

import application.Utility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import model.Customer;

public class CustomerGUI extends HBox {
	private static GraphicsContext gc;
	private static ArrayList<Customer> CustomerList;
	
	private final static double HEIGHT = 150;
	
	public CustomerGUI() {
		Canvas canvas = new Canvas(gamePane.WIDTH_SCREEN,HEIGHT);
		gc = canvas.getGraphicsContext2D();
		
		CustomerList = new ArrayList<Customer>();
		
		drawBG(gc);
		drawCustomer(gc);
		
		for(int i=0;i<7;i++) {
			Customer customer = new Customer(i);
			CustomerList.add(customer);
		}
		
		this.getChildren().add(canvas);
	}
	
	private static void drawCustomer(GraphicsContext gc) {
		gc.drawImage(Utility.CustomerImage,0, HEIGHT / 2);
	}

	private static void drawBG(GraphicsContext gc) {
		gc.drawImage(Utility.BackgroundImage, 0, 0);
	}
	
	public static void drawWant() {
		gc.clearRect(0, 0, gamePane.WIDTH_SCREEN, HEIGHT / 2);
		drawBG(gc);
		
		for(Customer i : CustomerList) {
			if(i.getWant() != null) {
				Image drawing = new Image(i.getWantURL(),60,60, false, false);
				gc.drawImage(drawing, i.getPosX(), 15);
			}
		}
	}

	public static ArrayList<Customer> getCustomerList() {
		return CustomerList;
	}
}
