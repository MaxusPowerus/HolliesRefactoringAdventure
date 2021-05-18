package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import basic.GameManager;
import entities.Enemy;
import entities.Player;
import utilities.Challenge;

public class FleeButton extends JButton implements ActionListener {

	private Challenge challenge;
	private Player player;
	private GameManager gameManager;

	public FleeButton(Challenge challenge, Player player, GameManager gameManager) {
		this.challenge = challenge;
		this.player = player;
		this.gameManager = gameManager;

		this.setText("Wegrennen");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);

		boolean fleeSucced = this.player.flee((Enemy) this.challenge.getNpc());
		if (fleeSucced) {
			this.gameManager.getGuiManager().addFieldInfo(
					"Du rennt vor <b>" + this.challenge.getNpc().toString() + "</b> davon. Es gelingt dir!");
			this.challenge.setChallengeCompleted(true);

			this.gameManager.getGuiManager().getActionButtonPanel().removeAll();
		} else {
			this.gameManager.getGuiManager().addFieldInfo("GAME OVER");
		}

		this.gameManager.getGuiManager().setNavigationEnabled(true);

		this.gameManager.update();
	}
}
