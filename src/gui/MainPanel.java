package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basic.Config;
import entities.Player;
import map.MapField;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public MainPanel() {
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(50, 30, 50, 30));
	}

	public void loadView(Player player) {
		MapField currentMapField = player.getCurrentMapField();

		JLabel mainText = new JLabel();
		mainText.setFont(new Font("Dialog", Font.PLAIN, 18));
		mainText.setForeground(Color.decode(Config.TEXT_COLOR));
		mainText.setText("<html><p style=\"text-align:center;\">" + currentMapField.getText() + "</p></html>");

		this.add(mainText, BorderLayout.NORTH);
	}

	public void resetView() {
		this.removeAll();
	}

}
