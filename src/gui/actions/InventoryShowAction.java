package gui.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import basic.GameManager;
import entities.Merchant;
import gui.GUIHelper;
import gui.Icon;
import gui.PlayerInfoPanel;
import items.Food;
import items.Item;
import items.Note;
import items.Other;
import items.Outfit;
import items.QuestItem;
import items.Weapon;
import utilities.Inventory;

public class InventoryShowAction implements ActionListener {

	private GameManager gameManager;
	private Inventory inventory;
	private String invName;
	private boolean sell;
	private boolean buy;
	private Merchant merchant;

	public InventoryShowAction(GameManager gameManager, Inventory inventory, String invName, Merchant merchant) {
		this.gameManager = gameManager;
		this.inventory = inventory;
		this.invName = invName;
		this.buy = false;
		this.sell = false;
		this.merchant = merchant;
	}

	public InventoryShowAction(GameManager gameManager, Inventory inventory) {
		this(gameManager, inventory, "Inventar", null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.gameManager.getGuiManager().getOpenInvButton().setEnabled(false);
		this.gameManager.getGuiManager().getOpenInvButton().setText("Lade...");
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
		this.gameManager.getGuiManager().getMapPanel().setVisible(false);
		this.gameManager.getGuiManager().getInventoryPanel().removeAll();
		this.gameManager.getGuiManager().getInventoryPanel().setVisible(true);
		this.gameManager.getGuiManager().getInventoryPanel().setLayout(new BorderLayout());

		this.gameManager.getGuiManager().getOpenInvButton().setText("Map");
		this.gameManager.getGuiManager().getOpenInvButton().removeActionListener(this);
		this.gameManager.getGuiManager().getOpenInvButton().setEnabled(true);
		this.gameManager.getGuiManager().getOpenInvButton().addActionListener(new MapShowAction(this.gameManager));

		this.gameManager.getGuiManager().getLeftContentPanel().setBackground(Color.WHITE);
		this.gameManager.getGuiManager().getLeftPanelHeadline().setText(this.invName);

		if (buy || sell) {
			this.gameManager.getGuiManager().getOpenInvButton().setVisible(false);
		} else {
			this.gameManager.getGuiManager().getOpenInvButton().setVisible(true);
		}

		JTabbedPane inventoryTabPane = new JTabbedPane(JTabbedPane.TOP);

		inventoryTabPane.setBorder(null);
		inventoryTabPane.setBackground(Color.WHITE);
		GroupLayout leftContentPanelGroupLayout = new GroupLayout(this.gameManager.getGuiManager().getInventoryPanel());
		leftContentPanelGroupLayout
				.setHorizontalGroup(leftContentPanelGroupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(inventoryTabPane, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE));
		leftContentPanelGroupLayout.setVerticalGroup(leftContentPanelGroupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(inventoryTabPane, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE));

		HashMap<String, ArrayList<Item>> itemCategories = this.inventory.getItemsByCategory();

		if (itemCategories.isEmpty()) {
			JPanel itemPanel = new JPanel();
			itemPanel.setBorder(null);
			itemPanel.setBackground(Color.WHITE);
			itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));

			JLabel empty = new JLabel("Dein Rucksack ist leer");
			itemPanel.add(empty);

			this.gameManager.getGuiManager().getInventoryPanel().add(itemPanel);
		} else {

			int categoryIndex = 0;
			for (String category : itemCategories.keySet()) {
				if ((this.buy || this.sell) && category == "Quest-Items")
					continue;

				JPanel itemPanel = new JPanel();
				itemPanel.setBorder(null);
				itemPanel.setBackground(Color.WHITE);
				itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));

				JScrollPane scrollPane = new JScrollPane(itemPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

				for (Item item : itemCategories.get(category)) {
					itemPanel.add(getItemComponent(item));
				}

				String categoryText = category;

				ImageIcon icon = null;
				if (category == "Nahrung") {
					icon = GUIHelper.getIcon(Icon.BREAD, 45, 45);
					categoryText = "";
				}
				if (category == "Waffen") {
					icon = GUIHelper.getIcon(Icon.SWORD, 45, 45);
					categoryText = "";
				}

				if (categoryText.length() > 5)
					categoryText = categoryText.substring(0, 5) + "..";

				inventoryTabPane.addTab(categoryText + " (" + itemCategories.get(category).size() + ")", icon,
						scrollPane, null);
				inventoryTabPane.setToolTipTextAt(categoryIndex++, category);
			}

