/*
 * VLine is a specific type of Line. It has a length, like all lines, but is only vertically drawn
 * it can only be drawn on a screen object. Although the length can be greater than the screen, only the part that is on the screen is visible
 * 
 */
public class VLine extends Line{
	/*
	 * Builds an VLine from the length, and sets the border character to the default '*'
	 * parameters: int length
	 * returns: none
	 */
	public VLine(int length){
		super('|',length);
	}
	/*
	 * default constructor that sets the VLine length to zero and the paint character to 
	 * the asterisk
	 * parameters: none
	 * returns: none
	 */
	public VLine(){
		super();
	}
	/*
	 * implements the paintOn() abstract method from Shape which draws an VLine based on the length. 
	 *  It starts drawing the v line at the specified location and draws down
	 * 
	 * parameters: Screen screen, int x coordinate, int y coordinate
	 * returns: none
	 */
	public void paintOn(Screen screen, int xCoord, int yCoord) {
		for(int i = yCoord; i < (yCoord + getLength()); i++){
			screen.paintAt(xCoord, i, getPaintChar());
		}
	}
	/*
	 * implements the paintOn() abstract method from Shape and draws an VLine based on the length. 
	 *  It starts drawing the VLine at default (0,0) and draws down
	 * 
	 * parameters: Screen screen
	 * returns: none
	 */
	public void paintOn(Screen screen) {
		paintOn(screen,0,0);
	}
	/*
	 * main() tests a few cases of the object, as well as some of its methods. Most of the testing was done using the ShapeMenu and user input.
	 *  * parameters: String[] args
	 * returns: void
	 */
	public static void main(String[] args){
		Screen screen = new Screen(20,10);
		VLine vLine = new VLine(6);
		vLine.paintOn(screen);
		vLine.paintOn(screen, 5, 5);
		screen.draw();
		screen.clearScreen();

		VLine vLine2 = new VLine(0);
		vLine2.paintOn(screen);
		vLine2.paintOn(screen, 7, 7);
		screen.draw();
		screen.clearScreen();

		VLine vLine3 = new VLine(13);
		vLine3.paintOn(screen);
		vLine3.paintOn(screen, -5, 5);
		screen.draw();
		screen.clearScreen();

		VLine vLine4 = new VLine();
		vLine4.paintOn(screen);
		vLine4.paintOn(screen, 6, 6);
		screen.draw();
	}
}


