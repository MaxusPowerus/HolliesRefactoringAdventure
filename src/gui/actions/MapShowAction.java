package gui.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import basic.Config;
import basic.GameManager;
import gui.GUIHelper;
import map.Biom;
import map.MapField;

public class MapShowAction implements ActionListener {

	GameManager gameManager;

	public MapShowAction() {
		this.gameManager = GameManager.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		initialize();
	}

	public void initialize() {
		this.gameManager.getGuiManager().getMain().getInventoryPanel().setVisible(false);
		this.gameManager.getGuiManager().getMain().getLogPanel().setVisible(false);
		this.gameManager.getGuiManager().getMain().getMapPanel().setVisible(false);
		this.gameManager.getGuiManager().getMain().getMapPanel().setLayout(new BorderLayout());

		// set map/inv/log button states
		GUIHelper.removeActionListener(this.gameManager.getGuiManager().getMain().getInvButton());
		this.gameManager.getGuiManager().getMain().getInvButton().addActionListener(
				new InventoryShowAction(this.gameManager, this.gameManager.getPlayer().getInventory()));

		GUIHelper.removeActionListener(this.gameManager.getGuiManager().getMain().getLogButton());
		this.gameManager.getGuiManager().getMain().getLogButton().addActionListener(new LogShowAction());

		this.gameManager.getGuiManager().getMain().getMapButton().setEnabled(false);
		this.gameManager.getGuiManager().getMain().getInvButton().setEnabled(true);
		this.gameManager.getGuiManager().getMain().getLogButton().setEnabled(true);

		this.gameManager.getGuiManager().getMain().getLeftPanelHeadline().setText("Map");
		this.gameManager.getGuiManager().getMain().getInvButton().setVisible(true);

		this.gameManager.getGuiManager().getMain().getLeftContentPanel().setBackground(new Color(0, 0, 0, 0));
		this.gameManager.getGuiManager().getMain().getMapPanel().setBackground(new Color(0, 0, 0, 0));
		this.gameManager.getGuiManager().getMain().getMapPanel().setOpaque(true);
		this.gameManager.getGuiManager().getMain().getMapPanel()
				.setLayout(new GridLayout(Config.MAP_SIZEX, Config.MAP_SIZEY, 1, 1));

		// generate when not done
		if (this.gameManager.getGuiManager().getMain().getMapPanel().getComponentCount() == 0) {
			for (int y = 0; y < Config.MAP_SIZEY; y++) {
				for (int x = 0; x < Config.MAP_SIZEX; x++) {
					MapField field = this.gameManager.getPlayer().getCurrentMap().getMapFieldByCoordinate(x, y);
					JPanel p = new JPanel();
					p.setName(x + ":" + y);
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

					if (this.gameManager.getPlayer().getCurrentMapField().getCoordinate()
							.isEqual(field.getCoordinate())) {
						p.setBackground(Color.RED);
					}

					this.gameManager.getGuiManager().getMain().getMapPanel().add(p);
				}
			}
		} else {
			this.update();
		}

		this.gameManager.getGuiManager().getMain().getMapPanel().setVisible(true);
		this.gameManager.update();
	}

	public void update() {
		this.update(false);
	}

	public void update(boolean show) {
		for (Component p : this.gameManager.getGuiManager().getMain().getMapPanel().getComponents()) {
			String name = p.getName();
			String[] splitter = name.split(":");
			int x = Integer.valueOf(splitter[0]);
			int y = Integer.valueOf(splitter[1]);

			MapField field = this.gameManager.getPlayer().getCurrentMap().getMapFieldByCoordinate(x, y);

			p.removeMouseListener(new MapFieldHoverAction(this.gameManager, field));
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

			if (this.gameManager.getPlayer().getCurrentMapField().getCoordinate().isEqual(field.getCoordinate())) {
				p.setBackground(Color.RED);
			}
		}

		if (show) {

		}
	}

}
