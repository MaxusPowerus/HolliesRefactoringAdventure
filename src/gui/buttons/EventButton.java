package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import basic.GameManager;
import entities.Player;
import gui.GUIHelper;
import gui.GraphicalButton;
import gui.PlayerInfoPanel;
import items.Item;
import utilities.Challenge;
import utilities.EventSolution;

public class EventButton extends GraphicalButton implements ActionListener {

	private int solutionIndex;
	private GameManager gameManager;
	private Challenge challenge;
	private Player player;
	private EventSolution eventSolution;

	public EventButton(int solutionIndex, GameManager gameManager, Challenge challenge, Player player,
			EventSolution eventSolution) {
		this.solutionIndex = solutionIndex;
		this.gameManager = gameManager;
		this.challenge = challenge;
		this.player = player;
		this.eventSolution = eventSolution;

		this.setText(eventSolution.getSolutionTry());
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.gameManager.getGuiManager().getMain().getActionButtonPanel().removeAll();

		if (this.eventSolution.tryIt(this.player)) {
			this.gameManager.getGuiManager().getMain().addFieldInfo(this.eventSolution.getSuccess());

			int rewardXP = this.eventSolution.getRewardXp();
			if (rewardXP > 0)
				this.gameManager.getGuiManager().getMain()
						.addFieldInfo("Du erhältst <b>" + rewardXP + " Erfahrungspunkte</b>");

			int rewardGold = this.eventSolution.getRewardGold();
			if (rewardGold > 0)
				this.gameManager.getGuiManager().getMain().addFieldInfo("Du erhältst <b>" + rewardGold + " Gold</b>");

			ArrayList<Item> rewardItems = this.eventSolution.getRewardItems();
			if (rewardItems.size() > 0)
				this.gameManager.getGuiManager().getMain().addFieldInfo(
						"Du erhältst folgende Items: <b>" + GUIHelper.stringifyItemList(rewardItems) + "</b>");

			this.eventSolution.rewardPlayer(this.player);
		} else {
			this.gameManager.getGuiManager().getMain().addFieldInfo(this.eventSolution.getFailure());
			this.eventSolution.punishPlayer(this.player);
		}

		this.challenge.setChallengeCompleted(true);
		PlayerInfoPanel.update();
	}

}
