package utilities;

import java.util.ArrayList;
import java.util.Random;

import basic.GameManager;
import entities.Enemy;
import entities.Merchant;
import entities.NPC;
import entities.Victim;
import map.Biom;

public class Challenge {

	private boolean challengeCompleted;
	private NPC npc = null;
	private Container container = null;
	private Event event;
	private int challengeType;
	private Biom biom;

	int containerChance = 0;
	int enemyChance = 0;

	int victimChance = 0;
	int traderChance = 0;
	int eventChance = 0;

	public Challenge(Biom biom) {

		this.challengeCompleted = false;
		this.biom = biom;
		switch (biom) {
		case MEADOW:
			containerChance = 100;
			enemyChance = 100;
			victimChance = 100;
			traderChance = 100;
			eventChance = 100;
			break;
		case FOREST:
			containerChance = 100;
			enemyChance = 100;
			victimChance = 100;
			traderChance = 100;
			eventChance = 100;
			break;
		case DESERT:
			containerChance = 100;
			enemyChance = 100;
			victimChance = 100;
			traderChance = 100;
			eventChance = 100;
			break;
		case SWAMP:
			containerChance = 100;
			enemyChance = 100;
			victimChance = 100;
			traderChance = 100;
			eventChance = 100;
			break;
		case MOUNTAINS:
			containerChance = 100;
			enemyChance = 100;
			victimChance = 100;
			traderChance = 100;
			eventChance = 100;
			break;
		}

		chooseChallenge(100, containerChance, enemyChance, traderChance, eventChance, victimChance);
	}

	private boolean chooseChallenge(int challangeChance, int containerChance, int enemyChance, int traderChance,
			int eventChance, int victimChance) {

		Random Randy = new Random();
		SpecialRandom Chan = new SpecialRandom();

		if (Randy.nextInt(101) > challangeChance) {
			return false;
		}

		int[] challengeTypes = new int[] { containerChance, enemyChance, traderChance, eventChance };
		this.challengeType = Chan.pickRandom(challengeTypes);

		if (challengeType != 0 && challengeType != 1 && challengeType != 2 && challengeType != 3 && challengeType != 4)
			System.out.println("Invalid ChallengeType: " + challengeType);

		switch (challengeType) {
		// Callenge: Container
		case 0:
			container = new Container("random", "");
			// container.fill(100, 1.5);

			break;

		// Callenge NPCAngriff
		case 1:
			ArrayList<Enemy> enemies = new ArrayList<Enemy>();
			int lengthEnemy = GameManager.getInstance().getResourceManager().getEnemies().size();
			for (int i = 0; i < lengthEnemy; i++) {
				if (GameManager.getInstance().getResourceManager().getEnemies().get(i).getBiom() == null
						|| GameManager.getInstance().getResourceManager().getEnemies().get(i).getBiom() == biom) {
					enemies.add(GameManager.getInstance().getResourceManager().getEnemies().get(i));
				}
			}
			npc = enemies.get(Randy.nextInt(enemies.size()));

			break;

		// Callenge: Händler
		case 2:
			ArrayList<Merchant> merchants = new ArrayList<Merchant>();
			int lengthMerchants = GameManager.getInstance().getResourceManager().getMerchants().size();
			for (int i = 0; i < lengthMerchants; i++) {
				if (GameManager.getInstance().getResourceManager().getMerchants().get(i).getBiom() == null
						|| GameManager.getInstance().getResourceManager().getMerchants().get(i).getBiom() == biom) {
					merchants.add(GameManager.getInstance().getResourceManager().getMerchants().get(i));
				}
			}
			npc = merchants.get(Randy.nextInt(merchants.size()));

			break;
		// Challenge: Event
		// case 3:
		// ArrayList<Event> events = new ArrayList<Event>();
		// int lengthEvents =
		// GameManager.getInstance().getResourceManager().getMerchants().size() - 1;
		// event =
		// GameManager.getInstance().getResourceManager().getEvents().get(Randy.nextInt(lengthEvents));

		// break;

		// Callenge NPCBeute
		case 3:
			ArrayList<Victim> victims = new ArrayList<Victim>();
			int lengthVictim = GameManager.getInstance().getResourceManager().getVictims().size();
			for (int i = 0; i < lengthVictim; i++) {
				if (GameManager.getInstance().getResourceManager().getVictims().get(i).getBiom() == null
						|| GameManager.getInstance().getResourceManager().getVictims().get(i).getBiom() == biom) {
					victims.add(GameManager.getInstance().getResourceManager().getVictims().get(i));
				}
			}
			npc = victims.get(Randy.nextInt(victims.size()));
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

	public Event getEvent() {
		return event;
	}

}
