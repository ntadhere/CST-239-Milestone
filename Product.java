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

// Jackson Type Info for all Sub-Classes of a Car
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
/**
 * This is an abstract Salable Product class of StoreFront
 */
public abstract class Product implements Cloneable, Comparable<Product>
{

	// properties
	private String name;
	private String description;
	private double price;
	private int quantity;

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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getQuantity()
	{
		return quantity;
	}

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
