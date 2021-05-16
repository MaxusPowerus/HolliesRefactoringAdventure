package gui;

import basic.GameManager;
import entities.Player;

public class PlayerInfoPanel {

	public static void update() {
		GameManager gameManager = GameManager.getInstance();
		GUIManager guiManager = gameManager.getGuiManager();
		Player player = gameManager.getPlayer();

		guiManager.getHealthBar().setValue((int) player.getHealth());
		guiManager.getHealthLabel().setText("HP (" + player.getHealth() + ")");
	}

}
