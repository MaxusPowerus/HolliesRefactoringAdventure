package entities;

import basic.Config;
import basic.GameManager;
import items.Weapon;
import map.Direction;
import map.Map;
import map.MapField;
import utilities.Coordinate;
import utilities.Experience;
import utilities.Inventory;
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

		this.inventory.add(GameManager.getInstance().getResourceManager().getItemByUniqueName("Stick"));
		this.equipped.add(GameManager.getInstance().getResourceManager().getItemByUniqueName("Stick"));
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

}
