package InventorySystem;

public class Item {
	public int Id;
    public String Name;
    public double Price;
    public int Quantity;
    public Item(int Id, String Name, double Price, int Quantity)
    {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
    }
    
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [Id=" + Id + ", Name=" + Name + ", Price=" + Price + ", Quantity=" + Quantity + "]";
	}
   
}
