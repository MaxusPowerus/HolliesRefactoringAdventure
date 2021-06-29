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
			player.setHealth(player.getHealth() + ((Food) item).getEnergy(), true);
			player.getInventory().remove(item);

			// update inventory when opened
			if (this.gameManager.getGuiManager().getMain().getLeftPanelHeadline().getText().contains("Inventar")) {
				new InventoryShowAction(this.gameManager, this.gameManager.getPlayer().getInventory()).updateView();
			}
		} else if (this.item instanceof Weapon) {
			if (player.isWeaponEquipped() && player.getWeapon().equals(this.item)) {
				player.dequip(player.getWeapon());
			} else if (player.isWeaponEquipped() && !player.getWeapon().equals(this.item)) {
				player.dequip(player.getWeapon());
				player.equip(this.item);
			} else {
				player.equip(this.item);
			}
		} else if (this.item instanceof Outfit) {
			if (player.isOutfitEquipped() && player.getOutfit().equals(this.item)) {
				player.dequip(player.getOutfit());
			} else if (player.isOutfitEquipped() && !player.getOutfit().equals(this.item)) {
				player.dequip(player.getOutfit());
				player.equip(this.item);
			} else if (!player.isOutfitEquipped()) {
				player.equip(this.item);
			}
		}

		PlayerInfoPanel.update();
		new InventoryShowAction(this.gameManager, this.gameManager.getPlayer().getInventory()).updateView();
	}

}
