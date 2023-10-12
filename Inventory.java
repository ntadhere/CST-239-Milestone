/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 10/15/2023
 * This is Inventory manager for Milestone 3
 * This is my own work
 */
package game;

import java.util.*;

/**
 * this is the inventory of available Salable Products in store
 */
public class Inventory implements Cloneable
{
	ArrayList<Product> inventory = initialize();
	/**
	 * Override the protected clone method defined in the Object class, 
	 * and strengthen its accessibility
	 * @return
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	
	
	/**
	 * this is a non-default constructor use to initialize the inventory
	 * declare and initialize list of available Salable Product
	 * list is sort by name and price
	 * @return the ArrayList of Product named inventory
	 */
	public ArrayList<Product> initialize() {
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
		return inventory;
	}
	
	/**
	 * This is determine the getProduct method of Inventory
	 * @param name is a name of product 
	 * @param qty is a quantity of chosen product
	 * @return temp is a clone product
	 * @throws CloneNotSupportedException
	 */
	public Product getProduct(String name, int qty) throws CloneNotSupportedException
	{
		Product temp = null;
		int item = 0;
		
		// read through the inventory ArrayList
		while (item < inventory.size())
		{
			int compare = name.compareToIgnoreCase(inventory.get(item).getName());
			
			// check if the name of Product in list match with the name we looking for
			if (compare == 0) 
			{
				// if it is matched
				// create a clone product to transfer to Shopping cart
				Product product = inventory.get(item);
				temp = (Product)product.clone();
				temp.clone();
				temp.setQuantity(qty);
				temp.getQuantity();
				
				// then adjust the property of that product in Inventory
				product.setQuantity(product.getQuantity()-qty);
				item += inventory.size();
			}
			
			// if it is not match
			// continually read through the inventory ArrayList
			else
			{
				item +=1;
			}
		}
		return temp;	
	}
	
	/**
	 * This is determine the addProdcut method of Inventory
	 * @param another is a Salable Product need to clarify
	 * @return the same product
	 */
	public Product addProduct(Product another){
		
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
				inventory.get(item).setQuantity(
						inventory.get(item).getQuantity()+another.getQuantity());
				item += inventory.size();
			}
			
			// if it is not match
			// continually read through the inventory ArrayList
			else
			{
				item +=1;
			}
		}
		return another;
	}
	
	
	/**
	 * This is determined as returning method for inventory ArrayList
	 * @return the inventory ArrayList 
	 */
	public ArrayList<Product> returnList() {
		for (int i = 1; i < inventory.size() + 1; i++)	// read an inventory list
		{
			System.out.println("---- item #" + i + " ----");
			System.out.println(inventory.get(i - 1));
		}
		return inventory;
	}
	
	
	
	
}

