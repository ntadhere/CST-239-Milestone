package game;

import java.util.ArrayList;

/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 10/15/2023
 * This is ShoppingCart class for Milestone 3
 * This is my own work
 */


public class ShoppingCart
{
	ArrayList<Product> shopCart = initialize();
	/*-----------------------------
	 * initialize method
	 * ----------------------------
	 */
	public ArrayList<Product> initialize()
	{
		ArrayList<Product> cart = new ArrayList<Product>();
		return cart;
	}
	
	/*-----------------------------
	 * adding method
	 * ----------------------------
	 */
	public Product addProduct(Product another){
		shopCart.add(another);
		return another;
	}
	
	
	/*-----------------------------
	 * Remove method
	 * ----------------------------
	 */
	public Product getProduct(int num, int qty){
		Product temp = shopCart.get(num-=1);
		temp.setQuantity(qty);
		temp.getQuantity();
		return temp;
	}
	
	public void returnList() {
		for (int i = 1; i < shopCart.size() + 1; i++)	// read an inventory list
		{
			System.out.println("---- item #" + i + " ----");
			System.out.println(shopCart.get(i - 1));
		}
	}
	
	
}
