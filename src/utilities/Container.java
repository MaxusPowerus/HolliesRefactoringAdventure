package utilities;

import java.util.ArrayList;
import java.util.Random;

import basic.GameManager;
import items.Food;
import items.Item;
import items.Outfit;
import items.Weapon;

public class Container {

	private String name;
	private Inventory inventory;
	private boolean found = false;

	public Container(String name) {
		this.name = name;
		inventory = new Inventory();
	}

	public void fill(int chance, int div) {
		ArrayList<Item> items = GameManager.getInstance().getResourceManager().getAllItems();

		Random Randy = new Random();
		if (Randy.nextInt(101) < chance) {
			chance = chance / div;
			inventory.add(items.get(Randy.nextInt(items.size() - 1)));
			fill(chance, div);
		}
	}

	public void fillByCategory(int chance, int div, String category) {
		ArrayList<Item> items = GameManager.getInstance().getResourceManager().getAllItems();
		ArrayList<Item> catItems = new ArrayList<Item>();

		category.toLowerCase();

		switch (category) {

		case "weapon":
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i) instanceof Weapon) {
					catItems.add(items.get(i));
				}
			}
			break;

		case "outfit":
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i) instanceof Outfit) {
					catItems.add(items.get(i));
				}
			}
			break;

		case "food":
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i) instanceof Food) {
					catItems.add(items.get(i));
				}
			}
			break;

		}

		Random Randy = new Random();
		if (Randy.nextInt(101) < chance) {
			chance = chance / div;
			inventory.add(catItems.get(Randy.nextInt(catItems.size() - 1)));
			fill(chance, div);
		}
	}

	public boolean getFound() {
		return this.found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public String stringifyItems() {
		return this.stringifyItems(false);
	}

	public String stringifyItems(boolean htmlBreak) {
		StringBuilder builder = new StringBuilder();
		for (Item item : this.inventory.getAllItems()) {
			builder.append(item.getName()).append(", ");
			if (htmlBreak)
				builder.append("<br>");
		}
		return builder.substring(0, builder.length() - 2).toString();
	}
}
