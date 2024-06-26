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

	FileService file = new FileService();
	List<Product> inventory = returnList();

	/**
	 * default constructor of inventory class
	 */
	public Inventory()
	{
		inventory = initialize();
	}

	/**
	 * Override the protected clone method defined in the Object class, and
	 * strengthen its accessibility
	 * 
	 * @return the clone object
	 * @throws CloneNotSupportedException
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	/**
	 * this is a non-default constructor use to initialize the inventory declare and
	 * initialize list of available Salable Product list is sort by name and price
	 * @return the ArrayList of Product named inventory
	 */
	public List<Product> initialize()
	{
		try
		{
			inventory = file.useFile(file.createList(), "out.json");
		} catch (CustomException e)
		{
			e.getMessage("Can not initialize Inventory");
		}
		return inventory;
	}

	/**
	 * This is determine the getProduct method of Inventory
	 * 
	 * @param name is a name of product
	 * @param qty  is a quantity of chosen product
	 * @return temp is a clone product
	 * @throws CloneNotSupportedException throw this exception to indicate that an
	 *                                    object could not or should not be cloned.
	 */
	public Product getProduct(String name, int qty) throws CloneNotSupportedException
	{
		returnList();
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
		try
		{
			file.useFile(inventory, "out.json");
		} catch (CustomException e)
		{
			e.getMessage("Error when get Product from Inventory");
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
		returnList();
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
				returnList().get(item).setQuantity(inventory.get(item).getQuantity() + another.getQuantity());
				item += inventory.size();
			}

			// if it is not match
			// continually read through the inventory ArrayList
			else
			{
				item += 1;
			}
		}
		try
		{
			file.useFile(inventory, "out.json");
		} catch (CustomException e)
		{
			e.getMessage("Error when add Product to Inventory");
		}
		return another;
	}

	/**
	 * This is determined as returning method for inventory ArrayList the array list
	 * is converted from Product array which is read from Json file
	 * 
	 * @return the inventory ArrayList
	 */
	public List<Product> returnList()
	{
		inventory = new ArrayList<>(Arrays.asList(file.readFromFile("out.json")));
		return inventory;
	}

}