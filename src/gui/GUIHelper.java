package gui;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import items.Item;

public class GUIHelper {

	public static ImageIcon getIcon(Icon icon, int width, int height) {
		return new ImageIcon(
				new ImageIcon(icon.getPath()).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	public static ImageIcon scaleIcon(ImageIcon icon, int width) {
		int iconWidth = icon.getIconWidth();
		int iconHeight = icon.getIconHeight();
		double ratio = Math.abs((double) iconHeight / (double) iconWidth);

		int height = (int) (width * ratio);

		return new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING));
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

	public static String stringifyItemList(ArrayList<Item> items) {
		StringBuilder builder = new StringBuilder();

		for (Item item : items) {
			builder.append(item.getCount() + "x " + item.getName()).append(", ");
		}
		return builder.substring(0, builder.toString().lastIndexOf(',') > -1 ? builder.toString().lastIndexOf(',') : 0)
				.toString();
	}

	public static void removeActionListener(JButton button) {
		for (ActionListener al : button.getActionListeners()) {
			button.removeActionListener(al);
		}
	}

}
