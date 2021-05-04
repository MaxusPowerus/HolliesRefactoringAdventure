package map;

import utilities.Coordinate;

public class MapField {
	
	private Coordinate coordinate;
	private boolean disabled; 
	
	private Map subMap;

	public MapField(Coordinate coordinate) {
		this.coordinate = coordinate;
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
	
}
