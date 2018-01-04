import javax.swing.JFrame;
import java.awt.*;
public class StatisticsGraphics {
	public static void drawBox(double[] data){
		double[] statArray = new double[5];
		statArray[0] = Statistics.min(data);
		statArray[1] = Statistics.lowerQuartile(data);
		statArray[2] = Statistics.median(data);
		statArray[3] = Statistics.upperQuartile(data);
		statArray[4] = Statistics.max(data);
		JFrame boxFrame = new JFrame();
		boxFrame.setSize(5,5);
		boxFrame.setTitle("Box and Whisker Plot");
		boxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boxFrame.setVisible(true);

		BoxAndWhiskerComponent graph = new BoxAndWhiskerComponent(data);
		boxFrame.add(graph);
	}
}
