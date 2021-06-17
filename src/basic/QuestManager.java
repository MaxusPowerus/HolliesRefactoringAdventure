package basic;

import java.util.ArrayList;

import QuestClasses.MainQuest01;
import QuestClasses.Quest;
import QuestClasses.QuestLolosCat;
import QuestClasses.QuestPattern;
import entities.Player;
import utilities.Coordinate;
import utilities.Flag;

public class QuestManager {
	ArrayList<Quest> quests;

	public QuestManager(Player player) {
		quests = new ArrayList<Quest>();

		// quests.add(initQuestPattern());
		quests.add(initLolosCat());
	}

	public QuestPattern initQuestPattern() {
		int il = 1; // instanceLimit
		Coordinate tp = new Coordinate(Config.MAP_SIZEX / 2, Config.MAP_SIZEY / 2 + 1);
		ArrayList<Coordinate> tz = null;
		boolean uoe = true;
		boolean aiql = true;
		String t = "title";
		String qi = "questInfo";
		String wil = "worldInfoLine";

		ArrayList<String> p = new ArrayList<String>();
		String p1 = "possibilitie01";
		p.add(p1);
		ArrayList<String> pb = new ArrayList<String>();
		String pb1 = "possibilitiesButtonlabel01";
		pb.add(pb1);
		ArrayList<Integer> pc = new ArrayList<Integer>();
		int pc1 = -1; // possibilitiesChance01
		pc.add(pc1);

		ArrayList<Flag> f = new ArrayList<Flag>();
		Flag f0 = new Flag("firstFlag");
		Flag f1 = new Flag("secondFlag");
		Flag f2 = new Flag("thirdFlag");
		f.add(f0);
		f.add(f1);
		f.add(f2);

		QuestPattern questPattern = new QuestPattern(il, tp, tz, uoe, aiql, t, qi, wil, p, pb, pc, f);
		return questPattern;
	}

	public QuestLolosCat initLolosCat() {
		int il = 1;
		Coordinate tp = new Coordinate(Config.MAP_SIZEX / 2, Config.MAP_SIZEY / 2 + 1);
		ArrayList<Coordinate> tz = null;
		boolean uoe = true;
		boolean aiql = true;
		String t = "Lolos Katze";
		String qi = "Du triffst auf Lol, der dir berichtet, das seine Katzte davon gelaufen ist. Er bittet dich um Hilfe be der Suche.";
		String wil = "Lollo: \"Hallo kannst du mir hlefen meine Katze zu finden?\"";

		ArrayList<String> p = new ArrayList<String>();
		String p1 = "Nach Lolos Katze suchen";
		p.add(p1);
		ArrayList<String> pb = new ArrayList<String>();
		String pb1 = "Katze suchen!";
		pb.add(pb1);
		ArrayList<Integer> pc = new ArrayList<Integer>();
		int pc1 = -1;
		pc.add(pc1);

		ArrayList<Flag> f = new ArrayList<Flag>();
		Flag f0 = new Flag("search");
		Flag f1 = new Flag("success");
		Flag f2 = new Flag("catch");
		Flag f3 = new Flag("failure");
		f.add(f0);
		f.add(f1);
		f.add(f2);
		f.add(f3);

		QuestLolosCat qestLolosCat = new QuestLolosCat(il, tp, tz, uoe, aiql, t, qi, wil, p, pb, pc, f);
		return qestLolosCat;
	}

	public ArrayList<Quest> getQuests() {
		return quests;
	}

	public ArrayList<Quest> getActiveQuests() {
		ArrayList<Quest> activeQuests = new ArrayList<Quest>();
		for (int i = 0; i < quests.size(); i++) {
			if (quests.get(i).isActive()) {
				activeQuests.add(quests.get(i));
			}
		}
		return activeQuests;
	}

	public ArrayList<Quest> getFinishedQuests() {
		ArrayList<Quest> finishedQuests = new ArrayList<Quest>();
		for (int i = 0; i < quests.size(); i++) {
			if (quests.get(i).isFinished()) {
				finishedQuests.add(quests.get(i));
			}
		}
		return finishedQuests;
	}

}
