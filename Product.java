/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 10/15/2023
 * This is salable Product for Milestone3
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
	 * Override comparable method to sort Product by name and price
	 */
	public int compareTo(Product p)
	{
		int value = this.name.compareTo(p.name);
		if (value == 0) 
		{
			Double obj1= this.price;
			Double obj2= p.price;
			int compareValue=obj1.compareTo(obj2);
			return compareValue;
		}
		else
		{
			return value;
		}
	}
	
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	// class methods
	public void setQuantity(int x)
	{
		this.quantity = x;
	}

	public String getName()
	{
		return name;
	}

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
