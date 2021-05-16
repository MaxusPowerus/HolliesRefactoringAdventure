package basic;

import entities.Player;
import gui.ActionPanel;
import gui.GUIManager;
import gui.PlayerInfoPanel;
import gui.WorldInfoPanel;
import gui.buttons.LootButton;
import map.Map;
import map.MapGenerator;
import utilities.Challenge;
import utilities.Container;

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

		this.execMainLogic();
	}

	public void execMainLogic() {
		// clear fields
		this.guiManager.getFieldInfos().removeAll();
		this.guiManager.getActionButtonPanel().removeAll();

		// execute challenge
		Challenge challenge = player.getCurrentMapField().getChallenge();
		if (!challenge.isChallengeCompleted()) {
			switch (challenge.getChallangeType()) {
			case 0:
				Container container = challenge.getContainer();
				this.guiManager.addFieldInfo("Du hast " + container.toString() + " gefunden");

				LootButton lootButton = new LootButton(challenge, player, this);
				this.guiManager.getActionButtonPanel().add(lootButton);
				break;
			}
		}

		this.guiManager.getFrame().revalidate();
		this.guiManager.getFrame().repaint();
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
