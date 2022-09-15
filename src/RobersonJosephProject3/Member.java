package RobersonJosephProject3;

public class Member {
	
//Fields for Member class
	private int customerID;
	private double moneySpent;
	private String name;
	private boolean isPremium;
	private int totalPurchases;
	
	
//Constructor to initialize
	public Member(String name, int num, double money, boolean isPremium) {
		this.customerID = num;
		this.name = name;
		this.moneySpent = money;
		this.isPremium = isPremium;
	}
	
//setter for customer number
	public void setCustomerNum(int num) {
		this.customerID = num;
	}
	
	public int getCustomerNum() {
		return customerID;
	}
	
	//setter and getter for moneySpent
	public void setMoneySpent(double money) {
		this.moneySpent = money;
	}
	
	public double getMoneySpent() {
		return moneySpent;
	}
	
	//setter and getter for name
	public void setName(String cName) {
		this.name = cName;
	}
	
	public String getName() {
		return name;
	}
	
	//setter and getter for premium status
	public void setPremium(boolean value) {
		this.isPremium = value;
	}
	
	public boolean getPremium() {
		return isPremium;
	}
	
	//setter and getter for total purchases
	public void setPurchases(int purchase) {
		totalPurchases = purchase;
	}
	
	public int getPurchases() {
		return totalPurchases
				;
	}
	
}
