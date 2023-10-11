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
 * 
 */
public class Inventory implements Cloneable
{
	protected ArrayList<Product> inventory = new ArrayList<Product>();

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
	
	 
	/*-----------------------------
	 * initialize method
	 * ----------------------------
	 */
	public ArrayList<Product> initialize() {
		// create 2 Weapon objects
		Product gun = new Weapon("gun", "100-150 Damage", 125.00, 25);
		Product gun1 = new Weapon("gun", "100-150 Damage", 100.00, 25);
		// create 2 Armor objects
		Product shield = new Armor("shield", "900 Block", 450.00, 13);
		Product helmet = new Armor("helmet", "250 Block", 100.00, 20);
		// create 2 Health objects
		Product food = new Health("food", "500 HP", 500.00, 15);
		Product drink = new Health("drink", "300 HP", 150.00, 14);

		// Create an initial inventory with products
		inventory.add(gun);
		inventory.add(gun1);
		inventory.add(shield);
		inventory.add(helmet);
		inventory.add(food);
		inventory.add(drink);
		
		Collections.sort(inventory);
		return inventory;
	}
	
	/*-----------------------------
	 * Remove method
	 * ----------------------------
	 */
	public Product getProduct(int num, int qty) throws CloneNotSupportedException{
		Product product = inventory.get(num-=1);
		Product temp = (Product)product.clone();
		temp.clone();
		temp.setQuantity(qty);
		temp.getQuantity();
		return temp;
	}
	
	/*-----------------------------
	 * adding method
	 * ----------------------------
	 */
	public Product addProduct(Product another){
		inventory.add(another);
		return another;
	}
	
	
	/*-----------------------------
	 * returning inventory method
	 * ----------------------------
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
