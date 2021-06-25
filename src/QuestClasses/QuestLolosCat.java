package QuestClasses;

import java.util.ArrayList;

import entities.Player;
import map.Biom;
import utilities.Coordinate;
import utilities.Flag;
import utilities.Skill;

public class QuestLolosCat extends Quest {
	public QuestLolosCat(Coordinate targetPoint, ArrayList<Coordinate> targetZone, Biom biom, boolean updateOnEnter,
			boolean appearsInQuestLog, String title, String questInfo, String worldInfoLine,
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
		case "search":
			if (attempt.equals(getPossibilities().get(0).getButtonLabel())) {
				if (super.basicSkillCheck(player, Skill.PERCEPTION, 5)) {
					super.setNewFlag("success");
					super.setQuestInfo(
							"Du entdeckst die Katze in einem Busch und schnappst sie dir!<br>Bringe sie zurück zu Lolo!");
					super.setWorldInfoLine(
							"Du entdeckst die Katze in einem Busch und schnappst sie dir!<br>Bringe sie zurück zu Lolo!");

					super.clearPossibilities();

					Possibility p1 = new Possibility("Lolo die Katze zurückgeben.", "Lolo berichten", -1);
					Possibility p2 = new Possibility("Lolos Katze essen!.", "Katze essen!", -1);
					super.getPossibilities().add(p1);
					super.getPossibilities().add(p2);

				} else {
					super.setNewFlag("catch");
					super.setQuestInfo(
							"Du entdeckst die Katze allerdings etwas zu spät als sie sich bereits auf der Flucht befindet.<br>Wenn du sie jetzt Fangen willst musst du sehr schnell sein!");
					super.setWorldInfoLine(
							"Du entdeckst die Katze allerdings etwas zu spät als sie sich bereits auf der Flucht befindet.<br>Wenn du sie jetzt Fangen willst musst du sehr schnell sein!");

					Possibility p1 = new Possibility("Versuchen Lolos Katze zu fangen.", "Katze fangen", -1);

					super.clearPossibilities();
					super.getPossibilities().add(p1);
				}

			}
			break;

		case "catch":
			if (attempt.equals(getPossibilities().get(0).getButtonLabel())) {
				if (super.basicSkillCheck(player, Skill.AGILITY, 7)) {
					super.setNewFlag("success");

					super.setQuestInfo("Du schnappst sie dir!<br>Bringe sie zurück zu Lolo!");
					super.setWorldInfoLine("Du schnappst sie dir!<br>Bringe sie zurück zu Lolo!");

					super.clearPossibilities();

					Possibility p1 = new Possibility("Lolo die Katze zurückgeben.", "Lolo berichten!", -1);
					Possibility p2 = new Possibility("Lolos Katze essen!", "Katze essen!", -1);
					super.getPossibilities().add(p1);
					super.getPossibilities().add(p2);

				} else {
					super.setNewFlag("failure");

					super.setQuestInfo(
							"Du bist zu langsam, die Katze entkommt dir!<br>Du solltest Lolo bescheid sagen!");
					super.setWorldInfoLine(
							"Du bist zu langsam, die Katze entkommt dir!<br>Du solltest Lolo bescheid sagen!");

					super.clearPossibilities();

					Possibility p1 = new Possibility("Lolo sagen, dass du seine Katze verloren hast.", "Lolo berichten",
							-1);
					super.getPossibilities().add(p1);
				}
			}
			break;

		case "success":

			if (attempt.equals(getPossibilities().get(0).getButtonLabel())) {
				super.setQuestInfo("Lolo ist überglücklich, das du ihn mit seinem Liebsten wiedervereint hast!");
				super.setWorldInfoLine(
						"Lolo: \"Danke das du sie wiedergefunden hast! Hier das ist für dich! \" [ + 5 Gold]");
				player.getInventory().addGold(5);
				player.getExperience().addXp(100);
			}
			if (attempt.equals(getPossibilities().get(1).getButtonLabel())) {
				super.setQuestInfo(
						"Lolo ist Fassungslos, als er sieht wie du seine Katze bei lebendigem Leib verspeißt!");
				super.setWorldInfoLine(
						"Lolo ist Fassungslos, als er sieht wie du seine Katze bei lebendigem Leib verspeißt!");
				player.setHealth(1000);
			}

			super.clearPossibilities();

			super.setUpdateOnEnter(false);
			super.setActive(false);
			super.setFinished(true);

			break;

		case "failure":

			if (attempt.equals(getPossibilities().get(0).getButtonLabel())) {

				super.clearPossibilities();

				super.setQuestInfo("Lolo ist sehr traurig, die Katze war sein bester Freund");
				super.setWorldInfoLine("Lolo ist sehr traurig, die Katze war sein bester Freund");

				super.clearPossibilities();
				super.setUpdateOnEnter(false);
				super.setActive(false);
				super.setFinished(true);
			}
			break;
		}
		System.out.println(" LeaveUpdate - ActiveFalg: " + super.getActiveFlagName());
	}

	@Override
	public void update(Player player) {

		System.out.println(" EnterUpdate(Simple) - ActiveFalg: " + super.getActiveFlagName());
		if (super.isActive() == false && super.isFinished() == false) {
			super.setActive(true);
			super.setNewFlag("search");
		}

		System.out.println(" LeaveUpdate - ActiveFalg: " + super.getActiveFlagName());
	}
}
