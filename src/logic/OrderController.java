package logic;

import java.util.ArrayList;
import java.util.Random;

import gui.CustomerGUI;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import model.Customer;

public class OrderController {

	private static Timeline timeline;
		
		public static void initialize() {
			timeline = new Timeline(
				    new KeyFrame(
				        Duration.millis( 5000 ),
				        event -> {
				        	ArrayList<Customer> CustomerBlankList = new ArrayList<Customer>();
				        	Random rand = new Random();
				        	for(Customer i : CustomerGUI.getCustomerList()) {
				        		if(i.getWant() == null) {
				        			CustomerBlankList.add(i);
				        		}
				        	}
				        	Customer isSelected = CustomerBlankList.get(rand.nextInt(CustomerBlankList.size()));
				            isSelected.drawWant();
				        }
				    )
			);
			
			timeline.setCycleCount( 12 );
			timeline.play();
		}
	
		public Timeline getTimeline() {
			return timeline;
		}
		
		public static void stop() {
			timeline.stop();
		}

}
