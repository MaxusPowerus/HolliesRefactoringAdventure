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

	public String getText() {
		String text = "Das ist das erste Mal, dass der kleine Max alleine in die freie Welt gelassen wurde. Doch was er da sah, übertraf all' seine Erwartungen.\n"
				+ "Ein großer Elefant 🐘 stand plätzlich vor ihm! Was soll er jetzt tun?";

		return text;
	}

}
