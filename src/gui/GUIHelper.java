package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

	public static void resetPanel(JPanel panel) {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
	}

	private static ImageIcon getIcon(Icon icon) {
		return new ImageIcon(new ImageIcon(icon.getPath()).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
	}

	public static void setIconAsButton(JButton button, Icon icon) {
		button.setIcon(GUIHelper.getIcon(icon));
		button.setContentAreaFilled(false);
		button.setBorder(null);
	}

}
