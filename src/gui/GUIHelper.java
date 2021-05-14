package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
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

	private static ImageIcon getIcon(Icon icon, int width, int height) {
		return new ImageIcon(
				new ImageIcon(icon.getPath()).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	public static void setIcon(JComponent component, Icon icon) {
		GUIHelper.setIcon(component, icon, 80, 80);
	}

	public static void setIcon(JComponent component, Icon icon, int width, int height) {
		if (component instanceof JButton) {
			((JButton) component).setIcon(GUIHelper.getIcon(icon, width, height));
			((JButton) component).setContentAreaFilled(false);
			((JButton) component).setBorder(null);
		} else if (component instanceof JLabel) {
			((JLabel) component).setIcon(GUIHelper.getIcon(icon, width, height));
			((JLabel) component).setBorder(null);
		} else {
			System.out.println("[WARN] GUIHelper: Wrong component type");
		}
	}

}
