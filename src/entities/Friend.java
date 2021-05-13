package entities;

import java.util.ArrayList;

import items.Item;

public class Friend extends NPC {

	private ArrayList<Item> items;

	public Friend(String name) {
		super(name);
		this.items = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

}
