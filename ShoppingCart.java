/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 11/05/2023
 * This is Inventory manager for Milestone 4
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
	 * This is non-default constructor used to initialize the ArrayList for the
	 * Shopping Cart
	 * 
	 * @return the cart ArrayList
	 */
	public ArrayList<Product> initialize()
	{
		ArrayList<Product> shopCart = new ArrayList<Product>();
		return shopCart;
	}

	/**
	 * This is determined as adding method for Shopping Cart It is used when the
	 * Purchase method of StoreFront been called
	 * 
	 * @param another is a chosen Salable Product
	 * @return the another Salable Product
	 */
	public Product addProduct(Product another)
	{
		boolean isExist = false;
		int item = 0;

		// Read through the shopping cart
		while (isExist == false && item < shopCart.size())
		{
			int compare = another.getName().compareToIgnoreCase(shopCart.get(item).getName());
			// if the name of item user want to add match the existed product in cart
			if (compare == 0)
			{
				Product product = shopCart.get(item);
				// adjust the quantity of chosen product
				product.setQuantity(product.getQuantity() + another.getQuantity());
				isExist = true;
			}

			// however, if it not match, continually check name of other existed product
			// until the checker reach the end of the shopping cart arraylist
			else
			{
				item += 1;
			}
		}

		// After check through the array list
		// If there is no product in cart match name of product want add
		// add a whole new product to cart
		if (item == shopCart.size())
		{
			shopCart.add(another);
		}
		Collections.sort(shopCart);
		return another;
	}

	/**
	 * This is determine the getProduct method of Shopping Cart
	 * 
	 * @param name is a name of product
	 * @param qty is a quantity of chosen product
	 * @return temp is a clone product
	 * @throws CloneNotSupportedException throw this exception to indicate that an object could not or should not be cloned.
	 */
	public Product getProduct(String name, int qty) throws CloneNotSupportedException
	{

		boolean hasError = false;
		boolean found = false;
		Product temp = null;
		int item = 0;

		// read through the shopping cart ArrayList
		while (item < shopCart.size() && found == false && hasError == false)
		{
			// check if the name of Product in shopping cart match with the name we looking
			// for
			int compare = name.compareToIgnoreCase(shopCart.get(item).getName());
			// if the name is matched
			if (compare == 0)
			{
				Product product = shopCart.get(item);
				// check if shopping cart have enough product user need
				if (product.getQuantity() < qty) // if they don't
				{
					System.out.println("ERROR: BAD NUMBER, SHOPPING CART DOES NOT HAVE ENOUGH TO CANCEL ");
					hasError = true;
				} else // if they do
				{
					// create a clone product to transfer to Shopping cart
					temp = (Product) product.clone();
					temp.clone();
					temp.setQuantity(qty);
					temp.getQuantity();
					product.setQuantity(product.getQuantity() - qty);
					if (product.getQuantity() == 0)
					{
						shopCart.remove(item);
					}
					found = true;
				}
			} else
			{
				item += 1;
			}
		}
		// After check through the array list
		// If there is no product in shopping cart match name of product want cancel
		// display an error message
		if (item == shopCart.size())
		{
			System.out.println("ERROR: PRODUCT IS NOT FOUND");
		}

		return temp;
	}

	/**
	 * This is determined as returning method for Shopping Cart ArrayList
	 * 
	 * @return the shopping cart ArrayList
	 */
	public ArrayList<Product> returnList()
	{
		return shopCart;
	}
	
	/**
	 * This is determined as empty method for the Shopping Cart when check out
	 * @return the shopping cart ArrayList
	 */
	public ArrayList<Product> emptyCart()
	{
		shopCart.removeAll(shopCart);
		System.out.println(".... EMPTY YOUR SHOPPING CART --> EXIT NOW");

		return shopCart;

	}

}
