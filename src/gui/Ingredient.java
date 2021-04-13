package gui;

public class Ingredient {
	String name;
	String url;
	int price;
	int remain;
	
	Ingredient(String name){
		this.name = name;
		switch(name){
			case "Cucumber":	url="Blueberry.png";	price=0; remain=10; break;
			case "Seaweed":		url="Blueberry.png";	price=0; remain=10;	break;
			case "Shrimp":		url="Blueberry.png";	price=0; remain=10; break;
			case "SweetEgg":	url="Blueberry.png";	price=0; remain=10; break;
			case "CrabStick":	url="Blueberry.png";	price=0; remain=10; break;
			case "Ikura":		url="Blueberry.png";	price=0; remain=10; break;
			case "Avocado":		url="Blueberry.png";	price=0; remain=10; break;
			case "Tuna":		url="Blueberry.png";	price=0; remain=10; break;
			case "Saba":		url="Blueberry.png";	price=0; remain=10; break;
			case "Salmon":		url="Blueberry.png";	price=0; remain=10; break;
			case "Squid":		url="Blueberry.png";	price=0; remain=10; break;
			case "Scallop":		url="Blueberry.png";	price=0; remain=10; break;
			case "Hamachi":		url="Blueberry.png";	price=0; remain=10; break;
			case "Fuaga":		url="Blueberry.png";	price=0; remain=10; break;
			case "ShrimpEgg":	url="Blueberry.png";	price=0; remain=10; break;
			case "Unangi":		url="Blueberry.png";	price=0; remain=10; break;
			case "Uni":			url="Blueberry.png";	price=0; remain=10; break;
			case "Rice":		url="Blueberry.png"; price=0; remain=10; break;
			default: url="coffee.png"; price=0; remain=0;
		}
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
