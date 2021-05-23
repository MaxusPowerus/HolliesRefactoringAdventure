package gui.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import basic.Config;
import basic.GameManager;
import map.Biom;
import map.MapField;

public class MapShowAction implements ActionListener {

	GameManager gameManager;

	public MapShowAction(GameManager gameManager) {
		this.gameManager = gameManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		initialize();
	}

	public void initialize() {
		this.gameManager.getGuiManager().getLeftContentPanel().removeAll();
		this.gameManager.getGuiManager().getLeftContentPanel().setLayout(new BorderLayout());

		this.gameManager.getGuiManager().getOpenInvButton().setText("Inventar");
		this.gameManager.getGuiManager().getOpenInvButton().removeActionListener(this);
		this.gameManager.getGuiManager().getOpenInvButton()
				.addActionListener(new InventoryShowAction(this.gameManager));

		this.gameManager.getGuiManager().getLeftPanelHeadline().setText("Map");

		this.gameManager.getGuiManager().getLeftContentPanel()
				.setLayout(new GridLayout(Config.MAP_SIZEX, Config.MAP_SIZEY, 0, 0));

		this.gameManager.getGuiManager().getLeftContentPanel().setVisible(false);

		int index = 1;
		for (int y = 0; y < Config.MAP_SIZEY; y++) {
			for (int x = 0; x < Config.MAP_SIZEX; x++) {
				MapField field = this.gameManager.getPlayer().getCurrentMap().getMapFieldByCoordinate(x, y);
				JPanel p = new JPanel();
				p.addMouseListener(new MapFieldHoverAction(this.gameManager, field));
				if (field.getBiom() == Biom.DESERT) {
					p.setBackground(Color.decode("#c28370"));
				} else if (field.getBiom() == Biom.FOREST) {
					p.setBackground(Color.decode("#196130"));
				} else if (field.getBiom() == Biom.MOUNTAINS) {
					p.setBackground(Color.decode("#71817B"));
				} else if (field.getBiom() == Biom.SWAMP) {
					p.setBackground(Color.decode("#6D610D"));
				} else if (field.getBiom() == Biom.MEADOW) {
					p.setBackground(Color.decode("#16b91e"));
				}

				p.setLayout(new GridLayout(1, 1));

				if (this.gameManager.getPlayer().getCurrentMapField().getCoordinate().isEqual(field.getCoordinate())) {
					p.setBackground(Color.RED);
				}

				this.gameManager.getGuiManager().getLeftContentPanel().add(p);
			}
		}

		this.gameManager.getGuiManager().getLeftContentPanel().setVisible(true);
		this.gameManager.update();
	}

}
