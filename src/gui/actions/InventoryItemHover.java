package gui.actions;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import basic.GameManager;
import items.Food;
import items.Item;
import items.Outfit;
import items.Weapon;

public class InventoryItemHover implements MouseListener {

	private GameManager gameManager;
	private Item item;

	public InventoryItemHover(GameManager gameManager, Item item) {
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

		JLabel name = new JLabel(item.getName());
		name.setFont(new Font("Dialog", Font.BOLD, 16));
		name.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		this.gameManager.getGuiManager().getLeftInfoContentPanel().add(name);

		JLabel value = new JLabel("Wert: " + item.getValue());
		value.setFont(new Font("Dialog", Font.PLAIN, 14));
		this.gameManager.getGuiManager().getLeftInfoContentPanel().add(value);

		if (item instanceof Weapon) {
			JLabel damage = new JLabel("Schaden: " + ((Weapon) item).getDamage());
			damage.setFont(new Font("Dialog", Font.ITALIC, 14));
			this.gameManager.getGuiManager().getLeftInfoContentPanel().add(damage);
		}
		if (item instanceof Food) {
			JLabel energy = new JLabel("Energie: " + ((Food) item).getEnergy());
			energy.setFont(new Font("Dialog", Font.ITALIC, 14));
			this.gameManager.getGuiManager().getLeftInfoContentPanel().add(energy);
		}
		if (item instanceof Outfit) {
			JLabel armor = new JLabel("Rüstungspunkte: " + ((Outfit) item).getArmor());
			armor.setFont(new Font("Dialog", Font.ITALIC, 14));
			this.gameManager.getGuiManager().getLeftInfoContentPanel().add(armor);
		}

		this.gameManager.update();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.gameManager.getGuiManager().getLeftInfoContentPanel().removeAll();

		this.gameManager.update();
	}

}
