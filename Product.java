/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 10/15/2023
 * This is salable Product for Milestone 3
 * This is my own work
 */

package game;

/**
 * This is an abstract Salable Product class of StoreFront
 */
public abstract class Product implements Cloneable, Comparable<Product>
{

	// properties
	private String name = "";
	private String description = "";
	private double price = 0.00;
	private int quantity = 0;

	/**
	 * This is the non default constructor that takes all parameters.
	 * 
	 * @param name        the name of the product
	 * @param description description of the product such as its specific function
	 * @param price       the price of the product
	 * @param quantity    the quantity of the product
	 */
	public Product(String name, String description, double price, int quantity)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	/**
	 * Override comparable interface to sort Product by name and price
	 */
	public int compareTo(Product another)
	{
		int value = this.name.compareToIgnoreCase(another.name);
		if (value == 0)
		{
			Double obj1 = this.price;
			Double obj2 = another.price;
			int compareValue = obj1.compareTo(obj2);
			return compareValue;
		} else
		{
			return value;
		}
	}

	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	/**
	 * This is determined as set quantity method for Product class
	 * @param qty is quantity of product
	 */
	public void setQuantity(int qty)
	{
		this.quantity = qty;
	}

	/**
	 * This is determined as get name method for Product class
	 * @return name of that Product
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * This is determined as get quantity method for Product class
	 * @return quantity of that Product
	 */
	public int getQuantity()
	{
		return quantity;
	}

	/**
	 * override the toString to format the appearance of each item
	 */
	@Override
	public String toString()
	{
		return String.format("%s\n%s\n%.2f\n%d available item \n", name, description, price, quantity);
	}

}
