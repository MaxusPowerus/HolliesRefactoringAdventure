package utilities;

import java.util.ArrayList;

import items.Food;
import items.Item;
import items.Outfit;
import items.Weapon;

public class Inventory {

	private ArrayList<Item> items;

	public Inventory() {
		items = new ArrayList<Item>();
	}

	public void add(Item item) {
		Item itemInInv = this.getItem(item);
		if (itemInInv != null) {
			itemInInv.incrementCount();
			return;
		}

		items.add(item);
	}

	public void add(Container container) {
		Inventory inv = container.getInventory();
		this.add(inv);
	}

	private void add(Inventory inventory) {
		ArrayList<Item> items = inventory.getAllItems();
		this.add(items);
	}

	private void add(ArrayList<Item> items) {
		for (int i = 0; i < items.size(); i++) {
			this.add(items.get(i));
		}
	}

	public void remove(Item item) {
		Item itemInInv = this.getItem(item);
		if (itemInInv != null) {
			itemInInv.decrementCount();
			return;
		}
		items.remove(itemInInv);
	}

	private Item getItem(Item item) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getUniqueName() == item.getUniqueName())
				return items.get(i);
		}
		return null;
	}

	public ArrayList<Item> getAllItems() {
		return items;
	}

	public ArrayList<Weapon> getWeapons() {
		ArrayList<Weapon> weapons = new ArrayList<Weapon>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Weapon) {
				weapons.add((Weapon) items.get(i));
			}
		}
		return weapons;
	}

	public ArrayList<Outfit> getOutfits() {
		ArrayList<Outfit> outfits = new ArrayList<Outfit>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Outfit) {
				outfits.add((Outfit) items.get(i));
			}
		}
		return outfits;
	}

	public ArrayList<Food> getFood() {
		ArrayList<Food> food = new ArrayList<Food>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Food) {
				food.add((Food) items.get(i));
			}
		}
		return food;
	}

}
