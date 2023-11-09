/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 11/05/2023
 * This is Inventory manager for Milestone 4
 * This is my own work
 */

package game;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This is an abstract Salable Product implement Cloneable and Comparable from Java Library
 */

// Jackson Type Info for all Sub-Classes of Product
// Maps the type field to the Sub-Class types
@JsonTypeInfo
(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "type"
)
@JsonSubTypes
(
		{
			@Type(value = Weapon.class, name = "weapon"),
			@Type(value = Armor.class, name = "armor"),
			@Type(value = Health.class, name = "health"),
		}
)


public abstract class Product implements Cloneable, Comparable<Product>
{

	// properties
	private String name;
	private String description;
	private double price;
	private int quantity;

	/**
	 * This is default constructor 
	 */
	public Product()
	{
		name = "";
		description = "";
		price = 0.00;
		quantity = 0;
	}
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
	 * this getter get name of the product
	 * @return name the product name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * this setter set name for the product
	 * @param name is name of the product
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * this getter get description of the product
	 * @return description the product description
	 */
	public String getDescription()
	{
		return description;
	}
	/**
	 * this setter set description for the product
	 * @param description is decription of the product
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	/**
	 * this getter get price of the product
	 * @return price the product price
	 */
	public double getPrice()
	{
		return price;
	}
	/**
	 * this setter set price for the product
	 * @param price is price of the product
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}
	/**
	 * this getter get quantity of the product
	 * @return quantity the product quantity
	 */
	public int getQuantity()
	{
		return quantity;
	}
	/**
	 * this setter set quantity for the product
	 * @param quantity is quantity of the product
	 */
	public void setQuantity(int quantity)
	{
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

	/**
	 * this make a clonable of a chosen product
	 */
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
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
