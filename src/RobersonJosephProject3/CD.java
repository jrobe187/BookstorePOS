package RobersonJosephProject3;

public class CD extends Product{
	
	String creator = "";
	String type = "cd";
	int minuteLength = 0;
	CD() {
		super();
	}
	
	
	
	CD(int ID, int quantity, double cost, String itemName, String artist){
		super(ID, quantity, cost, itemName);
		creator = artist;
	}
	
	public void display() {
		System.out.println("---------------------------------");
		System.out.println("NAME: " + getName());
		System.out.println("PRICE: " + getPrice());
		 System.out.println("ARTIST : " + creator);
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
