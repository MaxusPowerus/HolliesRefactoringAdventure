package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import basic.HelperFunctions;

public class GraphicalButton extends JButton {

	public GraphicalButton() {
		this("");
	}

	public GraphicalButton(String text) {
		super(text);
		BufferedImage backgroundImageSource = null;
		BufferedImage backgroundImageDisabledSource = null;
		BufferedImage backgroundImageHighlightedSource = null;
		try {
			backgroundImageSource = ImageIO.read(new File(HelperFunctions.getResource("images/GUI/Button5x1.png")));
			backgroundImageDisabledSource = ImageIO
					.read(new File(HelperFunctions.getResource("images/GUI/Button5x1_Disabled.png")));
			backgroundImageHighlightedSource = ImageIO
					.read(new File(HelperFunctions.getResource("images/GUI/Button5x1_Highlighted.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setIcon(new ImageIcon(GUIHelper.scaleIcon(new ImageIcon(backgroundImageSource), 200).getImage()));
		this.setDisabledIcon(
				new ImageIcon(GUIHelper.scaleIcon(new ImageIcon(backgroundImageDisabledSource), 200).getImage()));
		this.setRolloverIcon(
				new ImageIcon(GUIHelper.scaleIcon(new ImageIcon(backgroundImageHighlightedSource), 200).getImage()));
		this.setOpaque(false);
		this.setForeground(Color.WHITE);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setSize(194, 36);
		this.setPreferredSize(new Dimension(194, 36));
		this.setMaximumSize(new Dimension(194, 36));
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setBorderPainted(false);

//		this.addMouseListener(new ButtonHoverListener(this));
	}

}
