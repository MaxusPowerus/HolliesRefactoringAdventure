package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ContentPane extends JPanel {

	private static final long serialVersionUID = 1L;

	public ContentPane() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLUE);
	}
}
