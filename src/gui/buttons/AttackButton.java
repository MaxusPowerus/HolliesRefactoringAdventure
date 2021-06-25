package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import basic.GameManager;
import entities.Enemy;
import entities.Player;
import gui.GraphicalButton;
import gui.PlayerInfoPanel;
import utilities.Challenge;

public class AttackButton extends GraphicalButton implements ActionListener {

	private Challenge challenge;
	private Player player;
	private GameManager gameManager;

	public AttackButton(Challenge challenge, Player player, GameManager gameManager) {
		this.challenge = challenge;
		this.player = player;
		this.gameManager = gameManager;

		this.setText("Angreifen");
		this.setToolTipText(player.getFightChance((Enemy) this.challenge.getNpc()) + "%");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);

		this.gameManager.getGuiManager().getMain().getActionButtonPanel().removeAll();

		double healthBeforeFight = this.player.getHealth();

		boolean attackSucceed = this.player.fight((Enemy) this.challenge.getNpc());
		if (attackSucceed) {
			this.gameManager.getGuiManager().getMain().addFieldInfo("In einem epischen Kampf besiegst du <b>"
					+ this.challenge.getNpc().getPrefix() + " " + this.challenge.getNpc().getName() + "</b>");

			LootButton lootButton = new LootButton(this.challenge, this.gameManager,
					this.challenge.getNpc().getInventory());
			this.gameManager.getGuiManager().getMain().getActionButtonPanel().add(lootButton);

			double healthAfterFight = this.player.getHealth();

		} else {
			this.gameManager.endGame();
		}

		this.gameManager.getGuiManager().getMain().setNavigationEnabled(true);

		this.challenge.setChallengeCompleted(true);

		PlayerInfoPanel.update();
		this.gameManager.update();
	}
}
