package gui;

import basic.GameManager;
import entities.Player;

public class WorldInfoPanel {

	public static void update() {
		GameManager gameManager = GameManager.getInstance();
		GUIManager guiManager = gameManager.getGuiManager();
		Player player = gameManager.getPlayer();

		guiManager.getCurrentFieldBiomLabel()
				.setText(">>> " + player.getCurrentMapField().getBiom().getName() + " <<<");
	}
}
