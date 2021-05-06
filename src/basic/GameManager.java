package basic;

import entities.Player;
import gui.GUIManager;
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
		mainMap = new Map();
		MapGenerator mapGenerator = new MapGenerator(mainMap);

		mainMap = mapGenerator.generateMainMapBasic();

		player = new Player(Config.PLAYER_NAME, mainMap);

		resourceManager = new ResourceManager();

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
