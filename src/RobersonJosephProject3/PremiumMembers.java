package RobersonJosephProject3;
public class PremiumMembers extends Member{
	
//Fields for PremiumMembers
	private String payMethod;
	private boolean oweMoney;
	

//Constructor to initialize PremiumMembers objects
	public PremiumMembers(String name, int num, double money, boolean isPremium, String payMethod, boolean oweMoney){
		super(name, num, money, isPremium);
		this.payMethod = payMethod;
		this.oweMoney = oweMoney;
	}
	
//setter and getter for pay method
	public void setPayMethod(String method) {
		this.payMethod = method;
	}
	
	public String getPayMethod() {
		return payMethod;
	}
	
//setter and getter for oweMoney
	public void setOweMoney(boolean owe) {
		this.oweMoney = owe;
	}
	
	public boolean getOweMoney() {
		return oweMoney;
	}
	


	
	
}
