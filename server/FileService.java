/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 11/12/2023
 * This is File Service
 * This is my own work
 */
package server;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

import exception.CustomException;

/**
 * represent and maintain the state of the Salable Product inventory available
 * in the Store
 */
public class FileService
{
	public List<Product> createList()
	{
		List<Product> inv = new ArrayList<Product>();
		// create 2 Weapon objects
				Product gun = new Weapon("gun", "100 Damage", 125.00, 25);
				Product bomb = new Weapon("bomb", "150 Damage", 175.00, 25);
				// create 2 Armor objects
				Product shield1 = new Armor("shield", "900 Block", 500.00, 11);
				Product shield = new Armor("shield", "900 Block", 450.00, 13);
				Product helmet = new Armor("helmet", "250 Block", 100.00, 20);
				// create 2 Health objects
				Product food = new Health("food", "500 HP", 500.00, 15);
				Product drink = new Health("drink", "300 HP", 150.00, 14);
				// Create an initial inventory with products
				inv.add(gun);
				inv.add(bomb);
				inv.add(shield1);
				inv.add(shield);
				inv.add(helmet);
				inv.add(food);
				inv.add(drink);

				Collections.sort(inv);
		return inv;
	}
	
	/**
	 * saving method for array data which takes all parameters
	 * 
	 * @param filename  is a text file of inventory
	 * @param inventory is an array of list of inventory product
	 * @throws CustomException is a custom exception
	 */
	public String saveToFile(String filename, Product[] inventory)
	{
		String json = null;
		PrintWriter pw = null;
		try
		{
			// Create a file File to write
			File file = new File(filename);
			FileWriter fw = new FileWriter(file);
			pw = new PrintWriter(fw);

			// Write Product as JSON
			ObjectMapper objectMapper = new ObjectMapper();
			json = objectMapper.writeValueAsString(inventory);
			pw.println(json);

		} 
		catch (Exception e)
		{
			e.getMessage();
		} 
		finally
		{
			pw.close();
		}
		return json;
	}
	

	/**
	 * reading method for array data which takes all parameters
	 * 
	 * @param filename is a text file of inventory
	 * @return the array of inventory's Product
	 * @throws CustomException is a custom exception
	 */
	public Product[] readFromFile(String filename)
	{
		Product[] inventory = null;
		try
		{
			// Read a string of JSON from a file and convert to an array of
			ObjectMapper objectMapper = new ObjectMapper();
			inventory = objectMapper.readValue(new File(filename), Product[].class);
		} catch (Exception e)
		{
			e.getMessage();
		} 

		// Return the list of Cars
		return inventory;
	}

	/**
	 * method use the File Service to read, write and store data to text file and
	 * vice versa
	 * 
	 * @return the array list which is converted from array
	 * @throws CustomException is a custom exception
	 */
	public List<Product> useFile(List<Product> invList, String filename) throws CustomException
	{
		Product[] list = invList.toArray(new Product[0]);
		// Read the product from the file and print.out
		Product[] product = null;
		// Write the inventory of product to a file as JSON
		String json = saveToFile(filename, list);
		product = readFromFile(filename);
		List<Product> inventoryList = new ArrayList<>(Arrays.asList(product));
		return inventoryList;
	}
}