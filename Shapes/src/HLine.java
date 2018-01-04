/*
 * HLine is a specific type of Line. It has a length, like all lines, but is only horizontally drawn
 * it can only be drawn on a screen object. Although the length can be greater than the screen, only the part that is on the screen is visible
 * the length can only be a positive integer or it will not work
 * 
 */
public class HLine extends Line{
	/*
	 * Builds an HLine from the length, and sets the border character to the '-'
	 * length should be a positive int
	 * parameters: int length
	 * returns: none
	 */
	public HLine(int length){
		super('-',length);
	}
	/*
	 * default constructor that sets the HLine length to zero and the paint character to 
	 * the asterisk
	 * parameters: none
	 * returns: none
	 */
	public HLine(){
		super();
	}
	/*
	 * implements the paintOn() abstract method from Shape which draws an HLine based on the length. 
	 *  It starts drawing the v line at the specified location and draws right
	 * 
	 * parameters: Screen screen, int x coordinate, int y coordinate
	 * returns: none
	 */
	public void paintOn(Screen screen, int xCoord, int yCoord) {
		for(int i = xCoord; i < (xCoord + getLength()); i++){
			screen.paintAt(i, yCoord,getPaintChar());
		}
	}
	/*
	 * implements the paintOn() abstract method from Shape and draws an HLine based on the length. 
	 *  It starts drawing the HLine at default (0,0) and draws right
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
		HLine hLine = new HLine(6);
		hLine.paintOn(screen);
		hLine.paintOn(screen, 5, 5);
		screen.draw();
		screen.clearScreen();

		HLine hLine2 = new HLine(0);
		hLine2.paintOn(screen);
		hLine2.paintOn(screen, 7, 7);
		screen.draw();
		screen.clearScreen();

		HLine hLine3 = new HLine(13);
		hLine3.paintOn(screen);
		hLine3.paintOn(screen, -5, 5);
		screen.draw();
		screen.clearScreen();

		HLine hLine4 = new HLine();
		hLine4.paintOn(screen);
		hLine4.paintOn(screen, 6, 6);
		screen.draw();
	}
}


