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
		System.out.println("1. RETRIEVE Inventory");		
		System.out.println("2. UPDATE Inventory");		
		System.out.println("3. QUIT");		
		System.out.println("---------");
		while (!userInput.hasNextInt()) // check if input is a number
		{
			System.out.println("Input is not a number.");
			userInput.nextLine();
		}
		// when input is a number, the while loop return false and stop
		int input = userInput.nextInt();
		client.start("127.0.0.1", 6666);

		switch (input)
		{
		case 1:
			// return all the salable products from the Store Front
			response = client.sendMessage("R");
			System.out.println("Inventory Manager response was " + response);
			break;
		case 2:
		
			// Update the Store Front inventory with new Salable Product
			break;
		case 3:
			// QUIT
			break;
		default:
			System.out.println("There is no method exist for this option. Please choose a desire number");
		}
	}
}
