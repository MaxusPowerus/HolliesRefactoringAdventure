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

import QuestClasses.Quest;
import basic.GameManager;

public class LogLineHover implements MouseListener {

	private JPanel itemPanel;
	private GameManager gameManager;
	private Quest quest;

	public LogLineHover(JPanel itemPanel, GameManager gameManager, Quest quest) {
		this.itemPanel = itemPanel;
		this.gameManager = gameManager;
		this.quest = quest;
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

		JPanel questInfoPanel = new JPanel();
		questInfoPanel.setBackground(new Color(0, 0, 0, 0));

		JPanel itemIconPanel = new JPanel();
		itemIconPanel.setBackground(new Color(0, 0, 0, 0));
		itemIconPanel.setLayout(new BorderLayout());
		GroupLayout gl_leftInfoContentPanel = new GroupLayout(
				this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel());
		gl_leftInfoContentPanel.setHorizontalGroup(gl_leftInfoContentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_leftInfoContentPanel.createSequentialGroup()
						.addComponent(questInfoPanel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
						.addComponent(itemIconPanel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)));
		gl_leftInfoContentPanel.setVerticalGroup(gl_leftInfoContentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(itemIconPanel, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
				.addComponent(questInfoPanel, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE));
		questInfoPanel.setLayout(new BoxLayout(questInfoPanel, BoxLayout.Y_AXIS));

		JLabel name = new JLabel(quest.getTitle());
		name.setForeground(Color.WHITE);
		name.setFont(new Font(this.gameManager.getGuiManager().getCustomFont().getFamily(), Font.PLAIN, 40));
		questInfoPanel.add(name);

		int counter = 0;
		for (String infoLine : quest.getAllQuestInfoLines()) {

			JLabel info = new JLabel("<html>" + infoLine + "</html>");
			info.setForeground(Color.WHITE);
			info.setFont(new Font("Dialog", Font.ITALIC, 14));
			questInfoPanel.add(info);

			if (++counter > 5)
				break;
		}

		this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel().setLayout(gl_leftInfoContentPanel);
		this.gameManager.getGuiManager().getMain().getLeftInfoPanel().setLayout(gl_leftInfoPanel);

		this.itemPanel.setBackground(new Color(0, 0, 0, 0.3f));

		this.gameManager.update();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel().removeAll();

		this.itemPanel.setBackground(new Color(0, 0, 0, 0));

		this.gameManager.update();
	}

}
