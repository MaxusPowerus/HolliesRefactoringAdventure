package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import basic.GameManager;
import entities.Player;
import gui.PlayerInfoPanel;
import items.Food;
import items.Item;
import items.Outfit;
import items.Weapon;

public class UseItemAction implements ActionListener {

	private GameManager gameManager;
	private Item item;

	public UseItemAction(GameManager gameManager, Item item) {
		this.gameManager = gameManager;
		this.item = item;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Player player = this.gameManager.getPlayer();

		if (this.item instanceof Food) {
			player.setHealth(player.getHealth() + ((Food) item).getEnergy());
			player.getInventory().remove(item);

			// update inventory when opened
			if (this.gameManager.getGuiManager().getLeftPanelHeadline().getText().contains("Inventar")) {
				new InventoryShowAction(this.gameManager, this.gameManager.getPlayer().getInventory()).initialize();
			}
		} else if (this.item instanceof Weapon) {
			if (player.isWeaponEquipped() && player.isEquipped(this.item)) {
				player.dequip(this.item);
			} else if (!player.isWeaponEquipped()) {
				player.equip(this.item);
			}
		} else if (this.item instanceof Outfit) {
			if (player.isOutfitEquipped() && player.isEquipped(this.item)) {
				player.dequip(this.item);
			} else if (!player.isOutfitEquipped()) {
				player.equip(this.item);
			}
		}

		PlayerInfoPanel.update();
		new InventoryShowAction(this.gameManager, this.gameManager.getPlayer().getInventory()).initialize();
	}

}
