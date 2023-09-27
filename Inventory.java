package game;

import java.util.ArrayList;

public class Inventory {
	ArrayList<Product> list = new ArrayList<Product>();
	int item = 6;

	public Inventory() {
		productList();
	}
	
	public void productList() {
		//create 2 Weapon objects
		Weapon gun = new Weapon("gun", "100-150 Damage", 125.00, 25);
		Weapon bomb = new Weapon("bomb", "320-400 Damage", 400.00, 12);

		//create 2 Armor objects
		Armor shield = new Armor("shield", "900 Block", 450.00, 13);
		Armor helmet = new Armor("helmet", "250 Block", 100.00, 20);
		
		//create 2 Health objects
		Health food = new Health("food", "Restores 1,000 HP", 500.00, 15);
		Health drink = new Health("drink", "Restores 300 HP", 150.00, 14);
		
		//Create an initial inventory with products
		list.add(gun);
		list.add(bomb);
		list.add(shield);
		list.add(helmet);
		list.add(food);
		list.add(drink);

	}
	
	public void show() {
		System.out.println("------------------------------");
		System.out.println("There are " + item + " items in the Store Inventory");
		System.out.println("------------------------------");

		for(int i=1; i< list.size()+1; i++) {
			System.out.println("---- item #" + i + " ----");
			System.out.println(list.get(i-1));
		}
	}

}

    