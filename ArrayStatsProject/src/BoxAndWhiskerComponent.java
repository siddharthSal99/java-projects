
import java.awt.*;
import javax.swing.JComponent;
public class BoxAndWhiskerComponent extends JComponent {
	private double[] data;
	
	public BoxAndWhiskerComponent(double[] data){
		this.data = data;
	}
	public void paintComponent(Graphics g) {
		double width = getWidth();
		double height = getHeight();
		Graphics2D g2 = (Graphics2D) g;
		BoxAndWhiskerPlot boxPlot = new BoxAndWhiskerPlot(Statistics.min(data),Statistics.lowerQuartile(data),Statistics.median(data),Statistics.upperQuartile(data),Statistics.max(data),width,height);
		boxPlot.draw(g2);
		
	}


}
