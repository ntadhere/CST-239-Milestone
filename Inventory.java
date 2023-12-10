/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 11/12/2023
 * This is Inventory manager
 * This is my own work
 */
package server;

import java.util.*;

import exception.CustomException;

/**
 * this is the inventory of available Salable Products in store
 */
public class Inventory implements Cloneable
{
	 
	FileService file;
	List<Product> inventory;
	
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
	
	/**
	 * This is determined an updated list with new Product added
	 * @param another Product object
	 * @return a new updated list
	 */
	public List<Product> addNewProduct(Product another)
	{
		inventory.add(another);
		return inventory;
	}

}
