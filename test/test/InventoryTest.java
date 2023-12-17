package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import exception.CustomException;
import server.Armor;
import server.FileService;
import server.Health;
import server.Inventory;
import server.Product;

public class InventoryTest
{
	//----------------------------------------
  	// INVENTORY
    //----------------------------------------

	@Test
    public void testInitialize() {
        Inventory inventory = new Inventory();
        List<Product> productList = inventory.initialize();
        assertNotNull(productList);
        assertFalse(productList.isEmpty());
    }

    @Test
    public void testGetProduct() throws CloneNotSupportedException {
        Inventory inventory = new Inventory();
        FileService file = new FileService();
        Product product = new Armor("Armor1", "200 strength", 50.0, 10);
        List<Product> temp = inventory.returnList();
        temp.add(product);
        try
		{
			file.useFile(temp, "out.json");
		} catch (CustomException e)
		{
			e.printStackTrace();
		}

        Product retrievedProduct = inventory.getProduct("Armor1", 5);
        assertNotNull(retrievedProduct);
        assertEquals("Armor1", retrievedProduct.getName());
        assertEquals(5, retrievedProduct.getQuantity());
    }

    @Test
    public void testAddProduct() {
        Inventory inventory = new Inventory();
        Product product = new Health("Health", "50 HP", 50.0, 10);

        Product addedProduct = inventory.addProduct(product);
        assertNotNull(addedProduct);
        assertEquals("Health", addedProduct.getName());
        assertEquals(10, addedProduct.getQuantity());
    }

    @Test
    public void testReturnList() {
        Inventory inventory = new Inventory();
        List<Product> productList = inventory.returnList();
        assertNotNull(productList);
        assertFalse(productList.isEmpty());
    }
}
