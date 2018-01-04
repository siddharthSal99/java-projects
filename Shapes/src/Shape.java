/*
 * this abstract class serves as base class for different, more specific shape objects such as box, frame, and lines.
 * The only private data for the class is a paint character since all the methods will be implemented differently by the different sub classes
 * 
 */
public abstract class Shape {
	private char paintChar;
	/*
	 * although the class is abstract, the shape requires a paint character to be drawn on the screen
	 * 
	 * parameters: char paintChar
	 * returns: none
	 */
	public Shape(char paintChar){
		this.paintChar = paintChar;
	}
	/*
	 * this constructor sets the default paint char to an asterisk
	 * parameters: none
	 * returns: none
	 */
	public Shape(){
		this.paintChar = '*';
	}
	/*
	 * this method is abstract because it must be implemented by the subclasses since all shapes must be drawn
	 * It uses the specific instructions for drawing a shape to set a pixel on the screen to draw the full shape
	 * It draws the shape at the location specified by the x and y coordinate
	 * parameters: Screen screen, int X coordinate, int y coordinate
	 * returns: none
	 */
	public abstract void paintOn(Screen screen, int xCoord, int yCoord);
	/*
	 * this method is abstract because it must be implemented by the subclasses since all shapes must be drawn
	 * It uses the specific instructions for drawing a shape to set a pixel on the screen to draw the full shape
	 * It draws the shape at the default location(0,0)
	 * 
	 * parameters: Screen screen
	 * returns: none
	 */
	public abstract void paintOn(Screen screen);
	/*
	 * returns the paint character
	 * parameters: none
	 * returns: char paint character
	 */
	public char getPaintChar(){
		return paintChar;
	}
	/*
	 * sets the paint character
	 * parameters: char paint Character
	 * returns: none
	 */
	public void setPaintChar(char paintChar) {
		this.paintChar = paintChar;
	}
	
	
}