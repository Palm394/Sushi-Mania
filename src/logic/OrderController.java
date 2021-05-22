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
		private final int waitTime = 5;
		
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
				        			CustomerBlankList.add(customer);
				        		}else {
				        			customer.setWaitTime(customer.getWaitTime() - 1);
				        			if(customer.getWaitTime() == 0) {
				        				customer.setWant(null);
				        			}
				        		}
				        	}
				        	if(CustomerBlankList.size() > 0) {
					        	Customer isSelected = CustomerBlankList.get(rand.nextInt(CustomerBlankList.size()));
					        	isSelected.setWaitTime(waitTime);
					            FoodList isWant = Database.getHasMenu().get(rand.nextInt(Database.getHasMenu().size()));
					        	isSelected.setWantURL(isWant.getUrl());
					        	isSelected.setWant(isWant.getName());
					        	
					        	CustomerGUI.drawWant();
				        	}
				        }
				    )
			);
			
			timeline.setCycleCount( 40 );
			timeline.play();
		}
}
