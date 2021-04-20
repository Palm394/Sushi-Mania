package logic;

import java.util.ArrayList;
import java.util.Random;

import application.Database;
import gui.CustomerGUI;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import model.Customer;
import model.FoodList;
import model.SetTime;

public class OrderController extends SetTime {
		private final int waitTime = 3;
		
		private Random rand = new Random();

		public OrderController() {
			timeline = new Timeline(
				    new KeyFrame(
				        Duration.millis( rand.nextInt(3000) + 3000 ),
				        event -> {
				        	ArrayList<Customer> CustomerBlankList = new ArrayList<Customer>();
				        	Random rand = new Random();
				        	
				        	for(Customer customer : CustomerGUI.getCustomerList()) {
				        		if(customer.getWant() == null) {
				        			customer.setWaitTime(waitTime);
				        			CustomerBlankList.add(customer);
				        		}else {
				        			customer.setWaitTime(customer.getWaitTime() - 1);
				        			if(customer.getWaitTime() == 0) {
				        				customer.setWant(null);
				        			}
				        		}
				        	}
				        	Customer isSelected = CustomerBlankList.get(rand.nextInt(CustomerBlankList.size()));
				            FoodList isWant = Database.getHasMenu().get(rand.nextInt(Database.getHasMenu().size()));
				        	isSelected.setWantURL(isWant.getUrl());
				        	isSelected.setWant(isWant.getName());
				        	
				        	CustomerGUI.drawWant();
				        }
				    )
			);
			
			timeline.setCycleCount( 12 );
			timeline.play();
		}
}
