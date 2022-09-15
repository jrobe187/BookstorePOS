package RobersonJosephProject3;

public abstract class Product implements Comparable<Product>{
	
// Default Constructor
	public Product(){
	}
//Fields for product
	private int productID;
	private int quantity;
	private double price;
	private String name;
	private int sold;
	private String type;
	private String creator;
	
	
	public Product(int ID, int quantity, double cost, String itemName) {
		this.productID = ID;
		this.quantity = quantity;
		this.price = cost;
		this.name = itemName;
		
	}

//setter and getter for product ID
	public void setProductID(int ID) {
		productID = ID;
	}
	
	public int getProductID() {
		return productID;
	}
	
//setter and getter for quantity
	public void setQuantity(int value) {
		quantity = value;
	}
	
	public int getQuantity() {
		return quantity;
		
	}
	
//setter and getter for price
	public void setPrice(double cost) {
		price = cost;
		
	}
	
	public double getPrice() {
		return price;
	}
	
//setter and getter for name
	public void setName(String bookName) {
		name = bookName;
	}

	public String getName() {
		return name;
	}
	
// Overriding compareTo method
	
	@Override public int compareTo(Product p) {
		
		if(this.getPrice() < p.getPrice()) {
			return -1;
		}
		
		
		else if(this.getPrice() == p.getPrice()) {
			return 0;
		}
		
		else {
			return 1;
		}
	}

//getter for type
	public String getType() {
		return type;
	}

	
//Display Method
	 abstract public void display();
	 
//getter for creator
	 public String getCreator() {
		 return creator;
	 }
	


	 
		

	
}
