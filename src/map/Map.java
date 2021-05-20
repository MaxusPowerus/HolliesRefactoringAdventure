package map;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import basic.Config;
import utilities.Coordinate;

public class Map {
	private Map parentMap;
	private ArrayList<MapField> fields;

	public Map() {
		fields = new ArrayList<MapField>();
		parentMap = null;
	}

	public MapField getMapFieldByCoordinate(Coordinate coordinate) {
		for (MapField field : this.fields) {
			if (field.getCoordinate().isEqual(coordinate))
				return field;
		}
		return null;
	}

	public ArrayList<MapField> getFields() {
		return fields;
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
			int count = 0;

			for (int y = 0; y < Config.MAP_SIZEY; y++) {
				for (int x = 0; x < Config.MAP_SIZEX; x++) {

					Coordinate coordinate = new Coordinate(x, y);

					String biome = getMapFieldByCoordinate(x, y).getBiom().getName() + ",";
					String container = "";
					String enemies = "";

					if (getMapFieldByCoordinate(x, y).getChallenge().getContainer() != null) {
						container = "Coordinate: " + coordinate + " Continer: "
								+ getMapFieldByCoordinate(x, y).getChallenge().getContainer().getName();
					}

					if (getMapFieldByCoordinate(x, y).getChallenge().getNpc() != null) {
						enemies = "Coordinate: " + coordinate + " Gegner: "
								+ getMapFieldByCoordinate(x, y).getChallenge().getNpc().getName() + " (Biom: "
								+ getMapFieldByCoordinate(x, y).getBiom().getName() + ")";
					}
					// System.out.print("\n");
					writer.write(biome);
				}
				writer.write("\n");
			}
			// System.out.println(parameter);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
