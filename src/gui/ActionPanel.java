package gui;

import basic.GameManager;
import entities.Player;
import map.Direction;

public class ActionPanel {

	public static void update() {
		GameManager gameManager = GameManager.getInstance();
		GUIManager guiManager = gameManager.getGuiManager();
		Player player = gameManager.getPlayer();

		guiManager.getGoNorthButton().setEnabled(player.canGo(Direction.NORTH));
		guiManager.getGoEastButton().setEnabled(player.canGo(Direction.EAST));
		guiManager.getGoSouthButton().setEnabled(player.canGo(Direction.SOUTH));
		guiManager.getGoWestButton().setEnabled(player.canGo(Direction.WEST));
	}

}
