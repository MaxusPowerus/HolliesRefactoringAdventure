package entities;

import java.util.Random;

import QuestClasses.Quest;
import basic.Config;
import basic.GameManager;
import items.Food;
import items.Item;
import items.Note;
import items.Other;
import items.Outfit;
import items.Weapon;
import map.Direction;
import map.Map;
import map.MapField;
import utilities.Coordinate;
import utilities.Experience;
import utilities.Inventory;
import utilities.Skill;
import utilities.SkillSet;

public class Player {

	private String name;
	private double health;
	private Inventory inventory;

	private Experience experience;
	private int daysAlive;
	private Map currentMap;
	private MapField currentMapField;
	private Time time;
	private SkillSet skillSet;
	private Outfit outfit;
	private Weapon weapon;
	private Quest currentQuest;

	public Player(String name) {
		this.name = name;
		this.health = Config.PLAYER_HEALTH;
		this.inventory = new Inventory();
		this.experience = new Experience();
		this.daysAlive = 0;
		this.time = new Time(0);
		this.skillSet = new SkillSet();
		this.outfit = null;
		this.weapon = null;
	}

	public void setStartItems() {
		Weapon startWeapon = new Weapon("Stick", "Stock", 1, 1, 0);
		Outfit startOutfit = new Outfit("HolliesDress", "Hollys Lieblingskleid", 10, 0, 0, 0, 0, 0, 1, 0, 0, 1);
		Food startFood = new Food("StewGrandmaStyle", "Eintopf nach Omas Art", 1, 25, 0);
		Note startNote = new Note("LetterFromHolger01", "Nachricht von Holger",
				"Hey Holly!<br>Triff mich heute Abend im Wald!<br>Ich habe eine Überraschung für dich!<br>Dein Holger ;)",
				0, 0);
		Other startOther = new Other("HolliesTeddy", "SchrimplyPipples",
				"Hollies ältester und wichtigster Begleiter: Ein alter abgenutzter Teddybär!", 0, 0);

		Item speer = GameManager.getInstance().getResourceManager().getItemByUniqueName("Spear");
		Other angel = (Other) GameManager.getInstance().getResourceManager().getItemByUniqueName("FishingRod");

		inventory.add(startWeapon);
		inventory.add(startOutfit);
		inventory.add(startFood);
		inventory.add(startNote);
		inventory.add(startOther);

		inventory.add(speer);
		inventory.add(angel);

		inventory.addGold(50);

		this.equip(startWeapon);
		this.equip(startOutfit);
	}

	public void setMap(Map mainMap) {

		this.currentMap = mainMap;
		this.currentMapField = mainMap.getMapFieldByCoordinate(Config.MAP_SIZEX / 2, Config.MAP_SIZEY / 2);
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		if (health > 100)
			health = 100;
		this.health = health;
	}

	public Map getCurrentMap() {
		return currentMap;
	}

	public void setCurrentMap(Map currentMap) {
		this.currentMap = currentMap;
	}

