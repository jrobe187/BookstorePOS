package RobersonJosephProject3;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;


public class BookstoreTestHarness{

	public static void main(String[] args) {
		
	//Declaring product object to initialize later, and declaring ArrayLists for members, products, and carts
		
		
		
		ArrayList<Member> members = new ArrayList<Member>();
		ArrayList<Product> Cart = new ArrayList<Product>();
		Inventory inv = new Inventory();
		
		Scanner sc = new Scanner(System.in);

	//while loop to loop menu
		while(true) {
			
	//Initializing File input reader
			
		
			try {
				BufferedReader br = new BufferedReader(new FileReader("C:/Users/jrobe/Downloads/ProductInventory.csv"));
				File file = new File("ProductInventory.csv");
				String line = "";
				
			
	//Adding input file to array list	
				while((line = br.readLine()) != null) {
					String[] words = line.split(",");
					if(words[1].equals("book")) {
						inv.inventory.add(new Book(Integer.valueOf(words[0]), Integer.valueOf(words[4]), Double.valueOf(words[5]), 
								words[2], words[3]));
					}
					if(words[1].equals("cd")) {
						inv.inventory.add(new CD(Integer.valueOf(words[0]), Integer.valueOf(words[4]), Double.valueOf(words[5]), 
								words[2], words[3]));
					}
					if(words[1].equals("dvd")) {
						inv.inventory.add(new DVD(Integer.valueOf(words[0]), Integer.valueOf(words[4]), Double.valueOf(words[5]),
								words[2], words[3]));
					}
					
					
				}
		} catch (FileNotFoundException e) {
			System.out.println("Error! File not found");
			}
			catch(IOException e) {
				System.out.println("Error! Try again.");
			}	
			
	//main menu
		System.out.println("Welcome to Project 3 Bookstore");
		System.out.println("Select from the following menu options by choosing a number.");
		System.out.println("\t 1. Restock, Add, or Remove an item from inventory");
		System.out.println("\t 2. Register a new Member");
		System.out.println("\t 3. Make a Purchase");
		System.out.println("\t 4. Check Inventory");
		System.out.println("\t 5. Exit");
		int num = sc.nextInt();
		
		switch(num){
		
	//adding or removing item from inventory
			case 1:{
				try {
				System.out.println("Are you: ");
				System.out.println("\t 1. Adding an item to inventory");
				System.out.println("\t 2. Removing an item from inventory");
				System.out.println("\t 3. Restocking an existing item");
				int num1 = sc.nextInt();
				if(num1 == 1){
					
	//Using scanner input to create a new Product Object
					System.out.println("What is the name of the item?");
					String itemName = sc.next();
					System.out.println("Assign a product ID to the item.");
					int productID = sc.nextInt();
					
		//For loop searches inventory for matching product ID
					for(int i = 0; i < inv.inventory.size(); i++){
						while(productID == inv.inventory.get(i).getProductID()) {
								System.out.println("That product ID is taken, please input another one");
								productID = sc.nextInt();
							}
					}
					
	//Initializing book, dvd, or cd object
					System.out.println("What is the quantity of the item");
					int quantity = sc.nextInt();
					System.out.println("What is the price of the item");
					double price = sc.nextDouble();
					System.out.println("What is the product type of this item?");
					System.out.println("1 for Book, 2 for DVD, and 3 for CD");
					int type = sc.nextInt();
	
						if(type == 1) {
							System.out.println("Who is the author?");
							String author = sc.next();
							Book b = new Book(productID, quantity, price, itemName, author);
							inv.inventory.add(b);
							
						}
						if(type == 2) {
							System.out.println("Who is the director?");
							String director = sc.next();
							DVD d = new DVD(productID, quantity, price, itemName, director);
							inv.inventory.add(d);
						}
						if(type == 3) {
							System.out.println("What is the name of the artist");
							String artist = sc.next();
							CD c = new CD(productID, quantity, price, itemName, artist);
							inv.inventory.add(c);
							
						}
						
					System.out.println("The item has been added to the inventory!");
					break;		
			}
					
	
										
			
			if(num1 == 2) {
					
					System.out.println("Enter the product ID of the item you wish to remove");
					int removeID = sc.nextInt();
				
	//Using a for loop to iterate through the ArrayList and removes the item with the matching parameter
					for(int i = 0; i < inv.inventory.size(); i++) {
						int count = 1;
						if(inv.inventory.get(i).getProductID() == removeID) {
							inv.inventory.remove(i);
						}
						else {
							count++;
						}
						if(count == inv.inventory.size() && count != 1) {
							System.out.println("The item could not be located in the inventory.");							
						}
						else {
							System.out.println("The item has been removed from inventory");
						}
					}
					break;
				}
			
				if(num1 == 3) {
	//Restock
					System.out.println("Enter the product ID of the item you wish to restock: ");
					int rID = sc.nextInt();
					System.out.println("Enter the amount you would like to add: ");
					int restockQuantity = sc.nextInt();
					inv.restockProduct(rID, restockQuantity);
					System.out.println("The Amount has been Added");
					for(int i = 0; i < inv.inventory.size(); i++) {
						if(rID == inv.inventory.get(i).getProductID()) {
							System.out.println("There are now " + inv.inventory.get(i).getQuantity() + " units of " + 
						inv.inventory.get(i).getName());
						}
					}
				
					break;
				}
			}
				catch(InputMismatchException e) {
					System.out.println("Error! Wrong data type!");
				}
				catch(Exception e) {
					System.out.println("Input Exception");
				}
				
			}
		
		
			
	//making a purchase
			case 3:{
				try {
				boolean value1 = true;
				double Total = 0;
				double total2 = 0;
				while(value1) {
				System.out.println("What is the product ID of the item being purchased");
				int ID = sc.nextInt();
							
	//For loop that fills customer's cart
				System.out.println("How many would you like to buy?");
				int quantity = sc.nextInt();
					for(int i = 0; i < inv.inventory.size(); i++) {
						if(ID == inv.inventory.get(i).getProductID()) {
							Cart.add(inv.inventory.get(i));
							
							
	//Ensures that the customer doesn't buy more than what is in stock
							while(quantity > inv.inventory.get(i).getQuantity()) {
								System.out.println("We do not have enough in stock, please choose a quantity less than or equal to "
							+ inv.inventory.get(i).getQuantity());
								quantity = sc.nextInt();							
								}
									
							Total = (inv.inventory.get(i).getPrice() * quantity);
							 total2 = (total2 + Total);
							inv.inventory.get(i).setQuantity(inv.inventory.get(i).getQuantity() - quantity);
						}
					}
				
						
							System.out.println("Enter 0 to add another item or 1 to go to checkout");
							int 
							value2 = sc.nextInt();
							if(value2 != 0) {
								break;
							}
								
					}
				
	//Searches members arraylist for matching customer ID and asks for re-input if not found
				System.out.println("What is the ID of the customer?");
				int searchID = sc.nextInt();
				int customerIndex = 0;
				int count = 0;
				for(int j = 0; j < members.size(); j++) {
					if(members.get(j).getCustomerNum() == searchID) {
						customerIndex = j;
					}
					else {
						count++;
					}
					while(count == members.size() && count != 1) {
						System.out.println("That customer ID could not be found, please enter another one.");
						searchID = sc.nextInt();
					}
				
				}
		
				
	//Prints the total and adds it to the moneySpent field of the member object
				System.out.println("The total is: "+ Total);
				double moneySpent = members.get(customerIndex).getMoneySpent();
				members.get(customerIndex).setMoneySpent(moneySpent =+ Total);
				break;
		}
				catch(InputMismatchException e) {
					System.out.println("Error! Wrong Data type");
				}
				catch(Exception e) {
					System.out.println("Input error");
				}
			}
		
	
	//registering a new member
			case 2:{
				try {
				System.out.println("Choose between the membership options: ");
				System.out.println("\t 1. Regular Membership");
				System.out.println("\t 2. Premium Membership");
				 int num2 = sc.nextInt();
				
	//Path for registering regular members
				if(num2 == 1) {
					Member member;
					System.out.println("Enter the name of the customer: ");
					String cName = sc.next();
					
					
	//for loop that checks if the ID assigned is equal to an ID of another member
					System.out.println("Assign a the customer an ID number");
					int cID = sc.nextInt();
					for(int i = 0; i < members.size(); i++) {
						if(cID == members.get(i).getCustomerNum()) {
							System.out.println("That ID number already exists, please choose a new one");
							cID = sc.nextInt();
						}
					}
					double money = 0;
					boolean pStatus = false;
					
	//Initializes member object
					member = new Member(cName, cID, money, pStatus);
					members.add(member);
					System.out.println("The member has been added to the system!");	
					break;
				}
			
	//Path for premium members		
				if(num2 == 2) {
					PremiumMembers pMember;
					System.out.println("Enter the name of the customer: ");
					String cName = sc.next();
					
					
	//for loop that checks if the ID assigned is equal to an ID of another member
					System.out.println("Assign a the customer an ID number");
					int cID = sc.nextInt();
					for(int i = 0; i < members.size(); i++) {
						if(cID == members.get(i).getCustomerNum()) {
							System.out.println("That ID number already exists, please choose a new one");
							cID = sc.nextInt();
						}
					}			
					
					double money = 0;
					boolean pStatus = true;
					
					System.out.println("What is the method of payment?");
					String payMethod = sc.next();
					
					System.out.println("Has the customer paid their monthly fee?");
					System.out.println("Enter 0 for yes and 1 for no");
					boolean oweMoney;
					int value2 = sc.nextInt();
					if(value2 == 0) {
						oweMoney = true;
					}
					else {
						oweMoney = false;
					}
					
	//Initializes pMember object with fields declared above
					pMember = new PremiumMembers(cName, cID, money, pStatus, payMethod, oweMoney);
					members.add(pMember);
					System.out.println("The member has been added to the system!");
					break;
				
					}
				}
				catch(InputMismatchException e) {
					System.out.println("Error! Wrong Data Type");
				}
				catch(Exception e) {
					System.out.println("Input error.");
				}
			}
			
			case 4:{
				try {
				System.out.println("Would you like to: ");
				System.out.println("\t 1. Check Inventory");
				System.out.println("\t 2. See Total Inventory Value");
				System.out.println("\t 3. Compare Prices");
				System.out.println("\t 4. Change Price");
				int num3 = sc.nextInt();
				
				if(num3 == 1) {
					for(int i = 0; i < inv.inventory.size(); i++) {
						inv.inventory.get(i).display();
					}	
					break;
				}
				
				if(num3 == 2) {
					double totalVal = 0;
					for(int i = 0; i < inv.inventory.size(); i++) {
						totalVal = inv.inventoryValue();
				}
					System.out.println("The Total Value of the Inventory is: " + totalVal);
					break;
				}
				
				if(num3 == 3) {
					System.out.print("Input the Product ID of the first item you would like to Compare");
					int compare1 = sc.nextInt();
					System.out.println("Input the Product ID of the second item you would like to Compare");
					int compare2 = sc.nextInt();
					
		//compareTo method 
					for(int i = 0; i < inv.inventory.size(); i++) { 
						
						
					if(inv.inventory.get(i).getProductID() == compare1) {
							int pos1 = i;
							
							for(int j = 0; j < inv.inventory.size(); j++) {
								
								if(inv.inventory.get(j).getProductID() == compare2) {
									int pos2 = j;
							
									if(inv.inventory.get(pos1).compareTo(inv.inventory.get(pos2)) == -1) {
										System.out.println(inv.inventory.get(pos1).getName() + " is less expensive than " + 
												inv.inventory.get(pos2).getName());
										
								}
									if(inv.inventory.get(pos1).compareTo(inv.inventory.get(pos2)) == 0) {
										System.out.println(inv.inventory.get(pos1).getName() + " is equal to " + 
												inv.inventory.get(pos2).getName());
										
									}
									if(inv.inventory.get(pos1).compareTo(inv.inventory.get(pos2)) == 1) {
									System.out.println(inv.inventory.get(pos1).getName() + " is more expensive than" + 
											inv.inventory.get(pos2).getName());
									
								}
							}
							
							}
						}
					}
					
//Changing Prices Function
				if(num3 == 4) {
					System.out.println("Enter the product ID of the item you would like to change the price of");
					int change = sc.nextInt();
					System.out.println("What would you like to change the price to?");
					double newPrice = sc.nextDouble();
					for(int i = 0; i < inv.inventory.size(); i++) {
						if(change == inv.inventory.get(i).getProductID()) {
							inv.inventory.get(i).setPrice(newPrice);
						}
					}
					System.out.println("The price of this item has been changed!");
					}
				
					
				}
				}
					catch(InputMismatchException e) {
						System.out.println("Error! Wrong Data type");
					}
				catch(Exception e) {
					System.out.println("Input Error");
				}
			}
				

			
	//Exits 
			case 5:{
				System.out.println("a");
							double sales = 0;
				for(int i = 0; i < Cart.size(); i++) {
					sales =+ (Cart.get(i).getPrice() * Cart.get(i).getQuantity());
				}
			
				try {
					System.out.println("b");
						File fs = new File("EndOfDay.txt");
						if(!fs.exists()) {
							fs.createNewFile();
						}
	//Writing the End Of Day Report
						PrintWriter outFS = new PrintWriter(fs);
						outFS.println("********************");
						outFS.println("Items Purchased");
						outFS.println("********************");
						outFS.println(" ");
					
						for(int i = 0; i < Cart.size(); i++) {
							outFS.println("NAME: " + Cart.get(i).getName());
							outFS.println("PRODUCT ID: " + Cart.get(i).getProductID());
							outFS.println("PRICE: " + Cart.get(i).getPrice());
							outFS.println(" ");
						}	
					
						outFS.println(" ");
						outFS.println("********************");
						outFS.println("New Members");
						outFS.println("********************");
					
					
						for(int i = 0; i < members.size(); i++) {
							outFS.println("********************");
							outFS.println("NAME: " + members.get(i).getName());
							outFS.println("CUSTOMER ID: " + members.get(i).getCustomerNum());
							outFS.println("TOTAL SPENT: " + members.get(i).getMoneySpent());
							if(members.get(i).getPremium() == true) {
								outFS.println("PREMIUM: Yes");
							}
							else {
								outFS.println("PREMIUM: No");
							}
							outFS.println(" ");
						}
						outFS.println(" ");
						outFS.println("********************");
						outFS.println("TOTAL SALES: " + sales);
						outFS.println("********************");
						outFS.println(" ");
					
					
					
					outFS.close();
					}
					 catch (FileNotFoundException e) {
						 System.out.println("Error! File not found");
					}
					  catch(IOException e) {
						  System.out.println("Error! Try again.");
					  }
				
	//End of Day Inventory

				try {
					String filePath = "C:/Users/jrobe/Downloads/ProductInventory.csv";
					String temp = "temp.csv";
					
					File newFile = new File("C:/Users/jrobe/eclipse-workspace/RobersonJosephProject3/ProductInventory3.csv");

						FileWriter fw = new FileWriter(newFile, true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						
						for(int i = 0; i < inv.inventory.size(); i++) {
							pw.println(" ");
							pw.println("productID"+","+"type"+","+"title"+","+"author/artist"+","+"numInStock"+","+"price");
								pw.println(inv.inventory.get(i).getProductID()+","+inv.inventory.get(i).getType()+","+
							inv.inventory.get(i).getName() +","+ inv.inventory.get(i).getCreator() + ","+inv.inventory.get(i).getQuantity()+","+inv.inventory.get(i).getPrice());
						}
						pw.flush();
						pw.close();
						
			
						
						
					}
				
				catch (FileNotFoundException e) {
					System.out.println("Error! File not found");
				}
					catch (IOException e) {
						System.out.println("Error! Try again.");
					}
				System.exit(0);
			
					
				

				}
		}
		}
	}
}
			 
			
		  


	



	
	

			
		
	
			

 
	




					
					
					
				
		
		
	


