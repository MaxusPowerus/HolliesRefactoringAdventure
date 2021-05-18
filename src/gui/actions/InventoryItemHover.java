package gui.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

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

public class InventoryItemHover implements MouseListener {

	private JPanel itemPanel;
	private GameManager gameManager;
	private Item item;

	public InventoryItemHover(JPanel itemPanel, GameManager gameManager, Item item) {
		this.itemPanel = itemPanel;
		this.gameManager = gameManager;
		this.item = item;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.gameManager.getGuiManager().getLeftInfoContentPanel().removeAll();

		this.gameManager.getGuiManager().getLeftInfoContentPanel()
				.setBackground(UIManager.getColor("Desktop.background"));
		GroupLayout gl_leftInfoPanel = new GroupLayout(this.gameManager.getGuiManager().getLeftInfoPanel());
		gl_leftInfoPanel.setHorizontalGroup(gl_leftInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftInfoPanel.createSequentialGroup().addContainerGap()
						.addComponent(this.gameManager.getGuiManager().getLeftInfoContentPanel(),
								GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
						.addContainerGap()));
		gl_leftInfoPanel.setVerticalGroup(gl_leftInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftInfoPanel.createSequentialGroup().addContainerGap()
						.addComponent(this.gameManager.getGuiManager().getLeftInfoContentPanel(),
								GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
						.addContainerGap()));

		JPanel itemInfoPanel = new JPanel();
		itemInfoPanel.setBackground(UIManager.getColor("Desktop.background"));

		JPanel itemIconPanel = new JPanel();
		itemIconPanel.setBackground(UIManager.getColor("Desktop.background"));
		itemIconPanel.setLayout(new BorderLayout());
		GroupLayout gl_leftInfoContentPanel = new GroupLayout(
				this.gameManager.getGuiManager().getLeftInfoContentPanel());
		gl_leftInfoContentPanel.setHorizontalGroup(gl_leftInfoContentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_leftInfoContentPanel.createSequentialGroup()
						.addComponent(itemInfoPanel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
						.addComponent(itemIconPanel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)));
		gl_leftInfoContentPanel.setVerticalGroup(gl_leftInfoContentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(itemIconPanel, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
				.addComponent(itemInfoPanel, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE));
		itemInfoPanel.setLayout(new BoxLayout(itemInfoPanel, BoxLayout.Y_AXIS));

		JLabel name = new JLabel(item.getName());
		name.setFont(new Font("Dialog", Font.BOLD, 16));
		name.setForeground(Color.decode("#A33E3C"));
		name.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		itemInfoPanel.add(name);

		JLabel value = new JLabel("<html><b>Wert:</b> " + item.getValue() + " Gold</html>");
		value.setFont(new Font("Dialog", Font.PLAIN, 14));
		itemInfoPanel.add(value);

		if (item instanceof Weapon) {
			JLabel damage = new JLabel("<html><b>Schaden:</b> " + ((Weapon) item).getDamage() + "</html>");
			damage.setFont(new Font("Dialog", Font.ITALIC, 14));
			itemInfoPanel.add(damage);
		}
		if (item instanceof Food) {
			JLabel energy = new JLabel("<html><b>Energie:</b> " + ((Food) item).getEnergy() + "</html>");
			energy.setFont(new Font("Dialog", Font.ITALIC, 14));
			itemInfoPanel.add(energy);
		}
		if (item instanceof Outfit) {
			JLabel armor = new JLabel("<html><b>Rüstungspunkte:</b> " + ((Outfit) item).getArmor() + "</html>");
			armor.setFont(new Font("Dialog", Font.ITALIC, 14));
			itemInfoPanel.add(armor);
		}
		if (item instanceof Note) {
			JLabel text = new JLabel("<html><b>Nachricht:<br></b> " + ((Note) item).getText() + "</html>");
			text.setFont(new Font("Dialog", Font.ITALIC, 14));
			itemInfoPanel.add(text);
		}
		if (item instanceof Other) {
			JLabel info = new JLabel("<html><b>Information:</b> " + ((Other) item).getInfo() + "</html>");
			info.setFont(new Font("Dialog", Font.ITALIC, 14));
			itemInfoPanel.add(info);
		}
		if (item instanceof QuestItem) {
			JLabel info = new JLabel("<html><b>Information:</b> " + ((QuestItem) item).getInfo() + "</html>");
			info.setFont(new Font("Dialog", Font.ITALIC, 14));
			itemInfoPanel.add(info);
		}

		JLabel icon = new JLabel();
		Icon itemIcon = Icon.getByName(item.getUniqueName());
		if (itemIcon != null) {
			GUIHelper.setIcon(icon, itemIcon, 120, 120);
		}
		itemIconPanel.add(icon, BorderLayout.CENTER);

		this.gameManager.getGuiManager().getLeftInfoContentPanel().setLayout(gl_leftInfoContentPanel);
		this.gameManager.getGuiManager().getLeftInfoPanel().setLayout(gl_leftInfoPanel);

		this.itemPanel.setBackground(Color.LIGHT_GRAY);

		this.gameManager.update();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.gameManager.getGuiManager().getLeftInfoContentPanel().removeAll();

		this.itemPanel.setBackground(Color.WHITE);

		this.gameManager.update();
	}

}
