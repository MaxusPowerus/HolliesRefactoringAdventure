package utilities;

import java.util.ArrayList;
import java.util.Random;

import basic.GameManager;
import entities.Enemy;
import entities.NPC;
import map.Biom;

public class Challenge {

	private boolean challengeCompleted;
	private NPC npc = null;
	private Container container = null;
	private int challengeType;
	private Biom biom;

	int containerChance = 0;
	int enemyChance = 0;

	public Challenge(Biom biom) {

		this.challengeCompleted = false;
		this.biom = biom;
		switch (biom) {
		case MEADOW:
			containerChance = 0;
			enemyChance = 100;
			break;
		case FOREST:
			containerChance = 0;
			enemyChance = 100;
			break;
		case DESERT:
			containerChance = 0;
			enemyChance = 100;
			break;
		case SWAMP:
			containerChance = 0;
			enemyChance = 100;
			break;
		case MOUNTAINS:
			containerChance = 0;
			enemyChance = 100;
			break;
		}

		chooseChallenge(100, containerChance, enemyChance);
	}

	private boolean chooseChallenge(int challangeChance, int containerChance, int enemyChance) {
		Random Randy = new Random();
		MyRandom Chan = new MyRandom();

		if (Randy.nextInt(101) > challangeChance) {
			return false;
		}

		int[] challengeTypes = new int[] { containerChance, enemyChance };
		this.challengeType = Chan.pickRandom(challengeTypes);

		switch (challengeType) {

		case 0:
			container = new Container("random", "");
			container.fill(100, 1.5);
			break;

		case 1:
			ArrayList<Enemy> enemies = new ArrayList<Enemy>();
			int length = GameManager.getInstance().getResourceManager().getEnemies().size();
			for (int i = 0; i < length; i++) {
				if (GameManager.getInstance().getResourceManager().getEnemies().get(i).getBiom() == null
						|| GameManager.getInstance().getResourceManager().getEnemies().get(i).getBiom() == biom) {
					enemies.add(GameManager.getInstance().getResourceManager().getEnemies().get(i));
				}
			}
			npc = enemies.get(Randy.nextInt(enemies.size()));
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

	public int getChallangeType() {
		return challengeType;
	}

	public void setChallengeCompleted(boolean challengeCompleted) {
		this.challengeCompleted = challengeCompleted;
	}

	public Biom getBiom() {
		return biom;
	}

}
