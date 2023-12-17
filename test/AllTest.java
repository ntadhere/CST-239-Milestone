package test;

import static org.junit.Assert.*;
import org.junit.Test;

import server.Inventory;
import server.Product;
import server.Armor;
import server.Health;
import server.Weapon;

import java.util.List;


public class AllTest
{
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
        Product product = new Armor("Armor1", "200 strength", 50.0, 10);
        inventory.returnList().add(product);

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
    @Test
    public void testProductCompareTo() {
        Product product1 = new Armor("Armor1", "Protective armor", 50.0, 10);
        Product product2 = new Armor("Armor2", "Durable armor", 60.0, 5);

        assertTrue(product1.compareTo(product2) < 0);
    }

    @Test
    public void testProductClone() throws CloneNotSupportedException {
        Product product = new Armor("Armor1", "Protective armor", 50.0, 10);
        Product clonedProduct = (Product) product.clone();

        assertEquals(product.getName(), clonedProduct.getName());
        assertEquals(product.getDescription(), clonedProduct.getDescription());
        assertEquals(product.getPrice(), clonedProduct.getPrice(), 0.001);
        assertEquals(product.getQuantity(), clonedProduct.getQuantity());
    }
    @Test
    public void testArmorConstructor() {
        Armor armor = new Armor("Heavy Armor", "Durable protective armor", 100.0, 5);
        assertEquals("Heavy Armor", armor.getName());
        assertEquals("Durable protective armor", armor.getDescription());
        assertEquals(100.0, armor.getPrice(), 0.001);
        assertEquals(5, armor.getQuantity());
    }
    
    @Test
    public void testHealthConstructor() {
        Health health = new Health("Health", "50 HP", 50.0, 10);
        assertEquals("Health", health.getName());
        assertEquals("50 HP", health.getDescription());
        assertEquals(50.0, health.getPrice(), 0.001);
        assertEquals(10, health.getQuantity());
    }
    
    @Test
    public void testWeaponConstructor() {
        Weapon weapon = new Weapon("Weapon", "150 Damage", 50.0, 10);
        assertEquals("Weapon", weapon.getName());
        assertEquals("150 Damage", weapon.getDescription());
        assertEquals(50.0, weapon.getPrice(), 0.001);
        assertEquals(10, weapon.getQuantity());
    }
}

