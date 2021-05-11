package utilities;

import java.util.ArrayList;

import items.Item;

public class Container {

	private String name;
	private Inventory inventory;
	private boolean found = false;

	public Container(String name) {
		this.name = name;
		inventory = new Inventory();

		ArrayList<Item> items = new ArrayList<Item>();
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
}
