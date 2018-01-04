import java.awt.*;
import java.awt.geom.*;
public class BoxAndWhiskerPlot {
	private double max;
	private double min;
	private double median;
	private	double upperQ;
	private double lowerQ;
	private double width;
	private double height;
	
	public BoxAndWhiskerPlot(double min, double lowerQ, double median, double upperQ, double max, double width, double height){
		this.max = max;
		this.min = min;
		this.upperQ = upperQ;
		this.lowerQ = lowerQ;
		this.median = median;
		this.width = width;
		this.height = height;
	}
	public void draw(Graphics2D g2){
		double range  = max - min;

		Line2D.Double minSeg = new Line2D.Double(10,350,10,200);
		g2.draw(minSeg);
		Line2D.Double maxSeg = new Line2D.Double(width - 50, 350, width - 50, 200);
		g2.draw(maxSeg);
		Line2D.Double lowerQSeg = new Line2D.Double((Math.abs(lowerQ)/range) * (width - 60) , 350, (Math.abs(lowerQ)/range) * (width - 60), 200);
		g2.draw(lowerQSeg);
		Line2D.Double upperQSeg = new Line2D.Double((Math.abs(upperQ)/range) * (width - 60) , 350, (Math.abs(upperQ)/range) * (width - 60), 200);
		g2.draw(upperQSeg);
		Line2D.Double medianSeg = new Line2D.Double((Math.abs(median)/range) * (width - 60) , 350, (Math.abs(median)/range) * (width - 60), 200);
		g2.draw(medianSeg);
		Line2D.Double lowSmallConnect = new Line2D.Double(10,275 ,(Math.abs(lowerQ)/range) * (width - 60) , 275);
		g2.draw(lowSmallConnect);
		Line2D.Double highSmallConnect = new Line2D.Double(width - 50,275 ,(Math.abs(upperQ)/range) * (width - 60) , 275);
		g2.draw(highSmallConnect);
		Line2D.Double topLine = new Line2D.Double((Math.abs(lowerQ)/range) * (width - 60), 350, (Math.abs(upperQ)/range) * (width - 60), 350);
		g2.draw(topLine);
		Line2D.Double bottomLine = new Line2D.Double((Math.abs(lowerQ)/range) * (width - 60), 200, (Math.abs(upperQ)/range) * (width - 60), 200);
		g2.draw(bottomLine);
		g2.drawString("Min: "+ min, 20, 295);
		g2.drawString("Max: "+ max, (int)width - 70, 295);
		g2.drawString("Upper Quartile: "+ upperQ, (int)((Math.abs(upperQ)/range) * width) , 215);
		g2.drawString("Lower Quartile:"+ lowerQ,(int)((Math.abs(lowerQ)/range) * width), 215);
		g2.drawString("Median:"+ median, (int)((Math.abs(median)/range) * width) , 195);
	}
}
