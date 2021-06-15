package gui.actions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import basic.GameManager;
import basic.HelperFunctions;
import gui.GUIHelper;

public class ButtonHoverListener implements MouseListener {

	private JButton button;

	public ButtonHoverListener(JButton button) {
		this.button = button;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		BufferedImage backgroundImageSource = null;
		try {
			backgroundImageSource = ImageIO
					.read(new File(HelperFunctions.getResource("images/GUI/Button5x1_Highlighted.png")));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		this.button.setIcon(new ImageIcon(GUIHelper.scaleIcon(new ImageIcon(backgroundImageSource), 200).getImage()));
		GameManager.getInstance().update();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		BufferedImage backgroundImageSource = null;
		try {
			backgroundImageSource = ImageIO.read(new File(HelperFunctions.getResource("images/GUI/Button5x1.png")));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		this.button.setIcon(new ImageIcon(GUIHelper.scaleIcon(new ImageIcon(backgroundImageSource), 200).getImage()));
		GameManager.getInstance().update();
	}

}
