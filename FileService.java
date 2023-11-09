/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 11/05/2023
 * This is Inventory manager for Milestone 4
 * This is my own work
 */
package game;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import exception.CustomException;

/**
 * represent and maintain the state of the Salable Product inventory available
 * in the Store
 */
public class FileService
{
	/**
	 * saving method for array data which takes all parameters
	 * 
	 * @param filename  is a text file of inventory
	 * @param inventory is an array of list of inventory product
	 * @throws CustomException
	 */
	private void saveToFile(String filename, Product[] inventory) throws CustomException
	{
		PrintWriter pw = null;
		try
		{
			// Create a file File to write
			File file = new File(filename);
			FileWriter fw = new FileWriter(file);
			pw = new PrintWriter(fw);

			// Write Product as JSON
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(inventory);
			pw.println(json);

		} 
		catch (Exception e)
		{
			throw new CustomException(e, "Something bad happened reading the file");
		} 
		finally
		{
			pw.close();
		}
	}

	/**
	 * reading method for array data which takes all parameters
	 * 
	 * @param filename is a text file of inventory
	 * @return the array of inventory's Product
	 * @throws CustomException 
	 */
	private Product[] readFromFile(String filename) throws CustomException
	{
		Product[] inventory = null;
		try
		{
			// Read a string of JSON from a file and convert to an array of
			ObjectMapper objectMapper = new ObjectMapper();
			inventory = objectMapper.readValue(new File(filename), Product[].class);
		} catch (Exception e)
		{
			throw new CustomException(e, "Something bad happened reading the file");
		} 

		// Return the list of Cars
		return inventory;
	}

	/**
	 * method use the File Service to read, write and store data to text file and
	 * vice versa
	 * 
	 * @param list of array list need to convert to array
	 * @return the array list which is converted from array
	 * @throws CustomException 
	 */
	public ArrayList<Product> useFile() throws CustomException
	{
		ArrayList<Product> inventory = new ArrayList<Product>();
		// create 2 Weapon objects
		Product gun = new Weapon("gun", "100 Damage", 125.00, 25);
		Product bomb = new Weapon("bomb", "150 Damage", 175.00, 25);
		// create 2 Armor objects
		Product shield = new Armor("shield", "900 Block", 450.00, 13);
		Product helmet = new Armor("helmet", "250 Block", 100.00, 20);
		// create 2 Health objects
		Product food = new Health("food", "500 HP", 500.00, 15);
		Product drink = new Health("drink", "300 HP", 150.00, 14);

		// Create an initial inventory with products
		inventory.add(gun);
		inventory.add(bomb);
		inventory.add(shield);
		inventory.add(helmet);
		inventory.add(food);
		inventory.add(drink);

		Collections.sort(inventory);

		Product[] list = inventory.toArray(new Product[0]);
		// Write the inventory of product to a file as JSON
		saveToFile("out.json", list);

		// Read the product from the file and print.out
		Product[] product = readFromFile("out.json");
		ArrayList<Product> inventoryList = new ArrayList<>(Arrays.asList(product));
		return inventoryList;
	}
}
