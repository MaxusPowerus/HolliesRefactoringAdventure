package basic;

import java.util.ArrayList;

import QuestClasses.Possibility;
import QuestClasses.Quest;
import QuestClasses.QuestFishingMeadow;
import QuestClasses.QuestFishingSwamp;
import QuestClasses.QuestLolosCat;
import QuestClasses.QuestPattern;
import QuestClasses.QuestPoorTrader;
import QuestClasses.QuestPoorTraderTrigger;
import entities.Player;
import map.Biom;
import utilities.Coordinate;
import utilities.Flag;

public class QuestManager {
	ArrayList<Quest> quests;
	ArrayList<Quest> mainQuests;
	ArrayList<Quest> questWithCoordinates;

	public QuestManager(Player player) {
		quests = new ArrayList<Quest>();
		mainQuests = new ArrayList<Quest>();
		questWithCoordinates = new ArrayList<Quest>();

		// quests.add(initQuestPattern());
		quests.add(initLolosCat());
		quests.add(initQuestFishingMeadow());
		quests.add(initQuestFishingSwamp());
		questWithCoordinates.add(initQuestPoorTraderTrigger());
		// questWithCoordinates.add(initQuestPoorTrader());
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

		ArrayList<Possibility> p = new ArrayList<Possibility>();
		Possibility p1 = new Possibility("possibilitie01", "possibilitiesButtonlabel01", -1);

		ArrayList<Flag> f = new ArrayList<Flag>();
		Flag f0 = new Flag("firstFlag");
		Flag f1 = new Flag("secondFlag");
		Flag f2 = new Flag("thirdFlag");
		f.add(f0);
		f.add(f1);
		f.add(f2);

		QuestPattern questPattern = new QuestPattern(il, tp, tz, b, uoe, aiql, t, qi, wil, p, f);
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

		ArrayList<Possibility> p = new ArrayList<Possibility>();
		Possibility p1 = new Possibility("Katze suchen!", "Nach Lolos Katze suchen", -1);

		ArrayList<Flag> f = new ArrayList<Flag>();
		Flag f0 = new Flag("search");
		Flag f1 = new Flag("success");
		Flag f2 = new Flag("catch");
		Flag f3 = new Flag("failure");
		f.add(f0);
		f.add(f1);
		f.add(f2);
		f.add(f3);

		QuestLolosCat qeustLolosCat = new QuestLolosCat(il, tp, tz, b, uoe, aiql, t, qi, wil, p, f);
		return qeustLolosCat;
	}

	public QuestFishingMeadow initQuestFishingMeadow() {
		int il = Config.MAP_SIZEX * 5; // instanceLimit
		Coordinate tp = null;
		ArrayList<Coordinate> tz = null;
		Biom b = Biom.MEADOW;

		boolean uoe = true;
		boolean aiql = false;
		String t = "FischenWiese";
		String qi = "questInfo";
		String wil = "Du kommst an einen Fluss, in dem es vor Fischen nur so wimmelt. <br> Wenn du einen fängst, würde das ein brächtiges Abendesen abgeben!";

		ArrayList<Possibility> p = new ArrayList<Possibility>();
		Possibility p1 = new Possibility("Angeln", "Mit einem Angel fischen", -1);
		Possibility p2 = new Possibility("Speerfischen", "Mit einer Speer fischen", -1);

		ArrayList<Flag> f = new ArrayList<Flag>();
		Flag f0 = new Flag("fishing");
		Flag f1 = new Flag("empty");
		f.add(f0);
		f.add(f1);

		QuestFishingMeadow questFishingMeadow = new QuestFishingMeadow(il, tp, tz, b, uoe, aiql, t, qi, wil, p, f);
		return questFishingMeadow;
	}

	public QuestFishingSwamp initQuestFishingSwamp() {
		int il = 5; // instanceLimit
		Coordinate tp = null;
		ArrayList<Coordinate> tz = null;
		Biom b = Biom.SWAMP;

		boolean uoe = true;
		boolean aiql = false;
		String t = "FischenSumpf";
		String qi = "questInfo";
		String wil = "Du kommst an einen Fluss, in dem es vor Fischen nur so wimmelt. <br> Wenn du einen fängst, würde das ein brächtiges Abendesen abgeben!";

		ArrayList<Possibility> p = new ArrayList<Possibility>();
		Possibility p1 = new Possibility("Angeln", "Mit einem Angel fischen", -1);
		Possibility p2 = new Possibility("Speerfischen", "Mit einer Speer fischen", -1);

		ArrayList<Flag> f = new ArrayList<Flag>();
		Flag f0 = new Flag("fishing");
		Flag f1 = new Flag("empty");
		f.add(f0);
		f.add(f1);

		QuestFishingSwamp questFishingSwamp = new QuestFishingSwamp(il, tp, tz, b, uoe, aiql, t, qi, wil, p, f);
		return questFishingSwamp;
	}

	public QuestPoorTraderTrigger initQuestPoorTraderTrigger() {
		int il = 1; // instanceLimit

		Coordinate tp = new Coordinate(Config.MAP_SIZEX / 2, Config.MAP_SIZEY / 2 + 1);
		ArrayList<Coordinate> tz = null;
		Biom b = null; // null = Random Biom

		boolean uoe = true;
		boolean aiql = true;
		String t = "Eine falsche Entscheidung";
		String qi = "Du triffst auf Theodoras, er bereut es ein altes Familienerbstück an einen Händler verkauft zu haben. Er bittet dich um Hilfe und sagt, dass der Händler Richtung Osten gezogen ist.";
		String wil = "Theodoras: \"Hilf mir ich habe das Amulett meiner Mutter verkauft aber es war ein großer Fehler. Der händler ist Richtung Osten gegangen, bitte hole es zurück, es bedeutet mir Alles!\"";

		ArrayList<Possibility> p = new ArrayList<Possibility>();
		Possibility p1 = new Possibility("Bin Unterwegs!", "Alles klar, ich werde sehen was ich tun kann!", -1);

		ArrayList<Flag> f = new ArrayList<Flag>();
		Flag f0 = new Flag("start");
		Flag f1 = new Flag("wait");
		Flag f2 = new Flag("stillWait");
		Flag f3 = new Flag("success");
		Flag f4 = new Flag("failure");
		f.add(f0);
		f.add(f1);
		f.add(f2);
		f.add(f3);
		f.add(f4);

		QuestPoorTraderTrigger questPoorTraderTrigger = new QuestPoorTraderTrigger(il, tp, tz, b, uoe, aiql, t, qi, wil,
				p, f);
		return questPoorTraderTrigger;
	}

	public ArrayList<Quest> getQuests() {
		return quests;
	}

	public ArrayList<Quest> getMainQuests() {
		return mainQuests;
	}

	public ArrayList<Quest> getQuestWithCoordinates() {
		return questWithCoordinates;
	}

	public Quest getQuestByTitle(String title) {
		ArrayList<Quest> quests = getAllQuests();
		for (int i = 0; i < quests.size(); i++) {
			if (quests.get(i).getTitle().equals(title)) {
				return quests.get(i);
			}
			// System.out.println("title: " + title + " QuestName: " +
			// quests.get(i).getTitle());
		}
		System.out.println("quest ist NULL");
		return null;
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
		for (int j = 0; j < questWithCoordinates.size(); j++) {
			allQuests.add(questWithCoordinates.get(j));
		}
		return allQuests;
	}

}
