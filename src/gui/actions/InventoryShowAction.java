package gui.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		GroupLayout leftContentPanelGroupLayout = new GroupLayout(
				this.gameManager.getGuiManager().getLeftContentPanel());
		leftContentPanelGroupLayout
				.setHorizontalGroup(leftContentPanelGroupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE));
		leftContentPanelGroupLayout.setVerticalGroup(leftContentPanelGroupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE));

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

				tabbedPane.addTab(category, null, scrollPane, null);
			}
			tabbedPane.setSelectedIndex(this.gameManager.getPlayer().getInventory().getSelectedIndex());
			tabbedPane.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					gameManager.getPlayer().getInventory().setSelectedIndex(tabbedPane.getSelectedIndex());
				}
			});

			this.gameManager.getGuiManager().getLeftContentPanel().add(tabbedPane);
		}

		this.gameManager.update();
	}

	private JPanel getItemComponent(Item item) {

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 50));
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setBackground(Color.LIGHT_GRAY);
		this.gameManager.getGuiManager().getLeftContentPanel().add(panel);

		JLabel name = new JLabel(item.getName() + " (" + item.getCount() + " Stück)");
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));

		// TODO
		Icon itemIcon = Icon.getByName(item.getUniqueName());
		if (itemIcon != null) {
			GUIHelper.setIcon(name, itemIcon, 30, 30);
		}

		JButton button = new JButton();

		if (item instanceof Weapon) {
			button.setText("ausrüsten");
		}
		if (item instanceof Food) {
			button.setText("snacken");
		}
		if (item instanceof Outfit) {
			button.setText("anziehen");
		}
		if (item instanceof Note) {
			button.setText("ansehen");
		}
		if (item instanceof Other) {
			button.setText("nutzen");
		}

		button.addActionListener(new UseItemAction(this.gameManager, item));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE).addGap(10)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE).addContainerGap()));
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
