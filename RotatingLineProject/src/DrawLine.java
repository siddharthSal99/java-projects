import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;

/*Tharun Sankar, Alan Chai, $iddharth $alunkhe
 * March 2016
 * 
 * DrawLine.java
 * Contains the drawing instructions for drawing a line through the center of a JPanel or JFrame. 
 * Uses the line object to gain two points to draw the line through
 * 
 */
public class DrawLine {
	private int compHeight;
	private int compWidth;
	private Line line;
	private Color color;
	
	/*
	 * Constructs a DrawLine
	 * 
	 * Parameters:
	 * Line line = Line to display
	 * int height = height of LineComponent
	 * int width = width of LineComponent
	 * Color color = color of line
	 */
	public DrawLine(Line line, int height, int width, Color color){
		compHeight = height;
		compWidth = width;
		this.line = line;
		this.color = color;

	}
	
	/*
	 * Draws the line through the center of the panel
	 * 
	 * Parameters:
	 * Graphics2D g2 = Graphics2D object used to draw line
	 */
	public void draw(Graphics2D g2){
		int centerX = compWidth / 2;
		int centerY = compHeight / 2;
		g2.setColor(color);
		g2.setStroke( new BasicStroke(5f));
		Line2D.Double line1  = new Line2D.Double(centerX + line.convertToXCoord() , centerY + line.convertToYCoord(), 
												centerX-line.convertToXCoord(), centerY-line.convertToYCoord());
		
		g2.draw(line1);
	}
}
