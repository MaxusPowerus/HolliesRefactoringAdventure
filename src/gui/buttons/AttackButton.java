package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import basic.GameManager;
import entities.Enemy;
import entities.Player;
import gui.PlayerInfoPanel;
import utilities.Challenge;

public class AttackButton extends JButton implements ActionListener {

	private Challenge challenge;
	private Player player;
	private GameManager gameManager;

	public AttackButton(Challenge challenge, Player player, GameManager gameManager) {
		this.challenge = challenge;
		this.player = player;
		this.gameManager = gameManager;

		this.setText("Angreifen");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);

		boolean attackSucceed = this.player.fight((Enemy) this.challenge.getNpc());
		if (attackSucceed) {
			this.gameManager.getGuiManager()
					.addFieldInfo("In einem epischen Kampf besiegst du " + this.challenge.getNpc().toString());
		} else {
			this.gameManager.getGuiManager().addFieldInfo(
					"Du gibst alles was du kannst, aber " + this.challenge.getNpc().toString() + " tötet dich");
		}

		PlayerInfoPanel.update();

		this.gameManager.update();
	}
}
