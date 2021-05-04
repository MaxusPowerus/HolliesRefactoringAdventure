package map;

import java.util.ArrayList;

import basic.Config;
import utilities.Coordinate;

public class Map {
	private Map parentMap;
	private ArrayList<MapField> fields;
	
	public Map()
	{
		fields = new ArrayList<MapField>();
		parentMap = null;
	}
	
	public void generateMainMap() {
		for(int x = 0; x < Config.MAP_SIZEX; x++) {
			for(int y = 0; y < Config.MAP_SIZEY; y++) {
				Coordinate coordinate = new Coordinate(x, y);
				MapField field = new MapField(coordinate);
				fields.add(field);
				
			}
		}
	}
	
}
