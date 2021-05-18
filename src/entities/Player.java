package entities;

import basic.Config;
import items.Food;
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
	private Inventory equipped;

	private Experience experience;
	private int daysAlive;
	private Map currentMap;
	private MapField currentMapField;
	private Time time;
	private SkillSet skillSet;

	public Player(String name, Map mainMap) {
		this.name = name;
		this.health = Config.PLAYER_HEALTH;
		this.inventory = new Inventory();
		this.equipped = new Inventory();
		this.experience = new Experience();
		this.daysAlive = 0;
		this.currentMap = mainMap;
		this.currentMapField = mainMap.getMapFieldByCoordinate(Config.MAP_SIZEX / 2, Config.MAP_SIZEY / 2);
		this.time = new Time(0);
		this.skillSet = new SkillSet();

		// Set StartInventory
<<<<<<< HEAD
		Weapon startWeapon = new Weapon("Stick", "Stock", 1, 1);
		Outfit startOutfit = new Outfit("HolliesDress", "Hollys Lieblingskleid", 0, 10);
		Food startFood = new Food("StewGrandmaStyle", "Eintopf nach Omas Art", 25, 1);
		Note startNote = new Note("LetterFromHolger01", "Nachricht von Holger",
				"Hey Holly!\nTriff mich heute Abend im Wald!\nIch habe eine Überraschung für dich!\nDein Holger <3", 0);
		Other startOther = new Other("HolliesTeddy", "SchrimplyPipples",
				"Hollies ältester und wichtigster Begleiter: Ein alter abgenutzter Teddybär!", 0);
=======
		Weapon startWeapon = new Weapon("Stick", "Stock", 1, 0);
		Outfit startOutfit = new Outfit("HolliesDress", "Hollys Lieblingskleid", 0, 10);
		Food startFood = new Food("StewGrandmaStyle", "Eintopf nach Omas Art", 25, 1);
		Note startNote = new Note("LetterFromHolger01", "Nachricht von Holger",
				"Hey Holly!<br>Triff mich heute Abend im Wald!<br>Ich habe eine Überraschung für dich!<br>Dein Holger <3",
				0);
>>>>>>> a2336b140edc7b0a4b9a7c17ead4ce5825b83358

		inventory.add(startWeapon);
		inventory.add(startOutfit);
		inventory.add(startFood);
		inventory.add(startNote);
		inventory.add(startOther);
		;

		inventory.addGold(5);

		// ==============================================================================================
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
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

	public Weapon equippedWeapon() {

		for (int i = 0; i < equipped.getAllItems().size(); i++) {
			if (equipped.getAllItems().get(i) instanceof Weapon) {
				return (Weapon) equipped.getAllItems().get(i);
			}

		}
		return null;
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
		System.out.println("Gehe nach " + direction.getName());

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
		} else {
			System.out.println("no move");
		}
	}

	public boolean fight(Enemy enemy) {
		int playerFight = skillSet.getSkillValue(Skill.STRENGTH) + skillSet.getSkillValue(Skill.AGILITY) / 2;
		int enemyFight = enemy.getSkillSet().getSkillValue(Skill.STRENGTH)
				+ enemy.getSkillSet().getSkillValue(Skill.AGILITY) / 2;
		double playerDmg = 0;
		if (equippedWeapon() != null)
			playerDmg = equippedWeapon().getDamage();
		if (equippedWeapon() == null) {
			playerDmg = skillSet.getSkillValue(Skill.STRENGTH) / 2;
			if (playerDmg <= 0) {
				playerDmg = 1;
			}

		}
		double enemyDmg = enemy.getDamage();
		double dmgFac = 1;
		double enemyHealth = enemy.getHealth();

		int round = 1;

		System.out.println("playerFight: " + playerFight + " playerDmg: " + playerDmg);
		System.out.println("enemieFight: " + enemyFight + " enemieDmg: " + enemyDmg);

		while (true) {
			System.out.println("PlayerHP: " + this.health + "EnemyHP:" + enemyHealth);
			System.out.println("Runde: " + round);
			dmgFac = 1;
			// Player ist am Zug
			if ((playerFight - enemyFight) > 0)
				dmgFac = playerFight - enemyFight;

			System.out.println("Player - dmgFac: " + dmgFac);
			enemyHealth -= dmgFac * playerDmg;
			if (this.health <= 0)
				break;

			dmgFac = 1;
			// Enemy ist am Zug
			if ((enemyFight - playerFight) > 0)
				dmgFac = enemyFight - playerFight;

			System.out.println("Enemy - dmgFac: " + dmgFac);

			this.health -= dmgFac * enemyDmg;
			if (enemyHealth <= 0)
				break;
			round++;
		}
		if (health > 0) {
			this.inventory.add(enemy.getInventory());
			return true;
		} else {
			return false;
		}

	}

	public boolean flee(Enemy enemy) {
		if (enemy.getSkillSet().getSkillValue(Skill.AGILITY) < skillSet.getSkillValue(Skill.AGILITY)) {
			return false;
		} else {
			return true;
		}

	}

}
