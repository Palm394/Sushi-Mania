package gui;

import java.util.ArrayList;

import application.Utility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
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
		
		for(int i=0;i<7;i++) {
			Customer customer = new Customer(i);
			CustomerList.add(customer);
			drawCustomer(gc,customer);
		}
		this.getChildren().add(canvas);
	}
	
	private static void drawCustomer(GraphicsContext gc,Customer customer) {
		gc.drawImage(Utility.CustomerImage, customer.getPosX(), HEIGHT / 2);
	}

	private static void drawBG(GraphicsContext gc) {
		gc.drawImage(Utility.BackgroundImage, 0, 0);
	}
	
	public static void drawWant(int number,String want,double PosX) {
		gc.clearRect(0, 0, gamePane.WIDTH_SCREEN, HEIGHT / 2);
		drawBG(gc);
		
		for(Customer i : CustomerList) {
			drawCustomer(gc,i);
			if(i.getWant() != null) {
				gc.drawImage(Utility.DishImage, i.getPosX() - 25, -10);
			}
		}
	}

	public static ArrayList<Customer> getCustomerList() {
		return CustomerList;
	}
}
