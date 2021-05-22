package items;

import java.util.ArrayList;
import java.util.Random;

import basic.GameManager;

public class LootTable {
	private ArrayList<Item> items;
	private String name;
	private int gold;

	public LootTable(String name, String[] itemNames, int gold) {
		items = new ArrayList<Item>();
		this.gold = gold;
		if (gold < 0) {
			Random Randy = new Random();

			this.gold = Randy.nextInt(gold * (-1));
		}
		this.name = name;
		for (int i = 0; i < itemNames.length; i++) {
			items.add(GameManager.getInstance().getResourceManager().getItemByUniqueName(itemNames[i]));
		}
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
