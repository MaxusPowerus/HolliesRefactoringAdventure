package gui.actions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import basic.GameManager;
import basic.HelperFunctions;
import entities.Merchant;
import gui.BackgroundImagePanel;
import gui.GUIHelper;
import gui.GUIManager;
import gui.Icon;
import items.Item;
import utilities.Inventory;

public class InventoryShowAction implements ActionListener {

	private GameManager gameManager;
	private Inventory inventory;
	private String invName;
	private boolean sell;
	private boolean buy;
	private Merchant merchant;
	private boolean isQuest;

	public InventoryShowAction(GameManager gameManager, Inventory inventory, String invName, Merchant merchant,
			boolean isQuest) {
		this.gameManager = gameManager;
		this.inventory = inventory;
		this.invName = invName;
		this.buy = false;
		this.sell = false;
		this.merchant = merchant;
		this.isQuest = isQuest;
	}

	public InventoryShowAction(GameManager gameManager, Inventory inventory) {
		this(gameManager, inventory, "Inventar", null, false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.initialize();
	}

	public void initSell() {
		this.sell = true;
		this.initialize();
	}

	public void initBuy() {
		this.buy = true;
		this.initialize();
	}

	public void initialize() {
		GUIManager gm = this.gameManager.getGuiManager();

		// reset old and map panel
		gm.getMain().getMapPanel().setVisible(false);
		gm.getMain().getLogPanel().setVisible(false);
		gm.getMain().getInventoryPanel().removeAll();
		gm.getMain().getInventoryPanel().setVisible(true);

		// set map/inv/log button states
		GUIHelper.removeActionListener(gm.getMain().getMapButton());
		gm.getMain().getMapButton().addActionListener(new MapShowAction());

		GUIHelper.removeActionListener(gm.getMain().getLogButton());
		gm.getMain().getLogButton().addActionListener(new LogShowAction());

		gm.getMain().getMapButton().setEnabled(true);
		gm.getMain().getInvButton().setEnabled(false);
		gm.getMain().getLogButton().setEnabled(true);

		// set headline for left container
		gm.getMain().getLeftPanelHeadline().setText(this.invName);

		// prepare nav panel
		JPanel inventoryNavigationPanel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		inventoryNavigationPanel.setBackground(new Color(0, 0, 0, 0));
		inventoryNavigationPanel.setOpaque(false);

		// build layout
		JPanel inventoryContentPanel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		inventoryContentPanel.setBackground(new Color(0, 0, 0, 0));
		inventoryContentPanel.setOpaque(false);
		GroupLayout gl_invPanel = new GroupLayout(gm.getMain().getInventoryPanel());
		gl_invPanel.setHorizontalGroup(gl_invPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_invPanel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_invPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(inventoryContentPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(inventoryNavigationPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 541,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		gl_invPanel.setVerticalGroup(gl_invPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_invPanel
				.createSequentialGroup().addGap(5)
				.addComponent(inventoryNavigationPanel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(inventoryContentPanel, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
				.addContainerGap()));
		inventoryContentPanel.setLayout(new BoxLayout(inventoryContentPanel, BoxLayout.Y_AXIS));
		gm.getMain().getInventoryPanel().setLayout(gl_invPanel);
		inventoryNavigationPanel.setLayout(new BoxLayout(inventoryNavigationPanel, BoxLayout.X_AXIS));

		// get all items by category
		HashMap<String, ArrayList<Item>> itemCategories = this.inventory.getItemsByCategory();

		// loop over all categories (incl. items)
		int categoryIndex = 0;
		for (String category : itemCategories.keySet()) {
			if ((this.buy || this.sell) && category == "Quest-Items")
				continue;

			// set tab background in navigation panel
			BufferedImage navButtonBackgroundSource = null;
			try {
				navButtonBackgroundSource = ImageIO.read(new File(HelperFunctions.getResource("images/GUI/Tab.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			BackgroundImagePanel navigationButtonBackgroundPanel = new BackgroundImagePanel(
					GUIHelper.scaleIcon(new ImageIcon(navButtonBackgroundSource), 70).getImage());
			navigationButtonBackgroundPanel.setOpaque(false);

			// create tab label/icon
			JLabel buttonLabel = new JLabel();

			ImageIcon icon = null;
			if (category == "Nahrung") {
				icon = GUIHelper.getIcon(Icon.INV_FOOD, 40, 40);
			}
			if (category == "Waffen") {
				icon = GUIHelper.getIcon(Icon.INV_WEAPON, 40, 40);
			}
			if (category == "Sonstiges") {
				icon = GUIHelper.getIcon(Icon.INV_MISC, 40, 40);
			}
			if (category == "Notizen") {
				icon = GUIHelper.getIcon(Icon.INV_NOTES, 40, 40);
			}
			if (category == "Quest-Items") {
				icon = GUIHelper.getIcon(Icon.INV_QUEST_ITEMS, 40, 40);
			}
			if (category == "Kleidung/R??stung") {
				icon = GUIHelper.getIcon(Icon.INV_CLOTHES, 40, 40);
			}

			buttonLabel.setText("(" + itemCategories.get(category).size() + ")");
			buttonLabel.setIcon(icon);
			navigationButtonBackgroundPanel.setLayout(new GridBagLayout());
			navigationButtonBackgroundPanel.setToolTipText(category + " (" + itemCategories.get(category).size() + ")");
			navigationButtonBackgroundPanel.add(buttonLabel, new GridBagConstraints());
			navigationButtonBackgroundPanel.setName(category);
			navigationButtonBackgroundPanel.addMouseListener(
					new InventoryNavigationActions(this.gameManager, this.inventory, inventoryContentPanel,
							inventoryNavigationPanel, navigationButtonBackgroundPanel, buy, sell, merchant, invName));

			inventoryNavigationPanel.add(navigationButtonBackgroundPanel);

			categoryIndex++;
		}

		// add gold tab
		if (sell) {
			JLabel goldLabel = new JLabel(
					"<html><b>Gold:</b> " + this.gameManager.getPlayer().getInventory().getGold() + "</html>");
			goldLabel.setForeground(Color.decode("#FFD700"));
			goldLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
			inventoryNavigationPanel.add(goldLabel);

			JLabel merchantGoldLabel = new JLabel("<html><b>Gold vom H??ndler:</b> "
					+ this.gameManager.getPlayer().getInventory().getGold() + "</html>");
			merchantGoldLabel.setForeground(Color.decode("#FFD700"));
			merchantGoldLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
			inventoryNavigationPanel.add(merchantGoldLabel);
		} else {

			JLabel goldLabel = new JLabel(
					"<html><b>Gold:</b> " + this.gameManager.getPlayer().getInventory().getGold() + "</html>");
			goldLabel.setForeground(Color.decode("#FFD700"));
			goldLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
			inventoryNavigationPanel.add(goldLabel);
		}

		InventoryNavigationActions.openCategory(this.inventory.getSelectedCategory());

		this.gameManager.update();
	}

	public void updateView() {
		System.out.println("update");
		this.initialize();
		// TODO
	}

	public boolean isQuest() {
		return isQuest;
	}

}
