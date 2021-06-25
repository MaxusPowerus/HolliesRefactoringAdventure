package QuestClasses;

import java.util.ArrayList;

import basic.Config;
import basic.GameManager;
import entities.Player;
import map.Biom;
import utilities.Coordinate;
import utilities.Flag;
import utilities.Skill;

public class QuestPoorTraderTrigger extends Quest {

	public QuestPoorTraderTrigger(Coordinate targetPoint, ArrayList<Coordinate> targetZone, Biom biom,
			boolean updateOnEnter, boolean appearsInQuestLog, String title, String questInfo, String worldInfoLine,
			ArrayList<Possibility> possibilities, ArrayList<Flag> flags) {
		super(targetPoint, targetZone, biom, updateOnEnter, appearsInQuestLog, title, questInfo, worldInfoLine,
				possibilities, flags);

	}

	@Override
	public void update(String attempt, Player player) {

		if (super.isUpdateOnEnter() == false) {
			return;
		}

		System.out.println(" EnterUpdate - ActiveFalg: " + super.getActiveFlagName());

		switch (getActiveFlagName()) {
		case "start":

			super.setNewFlag("wait");
			super.setWorldInfoLine("Theodoras: \"Vielen Dank, das werde ich dir nie vergessen!\"");
			// setQuestInfo();

			super.clearPossibilities();

			QuestPoorTrader questPoorTrader = initQuestPoorTrader();

			GameManager.getInstance().getMainMap()
					.getMapFieldByCoordinate(super.getTargetPoint().getPosX() + 1, super.getTargetPoint().getPosY())
					.setQuest(questPoorTrader);
			GameManager.getInstance().getMainMap()
					.getMapFieldByCoordinate(super.getTargetPoint().getPosX() + 1, super.getTargetPoint().getPosY())
					.setChallenge(null);
			break;

		case "wait":

			;

			break;

		case "stillWait":
			setWorldInfoLine("Theodoras: \"Bitte Beeil dich!\"");
			// setQuestInfo();

			super.clearPossibilities();

			break;

		case "success":

			if (attempt.equals(getPossibilities().get(0).getButtonLabel())) {
				super.setQuestInfo("Du hast beschlossen das Amulett zu behalten.");
				super.setWorldInfoLine("Theodoras: \"Was?! Wie kannst du das nur tun?\"");

			} else if (attempt.equals(getPossibilities().get(1).getButtonLabel())) {
				super.setQuestInfo(
						"Du hast beschlossen Theodoras das Amulett nur gegen eine Bezahlung zurück zu geben!.");
				super.setWorldInfoLine("Theodoras: \"Was?! Nagut, nehmt das...mehr habe ich nicht ich schöwre es!\"");
				player.getInventory().addGold(38);

			} else if (attempt.equals(getPossibilities().get(2).getButtonLabel())) {
				super.setQuestInfo("Du hast beschlossen Theodoras das Amulett zurück zu geben!.");
				super.setWorldInfoLine("Theodoras: \"Habt vielen dank mein Freund.\"");
				player.getInventory()
						.remove(GameManager.getInstance().getResourceManager().getItemByUniqueName("TheodorasAmulet"));
				player.getExperience().addXp(500);
			}

			super.clearPossibilities();

			super.setUpdateOnEnter(false);
			super.setActive(false);
			super.setFinished(true);

			GameManager.getInstance().getMainMap().getMapFieldByCoordinate(super.getTargetPoint()).setQuest(null);
			break;

		case "failure":

			if (attempt.equals(getPossibilities().get(0).getButtonLabel())) {
				super.setQuestInfo("Du hast Theodoras von deinem Misserfolg berichtet!.");
				super.setWorldInfoLine("Theodoras: \"Oh nein ... was seid ihr nur für ein Nichtsnutz!\"");

			}

			super.clearPossibilities();

			super.setUpdateOnEnter(false);
			super.setActive(false);
			super.setFinished(true);
			GameManager.getInstance().getMainMap().getMapFieldByCoordinate(super.getTargetPoint()).setQuest(null);
			break;

		}

		System.out.println(" LeaveUpdate - ActiveFalg: " + super.getActiveFlagName());
	}

	@Override
	public void update(Player player) {
		if (isUpdateOnEnter() == false) {
			return;
		}

		System.out.println(" EnterUpdate(Simple) - ActiveFalg: " + super.getActiveFlagName());
		if (super.isActive() == false && super.isFinished() == false) {
			super.setActive(true);
			super.setNewFlag("start");
			return;
		}
		if (super.getActiveFlagName().equals("wait")) {
			super.setNewFlag("stillWait");
			super.setWorldInfoLine("Theodoras: \"Hast du das Amulett schon zurückholen können?\"");
			// setQuestInfo();

			Possibility p1 = new Possibility("Noch nicht", "\"Noch nicht aber ich bin dran\n", -1);

			super.getPossibilities().add(p1);

			return;
		} else if (super.getActiveFlagName().equals("stillWait")) {
			setWorldInfoLine("Theodoras scheint sehr besorgt...du solltest dich Beeilen!\"");
			// setQuestInfo();

			super.clearPossibilities();

			return;
		}
		System.out.println(" LeaveUpdate - ActiveFalg: " + super.getActiveFlagName());
	}

	public QuestPoorTrader initQuestPoorTrader() {

		Coordinate tp = new Coordinate(Config.MAP_SIZEX / 2 + 1, Config.MAP_SIZEY / 2 + 1);
		ArrayList<Coordinate> tz = null;
		Biom b = null; // null = Rabdom Biom

		boolean uoe = true;
		boolean aiql = true;
		String t = "Eine falsche Entscheidung II";
		String qi = "Du triffst auf den Händler, von dem Theodoras berichtet hat..";
		String wil = "Händler: \"Hallo fremder wollt ihr einen Blick auf meine Waren werfen?\"";

		ArrayList<Possibility> p = new ArrayList<Possibility>();
		Possibility p1 = new Possibility("Überreden",
				"\"Hey der Arme Theodoras ist am Boden zerstört...das Amulett gehörte seiner Toten Mutter...bitte lass es mich ihm zurück  geben!\"",
				-1);
		Possibility p2 = new Possibility("Abkaufen", "Kaufe dem Händler das Amulett ab.", -1);
		Possibility p3 = new Possibility("Wegnehmen", "Den Händler verprügeln und das Amulett mit Gewalt beschaffen.",
				-1);

		p.add(p1);
		p.add(p2);
		p.add(p3);

		ArrayList<Flag> f = new ArrayList<Flag>();
		Flag f0 = new Flag("start");
		f.add(f0);

		QuestPoorTrader questPoorTrader = new QuestPoorTrader(tp, tz, b, uoe, aiql, t, qi, wil, p, f);
		return questPoorTrader;
	}

}
