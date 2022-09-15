package RobersonJosephProject3;

public class Book extends Product{
	
	String creator = "";
	String type = "book";
	int pages = 0;
	Book() {
		super();
	}
	

	 Book(int ID, int quantity, double cost, String itemName, String writer){
			super(ID, quantity, cost, itemName);
			creator = writer;
			
		}
	 
	
//Overriden Display method 
	 public void display() {
		 System.out.println("---------------------------------");
		System.out.println("NAME: " + getName());
		System.out.println("PRICE: " + getPrice());
		 System.out.println("AUTHOR: " + creator);
		 System.out.println("QUANTITY: " + getQuantity());
		 System.out.println(" ");
	 }
	 
//getter for type
		
		public String getType() {
			return type;
		}
		
//getter for Creator
		public String getCreator() {
			return creator;
		}
}
