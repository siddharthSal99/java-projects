import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/*Tharun Sankar, Alan Chai, $iddharth $alunkhe
 * March 2016
 * 
 * PrismComponent.java
 * 
 * Used to display a Prism on a JPanel or JFrame
 * Overrides the paintComponent method to draw a Prism
 * of set dimensions
 */
public class PrismComponent extends JComponent {
	private Prism prism;
	private Color color;
	
	/*
	 * Constructs a PrismComponent
	 * 
	 * Parameters:
	 * Prism prism = Prism to represent
	 * Color color = color of prism displayed
	 */
	public PrismComponent(Prism prism, Color color){
		this.prism = prism;
		this.color = color;
		
	}
	
	/*
	 * Paints PrismComponent on the frame
	 * 
	 * Parameters:
	 * Graphics g = Graphics object used to paint
	 */
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		//draw the line
		DrawPrism prism = new DrawPrism(this.prism,getHeight(), getWidth(),color);
		prism.draw(g2);
		
	}
	
	/*
	Sets the color of the PrismComponent
	parameters: Color color = the new color of the component
	
	returns: none
	*/
	public void setColor(Color color) {
		this.color = color;
		
	}
}
