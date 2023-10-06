package game;
/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 10/01/2023
 * This is salable Product for Milestone2
 * This is my own work
 */


//super class
public abstract class Product implements Cloneable
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

	public String getDescription()
	{
		return description;
	}

	public double getPrice()
	{
		return price;
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
