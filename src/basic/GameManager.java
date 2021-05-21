package basic;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import entities.Enemy;
import entities.Player;
import gui.ActionPanel;
import gui.GUIHelper;
import gui.GUIManager;
import gui.PlayerInfoPanel;
import gui.WorldInfoPanel;
import gui.actions.InventoryShowAction;
import gui.actions.MapShowAction;
import gui.buttons.AttackButton;
import gui.buttons.FleeButton;
import gui.buttons.InspectButton;
import gui.buttons.LootButton;
import map.Biom;
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

		// show map for default
		new MapShowAction(this).initialize();

		// add inv handler
		this.guiManager.getOpenInvButton().addActionListener(new InventoryShowAction(this));

		this.execMainLogic();
	}

	public void execMainLogic() {
		// clear fields
		this.guiManager.getFieldInfos().removeAll();
		this.guiManager.getActionButtonPanel().removeAll();

		// switch biome
		this.guiManager.addFieldInfo("Du bist " + player.getCurrentMapField().getBiom().toString() + ":");

		String path = "";
		if (player.getCurrentMapField().getBiom() == Biom.DESERT) {
			this.guiManager.getFieldInfoPanel().setBackground(Color.decode("#c28370"));
//			path = "resources\\images\\backgrounds\\forest.png";
		} else if (player.getCurrentMapField().getBiom() == Biom.FOREST) {
			this.guiManager.getFieldInfoPanel().setBackground(Color.decode("#196130"));
			path = "forest_var1.png";
		} else if (player.getCurrentMapField().getBiom() == Biom.MOUNTAINS) {
			this.guiManager.getFieldInfoPanel().setBackground(Color.decode("#71817B"));
//			path = "resources\\images\\backgrounds\\forest.png";
		} else if (player.getCurrentMapField().getBiom() == Biom.SWAMP) {
			this.guiManager.getFieldInfoPanel().setBackground(Color.decode("#6D610D"));
//			path = "resources\\images\\backgrounds\\forest.png";
		} else if (player.getCurrentMapField().getBiom() == Biom.MEADOW) {
			this.guiManager.getFieldInfoPanel().setBackground(Color.decode("#16b91e"));
			path = "meadow_var2.png";
		}

		if (path != "") {
			try {
				BufferedImage image = ImageIO.read(new File("resources\\images\\backgrounds\\" + path));
				this.guiManager.getFieldBackground().setIcon(GUIHelper.scaleIcon(new ImageIcon(image), 650));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			this.guiManager.getFieldBackground().setIcon(null);
		}

		// execute challenge
		Challenge challenge = player.getCurrentMapField().getChallenge();
		if (!challenge.isChallengeCompleted()) {
			switch (challenge.getChallangeType()) {
			case 0:
				Container container = challenge.getContainer();
				if (!container.getFound()) {
					this.guiManager.addFieldInfo("Du hast <b>" + container.toString() + "</b> gefunden, dursuche sie");

					LootButton lootButton = new LootButton(challenge, this, challenge.getContainer().getInventory());
					this.guiManager.getActionButtonPanel().add(lootButton);
				} else {
					this.guiManager.addFieldInfo("Es ist ruhig hier...zu ruhig...");
					InspectButton button = new InspectButton(challenge, player, this);
					this.guiManager.getActionButtonPanel().add(button);
				}

				break;
			case 1:
				Enemy enemy = (Enemy) challenge.getNpc();
				this.guiManager.addFieldInfo(
						"<b>" + enemy.toString() + "</b> ist erschienen. Was tust du? Wegrennen oder K‰mpfen?");

				this.guiManager.setNavigationEnabled(false);

				AttackButton attackButton = new AttackButton(challenge, player, this);
				this.guiManager.getActionButtonPanel().add(attackButton);

				FleeButton escapeButton = new FleeButton(challenge, player, this);
				this.guiManager.getActionButtonPanel().add(escapeButton);

				break;
			case 2:
				this.guiManager.addFieldInfo("Du hast einen H‰ndler entdeckt");
				break;
			default:
				this.guiManager.addFieldInfo(
						"Wer das liest ist doof. Spaﬂ. Wer das liest, hat einen Bug entdeckt. :c Bitte kontaktieren Sie Ihren Administrator lul");
				break;
			}
		} else {
			this.guiManager.addFieldInfo("Du siehst nichts auﬂer deinen Fuﬂspuren");
		}

		this.update();
	}

	public void update() {
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
