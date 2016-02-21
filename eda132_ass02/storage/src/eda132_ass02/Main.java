package eda132_ass02;

public class Main {
	public static void main(String[] args) {
		Robot robot = new Robot();
		int repetitions = 15;
		for(int i = 0; i < repetitions; i++) {
			int tempx = robot.rnd.nextInt(100);
			int tempy = robot.rnd.nextInt(100);
			Position pos = new Position(tempx, tempy);
			System.out.println(pos);
		}
	}
}
