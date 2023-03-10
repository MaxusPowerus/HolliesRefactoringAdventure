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
	private String prefix;
	private Inventory inventory;
	private boolean found = false;

	public Container(String name, String prefix) {
		this.name = name;
		this.prefix = prefix;
		inventory = new Inventory();
		if (name == "random") {
			String[] containerNames = { "Truhe", "Geldbeutel", "Leiche", "Kühlschrank" };
			String[] containerPrefixes = { "eine", "einen", "die ", "einen" };

			Random Randy = new Random();
			int littleRandy = Randy.nextInt(containerNames.length);
			this.name = containerNames[littleRandy];
			this.prefix = containerPrefixes[littleRandy];

			switch (this.name) {
			case "Truhe":
				for (int i = 0; i < 5; i++) {
					Outfit outfit = GameManager.getInstance().getResourceManager().getOutfits()
							.get(Randy.nextInt((GameManager.getInstance().getResourceManager().getOutfits().size())));
					inventory.add(outfit.clone());
				}
				break;
			case "Geldbeutel":
				inventory.addGold(Randy.nextInt(20));
				break;
			case "Leiche":
				String[] types = { " eines Vagabunden", " eines Kaufmanns", " eines Söldners" };
				String[] lootTabelsNames = { "homeless", "trader", "mercenary" };
				int littleRandy2 = Randy.nextInt(types.length);
				this.name = this.name + types[littleRandy2];
				inventory.add(GameManager.getInstance().getResourceManager()
						.getLootTableByName(lootTabelsNames[littleRandy2]));

				break;
			case "Kühlschrank":
				int spawnChance = Randy.nextInt(101);

				for (int i = 0; i < 5; i++) {
					if (spawnChance > 0) {
						Food food = GameManager.getInstance().getResourceManager().getFood()
								.get(Randy.nextInt((GameManager.getInstance().getResourceManager().getFood().size())));
						inventory.add(food.clone());
						spawnChance = spawnChance - 10;
					} else {
						break;
					}
					break;
				}

				if (Randy.nextInt(100) % 2 == 0) {
					found = true;
				}
			}
		}

	}

	public void fill(double chance, double div) {
		ArrayList<Item> items = GameManager.getInstance().getResourceManager().getAllItems();

		Random Randy = new Random();
		if (Randy.nextInt(101) < chance) {
			chance = chance / div;
			Item item = items.get(Randy.nextInt(items.size()));
			inventory.add(item.clone());
			fill(chance, div);
		}
	}

	public void fillByCategory(double chance, double div, String category) {
		ArrayList<Item> items = GameManager.getInstance().getResourceManager().getAllItems();
		ArrayList<Item> catItems = new ArrayList<Item>();

		switch (category.toLowerCase()) {

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
			Item item = catItems.get(Randy.nextInt(catItems.size() - 1));
			inventory.add(item.clone());
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

	public String getPrefix() {
		return prefix;
	}

	@Override
	public String toString() {
		return this.prefix + " " + this.name;
	}

}
