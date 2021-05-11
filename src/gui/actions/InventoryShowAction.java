package gui.actions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import basic.Config;
import basic.GameManager;
import gui.GUIHelper;
import gui.MainPanel;
import items.Food;
import items.Item;
import items.Outfit;
import items.Weapon;

public class InventoryShowAction implements ActionListener {

	MainPanel mainPanel;

	public InventoryShowAction(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GUIHelper.resetPanel(this.mainPanel);

		this.mainPanel.printHeadline("Dein Beutel");
		this.mainPanel.addBackButton();

		JPanel itemPanel = new JPanel();

//		itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
		itemPanel.setPreferredSize(new Dimension(200, 200));

		// load items
		ArrayList<Item> items = GameManager.getInstance().getPlayer().getInventory().getAllItems();
		if (items.isEmpty()) {
			JLabel empty = new JLabel("Dein Rucksack ist leer");
			itemPanel.add(empty);
		} else {
			for (Item item : items) {
				itemPanel.add(this.getItemComponent(item));
			}
		}

		this.mainPanel.add(itemPanel);
	}

	private JPanel getItemComponent(Item item) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(1, 30, 20));
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Config.BOX_COLOR)));

		JLabel name = new JLabel(item.getName());

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

		panel.add(name);
		panel.add(button);

		return panel;
	}

}
