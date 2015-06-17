package cs320.midterm;

public class InventoryItem {
	private static int count = 0;
	
	int Id;
	String Name;
	String Description;
	double Price;
	int Quantity;
	
	public InventoryItem(String name, String description, double price, int quantity ) {
		this.Id = count++;
		this.Name = name;
		this.Description = description;
		this.Price = price;
		this.Quantity = quantity;
		
	}
	public String getName() {
		return Name;
	}
	
	public String getDescription() {
		return Description;
	}
	public double getPrice() {
		return Price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public int getId() {
		return Id;
	}
	

}
