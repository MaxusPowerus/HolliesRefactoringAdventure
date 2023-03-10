package entities;

import java.util.Random;

import items.Item;

public class Merchant extends NPC {

	private String type;

	public Merchant(String name, String prefix, String biom, String type, int size) {
		super(name, prefix, biom);
		this.type = type;

		Random Randy = new Random();

	}

	public boolean buy(Player player, Item item) {
		if (player.getInventory().getGold() >= item.getSpecificBuyValue(player)) {

			player.getInventory().add(item, true);
			this.getInventory().remove(item);

			player.getInventory().removeGold(item.getSpecificBuyValue(player), true);
			this.getInventory().addGold(item.getSpecificBuyValue(player));

			return true;
		} else {
			return false;
		}
	}

	public boolean sell(Player player, Item item) {
		if (this.getInventory().getGold() >= item.getSpecificSellValue(player)) {

			this.getInventory().add(item);
			player.getInventory().remove(item, true);

			this.getInventory().removeGold(item.getSpecificSellValue(player));
			player.getInventory().addGold(item.getSpecificSellValue(player), true);

			return true;
		} else {
			return false;
		}
	}

}
