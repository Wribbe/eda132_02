package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import model.Model;

public class MrRobot {
	String heading;
	int x, y;
	Random rnd;
	String[] headings = {"N","W","S","E"};
	//             N   W   S   E  
	int xlist[] = {0, -1,  0,  0};
	int ylist[] = {1,  0, -1,  1};
	Model model;
	
	HashMap<String, int[]> direction_modifiers = new HashMap<String, int[]>();
	
	public MrRobot(int x, int y, String heading, Model model) {
		this.x = x;
		this.y = y;
		this.heading = heading;
		this.rnd = new Random();
		this.model = model;
		
		set_up_direction_modifiers();
	}
	
	public void move() {

		String new_heading = "";
		ArrayList<String> possible_headings = get_possible_headings();

		Boolean possible_to_keep_going = can_i_go(this.heading);
		if (possible_to_keep_going) {
			int percent = rnd.nextInt(100)+1;
			if (percent <= 70) { 
				new_heading = this.heading;
			} else {
				new_heading = pick_one(possible_headings);
			}
		} else {
			new_heading = pick_one(possible_headings);
		}
		int[] modifiers = direction_modifiers.get(new_heading);
		this.x += modifiers[0];
		this.y += modifiers[1];
		this.heading = new_heading;
	}
	
	private ArrayList<String> get_possible_headings() {
		ArrayList<String> list = new ArrayList<String>();
		for (String heading : headings) {
			if (can_i_go(heading)) {
				list.add(heading);
			}
		}
		return list;
	}

	private String pick_one(ArrayList<String> list) {
		return list.get(rnd.nextInt(list.size()));
	}
	
	private Boolean can_i_go(String robot_heading) {
		int[] modifiers = direction_modifiers.get(robot_heading);
		int new_x = this.x + modifiers[0];
		int new_y = this.y + modifiers[1];
		Boolean x_is_fine = new_x < model.getNumCols() && new_x > -1;
		Boolean y_is_fine = new_y < model.getNumRows() && new_y > -1;
		return x_is_fine && y_is_fine;
	}
	
	private void set_up_direction_modifiers() {
		int pos = 0;
		for (String heading : headings) {
			int[] int_array = new int[2];
			int_array[0] = xlist[pos];
			int_array[1] = ylist[pos];
			this.direction_modifiers.put(heading, int_array);
			pos += 1;
		}
	}
	
	public String toString() {
		return String.format("(%d, %d)", this.x, this.y);
	}
}
