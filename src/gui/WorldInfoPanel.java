package gui;

import basic.GameManager;
import entities.Player;
import utilities.Challenge;

public class WorldInfoPanel {

	public static void update() {
		GameManager gameManager = GameManager.getInstance();
		GUIManager guiManager = gameManager.getGuiManager();
		Player player = gameManager.getPlayer();
		Challenge challenge = player.getCurrentMapField().getChallenge();

		guiManager.getCurrentFieldBiomLabel()
				.setText(">>> " + player.getCurrentMapField().getBiom().getName() + " <<<");

		guiManager.getChallengeState()
				.setText("Challenge: " + (challenge.isChallengeCompleted() ? "completed" : "uncompleted"));
	}
}
