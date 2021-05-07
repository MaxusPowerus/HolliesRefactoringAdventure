package map;

import java.util.Random;

import basic.Config;
import utilities.Coordinate;

public class MapGenerator {

	Map map;

	public MapGenerator(Map map) {

		this.map = map;
	}

	public Map setMapToBiom(Biom biom) {

		for (int y = 0; y < Config.MAP_SIZEY; y++) {
			for (int x = 0; x < Config.MAP_SIZEX; x++) {
				Coordinate coordinate = new Coordinate(x, y);
				MapField field = new MapField(coordinate, biom);
				map.getFields().add(field);
			}
		}
		return map;
	}

	public Map makeForest(int forestChance, int forestBoost) {
		Random Randy = new Random();
		for (int y = 0; y < Config.MAP_SIZEY; y++) {
			for (int x = 0; x < Config.MAP_SIZEX; x++) {

				int chance = forestChance;
				Biom above;
				Biom left;
				Biom leftAbove;

				if (x > 0)
					left = map.getMapFieldByCoordinate(x - 1, y).getBiom();
				else
					left = null;

				if (y > 0)
					above = map.getMapFieldByCoordinate(x, y - 1).getBiom();
				else
					above = null;

				if (x > 0 && y > 0)
					leftAbove = map.getMapFieldByCoordinate(x - 1, y - 1).getBiom();
				else
					leftAbove = null;

				if (left == Biom.FOREST)
					chance += forestBoost * 2;
				if (above == Biom.FOREST)
					chance += forestBoost * 2;
				if (leftAbove == Biom.FOREST)
					chance += forestBoost * 1.5;

				if (Randy.nextInt(101) < chance) {
					map.getMapFieldByCoordinate(x, y).setBiom(Biom.FOREST);
				}

			}

		}

		for (int y = 0; y < Config.MAP_SIZEY; y++) {
			for (int x = Config.MAP_SIZEX - 1; x >= 0; x--) {

				int chance = 0;
				Biom above;
				Biom right;
				Biom rightAbove;

				if (x < Config.MAP_SIZEX - 1)
					right = map.getMapFieldByCoordinate(x + 1, y).getBiom();
				else
					right = null;

				if (y > 0)
					above = map.getMapFieldByCoordinate(x, y - 1).getBiom();
				else
					above = null;

				if (x < Config.MAP_SIZEX - 1 && y > 0)
					rightAbove = map.getMapFieldByCoordinate(x + 1, y - 1).getBiom();
				else
					rightAbove = null;

				if (right == Biom.FOREST)
					chance += forestBoost * 2;
				if (above == Biom.FOREST)
					chance += forestBoost + 2;
				if (rightAbove == Biom.FOREST)
					chance += forestBoost * 1.5;

				if (Randy.nextInt(101) < chance) {
					map.getMapFieldByCoordinate(x, y).setBiom(Biom.FOREST);
				}

			}

		}
		return map;
	}

	public Map makeMountains(int mountainsChance, int mountainsBoost) {
		Random Randy = new Random();
		for (int y = 0; y < Config.MAP_SIZEY; y++) {
			for (int x = Config.MAP_SIZEX - 1; x >= 0; x--) {

				int chance = mountainsChance;
				Biom above;
				Biom right;
				Biom rightAbove;

				if (x < Config.MAP_SIZEX - 1)
					right = map.getMapFieldByCoordinate(x + 1, y).getBiom();
				else
					right = null;

				if (y > 0)
					above = map.getMapFieldByCoordinate(x, y - 1).getBiom();
				else
					above = null;

				if (x < Config.MAP_SIZEX - 1 && y > 0)
					rightAbove = map.getMapFieldByCoordinate(x + 1, y - 1).getBiom();
				else
					rightAbove = null;

				if (right == Biom.MOUNTAINS)
					chance += mountainsBoost * 10;
				if (above == Biom.MOUNTAINS)
					chance += mountainsBoost * 10;
				if (rightAbove == Biom.MOUNTAINS)
					chance += mountainsBoost * 5;

				if (Randy.nextInt(400) < chance) {
					map.getMapFieldByCoordinate(x, y).setBiom(Biom.MOUNTAINS);
				}

			}

		}

		return map;
	}

	public Map flatForestDesertBorder() {
		for (int y = 0; y < Config.MAP_SIZEY; y++) {
			for (int x = 0; x < Config.MAP_SIZEX; x++) {
				Coordinate coordinate = new Coordinate(x, y);
				if (map.getMapFieldByCoordinate(coordinate).getBiom() == Biom.FOREST)
					for (int i = 0; i < 8; i++) {
						if (map.getMapFieldByCoordinate(coordinate.getNeighbours()[i]) != null) {
							if (map.getMapFieldByCoordinate(coordinate.getNeighbours()[i]).getBiom() == Biom.DESERT) {
								map.getMapFieldByCoordinate(coordinate).setBiom(Biom.MEADOW);
								map.getMapFieldByCoordinate(coordinate.getNeighbours()[i]).setBiom(Biom.MEADOW);
							}
						}

					}
			}
		}
		return map;
	}