			inventoryTabPane.setSelectedIndex(this.gameManager.getPlayer().getInventory().getSelectedIndex());
			inventoryTabPane.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					gameManager.getPlayer().getInventory().setSelectedIndex(inventoryTabPane.getSelectedIndex());
				}
			});

			// add gold tab
			if (sell) {
				inventoryTabPane.addTab(
						"<html>Dein Gold: <b>" + this.gameManager.getPlayer().getInventory().getGold() + "</b></html>",
						null);
				inventoryTabPane.setBackgroundAt(inventoryTabPane.getTabCount() - 1, Color.decode("#FFD700"));
				inventoryTabPane.setEnabledAt(inventoryTabPane.getTabCount() - 1, false);

				inventoryTabPane.addTab(
						"<html>Gold vom Händler: <b>" + merchant.getInventory().getGold() + "</b></html>", null);
				inventoryTabPane.setBackgroundAt(inventoryTabPane.getTabCount() - 1, Color.decode("#FFD700"));
				inventoryTabPane.setEnabledAt(inventoryTabPane.getTabCount() - 1, false);
			} else {
				inventoryTabPane.addTab(
						"<html>Gold: <b>" + this.gameManager.getPlayer().getInventory().getGold() + "</b></html>",
						null);
				inventoryTabPane.setBackgroundAt(inventoryTabPane.getTabCount() - 1, Color.decode("#FFD700"));
				inventoryTabPane.setEnabledAt(inventoryTabPane.getTabCount() - 1, false);
			}

			this.gameManager.getGuiManager().getInventoryPanel().add(inventoryTabPane);
		}

		this.gameManager.update();
	}

	private JPanel getItemComponent(Item item) {

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 50));
		panel.setBackground(Color.WHITE);
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		this.gameManager.getGuiManager().getInventoryPanel().add(panel);

		JLabel name = new JLabel(item.getName() + " (" + item.getCount() + " Stück)");
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));

		// System.out.println(item.getName() + ": " + item.getCount());

		// TODO
		Icon itemIcon = Icon.getByName(item.getUniqueName());
		if (itemIcon != null) {
			GUIHelper.setIcon(name, itemIcon, 30, 30);
		}

		JButton button = this.getButton(item, panel);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE).addGap(100)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(name, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
								.addComponent(button, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
						.addContainerGap()));
		panel.setLayout(gl_panel);

		panel.addMouseListener(new InventoryItemHover(panel, this.gameManager, item, buy));

		return panel;
	}

	private JButton getButton(Item item, JPanel panel) {
		JButton button = new JButton();
		button.setBorder(null);

		button.setBackground(Color.decode("#71F899"));

		if (buy) { // BUY ACTION

			// has not enough money
			if (item.getSpecificBuyValue(gameManager.getPlayer()) > gameManager.getPlayer().getInventory().getGold()) {
				button.setText("nicht genügend Gold");
				button.setBackground(Color.decode("#D21C2D"));
				button.setForeground(Color.WHITE);
			} else {
				button.setText("<html>für <b>" + item.getSpecificBuyValue(gameManager.getPlayer())
						+ "</b> Gold kaufen</html>");
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (merchant.buy(gameManager.getPlayer(), item)) {
							gameManager.getGuiManager().addFieldInfo(
									"<html><p>Du hast folgendes gekauft: <b>" + item.toString() + "</b></p></html>");
							new InventoryShowAction(gameManager, inventory, invName, merchant).initBuy();
						} else {
							gameManager.getGuiManager().addFieldInfo("Du hast nicht genügend Gold");
						}
					}
				});
			}

		} else if (sell) { // SELL ACTION

			// has not enough money
			if (item.getSpecificSellValue(gameManager.getPlayer()) > this.merchant.getInventory().getGold()) {
				button.setText("nicht genügend Gold");
				button.setBackground(Color.decode("#D21C2D"));
				button.setForeground(Color.WHITE);
			} else {
				button.setText("<html>für <b>" + item.getSpecificSellValue(gameManager.getPlayer())
						+ "</b> Gold verkaufen</html>");
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Item toSell = item.clone();
						if (merchant.sell(gameManager.getPlayer(), item)) {
							gameManager.getPlayer().dequip(toSell);
							gameManager.getGuiManager().addFieldInfo(
									"<html><p>Du hast folgendes verkauft: <b>" + item.toString() + "</b></p></html>");
							new InventoryShowAction(gameManager, inventory, invName, merchant).initSell();

							PlayerInfoPanel.update();
						} else {
							gameManager.getGuiManager()
									.addFieldInfo("Der Händler hat nicht genügend Geld, um dir das Item abzukaufen");
						}
					}
				});
			}

		} else { // NORMAL INVENTORY SHOW
			if (item instanceof Weapon) {
				if (this.gameManager.getPlayer().isEquipped(item)) {
					button.setText("weglegen");
					button.setBackground(Color.decode("#D21C2D"));
					button.setForeground(Color.WHITE);
				} else {
					button.setText("ausrüsten");
				}
			}
			if (item instanceof Food) {
				button.setText("snacken");
			}
			if (item instanceof Outfit) {
				if (this.gameManager.getPlayer().isEquipped(item)) {
					button.setText("ausziehen");
					button.setBackground(Color.decode("#D21C2D"));
					button.setForeground(Color.WHITE);
				} else {
					button.setText("anziehen");
				}
			}
			if (item instanceof Note) {
				button.setText("ansehen");
			}
			if (item instanceof Other) {
				button.setText("nutzen");
			}

			button.addActionListener(new UseItemAction(this.gameManager, item));

			// hide button because there is no action
			if (item instanceof Note || item instanceof QuestItem) {
				button.setVisible(false);
			}
		}

		button.addMouseListener(new InventoryItemHover(panel, this.gameManager, item, buy));

		return button;
	}

}
