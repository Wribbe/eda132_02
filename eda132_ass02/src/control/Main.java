package control;

import model.Model;
import view.RobotLocalizationViewer;

public class Main {
	/*
	 * build your own if you like, this is just an example of how to start the viewer
	 * ...
	 */
	
	public static void main( String[] args) {
		
		/*
		 * generate you own localiser / estimator wrapper here to plug it into the 
		 * graphics class.
		 */
		//EstimatorInterface l = new DummyLocalizer( 4, 4, 4);
		Model model = new Model(4, 4, 4);
		MrRobot Sebastian = new MrRobot(0,0,"E",model);
		Sebastian.move();

		RobotLocalizationViewer viewer = new RobotLocalizationViewer(model);

		/*
		 * this thread controls the continuous update. If it is not started, 
		 * you can only click through your localisation stepwise
		 */
		new LocalizationDriver( 500, viewer).start();
	}
}	