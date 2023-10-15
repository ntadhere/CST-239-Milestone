/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 10/15/2023
 * This is Weapon class for Milestone 3
 * This is my own work
 */
package game;


/**
 * Weapon class is inherited from Product abstract class
 */
public class Weapon extends Product
{

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
		// TODO Auto-generated constructor stub
	}

}
