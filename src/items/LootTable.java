package items;

import java.util.ArrayList;
import java.util.Random;

public class LootTable {
	private ArrayList<Item> items;
	private String name;
	private int gold;

	public LootTable(String name, ArrayList<Item> items, int gold) {
		this.gold = gold;
		if (gold < 0) {
			Random Randy = new Random();

			this.gold = Randy.nextInt(gold * (-1));
		}
		this.name = name;
		this.items = items;
	}

	public void fill(Item item) {
		items.add(item);
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public String getName() {
		return name;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getGold() {
		return gold;
	}
}
