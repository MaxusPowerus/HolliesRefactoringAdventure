package utilities;

import java.util.ArrayList;

import basic.GameManager;
import items.Item;

public class Container {

	private String name;
	private Inventory inventory;
	private boolean found = false;

	public Container(String name) {
		this.name = name;
		inventory = new Inventory();

		ArrayList<Item> items = GameManager.getInstance().getResourceManager().getAllItems();
		for (int i = 0; i < items.size(); i++) {
			inventory.add(items.get(i));
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

	public Inventory getInventory() {
		return inventory;
	}

	public String stringifyItems() {
		StringBuilder builder = new StringBuilder();
		for (Item item : this.inventory.getAllItems()) {
			builder.append(item.getName()).append(", ");
		}
		return builder.substring(0, builder.length() - 2).toString();
	}
}
