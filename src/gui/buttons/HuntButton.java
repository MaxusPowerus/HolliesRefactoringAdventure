package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import basic.GameManager;
import entities.Player;
import entities.Victim;
import gui.GraphicalButton;
import gui.PlayerInfoPanel;
import utilities.Challenge;

public class HuntButton extends GraphicalButton implements ActionListener {

	private Challenge challenge;
	private Player player;
	private GameManager gameManager;

	public HuntButton(Challenge challenge, Player player, GameManager gameManager) {
		this.challenge = challenge;
		this.player = player;
		this.gameManager = gameManager;

		this.setText("Jagen");
		this.setToolTipText(player.getHuntChance((Victim) this.challenge.getNpc()) + "%");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);

		this.gameManager.getGuiManager().getMain().getActionButtonPanel().removeAll();

		boolean hunted = this.player.hunt((Victim) this.challenge.getNpc());
		if (hunted) {
			this.gameManager.getGuiManager().getMain()
					.addFieldInfo("Du hast <b>" + this.challenge.getNpc().toString(true) + "</b> erlegt!");
			this.challenge.setChallengeCompleted(true);

			LootButton lootButton = new LootButton(this.challenge, this.gameManager,
					this.challenge.getNpc().getInventory());
			this.gameManager.getGuiManager().getMain().getActionButtonPanel().add(lootButton);
		} else {
			this.gameManager.getGuiManager().getMain().addFieldInfo("So ein Mist, es ist dir entkommen!");
		}

		PlayerInfoPanel.update();
		this.gameManager.update();
	}
}
