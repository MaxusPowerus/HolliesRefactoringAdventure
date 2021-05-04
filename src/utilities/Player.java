package utilities;

import java.util.ArrayList;

import basic.Config;
import map.Map;

public class Player {
	
	private String name;
	private double health;
	private Inventory inventory;
	private ArrayList<Skill> skills;
	private Experience experience;
	private int daysAlive;
	private Coordinate coordinate;
	private Map currentMap;
	
	public Player(String name, Map mainMap) {
		this.name = name;
		this.health = Config.PLAYER_HEALTH;
		this.inventory = new Inventory();
		this.skills = new ArrayList<Skill>();
		this.experience = new Experience();
		this.daysAlive = 0;
		this.coordinate = new Coordinate(Config.MAP_SIZEX/2, Config.MAP_SIZEY/2);
		this.currentMap = mainMap;
	}
}
