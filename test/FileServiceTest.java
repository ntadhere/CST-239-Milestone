package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import server.FileService;
import server.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileServiceTest {

    private FileService fileService;
    private String testFileName;

    @Before
    public void setUp() {
        fileService = new FileService();
        testFileName = "test_inventory.json";
    }

    @Test
    public void testSaveAndReadFromFile(){
        // Create a sample inventory list
        List<Product> inventoryList = fileService.createList();

        // Save the inventory list to a test file
        fileService.saveToFile(testFileName, inventoryList.toArray(new Product[0]));

        // Read the inventory list from the test file
        List<Product> readInventoryList = new ArrayList<>(Arrays.asList(fileService.readFromFile(testFileName)));

        // Check if the read inventory list is not null
        assertNotNull(readInventoryList);
        // Check if the read inventory list is the same as the original inventory list
        for (int i=0; i < inventoryList.size(); i++)
        {
        	 assertEquals(inventoryList.get(i).getName(), readInventoryList.get(i).getName());
             assertEquals(inventoryList.get(i).getDescription(), readInventoryList.get(i).getDescription());
             assertEquals(inventoryList.get(i).getPrice(), readInventoryList.get(i).getPrice(), 0.001);
             assertEquals(inventoryList.get(i).getQuantity(), readInventoryList.get(i).getQuantity());
        }
    }
}
