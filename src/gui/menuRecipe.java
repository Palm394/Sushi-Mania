package gui;

public class menuRecipe {
	private int hcode;
	private int price;
	private String name;
	private String url;
	
	menuRecipe(int hcode){
		switch(hcode) {
			case 3: name="Cucumber Salad"; price=30; break;
			default: name="unknown"; price=-10; break;
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
