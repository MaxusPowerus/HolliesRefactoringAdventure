package basic;

import java.util.ArrayList;

import QuestClasses.MainQuest01;
import QuestClasses.Quest;
import entities.Player;
import utilities.Coordinate;
import utilities.Flag;

public class QuestManager {
	ArrayList<Quest> quests;

	public QuestManager(Player player) {

		MainQuest01 mainQuest01 = new MainQuest01(player);

		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */// define & add Quests

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
