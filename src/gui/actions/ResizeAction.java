package gui.actions;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import gui.GUIManager;

public class ResizeAction extends ComponentAdapter {

	private GUIManager guiManager;

	public ResizeAction(GUIManager guiManager) {
		this.guiManager = guiManager;
	}

	public void componentResized(ComponentEvent e) {
		System.out.println("w: " + e.getComponent().getWidth() + ", h: " + e.getComponent().getHeight());

		int width = e.getComponent().getWidth();
		int height = e.getComponent().getHeight();

		int halfWidth = width / 2;
		int halfHeight = height / 2;

		int contentPanelWidth = this.guiManager.getLeftContentPanel().getWidth();
		int contentPanelHeight = this.guiManager.getLeftContentPanel().getHeight();

		// RESIZE MAP
		if (this.guiManager.getLeftPanelHeadline().getText() == "Map") {
			int mapWidth = this.guiManager.getMapPanel().getWidth();
			int mapHeight = this.guiManager.getMapPanel().getHeight();

			int borderX = (contentPanelWidth - mapWidth) / 2;
			int borderY = (contentPanelHeight - mapHeight - 5) / 2; // -5 because of the gap to the headline

			if (contentPanelWidth > contentPanelHeight) {
				this.guiManager.getMapPanel().setBounds(borderX, borderY, contentPanelHeight - 20,
						contentPanelHeight - 20);
			} else {
				this.guiManager.getMapPanel().setBounds(borderX, borderY, contentPanelWidth - 20,
						contentPanelWidth - 20);
			}
		}
	}
}
