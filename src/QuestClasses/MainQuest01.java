package QuestClasses;

import java.util.ArrayList;

import basic.Config;
import entities.Player;
import utilities.Coordinate;
import utilities.Flag;

public class MainQuest01 extends Quest {

	public MainQuest01(Player player) {

		ArrayList<Flag> flags = new ArrayList<Flag>();

		Flag foundHolger = new Flag("foundHolger");

		flags.add(foundHolger);

		super.setQuest(1, new Coordinate(Config.MAP_SIZEX / 2, Config.MAP_SIZEY / 2 + 3), null, true,
				"Hollys Geburtstag",
				"Du hast von deinem Freund Holger einen Brief bekommen! Triff dich mit ihm im Wald", null, null, null,
				flags);

	}

	@Override
	public void update(Player player) {

		if (super.isActive()) {
			if (player.getCurrentMapField().getCoordinate().isEqual(super.getTargetPoint())) {
				super.setNewFlag("foundHolger");
				super.setTargetPoint(null);

			}
		}

		switch (super.getActiveFlagName()) {
		case "foundHolger":
			break;

		}

	}

	@Override
	public void update(String attempt, Player player) {
		// TODO Auto-generated method stub

	}

}
