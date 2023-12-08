/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 11/12/2023
 * This is Inventory manager
 * This is my own work
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import exception.CustomException;

/**
 * this is the inventory of available Salable Products in store
 */
public class Inventory implements Cloneable
{
	 
	FileService file;
	List<Product> inventory;
	// Class member variables
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	/**
	 * default constructor of inventory class
	 * @throws CustomException is a custom exception
	 */
	public Inventory() throws CustomException {
		file = new FileService();
		inventory = initialize();
	}

	/**
	 * Override the protected clone method defined in the Object class, and
	 * strengthen its accessibility
	 * 
	 * @return the clone object
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	/**
	 * this is a non-default constructor use to initialize the inventory declare and
	 * initialize list of available Salable Product list is sort by name and price
	 * 
	 * @return the ArrayList of Product named inventory
	 * @throws CustomException is a custom exception
	 */
	public List<Product> initialize() throws CustomException
	{

		return file.useFile();
	}

	/**
	 * This is determine the getProduct method of Inventory
	 * @param name is a name of product
	 * @param qty  is a quantity of chosen product
	 * @return temp is a clone product
	 * @throws CloneNotSupportedException throw this exception to indicate that an object could not or should not be cloned.
	 */
	public Product getProduct(String name, int qty) throws CloneNotSupportedException
	{
		boolean hasError = false;
		boolean found = false;
		Product temp = null;
		int item = 0;

		// read through the inventory ArrayList
		while (item < inventory.size() && found == false && hasError == false)
		{
			// check if the name of Product in list match with the name we looking for
			int compare = name.compareToIgnoreCase(inventory.get(item).getName());
			// if the name is matched
			if (compare == 0)
			{
				Product product = inventory.get(item);
				// check if inventory have enough product user need
				if (product.getQuantity() < qty) // if they don't
				{
					System.out.println("ERROR: BAD NUMBER, INVENTORY DOES NOT HAVE ENOUGH TO PURCHASE ");
					hasError = true;
				} else // if they do
				{
					// create a clone product to transfer to Shopping cart
					temp = (Product) product.clone();
					temp.clone();
					temp.setQuantity(qty);
					temp.getQuantity();

					// then adjust the property of that product in Inventory
					product.setQuantity(product.getQuantity() - qty);
					found = true;
				}
			}

			// if the name is not match
			// continually read through the inventory ArrayList
			else
			{
				item += 1;
			}
		}

		// After check through the array list
		// If there is no product in inventory match name of product want add
		// display an error message
		if (item == inventory.size())
		{
			System.out.println("ERROR: PRODUCT IS NOT FOUND");
		}
		return temp;
	}

	/**
	 * This is determine the addProdcut method of Inventory
	 * 
	 * @param another is a Salable Product need to clarify
	 * @return the same product
	 */
	public Product addProduct(Product another)
	{

		// read through the inventory ArrayList
		int item = 0;
		while (item < inventory.size())
		{

			// check if the name of Product in list match with the name we looking for
			int compare = another.getName().compareToIgnoreCase(inventory.get(item).getName());
			if (compare == 0)
			{
				// if it is matched
				// add the desired Salable Product back to inventory
				// by adjust the quantity of that Salable Product
				inventory.get(item).setQuantity(inventory.get(item).getQuantity() + another.getQuantity());
				item += inventory.size();
			}

			// if it is not match
			// continually read through the inventory ArrayList
			else
			{
				item += 1;
			}
		}
		return another;
	}

	/**
	 * This is determined as returning method for inventory ArrayList
	 * @return the inventory ArrayList
	 */
	public List<Product> returnList()
	{
		return inventory;
	}
	
	// ------------------------------------------------------------
	// ADMIN MANAGE
	//-------------------------------------------------------------
	public int getPort()
	{ 
		return clientSocket.getLocalPort();
	}
	public Socket connectionCheck(int port)throws IOException
	{
		serverSocket = new ServerSocket(port);
		return clientSocket = serverSocket.accept();
	}
	/**
	 * Start the Server and wait for connections on the specified part.
	 * @param port Port to listen on.
	 * @throws IOException Thrown in the networking classes if something bad happened.
	 */
	public String start(Socket clientSocket) throws IOException
	{
		// If you get here then a Client connected to this Server 
		// Create some input and output network buffers to communicate 
		// back and forth with the Client
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		// Wait for Command (string that is terminated by a line feed character)
		String inputLine;
		if ((inputLine = in.readLine()) != null)
		{
				out.println("Approved");
		}
		return inputLine;
	}
	/**
	 * Cleanup logic to close all the network connections.
	 * 
	 * @throws IOException Thrown if anything bad happens from the networking classed
	 */
	public void cleanup() throws IOException
	{
		// Close all input and output network buffers and sockets
		in.close();
		out.close();
		clientSocket.close();
		serverSocket.close();
	}

}
