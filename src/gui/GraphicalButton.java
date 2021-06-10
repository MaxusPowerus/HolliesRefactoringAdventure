package gui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import basic.HelperFunctions;
import gui.actions.ButtonHoverListener;

public class GraphicalButton extends JButton {

	public GraphicalButton() {
		this("");
	}

	public GraphicalButton(String text) {
		super(text);
		BufferedImage backgroundImageSource = null;
		try {
			backgroundImageSource = ImageIO.read(new File(HelperFunctions.getResource("images/GUI/Button5x1.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setIcon(new ImageIcon(GUIHelper.scaleIcon(new ImageIcon(backgroundImageSource), 200).getImage()));
		this.setOpaque(false);
		this.setForeground(Color.WHITE);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setBorderPainted(false);

		this.addMouseListener(new ButtonHoverListener(this));
	}

}
