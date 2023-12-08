package client;

import java.util.Scanner;

public class Administration
{
	static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args)
	{
		System.out.println("----------------------------------------------------------");
		System.out.println("----------- THIS IS ADMINISTRATIVE APPLICATION -----------");
		System.out.println("----------------------------------------------------------");		
		System.out.println("Choose action to continue:");
		System.out.println("---------");		
		System.out.println("Command R: Return all the Salable Products from the Store Front Inventory");		
		System.out.println("Command U: Update the Store Front inventory with new Salable Products.");		
		String input = userInput.nextLine();
	}
}
