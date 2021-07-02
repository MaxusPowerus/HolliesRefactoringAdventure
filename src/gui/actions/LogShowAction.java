package gui.actions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import basic.GameManager;
import basic.HelperFunctions;
import gui.BackgroundImagePanel;
import gui.GUIHelper;
import gui.GUIManager;

public class LogShowAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		this.initialize();
	}

	public void initialize() {
		GameManager gameManager = GameManager.getInstance();
		GUIManager gm = gameManager.getGuiManager();

		// reset old and map panel
		gm.getMain().getMapPanel().setVisible(false);
		gm.getMain().getLogPanel().removeAll();
		gm.getMain().getLogPanel().setVisible(true);

		// set map/inv/log button states
		GUIHelper.removeActionListener(gm.getMain().getMapButton());
		gm.getMain().getMapButton().addActionListener(new MapShowAction());

		GUIHelper.removeActionListener(gm.getMain().getInvButton());
		gm.getMain().getInvButton()
				.addActionListener(new InventoryShowAction(gameManager, gameManager.getPlayer().getInventory()));

		gm.getMain().getMapButton().setEnabled(true);
		gm.getMain().getInvButton().setEnabled(true);
		gm.getMain().getLogButton().setEnabled(false);

		// set headline for left container
		gm.getMain().getLeftPanelHeadline().setText("Quest Tagebuch");

		// prepare nav panel
		JPanel navigationPanel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		navigationPanel.setBackground(new Color(0, 0, 0, 0));
		navigationPanel.setOpaque(false);

		// build layout
		JPanel contentPanel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		contentPanel.setBackground(new Color(0, 0, 0, 0));
		contentPanel.setOpaque(false);
		GroupLayout layout = new GroupLayout(gm.getMain().getLogPanel());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(contentPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(navigationPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 541,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(5)
						.addComponent(navigationPanel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE).addContainerGap()));
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		gm.getMain().getLogPanel().setLayout(layout);
		navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.X_AXIS));

		// get all items by category
		ArrayList<String> categories = new ArrayList<String>();
		categories.add("In Arbeit");
		categories.add("Abgeschlossen");

		for (String category : categories) {

			// set tab background in navigation panel
			BufferedImage navButtonBackgroundSource = null;
			try {
				navButtonBackgroundSource = ImageIO.read(new File(HelperFunctions.getResource("images/GUI/Tab.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			BackgroundImagePanel navigationButtonBackgroundPanel = new BackgroundImagePanel(
					GUIHelper.scaleIcon(new ImageIcon(navButtonBackgroundSource), 70).getImage());
			navigationButtonBackgroundPanel.setOpaque(false);

			// create tab label/icon
			JLabel buttonLabel = new JLabel();

			buttonLabel.setText(category);
			navigationButtonBackgroundPanel.setLayout(new GridBagLayout());
			navigationButtonBackgroundPanel.add(buttonLabel, new GridBagConstraints());
			navigationButtonBackgroundPanel.setName(category);
			navigationPanel.add(navigationButtonBackgroundPanel);
			navigationButtonBackgroundPanel.addMouseListener(new LogNavigationAction(gameManager, contentPanel,
					navigationPanel, navigationButtonBackgroundPanel));
		}

		LogNavigationAction.openCategory("In Arbeit");

		gameManager.update();
	}

	public void update() {
		// TODO
		this.initialize();
	}

}
