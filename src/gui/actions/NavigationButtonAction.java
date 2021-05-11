package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import basic.GameManager;
import gui.GUIHelper;
import gui.GUIManager;
import map.Direction;

public class NavigationButtonAction implements ActionListener {

	Direction direction;

	public NavigationButtonAction(Direction direction) {
		this.direction = direction;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GameManager gameManager = GameManager.getInstance();

		gameManager.getPlayer().go(this.direction);

		GUIManager guiManager = GameManager.getInstance().getGuiManager();

		GUIHelper.resetPanel(guiManager.getMainPanel());
		GUIHelper.resetPanel(guiManager.getPlayerInfoPanel());
		GUIHelper.resetPanel(guiManager.getWorldInfoPanel());

		guiManager.getMainPanel().updateView();
		guiManager.getPlayerInfoPanel().updateView();
		guiManager.getWorldInfoPanel().updateView();
	}

}
