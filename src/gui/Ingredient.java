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
			case 0:  name="Cucumber";	url="cucumber.png";	price=0; remain=10; break;
			case 1:  name="Seaweed";	url="seaweed.png";	price=0; remain=10;	break;
			case 2:  name="SweetEgg";	url="sweetegg.png";	price=0; remain=10; break;
			case 3:  name="CrabStick";	url="crabstick.png";	price=0; remain=10; break;
			case 4:  name="ShrimpEgg";	url="shrimpegg.png";	price=0; remain=10; break;
			case 5:  name="Shrimp";		url="shrimp.png";	price=0; remain=10; break;
			case 6:  name="Saba";		url="saba.png";	price=0; remain=10; break;
			case 7:  name="Tuna";		url="tuna.png";	price=0; remain=10; break;
			case 8:  name="Squid";		url="squid.png";	price=0; remain=10; break;
			case 9:  name="Salmon";		url="salmon.png";	price=0; remain=10; break;
			case 10: name="Ikura";		url="ikura.png";	price=0; remain=10; break;
			case 11: name="Avocado";	url="avocado.png";	price=0; remain=10; break;
			case 12: name="Scallop";	url="scallop.png";	price=0; remain=10; break;
			case 13: name="Unangi";		url="unangi.png";	price=0; remain=10; break;
			case 14: name="Fuaga";		url="Fuaga.png";	price=0; remain=10; break;
			case 15: name="Uni";		url="uni.png";	price=0; remain=10; break;
			case 17: name="Rice";		url="rice.png"; 	price=0; remain=10; break;
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
