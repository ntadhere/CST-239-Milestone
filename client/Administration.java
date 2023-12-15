/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 12/10/2023
 * This is Administration Application
 * This is my own work
 */
package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import exception.CustomException;
import server.FileService;
import server.Product;

/**
 * Administration Application for Milestone 6
 */
public class Administration
{
	private static Scanner userInput = new Scanner(System.in);
	private static Scanner update = new Scanner(System.in);
	private static AdminService client = new AdminService();
	private static FileService file = new FileService();

	/**
	 * Main method or the application - entrance
	 * 
	 * @param args argument (not important)
	 * @throws IOException
	 * @throws CustomException
	 */
	public static void main(String[] args) throws IOException, CustomException
	{
		client.start("127.0.0.1", 6666);
		boolean isExit = false;
		while (isExit == false)
		{
			// ------------------------
			// MENU SYSTEM
			String response = null;
			System.out.println("----------------------------------------------------------");
			System.out.println("----------- THIS IS ADMINISTRATIVE APPLICATION -----------");
			System.out.println("----------------------------------------------------------");
			System.out.println("Choose action to continue:");
			System.out.println("---------");
			System.out.println("1. RETRIEVE Inventory");
			System.out.println("2. UPDATE Inventory");
			System.out.println("3. QUIT");
			System.out.println("---------");
			// ------------------------
			// USER INPUT CHECK
			while (!userInput.hasNextInt()) // check if input is a number
			{
				System.out.println("Input is not a number.");
				userInput.nextLine();
			}
			// when input is a number, the while loop return false and stop
			int input = userInput.nextInt();
			// Create a Client and connect to the remote Server on the specified IP Address
			// and Port

			// --------------------------
			// SWITCH CASE RESPONSE
			switch (input)
			{
			case 1:
				// return all the salable products from the Store Front
				response = client.sendMessage("R");
//			System.out.println("Inventory Manager response was ");
//			file.saveToFile("admin.txt", file.jsonToArray(response));
//			Product[] product = file.readFromFile("admin.txt");
//			List<Product> inventoryList = new ArrayList<>(Arrays.asList(product));
//			System.out.println("Inventory Manager response was ");

				System.out.println("Inventory Manager response was ");
				List<Product> inventoryList = new ArrayList<>(Arrays.asList(file.readFromFile("admin.json")));
				System.out.println("----------------------------");
				System.out.println("THIS IS THE INVENTORY:");
				// return the shopping cart
				for (int i = 1; i < inventoryList.size() + 1; i++) // read an inventory list
				{
					System.out.println("---- item #" + i + " ----");
					System.out.println(inventoryList.get(i - 1));
				}
				isExit = false;
				break;
			case 2:
				// Update the Store Front inventory with new Salable Product
				System.out.println("Enter data follow this order: 'type, name, description, price, quantity'");
				String data = update.nextLine();
				response = client.sendMessage("U" + " | " + data);
				System.out.println("Inventory Manager response was ");
				System.out.println(response);
				isExit = false;
				break;
			case 3:
				// QUIT
				client.sendMessage("Q");
				System.out.println("You exit out of Administration Application.");
				isExit = true;
				break;
			default:
				isExit = false;
				System.out.println("There is no method exist for this option. Please choose a desire number");
			}
		}
		client.cleanup();
	}
}