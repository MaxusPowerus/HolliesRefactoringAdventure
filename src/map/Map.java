package map;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public void printMapDebug(String parameter) {	
		try {
			File file = new File("Map.txt");
			file.delete();
			file.createNewFile();
			FileWriter writer = new FileWriter(file, true);
		    
			for(int y = 0; y < Config.MAP_SIZEY; y++) {
				for(int x = 0; x < Config.MAP_SIZEX; x++) {
					String out = getMapFieldByCoordinate(x, y).getBiom().getName() + ",";
					System.out.print(out);
					writer.write(out);
				}
				System.out.print("\n");
				writer.write("\n");
			}
			System.out.println(parameter);
			writer.close();
		} catch(Exception e) { }
		
	}
	
	public void generateMainMapStepOne() {
		String parameter = "emty";
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
				
				int meadowBoost = 200;
				int forestBoost = 100;
				int desertBoost = 100;
				int swampBoost = 50;
				int mountainsBoost = 100;
				
				parameter = "WI: " + meadowChance + "/"+ meadowBoost + ", WA: " + forestChance + "/" + forestBoost +", WÜ: " + desertChance + "/" + desertBoost + ", SU: " + swampChance + "/" + swampBoost + ", GE: " + mountainsChance + "/" + mountainsBoost;
				
					if(left == Biom.MEADOW)
						meadowChance += meadowBoost * 2;
					if(above == Biom.MEADOW)
						meadowChance += meadowBoost * 3;
					if(leftAbove == Biom.MEADOW)
						meadowChance += meadowBoost * 2;
					
					if(left == Biom.FOREST)
						forestChance += forestBoost * 3;
					if(above == Biom.FOREST)
						forestChance += forestBoost * 2;
					if(leftAbove == Biom.FOREST)
						forestChance += forestBoost * 3;
					
					if(left == Biom.DESERT)
						desertChance += desertBoost * 2.5;
					if(above == Biom.DESERT)
						desertChance += desertBoost * 2.5;
					if(leftAbove == Biom.DESERT)
						desertChance += desertBoost * 2.5;
					
					if(left == Biom.SWAMP)
						swampChance += swampBoost * 2;
					if(above == Biom.SWAMP)
						swampChance += swampBoost - 30;
					if(leftAbove == Biom.SWAMP)
						swampChance += swampBoost * 2;
					
					if(left == Biom.MOUNTAINS)
						mountainsChance += mountainsBoost * 2;	
					if(above == Biom.MOUNTAINS)
						mountainsChance += mountainsBoost * 7;
					if(leftAbove == Biom.MOUNTAINS)
						mountainsChance += mountainsBoost * 2;
				
				
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
		printMapDebug(parameter);
	}
	
	public void generateMainMapStepTwo() {
		String parameter = "emty";
		Random Randy = new Random();
		for(int y = 0; y < Config.MAP_SIZEX; y++) {
			for(int x = Config.MAP_SIZEY; x >= 0; x--) {
				Coordinate coordinate = new Coordinate(x, y);
				
				MapField field = new MapField(coordinate, Biom.getRandomBiom());
				
				int meadowChance = 0;
				int forestChance = 50;
				int desertChance = 0;
				int swampChance = 0;
				int mountainsChance = 0;
				
				 
				
				Biom above;
				Biom left;
				Biom leftAbove;
				
				if(x < Config.MAP_SIZEX  )
					left = getMapFieldByCoordinate(x + 1, y).getBiom();
				else
					left = null;
				
				if( y > 0)
					above = getMapFieldByCoordinate(x, y - 1).getBiom();
				else
					above = null;
				
				if(x < Config.MAP_SIZEX && y > 0)
					leftAbove = getMapFieldByCoordinate(x + 1, y - 1).getBiom();
				else
					leftAbove = null;
				
				int meadowBoost = 150;
				int forestBoost = 150;
				int desertBoost = 300;
				int swampBoost = 50;
				int mountainsBoost = 50;
				
				parameter = "WI: " + meadowChance + "/"+ meadowBoost + ", WA: " + forestChance + "/" + forestBoost +", WÜ: " + desertChance + "/" + desertBoost + ", SU: " + swampChance + "/" + swampBoost + ", GE: " + mountainsChance + "/" + mountainsBoost;
				
				    /*
					if(left == Biom.MEADOW)
						meadowChance += meadowBoost;
					if(above == Biom.MEADOW)
						meadowChance += meadowBoost + 30;
					if(leftAbove == Biom.MEADOW)
						meadowChance += meadowBoost;
					*/
					if(left == Biom.FOREST)
						forestChance += forestBoost * 2;
					if(above == Biom.FOREST)
						forestChance += forestBoost;
					if(leftAbove == Biom.FOREST)
						forestChance += forestBoost * 2;
					
					if(left == Biom.DESERT)
						desertChance += desertBoost * 2.5;
					if(above == Biom.DESERT)
						desertChance += desertBoost * 2.5;
					if(leftAbove == Biom.DESERT)
						desertChance += desertBoost * 2.5;
					
					if(left == Biom.SWAMP)
						swampChance += swampBoost * 3;
					if(above == Biom.SWAMP)
						swampChance += swampBoost/10;
					if(leftAbove == Biom.SWAMP)
						swampChance += swampBoost * 3;
					
					if(left == Biom.MOUNTAINS)
						mountainsChance += mountainsBoost ;	
					if(above == Biom.MOUNTAINS)
						mountainsChance += mountainsBoost * 2;
					if(leftAbove == Biom.MOUNTAINS)
						mountainsChance += mountainsBoost ;
				
				
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
		printMapDebug(parameter);
	}
	
}
