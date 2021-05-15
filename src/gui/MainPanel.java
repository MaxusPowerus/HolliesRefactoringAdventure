package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basic.Config;
import basic.GameManager;
import entities.Player;
import gui.actions.BackButtonAction;
import gui.actions.InspectAction;
import gui.actions.InventoryShowAction;
import gui.actions.NavigationButtonAction;
import gui.mainPanelComponents.NPCDialog;
import map.Direction;
import map.MapField;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel main;
	private JPanel header;
	private JPanel footer;

	public MainPanel() {
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(50, 30, 50, 30));

		this.main = new JPanel();
//		this.mainDialog.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.main.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.LIGHT_GRAY));
		this.add(main, BorderLayout.CENTER);

		this.header = new JPanel();
		this.header.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		this.add(this.header, BorderLayout.NORTH);

		this.footer = new JPanel();
		this.footer.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		this.add(this.footer, BorderLayout.SOUTH);
	}

	public void loadMainView() {
		GUIHelper.resetPanel(this);
		this.setMainView();
	}

	public void setMainView() {
		GameManager gameManager = GameManager.getInstance();
		Player player = gameManager.getPlayer();
		MapField currentMapField = player.getCurrentMapField();

		// add main text
		JLabel mainText = new JLabel();
		mainText.setFont(new Font("Dialog", Font.PLAIN, 18));
		mainText.setForeground(Color.decode(Config.TEXT_COLOR));
		mainText.setText("<html><p style=\"text-align:center;\">" + currentMapField.getText() + "</p></html>");
		this.header.add(mainText);

		// add npc dialog
		new NPCDialog(this);

		// add control buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(this.getNavigationButtons());
		buttonPanel.add(this.getInventoryButton());
		buttonPanel.add(this.getInspectButton());
		this.footer.add(buttonPanel);
	}

	public JPanel getNavigationButtons() {
		Player player = GameManager.getInstance().getPlayer();

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 50));

		JButton north = new JButton("N");
		JButton east = new JButton("O");
		JButton south = new JButton("S");
		JButton west = new JButton("W");

		this.setButtonStyle(north, Config.COMPASS_COLOR);
		this.setButtonStyle(east, Config.COMPASS_COLOR);
		this.setButtonStyle(south, Config.COMPASS_COLOR);
		this.setButtonStyle(west, Config.COMPASS_COLOR);

		north.addActionListener(new NavigationButtonAction(Direction.NORTH));
		east.addActionListener(new NavigationButtonAction(Direction.EAST));
		south.addActionListener(new NavigationButtonAction(Direction.SOUTH));
		west.addActionListener(new NavigationButtonAction(Direction.WEST));

		buttonPanel.setLayout(new BorderLayout());
		JPanel buttonFirstLine = new JPanel();
		JPanel buttonSecondLine = new JPanel();
		JPanel buttonThirdLine = new JPanel();

		// disable buttons when move is not allowed
		if (!player.canGo(Direction.NORTH)) {
			north.setEnabled(false);
		}
		if (!player.canGo(Direction.EAST)) {
			east.setEnabled(false);
		}
		if (!player.canGo(Direction.SOUTH)) {
			south.setEnabled(false);
		}
		if (!player.canGo(Direction.WEST)) {
			west.setEnabled(false);
		}

		buttonFirstLine.add(north);
		buttonSecondLine.add(west);
		buttonSecondLine.add(east);
		buttonThirdLine.add(south);

		buttonPanel.add(buttonFirstLine, BorderLayout.NORTH);
		buttonPanel.add(buttonSecondLine, BorderLayout.CENTER);
		buttonPanel.add(buttonThirdLine, BorderLayout.SOUTH);

		return buttonPanel;
	}

	public JPanel getInspectButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 20));

		JButton button = new JButton();
		button.setText("Bereich untersuchen");
		this.setButtonStyle(button);
		button.addActionListener(new InspectAction(this));

		panel.add(button, BorderLayout.CENTER);

		return panel;
	}

	public JPanel getInventoryButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 20));

		JButton button = new JButton();
		GUIHelper.setIcon(button, Icon.BACKPACK);
		button.addActionListener(new InventoryShowAction(this));

		panel.add(button, BorderLayout.CENTER);

		return panel;
	}

	public void setButtonStyle(JButton button) {
		this.setButtonStyle(button, Config.MAIN_BUTTON_COLOR);
	}

	public void setButtonStyle(JButton button, String color) {
		button.setBorder(new EmptyBorder(7, 20, 7, 20));
		button.setFocusPainted(false);
		button.setBackground(Color.decode(color));
		button.setForeground(Color.WHITE);
	}

	public void printHeadline(String text) {
		JLabel label = new JLabel();
		label.setText("<html><p style=\"text-align:center;\">" + text + "</p></html>");
		label.setFont(new Font("Dialog", Font.PLAIN, 30));
		label.setForeground(Color.decode(Config.TEXT_COLOR));

		this.add(label, BorderLayout.NORTH);
	}

	public void addBackButton() {
		JPanel panel = new JPanel();
		JButton button = new JButton();

		button.setText("Rucksack schliessen");
		this.setButtonStyle(button);
		button.addActionListener(new BackButtonAction(this));

		panel.add(button);
		this.add(panel, BorderLayout.SOUTH);
	}

	public JPanel getMain() {
		return main;
	}

	public JPanel getFooter() {
		return footer;
	}

	public JPanel getHeader() {
		return header;
	}

	public void clearMainDialog() {
		this.main.removeAll();
	}

	public void repaintMainDialog() {
		this.main.revalidate();
		this.main.repaint();
	}

}
