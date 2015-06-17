package finalPractise;

public class ItemsBean {
	
	int id;
	String description;
	int quantity;
	double price;
	
	public ItemsBean(int id, String description, int quantity, double price) {
		this.id = id;
		this.description= description;
		this.quantity = quantity;
		this.price = price;
		
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}
	

}
