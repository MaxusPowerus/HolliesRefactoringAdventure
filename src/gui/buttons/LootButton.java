package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import basic.GameManager;
import entities.Player;
import gui.WorldInfoPanel;
import gui.actions.InventoryShowAction;
import utilities.Challenge;

public class LootButton extends JButton implements ActionListener {

	private Challenge challenge;
	private Player player;
	private GameManager gameManager;

	public LootButton(Challenge challenge, Player player, GameManager fieldInfos) {
		this.challenge = challenge;
		this.player = player;
		this.gameManager = fieldInfos;

		this.setText(this.challenge.getContainer().getName() + " looten");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);

		this.player.getInventory().add(this.challenge.getContainer());
		gameManager.getGuiManager()
				.addFieldInfo("Du hast folgende Items eingesammelt: " + this.challenge.getContainer().stringifyItems());

		this.challenge.setChallengeCompleted(true);
		WorldInfoPanel.update();

		// update inventory when opened
		if (this.gameManager.getGuiManager().getLeftPanelHeadline().getText() == "Inventar") {
			new InventoryShowAction(this.gameManager).initialize();
		}
	}
}
