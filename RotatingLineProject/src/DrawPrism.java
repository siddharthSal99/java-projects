import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/*Tharun Sankar, Alan Chai, $iddharth $alunkhe
 * March 2016
 * 
 * DrawPrism.java
 * Contains the drawing instructions for drawing a prism with a shared center with that of a JPanel or JFrame. 
 * Uses the prism object to gain the points to draw the prism and connecting the points. 
 * The faces of the prism are two polygons and the aligning vertices are connected to make a prism
 * 
 */
public class DrawPrism {
	private Prism prism;
	private int numSides;
	private int compHeight;
	private int compWidth;
	private Color color;
	
	/*
	 * Constructs a DrawPrism
	 * 
	 * Parameters:
	 * Prism prism = Prism to display
	 * int height = height of PrismComponent
	 * int width = width of PrismComponent
	 * Color color = color of Prism
	 */
	public DrawPrism(Prism prism, int height, int width,Color color){
		this.prism = prism;
		this.numSides = prism.getFaceSides();
		this.compHeight = height;
		this.compWidth = width;
		this.color = color;
	}
	
	/*
	 * Draws the prism through the center of the panel
	 * 
	 * Parameters:
	 * Graphics2D g2 = Graphics2D object used to draw prism
	 */
	public void draw(Graphics2D g2){
		int centerX = compWidth / 2;
		int centerY = compHeight / 2;
		g2.setColor(color);
		g2.setStroke( new BasicStroke(5f));
		double[][] coordinates = prism.convertToCartesian();
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
