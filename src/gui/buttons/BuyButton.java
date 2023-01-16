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

public class BuyButton extends GraphicalButton implements ActionListener {

	private Challenge challenge;
	private Player player;
	private GameManager gameManager;
	private JButton button;

	public BuyButton(Challenge challenge, Player player, GameManager gameManager) {

		this.challenge = challenge;
		this.player = player;
		this.gameManager = gameManager;

		this.setText("Kaufen");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.gameManager.getGuiManager().getMain().setNavigationEnabled(false);
		new InventoryShowAction(this.gameManager, ((Merchant) challenge.getNpc()).getInventory(),
				"Items kaufen: Inventar des Händlers", (Merchant) this.challenge.getNpc(), false).initBuy();

		JButton stopHandling = new GraphicalButton("Handel beenden");
		stopHandling.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MapShowAction().initialize();

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
