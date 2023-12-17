package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import server.ShoppingCart;
import server.Weapon;
import server.Product;



import java.util.List;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @Before
    public void setUp() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void testAddProduct() {
        // Create a sample product
        Product product = new Weapon("gun", "100 Damage", 125.00, 25);

        // Add the product to the shopping cart
        shoppingCart.addProduct(product);

        // Check if the product is in the shopping cart
        List<Product> cartList = shoppingCart.returnList();
        assertTrue(cartList.contains(product));
    }

    @Test
    public void testGetProduct(){
        // Create a sample product
        Product product = new Weapon("gun", "100 Damage", 125.00, 25);

        // Add the product to the shopping cart
        shoppingCart.addProduct(product);

        // Get the product from the shopping cart
        Product retrievedProduct = null;
		try
		{
			retrievedProduct = shoppingCart.getProduct("gun", 1);
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}

        // Check if the retrieved product is the same as the original product
        assertEquals(product.getName(), retrievedProduct.getName());
        assertEquals(product.getDescription(), retrievedProduct.getDescription());
        assertEquals(product.getPrice(), retrievedProduct.getPrice(), 0.001);

        // Check if the quantity in the shopping cart has been updated
        List<Product> cartList = shoppingCart.returnList();
        assertEquals(24, cartList.get(0).getQuantity());
    }

    @Test
    public void testEmptyCart() {
        // Create a sample product
        Product product = new Weapon("gun", "100 Damage", 125.00, 25);

        // Add the product to the shopping cart
        shoppingCart.addProduct(product);

        // Empty the shopping cart
        shoppingCart.emptyCart();

        // Check if the shopping cart is empty
        List<Product> cartList = shoppingCart.returnList();
        assertTrue(cartList.isEmpty());
    }

    // Add more tests for other methods in ShoppingCart class as needed

}

