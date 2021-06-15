package map;

import QuestClasses.Quest;
import utilities.Challenge;
import utilities.Container;
import utilities.Coordinate;

public class MapField {

	private Coordinate coordinate;
	private boolean disabled;
	private Biom biom;
	private Challenge challenge;
	private Quest quest;

	private Container container = null;
	private Map subMap;

	public MapField(Coordinate coordinate, Biom biom) {
		this.coordinate = coordinate;
		this.disabled = false;
		this.biom = biom;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public Map getSubMap() {
		return subMap;
	}

	public void setSubMap(Map subMap) {
		this.subMap = subMap;
	}

	public Biom getBiom() {
		return biom;
	}

	public void setBiom(Biom biom) {
		this.biom = biom;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public Container getContainer() {
		if (container == null) {
			return null;
		} else {
			return container;
		}
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}

	public Challenge getChallenge() {
		return challenge;
	}

	public Quest getQuest() {
		return quest;
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}

}
