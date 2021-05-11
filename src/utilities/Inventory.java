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
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).equals(item)) {
				items.get(i).incrementCount();
			}
		}
		items.add(item);
	}

	public void remove(Item item) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).equals(item)) {
				items.get(i).decrementCount();
			}
		}
		items.remove(item);
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
