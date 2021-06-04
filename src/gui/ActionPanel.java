package gui;

import basic.GameManager;
import entities.Player;
import map.Direction;

public class ActionPanel {

	public static void update() {
		GameManager gameManager = GameManager.getInstance();
		GUIManager guiManager = gameManager.getGuiManager();
		Player player = gameManager.getPlayer();

		guiManager.getMain().getGoNorthButton().setEnabled(player.canGo(Direction.NORTH));
		guiManager.getMain().getGoEastButton().setEnabled(player.canGo(Direction.EAST));
		guiManager.getMain().getGoSouthButton().setEnabled(player.canGo(Direction.SOUTH));
		guiManager.getMain().getGoWestButton().setEnabled(player.canGo(Direction.WEST));
	}

}
