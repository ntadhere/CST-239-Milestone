// Truong Anh Dao Nguyen
// CST-239
// 9/17/2023
// This is Front Store class for Milestone 1
// This is my own work

package game;


import java.util.Scanner;


public class StoreFront {
	String choice;
	static Scanner scanner = new Scanner(System.in);

	
	/**
     * This is the non default constructor that takes all parameters
     */
	// Will use to build relationship with salable product, inventory and shopping cart in future
	public StoreFront() {

	}

	/**
	 * able to purchase item from shopping cart. WILL UPDATE...
	 */
	public static void purchase() {
//		System.out.println("Which item do you want to purchase and how many of it?");
//		String name = scanner.nextLine();
//		String quantity = scanner.nextLine();
//		System.out.println("You successfully purchase " + quantity + " item #" + name +
//				" from your Shopping Cart");
		System.out.println("You successfully purchase the item  from your Shopping Cart");
		
	}
	
	/**
	 *  able to cancel item from shopping cart, return item back to inventory store. WILL UPDATE..
	 */
	public static void cancel() {
		System.out.println("You successfully cancel the item from your Shopping Cart");
	}
	
	/**
	 * This is determines user's interact with frontStore
	 */
	public void showMenu() {
		Inventory list = new Inventory();
		boolean exit = false;
		while (exit != true) {
			list.show();
			System.out.println("---- MAIN MENU -----");
			System.out.println("Make a selection: ");
			System.out.println("1. Purchase ");
			System.out.println("2. Cancel ");
			System.out.println("3. Exit ");
			System.out.println("---------");
//			Scanner scanner = new Scanner(System.in);
			choice = scanner.nextLine();
			
			  switch (choice) {
		      case "1":
		    	purchase();
		    	exit = false;
		        break;
		      case "2":
		    	cancel();
		        exit = false;
		        break;
		      case "3":
		        System.out.println("You have exited the Arena. Goodbye and See you later!!");
		        exit = true;
		        break;
			  }	
		}
	}
	
	public static void main(String[] args) {	
		System.out.println("--------------------------------------------");
		System.out.println("----------- WELCOME TO UWU STORE -----------");
		System.out.println("---In here you can find all what you need---");
		System.out.println("--------------------------------------------");
		StoreFront store = new StoreFront();	
		store.showMenu();
	}

}

    
    