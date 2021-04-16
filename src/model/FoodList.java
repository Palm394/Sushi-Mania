package model;

public class FoodList {
	private int hcode;
	private int price;
	private String name;
	private String url;
	
	public FoodList(int hcode){
		switch(hcode) {
			case 28700092: name="roll1"; 	  price=300; url="MenuImage/Sushi1.png";  break;  
			case 14407959: name="Ikura"; 	  price=300; url="MenuImage/Sushi2.png";  break;  
			case 14368590: name="Salmon"; 	  price=300; url="MenuImage/Sushi3.png";  break;
			case 14545740: name="roll2"; 	  price=300; url="MenuImage/Sushi4.png";  break;
			case 14351094: name="Tuna";		  price=300; url="MenuImage/Sushi5.png";  break;
			case 14390461: name="roll3";	  price=300; url="MenuImage/Sushi6.png";  break;
			case 14348991: name="ShrimpEgg";  price=300; url="MenuImage/Sushi7.png";  break;
			case 28697905: name="roll4";	  price=300; url="MenuImage/Sushi8.png";  break;
			case 28719775: name="roll5";	  price=300; url="MenuImage/Sushi9.png";  break;
			case 14348919: name="sweetEgg";	  price=300; url="MenuImage/Sushi10.png";  break;
			case 14372965: name="roll6";	  price=300; url="MenuImage/Sushi11.png";  break;
			case 14349150: name="shrimp";	  price=300; url="MenuImage/Sushi12.png";  break;
			case 14355471: name="squid";	  price=300; url="MenuImage/Sushi13.png";  break;
			case 14349636: name="saba";		  price=300; url="MenuImage/Sushi14.png";  break;
			case 28697817: name="Onigiri";	  price=300; url="MenuImage/Sushi15.png";  break;
			case 14368594: name="temaki1";	  price=300; url="MenuImage/Sushi16.png";  break;
			case 14348937: name="crab roll";  price=300; url="MenuImage/Sushi17.png";  break;
			case 28719778: name="roll7";	  price=300; url="MenuImage/Sushi18.png";  break;
			case 14526175: name="roll8";	  price=300; url="MenuImage/Sushi19.png";  break;
			case 14880348: name="scallop";	  price=300; url="MenuImage/Sushi20.png";  break;
			case 43066527: name="temaki2";	  price=300; url="MenuImage/Sushi21.png";  break;
			case 19131879: name="Uni roll";	  price=300; url="MenuImage/Sushi22.png";  break;
			case 15943233: name="unngi roll"; price=300; url="MenuImage/Sushi23.png";  break;
			case 28700018: name="double set"; price=300; url="MenuImage/Sushi24.png";  break;
			case 43051111: name="triple set"; price=300; url="MenuImage/Sushi25.png";  break;
			case 28717506: name="Onigiri";	  price=300; url="MenuImage/Sushi26.png";  break;
			case 29071827: name="roll9";	  price=300; url="MenuImage/Sushi27.png";  break;
			case 28896867: name="Onigiri";	  price=300; url="MenuImage/Sushi28.png";  break;
			case 14368602: name="Onigiri";	  price=300; url="MenuImage/Sushi29.png";  break;
			case 43086108: name="temaki3";	  price=300; url="MenuImage/Sushi30.png";  break;
			case 553311: name="Mixed Sashimi";price=300; url="MenuImage/Sushi31.png";  break;
			case 39366: name="Salmon Sashimi";price=300; url="MenuImage/Sushi32.png"; break;  
			default: name="unknown"; price=-10; url="MenuImage/Unknown.png"; break;
		}
	}


	public int getHcode() {
		return hcode;
	}


	public void setHcode(int hcode) {
		this.hcode = hcode;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
		public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
}
