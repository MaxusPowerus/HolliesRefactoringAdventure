package gui;

import javax.swing.JLabel;

import basic.GameManager;
import entities.Player;
import utilities.Challenge;

public class WorldInfoPanel {

	public static void update() {
		GameManager gameManager = GameManager.getInstance();
		GUIManager guiManager = gameManager.getGuiManager();
		Player player = gameManager.getPlayer();
		Challenge challenge = player.getCurrentMapField().getChallenge();

		guiManager.getLeftInfoContentPanel().removeAll();

		guiManager.getLeftInfoContentPanel()
				.add(new JLabel(">>> " + player.getCurrentMapField().getBiom().getName() + " <<<"));

		guiManager.getLeftInfoContentPanel()
				.add(new JLabel("Challenge: " + (challenge.isChallengeCompleted() ? "completed" : "uncompleted")));

		GameManager.getInstance().update();
	}
}
