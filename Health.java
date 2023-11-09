/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 11/05/2023
 * This is Inventory manager for Milestone 4
 * This is my own work
 */
package game;

/**
 * Health class is inherited from Product abstract class
 */
public class Health extends Product
{
	/**
	 * This is the default constructor for this class which inherited from super class
	 */
	public Health()
	{
		super();
	}
	/**
	 * This is the non default constructor that takes all parameters.
	 * @param name the name for Weapon
	 * @param description the description for Weapon
	 * @param price the price for Weapon
	 * @param quantity the quantity for Weapon
	 */
	public Health(String name, String description, double price, int quantity)
	{
		super(name, description, price, quantity);
	}

}
