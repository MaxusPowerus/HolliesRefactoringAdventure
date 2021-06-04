package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import basic.GameManager;
import entities.Player;
import utilities.Challenge;
import utilities.Container;

public class InspectButton extends JButton implements ActionListener {

	private Challenge challenge;
	private Player player;
	private GameManager gameManager;

	public InspectButton(Challenge challenge, Player player, GameManager gameManager) {
		this.challenge = challenge;
		this.player = player;
		this.gameManager = gameManager;

		this.setText("Untersuchen");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);

		gameManager.getGuiManager().getMain()
				.addFieldInfo("Du hast <b>" + this.challenge.getContainer().getName() + "</b> gefunden");

		// set container found when available
		Container container = this.challenge.getContainer();

		LootButton lootButton = new LootButton(challenge, this.gameManager,
				this.challenge.getContainer().getInventory());
		this.gameManager.getGuiManager().getMain().getActionButtonPanel().add(lootButton);

		this.gameManager.update();
	}
}
