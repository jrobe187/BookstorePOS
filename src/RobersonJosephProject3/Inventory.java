package RobersonJosephProject3;

import java.util.ArrayList;

public class Inventory implements BookstoreSpecification{
	
//ArrayList for inventory
	public ArrayList<Product> inventory = new ArrayList<Product>();
	
//Default Constructor for Inventory
	public Inventory() {
		
	}
	
//Parameter Constructor for Inventory
	public Inventory(ArrayList<Product> i) {
		inventory = i;
	}
	
//restockProduct Method
	@Override public int restockProduct(int id, int amount) {
		int index = -1; 
			for(int i = 0; i < inventory.size(); i++) {
				if(id == inventory.get(i).getProductID()) {
					inventory.get(i).setQuantity(inventory.get(i).getQuantity() + amount);
				}
			}
			return index;
		}

//inventoryValue method
	@Override public double inventoryValue() {
		double value = 0;
		for(int i = 0; i < inventory.size(); i++) {
			double price =+ (inventory.get(i).getPrice() * inventory.get(i).getQuantity());
			value = (value + price);
		}
		return value;
	}
	

}
