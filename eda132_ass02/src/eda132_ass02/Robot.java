package eda132_ass02;

import java.util.Random;

public class Robot {
	
	Random rnd;
	
	public Robot() {
		rnd = new Random();
	}
	
	public int bump() {
		return rnd.nextInt(100);
	}
	
}