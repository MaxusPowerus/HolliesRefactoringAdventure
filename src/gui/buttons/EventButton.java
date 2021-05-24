package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import basic.GameManager;
import entities.Player;
import utilities.Challenge;
import utilities.EventSolution;

public class EventButton extends JButton implements ActionListener {

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

		this.setText("Möglichkeit " + solutionIndex);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.gameManager.getGuiManager().getActionButtonPanel().removeAll();

		if (this.eventSolution.tryIt(this.player)) {
			this.gameManager.getGuiManager().addFieldInfo(this.eventSolution.getSuccess());
			this.eventSolution.rewardPlayer(this.player);
		} else {
			this.gameManager.getGuiManager().addFieldInfo(this.eventSolution.getFailure());
			this.eventSolution.punishPlayer(this.player);
		}
		this.challenge.setChallengeCompleted(true);
	}

}
