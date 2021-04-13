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
			case 0:  name="Cucumber";	url="Blueberry.png";	price=0; remain=10; break;
			case 1:  name="Seaweed";	url="Blueberry.png";	price=0; remain=10;	break;
			case 2:  name="Shrimp";		url="Blueberry.png";	price=0; remain=10; break;
			case 3:  name="SweetEgg";	url="Blueberry.png";	price=0; remain=10; break;
			case 4:  name="CrabStick";	url="Blueberry.png";	price=0; remain=10; break;
			case 5:  name="Ikura";		url="Blueberry.png";	price=0; remain=10; break;
			case 6:  name="Avocado";	url="Blueberry.png";	price=0; remain=10; break;
			case 7:  name="Tuna";		url="Blueberry.png";	price=0; remain=10; break;
			case 8:  name="Saba";		url="Blueberry.png";	price=0; remain=10; break;
			case 9:  name="Salmon";		url="Blueberry.png";	price=0; remain=10; break;
			case 10: name="Squid";		url="Blueberry.png";	price=0; remain=10; break;
			case 11: name="Scallop";	url="Blueberry.png";	price=0; remain=10; break;
			case 12: name="Hamachi";	url="Blueberry.png";	price=0; remain=10; break;
			case 13: name="Fuaga";		url="Blueberry.png";	price=0; remain=10; break;
			case 14: name="ShrimpEgg";	url="Blueberry.png";	price=0; remain=10; break;
			case 15: name="Unangi";		url="Blueberry.png";	price=0; remain=10; break;
			case 16: name="Uni";		url="Blueberry.png";	price=0; remain=10; break;
			case 17: name="Rice";		url="Blueberry.png"; 	price=0; remain=10; break;
			default: name="wut"; url="coffee.png"; price=0; remain=0;
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
