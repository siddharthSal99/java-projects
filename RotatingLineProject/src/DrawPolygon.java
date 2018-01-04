import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/*Tharun Sankar, Alan Chai, $iddharth $alunkhe
 * March 2016
 * 
 * DrawPolygon.java
 * Contains the drawing instructions for drawing a polygon with a shared center with that of a JPanel or JFrame. 
 * Uses the polygon object to gain the points to draw the polygon by connecting the points 
 * 
 */
public class DrawPolygon  {
	private Polygon polygon;
	private int numSides;
	private int compHeight;
	private int compWidth;
	private Color color;
	
	/*
	 * Constructs a DrawPolygon
	 * 
	 * Parameters:
	 * Polygon polygon = Polygon to display
	 * int height = height of PolygonComponent
	 * int width = width of PolygonComponent
	 * Color color = color of Polygon
	 */
	public DrawPolygon(Polygon polygon, int height, int width,Color color){
		this.polygon = polygon;
		this.numSides = polygon.getNumSides();
		this.compHeight = height;
		this.compWidth = width;
		this.color = color;
	}
	
	/*
	 * Draws the polygon through the center of the panel
	 * 
	 * Parameters:
	 * Graphics2D g2 = Graphics2D object used to draw polygon
	 */
	public void draw(Graphics2D g2){
		int centerX = compWidth / 2;
		int centerY = compHeight / 2;
		g2.setColor(color);
		g2.setStroke( new BasicStroke(5f));
		double[][] coordinates = polygon.convertToCartesian();
		for(int i = 0; i < numSides - 1; i++){
			
			Line2D.Double line = new Line2D.Double(coordinates[i][0] + centerX, coordinates[i][1] + centerY, coordinates[i + 1][0] + centerX, coordinates[i + 1][1] + centerY);
			g2.draw(line);
		}
		Line2D.Double line2 = new Line2D.Double(coordinates[0][0] + centerX, coordinates[0][1] + centerY, coordinates[numSides - 1][0] + centerX, coordinates[numSides - 1][1] + centerY);
		g2.draw(line2);
	}
}
