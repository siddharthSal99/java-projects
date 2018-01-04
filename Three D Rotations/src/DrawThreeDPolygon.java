import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class DrawThreeDPolygon {
	private ThreeDPolygon polygon;
	private int numSides;
	private int compHeight;
	private int compWidth;
	private Color color;

	public DrawThreeDPolygon(ThreeDPolygon polygon, int height, int width,Color color){
		this.polygon = polygon;
		this.numSides = polygon.getFaceSides();
		this.compHeight = height;
		this.compWidth = width;
		this.color = color;
	}
	public void draw(Graphics2D g2){
		//draw the line
		int centerX = compWidth / 2;
		int centerY = compHeight / 2;
		g2.setColor(color);
		g2.setStroke( new BasicStroke(5f));
		double[][] coordinates = polygon.convertToCartesian();
		for(int i = 0; i < numSides - 1; i++){

			Line2D.Double line = new Line2D.Double(coordinates[i][0] + centerX, coordinates[i][1] + centerY, coordinates[i + 1][0] + centerX, coordinates[i + 1][1] + centerY);
			g2.draw(line);
		}
		for(int i = numSides; i < 2 * numSides - 1; i++){

			Line2D.Double line = new Line2D.Double(coordinates[i][0] + centerX, coordinates[i][1] + centerY, coordinates[i + 1][0] + centerX, coordinates[i + 1][1] + centerY);
			g2.draw(line);
		}
		Line2D.Double line2 = new Line2D.Double(coordinates[0][0] + centerX, coordinates[0][1] + centerY, coordinates[numSides - 1][0] + centerX, coordinates[numSides - 1][1] + centerY);
		g2.draw(line2);
		Line2D.Double line3 = new Line2D.Double(coordinates[numSides][0] + centerX, coordinates[numSides][1] + centerY, coordinates[2 *numSides - 1][0] + centerX, coordinates[2 * numSides - 1][1] + centerY);
		g2.draw(line3);
		
		for(int i = 0; i < numSides; i++){
			Line2D.Double line = new Line2D.Double(coordinates[i][0] + centerX, coordinates[i][1] + centerY, coordinates[i + numSides][0] + centerX, coordinates[i + numSides][1] + centerY);
			g2.draw(line);
		}

		
	}
}
