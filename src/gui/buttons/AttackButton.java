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

		this.gameManager.getGuiManager().getActionButtonPanel().removeAll();

		double healthBeforeFight = this.player.getHealth();

		boolean attackSucceed = this.player.fight((Enemy) this.challenge.getNpc());
		if (attackSucceed) {
			this.gameManager.getGuiManager().addFieldInfo("In einem epischen Kampf besiegst du <b>"
					+ this.challenge.getNpc().getPrefix() + " " + this.challenge.getNpc().getName() + "</b>");

			LootButton lootButton = new LootButton(this.challenge, this.gameManager,
					this.challenge.getNpc().getInventory());
			this.gameManager.getGuiManager().getActionButtonPanel().add(lootButton);

			double healthAfterFight = this.player.getHealth();
			this.gameManager.getGuiManager().addFieldInfo("Im Kampf hast du <b>"
					+ Math.abs((int) healthBeforeFight - healthAfterFight) + " Lebenspunkte</b> verloren");

		} else {
			this.gameManager.getGuiManager().addFieldInfo("GAME OVER");
		}

		this.gameManager.getGuiManager().setNavigationEnabled(true);

		this.challenge.setChallengeCompleted(true);

		PlayerInfoPanel.update();
		this.gameManager.update();
	}
}
