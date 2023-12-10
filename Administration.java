package client;

import java.io.IOException;
import java.util.Scanner;

import exception.CustomException;

public class Administration
{
	static Scanner userInput = new Scanner(System.in);
	static AdminService client = new AdminService();
	public static void main(String[] args) throws IOException, CustomException
	{
		boolean exit = false;
		while (exit != true)
		{
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
		while (!userInput.hasNextInt()) // check if input is a number
		{
			System.out.println("Input is not a number.");
			userInput.nextLine();
		}
		// when input is a number, the while loop return false and stop
		int input = userInput.nextInt();
		switch (input)
		{
		case 1:
			// return all the salable products from the Store Front
			client.start("127.0.0.1", 6666);
			response = client.sendMessage("R");
			System.out.println("Inventory Manager response was ");
			System.out.println(response);
			client.cleanup();
			exit = false;
			break;
		case 2:
			client.start("127.0.0.1", 6666);
			// Update the Store Front inventory with new Salable Product
			exit = false;
			break;
		case 3:
			// QUIT
			System.out.println("You exit out of Administration Application.");
			exit = true;
			break;
		default:
			System.out.println("There is no method exist for this option. Please choose a desire number");
			exit = false;
		}
//		client.cleanup();

		}
	}
}
