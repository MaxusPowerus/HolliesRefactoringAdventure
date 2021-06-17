package basic;

import java.util.ArrayList;

import QuestClasses.Quest;
import QuestClasses.QuestFishingMeadow;
import QuestClasses.QuestFishingSwamp;
import QuestClasses.QuestLolosCat;
import QuestClasses.QuestPattern;
import entities.Player;
import map.Biom;
import utilities.Coordinate;
import utilities.Flag;

public class QuestManager {
	ArrayList<Quest> quests;
	ArrayList<Quest> mainQuests;

	public QuestManager(Player player) {
		quests = new ArrayList<Quest>();
		mainQuests = new ArrayList<Quest>();

		// quests.add(initQuestPattern());
		quests.add(initLolosCat());
		quests.add(initQuestFishingMeadow());
		quests.add(initQuestFishingSwamp());
	}

	public QuestPattern initQuestPattern() {
		int il = 1; // instanceLimit
		Coordinate tp = null;
		ArrayList<Coordinate> tz = null;
		Biom b = null; // null = Rabdom Biom

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

		QuestPattern questPattern = new QuestPattern(il, tp, tz, b, uoe, aiql, t, qi, wil, p, pb, pc, f);
		return questPattern;
	}

	public QuestLolosCat initLolosCat() {
		int il = 1;
		Coordinate tp = null;
		ArrayList<Coordinate> tz = null;
		Biom b = null;
		boolean uoe = true;
		boolean aiql = true;
		String t = "Lolos Katze";
		String qi = "Du triffst auf Lol, der dir berichtet, das seine Katzte davon gelaufen ist. Er bittet dich um Hilfe be der Suche.";
		String wil = "Lollo: \"Hallo kannst du mir helfen meine Katze zu finden?\"";

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

		QuestLolosCat qeustLolosCat = new QuestLolosCat(il, tp, tz, b, uoe, aiql, t, qi, wil, p, pb, pc, f);
		return qeustLolosCat;
	}

	public QuestFishingMeadow initQuestFishingMeadow() {
		int il = Config.MAP_SIZEX; // instanceLimit
		Coordinate tp = null;
		ArrayList<Coordinate> tz = null;
		Biom b = Biom.MEADOW;

		boolean uoe = true;
		boolean aiql = false;
		String t = "FischenWiese";
		String qi = "questInfo";
		String wil = "Du kommst an einen Fluss, in dem es vor Fischen nur so wimmelt. <br> Wenn du einen fängst, würde das ein brächtiges Abendesen abgeben!";

		ArrayList<String> p = new ArrayList<String>();
		String p1 = "Mit einem Angel fischen";
		p.add(p1);
		String p2 = "Mit einer Speer fischen";
		p.add(p2);
		ArrayList<String> pb = new ArrayList<String>();
		String pb1 = "Angeln";
		pb.add(pb1);
		String pb2 = "Speerfischen";
		pb.add(pb2);
		ArrayList<Integer> pc = new ArrayList<Integer>();
		int pc1 = -1; // possibilitiesChance01
		pc.add(pc1);
		int pc2 = -1; // possibilitiesChance01
		pc.add(pc2);

		ArrayList<Flag> f = new ArrayList<Flag>();
		Flag f0 = new Flag("fishing");
		Flag f1 = new Flag("empty");
		f.add(f0);
		f.add(f1);

		QuestFishingMeadow questFishingMeadow = new QuestFishingMeadow(il, tp, tz, b, uoe, aiql, t, qi, wil, p, pb, pc,
				f);
		return questFishingMeadow;
	}

	public QuestFishingSwamp initQuestFishingSwamp() {
		int il = Config.MAP_SIZEX; // instanceLimit
		Coordinate tp = null;
		ArrayList<Coordinate> tz = null;
		Biom b = Biom.SWAMP;

		boolean uoe = true;
		boolean aiql = false;
		String t = "FischenSumpf";
		String qi = "questInfo";
		String wil = "Du kommst an einen Fluss, in dem es vor Fischen nur so wimmelt. <br> Wenn du einen fängst, würde das ein brächtiges Abendesen abgeben!";

		ArrayList<String> p = new ArrayList<String>();
		String p1 = "Mit einem Angel fischen";
		p.add(p1);
		String p2 = "Mit einer Speer fischen";
		p.add(p2);
		ArrayList<String> pb = new ArrayList<String>();
		String pb1 = "Angeln";
		pb.add(pb1);
		String pb2 = "Speerfischen";
		pb.add(pb2);
		ArrayList<Integer> pc = new ArrayList<Integer>();
		int pc1 = -1; // possibilitiesChance01
		pc.add(pc1);
		int pc2 = -1; // possibilitiesChance01
		pc.add(pc2);

		ArrayList<Flag> f = new ArrayList<Flag>();
		Flag f0 = new Flag("fishing");
		Flag f1 = new Flag("empty");
		f.add(f0);
		f.add(f1);

		QuestFishingSwamp questFishingSwamp = new QuestFishingSwamp(il, tp, tz, b, uoe, aiql, t, qi, wil, p, pb, pc, f);
		return questFishingSwamp;
	}

	public ArrayList<Quest> getQuests() {
		return quests;
	}

	public ArrayList<Quest> getMainQuests() {
		return mainQuests;
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

	public ArrayList<Quest> getQuestsByBiom(Biom biom) {
		ArrayList<Quest> questsByBiom = new ArrayList<Quest>();
		for (int i = 0; i < quests.size(); i++) {
			if (quests.get(i).getBiom() == biom) {
				for (int j = 0; j < quests.get(i).getInstanceLimit(); j++) {
					questsByBiom.add(quests.get(i));
				}
			}
		}
		return questsByBiom;
	}

	public ArrayList<Quest> getAllQuests() {
		ArrayList<Quest> allQuests = new ArrayList<Quest>();
		for (int i = 0; i < quests.size(); i++) {
			allQuests.add(quests.get(i));
		}
		for (int j = 0; j < mainQuests.size(); j++) {
			allQuests.add(mainQuests.get(j));
		}
		return allQuests;
	}

}
