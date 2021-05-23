package model;

import javafx.scene.image.Image;

public class FoodList extends Food {

	private String hcode;
	private String url;
	private Image image;
	
	public FoodList(int id){
		switch(id) {
			case 1:  hcode="1010100100000002"; name="roll1"; 	  price=65; url="MenuImage/Sushi1.PNG";   break;  
			case 2:  hcode="0100000000100001"; name="Ikura"; 	  price=35; url="MenuImage/Sushi2.PNG";   break;  
			case 3:  hcode="0000000001000001"; name="Salmon"; 	  price=25; url="MenuImage/Sushi3.PNG";   break;
			case 4:  hcode="0100000001010001"; name="roll2"; 	  price=45; url="MenuImage/Sushi4.PNG";   break;
			case 5:  hcode="0000000100000001"; name="Tuna";	      price=25; url="MenuImage/Sushi5.PNG";   break;
			case 6:  hcode="1000000102000001"; name="roll3";	  price=55; url="MenuImage/Sushi6.PNG";   break;
			case 7:  hcode="0100100000000001"; name="ShrimpEgg";  price=35; url="MenuImage/Sushi7.PNG";   break;
			case 8:  hcode="1010100000000002"; name="roll4";	  price=55; url="MenuImage/Sushi8.PNG";   break;
			case 9:  hcode="1010100101000002"; name="roll5";	  price=75; url="MenuImage/Sushi9.PNG";   break;
			case 10: hcode="0110000000000001"; name="sweetEgg";	  price=35; url="MenuImage/Sushi10.PNG";  break;
			case 11: hcode="1000000201000001"; name="roll6";	  price=55; url="MenuImage/Sushi11.PNG";  break;
			case 12: hcode="0000010000000001"; name="shrimp";	  price=25; url="MenuImage/Sushi12.PNG";  break;
			case 13: hcode="0100000010000001"; name="squid";	  price=35; url="MenuImage/Sushi13.PNG";  break;
			case 14: hcode="0000001000000001"; name="saba";		  price=25; url="MenuImage/Sushi14.PNG";  break;
			case 15: hcode="0100000000000002"; name="Onigiri";	  price=35; url="MenuImage/Sushi15.PNG";  break;
			case 16: hcode="1100000001000001"; name="temaki1";	  price=45; url="MenuImage/Sushi16.PNG";  break;
			case 17: hcode="0101000000000001"; name="crab roll";  price=35; url="MenuImage/Sushi17.PNG";  break;
			case 18: hcode="1111100001000002"; name="roll7";	  price=85; url="MenuImage/Sushi18.PNG";  break;
			case 19: hcode="1111100000010001"; name="roll8";	  price=75; url="MenuImage/Sushi19.PNG";  break;
			case 20: hcode="0000000000001001"; name="scallop";	  price=25; url="MenuImage/Sushi20.PNG";  break;
			case 21: hcode="0211100001000003"; name="temaki2";	  price=95; url="MenuImage/Sushi21.PNG";  break;
			case 22: hcode="0100000000000011"; name="Uni roll";	  price=35; url="MenuImage/Sushi22.PNG";  break;
			case 23: hcode="0100000000000101"; name="unangi roll";price=35; url="MenuImage/Sushi23.PNG";  break;
			case 24: hcode="2210000100000002"; name="double set"; price=85; url="MenuImage/Sushi24.PNG";  break;
			case 25: hcode="1210000200000003"; name="triple set"; price=95; url="MenuImage/Sushi25.PNG";  break;
			case 26: hcode="0010000001000002"; name="roll9";	  price=45; url="MenuImage/Sushi26.PNG";  break;
			case 27: hcode="0011000001020002"; name="roll10";	  price=75; url="MenuImage/Sushi27.PNG";  break;
			case 28: hcode="0011000101010002"; name="roll11";	  price=75; url="MenuImage/Sushi28.PNG";  break;
			case 29: hcode="0110000001000001"; name="roll12";	  price=45; url="MenuImage/Sushi29.PNG";  break;
			case 30: hcode="0120000002000003"; name="temaki3";	  price=85; url="MenuImage/Sushi30.PNG";  break;
			case 31: hcode="0000000101001000"; name="Mix Sashimi";price=35; url="MenuImage/Sushi31.PNG";  break;
			case 32: hcode="0000000002000000"; name="Sal Sashimi";price=25; url="MenuImage/Sushi32.PNG";  break;  
			default: name="unknown"; price=-50; url="MenuImage/Unknown.PNG"; break;
		}
		url = ClassLoader.getSystemResource(url).toString();
		image = new Image(url,60,60, false, false);
	}

	public String getHcode() {
		return hcode;
	}
	
	public String getUrl() {
		return url;
	}

	public Image getImage() {
		return image;
	}
	
}

