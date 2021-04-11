package logic;

import java.util.ArrayList;
import java.util.Random;

import gui.CustomerGUI;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import model.Customer;

public class OrderController extends SetTime {
	
		public OrderController() {
			timeline = new Timeline(
				    new KeyFrame(
				        Duration.millis( 5000 ),
				        event -> {
				        	ArrayList<Customer> CustomerBlankList = new ArrayList<Customer>();
				        	Random rand = new Random();
				        	for(Customer i : CustomerGUI.getCustomerList()) {
				        		if(i.getWant() == null) {
				        			//15 second to serve
				        			i.setWaitTime(3);
				        			CustomerBlankList.add(i);
				        		}else {
				        			i.setWaitTime(i.getWaitTime() - 1);
				        			if(i.getWaitTime() == 0) {
				        				i.setWant(null);
				        			}
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
}
