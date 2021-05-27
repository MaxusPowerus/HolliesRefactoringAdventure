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
import map.MapField;

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
		this.gameManager.getGuiManager().getLeftInfoContentPanel().removeAll();

		this.gameManager.getGuiManager().getLeftInfoContentPanel().setBackground(new Color(0, 0, 0, 0));
		GroupLayout gl_leftInfoPanel = new GroupLayout(this.gameManager.getGuiManager().getLeftInfoPanel());
		gl_leftInfoPanel.setHorizontalGroup(gl_leftInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftInfoPanel.createSequentialGroup().addContainerGap()
						.addComponent(this.gameManager.getGuiManager().getLeftInfoContentPanel(),
								GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
						.addContainerGap()));
		gl_leftInfoPanel.setVerticalGroup(gl_leftInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftInfoPanel.createSequentialGroup().addContainerGap()
						.addComponent(this.gameManager.getGuiManager().getLeftInfoContentPanel(),
								GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
						.addContainerGap()));

		JPanel mapFieldInfoPanel = new JPanel();
		mapFieldInfoPanel.setBackground(new Color(0, 0, 0, 0));

		JPanel itemIconPanel = new JPanel();
		itemIconPanel.setBackground(new Color(0, 0, 0, 0));
		itemIconPanel.setLayout(new BorderLayout());
		GroupLayout gl_leftInfoContentPanel = new GroupLayout(
				this.gameManager.getGuiManager().getLeftInfoContentPanel());
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
		name.setFont(new Font("Dialog", Font.BOLD, 16));
		name.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		mapFieldInfoPanel.add(name);

		this.gameManager.getGuiManager().getLeftInfoContentPanel().setLayout(gl_leftInfoContentPanel);
		this.gameManager.getGuiManager().getLeftInfoPanel().setLayout(gl_leftInfoPanel);

		this.gameManager.update();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.gameManager.getGuiManager().getLeftInfoContentPanel().removeAll();

		this.gameManager.update();
	}

}
