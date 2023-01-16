package gui.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import basic.GameManager;
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
import utilities.Skill;

public class InventoryItemHover implements MouseListener {

	private JPanel itemPanel;
	private GameManager gameManager;
	private Item item;
	private boolean buy;

	public InventoryItemHover(JPanel itemPanel, GameManager gameManager, Item item, boolean buy) {
		this.itemPanel = itemPanel;
		this.gameManager = gameManager;
		this.item = item;
		this.buy = buy;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.mouseExited(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel().removeAll();

		this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel().setBackground(new Color(0, 0, 0, 0));
		GroupLayout gl_leftInfoPanel = new GroupLayout(this.gameManager.getGuiManager().getMain().getLeftInfoPanel());
		gl_leftInfoPanel.setHorizontalGroup(gl_leftInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftInfoPanel.createSequentialGroup().addContainerGap()
						.addComponent(this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel(),
								GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
						.addContainerGap()));
		gl_leftInfoPanel.setVerticalGroup(gl_leftInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftInfoPanel.createSequentialGroup().addContainerGap()
						.addComponent(this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel(),
								GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
						.addContainerGap()));

		JPanel itemInfoPanel = new JPanel();
		itemInfoPanel.setBackground(new Color(0, 0, 0, 0));

		JPanel itemIconPanel = new JPanel();
		itemIconPanel.setBackground(new Color(0, 0, 0, 0));
		itemIconPanel.setLayout(new BorderLayout());
		GroupLayout gl_leftInfoContentPanel = new GroupLayout(
				this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel());
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
		name.setForeground(Color.WHITE);
		name.setFont(new Font(this.gameManager.getGuiManager().getCustomFont().getFamily(), Font.PLAIN, 40));
		itemInfoPanel.add(name);

		if (buy) {
			Item hasItem = gameManager.getPlayer().getInventory().getItem(item);
			int itemCount = 0;
			if (hasItem != null)
				itemCount = hasItem.getCount();
			JLabel hasAmount = new JLabel("<html><i>Du besitzt " + itemCount + "</i></html>");
			hasAmount.setForeground(Color.WHITE);
			hasAmount.setFont(new Font("Dialog", Font.PLAIN, 14));
			itemInfoPanel.add(hasAmount);
		}

		JLabel value = new JLabel("<html><b>Wert:</b> " + item.getValue() + " Gold");
		if (item.getValue() != item.getSpecificBuyValue(GameManager.getInstance().getPlayer())) {
			int diff = item.getValue() - item.getSpecificBuyValue(GameManager.getInstance().getPlayer());
			if (buy) {
				value.setText(
						value.getText() + " (" + (diff > 0 ? "-" : "+") + " " + Math.abs(diff) + " durch Charisma)");
			} else {
				value.setText(
						value.getText() + " (" + (diff < 0 ? "-" : "+") + " " + Math.abs(diff) + " durch Charisma)");
			}
		}
		value.setText(value.getText() + "</html>");
		value.setForeground(Color.decode("#FFD700"));
		value.setFont(new Font("Dialog", Font.PLAIN, 14));
		itemInfoPanel.add(value);

		if (item instanceof Weapon) {
			JLabel damage = new JLabel("<html><b>Schaden:</b> " + ((Weapon) item).getDamage() + "</html>");
			damage.setForeground(Color.WHITE);
			damage.setFont(new Font("Dialog", Font.ITALIC, 14));
			itemInfoPanel.add(damage);
		}
		if (item instanceof Food) {
			JLabel energy = new JLabel("<html><b>Energie:</b> " + ((Food) item).getEnergy() + "</html>");
			energy.setForeground(Color.WHITE);
			energy.setFont(new Font("Dialog", Font.ITALIC, 14));
			itemInfoPanel.add(energy);

			// show in player health bar
			this.gameManager.getGuiManager().getMain().getHealthBar().setValue(
					this.gameManager.getGuiManager().getMain().getHealthBar().getValue() + ((Food) item).getEnergy());
		}
		if (item instanceof Outfit) {
			JLabel armor = new JLabel("<html><b>Rüstungspunkte:</b> " + ((Outfit) item).getArmor() + "</html>");
			armor.setForeground(Color.WHITE);
			armor.setFont(new Font("Dialog", Font.ITALIC, 14));
			itemInfoPanel.add(armor);

			if (((Outfit) item).getOutfitFx().getSkillBoost().getSkillValue(Skill.STRENGTH) != 0) {
				JLabel stFx = new JLabel("<html><b>Effekt auf Stärke:</b> "
						+ ((Outfit) item).getOutfitFx().getSkillBoost().getSkillValue(Skill.STRENGTH) + "</html>");
				stFx.setFont(new Font("Dialog", Font.ITALIC, 14));
				stFx.setForeground(Color.WHITE);
				itemInfoPanel.add(stFx);
			}
			if (((Outfit) item).getOutfitFx().getSkillBoost().getSkillValue(Skill.PERCEPTION) != 0) {
				JLabel peFx = new JLabel("<html><b>Effekt auf Wahrnehmung:</b> "
						+ ((Outfit) item).getOutfitFx().getSkillBoost().getSkillValue(Skill.PERCEPTION) + "</html>");
				peFx.setFont(new Font("Dialog", Font.ITALIC, 14));
				peFx.setForeground(Color.WHITE);
				itemInfoPanel.add(peFx);
			}
			if (((Outfit) item).getOutfitFx().getSkillBoost().getSkillValue(Skill.ENDURANCE) != 0) {
				JLabel enFx = new JLabel("<html><b>Effekt auf Ausdauer:</b> "
						+ ((Outfit) item).getOutfitFx().getSkillBoost().getSkillValue(Skill.ENDURANCE) + "</html>");
				enFx.setFont(new Font("Dialog", Font.ITALIC, 14));
				enFx.setForeground(Color.WHITE);
				itemInfoPanel.add(enFx);
			}
			if (((Outfit) item).getOutfitFx().getSkillBoost().getSkillValue(Skill.CHARISMA) != 0) {
				JLabel chFx = new JLabel("<html><b>Effekt auf Charisma:</b> "
						+ ((Outfit) item).getOutfitFx().getSkillBoost().getSkillValue(Skill.CHARISMA) + "</html>");
				chFx.setFont(new Font("Dialog", Font.ITALIC, 14));
				chFx.setForeground(Color.WHITE);
				itemInfoPanel.add(chFx);
			}
			if (((Outfit) item).getOutfitFx().getSkillBoost().getSkillValue(Skill.INTELLIGENCE) != 0) {
				JLabel inFx = new JLabel("<html><b>Effekt auf Intelligenz:</b> "
						+ ((Outfit) item).getOutfitFx().getSkillBoost().getSkillValue(Skill.INTELLIGENCE) + "</html>");
				inFx.setFont(new Font("Dialog", Font.ITALIC, 14));
				inFx.setForeground(Color.WHITE);
				itemInfoPanel.add(inFx);
			}
			if (((Outfit) item).getOutfitFx().getSkillBoost().getSkillValue(Skill.AGILITY) != 0) {
				JLabel agFx = new JLabel("<html><b>Effekt auf Gewandtheit:</b> "
						+ ((Outfit) item).getOutfitFx().getSkillBoost().getSkillValue(Skill.AGILITY) + "</html>");
				agFx.setFont(new Font("Dialog", Font.ITALIC, 14));
				agFx.setForeground(Color.WHITE);
				itemInfoPanel.add(agFx);
			}
			if (((Outfit) item).getOutfitFx().getSkillBoost().getSkillValue(Skill.LUCK) != 0) {
				JLabel lkFx = new JLabel("<html><b>Effekt auf Glück:</b> "
						+ ((Outfit) item).getOutfitFx().getSkillBoost().getSkillValue(Skill.LUCK) + "</html>");
				lkFx.setFont(new Font("Dialog", Font.ITALIC, 14));
				lkFx.setForeground(Color.WHITE);
				itemInfoPanel.add(lkFx);
			}

		}
		if (item instanceof Note) {
			JLabel text = new JLabel("<html><b>Nachricht:<br></b> " + ((Note) item).getText() + "</html>");
			text.setFont(new Font("Dialog", Font.ITALIC, 14));
			text.setForeground(Color.WHITE);
			itemInfoPanel.add(text);
		}
		if (item instanceof Other) {
			JLabel info = new JLabel("<html><b>Information:</b> " + ((Other) item).getInfo() + "</html>");
			info.setFont(new Font("Dialog", Font.ITALIC, 14));
			info.setForeground(Color.WHITE);
			itemInfoPanel.add(info);
		}
		if (item instanceof QuestItem) {
			JLabel info = new JLabel("<html><b>Information:</b> " + ((QuestItem) item).getInfo() + "</html>");
			info.setFont(new Font("Dialog", Font.ITALIC, 14));
			info.setForeground(Color.WHITE);
			itemInfoPanel.add(info);
		}

		JLabel icon = new JLabel();
		Icon itemIcon = Icon.getByName(item.getUniqueName());
		if (itemIcon != null) {
			GUIHelper.setIcon(icon, itemIcon, 120, 120);
		}
		itemIconPanel.add(icon, BorderLayout.CENTER);

		this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel().setLayout(gl_leftInfoContentPanel);
		this.gameManager.getGuiManager().getMain().getLeftInfoPanel().setLayout(gl_leftInfoPanel);

		this.itemPanel.setBackground(new Color(0, 0, 0, 0.3f));

		this.gameManager.update();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel().removeAll();

		this.itemPanel.setBackground(new Color(0, 0, 0, 0));

		PlayerInfoPanel.update();

		this.gameManager.update();
	}

}
