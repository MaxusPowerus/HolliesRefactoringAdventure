package basic;


import java.io.IOException;

import entities.Player;
import gui.GUIManager;
import map.Biom;
import map.Map;
import map.MapGenerator;

public class GameManager {

	private static Player player;
	private Map mainMap;
	private static GameManager instance;
	private GUIManager guiManager;
	
	public GameManager() {
		instance = this;
		this.prepareGame();
	}
	//------------------------------------------------------------------
	public void prepareGame() {		
		mainMap = new Map();
		MapGenerator mapGenerator = new MapGenerator(mainMap);
		
		mainMap = mapGenerator.generateMainMapBasic();
		//mainMap = mapGenerator.setMapToBiom(Biom.MEADOW);
		//mainMap = mapGenerator.generateForestOnly();
		mainMap.printMapDebug("");
		//-------------------------------------------------------------
		
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
