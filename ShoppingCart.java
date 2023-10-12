/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 10/15/2023
 * This is ShoppingCart class for Milestone 3
 * This is my own work
 */

package game;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This is Shopping Cart of the Store Front
 */
public class ShoppingCart
{
	ArrayList<Product> shopCart = initialize();
	
	/**
	 * This is non-default constructor used to initialize the ArrayList for the Shopping Cart
	 * @return the cart ArrayList
	 */
	public ArrayList<Product> initialize()
	{
		ArrayList<Product> shopCart = new ArrayList<Product>();
		return shopCart;
	}
	
	/**
	 * This is determined as adding method for Shopping Cart
	 * It is used when the puchase method of StoreFront been called
	 * @param another is a chosen Salable Product
	 * @return the another Salable Product
	 */
	public Product addProduct(Product another){
		shopCart.add(another);
		Collections.sort(shopCart);
		return another;
	}
	
	
	/**
	 * This is determine the getProduct method of Shopping Cart
	 * @param name is a name of product 
	 * @param qty is a quantity of chosen product
	 * @return temp is a clone product
	 * @throws CloneNotSupportedException
	 */
	public Product getProduct(String name, int qty) throws CloneNotSupportedException
	{
		Product temp = null;
		int item = 0;
		while (item < shopCart.size())
		{
			int compare = name.compareToIgnoreCase(shopCart.get(item).getName());
			if (compare == 0) 
			{
				Product product = shopCart.get(item);
				temp = (Product)product.clone();
				temp.clone();
				temp.setQuantity(qty);
				temp.getQuantity();
				product.setQuantity(product.getQuantity()-qty);
				if (product.getQuantity() ==0)
				{
					shopCart.remove(item);
				}
				item += shopCart.size();
				
				
			}
			else
			{
				item +=1;
			}
		}
		return temp;	
	}

	/**
	 * This is determined as returning method for inventory ArrayList
	 * @return the inventory ArrayList 
	 */
	public void returnList() {
		for (int i = 1; i < shopCart.size() + 1; i++)	// read an inventory list
		{
			System.out.println("---- item #" + i + " ----");
			System.out.println(shopCart.get(i - 1));
		}
	}
	
	
}
