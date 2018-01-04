import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/*Tharun Sankar, Alan Chai, $iddharth $alunkhe
 * March 2016
 * 
 * LineComponent.java
 * 
 * Used to display a Line on a JPanel or JFrame
 * Overrides the paintComponent method to draw a Line
 * of set dimensions
 */
public class LineComponent extends JComponent {
	private Line line;
	private Color color;
	
	/*
	 * Constructs a LineComponent
	 * 
	 * Parameters:
	 * Line line = Line to represent
	 * Color color = color of the line displayed
	 */
	public LineComponent(Line line, Color color){
		this.line = line;
		this.color = color;
	}
	/*
	Sets the color of the LineComponent
	parameters: Color color = the new color of the component
	
	returns: none
	*/
    public void setColor(Color color)
   
    {
      this.color = color; 
    }
    
    /*
     * Paints the LineComponent onto a frame
     * 
     * Parameters:
     * Graphics g = Graphics object used to represent the component
     */
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		DrawLine line= new DrawLine(this.line,getHeight(), getWidth(),color);
		line.draw(g2);
		
	}
	
}
