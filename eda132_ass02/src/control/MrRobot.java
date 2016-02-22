package control;

import java.util.Random;

import model.Model;

public class MrRobot {
	String heading;
	int x, y;
	Random rnd;
	String[] headings = {"N","W","S","E"};
	Model model;
	
	public MrRobot(int x, int y, String heading, Model model) {
		this.x = x;
		this.y = y;
		this.heading = heading;
		rnd = new Random();
		this.model = model;
	}
	
	public void move() {
		for(int i =0; i<100; i++) {
			String heading = random_heading();
			System.out.println(heading);
			System.out.println(can_i_go(heading));
		}
	}
	
	public String random_heading() {
		return headings[rnd.nextInt(headings.length)];
	}
	
	public Boolean can_i_go(String robot_heading) {
		//Corr:        N   W   S   E  (Case switches are boring.)
		int xlist[] = {0, -1,  0,  0};
		int ylist[] = {1,  0, -1,  1};
		int pos = 0;
		for (String heading : headings) {
			if(robot_heading.equals(heading)) {
				break;
			}
			pos += 1;
		}
		int new_x = this.x + xlist[pos];
		int new_y = this.y + ylist[pos];
		Boolean x_is_fine = new_x < model.getNumCols() && new_x > -1;
		Boolean y_is_fine = new_y < model.getNumRows() && new_y > -1;
		return x_is_fine && y_is_fine;
	}
}
