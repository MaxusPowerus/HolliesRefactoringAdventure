package utilities;

import java.util.Random;

import entities.NPC;
import map.Biom;

public class Challenge {

	private boolean challengeCompleted;
	private NPC npc = null;
	private Container container = null;
	int challangeType;
	private Biom biom;

	int containerChance = 0;

	public Challenge(Biom biom) {
		this.challengeCompleted = true;
		this.biom = biom;
		switch (biom) {
		case MEADOW:
			containerChance = 100;
			break;
		case FOREST:
			containerChance = 100;
			break;
		case DESERT:
			containerChance = 100;
			break;
		case SWAMP:
			containerChance = 100;
			break;
		case MOUNTAINS:
			containerChance = 100;
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
		this.challangeType = Chan.pickRandom(challengeTypes);

		switch (challangeType) {
		case 1:
			container = new Container("random", "");
			container.fill(100, 1.5);
			break;
		}
		return true;
	}

	public boolean isChallengeCompleted() {
		return challengeCompleted;
	}

	public NPC getNpc() {
		return npc;
	}

	public Container getContainer() {
		return container;
	}

}