	public String getName() {
		return name;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public Experience getExperience() {
		return experience;
	}

	public int getDaysAlive() {
		return daysAlive;
	}

	public MapField getCurrentMapField() {
		return currentMapField;
	}

	public Time getTime() {
		return time;
	}

	public SkillSet getSkillSet() {
		return skillSet;
	}

	public boolean canGo(Direction direction) {
		MapField currentField = this.currentMapField;
		Coordinate coordinate = currentField.getCoordinate();

		int posX = coordinate.getPosX();
		int posY = coordinate.getPosY();

		if (direction == Direction.NORTH)
			posY -= 1;
		if (direction == Direction.EAST)
			posX += 1;
		if (direction == Direction.SOUTH)
			posY += 1;
		if (direction == Direction.WEST)
			posX -= 1;

		Coordinate newCoordinate = new Coordinate(posX, posY);
		MapField newField = this.currentMap.getMapFieldByCoordinate(newCoordinate);

		return newField != null;
	}

	public void go(Direction direction) {

		MapField currentField = this.currentMapField;
		Coordinate coordinate = currentField.getCoordinate();

		int posX = coordinate.getPosX();
		int posY = coordinate.getPosY();

		if (direction == Direction.NORTH)
			posY -= 1;
		if (direction == Direction.EAST)
			posX += 1;
		if (direction == Direction.SOUTH)
			posY += 1;
		if (direction == Direction.WEST)
			posX -= 1;

		Coordinate newCoordinate = new Coordinate(posX, posY);
		MapField newField = this.currentMap.getMapFieldByCoordinate(newCoordinate);

		if (newField != null) {

			this.currentMapField = newField;
			this.currentMapField.getCoordinate().print();
			this.time.addHours(2);

			Quest quest = this.currentMapField.getQuest();
			if (quest != null) {
				quest.update(this);
			}
		}
	}

	public boolean hunt(Victim victim) {
		if (skillSet.getSkillValue(Skill.AGILITY) < victim.getSkillSet().getSkillValue(Skill.AGILITY)) {
			return saveMe();
		} else {
			return true;
		}
	}

	public int getHuntChance(Victim victim) {
		int chance = 100
				- (victim.getSkillSet().getSkillValue(Skill.AGILITY) - skillSet.getSkillValue(Skill.AGILITY)) * 15;
		if (chance > 95) {
			chance = 95;
		} else {
			chance = 5;
		}
		return chance;
	}

	public boolean fight(Enemy enemy) {

		Random Randy = new Random();

		int playerFight = skillSet.getSkillValue(Skill.STRENGTH) + skillSet.getSkillValue(Skill.AGILITY);
		int enemyFight = enemy.getSkillSet().getSkillValue(Skill.STRENGTH)
				+ enemy.getSkillSet().getSkillValue(Skill.AGILITY);
		double playerDmg = 0;
		if (this.weapon != null)
			playerDmg = this.weapon.getDamage();
		if (this.weapon == null) {
			playerDmg = skillSet.getSkillValue(Skill.STRENGTH) / 2;
			if (playerDmg <= 0) {
				playerDmg = 1;
			}

		}
		double enemyDmg = enemy.getDamage();
		int threshold = 20;
		double enemyHealth = enemy.getHealth();
		double dmgFacPlayer = 1;
		double dmgFacEnemy = 1;

		if (playerFight > enemyFight) {
			dmgFacPlayer += playerFight - enemyFight;
		} else {
			dmgFacEnemy += enemyFight - playerFight;
		}

		int round = 1;

		// System.out.println("playerFight: " + playerFight + " playerDmg: " +
		// playerDmg);
		// System.out.println("enemieFight: " + enemyFight + " enemieDmg: " + enemyDmg);

		while (true) {
			// System.out.println("PlayerHP: " + this.health + "EnemyHP:" + enemyHealth);
			// System.out.println("Runde: " + round);

			// Player ist am Zug
			if (Randy.nextInt(threshold) <= skillSet.getSkillValue(Skill.LUCK)) {
				enemyHealth -= playerDmg * dmgFacPlayer;
			}
			if (enemyHealth <= 0) {
				break;
			}

			// System.out.println("Player - dmgFac: " + dmgFac);

			// Enemy ist am Zug
			if (Randy.nextInt(threshold) <= enemy.getSkillSet().getSkillValue(Skill.LUCK)) {
				this.health -= enemyDmg * dmgFacEnemy;
			}
			if (this.health <= 0) {
				break;
			}
			// System.out.println("Enemy - dmgFac: " + dmgFac);

			round++;
		}
		if (health > 0) {
			this.experience.addXp(enemy.getXp());
			return true;
		} else {
			return false;
		}

	}

	public int getFightChance(Enemy enemy) {
		int chance = 50;

		int playerFight = skillSet.getSkillValue(Skill.STRENGTH) + skillSet.getSkillValue(Skill.AGILITY);
		int enemyFight = enemy.getSkillSet().getSkillValue(Skill.STRENGTH)
				+ enemy.getSkillSet().getSkillValue(Skill.AGILITY);
		double playerDmg = 0;
		if (this.weapon != null)
			playerDmg = this.weapon.getDamage();
		if (this.weapon == null) {
			playerDmg = skillSet.getSkillValue(Skill.STRENGTH) / 2;
			if (playerDmg <= 0) {
				playerDmg = 1;
			}

		}
		double enemyDmg = enemy.getDamage();
		int ChanceFac = 15;
		double enemyHealth = enemy.getHealth();
		double dmgFacPlayer = 1;
		double dmgFacEnemy = 1;

		if (playerFight > enemyFight) {
			dmgFacPlayer += playerFight - enemyFight;
		} else {
			dmgFacEnemy += enemyFight - playerFight;
		}

		int needRoundsPlayer = (int) (this.health / (enemyDmg * dmgFacEnemy));
		int needRoundsEnemy = (int) (enemyHealth / (playerDmg * dmgFacPlayer));

		return chance + (needRoundsPlayer - needRoundsEnemy) * ChanceFac;
	}

	public int getFleeChance(Enemy enemy) {
		int chance = 100
				- (enemy.getSkillSet().getSkillValue(Skill.AGILITY) - skillSet.getSkillValue(Skill.AGILITY)) * 15;
		if (chance > 95) {
			chance = 95;
		} else {
			chance = 5;
		}
		return chance;
	}

	public boolean flee(Enemy enemy) {

		if (enemy.getSkillSet().getSkillValue(Skill.AGILITY) < skillSet.getSkillValue(Skill.AGILITY)) {
			return saveMe();
		} else {
			return true;
		}
	}

	public boolean saveMe() {
		Random Randy = new Random();

		if (Randy.nextInt(10) < skillSet.getSkillValue(Skill.LUCK)) {
			System.out.println("saveMe +");
			return true;
		} else {
			System.out.println("saveMe -");
			return false;
		}
	}

	public void equip(Item item) {
		if ((item instanceof Weapon && this.weapon == null)) {
			this.weapon = (Weapon) item;
		}
		if ((item instanceof Outfit && this.outfit == null)) {
			this.outfit = (Outfit) item;
			((Outfit) item).getOutfitFx().onEquipping(this);
		}
	}

	public void dequip(Item item) {
		if (item == null)
			return;
		if (this.weapon != null && this.weapon.equals(item))
			this.weapon = null;
		if (this.outfit != null && this.outfit.equals(item)) {
			this.outfit = null;
			((Outfit) item).getOutfitFx().onDequipping(this);
		}
	}

	public boolean isEquipped(Item item) {
		return item.equals(this.weapon) || item.equals(this.outfit);
	}

	public boolean isWeaponEquipped() {
		return this.weapon != null;
	}

	public boolean isOutfitEquipped() {
		return this.outfit != null;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public Outfit getOutfit() {
		return outfit;
	}

}
