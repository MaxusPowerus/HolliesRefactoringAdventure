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

	public QuestPoorTraderTrigger(int instanceLimit, Coordinate targetPoint, ArrayList<Coordinate> targetZone,
			Biom biom, boolean updateOnEnter, boolean appearsInQuestLog, String title, String questInfo,
			String worldInfoLine, ArrayList<String> possibilities, ArrayList<String> possibilitiesButtonlabels,
			ArrayList<Integer> possibilitiesChances, ArrayList<Flag> flags) {
		super(instanceLimit, targetPoint, targetZone, biom, updateOnEnter, appearsInQuestLog, title, questInfo,
				worldInfoLine, possibilities, possibilitiesButtonlabels, possibilitiesChances, flags);

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

			if (attempt.equals(getPossibilitiesButtonlabels().get(0))) {
				super.setQuestInfo("Du hast beschlossen das Amulett zu behalten.");
				super.setWorldInfoLine("Theodoras: \"Was?! Wie kannst du das nur tun?\"");

			} else if (attempt.equals(getPossibilitiesButtonlabels().get(1))) {
				super.setQuestInfo(
						"Du hast beschlossen Theodoras das Amulett nur gegen eine Bezahlung zur�ck zu geben!.");
				super.setWorldInfoLine("Theodoras: \"Was?! Nagut, nehmt das...mehr habe ich nicht ich sch�wre es!\"");
				player.getInventory().addGold(38);

			} else if (attempt.equals(getPossibilitiesButtonlabels().get(2))) {
				super.setQuestInfo("Du hast beschlossen Theodoras das Amulett zur�ck zu geben!.");
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

			if (attempt.equals(getPossibilitiesButtonlabels().get(0))) {
				super.setQuestInfo("Du hast Theodoras von deinem Misserfolg berichtet!.");
				super.setWorldInfoLine("Theodoras: \"Oh nein ... was seid ihr nur f�r ein Nichtsnutz!\"");

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
			super.setWorldInfoLine("Theodoras: \"Hast du das Amulett schon zur�ckholen k�nnen?\"");
			// setQuestInfo();

			super.getPossibilitiesChances().add(-1);
			super.getPossibilities().add("\"Noch nicht aber ich bin dran\n");
			super.getPossibilitiesButtonlabels().add("Noch nicht");

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
		int il = 1; // instanceLimit
		Coordinate tp = new Coordinate(Config.MAP_SIZEX / 2 + 1, Config.MAP_SIZEY / 2 + 1);
		ArrayList<Coordinate> tz = null;
		Biom b = null; // null = Rabdom Biom

		boolean uoe = true;
		boolean aiql = true;
		String t = "Eine falsche Entscheidung II";
		String qi = "Du triffst auf den H�ndler, von dem Theodoras berichtet hat..";
		String wil = "H�ndler: \"Hallo fremder wollt ihr einen Blick auf meine Waren werfen?\"";

		ArrayList<String> p = new ArrayList<String>();
		String p1 = "Hey der Arme Theodoras ist am Boden zerst�rt...das Amulett geh�rte seiner Toten Mutter...bitte lass es mich ihm zur�ck  geben!";
		String p2 = "Kaufe dem H�ndler das Amulett ab.";
		String p3 = "Den H�ndler verpr�geln und das Amulett mit Gewalt beschaffen.";
		p.add(p1);
		p.add(p2);
		p.add(p3);

		ArrayList<String> pb = new ArrayList<String>();
		String pb1 = "�berreden";
		String pb2 = "Abkaufen";
		String pb3 = "Wegnehmen";
		pb.add(pb1);
		pb.add(pb2);
		pb.add(pb3);
		ArrayList<Integer> pc = new ArrayList<Integer>();
		int pc1 = -1;
		int pc2 = -1;
		int pc3 = -1;
		pc.add(pc1);
		pc.add(pc2);
		pc.add(pc3);

		ArrayList<Flag> f = new ArrayList<Flag>();
		Flag f0 = new Flag("start");
		f.add(f0);

		QuestPoorTrader questPoorTrader = new QuestPoorTrader(il, tp, tz, b, uoe, aiql, t, qi, wil, p, pb, pc, f);
		return questPoorTrader;
	}

}
