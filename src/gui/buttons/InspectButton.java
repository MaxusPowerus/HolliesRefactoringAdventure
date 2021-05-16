package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import basic.GameManager;
import entities.Player;
import utilities.Challenge;

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

		gameManager.getGuiManager().addFieldInfo("Du hast " + this.challenge.getContainer().getName() + " gefunden");

		LootButton lootButton = new LootButton(challenge, player, this.gameManager);
		this.gameManager.getGuiManager().getActionButtonPanel().add(lootButton);

		this.gameManager.update();
	}
}
