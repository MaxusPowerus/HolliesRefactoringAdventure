package basic;

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import QuestClasses.Quest;
import entities.Enemy;
import entities.Merchant;
import entities.Player;
import entities.Victim;
import gui.ActionPanel;
import gui.BackgroundImagePanel;
import gui.GUIHelper;
import gui.GUIManager;
import gui.PlayerInfoPanel;
import gui.WorldInfoPanel;
import gui.actions.MapShowAction;
import gui.buttons.AttackButton;
import gui.buttons.BuyButton;
import gui.buttons.FleeButton;
import gui.buttons.InspectButton;
import gui.buttons.LootButton;
import gui.buttons.QuestButton;
import gui.buttons.SellButton;
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
	private QuestManager questManager;
	private JPanel backgroundImage;
	private boolean fullscreen;
	private boolean playerEditor;

	public GameManager(boolean fullscreen, boolean playerEditor) {
		instance = this;
		this.fullscreen = fullscreen;
		this.playerEditor = playerEditor;
		this.prepareGame();
	}

	public void prepareGame() {
		player = new Player(Config.PLAYER_NAME);

		resourceManager = new ResourceManager();
		questManager = new QuestManager(player);

		mainMap = new Map();
		MapGenerator mapGenerator = new MapGenerator(mainMap);

		mainMap = mapGenerator.generateMapMK2();
		player.setMap(mainMap);

		this.guiManager = new GUIManager(this.fullscreen);
	}

	public Player getPlayer() {
		return player;
	}

	public void startGame() {
		guiManager.setLoadingScreen();

		// start game logic in own thread
		new Thread(new Runnable() {
			@Override
			public void run() {
				// generate main view
				gui.views.Main main = new gui.views.Main();
				guiManager.setMain(main);
				guiManager.getFrame().setContentPane(main);
				player.setStartItems();

				PlayerInfoPanel.update();
				WorldInfoPanel.update();
				ActionPanel.update();

				// show map for default
				new MapShowAction().initialize();

				execMainLogic();

			}

		}).start();
	}

	public void execMainLogic() {
		// clear fields
		this.guiManager.getMain().getFieldInfos().removeAll();
		this.guiManager.getMain().getActionButtonPanel().removeAll();

		// switch biome
		this.guiManager.getMain()
				.addFieldInfo("<i>Du bist " + player.getCurrentMapField().getBiom().toString() + ":</i>");

		String path = "";
		if (player.getCurrentMapField().getBiom() == Biom.DESERT) {
			path = "meadow_var1.png";
		} else if (player.getCurrentMapField().getBiom() == Biom.FOREST) {
			path = "forest_var1.png";
		} else if (player.getCurrentMapField().getBiom() == Biom.MOUNTAINS) {
			path = "mountains_var1.png";
		} else if (player.getCurrentMapField().getBiom() == Biom.SWAMP) {
			this.guiManager.getMain().getFieldInfoPanel().setBackground(Color.decode("#6D610D"));
			path = "meadow_var1.png";
		} else if (player.getCurrentMapField().getBiom() == Biom.MEADOW) {
			path = "meadow_var2.png";
		}

		// remove background image
		for (Component c : this.guiManager.getMain().getFieldInfoPanel().getComponents()) {
			if (c instanceof BackgroundImagePanel)
				this.guiManager.getMain().getFieldInfoPanel().remove(c);
		}

		// set background image
		if (path != "") {
			try {
				BufferedImage backgroundImageSource = ImageIO
						.read(new File(HelperFunctions.getResource("images/backgrounds/" + path)));
				this.guiManager.getMain().setBackgroundImagePanel(new BackgroundImagePanel(
						GUIHelper.scaleIcon(new ImageIcon(backgroundImageSource), 650).getImage()));
				this.guiManager.getMain().getFieldInfoPanel().add(this.guiManager.getMain().getBackgroundImagePanel());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// execute challenge
		Challenge challenge = player.getCurrentMapField().getChallenge();
		Quest quest = player.getCurrentMapField().getQuest();
		if (quest == null && challenge != null) {
			if (!challenge.isChallengeCompleted()) {
				switch (challenge.getChallangeType()) {
				case 0:
					Container container = challenge.getContainer();
					if (!container.getFound()) {
						this.guiManager.getMain().addFieldInfo(
								"Du hast <b>" + container.toString() + "</b> gefunden. Halte nach Items ausschau.");

						LootButton lootButton = new LootButton(challenge, this,
								challenge.getContainer().getInventory());
						this.guiManager.getMain().getActionButtonPanel().add(lootButton);
					} else {
						this.guiManager.getMain().addFieldInfo("Es ist ruhig hier...zu ruhig...");
						InspectButton button = new InspectButton(challenge, player, this);
						this.guiManager.getMain().getActionButtonPanel().add(button);
					}

					break;
				case 1:
					Enemy enemy = (Enemy) challenge.getNpc();
					this.guiManager.getMain().addFieldInfo(
							"<b>" + enemy.toString() + "</b> ist erschienen. Was tust du? Wegrennen oder K�mpfen?");

					this.guiManager.getMain().setNavigationEnabled(false);

					AttackButton attackButton = new AttackButton(challenge, player, this);
					this.guiManager.getMain().getActionButtonPanel().add(attackButton);

					FleeButton escapeButton = new FleeButton(challenge, player, this);
					this.guiManager.getMain().getActionButtonPanel().add(escapeButton);

					break;
				case 2:
					Merchant merchant = (Merchant) challenge.getNpc();
					this.guiManager.getMain().addFieldInfo("<b>" + merchant.toString()
							+ "</b> ist erschienen. M�chtest du mit ihm einen Handel eingehen?");

					BuyButton buyButton = new BuyButton(challenge, player, this);
					this.guiManager.getMain().getActionButtonPanel().add(buyButton);

					SellButton sellButton = new SellButton(challenge, player, this);
					this.guiManager.getMain().getActionButtonPanel().add(sellButton);
					break;
				case 3:
					Victim victim = (Victim) challenge.getNpc();

					// TODO

					break;
				default:
					this.guiManager.getMain().addFieldInfo(
							"Wer das liest ist doof. Spa�. Wer das liest, hat einen Bug entdeckt. :c Bitte kontaktieren Sie Ihren Administrator lul");
					break;
				}
			} else {
				this.guiManager.getMain().addFieldInfo("Du siehst nichts au�er deinen Fu�spuren");
			}
		} else if (challenge == null && quest != null) {
			this.getGuiManager().getMain().addFieldInfo(quest.getWorldInfoLine());

			for (int i = 0; i < quest.getPossibilities().size(); i++) {
				QuestButton questButton = new QuestButton(quest, player, this,
						quest.getPossibilitiesButtonlabels().get(i), quest.getPossibilitiesChances().get(i));
				this.guiManager.getMain().getActionButtonPanel().add(questButton);
			}
		} else {
			System.out.println("MAX DU HAST KAKI GEBAUT! aber ich vergebe dir");
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

	public QuestManager getQuestManager() {
		return questManager;
	}

	public void endGame() {
		this.guiManager.showGameOver();
	}
}