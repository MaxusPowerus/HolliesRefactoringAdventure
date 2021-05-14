package map;

import utilities.Container;
import utilities.Coordinate;

public class MapField {

	private Coordinate coordinate;
	private boolean disabled;
	private Biom biom;

	private Container container = null;
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

	public void setBiom(Biom biom) {
		this.biom = biom;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public Container getContainer() {
		if (container == null) {
			return null;
		} else {
			return container;
		}
	}

	public String getText() {
		String text = "Das ist das erste Mal, dass der kleine Max alleine in die freie Welt gelassen wurde. Doch was er da sah, uebertraf all' seine Erwartungen.\n"
				+ "Ein grosser Elefant stand ploetzlich vor ihm! Was soll er jetzt tun?";

		return text;
	}

}
