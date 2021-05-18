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
import gui.GUIHelper;
import gui.Icon;
import items.Food;
import items.Item;
import items.Note;
import items.Other;
import items.Outfit;
import items.QuestItem;
import items.Weapon;

public class InventoryShowAction implements ActionListener {

	private GameManager gameManager;

	public InventoryShowAction(GameManager gameManager) {
		this.gameManager = gameManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.initialize();
	}

	public void initialize() {
		this.gameManager.getGuiManager().getLeftContentPanel().removeAll();
		this.gameManager.getGuiManager().getLeftContentPanel().setLayout(new BorderLayout());

		this.gameManager.getGuiManager().getOpenInvButton().setText("Inventar schließen");
		this.gameManager.getGuiManager().getOpenInvButton().removeActionListener(this);
		this.gameManager.getGuiManager().getOpenInvButton().addActionListener(new MapShowAction(this.gameManager));

		this.gameManager.getGuiManager().getLeftPanelHeadline().setText("Inventar");

		JTabbedPane inventoryTabPane = new JTabbedPane(JTabbedPane.TOP);

		inventoryTabPane.setBorder(null);
		inventoryTabPane.setBackground(Color.WHITE);
		GroupLayout leftContentPanelGroupLayout = new GroupLayout(
				this.gameManager.getGuiManager().getLeftContentPanel());
		leftContentPanelGroupLayout
				.setHorizontalGroup(leftContentPanelGroupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(inventoryTabPane, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE));
		leftContentPanelGroupLayout.setVerticalGroup(leftContentPanelGroupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(inventoryTabPane, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE));

		HashMap<String, ArrayList<Item>> itemCategories = GameManager.getInstance().getPlayer().getInventory()
				.getItemsByCategory();

		if (itemCategories.isEmpty()) {
			JPanel itemPanel = new JPanel();
			itemPanel.setBorder(null);
			itemPanel.setBackground(Color.WHITE);
			itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));

			JLabel empty = new JLabel("Dein Rucksack ist leer");
			itemPanel.add(empty);

			this.gameManager.getGuiManager().getLeftContentPanel().add(itemPanel);
		} else {

			int categoryIndex = 0;
			for (String category : itemCategories.keySet()) {

				JPanel itemPanel = new JPanel();
				itemPanel.setBorder(null);
				itemPanel.setBackground(Color.WHITE);
				itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));

				JScrollPane scrollPane = new JScrollPane(itemPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

				for (Item item : itemCategories.get(category)) {
					itemPanel.add(getItemComponent(item));
				}

				ImageIcon icon = null;
				if (category == "Nahrung")
					icon = GUIHelper.getIcon(Icon.BREAD, 25, 25);
				if (category == "Waffen")
					icon = GUIHelper.getIcon(Icon.SWORD, 25, 25);

				inventoryTabPane.addTab(category + " (" + itemCategories.get(category).size() + ")", icon, scrollPane,
						null);
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
			inventoryTabPane.addTab("Gold: " + this.gameManager.getPlayer().getInventory().getGold(), null);
			inventoryTabPane.setBackgroundAt(inventoryTabPane.getTabCount() - 1, Color.decode("#FFD700"));
			inventoryTabPane.setEnabledAt(inventoryTabPane.getTabCount() - 1, false);

			this.gameManager.getGuiManager().getLeftContentPanel().add(inventoryTabPane);
		}

		this.gameManager.update();
	}

	private JPanel getItemComponent(Item item) {

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 50));
		panel.setBackground(Color.WHITE);
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		this.gameManager.getGuiManager().getLeftContentPanel().add(panel);

		JLabel name = new JLabel(item.getName() + " (" + item.getCount() + " Stück)");
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));

		System.out.println(item.getName() + ": " + item.getCount());

		// TODO
		Icon itemIcon = Icon.getByName(item.getUniqueName());
		if (itemIcon != null) {
			GUIHelper.setIcon(name, itemIcon, 30, 30);
		}

		JButton button = new JButton();
		button.setBorder(null);

		button.setBackground(Color.decode("#71F899"));

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
		button.addMouseListener(new InventoryItemHover(panel, this.gameManager, item));

		// hide button because there is no action
		if (item instanceof Note || item instanceof QuestItem) {
			button.setVisible(false);
		}

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

		panel.addMouseListener(new InventoryItemHover(panel, this.gameManager, item));

		return panel;
	}

}
