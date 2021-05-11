package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainPanel;

public class BackButtonAction implements ActionListener {

	MainPanel mainPanel;

	public BackButtonAction(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.mainPanel.loadMainView();
	}

}
