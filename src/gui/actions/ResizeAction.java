package gui.actions;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;

import basic.GameManager;
import basic.Main;
import gui.BackgroundImagePanel;
import gui.GUIHelper;
import gui.GUIManager;

public class ResizeAction extends ComponentAdapter {

	private GUIManager guiManager;
	private boolean timeout;
	private long rtime;
	private int delta;

	private static int GAP = 6;
	private static int BIG_FONT = 20;
	private static int MEDIUM_FONT = 18;
	private static int NORMAL_FONT = 14;
	private static int MEDIUM_WINDOW = 1200;
	private static int BIG_WINDOW = 1600;

	public ResizeAction(GUIManager guiManager) {
		this.guiManager = guiManager;
		this.delta = 50;
	}

	public void componentResized(ComponentEvent e) {
		rtime = System.currentTimeMillis();
		if (!timeout) {
			timeout = true;
			Main.setTimeout(() -> {
				resizeEnded();
			}, delta);
		}
	}

	private void resizeEnded() {
		if (System.currentTimeMillis() - this.rtime < delta) {
			Main.setTimeout(() -> {
				this.resizeEnded();
			}, delta);
		} else { // DO RESIZE
			GUIManager gm = this.guiManager;
			timeout = false;

			int width = this.guiManager.getFrame().getWidth();
			int height = this.guiManager.getFrame().getHeight();

			// RESIZE LEFT MAIN PANEL
			this.guiManager.getLeftMainPanel().setBounds(0, 0, this.guiManager.getLeftMainPanel().getWidth(),
					this.guiManager.getLeftMainPanel().getWidth());

			int contentPanelWidth = this.guiManager.getLeftContentPanel().getWidth();
			int contentPanelHeight = this.guiManager.getLeftContentPanel().getHeight();

			// RESIZE MAP
			if (this.guiManager.getLeftPanelHeadline().getText() == "Map") {
				int mapWidth = this.guiManager.getMapPanel().getWidth();
				int mapHeight = this.guiManager.getMapPanel().getHeight();

				int borderX = (contentPanelWidth - mapWidth) / 2;
				int borderY = (contentPanelHeight - mapHeight) / 2; // -5 because of the gap to the headline

				if (contentPanelWidth > contentPanelHeight) {
					this.guiManager.getMapPanel().setBounds(borderX, borderY, contentPanelHeight, contentPanelHeight);
				} else {
					this.guiManager.getMapPanel().setBounds(borderX, borderY, contentPanelWidth, contentPanelWidth);
				}
			}

			// UPDATE FIELD BACKGROUND IMAGE
			for (Component c : this.guiManager.getFieldInfoPanel().getComponents()) {
				if (c instanceof BackgroundImagePanel)
					this.guiManager.getFieldInfoPanel().remove(c);
			}
			if (this.guiManager.getBackgroundImagePanel() != null) {
				Image backgroundImage = ((BackgroundImagePanel) this.guiManager.getBackgroundImagePanel()).getImg();
				if (backgroundImage != null) {
					this.guiManager.setBackgroundImagePanel(
							new BackgroundImagePanel(GUIHelper.scaleIcon(new ImageIcon(backgroundImage),
									this.guiManager.getFieldInfoPanel().getWidth() + 150).getImage()));
					this.guiManager.getFieldInfoPanel().add(this.guiManager.getBackgroundImagePanel());
				}
			}

			// UPDATE FIELDINFOS DIMENSIONS
			int fieldInfoPanelWidth = gm.getFieldInfoPanel().getWidth();
			int fieldInfoPanelHeight = gm.getFieldInfoPanel().getHeight();
			gm.getFieldInfos().setBounds(GAP, GAP, fieldInfoPanelWidth - GAP * 2, fieldInfoPanelHeight - GAP * 2);
			for (Component c : gm.getFieldInfos().getComponents()) {
				updateFontSize(c);
			}

			// UPDATE HEADLINES
			updateFontSize(gm.getLeftPanelHeadline());
			updateFontSize(gm.getPlayerInfoHeadline());

			GameManager.getInstance().update();
		}
	}

	private boolean isBigWindow() {
		return this.guiManager.getFrame().getWidth() > BIG_WINDOW;
	}

	private boolean isMediumWindow() {
		return this.guiManager.getFrame().getWidth() > MEDIUM_WINDOW;
	}

	private int getFontSize() {
		if (isBigWindow())
			return BIG_FONT;
		if (isMediumWindow())
			return MEDIUM_FONT;
		return NORMAL_FONT;
	}

	private void updateFontSize(Component c) {
		Font font = c.getFont();
		c.setFont(new Font(font.getFamily(), font.getStyle(), getFontSize()));
	}
}
