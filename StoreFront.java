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
	static ShoppingCart cart = new ShoppingCart();



	/**
	 * This is the non default constructor that takes all parameters
	 */
	public StoreFront()
	{
		

	}

	/**
	 * 
	 * @throws CloneNotSupportedException 
	 */
	public static void purchase() throws CloneNotSupportedException
	{
		// take user input
		System.out.println("Which item do you want to purchase?");
		int num = scan.nextInt();
		System.out.println("How many item do you want to purchase?");
		int qty = scan.nextInt();
		// sort and take the clone product in the inventory
		Product temp = inventory.getProduct(num,qty);
		// add a clone product to shopping cart
		cart.addProduct(temp);
		System.out.println("You successfully purchase the item from your Shopping Cart");
		System.out.println("This is your shopping cart:");
		cart.returnList();
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
			inventory.returnList();
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
