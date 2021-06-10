package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import basic.GameManager;
import gui.GraphicalButton;
import gui.actions.InventoryShowAction;
import utilities.Challenge;
import utilities.Inventory;

public class LootButton extends GraphicalButton implements ActionListener {

	private Challenge challenge;
	private GameManager gameManager;
	private Inventory inventory;

	public LootButton(Challenge challenge, GameManager gameManager, Inventory inventory) {
		this.challenge = challenge;
		this.gameManager = gameManager;
		this.inventory = inventory;

		if (this.challenge.getContainer() != null) { // when container on field
			this.setText(this.challenge.getContainer().getName() + " durchsuchen");
		} else { // loot killed enemy
			this.setText(this.challenge.getNpc().getName() + " ausnehmen");
		}
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);

		String itemsString = this.inventory.stringifyItems();

		this.gameManager.getPlayer().getInventory().add(this.inventory);

		int itemCount = this.inventory.getAllItems().size();
		if (itemCount > 0) {
			gameManager.getGuiManager().getMain()
					.addFieldInfo("Du hast folgende Items eingesammelt: <b>" + itemsString + "</b>");
		}

		int gold = this.inventory.getGold();
		if (gold > 0) {
			gameManager.getGuiManager().getMain().addFieldInfo("Du hast <b>" + gold + " Gold</b> gefunden");
		}

		if (itemCount == 0 && gold == 0) {
			gameManager.getGuiManager().getMain()
					.addFieldInfo(this.challenge.getContainer().toString() + " ist leer, so ein Pech");
		}

		// update inventory when opened
		if (this.gameManager.getGuiManager().getMain().getLeftPanelHeadline().getText().contains("Inventar")) {
			new InventoryShowAction(this.gameManager, this.gameManager.getPlayer().getInventory()).initialize();
		}

		if (this.challenge.getContainer() != null)
			this.challenge.getContainer().setFound(true);

		this.challenge.setChallengeCompleted(true);
	}
}
