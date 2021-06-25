package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import basic.GameManager;
import entities.Merchant;
import entities.Player;
import gui.GraphicalButton;
import gui.actions.InventoryShowAction;
import gui.actions.MapShowAction;
import utilities.Challenge;

public class SellButton extends GraphicalButton implements ActionListener {

	private Challenge challenge;
	private Player player;
	private GameManager gameManager;

	public SellButton(Challenge challenge, Player player, GameManager gameManager) {
		this.challenge = challenge;
		this.player = player;
		this.gameManager = gameManager;

		this.setText("Verkaufen");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.gameManager.getGuiManager().getMain().setNavigationEnabled(false);
		new InventoryShowAction(this.gameManager, this.player.getInventory(), "Items verkaufen: Dein Inventar",
				(Merchant) this.challenge.getNpc(), false).initSell();

		JButton stopHandling = new GraphicalButton("Handel beenden");
		stopHandling.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MapShowAction().initialize();

				gameManager.getGuiManager().getMain()
						.addFieldInfo("Du hast den Handel mit <b>" + challenge.getNpc().getName() + "</b> beendet");

				gameManager.getGuiManager().getMain().getActionButtonPanel().removeAll();

				BuyButton buyButton = new BuyButton(challenge, player, gameManager);
				gameManager.getGuiManager().getMain().getActionButtonPanel().add(buyButton);

				SellButton sellButton = new SellButton(challenge, player, gameManager);
				gameManager.getGuiManager().getMain().getActionButtonPanel().add(sellButton);

				gameManager.getGuiManager().getMain().setNavigationEnabled(true);

				gameManager.update();
			}
		});
		this.gameManager.getGuiManager().getMain().getActionButtonPanel().removeAll();
		this.gameManager.getGuiManager().getMain().getActionButtonPanel().add(stopHandling);

	}

}
