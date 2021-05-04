package utilities;

public class Coordinate {
	int posX;
	int posY;
	
	public Coordinate(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public boolean isEqual(Coordinate coordinate) {
		return (posX == coordinate.getPosX() && posY == coordinate.getPosY());
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	@Override
	public String toString() {
		return "X: " + this.posX + ", Y: " + this.posY;
	}
}
