import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class ThreeDPolygonComponent extends JComponent {
	private int frameHeight;
	private int frameWidth;
	private ThreeDPolygon polygon;
	private double length;
	private double angle;
	private Color color;
	
	public ThreeDPolygonComponent(int height, int width, ThreeDPolygon polygon, Color color){
		frameHeight = height;
		frameWidth = width;
		this.polygon = polygon;
		this.color = color;
		
	}

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		//draw the line
		DrawThreeDPolygon polygon = new DrawThreeDPolygon(this.polygon,getHeight(), getWidth(),color);
		polygon.draw(g2);
		
	}
	
	public void rotate(){
		polygon.rotate(0.01);
		repaint();
	}

	public void setColor(Color color) {
		this.color = color;
		
	}
}
