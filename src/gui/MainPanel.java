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
import map.Direction;
import map.MapField;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public MainPanel() {
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(50, 30, 50, 30));
	}

	public void loadMainView() {
		GUIHelper.resetPanel(this);
		this.updateView();
	}

	public void updateView() {
		Player player = GameManager.getInstance().getPlayer();

		MapField currentMapField = player.getCurrentMapField();

		JLabel mainText = new JLabel();
		mainText.setFont(new Font("Dialog", Font.PLAIN, 18));
		mainText.setForeground(Color.decode(Config.TEXT_COLOR));
		mainText.setText("<html><p style=\"text-align:center;\">" + currentMapField.getText() + "</p></html>");

		this.add(mainText, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel();

		buttonPanel.add(this.getNavigationButtons());
		buttonPanel.add(this.getInventoryButton());
		buttonPanel.add(this.getInspectButton());

		this.add(buttonPanel, BorderLayout.SOUTH);
	}

	public JPanel getNavigationButtons() {
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
		button.addActionListener(new InspectAction());

		panel.add(button, BorderLayout.CENTER);

		return panel;
	}

	public JPanel getInventoryButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 20));

		JButton button = new JButton();

		button.setText("Rucksack öffnen");
		this.setButtonStyle(button);
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

}
