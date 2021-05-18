package gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class GUIHelper {

	public static ImageIcon getIcon(Icon icon, int width, int height) {
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
