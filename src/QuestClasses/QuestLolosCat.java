package QuestClasses;

import java.util.ArrayList;

import entities.Player;
import utilities.Coordinate;
import utilities.Flag;
import utilities.Skill;

public class QuestLolosCat extends Quest {
	public QuestLolosCat(int instanceLimit, Coordinate targetPoint, ArrayList<Coordinate> targetZone,
			boolean updateOnEnter, boolean appearsInQuestLog, String title, String questInfo, String worldInfoLine,
			ArrayList<String> possibilities, ArrayList<String> possibilitiesButtonlabels,
			ArrayList<Integer> possibilitiesChances, ArrayList<Flag> flags) {
		super(instanceLimit, targetPoint, targetZone, updateOnEnter, appearsInQuestLog, title, questInfo, worldInfoLine,
				possibilities, possibilitiesButtonlabels, possibilitiesChances, flags);

	}

	@Override
	public void update(String attempt, Player player) {

		System.out.println(" EnterUpdate - ActiveFalg: " + super.getActiveFlagName());

		switch (getActiveFlagName()) {
		case "search":
			if (attempt.equals(getPossibilitiesButtonlabels().get(0))) {
				if (player.getSkillSet().getSkillValue(Skill.PERCEPTION) >= 9) {
					super.setNewFlag("success");
					super.setQuestInfo(
							"Du entdeckst die Katze in einem Busch und schnappst sie dir!<br>Bringe sie zurück zu Lolo!");
					super.setWorldInfoLine(
							"Du entdeckst die Katze in einem Busch und schnappst sie dir!<br>Bringe sie zurück zu Lolo!");

					super.clearPossibilities();

					super.getPossibilitiesChances().add(-1);
					super.getPossibilitiesChances().add(-1);
					super.getPossibilities().add("Lolo die Katze zurückgeben.");
					super.getPossibilities().add("Lolos Katze essen!.");
					super.getPossibilitiesButtonlabels().add("Lolo berichten!");
					super.getPossibilitiesButtonlabels().add("Katze essen!");

				} else {
					super.setNewFlag("catch");
					super.setQuestInfo(
							"Du entdeckst die Katze allerdings etwas zu spät als sie sich bereits auf der Flucht befindet.<br>Wenn du sie jetzt Fangen willst musst du sehr schnell sein!");
					super.setWorldInfoLine(
							"Du entdeckst die Katze allerdings etwas zu spät als sie sich bereits auf der Flucht befindet.<br>Wenn du sie jetzt Fangen willst musst du sehr schnell sein!");

					super.clearPossibilities();
					super.getPossibilitiesChances().add(-1);
					super.getPossibilities().add("Versuchen Lolos Katze zu fangen.");
					super.getPossibilitiesButtonlabels().add("Katze fangen");
				}

			}
			break;

		case "catch":
			if (attempt.equals(getPossibilitiesButtonlabels().get(0))) {
				if (player.getSkillSet().getSkillValue(Skill.AGILITY) >= 5) {
					super.setNewFlag("success");

					super.setQuestInfo("Du schnappst sie dir!<br>Bringe sie zurück zu Lolo!");
					super.setWorldInfoLine("Du schnappst sie dir!<br>Bringe sie zurück zu Lolo!");

					super.clearPossibilities();

					super.getPossibilitiesChances().add(-1);
					super.getPossibilitiesChances().add(-1);
					super.getPossibilities().add("Lolo die Katze zurückgeben.");
					super.getPossibilities().add("Lolos Katze essen!.");
					super.getPossibilitiesButtonlabels().add("Lolo berichten!");
					super.getPossibilitiesButtonlabels().add("Katze essen!");

				} else {
					super.setNewFlag("failure");

					super.setQuestInfo(
							"Du bist zu langsam, die Katze entkommt dir!<br>Du solltest Lolo bescheid sagen!");
					super.setWorldInfoLine(
							"Du bist zu langsam, die Katze entkommt dir!<br>Du solltest Lolo bescheid sagen!");

					super.clearPossibilities();

					super.getPossibilitiesChances().add(-1);
					super.getPossibilities().add("Lolo sagen, dass du seine Katze verloren hast.");
					super.getPossibilitiesButtonlabels().add("Lolo berichten");
				}
			}
			break;

		case "success":

			if (attempt.equals(getPossibilitiesButtonlabels().get(0))) {
				super.setQuestInfo("Lolo ist überglücklich, das du ihn mit seinem Liebsten wiedervereint hast!");
				super.setWorldInfoLine("Lolo ist überglücklich, das du ihn mit seinem Liebsten wiedervereint hast!");
				player.getExperience().addXp(100);
			}
			if (attempt.equals(getPossibilitiesButtonlabels().get(1))) {
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

			if (attempt.equals(getPossibilitiesButtonlabels().get(0))) {

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
