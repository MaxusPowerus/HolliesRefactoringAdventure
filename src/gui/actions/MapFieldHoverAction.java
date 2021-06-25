package gui.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import basic.GameManager;
import entities.Enemy;
import entities.Merchant;
import map.MapField;
import utilities.Challenge;

public class MapFieldHoverAction implements MouseListener {

	private GameManager gameManager;
	private MapField mapField;

	public MapFieldHoverAction(GameManager gameManager, MapField mapField) {
		this.gameManager = gameManager;
		this.mapField = mapField;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel().removeAll();

		this.gameManager.getGuiManager().getMain().getLeftInfoPanel().setBackground(new Color(0, 0, 0, 0.4f));

		this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel().setBackground(new Color(0, 0, 0, 0));
		GroupLayout gl_leftInfoPanel = new GroupLayout(this.gameManager.getGuiManager().getMain().getLeftInfoPanel());
		gl_leftInfoPanel.setHorizontalGroup(gl_leftInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftInfoPanel.createSequentialGroup().addContainerGap()
						.addComponent(this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel(),
								GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
						.addContainerGap()));
		gl_leftInfoPanel.setVerticalGroup(gl_leftInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftInfoPanel.createSequentialGroup().addContainerGap()
						.addComponent(this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel(),
								GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
						.addContainerGap()));

		JPanel mapFieldInfoPanel = new JPanel();
		mapFieldInfoPanel.setBackground(new Color(0, 0, 0, 0));

		JPanel itemIconPanel = new JPanel();
		itemIconPanel.setBackground(new Color(0, 0, 0, 0));
		itemIconPanel.setLayout(new BorderLayout());
		GroupLayout gl_leftInfoContentPanel = new GroupLayout(
				this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel());
		gl_leftInfoContentPanel.setHorizontalGroup(gl_leftInfoContentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_leftInfoContentPanel.createSequentialGroup()
						.addComponent(mapFieldInfoPanel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
						.addComponent(itemIconPanel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)));
		gl_leftInfoContentPanel.setVerticalGroup(gl_leftInfoContentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(itemIconPanel, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
				.addComponent(mapFieldInfoPanel, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE));
		mapFieldInfoPanel.setLayout(new BoxLayout(mapFieldInfoPanel, BoxLayout.Y_AXIS));

		JLabel name = new JLabel(this.mapField.getBiom().getName());
		name.setForeground(Color.WHITE);
		name.setFont(new Font(this.gameManager.getGuiManager().getCustomFont().getFamily(), Font.PLAIN, 40));
		name.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		mapFieldInfoPanel.add(name);

		JLabel info = new JLabel();
		info.setForeground(Color.WHITE);
		info.setFont(new Font("Dialog", Font.PLAIN, 14));

		Challenge challenge = this.mapField.getChallenge();
		switch (challenge.getChallangeType()) {
		case 0:
			if (challenge.isChallengeCompleted()) {
				info.setText("Du hast diesen Container bereits gefunden");
			} else {
				info.setText("Hier gibt es " + challenge.getContainer().toString() + " für dich");
			}
			break;
		case 1:
			if (challenge.isChallengeCompleted()) {
				info.setText("Du hast diesen Feind bereits besiegt");
			} else {
				info.setText("Achtung, hier erwartet dich " + ((Enemy) challenge.getNpc()).toString());
			}
			break;
		case 2:
			info.setText("Hier erwartet dich ein Händler: " + ((Merchant) challenge.getNpc()).getName());
			break;
		case 3:
			// TODO
			break;
		}
		mapFieldInfoPanel.add(info);

		this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel().setLayout(gl_leftInfoContentPanel);
		this.gameManager.getGuiManager().getMain().getLeftInfoPanel().setLayout(gl_leftInfoPanel);

		this.gameManager.update();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.gameManager.getGuiManager().getMain().getLeftInfoContentPanel().removeAll();

		this.gameManager.update();
	}

}
