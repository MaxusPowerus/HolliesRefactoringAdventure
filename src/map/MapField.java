package map;

import utilities.Coordinate;

public class MapField {
	
	private Coordinate coordinate;
	private boolean disabled;
	private Biom biom;
	
	private Map subMap;

	public MapField(Coordinate coordinate, Biom biom) {
		this.coordinate = coordinate;
		this.disabled = false;
		this.biom = biom;
	}


	public Coordinate getCoordinate() {
		return coordinate;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public Map getSubMap() {
		return subMap;
	}

	public void setSubMap(Map subMap) {
		this.subMap = subMap;
	}
	
	public Biom getBiom() {
		return biom;
	}
	
}
