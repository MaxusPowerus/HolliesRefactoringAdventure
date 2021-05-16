package basic;

import entities.Player;
import gui.ActionPanel;
import gui.GUIManager;
import gui.PlayerInfoPanel;
import gui.WorldInfoPanel;
import map.Map;
import map.MapGenerator;

public class GameManager {

	private static Player player;
	private Map mainMap;
	private static GameManager instance;
	private GUIManager guiManager;
	private ResourceManager resourceManager;

	public GameManager() {
		instance = this;
		this.prepareGame();
	}

	public void prepareGame() {
		resourceManager = new ResourceManager();

		mainMap = new Map();
		MapGenerator mapGenerator = new MapGenerator(mainMap);

		mainMap = mapGenerator.generateMapMK2();
		mainMap.printMapDebug("");

		player = new Player(Config.PLAYER_NAME, mainMap);

		this.guiManager = new GUIManager();
		guiManager.getFrame().setVisible(true);

		this.startGame();
	}

	public Player getPlayer() {
		return player;
	}

	private void startGame() {
		PlayerInfoPanel.update();
		WorldInfoPanel.update();
		ActionPanel.update();

	}

	public GUIManager getGuiManager() {
		return guiManager;
	}

	public static GameManager getInstance() {
		return instance;
	}

	public ResourceManager getResourceManager() {
		return resourceManager;
	}
}
