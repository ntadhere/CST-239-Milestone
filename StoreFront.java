/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 10/01/2023
 * This is my StoreFront for Milestone2
 * This is my own work
 */
package game;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Create an constant variable for number of kind item in inventory
 * Using scanner and ArrayList to read user input and store data of each item respectively
 */
public class StoreFront
{
	static int ITEM_INVENTORY = 6; //constant variable
	static Scanner scan = new Scanner(System.in);
	static Inventory inventory = new Inventory();
	static ArrayList<Product> list = inventory.getList();


	/**
	 * This is the non default constructor that takes all parameters
	 */
	// Will use to build relationship with salable product, inventory and shopping
	// cart in future
	public StoreFront()
	{
		

	}

	/**
	 * able to purchase item from shopping cart. WILL UPDATE...
	 * @throws CloneNotSupportedException 
	 */
	public static void purchase() throws CloneNotSupportedException
	{
		/*
		 * take user input
		 * sort the product in inventory
		 * take a clone product from inventory
		 * add a clone product to shopping cart
		 * exit
		 */
		// take user input
		int num = scan.nextInt();
		int qty = scan.nextInt();
		// sort the product in the inventory
		System.out.println(inventory.remove(num,qty));
		System.out.println("You successfully purchase the item from your Shopping Cart");
		System.out.println("------------------------------------------------------------");
		System.out.println("--------------RETURN BACK TO THE INVENTORY------------------");
		System.out.println("------------------------------------------------------------");

	}

	/**
	 * able to cancel item from shopping cart, return item back to inventory store.
	 * WILL UPDATE..
	 * @throws CloneNotSupportedException 
	 */
	public static void cancel() throws CloneNotSupportedException
	{
		/*
		 * take user input
		 * open shopping cart
		 * sort the product
		 * take a clone product from shopping cart
		 * add a clone product to inventory
		 * exit
		 */
		
		// take user input
		int num = scan.nextInt();
		int qty = scan.nextInt();
		// sort the product in the inventory
		System.out.println(inventory.add(num,qty));
		System.out.println("You successfully cancel the item from your Shopping Cart");
		System.out.println("------------------------------------------------------------");
		System.out.println("--------------RETURN BACK TO THE INVENTORY------------------");
		System.out.println("------------------------------------------------------------");
	}

	/**
	 * This is determines user's interact with frontStore
	 * @throws CloneNotSupportedException 
	 */
	private void showMenu() throws CloneNotSupportedException
	{
		inventory.initialize();
		boolean exit = false;
		while (exit != true)
		{	
			for (int i = 1; i < list.size() + 1; i++)	// read an inventory list
			{
				System.out.println("---- item #" + i + " ----");
				System.out.println(list.get(i - 1));
			}
			System.out.println("---- MAIN MENU -----");
			System.out.println("Make a selection: ");
			System.out.println("1. Purchase ");
			System.out.println("2. Cancel ");
			System.out.println("3. Exit ");
			System.out.println("---------");
			
			while (!scan.hasNextInt()) //check if input is a number
			{
				System.out.println("Input is not a number.");
			     scan.nextLine();
			}
			    int choice = scan.nextInt();
				switch (choice)
				{
				case 1:
					purchase();
					exit = false;
					break;
				case 2:
					cancel();
					exit = false;
					break;
				case 3:
					System.out.println("You have exited the Arena. Goodbye and See you later!!");
					exit = true;
					break;
				default:
					System.out.println("There is no method exist for this option. Please choose a desire number");
					exit = false;
				}
		}
	}

	/**
	 * Main method to display welcome message and get all the code load
	 * @param args this is automatic JAVA generation
	 */
	public static void main(String[] args) throws CloneNotSupportedException
	{
		StoreFront store = new StoreFront();
		System.out.println("--------------------------------------------");
		System.out.println("----------- WELCOME TO UWU STORE -----------");
		System.out.println("---In here you can find all what you need---");
		System.out.println("--------------------------------------------");
		System.out.println("------------------------------");
		System.out.println("There are " + ITEM_INVENTORY + " items in the Inventory");
		System.out.println("------------------------------");
		store.showMenu();
	}

}
