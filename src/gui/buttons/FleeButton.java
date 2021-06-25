package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import basic.GameManager;
import entities.Enemy;
import entities.Player;
import gui.GraphicalButton;
import utilities.Challenge;

public class FleeButton extends GraphicalButton implements ActionListener {

	private Challenge challenge;
	private Player player;
	private GameManager gameManager;

	public FleeButton(Challenge challenge, Player player, GameManager gameManager) {
		this.challenge = challenge;
		this.player = player;
		this.gameManager = gameManager;

		this.setText("Wegrennen");
		this.setToolTipText(player.getFleeChance((Enemy) this.challenge.getNpc()) + "%");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);

		boolean fleeSucced = this.player.flee((Enemy) this.challenge.getNpc());
		if (fleeSucced) {
			this.gameManager.getGuiManager().getMain().addFieldInfo("Du rennst davon. Es gelingt dir!");

			this.gameManager.getGuiManager().getMain().getActionButtonPanel().removeAll();
		} else {
			this.gameManager.endGame();
		}

		this.gameManager.getGuiManager().getMain().setNavigationEnabled(true);

		this.gameManager.update();
	}
}
