package utilities;

import java.util.Random;

import entities.NPC;
import map.Biom;

public class Challenge {

	private boolean challengeActive;
	private NPC npc = null;
	private Container container = null;
	private Biom biom;

	int containerChance = 0;

	public Challenge(Biom biom) {
		this.biom = biom;
		switch (biom) {
		case MEADOW:
			containerChance = 50;
			break;
		case FOREST:
			containerChance = 60;
			break;
		case DESERT:
			containerChance = 5;
			break;
		case SWAMP:
			containerChance = 55;
			break;
		case MOUNTAINS:
			containerChance = 30;
			break;
		}

		chooseChallenge(100, 100);
	}

	public boolean chooseChallenge(int challangeChance, int containerChance) {
		Random Randy = new Random();
		MyRandom Chan = new MyRandom();

		if (Randy.nextInt(101) > challangeChance) {
			return false;
		}

		int[] challengeTypes = new int[] { containerChance };
		int challangeType = Chan.pickRandom(challengeTypes);

		switch (challangeType) {
		case 1:
			container = new Container("random", "");
			container.fill(100, 1.5);
			break;
		}
		return true;
	}

	public boolean getChallengeActive() {
		return challengeActive;
	}

	public NPC getNpc() {
		return npc;
	}

	public Container getContainer() {
		return container;
	}

}
