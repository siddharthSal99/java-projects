import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/*Tharun Sankar, Alan Chai, $iddharth $alunkhe
 * March 2016
 * 
 * PolygonComponent.java
 * 
 * Used to display a Polygon on a JPanel or JFrame
 * Overrides the paintComponent method to draw a Polygon
 * of set dimensions
 */
public class PolygonComponent extends JComponent {
	private Polygon polygon;
	private Color color;
	
	/*
	 * Constructs a PolygonComponent
	 * 
	 * Parameters:
	 * Polygon polygon = Polygon to represent
	 * Color color = color of the polygon displayed
	 */
	public PolygonComponent(Polygon polygon, Color color){
		this.polygon = polygon;
		this.color = color;	
	}
	
	/*
	 * Paints a PolygonComponent on a panel
	 * 
	 * Parameters:
	 * Graphics g = Graphics object used to represent the PolygonComponent
	 */
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		DrawPolygon polygon = new DrawPolygon(this.polygon,getHeight(), getWidth(),color);
		polygon.draw(g2);
		
	}
	
	/*
	 * Sets the color of the PolygonComponent
	 * 
	 * Parameters:
	 * Color color = color to be displayed
	 */
	public void setColor(Color color) {
		this.color = color;
		
	}
}
