package utilities;

public class Coordinate {
	int posX;
	int posY;
	
	public Coordinate(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void setCoordinate(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void setCoordinate(Coordinate coordinate) {
		this.posX = coordinate.getPosX();
		this.posY = coordinate.getPosY();
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
	
	public Coordinate[] getNeighbours() {
		Coordinate[] neighbours = new Coordinate[8];
		
		neighbours[0] = new Coordinate(this.getPosX() - 1, this.getPosY() + 1);
		neighbours[1] = new Coordinate(this.getPosX() + 0, this.getPosY() + 1);
		neighbours[2] = new Coordinate(this.getPosX() + 1, this.getPosY() + 1);
		neighbours[3] = new Coordinate(this.getPosX() + 1, this.getPosY() + 0);
		neighbours[4] = new Coordinate(this.getPosX() + 1, this.getPosY() - 1);
		neighbours[5] = new Coordinate(this.getPosX() + 0, this.getPosY() - 1);
		neighbours[6] = new Coordinate(this.getPosX() - 1, this.getPosY() - 1);
		neighbours[7] = new Coordinate(this.getPosX() - 1, this.getPosY() + 0);
		
		return neighbours;
	}
	
	@Override
	public String toString() {
		return "X: " + this.posX + ", Y: " + this.posY;
	}
	
	public void print() {
		System.out.println("X = " + this.posX + ", Y = " + this.posY);
	}
}
