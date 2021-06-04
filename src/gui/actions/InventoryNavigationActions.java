package gui.actions;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import basic.GameManager;
import basic.HelperFunctions;
import entities.Merchant;
import gui.BackgroundImagePanel;
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

public class InventoryNavigationActions implements MouseListener {

	private static GameManager gameManager;
	private static Inventory inv;
	private static JPanel inventoryContentPanel;
	private static JPanel inventoryNavigationPanel;
	private BackgroundImagePanel navigationButtonBackgroundPanel;
	private static boolean buy;
	private static boolean sell;
	private static Merchant merchant;
	private static String invName;

	public InventoryNavigationActions(GameManager gameManager, Inventory inv, JPanel inventoryContentPanel,
			JPanel inventoryNavigationPanel, BackgroundImagePanel navigationButtonBackgroundPanel, boolean buy,
			boolean sell, Merchant merchant, String invName) {
		InventoryNavigationActions.gameManager = gameManager;
		InventoryNavigationActions.inv = inv;
		InventoryNavigationActions.inventoryContentPanel = inventoryContentPanel;
		InventoryNavigationActions.inventoryNavigationPanel = inventoryNavigationPanel;
		this.navigationButtonBackgroundPanel = navigationButtonBackgroundPanel;
		InventoryNavigationActions.buy = buy;
		InventoryNavigationActions.sell = sell;
		InventoryNavigationActions.merchant = merchant;
		InventoryNavigationActions.invName = invName;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		updateNavIcon(true);
		navigationButtonBackgroundPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (!inv.getSelectedCategory().equalsIgnoreCase(e.getComponent().getName())) {
			updateNavIcon(false);
		}
		navigationButtonBackgroundPanel.setCursor(Cursor.getDefaultCursor());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		openCategory(e.getComponent().getName());
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	private static void updateNavIcon(BackgroundImagePanel navPanel, boolean selected) {
		BufferedImage navButtonBackgroundSource = null;
		try {
			if (selected) {
				navButtonBackgroundSource = ImageIO
						.read(new File(HelperFunctions.getResource("images/GUI/TabSelected.png")));
			} else {
				navButtonBackgroundSource = ImageIO.read(new File(HelperFunctions.getResource("images/GUI/Tab.png")));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		navPanel.setImg(GUIHelper.scaleIcon(new ImageIcon(navButtonBackgroundSource), 70).getImage());
		navPanel.repaint();
		navPanel.setCursor(Cursor.getDefaultCursor());

		gameManager.update();
	}

	private void updateNavIcon(boolean selected) {
		updateNavIcon(navigationButtonBackgroundPanel, selected);
	}

	public static void openCategory(String category) {
		if (category == "")
			category = "Kleidung/Rüstung"; // when not selected
		inventoryContentPanel.removeAll();

		// update navigation button icon
		for (Component c : inventoryNavigationPanel.getComponents()) {
			if (c instanceof BackgroundImagePanel) {
				updateNavIcon((BackgroundImagePanel) c, category.equalsIgnoreCase(c.getName()));
			}
		}

		inv.setSelectedCategory(category);

		ArrayList<Item> items = inv.getItemsByCategory().get(category);

		if (items.size() == 0) {
			inventoryContentPanel.add(new JLabel("<html><b>Was suchst du? Hier gibt es nichts zu sehen</b></html>"));
		} else {
			for (Item item : items) {
				inventoryContentPanel.add(getItemComponent(item, category));
			}
		}

		gameManager.update();
	}

	private static JPanel getItemComponent(Item item, String category) {

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(32767, 50));
		panel.setBackground(new Color(0, 0, 0, 0.4f));
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0, 0, 0, 0f)));
		gameManager.getGuiManager().getInventoryPanel().add(panel);

		JLabel name = new JLabel(item.getName() + " (" + item.getCount() + " Stück)");
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));

		// TODO
		Icon itemIcon = Icon.getByName(item.getUniqueName());
		if (itemIcon != null) {
			GUIHelper.setIcon(name, itemIcon, 30, 30);
		}

		JButton button = getButton(item, panel, category);

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

		panel.addMouseListener(new InventoryItemHover(panel, gameManager, item, buy));

		return panel;
	}

	private static JButton getButton(Item item, JPanel panel, String category) {
		JButton button = new JButton();
		button.setBorder(null);

		button.setBackground(Color.decode("#71F899"));

		if (buy) { // BUY ACTION

			// has not enough money
			if (item.getSpecificBuyValue(gameManager.getPlayer()) > gameManager.getPlayer().getInventory().getGold()) {
				button.setText("<html>für <b>" + item.getSpecificBuyValue(gameManager.getPlayer())
						+ "</b> Gold kaufen</html>");
				button.addMouseListener(new MouseAdapter() {
					public void mouseEntered(java.awt.event.MouseEvent evt) {
						button.setText("nicht genügend Gold");
					}

					public void mouseExited(java.awt.event.MouseEvent evt) {
						button.setText("<html>für <b>" + item.getSpecificBuyValue(gameManager.getPlayer())
								+ "</b> Gold kaufen</html>");
					}
				});
				button.setBackground(Color.decode("#B8B8B8"));
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
							new InventoryShowAction(gameManager, inv, invName, merchant).initBuy();
						} else {
							gameManager.getGuiManager().addFieldInfo("Du hast nicht genügend Gold");
						}
					}
				});
			}

		} else if (sell) { // SELL ACTION

			// has not enough money
			if (item.getSpecificSellValue(gameManager.getPlayer()) > merchant.getInventory().getGold()) {
				button.setText("nicht genügend Gold");
				button.setBackground(Color.decode("#B8B8B8"));
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
							new InventoryShowAction(gameManager, inv, invName, merchant).initSell();
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
				if (gameManager.getPlayer().isEquipped(item)) {
					button.setText("weglegen");
					button.setBackground(Color.decode("#ed394a"));
					button.setForeground(Color.WHITE);
				} else {
					button.setText("ausrüsten");
				}
			}
			if (item instanceof Food) {
				button.setText("snacken");
			}
			if (item instanceof Outfit) {
				if (gameManager.getPlayer().isEquipped(item)) {
					button.setText("ausziehen");
					button.setBackground(Color.decode("#ed394a"));
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

			button.addActionListener(new UseItemAction(gameManager, item));

			// hide button because there is no action
			if (item instanceof Note || item instanceof QuestItem) {
				button.setVisible(false);
			}
		}

		button.addMouseListener(new InventoryItemHover(panel, gameManager, item, buy));

		return button;
	}
}
