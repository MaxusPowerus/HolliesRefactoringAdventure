package basic;


import java.io.IOException;

import entities.Player;
import gui.GUIManager;
import map.Map;

public class GameManager {

	private static Player player;
	private Map mainMap;
	private static GameManager instance;
	private GUIManager guiManager;
	
	public GameManager() {
		instance = this;
		this.prepareGame();
	}
	
	public void prepareGame() {		
		mainMap = new Map();
		mainMap.generateMainMapStepOne();
		//mainMap.generateMainMapStepTwo();
		player = new Player(Config.PLAYER_NAME, mainMap);

		this.guiManager = new GUIManager();
		
		this.startGame();
	}
	
	public static Player getPlayer() {
		return player;
	}
	
	public void restart() {
		this.guiManager.destroy();
		this.prepareGame();
	}
	
	private void startGame() {
		this.guiManager.updateView(player);
	}
	
	public static GameManager getInstance() {
		return instance;
	}
}
