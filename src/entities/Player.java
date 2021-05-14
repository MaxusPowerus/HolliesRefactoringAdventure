package entities;

import java.util.ArrayList;

import basic.Config;
import map.Direction;
import map.Map;
import map.MapField;
import utilities.Coordinate;
import utilities.Experience;
import utilities.Inventory;
import utilities.Skill;

public class Player {

	private String name;
	private double health;
	private Inventory inventory;
	private ArrayList<Skill> skills;
	private Experience experience;
	private int daysAlive;
	private Map currentMap;
	private MapField currentMapField;
	private Time time;

	public Player(String name, Map mainMap) {
		this.name = name;
		this.health = Config.PLAYER_HEALTH;
		this.inventory = new Inventory();
		this.skills = new ArrayList<Skill>();
		this.experience = new Experience();
		this.daysAlive = 0;
		this.currentMap = mainMap;
		this.currentMapField = mainMap.getMapFieldByCoordinate(Config.MAP_SIZEX / 2, Config.MAP_SIZEY / 2);
		this.time = new Time(0);
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

	public ArrayList<Skill> getSkills() {
		return skills;
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

	public boolean canGo(Direction direction) {
		MapField currentField = this.currentMapField;
		Coordinate coordinate = currentField.getCoordinate();

		int posX = coordinate.getPosX();
		int posY = coordinate.getPosY();

		if (direction == Direction.NORTH)
			posX -= 1;
		if (direction == Direction.EAST)
			posY += 1;
		if (direction == Direction.SOUTH)
			posX += 1;
		if (direction == Direction.WEST)
			posY -= 1;

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
			posX -= 1;
		if (direction == Direction.EAST)
			posY += 1;
		if (direction == Direction.SOUTH)
			posX += 1;
		if (direction == Direction.WEST)
			posY -= 1;

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
