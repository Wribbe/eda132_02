package eda132_ass02;

public class Position {
	int x,y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return String.format("(%d,%d)", this.x, this.y);
	}
}
