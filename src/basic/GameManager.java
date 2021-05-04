package basic;


import entities.Player;
import gui.GUIManager;
import map.Map;

public class GameManager {

	private static Player player;
	private Map mainMap;
	
	private GUIManager guiManager;
	
	public GameManager() {
		this.prepareGame();
	}
	
	public void prepareGame() {		
		mainMap = new Map();
		mainMap.generateMainMap();
		player = new Player(Config.PLAYER_NAME, mainMap);

		this.guiManager = new GUIManager();
	}
	
	public static Player getPlayer() {
		return player;
	}
}
