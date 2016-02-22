package control;

import java.util.Random;

import model.Model;

public class MrRobot {
	String heading;
	int x, y;
	Random rnd;
	
	public MrRobot(int x, int y, String heading, Model model) {
		this.x = x;
		this.y = y;
		this.heading = heading;
		rnd = new Random();
	}
	
	public void move() {
		for(int i =0; i<100; i++) {
			System.out.println(random_heading());
		}
	}
	
	public String random_heading() {
		String[] headings = {"N","W","S","E"};
		return headings[rnd.nextInt(headings.length)];
	}
}
