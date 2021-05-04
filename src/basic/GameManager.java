package basic;


import gui.GUIManager;
import map.Map;
import utilities.Player;

public class GameManager {

	private Player player;
	private Map mainMap;
	
	private GUIManager guiManager;
	
	public GameManager() {
		this.guiManager = new GUIManager();
	}
	
	public void prepareGame() {
		mainMap = new Map();
		player = new Player(Config.PLAYER_NAME, mainMap);
	}
}
