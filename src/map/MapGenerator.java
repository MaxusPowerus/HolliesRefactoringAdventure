package map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import QuestClasses.Quest;
import basic.Config;
import basic.GameManager;
import utilities.Challenge;
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

	public Map makeSwamps(int swampChance) {
		Random Randy = new Random();
		for (int y = 0; y < Config.MAP_SIZEY; y++) {
			for (int x = Config.MAP_SIZEX - 1; x >= 0; x--) {
				if (Randy.nextInt(1000) < swampChance) {
					map.getMapFieldByCoordinate(x, y).setBiom(Biom.SWAMP);

					if (Randy.nextInt(100) % 4 == 0) {
						if (map.getMapFieldByCoordinate(x + 1, y + 1) != null) {
							map.getMapFieldByCoordinate(x + 1, y + 1).setBiom(Biom.SWAMP);
						}
						if (map.getMapFieldByCoordinate(x + 1, y - 1) != null) {
							map.getMapFieldByCoordinate(x + 1, y - 1).setBiom(Biom.SWAMP);
						}
					} else if (Randy.nextInt(100) % 3 == 0) {
						if (map.getMapFieldByCoordinate(x + 1, y - 1) != null) {
							map.getMapFieldByCoordinate(x + 1, y - 1).setBiom(Biom.SWAMP);
						}
						if (map.getMapFieldByCoordinate(x - 1, y - 1) != null) {
							map.getMapFieldByCoordinate(x - 1, y - 1).setBiom(Biom.SWAMP);
						}
					} else if (Randy.nextInt(100) % 2 == 0) {
						if (map.getMapFieldByCoordinate(x - 1, y - 1) != null) {
							map.getMapFieldByCoordinate(x - 1, y - 1).setBiom(Biom.SWAMP);
						}
						if (map.getMapFieldByCoordinate(x - 1, y + 1) != null) {
							map.getMapFieldByCoordinate(x - 1, y + 1).setBiom(Biom.SWAMP);
						}
					} else if (Randy.nextInt(100) % 1 == 0) {
						if (map.getMapFieldByCoordinate(x - 1, y + 1) != null) {
							map.getMapFieldByCoordinate(x - 1, y + 1).setBiom(Biom.SWAMP);
						}
						if (map.getMapFieldByCoordinate(x + 1, y + 1) != null) {
							map.getMapFieldByCoordinate(x + 1, y + 1).setBiom(Biom.SWAMP);
						}
					}
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
				if (map.getMapFieldByCoordinate(coordinate).getBiom() == Biom.FOREST) {
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

	public ArrayList<MapField> getRandomMapfielsdWithNoQuest(Biom biom, int count) {

		ArrayList<MapField> fields = new ArrayList<MapField>();

		if (biom == null) {
			for (int y = 0; y < Config.MAP_SIZEY; y++) {
				for (int x = 0; x < Config.MAP_SIZEX; x++) {
					if (map.getMapFieldByCoordinate(x, y).getQuest() == null) {
						fields.add(map.getMapFieldByCoordinate(x, y));
					}

				}
			}
		} else {
			for (int y = 0; y < Config.MAP_SIZEY; y++) {
				for (int x = 0; x < Config.MAP_SIZEX; x++) {
					if (map.getMapFieldByCoordinate(x, y).getBiom().getName().equals(biom.getName())
							&& map.getMapFieldByCoordinate(x, y).getQuest() == null) {

						fields.add(map.getMapFieldByCoordinate(x, y));
					}
				}
			}
		}
		Collections.shuffle(fields);
		System.out.println("COUNT: " + count);
		System.out.println("FIELDSIZE 1: " + fields.size());
		Random Randy = new Random();
		while (fields.size() > count) {
			fields.remove(Randy.nextInt(fields.size()));
		}
		System.out.println("FIELDSIZE 2: " + fields.size());
		return fields;
	}

	public void generateChallenge() {

		Random Randy = new Random();

		for (int y = 0; y < Config.MAP_SIZEY; y++) {
			for (int x = 0; x < Config.MAP_SIZEX; x++) {
				Challenge challenge = new Challenge(map.getMapFieldByCoordinate(x, y).getBiom());
				map.getMapFieldByCoordinate(x, y).setChallenge(challenge);
			}
		}
	}

	public void generateQuests() {

		testQuest("Eine Falsche Entscheidung");

		// Quests mit Vorbestimmten Koordinaten
		ArrayList<Quest> questsPos = GameManager.getInstance().getQuestManager().getQuestWithCoordinates();
		for (int i = 0; i < questsPos.size(); i++) {
			map.getMapFieldByCoordinate(questsPos.get(i).getTargetPoint()).setQuest(questsPos.get(i));
			map.getMapFieldByCoordinate(questsPos.get(i).getTargetPoint()).setChallenge(null);

		}

		//// Quests Nach Biomen
		ArrayList<MapField> fields;

		// beliebige Biome
		ArrayList<Quest> questsNull = GameManager.getInstance().getQuestManager().getQuestsByBiom(null);
		fields = getRandomMapfielsdWithNoQuest(null, questsNull.size());

		for (int i = 0; i < questsNull.size(); i++) {
			map.getMapFieldByCoordinate(fields.get(i).getCoordinate()).setQuest(questsNull.get(i));
			map.getMapFieldByCoordinate(fields.get(i).getCoordinate()).setChallenge(null);
			questsNull.get(i).setTargetPoint(fields.get(i).getCoordinate());
			System.out.println("Spwan quest at :" + questsPos.get(i).getTargetPoint().toString());
		}
		fields.clear();

		// Wiese
		ArrayList<Quest> questsMeadow = GameManager.getInstance().getQuestManager().getQuestsByBiom(Biom.MEADOW);
		System.out.println("MEADOW: " + questsMeadow.size());

		fields = getRandomMapfielsdWithNoQuest(Biom.MEADOW, questsMeadow.size());

		for (int i = 0; i < questsMeadow.size(); i++) {
			map.getMapFieldByCoordinate(fields.get(i).getCoordinate()).setQuest(questsMeadow.get(i));
			map.getMapFieldByCoordinate(fields.get(i).getCoordinate()).setChallenge(null);
			questsMeadow.get(i).setTargetPoint(fields.get(i).getCoordinate());

		}
		fields.clear();

		// Wald
		ArrayList<Quest> questsForest = GameManager.getInstance().getQuestManager().getQuestsByBiom(Biom.FOREST);
		System.out.println("FOREST: " + questsForest.size());
		fields = getRandomMapfielsdWithNoQuest(Biom.FOREST, questsForest.size());
		for (int i = 0; i < questsForest.size(); i++) {
			map.getMapFieldByCoordinate(fields.get(i).getCoordinate()).setQuest(questsForest.get(i));
			map.getMapFieldByCoordinate(fields.get(i).getCoordinate()).setChallenge(null);
			questsForest.get(i).setTargetPoint(fields.get(i).getCoordinate());

		}
		fields.clear();

		// Wüste
		ArrayList<Quest> questsWueste = GameManager.getInstance().getQuestManager().getQuestsByBiom(Biom.DESERT);
		System.out.println("DESERT: " + questsWueste.size());
		fields = getRandomMapfielsdWithNoQuest(Biom.DESERT, questsWueste.size());
		for (int i = 0; i < questsWueste.size(); i++) {
			map.getMapFieldByCoordinate(fields.get(i).getCoordinate()).setQuest(questsWueste.get(i));
			map.getMapFieldByCoordinate(fields.get(i).getCoordinate()).setChallenge(null);
			questsWueste.get(i).setTargetPoint(fields.get(i).getCoordinate());

		}
		fields.clear();

		// Sumpf
		ArrayList<Quest> questsSumpf = GameManager.getInstance().getQuestManager().getQuestsByBiom(Biom.SWAMP);
		System.out.println("SWAMP: " + questsSumpf.size());
		fields = getRandomMapfielsdWithNoQuest(Biom.SWAMP, questsSumpf.size());
		System.out.println("FIELD: " + fields.size());
		for (int i = 0; i < questsSumpf.size(); i++) {
			map.getMapFieldByCoordinate(fields.get(i).getCoordinate()).setQuest(questsSumpf.get(i));
			map.getMapFieldByCoordinate(fields.get(i).getCoordinate()).setChallenge(null);
			questsSumpf.get(i).setTargetPoint(fields.get(i).getCoordinate());

		}
		fields.clear();

		// Berge
		ArrayList<Quest> questsMountains = GameManager.getInstance().getQuestManager().getQuestsByBiom(Biom.MOUNTAINS);
		System.out.println("MOUNTAINS: " + questsMountains.size());
		fields = getRandomMapfielsdWithNoQuest(Biom.MOUNTAINS, questsMountains.size());
		for (int i = 0; i < questsMountains.size(); i++) {
			map.getMapFieldByCoordinate(fields.get(i).getCoordinate()).setQuest(questsMountains.get(i));
			map.getMapFieldByCoordinate(fields.get(i).getCoordinate()).setChallenge(null);
			questsMountains.get(i).setTargetPoint(fields.get(i).getCoordinate());

		}
		fields.clear();

	}

	public void testQuest(String title) {
		ArrayList<Quest> quests = GameManager.getInstance().getQuestManager().getAllQuests();
		for (int i = 0; i < quests.size(); i++) {
			if (quests.get(i).getTitle().equals(title)) {
				Coordinate pos = new Coordinate(Config.MAP_SIZEX / 2, Config.MAP_SIZEY / 2 + 1);
				map.getMapFieldByCoordinate(pos).setQuest(quests.get(i));
				map.getMapFieldByCoordinate(pos).setChallenge(null);
				quests.get(i).setTargetPoint(pos);
			}
		}
	}

	public Map generateMapMK2() {
		map = setMapToBiom(Biom.MEADOW);
		// System.out.println("Meadow Done");
		map = makeForest(3, 16);
		// System.out.println("Forest Done");
		map = makeSwamps(1);
		// System.out.println("Swamp Done");
		map = makeMountains(1, 15);
		// System.out.println("Mountains Done");
		map = makeOneDesert(Config.MAP_SIZEX * 5);
		// System.out.println("Desert Done");
		map = flatForestDesertBorder();
		// System.out.println("Flater01 Done");

		generateChallenge();
		// System.out.println("Container Done");

		generateQuests();
		// System.out.println("Container Done");

		// map.printMapDebug("");

		return map;
	}

}
