package gui.actions;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import QuestClasses.Quest;
import basic.GameManager;
import basic.HelperFunctions;
import gui.BackgroundImagePanel;
import gui.GUIHelper;

public class LogNavigationAction implements MouseListener {

	private static GameManager gameManager;
	private static JPanel contentPanel;
	private static JPanel navigationPanel;
	private BackgroundImagePanel navigationButtonBackgroundPanel;
	private static String openedCategory;

	public LogNavigationAction(GameManager gameManager, JPanel contentPanel, JPanel navigationPanel,
			BackgroundImagePanel navigationButtonBackgroundPanel) {
		LogNavigationAction.gameManager = gameManager;
		LogNavigationAction.contentPanel = contentPanel;
		LogNavigationAction.navigationPanel = navigationPanel;
		this.navigationButtonBackgroundPanel = navigationButtonBackgroundPanel;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		updateNavIcon(true);
		navigationButtonBackgroundPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (!openedCategory.equalsIgnoreCase(e.getComponent().getName())) {
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
			category = "In Arbeit"; // when not selected
		contentPanel.removeAll();

		openedCategory = category;

		// update navigation button icon
		for (Component c : navigationPanel.getComponents()) {
			if (c instanceof BackgroundImagePanel) {
				updateNavIcon((BackgroundImagePanel) c, category.equalsIgnoreCase(c.getName()));
			}
		}

		ArrayList<Quest> inWork = new ArrayList<Quest>();
		ArrayList<Quest> done = new ArrayList<Quest>();
		for (Quest quest : GameManager.getInstance().getQuestManager().getAllQuests()) {
			if (quest.isAppearsInQuestLog()) {
				if (quest.isActive() && !quest.isFinished())
					inWork.add(quest);
				if (!quest.isActive() && quest.isFinished())
					done.add(quest);
			}
		}

		if (category == "In Arbeit" && !inWork.isEmpty()) {
			for (Quest quest : inWork) {
				contentPanel.add(getQuestLine(quest));
			}

		} else if (category == "Abgeschlossen" && !done.isEmpty()) {
			for (Quest quest : done) {
				contentPanel.add(getQuestLine(quest));
			}
		} else {
			contentPanel.add(new JLabel("<html><b>Hier erscheinen deine Quests, sobald sie verfügbar sind</b></html>"));
		}

		gameManager.update();
	}

	private static JPanel getQuestLine(Quest quest) {

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(32767, 50));
		panel.setBackground(new Color(0, 0, 0, 0));
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0, 0, 0, 0f)));
		gameManager.getGuiManager().getMain().getInventoryPanel().add(panel);

		JLabel name = new JLabel(quest.getTitle());
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));

		// TODO

		JButton button = getButton(quest, panel);

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

		panel.addMouseListener(new LogLineHover(panel, gameManager, quest));

		return panel;
	}

	private static JButton getButton(Quest quest, JPanel panel) {
		JButton button = new JButton();
		button.setBorder(null);

		Quest currentQuest = GameManager.getInstance().getPlayer().getCurrentQuest();

		button.setBackground(Color.decode("#71F899"));
		if (currentQuest != null && currentQuest.equals(quest)) { // TODO
			button.setText("abrüsten");
			button.setBackground(Color.decode("#ed394a"));
			button.setForeground(Color.WHITE);
		} else {
			button.setText("ausrüsten");
		}
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentQuest != null && currentQuest.equals(quest)) {
					GameManager.getInstance().getPlayer().setCurrentQuest(null);
				} else {
					GameManager.getInstance().getPlayer().setCurrentQuest(quest);
				}
				openCategory(openedCategory);
				GameManager.getInstance().getGuiManager().getMain().updateCompass();
			}
		});

		// hide button because there is no action left
		if (quest.isFinished()) {
			button.setVisible(false);
		}

		return button;
	}
}