	public Map makeOneDesert(int maxSize) {

		Random Randy = new Random();
		Coordinate middle = new Coordinate(Randy.nextInt(Config.MAP_SIZEX), Randy.nextInt(Config.MAP_SIZEY));
		map.getMapFieldByCoordinate(middle).setBiom(Biom.DESERT);
		for (int i = 0; i < 8; i++) {
			if (map.getMapFieldByCoordinate(middle.getNeighbours()[i]) != null) {
				map.getMapFieldByCoordinate(middle.getNeighbours()[i]).setBiom(Biom.DESERT);
			}
		}
		int chance = 55;
		for (int loops = 0; loops < 2; loops++) {
			for (int y = 0; y < Config.MAP_SIZEY; y++) {
				for (int x = 0; x < Config.MAP_SIZEX; x++) {
					if (map.getMapFieldByCoordinate(x, y).getBiom() == Biom.DESERT) {
						for (int i = 0; i < 8; i++) {
							if (Randy.nextInt(100) < chance) {
								Coordinate c = new Coordinate(x, y);
								if (map.getMapFieldByCoordinate(c.getNeighbours()[i]) != null
										&& map.getMapFieldByCoordinate(c.getNeighbours()[i]).getBiom() != Biom.DESERT) {

									map.getMapFieldByCoordinate(c.getNeighbours()[i]).setBiom(Biom.DESERT);
									maxSize--;

									if (maxSize <= 0) {
										return map;
									}
								}
							}
						}
					}
				}
			}
		}
		return map;
	}

	public Map generateMapMK2() {
		map = setMapToBiom(Biom.MEADOW);
		System.out.println("Meadow Done");
		map = makeForest(3, 15);
		System.out.println("Forest Done");
		map = makeMountains(1, 15);
		System.out.println("Mountains Done");
		map = makeOneDesert(500);
		System.out.println("Desert Done");
		map = flatForestDesertBorder();
		System.out.println("Flater01 Done");

		map.printMapDebug("");
		return map;
	}

	public Map generateMainMapBasic() {
		String parameter = "emty";
		Random Randy = new Random();
		for (int y = 0; y < Config.MAP_SIZEY; y++) {
			for (int x = 0; x < Config.MAP_SIZEX; x++) {
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

				if (x > 0)
					left = map.getMapFieldByCoordinate(x - 1, y).getBiom();
				else
					left = null;

				if (y > 0)
					above = map.getMapFieldByCoordinate(x, y - 1).getBiom();
				else
					above = null;

				if (x > 0 && y > 0)
					leftAbove = map.getMapFieldByCoordinate(x - 1, y - 1).getBiom();
				else
					leftAbove = null;

				int meadowBoost = 200;
				int forestBoost = 150;
				int desertBoost = 200;
				int swampBoost = 100;
				int mountainsBoost = 100;

				parameter = "WI: " + meadowChance + "/" + meadowBoost + ", WA: " + forestChance + "/" + forestBoost
						+ ", WÜ: " + desertChance + "/" + desertBoost + ", SU: " + swampChance + "/" + swampBoost
						+ ", GE: " + mountainsChance + "/" + mountainsBoost;

				if (left == Biom.MEADOW)
					meadowChance += meadowBoost * 2;
				if (above == Biom.MEADOW)
					meadowChance += meadowBoost * 3;
				if (leftAbove == Biom.MEADOW)
					meadowChance += meadowBoost * 2;

				if (left == Biom.FOREST)
					forestChance += forestBoost * 3;
				if (above == Biom.FOREST)
					forestChance += forestBoost * 2;
				if (leftAbove == Biom.FOREST)
					forestChance += forestBoost * 3;

				if (left == Biom.DESERT)
					desertChance += desertBoost * 2.5;
				if (above == Biom.DESERT)
					desertChance += desertBoost * 2.5;
				if (leftAbove == Biom.DESERT)
					desertChance += desertBoost * 2.5;

				if (left == Biom.SWAMP)
					swampChance += swampBoost * 2;
				if (above == Biom.SWAMP)
					swampChance += swampBoost - 30;
				if (leftAbove == Biom.SWAMP)
					swampChance += swampBoost * 2;

				if (left == Biom.MOUNTAINS)
					mountainsChance += mountainsBoost * 3;
				if (above == Biom.MOUNTAINS)
					mountainsChance += mountainsBoost * 8;
				if (leftAbove == Biom.MOUNTAINS)
					mountainsChance += mountainsBoost * 1.5;

				int sumOfChances = meadowChance + forestChance + desertChance + swampChance + mountainsChance + 1;

				int randomInt = Randy.nextInt(sumOfChances);

				if (0 < randomInt && randomInt < meadowChance)
					field = new MapField(coordinate, Biom.MEADOW);

				if (meadowChance < randomInt && randomInt < meadowChance + forestChance)
					field = new MapField(coordinate, Biom.FOREST);

				if (meadowChance + forestChance < randomInt && randomInt < meadowChance + forestChance + desertChance)
					field = new MapField(coordinate, Biom.DESERT);

				if (meadowChance + forestChance + desertChance < randomInt
						&& randomInt < meadowChance + forestChance + desertChance + swampChance)
					field = new MapField(coordinate, Biom.SWAMP);

				if (meadowChance + forestChance + desertChance + swampChance < randomInt
						&& randomInt < meadowChance + forestChance + desertChance + swampChance + mountainsChance)
					field = new MapField(coordinate, Biom.MOUNTAINS);

				// System.out.println(field.getBiom().getName() + chances[0] + " " + chances[1]
				// + " " + chances[2] + " " + chances[3] + " " + chances[4] + "||" + randomInt +
				// "||" + sumOfChances);
				map.getFields().add(field);
			}
		}
		// map.printMapDebug(parameter);
		return map;
	}
}
