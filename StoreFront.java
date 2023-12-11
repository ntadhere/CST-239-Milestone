/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 11/05/2023
 * This is Store Front
 * This is my own work
 */
package server;

import java.io.IOException;
import java.net.Socket;
import java.util.*;

import exception.CustomException;

/**
 * class with a main method containing an instance of Inventory class and
 * ShoppingCart class
 */
public class StoreFront
{
	static Scanner scan = new Scanner(System.in);
	static Scanner item = new Scanner(System.in);
	static Inventory inventory;
	static Server server = new Server();
	static ShoppingCart cart = new ShoppingCart();

	/**
	 * this is a non-default constructor support purchase action Method take user
	 * input name and quantity then remove Product from Inventory to add to
	 * ShoppingCart
	 * 
	 * @throws CloneNotSupportedException throw this exception to indicate that an
	 *                                    object could not or should not be cloned.
	 */
	public static void purchase() throws CloneNotSupportedException
	{
		// take user input
		Product temp = null;
		while (temp == null)
		{
			System.out.println("------------------------------------------------------------");
			System.out.println("Which item do you want to purchase?");
			String name = item.nextLine();
			System.out.println("How many item do you want to purchase?");
			int qty = scan.nextInt();

			// sort and take the product out of the inventory
			temp = inventory.getProduct(name, qty);
		}

		// add the product to shopping cart
		cart.addProduct(temp);
		System.out.println("You successfully purchase the item to your Shopping Cart");
		System.out.println("------------------------------------------------------------");
		System.out.println("--------------RETURN BACK TO THE STORE FRONT------------------");
		System.out.println("------------------------------------------------------------");

	}

	/**
	 * this is a non-default constructor support cancel action Method take user
	 * input name and quantity then remove Product from ShoppingCart to add back to
	 * Inventory
	 * 
	 * @throws CloneNotSupportedException throw this exception to indicate that an
	 *                                    object could not or should not be cloned.
	 */
	public static void cancel() throws CloneNotSupportedException
	{
		// take user input
		Product temp = null;
		while (temp == null)
		{
			System.out.println("Which item do you want to cancel?");
			String name = item.nextLine();
			System.out.println("How many item do you want to cancel?");
			int qty = scan.nextInt();
			// sort and take the product from the ShoppingCart
			temp = cart.getProduct(name, qty);
		}
		// add the product back to Inventory
		inventory.addProduct(temp);
		System.out.println("You successfully cancel the item from your Shopping Cart");
		System.out.println("------------------------------------------------------------");
		System.out.println("--------------RETURN BACK TO THE STORE FRONT------------------");
		System.out.println("------------------------------------------------------------");

	}

	/**
	 * This is a non-default constructor take user input from the keyboard and
	 * display appropriate feedback on the console
	 * 
	 * @throws CloneNotSupportedException throw this exception to indicate that an
	 *                                    object could not or should not be cloned.
	 */
	private void showMenu() throws CloneNotSupportedException
	{
		boolean exit = false;
		while (exit != true)
		{
			System.out.println("---- MAIN MENU -----");
			System.out.println("Make a selection: ");
			System.out.println("1. View Inventory ");
			System.out.println("2. View Shopping Cart ");
			System.out.println("3. Purchase Product ");
			System.out.println("4. Cancel Product ");
			System.out.println("5. Exit ");

			System.out.println("---------");

			while (!scan.hasNextInt()) // check if input is a number
			{
				System.out.println("Input is not a number.");
				scan.nextLine();
			}
			// when input is a number, the while loop return false and stop
			int choice = scan.nextInt();
			switch (choice)
			{
			case 1:
				System.out.println("----------------------------");
				System.out.println("THIS IS THE INVENTORY:");
				// return the shopping cart
				for (int i = 1; i < inventory.returnList().size() + 1; i++) // read an inventory list
				{
					System.out.println("---- item #" + i + " ----");
					System.out.println(inventory.returnList().get(i - 1));
				}
				exit = false;
				break;
			case 2:
				// check if the shopping cart is empty or not
				if (cart.returnList().size() < 1)
				{
					System.out.println("----------------------------");
					System.out.println("YOUR SHOPPING CART IS EMPTY");
					System.out.println("----------------------------");
				} else
				{
					System.out.println("----------------------------");
					System.out.println("YOUR SHOPPING CART:");
					for (int i = 1; i < cart.returnList().size() + 1; i++) // read an inventory list
					{
						System.out.println("---- item #" + i + " ----");
						System.out.println(cart.returnList().get(i - 1));
					}
				}
				exit = false;
				break;
			case 3:
				purchase();
				exit = false;
				break;
			case 4:
				cancel();
				exit = false;
				break;
			case 5:
				cart.emptyCart();
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
	 * This is logic method between server and client networking using Thread in the background
	 * @throws IOException
	 * @throws CustomException
	 */
	public static void manageByAd() throws IOException, CustomException
	{
		System.out.println("Waiting for a Admin connection......");
		Socket clientSocket = server.checkConnection(6666);
		System.out.println("Received a Client connection on port " + server.getPort());
		Map<String, Object> map = server.start(clientSocket);
		String cmd = (String) map.get("data");
		System.out.println("Got a command: " + cmd );
		if (cmd.equalsIgnoreCase("R"))
		{
			System.out.println("Admin want to retrieve the Inventory");
		}
		else if (cmd.equalsIgnoreCase("U"))
		{
			inventory.addNewProduct((Product) map.get("product"));
			System.out.println("Admin want to update the Inventory");
		}
		else if (cmd.equalsIgnoreCase("Q"))
		{
			// Exit message that Server is shut down
			System.out.println("Server is shut down");
		}
		System.out.println("--------------------------");

		server.cleanup();


	}

	/**
	 * Main method to display welcome message and get all the code load r
	 * 
	 * @param args this is automatic JAVA generation
	 * @throws CloneNotSupportedException throw this exception to indicate that an
	 *                                    object could not or should not be cloned.
	 * @throws CustomException            is a custom exception
	 * @throws IOException
	 * 
	 */
	public static void main(String[] args) throws CloneNotSupportedException, CustomException, IOException
	{
		StoreFront store = new StoreFront();
		inventory = new Inventory();
		inventory.initialize(); // initialize list of Salable Product in Inventory list
		cart.initialize(); // initialize list of Salable Product in Inventory list
		boolean isAdmin = true;
		while (isAdmin == true)
		{
			System.out.println("Make any change as Admin? (Y/N)");
			String input = scan.nextLine();
			if (input.equalsIgnoreCase("Y"))
			{
				manageByAd();
				isAdmin = true;
			}
			else if (input.equalsIgnoreCase("N"))
			{
				isAdmin = false;
			}
		}
		System.out.println("--------------------------------------------");
		System.out.println("----------- WELCOME TO UWU STORE -----------");
		System.out.println("---In here you can find all what you need---");
		System.out.println("--------------------------------------------");
		store.showMenu();
	}
}
