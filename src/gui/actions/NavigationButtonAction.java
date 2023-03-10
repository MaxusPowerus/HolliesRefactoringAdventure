package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import basic.GameManager;
import gui.ActionPanel;
import gui.WorldInfoPanel;
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

		WorldInfoPanel.update();
		ActionPanel.update();
		GameManager.getInstance().getGuiManager().getMain().updateCompass();

		if (gameManager.getGuiManager().getMain().getLeftPanelHeadline().getText() == "Map") {
			new MapShowAction().update();
		}

		if (gameManager.getGuiManager().getMain().getLeftPanelHeadline().getText() == "Quest Tagebuch") {
			new LogShowAction().update();
		}

		gameManager.execMainLogic();
	}

}
