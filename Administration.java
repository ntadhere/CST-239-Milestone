package client;

import java.io.IOException;
import java.util.Scanner;

public class Administration
{
	static Scanner userInput = new Scanner(System.in);
	static AdminService client = new AdminService();
	public static void main(String[] args) throws IOException
	{
		String response =null;
		System.out.println("----------------------------------------------------------");
		System.out.println("----------- THIS IS ADMINISTRATIVE APPLICATION -----------");
		System.out.println("----------------------------------------------------------");		
		System.out.println("Choose action to continue:");
		System.out.println("---------");		
		System.out.println("Command R: Return all the Salable Products from the Store Front Inventory");		
		System.out.println("Command U: Update the Store Front inventory with new Salable Products.");		
		System.out.println("---------");		
		String input = userInput.nextLine();
		
		if (input.equalsIgnoreCase("R"))
		{
			// return all the salable products from the Store Front
			client.start("127.0.0.1", 6666);
			response = client.sendMessage("Admin want to view the Inventory");
			System.out.println("Inventory Manager response was " + response);
		}
		if (input.equalsIgnoreCase("U"))
		{
			// Update the Store Front inventory with new Salable Product
		}
	}
}
