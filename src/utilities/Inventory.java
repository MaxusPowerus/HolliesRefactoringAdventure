package utilities;

import java.util.ArrayList;
import java.util.HashMap;

import items.Food;
import items.Item;
import items.Note;
import items.Other;
import items.Outfit;
import items.QuestItem;
import items.Weapon;

public class Inventory {

	private ArrayList<Item> items;
	private int gold;
	private int selectedIndex;

	public Inventory() {
		this.selectedIndex = 0;
		items = new ArrayList<Item>();
		gold = 0;
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

	public void add(Inventory inventory) {
		ArrayList<Item> items = inventory.getAllItems();
		this.add(items, inventory.getGold());
	}

	private void add(ArrayList<Item> items, int gold) {
		this.gold += gold;
		for (int i = 0; i < items.size(); i++) {
			this.add(items.get(i));
		}
	}

	public void remove(Item item) {
		Item itemInInv = this.getItem(item);
		itemInInv.decrementCount();
		if (itemInInv.getCount() == 0) {
			items.remove(itemInInv);
		}

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

	public ArrayList<Note> getNotes() {
		ArrayList<Note> note = new ArrayList<Note>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Note) {
				note.add((Note) items.get(i));
			}
		}
		return note;
	}

	public ArrayList<Other> getOther() {
		ArrayList<Other> other = new ArrayList<Other>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Other) {
				other.add((Other) items.get(i));
			}
		}
		return other;
	}

	public HashMap<String, ArrayList<Item>> getItemsByCategory() {
		HashMap<String, ArrayList<Item>> itemCategories = new HashMap<String, ArrayList<Item>>();

		ArrayList<Item> food = new ArrayList<Item>();
		ArrayList<Item> notes = new ArrayList<Item>();
		ArrayList<Item> others = new ArrayList<Item>();
		ArrayList<Item> outfits = new ArrayList<Item>();
		ArrayList<Item> weapons = new ArrayList<Item>();
		ArrayList<Item> questItems = new ArrayList<Item>();

		for (Item item : this.items) {
			if (item instanceof Food)
				food.add(item);
			if (item instanceof Note)
				notes.add(item);
			if (item instanceof Other)
				others.add(item);
			if (item instanceof Outfit)
				outfits.add(item);
			if (item instanceof Weapon)
				weapons.add(item);
			if (item instanceof QuestItem)
				questItems.add(item);
		}

		itemCategories.put("Nahrung", food);
		itemCategories.put("Notizen", notes);
		itemCategories.put("Sonstiges", others);
		itemCategories.put("Kleidung/Rüstung", outfits);
		itemCategories.put("Waffen", weapons);
		itemCategories.put("Quest-Items", questItems);

		return itemCategories;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public void addGold(int gold) {
		this.gold += gold;
	}

	public void removeGold(int gold) {
		this.gold -= gold;
	}

	public int getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	public String stringifyItems() {
		StringBuilder builder = new StringBuilder();
		for (Item item : this.items) {
			builder.append(item.getCount() + "x " + item.getName()).append(", ");
		}
		return builder.substring(0, builder.toString().lastIndexOf(',') > -1 ? builder.toString().lastIndexOf(',') : 0)
				.toString();
	}

	public boolean containsWeapon() {
		return this.getWeapons().size() > 0;
	}

	public boolean containsOutfit() {
		return this.getOutfits().size() > 0;
	}

}
