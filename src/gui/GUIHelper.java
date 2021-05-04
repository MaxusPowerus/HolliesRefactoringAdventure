package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUIHelper {

	public static JPanel createTextPanel(String label, String value) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 0));

		JLabel jLabel = new JLabel();
		jLabel.setText(label + ": ");

		JLabel jValue = new JLabel();
		jValue.setText(value);
		jValue.setFont(new Font("Dialog", Font.PLAIN, 12));

		panel.setBorder(new EmptyBorder(0, 80, 0, 80));
		panel.add(jLabel);
		panel.add(jValue);

		return panel;
	}

}
