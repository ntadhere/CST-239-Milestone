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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import exception.CustomException;

/**
 * represent and maintain the state of the Salable Product inventory available
 * in the Store
 */
public class FileService
{
	List<Product> inventory;
	public List<Product> getInv()
	{
		return this.inventory;
	}
	public void setInv(List<Product> inventory)
	{
		this.inventory = inventory;
	}
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
				setInv(inv);
		return getInv();
	}
	
	/**
	 * saving method for array data which takes all parameters
	 * 
	 * @param filename  is a text file of inventory
	 * @param inventory is an array of list of inventory product
	 * @throws CustomException is a custom exception
	 */
	public String saveToFile(String filename, Product[] inventory) throws CustomException
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
			throw new CustomException(e, "Something bad happened reading the file");
		} 
		finally
		{
			pw.close();
		}
		return json;
	}
	public String listToJson(List<Product> inventory) throws JsonProcessingException, CustomException
	{
		ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(inventory);
        return json;
	}

	/**
	 * reading method for array data which takes all parameters
	 * 
	 * @param filename is a text file of inventory
	 * @return the array of inventory's Product
	 * @throws CustomException is a custom exception
	 */
	public Product[] readFromFile(String filename) throws CustomException
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
	 * @return the array list which is converted from array
	 * @throws CustomException is a custom exception
	 */
	public List<Product> useFile(List<Product> invList) throws CustomException
	{
		Product[] list = invList.toArray(new Product[0]);
		// Read the product from the file and print.out
		Product[] product = null;
		try
		{
			// Write the inventory of product to a file as JSON
			String json = saveToFile("out.json", list);
			product = readFromFile("out.json");
		} catch (CustomException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Application Error: " + e.getMessage());
		}
		List<Product> inventoryList = new ArrayList<>(Arrays.asList(product));
		return inventoryList;
	}
	/**
	 * Convert List Product to JSON string and return string
	 * @param inventory is the List of Salable Product
	 * @return JSON string
	 * @throws JsonProcessingException
	 * @throws CustomException
	 */
	
	
	public Product[] jsonToArray(String json)
	{
		 ObjectMapper mapper = new ObjectMapper();
		 Product[] products = null;
         try
		{
			products = mapper.readValue(json, Product[].class);
		} catch (JsonMappingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;

	}
}