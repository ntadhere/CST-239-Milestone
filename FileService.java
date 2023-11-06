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

public class FileService
{
	private void saveToFile(String filename, Product[] inventory)
	{
		PrintWriter pw = null;
		try
		{
			// Create a file File to write
			File file = new File(filename);
			FileWriter fw = new FileWriter(file);
			pw = new PrintWriter(fw);

			// Write Car as JSON
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(inventory);
			pw.println(json);

			// if json throw the exception, pw.close() will run bad and never close
			// Cleanup
			// pw.close();

			//
		} catch (IOException e)
		{
			// Print exception
			// BAD CODE: create a custom exception to throw back to the call
			e.printStackTrace();
		} finally
		{
			pw.close();
		}
	}

	private Product[] readFromFile(String filename)
	{
		Product[] inventory = null;
		try
		{
			// Read a string of JSON from a file and convert to an array of
			// Cars (could have used ArrayList as well)
			ObjectMapper objectMapper = new ObjectMapper();
			inventory = objectMapper.readValue(new File(filename), Product[].class);
		} catch (IOException e)
		{
			// print exception
			e.printStackTrace();
		}

		// Return the list of Cars
		return inventory;
	}

	public ArrayList<Product> useFile(ArrayList<Product> list)
	{
		Product[] inventory = list.toArray(new Product[0]);
		// Write the Cars to a file as JSON
		saveToFile("out.json", inventory);

		// Read the Cars from the file and print.out
		Product[] product = readFromFile("out.json");
		ArrayList<Product> inventoryList = new ArrayList<>(Arrays.asList(product));
		return inventoryList;
	}
}
