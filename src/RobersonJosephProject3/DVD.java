package RobersonJosephProject3;

public class DVD extends Product{
	
	String creator = "";
	String type = "dvd";
	int minutesLength = 0;
	
	DVD(){
		super();
	}
	
	
	
	DVD(int ID, int quantity, double cost, String itemName, String dir){
		super(ID, quantity, cost, itemName);
		creator = dir;
	}
	
	public void display() {
		System.out.println("---------------------------------");
		System.out.println("NAME: " + getName());
		System.out.println("PRICE: " + getPrice());
		 System.out.println("CREATOR: " + creator);
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
