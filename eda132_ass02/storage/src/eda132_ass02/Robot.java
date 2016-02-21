package eda132_ass02;

import java.util.Random;

public class Robot {
	
	public Random rnd;
	public int x, y;
	
	public Robot() {
		rnd = new Random();
	}
	
	public int bump() {
		return rnd.nextInt(100);
	}
	
	public void set_pos(int x, int y) { 
		this.x = x;
		this.y = y;
	}
	
	public void set_pos(Position pos) {
		set_pos(pos.x, pos.y);
	}
}