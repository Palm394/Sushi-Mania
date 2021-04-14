package gui;

public class Ingredient {
	String name;
	String url;
	int id;
	int price;
	int remain;
	
	Ingredient(int id){
		this.id=id;
		switch(id){
			case 0:  name="Cucumber";	url="Ingredient/cucumber.png";	price=0; remain=10; break;
			case 1:  name="Seaweed";	url="Ingredient/seaweed.png";	price=0; remain=10;	break;
			case 2:  name="SweetEgg";	url="Ingredient/sweetegg.png";	price=0; remain=10; break;
			case 3:  name="CrabStick";	url="Ingredient/crabstick.png";	price=0; remain=10; break;
			case 4:  name="ShrimpEgg";	url="Ingredient/shrimpegg.png";	price=0; remain=10; break;
			case 5:  name="Shrimp";		url="Ingredient/shrimp.png";	price=0; remain=10; break;
			case 6:  name="Saba";		url="Ingredient/saba.png";	price=0; remain=10; break;
			case 7:  name="Tuna";		url="Ingredient/tuna.png";	price=0; remain=10; break;
			case 8:  name="Squid";		url="Ingredient/squid.png";	price=0; remain=10; break;
			case 9:  name="Salmon";		url="Ingredient/salmon.png";	price=0; remain=10; break;
			case 10: name="Ikura";		url="Ingredient/ikura.png";	price=0; remain=10; break;
			case 11: name="Avocado";	url="Ingredient/avocado.png";	price=0; remain=10; break;
			case 12: name="Scallop";	url="Ingredient/scallop.png";	price=0; remain=10; break;
			case 13: name="Unangi";		url="Ingredient/unangi.png";	price=0; remain=10; break;
			case 14: name="Fuaga";		url="Ingredient/Fuaga.png";	price=0; remain=10; break;
			case 15: name="Uni";		url="Ingredient/uni.png";	price=0; remain=10; break;
			case 17: name="Rice";		url="Ingredient/rice.png"; 	price=0; remain=10; break;
			default: name="WTF"; 	url="coffee.png"; price=0; remain=0;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}
	
}
