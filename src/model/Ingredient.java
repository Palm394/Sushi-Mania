package model;

public class Ingredient {
	private String name;
	private String url;
	private int id;
	private int price;
	private int remain;
	
	public Ingredient(int id){
		this.id=id;
		switch(id){
			case 0:  name="Cucumber";	url="Ingredient/cucumber.png";	price=10; remain=10; break;
			case 1:  name="Seaweed";	url="Ingredient/seaweed.png";	price=12; remain=10; break;
			case 2:  name="SweetEgg";	url="Ingredient/sweetegg.png";	price=15; remain=10; break;
			case 3:  name="CrabStick";	url="Ingredient/crabstick.png";	price=18; remain=10; break;
			case 4:  name="ShrimpEgg";	url="Ingredient/shrimpegg.png";	price=20; remain=10; break;
			case 5:  name="Shrimp";		url="Ingredient/shrimp.png";	price=25; remain=10; break;
			case 6:  name="Saba";		url="Ingredient/saba.png";		price=29; remain=10; break;
			case 7:  name="Tuna";		url="Ingredient/tuna.png";		price=35; remain=10; break;
			case 8:  name="Squid";		url="Ingredient/squid.png";		price=38; remain=10; break;
			case 9:  name="Salmon";		url="Ingredient/salmon.png";	price=42; remain=10; break;
			case 10: name="Ikura";		url="Ingredient/ikura.png";		price=45; remain=10; break;
			case 11: name="Avocado";	url="Ingredient/avocado.png";	price=48; remain=10; break;
			case 12: name="Scallop";	url="Ingredient/scallop.png";	price=50; remain=10; break;
			case 13: name="Unangi";		url="Ingredient/unangi.png";	price=60; remain=10; break;
			case 14: name="Uni";		url="Ingredient/uni.png";		price=90; remain=10; break;
			case 15: name="Rice";		url="Ingredient/rice.png"; 		price=25; remain=10; break;
			default: name="WTF"; 	url="coffee.png"; price=0; remain=0;
		}
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public int getPrice() {
		return price;
	}

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}
	
}
