/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 11/12/2023
 * This is Weapon product
 * This is my own work
 */
package server;
/**
 * Weapon class is inherited from Product abstract class
 */
public class Weapon extends Product
{
	/**
	 * This is the default constructor for this class which inherited from super class
	 */
	public Weapon()
	{
		super();
	}
	/**
	 * This is the non default constructor that takes all parameters.
	 * 
	 * @param name the name for Weapon
	 * @param description the description for Weapon
	 * @param price the price for Weapon
	 * @param quantity the quantity for Weapon
	 */
	public Weapon(String name, String description, double price, int quantity)
	{
		super(name, description, price, quantity);
	}

}
