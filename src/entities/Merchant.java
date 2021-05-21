package entities;

import java.util.Random;

import basic.GameManager;
import items.Item;
import items.Weapon;
import utilities.Inventory;

public class Merchant extends NPC {

	private Inventory inventory;
	private String type;

	public Merchant(String name, String prefix, String biom, String type, int size) {
		super(name, prefix, biom);
		inventory = new Inventory();
		this.type = type;

		Random Randy = new Random();

		switch (type) {
		case "Blacksmith":
			for (int i = 0; i < size * 3; i++) {
				Weapon weapon = GameManager.getInstance().getResourceManager().getWeapons()
						.get(Randy.nextInt((GameManager.getInstance().getResourceManager().getWeapons().size())));
				inventory.add(weapon.clone());
				inventory.addGold(Randy.nextInt(100));
			}
			break;
		}
	}

	public boolean buy(Player player, Item item) {
		if (player.getInventory().getGold() >= item.getSpecificValue(player)) {

			player.getInventory().add(item);
			this.getInventory().remove(item);

			player.getInventory().removeGold(item.getSpecificValue(player));
			this.getInventory().addGold(item.getSpecificValue(player));

			return true;
		} else {
			return false;
		}
	}

	public boolean sell(Player player, Item item) {
		if (this.getInventory().getGold() >= item.getSpecificValue(player)) {

			this.getInventory().add(item);
			player.getInventory().remove(item);

			this.getInventory().removeGold(item.getSpecificValue(player));
			player.getInventory().addGold(item.getSpecificValue(player));

			return true;
		} else {
			return false;
		}
	}

}
