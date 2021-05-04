package map;

import java.util.ArrayList;
import java.util.Random;

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
	
	public MapField getMapFieldByCoordinate(Coordinate coordinate) {
		for(MapField field : this.fields) {
			if(field.getCoordinate().isEqual(coordinate)) return field;
		}
		return null;
	}
	
	public MapField getMapFieldByCoordinate(int x, int y) {
		Coordinate coordinate = new Coordinate(x, y);
		return this.getMapFieldByCoordinate(coordinate);
	}
	
	public void prntMapDebug() {
		for(int x = 0; x < Config.MAP_SIZEX; x++) {
			for(int y = 0; y < Config.MAP_SIZEY; y++) {
				System.out.print(getMapFieldByCoordinate(x, y).getBiom().getName() + "  ");
			}
			System.out.println("\n");
		}
	}
	
	public void generateMainMap() {
		Random Randy = new Random();
		for(int x = 0; x < Config.MAP_SIZEX; x++) {
			for(int y = 0; y < Config.MAP_SIZEY; y++) {
				Coordinate coordinate = new Coordinate(x, y);
				
				MapField field = new MapField(coordinate, Biom.getRandomBiom());
				
				int meadowChance = Biom.MEADOW.getChance();
				int forestChance = Biom.FOREST.getChance();
				int desertChance = Biom.DESERT.getChance();
				int swampChance = Biom.SWAMP.getChance();
				int mountainsChance = Biom.MOUNTAINS.getChance();
				
				
				Biom above;
				Biom left;
				Biom leftAbove;
				
				if(x > 0 )
					left = getMapFieldByCoordinate(x - 1, y).getBiom();
				else
					left = null;
				
				if( y > 0)
					above = getMapFieldByCoordinate(x, y - 1).getBiom();
				else
					above = null;
				
				if(x > 0 && y > 0)
					leftAbove = getMapFieldByCoordinate(x - 1, y - 1).getBiom();
				else
					leftAbove = null;
				
				int boost = 150;
				
				
					if(left == Biom.MEADOW)
						meadowChance += boost + 50;
					if(above == Biom.MEADOW)
						meadowChance += boost + 50;
					if(leftAbove == Biom.MEADOW)
						meadowChance += boost;
					
					if(left == Biom.FOREST)
						forestChance += boost;
					if(above == Biom.FOREST)
						forestChance += boost + 30;
					if(leftAbove == Biom.FOREST)
						forestChance += boost;
					
					if(left == Biom.DESERT)
						desertChance += boost * 2;
					if(above == Biom.DESERT)
						desertChance += boost * 2;
					if(leftAbove == Biom.DESERT)
						desertChance += boost * 2;
					
					if(left == Biom.SWAMP)
						swampChance += boost;
					if(above == Biom.SWAMP)
						swampChance += boost;
					if(leftAbove == Biom.SWAMP)
						swampChance += boost;
					
					if(left == Biom.MOUNTAINS)
						mountainsChance += boost;	
					if(above == Biom.MOUNTAINS)
						mountainsChance += boost;
					if(leftAbove == Biom.MOUNTAINS)
						mountainsChance += boost * 3 + 10;
				
				
				int sumOfChances = meadowChance + forestChance + desertChance + swampChance + mountainsChance + 1;
				
				int randomInt = Randy.nextInt(sumOfChances);
				
				if(0 < randomInt && randomInt < meadowChance)
					 field = new MapField(coordinate, Biom.MEADOW);
					
				if(meadowChance < randomInt && randomInt < meadowChance + forestChance)
					 field = new MapField(coordinate, Biom.FOREST);
				
				if(meadowChance + forestChance < randomInt && randomInt < meadowChance + forestChance + desertChance)
					 field = new MapField(coordinate, Biom.DESERT);
					
				if(meadowChance + forestChance + desertChance < randomInt && randomInt < meadowChance + forestChance + desertChance + swampChance)
					 field = new MapField(coordinate, Biom.SWAMP);
					
				if(meadowChance + forestChance + desertChance + swampChance < randomInt && randomInt < meadowChance + forestChance + desertChance + swampChance + mountainsChance)
					 field = new MapField(coordinate, Biom.MOUNTAINS);

				//System.out.println(field.getBiom().getName() + chances[0] + " " + chances[1] + " " + chances[2] + " " + chances[3] + " " + chances[4] + "||" + randomInt + "||" + sumOfChances);
				fields.add(field);
			}
		}
	}
	
}
